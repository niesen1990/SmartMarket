package com.cmbb.smartmarket.im;

import android.app.Application;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;
import android.widget.Toast;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.IYWP2PPushListener;
import com.alibaba.mobileim.IYWTribePushListener;
import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWChannel;
import com.alibaba.mobileim.YWConstants;
import com.alibaba.mobileim.YWIMCore;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.LoginParam;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.channel.util.YWLog;
import com.alibaba.mobileim.contact.IYWContact;
import com.alibaba.mobileim.conversation.IYWConversationService;
import com.alibaba.mobileim.conversation.YWCustomMessageBody;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.gingko.model.tribe.YWTribe;
import com.alibaba.mobileim.gingko.model.tribe.YWTribeMember;
import com.alibaba.mobileim.login.IYWConnectionListener;
import com.alibaba.mobileim.login.YWLoginCode;
import com.alibaba.mobileim.login.YWLoginState;
import com.alibaba.mobileim.login.YWPwdType;
import com.alibaba.mobileim.ui.chat.widget.YWSmilyMgr;
import com.alibaba.mobileim.utility.IMAutoLoginInfoStoreUtil;
import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.im.commom.Notification;
import com.cmbb.smartmarket.im.custom.SmilyCustom;
import com.umeng.openim.OpenIMAgent;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * SDK 初始化和登录
 *
 * @author jing.huai
 */
public class IMLoginHelper {

    private static IMLoginHelper sInstance = new IMLoginHelper();

    public static IMLoginHelper getInstance() {
        return sInstance;
    }

    // 应用APPKEY，这个APPKEY是申请应用时获取的
    public static String APP_KEY;

    // openIM UI解决方案提供的相关API，创建成功后，保存为全局变量使用
    private YWIMKit mIMKit;

    private YWConnectionListenerImpl mYWConnectionListenerImpl = new YWConnectionListenerImpl();

    private List<Map<YWTribe, YWTribeMember>> mTribeInviteMessages = new ArrayList<Map<YWTribe, YWTribeMember>>();

    public YWIMKit getIMKit() {
        return mIMKit;
    }

    public void setIMKit(YWIMKit imkit) {
        mIMKit = imkit;
    }

    public void initIMKit(String userId, String appKey) {
        mIMKit = YWAPI.getIMKitInstance(userId, appKey);
        addConnectionListener();
        addPushMessageListener();
    }

    private YWLoginState mAutoLoginState = YWLoginState.idle;

    public YWLoginState getAutoLoginState() {
        return mAutoLoginState;
    }

    public void setAutoLoginState(YWLoginState state) {
        this.mAutoLoginState = state;
    }

    /**
     * 初始化SDK
     *
     * @param context Application
     */
    public void initSDK(Application context) {
        APP_KEY = OpenIMAgent.getInstance(context).getMessageBCAppkey();

        //初始化IMKit  通过SharePreference保持
        final String userId = IMAutoLoginInfoStoreUtil.getLoginUserId();
        final String appkey = IMAutoLoginInfoStoreUtil.getAppkey();

        if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(appkey)) {
            IMLoginHelper.getInstance().initIMKit(userId, appkey);
            NotificationInitHelper.init();
        }
        OpenIMAgent im = OpenIMAgent.getInstance(context);
        im.init();

        //通知栏相关的初始化
        NotificationInitHelper.init();
        initAutoLoginStateCallback();


