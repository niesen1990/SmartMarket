package com.cmbb.smartmarket.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.PublishOperationActivity;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;

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

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initBottom();
//        initPublishFloatingButton();
    }

    /*protected void initPublishFloatingButton() {
        int redActionButtonSize = getResources().getDimensionPixelSize(R.dimen.publish_button_size);
        int redActionButtonMargin = getResources().getDimensionPixelSize(R.dimen.publish_button_margin);
        int redActionButtonContentSize = getResources().getDimensionPixelSize(R.dimen.publish_button_content_size);
        int redActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.publish_button_content_margin);
        int redActionMenuRadius = getResources().getDimensionPixelSize(R.dimen.publish_button_menu_radius);
        int blueSubActionButtonSize = getResources().getDimensionPixelSize(R.dimen.publish_button_sub_size);
        int blueSubActionButtonContentMargin = getResources().getDimensionPixelSize(R.dimen.publish_button_sub_margin);

        ImageView fabIconStar = new ImageView(this);

        FloatingActionButton.LayoutParams starParams = new FloatingActionButton.LayoutParams(redActionButtonSize, redActionButtonSize);
        starParams.setMargins(redActionButtonMargin, redActionButtonMargin, redActionButtonMargin, redActionButtonMargin);
        fabIconStar.setLayoutParams(starParams);

        FloatingActionButton.LayoutParams fabIconStarParams = new FloatingActionButton.LayoutParams(redActionButtonContentSize, redActionButtonContentSize);
        fabIconStarParams.setMargins(redActionButtonContentMargin, redActionButtonContentMargin, redActionButtonContentMargin, redActionButtonContentMargin);

        final FloatingActionButton BottomCenterButton = new FloatingActionButton.Builder(this)
                .setContentView(fabIconStar, fabIconStarParams)
                .setBackgroundDrawable(R.drawable.selector_home_publish)
                .setPosition(FloatingActionButton.POSITION_BOTTOM_CENTER)
                .setLayoutParams(starParams)
                .build();

        // Set up customized SubActionButtons for the right center menu
        SubActionButton.Builder lCSubBuilder = new SubActionButton.Builder(this);
        lCSubBuilder.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_white_circle));

        FrameLayout.LayoutParams blueContentParams = new FrameLayout.LayoutParams(FrameLayout.LayoutParams.MATCH_PARENT, FrameLayout.LayoutParams.MATCH_PARENT);
        blueContentParams.setMargins(blueSubActionButtonContentMargin, blueSubActionButtonContentMargin, blueSubActionButtonContentMargin, blueSubActionButtonContentMargin);
        lCSubBuilder.setLayoutParams(blueContentParams);
        // Set custom layout params
        FrameLayout.LayoutParams blueParams = new FrameLayout.LayoutParams(blueSubActionButtonSize, blueSubActionButtonSize);
        //blueParams.setMargins(blueSubActionButtonContentMargin, blueSubActionButtonContentMargin, blueSubActionButtonContentMargin, blueSubActionButtonContentMargin);
        lCSubBuilder.setLayoutParams(blueParams);

        ImageView lcIcon1 = new ImageView(this);
        ImageView lcIcon2 = new ImageView(this);
        lcIcon1.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_pager_red));
        lcIcon2.setImageDrawable(getResources().getDrawable(R.drawable.ic_home_message_red));

        // Build another menu with custom options
        final FloatingActionMenu BottomCenterMenu = new FloatingActionMenu.Builder(this)
                .addSubActionView(lCSubBuilder.setContentView(lcIcon1, blueContentParams).build())
                .addSubActionView(lCSubBuilder.setContentView(lcIcon2, blueContentParams).build())
                .setRadius(redActionMenuRadius)
                .setStartAngle(-60)
                .setEndAngle(-120)
                .attachTo(BottomCenterButton)
                .build();
        lcIcon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomCenterMenu.close(true);
                PublishActivity.newIntent(BaseHomeActivity.this, "求购", "1");

            }
        });
        lcIcon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BottomCenterMenu.close(true);
                PublishActivity.newIntent(BaseHomeActivity.this, "发布", "0");
            }
        });
    }*/

    protected void initBottom() {
        tvHome.setOnClickListener(this);
        tvShop.setOnClickListener(this);
        tvPublish.setOnClickListener(this);
        tvMessage.setOnClickListener(this);
        tvMe.setOnClickListener(this);
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
                PublishOperationActivity.newIntent(this);
                break;
            case R.id.tv_message:
                HomeMessageActivity.newIntent(this);
                break;
            case R.id.tv_me:
                HomeMeActivity.newIntent(this);
                break;
        }
    }
}
