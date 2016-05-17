package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

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

    @BindView(R.id.tv_finished_money)
    TextView tvFinishedMoney;
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

    @Override
    protected void init(Bundle savedInstanceState) {
        initView();
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
                PickAccountActivity.newIntent(this);
                break;
            case R.id.rl_deal_psw:
                DealPswActivity.newIntent(this, "设置交易密码");
                break;
            case R.id.rl_change_psw:
                DealPswPhoneActivity.newIntent(this);
                break;
            case R.id.rl_balance_account:
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
