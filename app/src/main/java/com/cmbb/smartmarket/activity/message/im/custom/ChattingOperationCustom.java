package com.cmbb.smartmarket.activity.message.im.custom;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.view.View;

import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.aop.Pointcut;
import com.alibaba.mobileim.aop.custom.IMChattingPageOperateion;
import com.alibaba.mobileim.aop.model.ReplyBarItem;
import com.alibaba.mobileim.aop.model.YWChattingPlugin;
import com.alibaba.mobileim.conversation.YWConversation;
import com.alibaba.mobileim.conversation.YWConversationType;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.conversation.YWMessageChannel;
import com.alibaba.mobileim.fundamental.widget.WxAlertDialog;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 聊天界面(单聊和群聊界面)的定制点(根据需要实现相应的接口来达到自定义聊天界面)，不设置则使用openIM默认的实现
 * 1.CustomChattingTitleAdvice 自定义聊天窗口标题 2. OnUrlClickChattingAdvice 自定义聊天窗口中
 * 当消息是url是点击的回调。用于isv处理url的打开处理。不处理则用第三方浏览器打开 如果需要定制更多功能，需要实现更多开放的接口
 * 需要.继承BaseAdvice .实现相应的接口
 * <p/>
 * 另外需要在Application中绑定
 * AdviceBinder.bindAdvice(PointCutEnum.CHATTING_FRAGMENT_POINTCUT,
 * ChattingOperationCustomSample.class);
 *
 * @author jing.huai
 */
public class ChattingOperationCustom extends IMChattingPageOperateion {

    private static final String TAG = "ChattingOperationCustomSample";

    YWIMKit mIMKit = IMHelper.getInstance().getIMKit();

    public class CustomMessageType {
        private static final String GREETING = "Greeting";
        private static final String CARD = "CallingCard";
        private static final String IMAGE = "PrivateImage";
        public static final String READ_STATUS = "PrivateImageRecvRead";
    }

    // 默认写法
    public ChattingOperationCustom(Pointcut pointcut) {
        super(pointcut);
    }

    /**
     * 单聊ui界面，点击url的事件拦截 返回true;表示自定义处理，返回false，由默认处理
     *
     * @param fragment 可以通过 fragment.getActivity拿到Context
     * @param message  点击的url所属的message
     * @param url      点击的url
     */
    @Override
    public boolean onUrlClick(Fragment fragment, YWMessage message, String url, YWConversation conversation) {
       /* Notification.showToastMsgLong(fragment.getActivity(), "用户点击了url:" + url);
        if (!url.startsWith("http")) {
            url = "http://" + url;
        }
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        fragment.startActivity(intent);*/

        return false;
    }

    /**
     * 是否显示默认的Item，照片，相册
     *
     * @param conversation
     * @return
     */
    @Override
    public boolean showDefaultBarItems(YWConversation conversation) {
        return true;//显示
    }



    /**
     * 定制点击消息事件, 每一条消息的点击事件都会回调该方法，开发者根据消息类型，对不同类型的消息设置不同的点击事件
     *
     * @param fragment 聊天窗口fragment对象
     * @param message  被点击的消息
     * @return true:使用用户自定义的消息点击事件，false：使用默认的消息点击事件
     */
    @Override
    public boolean onMessageClick(final Fragment fragment, final YWMessage message) {
        return false;
    }

    /**
     * 定制长按消息事件，每一条消息的长按事件都会回调该方法，开发者根据消息类型，对不同类型的消息设置不同的长按事件
     *
     * @param fragment 聊天窗口fragment对象
     * @param message  被点击的消息
     * @return true:使用用户自定义的长按消息事件，false：使用默认的长按消息事件
     */
    @Override
    public boolean onMessageLongClick(final Fragment fragment, final YWMessage message) {

        return false;
    }

    @Override
    public int getFastReplyResId(YWConversation conversation) {
        return R.drawable.aliwx_reply_bar_face_bg;
    }

    @Override
    public boolean onFastReplyClick(Fragment pointcut, YWConversation ywConversation) {
        return false;
    }

    @Override
    public int getRecordResId(YWConversation conversation) {
        return 0;
    }

    @Override
    public boolean onRecordItemClick(Fragment pointcut, YWConversation ywConversation) {
        return false;
    }

    /**
     * 开发者可以根据用户操作设置该值
     */
    private static boolean mUserInCallMode = false;

    /**
     * 是否使用听筒模式播放语音消息
     *
     * @param fragment
     * @param message
     * @return true：使用听筒模式， false：使用扬声器模式
     */
    @Override
    public boolean useInCallMode(Fragment fragment, YWMessage message) {
        return mUserInCallMode;
    }

