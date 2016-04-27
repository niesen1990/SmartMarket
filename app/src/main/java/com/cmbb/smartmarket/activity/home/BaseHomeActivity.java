package com.cmbb.smartmarket.activity.home;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:32
 */
public abstract class BaseHomeActivity extends BaseRecyclerActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initBottom();
    }

    protected void initBottom() {
        findViewById(R.id.tv_home).setOnClickListener(this);
        findViewById(R.id.tv_shop).setOnClickListener(this);
        findViewById(R.id.tv_publish).setOnClickListener(this);
        findViewById(R.id.tv_message).setOnClickListener(this);
        findViewById(R.id.tv_me).setOnClickListener(this);
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
                HomePublishActivity.newIntent(this);
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
