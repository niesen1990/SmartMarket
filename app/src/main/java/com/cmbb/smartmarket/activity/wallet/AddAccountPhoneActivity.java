package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeRequestModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipayRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipayResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SPCache;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/5 下午3:14
 * 修改人：N.Sun
 * 修改时间：16/5/5 下午3:14
 * 修改备注：
 */
public class AddAccountPhoneActivity extends BaseActivity {

    private static final String TAG = AddAccountPhoneActivity.class.getSimpleName();
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_check)
    EditText etCheck;
    @BindView(R.id.tv_check)
    TextView tvCheck;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    //获取验证码
    Observer<SecurityCodeResponseModel> mSecurityCodeResponseModelObserver = new Observer<SecurityCodeResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(SecurityCodeResponseModel securityCodeResponseModel) {
            hideWaitingDialog();
            if (securityCodeResponseModel != null) {
                showToast(securityCodeResponseModel.getMsg());
            }
        }
    };

    Observer<WalletAccountBindalipayResponseModel> mWalletAccountBindalipayResponseModel = new Observer<WalletAccountBindalipayResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(WalletAccountBindalipayResponseModel walletAccountBindalipayResponseModel) {
            hideWaitingDialog();
            if (walletAccountBindalipayResponseModel != null) {
                showToast(walletAccountBindalipayResponseModel.getMsg());
                if (walletAccountBindalipayResponseModel.isData()) {
                    PickAccountActivity.newIntent(AddAccountPhoneActivity.this, SPCache.getBoolean(Constants.HAS_WALLET_PSW, false),false, "账号设置");
                    finish();
                } else {

                }
            }
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("认证支付宝账号");
        tvSubmit.setOnClickListener(this);
        tvCheck.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_account_phone_activity;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_check:
                if (!TextUtils.isEmpty(etPhone.getText().toString())) {
                    unSubscribe();
                    showWaitingDialog();
                    subscription = HttpMethod.getInstance().requestSecurityCode(mSecurityCodeResponseModelObserver, setCheckParams());
                } else {
                    showToast("请输入手机号码");
                }
                break;
            case R.id.tv_submit:
                if (!TextUtils.isEmpty(etCheck.getText().toString())) {
                    unSubscribe();
                    showWaitingDialog();
                    subscription = HttpMethod.getInstance().walletAccountBindalipay(mWalletAccountBindalipayResponseModel, setAlipayParams());
                } else {
                    showToast("请输入验证码");
                }
                break;
        }
    }

    private WalletAccountBindalipayRequestModel setAlipayParams() {
        WalletAccountBindalipayRequestModel walletAccountBindalipayRequestModel = new WalletAccountBindalipayRequestModel();
        walletAccountBindalipayRequestModel.setToken(BaseApplication.getToken());
        walletAccountBindalipayRequestModel.setCmd(ApiInterface.WalletAccountBindalipay);
        walletAccountBindalipayRequestModel.setParameters(new WalletAccountBindalipayRequestModel.ParametersEntity("支付宝",
                getIntent().getStringExtra("name"),
                getIntent().getStringExtra("account"),
                etCheck.getText().toString(),
                etPhone.getText().toString()));
        return walletAccountBindalipayRequestModel;
    }

    private SecurityCodeRequestModel setCheckParams() {
        SecurityCodeRequestModel securityCodeRequestModel = new SecurityCodeRequestModel();
        securityCodeRequestModel.setToken(BaseApplication.getToken());
        securityCodeRequestModel.setCmd(ApiInterface.SecurityCode);
        securityCodeRequestModel.setParameters(new SecurityCodeRequestModel.ParametersEntity(etPhone.getText().toString()));
        return securityCodeRequestModel;
    }

    public static void newIntent(Context context, String account, String name) {
        Intent intent = new Intent(context, AddAccountPhoneActivity.class);
        intent.putExtra("account", account);
        intent.putExtra("name", name);
        context.startActivity(intent);
    }
}
