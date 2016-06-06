package com.cmbb.smartmarket.activity.message.im.custom;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.aop.Pointcut;
import com.alibaba.mobileim.aop.custom.IMChattingPageUI;
import com.alibaba.mobileim.contact.IYWContact;
import com.alibaba.mobileim.conversation.YWConversation;
import com.alibaba.mobileim.conversation.YWConversationType;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.conversation.YWP2PConversationBody;
import com.alibaba.mobileim.ui.WxChattingActvity;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;

/**
 * 聊天界面自带提供两种主题的自定义供用户方便的使用，用户可以通过｝中 实现 AdviceBinder.bindAdvice(PointCutEnum.CHATTING_FRAGMENT_UI_POINTCUT, ChattingUICustomSample.class);
 * 使用该主题的聊天界面自定义风格：文字和图片小猪气泡风格
 * <p>
 * todo 聊天界面的自定义风格1：文字和图片小猪气泡风格
 * Created by mayongge on 15-9-23.
 */
public class ChattingUICustom extends IMChattingPageUI {

    public ChattingUICustom(Pointcut pointcut) {
        super(pointcut);
    }


    @Override
    public boolean needRoundChattingImage() {
        return true;
    }

    /**
     * 设置聊天界面图片圆角的边角半径的长度(单位：dp)
     *
     * @return
     */
    @Override
    public float getRoundRadiusDps() {
        return 12.6f;
    }

    /**
     * 设置聊天窗口背景
     *
     * @return 聊天窗口背景，默认不显示
     */
    @Override
    public int getChattingBackgroundResId() {
        //聊天窗口背景，默认不显示
        return 0;
        // return R.drawable.demo_chatting_bg;
    }


    /**
     * 是否隐藏标题栏
     *
     * @param fragment
     * @param conversation
     * @return true: 隐藏标题栏  false：不隐藏标题栏
     */
    @Override
    public boolean needHideTitleView(Fragment fragment, YWConversation conversation) {
//        if (conversation.getConversationType() == YWConversationType.Tribe){
//            return true;
//        }
        //@消息功能需要展示标题栏，暂不隐藏
        return false;
    }

