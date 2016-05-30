package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindListResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountGetCashRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountGetCashResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
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
 * 创建时间：16/5/6 上午10:19
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午10:19
 * 修改备注：
 */
public class WithdrawalsActivity extends BaseAccountActivity {

    private static final String TAG = WithdrawalsActivity.class.getSimpleName();

    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.et_money)
    EditText etMoney;
    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.ll03)
    LinearLayout ll03;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    WalletAccountBindListResponseModel.DataEntity walletEntity;
    Observer<WalletAccountGetCashResponseModel> mWalletAccountGetCashResponseModelObserver = new Observer<WalletAccountGetCashResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(WalletAccountGetCashResponseModel walletAccountGetCashResponseModel) {

        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("提现");
        setNeedValPsw(false);
        etMoney.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                int posDot = temp.indexOf(".");
                if (posDot <= 0)
                    return;
                if (temp.length() - posDot - 1 > 2) {
                    edt.delete(posDot + 3, posDot + 4);
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
        walletEntity = getIntent().getParcelableExtra("data");
        tvAccount.setText(walletEntity.getCardCode());
        tvName.setText(walletEntity.getCardUsername());
        tvSubmit.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_withdrawals_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etMoney.getText().toString())) {
                    showToast("请输入提现金额");
                    return;
                }
                showBottomSheet();
                break;
        }
    }

    @Override
    protected void pswOnConfirm(String psw) {
        subscription = HttpMethod.getInstance().walletAccountGetCashRequest(mWalletAccountGetCashResponseModelObserver, setCashParams(psw));

    }

    @Override
    protected Observer<WalletAccountValiatePayPasswordResponseModel> getPswValiate() {
        return new Observer<WalletAccountValiatePayPasswordResponseModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.toString());
                hideWaitingDialog();
            }

            @Override
            public void onNext(WalletAccountValiatePayPasswordResponseModel walletAccountValiatePayPasswordResponseModel) {
                hideWaitingDialog();
                if (walletAccountValiatePayPasswordResponseModel != null) {
                    showToast(walletAccountValiatePayPasswordResponseModel.getMsg());
                    if (walletAccountValiatePayPasswordResponseModel.isData()) {
                        //密码验证成功
                    }
                }
            }
        };
    }

    private WalletAccountGetCashRequestModel setCashParams(String psw) {
        WalletAccountGetCashRequestModel walletAccountGetCashRequestModel = new WalletAccountGetCashRequestModel();
        walletAccountGetCashRequestModel.setToken(BaseApplication.getToken());
        walletAccountGetCashRequestModel.setCmd(ApiInterface.WalletAccountGetCash);
        walletAccountGetCashRequestModel.setParameters(new WalletAccountGetCashRequestModel.ParametersEntity(Double.parseDouble(etMoney.getText().toString()), "支付宝", walletEntity.getCardUsername(), walletEntity.getCardCode(), walletEntity.getPhone(), psw));
        return walletAccountGetCashRequestModel;
    }

    public static void newIntent(Context context, WalletAccountBindListResponseModel.DataEntity dataEntity) {
        Intent intent = new Intent(context, WithdrawalsActivity.class);
        intent.putExtra("data", dataEntity);
        context.startActivity(intent);
    }
}
