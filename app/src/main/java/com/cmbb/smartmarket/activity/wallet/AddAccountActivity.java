package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
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
public class AddAccountActivity extends BaseActivity {

    @BindView(R.id.tv_tag)
    TextView tvTag;
    @BindView(R.id.et_account)
    EditText etAccount;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.tv_next)
    TextView tvNext;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("认证支付宝账号");
        tvNext.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_next:
                if (TextUtils.isEmpty(etAccount.getText().toString())) {
                    showToast("请输入支付宝账号");
                    return;
                }
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    showToast("请输入真实姓名");
                    return;
                }
                AddAccountPhoneActivity.newIntent(this, etAccount.getText().toString(), etName.getText().toString());
                finish();
                break;
        }

    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_account_activity;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, AddAccountActivity.class);
        context.startActivity(intent);
    }
}