        //添加自定义表情的初始化
        YWSmilyMgr.setSmilyInitNotify(new YWSmilyMgr.SmilyInitNotify() {
            @Override
            public void onDefaultSmilyInitOk() {
                SmilyCustom.addNewEmojiSmiley();
                SmilyCustom.addNewImageSmiley();

                //最后要清空通知，防止memory leak
                YWSmilyMgr.setSmilyInitNotify(null);
            }
        });

    }

    //将自动登录的状态广播出去
    private void sendAutoLoginState(YWLoginState loginState) {
        Intent intent = new Intent(Constants.AUTO_LOGIN_STATE_ACTION);
        intent.putExtra("state", loginState.getValue());
        LocalBroadcastManager.getInstance(YWChannel.getApplication()).sendBroadcast(intent);
    }

    /**
     * 登录操作
     *
     * @param userId   用户id
     * @param password 密码
     * @param callback 登录操作结果的回调
     */
    //------------------请特别注意，OpenIMSDK会自动对所有输入的用户ID转成小写处理-------------------
    //所以开发者在注册用户信息时，尽量用小写
    public void loginIM(String userId, String password, String appKey, IWxCallback callback) {
        if (mIMKit == null) {
            return;
        }

        YWLoginParam loginParam = YWLoginParam.createLoginParam(userId, password);
        if (TextUtils.isEmpty(appKey) || appKey.equals(YWConstants.YWSDKAppKey) || appKey.equals(YWConstants.YWSDKAppKeyCnHupan)) {
            loginParam.setServerType(LoginParam.ACCOUNTTYPE_WANGXIN);
            loginParam.setPwdType(YWPwdType.pwd);
        }
        // openIM SDK提供的登录服务
        IYWLoginService mLoginService = mIMKit.getLoginService();
        mLoginService.login(loginParam, callback);
    }

    //设置连接状态的监听
    private void addConnectionListener() {
        if (mIMKit == null) {
            return;
        }
        YWIMCore imCore = mIMKit.getIMCore();
        imCore.removeConnectionListener(mYWConnectionListenerImpl);
        imCore.addConnectionListener(mYWConnectionListenerImpl);
    }

    private class YWConnectionListenerImpl implements IYWConnectionListener {

        @Override
        public void onReConnecting() {
            YWLog.i("IMLoginHelper", "onReConnecting");
        }

        @Override
        public void onReConnected() {
            YWLog.i("IMLoginHelper", "onReConnected");
        }

        @Override
        public void onDisconnect(int arg0, String arg1) {
            if (arg0 == YWLoginCode.LOGON_FAIL_KICKOFF) {
                sendAutoLoginState(YWLoginState.disconnect);//自动登陆的广播
                //在其它终端登录，当前用户被踢下线
                IMLoginHelper.getInstance().setAutoLoginState(YWLoginState.disconnect);
                Toast.makeText(BaseApplication.getContext(), "您的账户在另外一处登陆", Toast.LENGTH_LONG).show();
                YWLog.i("LoginSampleHelper", "账户在另外一处登陆");
                //重新登陆
                Intent intent = new Intent(BaseApplication.getContext(), LoginActivity.class);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                BaseApplication.getContext().startActivity(intent);
            }
        }
    }

    /**
     * 添加新消息到达监听，该监听应该在登录之前调用以保证登录后可以及时收到消息
     */
    private void addPushMessageListener() {
        if (mIMKit == null) {
            return;
        }

        IYWConversationService conversationService = mIMKit.getConversationService();
        //添加单聊消息监听，先删除再添加，以免多次添加该监听
        conversationService.removeP2PPushListener(mP2PListener);
        conversationService.addP2PPushListener(mP2PListener);

        //添加群聊消息监听，先删除再添加，以免多次添加该监听
        conversationService.removeTribePushListener(mTribeListener);
        conversationService.addTribePushListener(mTribeListener);
    }

    /**
     * 接受单聊消息监听器
     */
    private IYWP2PPushListener mP2PListener = new IYWP2PPushListener() {
        @Override
        public void onPushMessage(IYWContact contact, YWMessage message) {

            if (message.getSubType() == YWMessage.SUB_MSG_TYPE.IM_P2P_CUS) {
                if (message.getMessageBody() instanceof YWCustomMessageBody) {
                    YWCustomMessageBody messageBody = (YWCustomMessageBody) message.getMessageBody();
                    if (messageBody.getTransparentFlag() == 1) {
                        String content = messageBody.getContent();
                        try {
                            JSONObject object = new JSONObject(content);
                            if (object.has("text")) {
                                String text = object.getString("text");
                                Notification.showToastMsgLong(BaseApplication.getContext(), "透传消息，content = " + text);
                            }
                        } catch (JSONException e) {

                        }
                    }
                }
            }
        }
    };

    /**
     * 群聊消息监听器
     */
    private IYWTribePushListener mTribeListener = new IYWTribePushListener() {
        @Override
        public void onPushMessage(YWTribe tribe, YWMessage message) {
            //TODO 收到群消息
        }
    };

    /**
     * 登出
     */
    public void loginOutIM() {
        if (mIMKit == null) {
            return;
        }

        // openIM SDK提供的登录服务
        IYWLoginService mLoginService = mIMKit.getLoginService();
        mLoginService.logout(new IWxCallback() {

            @Override
            public void onSuccess(Object... arg0) {
                YWLog.i("LoginSampleHelper", "登出成功");
            }

            @Override
            public void onProgress(int arg0) {
                YWLog.i("LoginSampleHelper", "登出ing");

            }

            @Override
            public void onError(int arg0, String arg1) {
                YWLog.i("LoginSampleHelper", "登出失败");

            }
        });
    }

    /**
     * 开发者不需要关注此方法，纯粹是DEMO自动登录的需要
     */
    private void initAutoLoginStateCallback() {
        YWChannel.setAutoLoginCallBack(new IWxCallback() {
            @Override
            public void onSuccess(Object... result) {
                mAutoLoginState = YWLoginState.success;
                sendAutoLoginState(mAutoLoginState);
            }

            @Override
            public void onError(int code, String info) {
                mAutoLoginState = YWLoginState.fail;
                sendAutoLoginState(mAutoLoginState);
            }

            @Override
            public void onProgress(int progress) {
                mAutoLoginState = YWLoginState.logining;
                sendAutoLoginState(mAutoLoginState);
            }
        });
    }

    public List<Map<YWTribe, YWTribeMember>> getTribeInviteMessages() {
        return mTribeInviteMessages;
    }
}