    /**
     * 当打开聊天窗口时，自动发送该字符串给对方
     *
     * @param fragment     聊天窗口fragment
     * @param conversation 当前会话
     * @return 自动发送的内容（注意，内容empty则不自动发送）
     */
    @Override
    public String messageToSendWhenOpenChatting(Fragment fragment, YWConversation conversation) {
        //p2p、客服和店铺会话处理，否则不处理，
        int mCvsType = conversation.getConversationType().getValue();
        if (mCvsType == YWConversationType.P2P.getValue() || mCvsType == YWConversationType.SHOP.getValue()) {
            //            return "你好";
            return null;
        } else {
            return null;
        }

    }

    /**
     * 当打开聊天窗口时，自动发送该消息给对方
     *
     * @param fragment                   聊天窗口fragment
     * @param conversation               当前会话
     * @param isConversationFirstCreated 是否是首次创建会话
     * @return 自动发送的消息（注意，内容empty则不自动发送）
     */
    @Override
    public YWMessage ywMessageToSendWhenOpenChatting(Fragment fragment, YWConversation conversation, boolean isConversationFirstCreated) {
        //        YWMessageBody messageBody = new YWMessageBody();
        //        messageBody.setSummary("WithoutHead");
        //        messageBody.setContent("hi，我是单聊自定义消息之好友名片");
        //        YWMessage message = YWMessageChannel.createCustomMessage(messageBody);
        //        return message;

        //与客服的会话
        if (conversation.getConversationId().contains("openim官方客服")) {
            //首次进入会话
            //            if(isConversationFirstCreated){

            final SharedPreferences defalultSprefs = fragment.getActivity().getSharedPreferences(
                    "ywPrefsTools", Context.MODE_PRIVATE);

            long lastSendTime = defalultSprefs.getLong("lastSendTime_" + conversation.getConversationId(), -1);
            //24小时后再次发送本地隐藏消息
            if (System.currentTimeMillis() - lastSendTime > 24 * 60 * 60 * 1000) {

                YWMessage textMessage = YWMessageChannel.createTextMessage("你好");
                //添加发送的消息不显示在对方界面上的本地标记（todo 仅支持本地隐藏。当用户切换手机或清楚数据后，会漫游消息下这些消息并出现在用户的聊天界面上！！）
                textMessage.setLocallyHideMessage(true);

                //保存发送时间戳
                SharedPreferences.Editor edit = defalultSprefs.edit();
                edit.putLong("lastSendTime_" + conversation.getConversationId(), System.currentTimeMillis());
                edit.commit();

                return textMessage;
            }

            //            }

        }
        //返回null,则不发送
        return null;

    }

    /*****************
     * 以下是定制自定义消息view的示例代码
     ****************/

    //自定义消息view的种类数
    private final int typeCount = 4;

    /**
     * 自定义viewType，viewType的值必须从0开始，然后依次+1递增，且viewType的个数必须等于typeCount，切记切记！！！
     ***/
    //地理位置消息
    private final int type_0 = 0;

    //群自定义消息(Say-Hi消息)
    private final int type_1 = 1;

    //单聊自定义消息(名片消息)
    private final int type_2 = 2;

    //单聊阅后即焚消息
    private final int type_3 = 3;

    /**
     * 自定义消息view的种类数
     *
     * @return 自定义消息view的种类数
     */
    @Override
    public int getCustomViewTypeCount() {
        return typeCount;
    }

    /**
     * 自定义消息view的类型，开发者可以根据自己的需求定制多种自定义消息view，这里需要根据消息返回view的类型
     *
     * @param message 需要自定义显示的消息
     * @return 自定义消息view的类型
     */
    @Override
    public int getCustomViewType(YWMessage message) {
        if (message.getSubType() == YWMessage.SUB_MSG_TYPE.IM_GEO) {
            return type_0;
        } else if (message.getSubType() == YWMessage.SUB_MSG_TYPE.IM_P2P_CUS || message.getSubType() == YWMessage.SUB_MSG_TYPE.IM_TRIBE_CUS) {
            String msgType = null;
            try {
                String content = message.getMessageBody().getContent();
                JSONObject object = new JSONObject(content);
                msgType = object.getString("customizeMessageType");
            } catch (Exception e) {

            }
            if (!TextUtils.isEmpty(msgType)) {
                if (msgType.equals(CustomMessageType.GREETING)) {
                    return type_1;
                } else if (msgType.equals(CustomMessageType.CARD)) {
                    return type_2;
                } else if (msgType.equals(CustomMessageType.IMAGE)) {
                    return type_3;
                }
            }
        }
        return super.getCustomViewType(message);
    }

