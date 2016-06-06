package com.cmbb.smartmarket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.HomePagerActivity;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.log.Log;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午10:22
 */
public class SplashActivity extends BaseActivity {

    @Override
    protected void init(Bundle savedInstanceState) {
        PushAgent.getInstance(this).enable(mRegisterCallback);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HomePagerActivity.newIntent(SplashActivity.this);
                finish();
            }
        }, 500);
    }

    // 友盟推送注册器
    private IUmengRegisterCallback mRegisterCallback = new IUmengRegisterCallback() {
        @Override
        public void onRegistered(String registrationId) {
            Log.e("mRegisterCallback", "token:" + PushAgent.getInstance(SplashActivity.this).getRegistrationId());
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }


    public static void newIntent(Context context) {
        Intent intent = new Intent(context, SplashActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
