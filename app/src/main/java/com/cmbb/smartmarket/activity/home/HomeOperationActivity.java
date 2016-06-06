package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.PublishActivity;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.utils.TDevice;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/5 下午3:27
 * 修改人：N.Sun
 * 修改时间：16/6/5 下午3:27
 * 修改备注：
 */
public class HomeOperationActivity extends BaseActivity {

    private static final String TAG = HomeOperationActivity.class.getSimpleName();
    @BindView(R.id.tv_need)
    TextView tvNeed;
    @BindView(R.id.tv_publish)
    TextView tvPublish;
    @BindView(R.id.iv_close)
    ImageView ivClose;
    @BindView(R.id.base)
    RelativeLayout base;

    TranslateAnimation tvNeedOpen;
    TranslateAnimation tvNeedClose;

    TranslateAnimation tvPublishOpen;
    TranslateAnimation tvPublishClose;

    RotateAnimation animationOpen;
    RotateAnimation animationClose;

    int leftX;
    int leftY;

    @Override
    protected void init(Bundle savedInstanceState) {
        leftX = TDevice.dip2px(60, this);
        leftY = TDevice.dip2px(80, this);
        base.setOnClickListener(this);
        tvNeed.setOnClickListener(this);
        tvPublish.setOnClickListener(this);
        tvNeedOpen = new TranslateAnimation(tvNeed.getLeft(), tvNeed.getLeft() + leftX, tvNeed.getRight(), tvNeed.getRight() - leftY);
        tvNeedOpen.setDuration(200);
        tvNeedOpen.setFillAfter(true);
        tvNeedOpen.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tvNeed.clearAnimation();
                tvNeed.layout(tvNeed.getLeft() + leftX, tvNeed.getTop() - leftY, tvNeed.getRight() + leftX, tvNeed.getBottom() - leftY);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tvNeed.setAnimation(tvNeedOpen);
        tvNeedOpen.startNow();

        tvNeedClose = new TranslateAnimation(tvNeed.getLeft(), tvNeed.getLeft() - leftX, tvNeed.getRight(), tvNeed.getRight() + leftY);
        tvNeedClose.setDuration(150);
        tvNeedClose.setFillAfter(true);

        tvPublishOpen = new TranslateAnimation(tvPublish.getLeft(), tvPublish.getLeft() - leftX, tvPublish.getRight(), tvPublish.getRight() - leftY);
        tvPublishOpen.setDuration(200);
        tvPublishOpen.setFillAfter(true);
        tvPublishOpen.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                tvPublish.clearAnimation();
                tvPublish.layout(tvPublish.getLeft() - leftX, tvPublish.getTop() - leftY, tvPublish.getRight() - leftX, tvPublish.getBottom() - leftY);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        tvPublish.setAnimation(tvPublishOpen);
        tvPublishOpen.startNow();

        tvPublishClose = new TranslateAnimation(tvPublish.getLeft(), tvPublish.getLeft() + leftX, tvPublish.getRight(), tvPublish.getRight() + leftY);
        tvPublishClose.setDuration(200);
        tvPublishClose.setFillAfter(true);

        animationOpen = new RotateAnimation(0f, 45f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animationOpen.setDuration(120);//设置动画持续时间
        animationOpen.setFillAfter(true);
        ivClose.setAnimation(animationOpen);
        animationOpen.startNow();

        animationClose = new RotateAnimation(45f, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animationClose.setDuration(200);//设置动画持续时间
        animationClose.setFillAfter(true);

    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        tvNeed.clearAnimation();
        tvNeed.setAnimation(tvNeedClose);
        tvNeedClose.startNow();

        tvPublish.clearAnimation();
        tvPublish.setAnimation(tvPublishClose);
        tvPublishClose.startNow();

        ivClose.clearAnimation();
        animationClose.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
        ivClose.setAnimation(animationClose);
        animationClose.startNow();
        switch (v.getId()) {
            case R.id.iv_close:
                break;
            case R.id.tv_publish:
                PublishActivity.newIntent(this, "发布", "0");
                break;
            case R.id.tv_need:
                PublishActivity.newIntent(this, "求购", "1");
                break;
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_operation_layout;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeOperationActivity.class);
        context.startActivity(intent);
    }
}
