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
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordResponseModel;
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
 * 创建时间：16/5/6 上午11:00
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午11:00
 * 修改备注：
 */
public class DealPswActivity extends BaseActivity {

    private static final String TAG = DealPswActivity.class.getSimpleName();

    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.et_psw)
    EditText etPsw;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.et_psw_confirm)
    EditText etPswConfirm;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

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
            SPCache.putBoolean(Constants.HAS_WALLET_PSW, true);
            finish();
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle(getIntent().getStringExtra("title"));
        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                unSubscribe();
                if (TextUtils.isEmpty(etPsw.getText().toString())) {
                    showToast("请设置密码");
                    return;
                }
                if (TextUtils.isEmpty(etPswConfirm.getText().toString())) {
                    showToast("请设置确认密码");
                    return;
                }
                subscription = HttpMethod.getInstance().walletAccountSetPasswordRequest(mWalletAccountSetPasswordResponseModelObserver, setParams());
                break;
        }
    }

    private WalletAccountSetPasswordRequestModel setParams() {
        WalletAccountSetPasswordRequestModel walletAccountSetPasswordRequestModel = new WalletAccountSetPasswordRequestModel();
        walletAccountSetPasswordRequestModel.setCmd(ApiInterface.WalletAccountSetPassword);
        walletAccountSetPasswordRequestModel.setToken(BaseApplication.getToken());
        walletAccountSetPasswordRequestModel.setParameters(new WalletAccountSetPasswordRequestModel.ParametersEntity(etPsw.getText().toString(), etPswConfirm.getText().toString()));
        return walletAccountSetPasswordRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detal_psw_layout;
    }

    public static void newIntent(Context context, String title) {
        Intent intent = new Intent(context, DealPswActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }
}
