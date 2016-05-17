package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;

import butterknife.BindView;

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

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("提现");
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
                showBottomSheet(tvSubmit);
                break;
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, WithdrawalsActivity.class);
        context.startActivity(intent);
    }
}