    /**
     * isv需要返回自定义的view. openIMSDK会回调这个方法，获取用户设置的view. Fragment 聊天界面的fragment
     */
    @Override
    public View getCustomTitleView(final Fragment fragment, final Context context, LayoutInflater inflater, final YWConversation conversation) {
        // 单聊和群聊都会使用这个方法，所以这里需要做一下区分

        //TODO 重要：必须以该形式初始化view---［inflate(R.layout.**, new RelativeLayout(context),false)］------，以让inflater知道父布局的类型，否则布局**中的高度和宽度无效，均变为wrap_content
        View view = inflater.inflate(R.layout.im_toolbar, new Toolbar(context), false);
        TextView textView = (TextView) view.findViewById(R.id.title);
        TextView back = (TextView) view.findViewById(R.id.back);
        String title = null;
        YWP2PConversationBody conversationBody = (YWP2PConversationBody) conversation.getConversationBody();
        if (!TextUtils.isEmpty(conversationBody.getContact().getShowName())) {
            title = conversationBody.getContact().getShowName();
        } else {
            YWIMKit imKit = IMHelper.getInstance().getIMKit();
            IYWContact contact = imKit.getContactService().getContactProfileInfo(conversationBody.getContact().getUserId(), conversationBody.getContact().getAppKey());
            //生成showName，According to id。
            if (contact != null && !TextUtils.isEmpty(contact.getShowName())) {
                title = contact.getShowName();
            }
        }
        //如果标题为空，那么直接使用Id
        if (TextUtils.isEmpty(title)) {
            title = conversationBody.getContact().getUserId();
        }
        textView.setText(title);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((WxChattingActvity)context).onBackPressed();
            }
        });
        return view;
    }


    /**
     * 定制图片预览页面titlebar右侧按钮点击事件
     *
     * @param fragment
     * @param message  当前显示的图片对应的ywmessage对象
     * @return true：使用用户定制的点击事件， false：使用默认的点击事件(默认点击事件为保持该图片到本地)
     */
    @Override
    public boolean onImagePreviewTitleButtonClick(Fragment fragment, YWMessage message) {
        Context context = fragment.getActivity();
        Toast.makeText(context, "你点击了该按钮~", Toast.LENGTH_SHORT).show();
        return false;
    }

    /**
     * 返回图片保存的目录
     *
     * @param fragment
     * @param message
     * @return 如果为null, 使用SDK默认的目录, 否则使用用户设置的目录
     */
    @Override
    public String getImageSavePath(Fragment fragment, YWMessage message) {
//        return Environment
//                .getExternalStorageDirectory().getAbsolutePath()
//                + "/alibaba/WXOPENI/云旺相册";
        return null;
    }

    /**
     * 返回单聊默认头像资源Id
     *
     * @return 0:使用SDK默认提供的
     */
    @Override
    public int getDefaultHeadImageResId() {
        return 0;
    }

    /**
     * 是否需要圆角矩形的头像
     *
     * @return true:需要圆角矩形
     * <br>
     * false:不需要圆角矩形，默认为圆形
     * <br>
     * 注：如果返回true，则需要使用{@link #getRoundRectRadius()}给出圆角的设置半径，否则无圆角效果
     */
    @Override
    public boolean isNeedRoundRectHead() {
        return false;
    }

    /**
     * 返回设置圆角矩形的圆角半径大小
     *
     * @return 0:如果{@link #isNeedRoundRectHead()}返回true，此处返回0则表示头像显示为直角正方形
     */
    @Override
    public int getRoundRectRadius() {
        return 0;
    }


    /**
     * 是否需要在聊天界面展示顶部自定义View
     *
     * @param fragment 聊天界面的Fragment
     * @param intent   打开聊天界面Activity的Intent
     * @return
     */
    @Override
    public boolean isUseChattingCustomViewAdvice(Fragment fragment, Intent intent) {
        if (intent != null && intent.hasExtra("extraTribeId") && intent.hasExtra("conversationType")) {
            long tribeId = intent.getLongExtra("extraTribeId", 0);
            int conversationType = intent.getIntExtra("conversationType", -1);
            if (tribeId > 0 && conversationType == YWConversationType.Tribe.getValue()) {
                return true;
            }
        }
        return false;
    }


    /**
     * getView方法内，返回View之前，对［聊天界面的右边消息item的View］做最后调整,如调整View的Padding。
     *
     * @param msg
     * @param rightItemParentView
     * @param fragment
     * @param conversation
     */
    @Override
    public void modifyRightItemParentViewAfterSetValue(YWMessage msg, RelativeLayout rightItemParentView, Fragment fragment, YWConversation conversation) {
//        if(msg!=null&&rightItemParentView!=null&&msg.getSubType()==YWMessage.SUB_MSG_TYPE.IM_IMAGE||msg.getSubType()==YWMessage.SUB_MSG_TYPE.IM_GIF){
//            rightItemParentView.setPadding(rightItemParentView.getPaddingLeft(), rightItemParentView.getPaddingTop(), 0, rightItemParentView.getPaddingBottom());
//        }
    }

    /**
     * getView方法内，返回View之前，对［聊天界面的左边消息item的View］做最后调整,如调整View的Padding。
     *
     * @param msg
     * @param leftItemParentView
     * @param fragment
     * @param conversation
     */
    @Override
    public void modifyLeftItemParentViewAfterSetValue(YWMessage msg, RelativeLayout leftItemParentView, Fragment fragment, YWConversation conversation) {

//        if(msg!=null&&leftItemParentView!=null&&msg.getSubType()==YWMessage.SUB_MSG_TYPE.IM_IMAGE||msg.getSubType()==YWMessage.SUB_MSG_TYPE.IM_GIF) {
//            leftItemParentView.setPadding(0, leftItemParentView.getPaddingTop(), leftItemParentView.getPaddingRight(), leftItemParentView.getPaddingBottom());
//        }
    }

    /**
     * 是否隐藏底部ChattingReplyBar
     *
     * @return
     */
    @Override
    public boolean needHideChattingReplyBar() {
        return false;
    }

    /**
     * 是否隐藏表情发送入口
     *
     * @return true:隐藏表情按钮
     * false:显示表情按钮
     */
    @Override
    public boolean needHideFaceView() {
        return false;
    }

    /**
     * 是否隐藏语音发送入口
     *
     * @return true:隐藏语音发送按钮
     * false:显示语音发送按钮
     */
    @Override
    public boolean needHideVoiceView() {
        return false;
    }

    /**
     * 返回自定义ChattingReplyBar高度(单位为dp)
     *
     * @return 如果返回值小于等于0, 则使用默认值
     */
    @Override
    public int getCustomChattingReplyBarHeight() {
        return 0;
    }

    /**
     * 返回自定义聊天输入框高度(单位为dp)
     *
     * @return 如果返回值小于等于0, 则使用默认值
     */
    @Override
    public int getCustomChattingInputEditTextHeight() {
        return 0;
    }

    /**
     * 返回自定义发送消息的文字颜资源Id
     *
     * @return 颜色资源Id
     */
    @Override
    public int getCustomRightTextColorId() {
        return 0;
    }

    /**
     * 返回自定义接收消息文字颜色资源Id
     *
     * @return 颜色资源Id
     */
    @Override
    public int getCustomLeftTextColorId() {
        return 0;
    }

    /**
     * 返回自定义的发送消息的超链接文字颜色的资源Id
     *
     * @return 颜色资源Id
     */
    @Override
    public int getCustomRightLinkTextColorId() {
        return 0;
    }

    /**
     * 返回自定义的接收消息超链接文字颜色的资源Id
     *
     * @return 颜色资源Id
     */
    @Override
    public int getCustomLeftLinkTextColorId() {
        return 0;
    }

    /**
     * 返回表情按钮图标背景资源Id
     *
     * @return
     */
    @Override
    public int getFaceViewBgResId() {
        return 0;
    }

    /**
     * 返回"+号"按钮选中图标背景资源Id
     *
     * @return
     */
    @Override
    public int getExpandViewCheckedBgResId() {
        return 0;
    }

    /**
     * 返回"+号"按钮取消选中图标背景资源Id
     *
     * @return
     */
    @Override
    public int getExpandViewUnCheckedBgResId() {
        return 0;
    }

    /**
     * 返回发送按钮背景资源Id
     *
     * @return
     */
    @Override
    public int getSendButtonBgId() {
        return 0;
    }

    /**
     * 返回语音按钮图标背景资源Id
     *
     * @return
     */
    @Override
    public int getVoiceViewBgResId() {
        return 0;
    }

    /**
     * 返回键盘按钮图标资源Id
     *
     * @return
     */
    @Override
    public int getKeyboardViewBgResId() {
        return 0;
    }
}
