package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeRequestModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午11:00
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午11:00
 * 修改备注：
 */
public class DealPswPhoneActivity extends BaseActivity {

    private static final String TAG = DealPswPhoneActivity.class.getSimpleName();

    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.et_check)
    EditText etCheck;
    @BindView(R.id.tv_check)
    TextView tvCheck;
    @BindView(R.id.tv_next)
    TextView tvNext;

    Observer<WalletAccountSetPasswordResponseModel> mWalletAccountSetPasswordResponseModelObserver = new Observer<WalletAccountSetPasswordResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(WalletAccountSetPasswordResponseModel walletAccountSetPasswordResponseModel) {
            hideWaitingDialog();
            if (walletAccountSetPasswordResponseModel == null)
                return;
            showToast(walletAccountSetPasswordResponseModel.getMsg());
            finish();
        }
    };

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

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("修改密码");
        tvCheck.setOnClickListener(this);
        tvNext.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detal_psw_check_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_next:
                if (!TextUtils.isEmpty(etPhone.getText().toString()) && !TextUtils.isEmpty(etCheck.getText().toString())) {
                    unSubscribe();
                    showWaitingDialog();
                    subscription = HttpMethod.getInstance().walletAccountSetPasswordRequest(mWalletAccountSetPasswordResponseModelObserver, setParams());
                }
                break;
            case R.id.tv_check:
                if (!TextUtils.isEmpty(etPhone.getText().toString())) {
                    unSubscribe();
                    showWaitingDialog();
                    subscription = HttpMethod.getInstance().requestSecurityCode(mSecurityCodeResponseModelObserver, setCheckParams());
                }
                break;

        }
    }

    private SecurityCodeRequestModel setCheckParams() {
        SecurityCodeRequestModel securityCodeRequestModel = new SecurityCodeRequestModel();
        securityCodeRequestModel.setToken(BaseApplication.getToken());
        securityCodeRequestModel.setCmd(ApiInterface.SecurityCode);
        securityCodeRequestModel.setParameters(new SecurityCodeRequestModel.ParametersEntity(etPhone.getText().toString()));
        return securityCodeRequestModel;
    }

    private WalletAccountSetPasswordRequestModel setParams() {
        WalletAccountSetPasswordRequestModel walletAccountSetPasswordRequestModel = new WalletAccountSetPasswordRequestModel();
        walletAccountSetPasswordRequestModel.setCmd(ApiInterface.WalletAccountSetPassword);
        walletAccountSetPasswordRequestModel.setToken(BaseApplication.getToken());
//        walletAccountSetPasswordRequestModel.setParameters(new WalletAccountSetPasswordRequestModel.ParametersEntity(etPsw.getText().toString(), etPswConfirm.getText().toString()));
        return walletAccountSetPasswordRequestModel;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, DealPswPhoneActivity.class);
        context.startActivity(intent);
    }
}
