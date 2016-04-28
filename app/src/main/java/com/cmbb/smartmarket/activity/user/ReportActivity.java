package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/28 上午11:38
 */
public class ReportActivity extends BaseActivity {

    private TextView tvReason;
    private RadioGroup rgReason;
    private RadioButton rb01;
    private RadioButton rb02;
    private RadioButton rb03;
    private RadioButton rb004;
    private RadioButton rb05;
    private RelativeLayout rlReason;
    private TextView tvSubmit;
    private EditText etContent;

    protected void initView() {
        tvReason = (TextView) findViewById(R.id.tv_reason);
        rgReason = (RadioGroup) findViewById(R.id.rg_reason);
        rb01 = (RadioButton) findViewById(R.id.rb01);
        rb02 = (RadioButton) findViewById(R.id.rb02);
        rb03 = (RadioButton) findViewById(R.id.rb03);
        rb004 = (RadioButton) findViewById(R.id.rb004);
        rb05 = (RadioButton) findViewById(R.id.rb05);
        rlReason = (RelativeLayout) findViewById(R.id.rl_reason);
        tvSubmit = (TextView) findViewById(R.id.tv_submit);
        tvSubmit.setOnClickListener(this);
        etContent = (EditText) findViewById(R.id.et_content);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("举报");
        initView();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_report_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                // TODO: 16/4/28
                break;
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, ReportActivity.class);
        context.startActivity(intent);
    }
}
