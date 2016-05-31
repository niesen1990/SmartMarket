package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 下午12:00
 * 修改人：N.Sun
 * 修改时间：16/5/31 下午12:00
 * 修改备注：
 */
public class RejectRefundReasonActivity extends BaseActivity {

    private static final String TAG = RejectRefundReasonActivity.class.getSimpleName();
    @BindView(R.id.tv_reason)
    EditText tvReason;
    @BindView(R.id.tv_apply)
    TextView tvApply;

    Observer<MarketOrderRefundResponseModel> mMarketOrderRefundResponseModelObserver = new Observer<MarketOrderRefundResponseModel>() {
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
        public void onNext(MarketOrderRefundResponseModel marketOrderRefundResponseModel) {
            if (marketOrderRefundResponseModel == null)
                return;
            showToast(marketOrderRefundResponseModel.getMsg());
            finish();
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("填写拒绝原因");
        tvApply.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (TextUtils.isEmpty(tvReason.getText().toString())) {
            showToast("请填写退款原因");
            return;
        }
        DialogUtils.createAlertDialog(this, "警告", "是否要提交拒绝退款原因？", true, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                showWaitingDialog();
                unSubscribe();
                subscription = HttpMethod.getInstance().marketOrderRefund(mMarketOrderRefundResponseModelObserver, setRejectParams());
            }
        });

    }

    private MarketOrderRefundRequestModel setRejectParams() {
        MarketOrderRefundRequestModel marketOrderRefundRequestModel = new MarketOrderRefundRequestModel();
        marketOrderRefundRequestModel.setToken(BaseApplication.getToken());
        marketOrderRefundRequestModel.setCmd(ApiInterface.MarketOrderRefund);
        marketOrderRefundRequestModel.setParameters(new MarketOrderRefundRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1), "REJECT", tvReason.getText().toString()));
        return marketOrderRefundRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_reject_refund_reason_layout;
    }

    public static void newIntent(Context context, int orderId) {
        Intent intent = new Intent(context, RejectRefundReasonActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivity(intent);
    }
}
