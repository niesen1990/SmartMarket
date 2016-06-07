package com.cmbb.smartmarket.activity.message.im;

import android.app.Application;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.text.TextUtils;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.IYWP2PPushListener;
import com.alibaba.mobileim.YWAPI;
import com.alibaba.mobileim.YWChannel;
import com.alibaba.mobileim.YWIMCore;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.YWLoginParam;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.contact.IYWContact;
import com.alibaba.mobileim.conversation.IYWConversationService;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.login.IYWConnectionListener;
import com.alibaba.mobileim.login.YWLoginCode;
import com.alibaba.mobileim.login.YWLoginState;
import com.alibaba.mobileim.utility.IMAutoLoginInfoStoreUtil;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.Logout;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/29 下午2:03
 */
public class IMHelper {
    private static final java.lang.String TAG = IMHelper.class.getSimpleName();
    private static IMHelper ourInstance = new IMHelper();

    public static IMHelper getInstance() {
        return ourInstance;
    }

    //读取登录成功后保存的用户名和密码
    //    String im_userId = IMPrefsTools.getStringPrefs(LoginActivity.this, Constants.IM_USER_ID, "");
    //    String im_userPassword = IMPrefsTools.getStringPrefs(LoginActivity.this, Constants.IM_USER_PASSWORD, "");

    private IMHelper() {
    }

    /**
     * IM app_key
     */
    private static String APP_KEY = "23369408";
    private YWIMKit mIMKit;
    private YWLoginState autoLoginState = YWLoginState.idle;//登陆状态
    private YWConnectionListenerImpl mYWConnectionListenerImpl = new YWConnectionListenerImpl();

    public static String getAppKey() {
        return APP_KEY;
    }

    public static void setAppKey(String appKey) {
        IMHelper.APP_KEY = appKey;
    }

    public YWIMKit getIMKit() {
        return mIMKit;
    }

    public void setIMKit(YWIMKit mIMKit) {
        this.mIMKit = mIMKit;
    }

    public YWLoginState getAutoLoginState() {
        return autoLoginState;
    }

    public void setAutoLoginState(YWLoginState autoLoginState) {
        this.autoLoginState = autoLoginState;
    }

    public void initSdk(Application context) {
        //初始化IMKit
        final String userId = IMAutoLoginInfoStoreUtil.getLoginUserId();
        if (!TextUtils.isEmpty(userId) && !TextUtils.isEmpty(APP_KEY)) {
            initIMKit(userId, APP_KEY);
        }
        YWAPI.init(context, APP_KEY);
    }

    public void loginIM(String userId, String password, IWxCallback callback) {
        if (mIMKit == null)
            return;
        YWLoginParam loginParam = YWLoginParam.createLoginParam(userId, password);
        // openIM SDK提供的登录服务
        IYWLoginService mLoginService = mIMKit.getLoginService();
        mLoginService.login(loginParam, callback);
    }

    public void logoutIM(IWxCallback callback) {
        if (mIMKit == null)
            return;
        // openIM SDK提供的登录服务
        IYWLoginService mLoginService = mIMKit.getLoginService();
        mLoginService.logout(callback);
    }

    /**
     * 初始化IMKit 组建
     *
     * @param userId
     * @param appKey
     */
    public void initIMKit(String userId, String appKey) {
        mIMKit = YWAPI.getIMKitInstance(userId, appKey);
        if (mIMKit == null)
            return;
        YWIMCore imCore = mIMKit.getIMCore();
        imCore.removeConnectionListener(mYWConnectionListenerImpl);
        imCore.addConnectionListener(mYWConnectionListenerImpl);
        IYWConversationService conversationService = mIMKit.getConversationService();
        //添加单聊消息监听，先删除再添加，以免多次添加该监听
        conversationService.removeP2PPushListener(mP2PListener);
        conversationService.addP2PPushListener(mP2PListener);
    }

    private class YWConnectionListenerImpl implements IYWConnectionListener {

        @Override
        public void onReConnecting() {
            Log.i("IMHelper", "onReConnecting");
        }

        @Override
        public void onReConnected() {
            Log.i("IMHelper", "onReConnected");
        }

        @Override
        public void onDisconnect(int arg0, String arg1) {
            if (arg0 == YWLoginCode.LOGON_FAIL_KICKOFF) {
                sendAutoLoginState(YWLoginState.disconnect);
                //在其它终端登录，当前用户被踢下线 重新登陆
                IMHelper.getInstance().setAutoLoginState(YWLoginState.disconnect);
                Logout.logout(BaseApplication.getContext());
            }
        }
    }

    private IYWP2PPushListener mP2PListener = new IYWP2PPushListener() {
        @Override
        public void onPushMessage(IYWContact contact, YWMessage message) {
            Log.i(TAG, "P2P 消息接受监听器   " + message.getMessageBody().getContent());
        }
    };

    //将自动登录的状态广播出去
    private void sendAutoLoginState(YWLoginState loginState) {
        Intent intent = new Intent(Constants.AUTO_LOGIN_STATE_ACTION);
        intent.putExtra("state", loginState.getValue());
        LocalBroadcastManager.getInstance(YWChannel.getApplication()).sendBroadcast(intent);
    }

}
