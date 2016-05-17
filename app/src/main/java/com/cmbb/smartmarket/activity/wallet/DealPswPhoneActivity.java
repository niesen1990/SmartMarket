package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

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

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("修改密码");
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
                DealPswActivity.newIntent(this, "修改交易密码");
                break;
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, DealPswPhoneActivity.class);
        context.startActivity(intent);
    }
}
