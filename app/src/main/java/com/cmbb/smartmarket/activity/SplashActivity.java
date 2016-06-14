package com.cmbb.smartmarket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.HomePagerActivity;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SPCache;
import com.umeng.message.IUmengRegisterCallback;
import com.umeng.message.PushAgent;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午10:22
 */
public class SplashActivity extends BaseActivity {

    Observer<WalletAccountIndexResponseModel> mWalletAccountIndexResponseModelObserver = new Observer<WalletAccountIndexResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
        }

        @Override
        public void onNext(WalletAccountIndexResponseModel walletAccountIndexResponseModel) {
            if (walletAccountIndexResponseModel == null)
                return;
            if (walletAccountIndexResponseModel.getData().isHasPassword()) {
                SPCache.putBoolean(Constants.HAS_WALLET_PSW, true);
            } else {
                SPCache.putBoolean(Constants.HAS_WALLET_PSW, false);
            }
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        PushAgent.getInstance(this).enable(mRegisterCallback);
        if (!TextUtils.isEmpty(BaseApplication.getToken()))
            HttpMethod.getInstance().walletAccountIndexRequest(mWalletAccountIndexResponseModelObserver, setIndexParams());
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                HomePagerActivity.newIntent(SplashActivity.this);
                finish();
            }
        }, 500);
    }

    private WalletAccountIndexRequestModel setIndexParams() {
        WalletAccountIndexRequestModel walletAccountIndexRequestModel = new WalletAccountIndexRequestModel();
        walletAccountIndexRequestModel.setCmd(ApiInterface.WalletAccountIndex);
        walletAccountIndexRequestModel.setToken(BaseApplication.getToken());
        return walletAccountIndexRequestModel;
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
