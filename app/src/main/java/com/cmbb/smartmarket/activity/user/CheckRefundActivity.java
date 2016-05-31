package com.cmbb.smartmarket.activity.user;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
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
 * 创建时间：16/5/31 上午9:46
 * 修改人：N.Sun
 * 修改时间：16/5/31 上午9:46
 * 修改备注：
 */
public class CheckRefundActivity extends BaseActivity {
    private static final String TAG = CheckRefundActivity.class.getSimpleName();

    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.ll03)
    LinearLayout ll03;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.ll04)
    LinearLayout ll04;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.tv_reject)
    TextView tvReject;
    @BindView(R.id.tv_agree)
    TextView tvAgree;

    MarketOrderListResponseModel.DataEntity.ContentEntity dataEntity;

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
            setResult(RESULT_OK);
            finish();
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("查看退货信息");
        dataEntity = getIntent().getParcelableExtra("data");
        tvReject.setOnClickListener(this);
        tvAgree.setOnClickListener(this);
        tvType.setText(dataEntity.getRefundServer());
        tvReason.setText(dataEntity.getRejectReason());
        tvIntroduce.setText(dataEntity.getRefundMark());
        tvMoney.setText("￥" + dataEntity.getPrice());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_reject:
                RejectRefundReasonActivity.newIntent(this, dataEntity.getId());
                break;
            case R.id.tv_agree:
                DialogUtils.createAlertDialog(this, "警告", "您确定同意付款吗？", true, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        unSubscribe();
                        showWaitingDialog();
                        subscription = HttpMethod.getInstance().marketOrderRefund(mMarketOrderRefundResponseModelObserver, setAgreeParams());
                    }
                });
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_refund_layout;
    }

    private MarketOrderRefundRequestModel setAgreeParams() {
        MarketOrderRefundRequestModel marketOrderRefundRequestModel = new MarketOrderRefundRequestModel();
        marketOrderRefundRequestModel.setToken(BaseApplication.getToken());
        marketOrderRefundRequestModel.setCmd(ApiInterface.MarketOrderRefund);
        marketOrderRefundRequestModel.setParameters(new MarketOrderRefundRequestModel.ParametersEntity(dataEntity.getId(), "AGREE", ""));
        return marketOrderRefundRequestModel;
    }

    public static void newIntent(BaseActivity context, MarketOrderListResponseModel.DataEntity.ContentEntity entity) {
        Intent intent = new Intent(context, CheckRefundActivity.class);
        intent.putExtra("data", entity);
        context.startActivityForResult(intent, 100);
    }
}
