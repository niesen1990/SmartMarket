package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexResponseModel;
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
 * 创建时间：16/5/4 下午6:37
 * 修改人：N.Sun
 * 修改时间：16/5/4 下午6:37
 * 修改备注：
 */
public class WalletActivity extends BaseActivity {

    private static final String TAG = WalletActivity.class.getSimpleName();

    @BindView(R.id.tv_finished_money)
    TextView tvFinishedMoney;
    @BindView(R.id.tv_prePayment)
    TextView tvPrePayment;
    @BindView(R.id.tv_detail)
    TextView tvDetail;
    @BindView(R.id.rl_pre_payment)
    RelativeLayout rlPrePayment;
    @BindView(R.id.rl_balance_out)
    RelativeLayout rlBalanceOut;
    @BindView(R.id.rl_deal_psw)
    RelativeLayout rlDealPsw;
    @BindView(R.id.rl_change_psw)
    RelativeLayout rlChangePsw;
    @BindView(R.id.rl_balance_account)
    RelativeLayout rlBalanceAccount;

    Observer<WalletAccountIndexResponseModel> mWalletAccountIndexResponseModelObserver = new Observer<WalletAccountIndexResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(WalletAccountIndexResponseModel walletAccountIndexResponseModel) {
            hideWaitingDialog();
            if (walletAccountIndexResponseModel == null)
                return;
            //更新UI
            tvFinishedMoney.setText("￥" + walletAccountIndexResponseModel.getData().getBalance());
            tvPrePayment.setText("￥" + walletAccountIndexResponseModel.getData().getPrePayment());
            if (walletAccountIndexResponseModel.getData().isHasPassword()) {
                rlDealPsw.setVisibility(View.GONE);
                SPCache.putBoolean(Constants.HAS_WALLET_PSW, true);
            } else {
                rlDealPsw.setVisibility(View.VISIBLE);
            }
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
        showWaitingDialog();
        subscription = HttpMethod.getInstance().walletAccountIndexRequest(mWalletAccountIndexResponseModelObserver, setIndexParams());
    }

    private WalletAccountIndexRequestModel setIndexParams() {
        WalletAccountIndexRequestModel walletAccountIndexRequestModel = new WalletAccountIndexRequestModel();
        walletAccountIndexRequestModel.setCmd(ApiInterface.WalletAccountIndex);
        walletAccountIndexRequestModel.setToken(BaseApplication.getToken());
        return walletAccountIndexRequestModel;
    }

    private void initView() {
        setTitle("我的钱包");
        tvDetail.setOnClickListener(this);
        rlPrePayment.setOnClickListener(this);
        rlBalanceOut.setOnClickListener(this);
        rlDealPsw.setOnClickListener(this);
        rlChangePsw.setOnClickListener(this);
        rlBalanceAccount.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_detail:
                BalanceDetailActivity.newIntent(this);
                break;
            case R.id.rl_pre_payment:
                break;
            case R.id.rl_balance_out:
                PickAccountActivity.newIntent(this, SPCache.getBoolean(Constants.HAS_WALLET_PSW, false), true);
                break;
            case R.id.rl_deal_psw:
                DealPswActivity.newIntent(this, "设置交易密码");
                break;
            case R.id.rl_change_psw:
                DealPswPhoneActivity.newIntent(this);
                break;
            case R.id.rl_balance_account:
                PickAccountActivity.newIntent(this, SPCache.getBoolean(Constants.HAS_WALLET_PSW, false), false);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me_wallet_layout;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, WalletActivity.class);
        context.startActivity(intent);
    }
}
