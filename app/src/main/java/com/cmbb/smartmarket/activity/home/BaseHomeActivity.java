package com.cmbb.smartmarket.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.mobileim.conversation.IYWConversationService;
import com.alibaba.mobileim.conversation.IYWConversationUnreadChangeListener;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.base.Constants;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:32
 */
public abstract class BaseHomeActivity extends BaseRecyclerActivity {

    private static final java.lang.String TAG = BaseHomeActivity.class.getSimpleName();
    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.tv_publish)
    ImageView tvPublish;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_me)
    TextView tvMe;
    @BindView(R.id.tv_message_count)
    TextView tvMessageCount;

    protected IYWConversationUnreadChangeListener mConversationUnreadChangeListener;
    protected IYWConversationService mConversationService;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    AnimationSet animationSet;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initBottom();
        initListener();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (animationSet != null)
            tvPublish.startAnimation(animationSet);
        if (mConversationUnreadChangeListener == null || mConversationService == null)
            return;

        //resume时需要检查全局未读消息数并做处理，因为离开此界面时删除了全局消息监听器
        mConversationUnreadChangeListener.onUnreadChange();
        //在Tab栏增加会话未读消息变化的全局监听器
        mConversationService.addTotalUnreadChangeListener(mConversationUnreadChangeListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (animationSet != null)
            tvPublish.clearAnimation();
        if (mConversationUnreadChangeListener == null || mConversationService == null)
            return;
        //在Tab栏删除会话未读消息变化的全局监听器
        mConversationService.removeTotalUnreadChangeListener(mConversationUnreadChangeListener);
    }

    protected void initBottom() {
        tvHome.setOnClickListener(this);
        tvShop.setOnClickListener(this);
        tvPublish.setOnClickListener(this);

        tvMessage.setOnClickListener(this);
        tvMe.setOnClickListener(this);

        animationSet = new AnimationSet(false);
        //--------------------1----------
        ScaleAnimation scaleAnimation1 = new ScaleAnimation(1.0f, 1.1f, 1.0f, 1.1f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation1.setStartOffset(1500);
        scaleAnimation1.setDuration(1000);
        scaleAnimation1.setFillAfter(false);
        scaleAnimation1.setRepeatCount(10000);
        scaleAnimation1.setRepeatMode(Animation.INFINITE);

        AlphaAnimation alphaAnimation1 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation1.setStartOffset(1500);
        alphaAnimation1.setFillAfter(false);
        alphaAnimation1.setRepeatCount(Animation.INFINITE);
        alphaAnimation1.setRepeatMode(Animation.RESTART);
        alphaAnimation1.setDuration(2000);
        //--------------------1----------

        //--------------------2----------
        ScaleAnimation scaleAnimation2 = new ScaleAnimation(1.0f, 1.2f, 1.0f, 1.2f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation2.setStartOffset(1000);
        scaleAnimation2.setFillAfter(false);
        scaleAnimation2.setDuration(2000);
        scaleAnimation2.setRepeatCount(10000);
        scaleAnimation2.setRepeatMode(Animation.INFINITE);

        AlphaAnimation alphaAnimation2 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation2.setFillAfter(false);
        alphaAnimation2.setStartOffset(1000);
        alphaAnimation2.setRepeatCount(Animation.INFINITE);
        alphaAnimation2.setRepeatMode(Animation.RESTART);
        alphaAnimation2.setDuration(2000);
        //--------------------2----------

        //--------------------3----------
        ScaleAnimation scaleAnimation3 = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation3.setFillAfter(false);
//        scaleAnimation3.setStartOffset(500);
        scaleAnimation3.setRepeatCount(Animation.INFINITE);
        scaleAnimation3.setRepeatMode(Animation.RESTART);
        scaleAnimation3.setDuration(2000);

        AlphaAnimation alphaAnimation3 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation3.setFillAfter(false);
//        alphaAnimation3.setStartOffset(500);
        alphaAnimation3.setRepeatCount(Animation.INFINITE);
        alphaAnimation3.setRepeatMode(Animation.RESTART);
        alphaAnimation3.setDuration(2000);

        //--------------------3----------

        //--------------------4----------
        ScaleAnimation scaleAnimation4 = new ScaleAnimation(1.0f, 1.4f, 1.0f, 1.4f,
                Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation4.setFillAfter(false);
        scaleAnimation4.setRepeatCount(Animation.INFINITE);
        scaleAnimation4.setRepeatMode(Animation.RESTART);
        scaleAnimation4.setDuration(2000);

        AlphaAnimation alphaAnimation4 = new AlphaAnimation(1.0f, 0.2f);
        alphaAnimation4.setFillAfter(false);
        alphaAnimation4.setRepeatCount(Animation.INFINITE);
        alphaAnimation4.setRepeatMode(Animation.RESTART);
        alphaAnimation4.setDuration(2000);
        //--------------------4----------

       /* animationSet.addAnimation(scaleAnimation1);
        animationSet.addAnimation(alphaAnimation1);

        animationSet.addAnimation(scaleAnimation2);
        animationSet.addAnimation(alphaAnimation2);*/

//                animationSet.addAnimation(scaleAnimation3);
//                animationSet.addAnimation(alphaAnimation3);
        animationSet.addAnimation(scaleAnimation4);
        animationSet.addAnimation(alphaAnimation4);

    }

    private void initListener() {
        if (IMHelper.getInstance().getIMKit() == null)
            return;
        mConversationService = IMHelper.getInstance().getIMKit().getConversationService();
        //初始化并添加会话变更监听
        mConversationUnreadChangeListener = new IYWConversationUnreadChangeListener() {
            //当未读数发生变化时会回调该方法，开发者可以在该方法中更新未读数
            @Override
            public void onUnreadChange() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //获取当前登录用户的所有未读数
                        int unReadCount = mConversationService.getAllUnreadCount();
                        updateMessage(unReadCount);
                    }
                });
            }
        };
    }

    public void updateMessage(int unReadCount) {
        if (unReadCount > 0) {
            tvMessageCount.setVisibility(View.VISIBLE);
            if (unReadCount < 100) {
                tvMessageCount.setText(unReadCount + "");
            } else {
                tvMessageCount.setText("99+");
            }
        } else {
            tvMessageCount.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_home:
                HomePagerActivity.newIntent(this);
                break;
            case R.id.tv_shop:
                HomeShopActivity.newIntent(this);
                break;
            case R.id.tv_publish:
                HomeOperationActivity.newIntent(this);
                break;
            case R.id.tv_message:
                HomeMessageActivity.newIntent(this);
                break;
            case R.id.tv_me:
                HomeMeActivity.newIntent(this);
                break;
        }
    }

    private Boolean isQuit = false;// 退出应用标识符
    private Timer timer = new Timer();// 程序退出定时器

    @Override
    public void onBackPressed() {
        if (!isQuit) {
            isQuit = true;
            showToast("您确定要退出吗？");
            TimerTask task = new TimerTask() {
                @Override
                public void run() {
                    isQuit = false;
                }
            };
            timer.schedule(task, 2000);
        } else {
            Intent intent = new Intent(Constants.INTENT_ACTION_EXIT_APP);
            sendBroadcast(intent);
        }
    }
}
