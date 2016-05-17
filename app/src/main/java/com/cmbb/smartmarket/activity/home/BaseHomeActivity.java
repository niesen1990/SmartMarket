package com.cmbb.smartmarket.activity.home;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.PublishCommodityActivity;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:32
 */
public abstract class BaseHomeActivity extends BaseRecyclerActivity {

    @BindView(R.id.tv_home)
    TextView tvHome;
    @BindView(R.id.tv_shop)
    TextView tvShop;
    @BindView(R.id.tv_publish)
    TextView tvPublish;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.tv_me)
    TextView tvMe;

    @Override
    protected void init(Bundle savedInstanceState) {
        super.init(savedInstanceState);
        initBottom();
    }

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
                //                HomePublishActivity.newIntent(this);
                PublishCommodityActivity.newIntent(this);
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
