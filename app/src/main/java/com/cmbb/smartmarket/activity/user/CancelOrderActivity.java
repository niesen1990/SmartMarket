package com.cmbb.smartmarket.activity.user;

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
import com.cmbb.smartmarket.activity.user.model.MarketOrderCancelRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderCancelResponseModel;
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
 * 创建时间：16/5/29 下午12:54
 * 修改人：N.Sun
 * 修改时间：16/5/29 下午12:54
 * 修改备注：
 */
public class CancelOrderActivity extends BaseActivity {
    private static final String TAG = CancelOrderActivity.class.getSimpleName();

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

    String reason;
    Observer<MarketOrderCancelResponseModel> mMarketOrderCancelResponseModelObserver = new Observer<MarketOrderCancelResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketOrderCancelResponseModel marketOrderCancelResponseModel) {
            hideWaitingDialog();
            if (marketOrderCancelResponseModel == null)
                return;
            showToast(marketOrderCancelResponseModel.getMsg());
            setResult(RESULT_OK);
            finish();
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("取消订单");
        tvSubmit.setOnClickListener(this);
        rgReason.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                //获取变更后的选中项的ID
                switch (checkedId) {
                    case R.id.rb01:
                        reason = rb01.getText().toString();
                        break;
                    case R.id.rb02:
                        reason = rb02.getText().toString();
                        break;
                    case R.id.rb03:
                        reason = rb03.getText().toString();
                        break;
                    case R.id.rb04:
                        reason = rb04.getText().toString();
                        break;
                }
            }
        });
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_cancel_order_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (rgReason.getCheckedRadioButtonId() == R.id.rb04 && TextUtils.isEmpty(etContent.getText().toString())) {
                    showToast("请输入其他原因");
                    return;
                }
                subscription = HttpMethod.getInstance().marketOrderCancel(mMarketOrderCancelResponseModelObserver, setCancelParams());
                break;
        }
    }

    private MarketOrderCancelRequestModel setCancelParams() {
        MarketOrderCancelRequestModel marketOrderCancelRequestModel = new MarketOrderCancelRequestModel();
        marketOrderCancelRequestModel.setCmd(ApiInterface.MarketOrderCancel);
        marketOrderCancelRequestModel.setToken(BaseApplication.getToken());
        marketOrderCancelRequestModel.setParameters(new MarketOrderCancelRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1), reason));
        return marketOrderCancelRequestModel;
    }

    public static void newIntent(BaseActivity context, int orderId) {
        Intent intent = new Intent(context, CancelOrderActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivityForResult(intent, 100);
    }
}
