package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

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

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("认证支付宝账号");
        tvSubmit.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_account_phone_activity;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                WithdrawalsActivity.newIntent(this);
                break;
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, AddAccountPhoneActivity.class);
        context.startActivity(intent);
    }
}
