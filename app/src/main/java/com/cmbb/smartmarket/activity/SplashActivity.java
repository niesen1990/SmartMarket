package com.cmbb.smartmarket.activity;

import android.os.Bundle;
import android.os.Handler;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.HomePagerActivity;
import com.cmbb.smartmarket.base.BaseActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午10:22
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void init(Bundle savedInstanceState) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HomePagerActivity.newIntent(SplashActivity.this);
                finish();
            }
        }, 500);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }
}