    /**
     * 是否需要隐藏头像
     *
     * @param viewType 自定义view类型
     * @return true: 隐藏头像  false：不隐藏头像
     */
    @Override
    public boolean needHideHead(int viewType) {
        if (viewType == type_2) {
            return true;
        }
        return super.needHideHead(viewType);
    }

    /**
     * 是否需要隐藏显示名
     *
     * @param viewType 自定义view类型
     * @return true: 隐藏显示名  false：不隐藏显示名
     */
    @Override
    public boolean needHideName(int viewType) {
        if (viewType == type_2) {
            return true;
        }
        return super.needHideName(viewType);
    }

    /**************** 以上是定制自定义消息view的示例代码 ****************/

    /**
     * 双击放大文字消息的开关
     *
     * @param fragment
     * @return true:开启双击放大文字 false: 关闭双击放大文字
     */
    @Override
    public boolean enableDoubleClickEnlargeMessageText(Fragment fragment) {
        return true;
    }

    /**
     * 数字字符串点击事件,开发者可以根据自己的需求定制
     *
     * @param activity
     * @param clickString 被点击的数字string
     * @param widget      被点击的TextView
     * @return false:不处理
     * true:需要开发者在return前添加自己实现的响应逻辑代码
     */
    @Override
    public boolean onNumberClick(final Activity activity, final String clickString, final View widget) {
        ArrayList<String> menuList = new ArrayList<String>();
        menuList.add("呼叫");
        menuList.add("添加到手机通讯录");
        menuList.add("复制到剪贴板");
        final String[] items = new String[menuList.size()];
        menuList.toArray(items);
        Dialog alertDialog = new WxAlertDialog.Builder(activity)
                .setItems(items, new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog,
                                        int which) {
                        if (TextUtils.equals(items[which], "呼叫")) {
                            Intent intent = new Intent(Intent.ACTION_DIAL);
                            intent.setData(Uri.parse("tel:" + clickString));
                            activity.startActivity(intent);
                        } else if (TextUtils.equals(items[which], "添加到手机通讯录")) {
                            Intent intent = new Intent(Intent.ACTION_INSERT_OR_EDIT);
                            intent.setType("vnd.android.cursor.item/person");
                            intent.setType("vnd.android.cursor.item/contact");
                            intent.setType("vnd.android.cursor.item/raw_contact");
                            intent.putExtra(android.provider.ContactsContract.Intents.Insert.PHONE, clickString);
                            activity.startActivity(intent);

                        } else if (TextUtils.equals(items[which], "复制到剪贴板")) {
                            ClipboardManager clipboardManager = (ClipboardManager) activity.getSystemService(Context.CLIPBOARD_SERVICE);
                            clipboardManager.setText(clickString);
                        }
                    }
                }).create();
        alertDialog.setCanceledOnTouchOutside(true);
        alertDialog.setCancelable(true);
        alertDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                widget.invalidate();
            }
        });
        if (!alertDialog.isShowing()) {
            alertDialog.show();
        }
        return true;
    }

    //TODO 不要使用60000之前的值，防止和SDK中使用的产生冲突
    private static final int CAMERA_WITH_DATA = 60001;
    private static final int PHOTO_PICKED_WITH_DATA = 60002;
    public static final int IMAGE_CAMERA_WITH_DATA = 60003;
    private static final int IMAGE_PHOTO_PICKED_WITH_DATA = 60004;

    /**
     * 请注意不要和内部的ID重合
     * {@link YWChattingPlugin.ReplyBarItem#ID_CAMERA}
     * {@link YWChattingPlugin.ReplyBarItem#ID_ALBUM}
     * {@link YWChattingPlugin.ReplyBarItem#ID_SHORT_VIDEO}
     */
    private static int ITEM_ID_1 = 0x1;
    private static int ITEM_ID_2 = 0x2;
    private static int ITEM_ID_3 = 0X3;

    /**
     * 用于增加聊天窗口 下方回复栏的操作区的item
     * <p/>
     * ReplyBarItem
     * itemId:唯一标识 建议从1开始
     * ItemImageRes：显示的图片
     * ItemLabel：文字
     * needHide:是否隐藏 默认: false ,  显示：false ， 隐藏：true
     * OnClickListener: 自定义点击事件, null则使用默认的点击事件
     * 参照示例返回List<ReplyBarItem>用于操作区显示item列表，可以自定义顺序和添加item
     *
     * @param pointcut         聊天窗口fragment
     * @param conversation     当前会话，通过conversation.getConversationType() 区分个人单聊，与群聊天
     * @param replyBarItemList 默认的replyBarItemList，如拍照、选择照片、短视频等
     * @return
     */
    @Override
    public List<ReplyBarItem> getCustomReplyBarItemList(final Fragment pointcut, final YWConversation conversation, List<ReplyBarItem> replyBarItemList) {
        List<ReplyBarItem> replyBarItems = new ArrayList<ReplyBarItem>();
        for (ReplyBarItem replyBarItem : replyBarItemList) {
            if (replyBarItem.getItemId() == YWChattingPlugin.ReplyBarItem.ID_CAMERA) {
                //是否隐藏ReplyBarItem中的拍照选项
                replyBarItem.setNeedHide(false);
                //不自定义ReplyBarItem中的拍照的点击事件,设置OnClicklistener(null);
                replyBarItem.setOnClicklistener(null);
                //自定义ReplyBarItem中的拍照的点击事件,设置OnClicklistener
                //                开发者在自己实现拍照逻辑时，可以在{@link #onActivityResult(int, int, Intent, List<YWMessage>)}中处理拍照完成后的操作
                //                replyBarItem.setOnClicklistener(new View.OnClickListener() {
                //                    @Override
                //                    public void onClick(View v) {
                //
                //                    }
                //                });
            } else if (replyBarItem.getItemId() == YWChattingPlugin.ReplyBarItem.ID_ALBUM) {
                //是否隐藏ReplyBarItem中的选择照片选项
                replyBarItem.setNeedHide(false);
                //不自定义ReplyBarItem中的相册的点击事件,设置OnClicklistener（null）
                replyBarItem.setOnClicklistener(null);
                //自定义ReplyBarItem中的相册的点击事件,设置OnClicklistener
                //                replyBarItem.setOnClicklistener(new View.OnClickListener() {
                //                    @Override
                //                    public void onClick(View v) {
                //                        Notification.showToastMsgLong(pointcut.getActivity(), "用户点击了选择照片");
                //                    }
                //                });
            } else if (replyBarItem.getItemId() == YWChattingPlugin.ReplyBarItem.ID_SHORT_VIDEO) {
                //检查是否集成了短视频SDK
                if (!haveShortVideoLibrary()) {
                    //是否隐藏ReplyBarItem中的短视频选项
                    replyBarItem.setNeedHide(true);
                }
            }
            replyBarItems.add(replyBarItem);
        }
        return replyBarItems;

    }

    private static YWConversation mConversation;

    /**
     * 如果开发者选择自己实现拍照或者选择照片的流程，则可以在该方法中实现照片(图片)的发送操作
     *
     * @param requestCode
     * @param resultCode
     * @param data
     * @param messageList 开发者构造图片消息并赋值给message参数，sdk会把该消息发送出去
     * @return 开发者在自己实现拍照处理或者选择照片时，一定要return true
     */
    public boolean onActivityResult(int requestCode, int resultCode, Intent data, List<YWMessage> messageList) {

        return false;
    }

    private static boolean compiledShortVideoLibrary = false;
    private static boolean haveCheckedShortVideoLibrary = false;

    /**
     * 检查是否集成了集成了短视频的SDK
     *
     * @return
     */
    private boolean haveShortVideoLibrary() {
        if (!haveCheckedShortVideoLibrary) {
            try {
                Class.forName("com.im.IMRecordVideoActivity");
                compiledShortVideoLibrary = true;
                haveCheckedShortVideoLibrary = true;
            } catch (ClassNotFoundException e) {
                compiledShortVideoLibrary = false;
                haveCheckedShortVideoLibrary = true;
                e.printStackTrace();
            }
        }
        return compiledShortVideoLibrary;

    }

    /**
     * 自定义时间文案
     *
     * @param fragment     聊天窗口fragment
     * @param conversation 当前聊天窗口对应的会话
     * @param time         默认时间文案
     * @return 如果是NULL，则不显示，如果是空字符串，则使用SDK默认的文案，如果返回非空串，则使用用户自定义的
     */
    @Override
    public String getCustomTimeString(Fragment fragment, YWConversation conversation, String time) {
        return "";
    }

    /**
     * 自定义系统消息文案
     *
     * @param fragment     聊天窗口fragment
     * @param conversation 当前聊天窗口对应的会话
     * @param content      默认系统消息文案
     * @return 如果是NULL，则不显示，如果是空字符串，则使用SDK默认的文案，如果返回非空串，则使用用户自定义的
     */
    @Override
    public String getSystemMessageContent(Fragment fragment, YWConversation conversation, String content) {
        return "";
    }
}