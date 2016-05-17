package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
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

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle(getIntent().getStringExtra("title"));
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
