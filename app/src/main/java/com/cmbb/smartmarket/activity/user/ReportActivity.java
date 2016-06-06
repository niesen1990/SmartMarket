package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
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
 * 创建时间：16/4/28 上午11:38
 */
public class ReportActivity extends BaseActivity {

    private static final String TAG = ReportActivity.class.getSimpleName();

    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.rg_reason)
    RadioGroup rgReason;
    @BindView(R.id.rb01)
    RadioButton rb01;
    @BindView(R.id.rb02)
    RadioButton rb02;
    @BindView(R.id.rb03)
    RadioButton rb03;
    @BindView(R.id.rb04)
    RadioButton rb04;
    @BindView(R.id.rl_reason)
    RelativeLayout rlReason;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    SystemTipoffsGetPageResponseModel mSystemTipoffsGetPageResponseModel;
    int checked;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("举报");
        showWaitingDialog();
        tvSubmit.setOnClickListener(this);
        rgReason.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rb01:
                        checked = 0;
                        break;
                    case R.id.rb02:
                        checked = 1;
                        break;
                    case R.id.rb03:
                        checked = 2;
                        break;
                    case R.id.rb04:
                        checked = 3;
                        break;
                }
            }
        });
        HttpMethod.getInstance().requestSystemTipoffsGetPage(new Observer<SystemTipoffsGetPageResponseModel>() {
            @Override
            public void onCompleted() {
                hideWaitingDialog();
            }

            @Override
            public void onError(Throwable e) {
                hideWaitingDialog();
                Log.e(TAG, e.toString());
            }

            @Override
            public void onNext(SystemTipoffsGetPageResponseModel systemTipoffsGetPageResponseModel) {
                if (systemTipoffsGetPageResponseModel == null)
                    return;
                mSystemTipoffsGetPageResponseModel = systemTipoffsGetPageResponseModel;
                rb01.setText(systemTipoffsGetPageResponseModel.getData().get(0).getName());
                rb02.setText(systemTipoffsGetPageResponseModel.getData().get(1).getName());
                rb03.setText(systemTipoffsGetPageResponseModel.getData().get(2).getName());
                rb04.setText(systemTipoffsGetPageResponseModel.getData().get(3).getName());

            }
        }, setCodeParams());
    }

    private SystemTipoffsGetPageRequestModel setCodeParams() {
        SystemTipoffsGetPageRequestModel systemTipoffsGetPageRequestModel = new SystemTipoffsGetPageRequestModel();
        systemTipoffsGetPageRequestModel.setCmd(ApiInterface.SystemTipoffsGetPage);
        systemTipoffsGetPageRequestModel.setToken(BaseApplication.getToken());
        return systemTipoffsGetPageRequestModel;
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
                switch (checked) {
                    case 3:
                        if (TextUtils.isEmpty(etContent.getText().toString())) {
                            showToast("请输入举报内容");
                            return;
                        }
                }
                showWaitingDialog();
                HttpMethod.getInstance().systemTipoffsReportRequest(new Observer<SystemTipoffsReportResponseModel>() {
                    @Override
                    public void onCompleted() {
                        hideWaitingDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        hideWaitingDialog();
                        Log.e(TAG, e.toString());
                    }

                    @Override
                    public void onNext(SystemTipoffsReportResponseModel systemTipoffsReportResponseModel) {
                        if (systemTipoffsReportResponseModel == null)
                            return;
                        showToast(systemTipoffsReportResponseModel.getMsg());
                        finish();
                    }
                }, setReportParams());
                break;
        }
    }

    private SystemTipoffsReportRequestModel setReportParams() {
        SystemTipoffsReportRequestModel systemTipoffsReportRequestModel = new SystemTipoffsReportRequestModel();
        systemTipoffsReportRequestModel.setCmd(ApiInterface.SystemTipoffsReport);
        systemTipoffsReportRequestModel.setToken(BaseApplication.getToken());
        switch (checked) {
            case 0:
                systemTipoffsReportRequestModel.setParameters(new SystemTipoffsReportRequestModel.ParametersEntity(mSystemTipoffsGetPageResponseModel.getData().get(0).getValue(), getIntent().getIntExtra("id", -1)));
                break;
            case 1:
                systemTipoffsReportRequestModel.setParameters(new SystemTipoffsReportRequestModel.ParametersEntity(mSystemTipoffsGetPageResponseModel.getData().get(1).getValue(), getIntent().getIntExtra("id", -1)));
                break;
            case 2:
                systemTipoffsReportRequestModel.setParameters(new SystemTipoffsReportRequestModel.ParametersEntity(mSystemTipoffsGetPageResponseModel.getData().get(2).getValue(), getIntent().getIntExtra("id", -1)));
                break;
            case 3:
                if (TextUtils.isEmpty(etContent.getText().toString())) {
                    showToast("请输入举报内容");
                }
                systemTipoffsReportRequestModel.setParameters(new SystemTipoffsReportRequestModel.ParametersEntity(mSystemTipoffsGetPageResponseModel.getData().get(2).getValue(), getIntent().getIntExtra("id", -1), etContent.getText().toString()));
                break;
        }
        return systemTipoffsReportRequestModel;
    }

    public static void newIntent(Context context, int id) {
        Intent intent = new Intent(context, ReportActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
