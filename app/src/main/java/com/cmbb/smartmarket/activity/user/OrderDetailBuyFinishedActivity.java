package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.activity.market.PayActivity;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderBuyStatus;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 下午6:24
 * 修改人：N.Sun
 * 修改时间：16/5/31 下午6:24
 * 修改备注：
 */
public class OrderDetailBuyFinishedActivity extends OrderDetailBaseActivity {

    private static final String TAG = OrderDetailBuyFinishedActivity.class.getSimpleName();

    public static void newIntent(Context context, int orderId, String orderType) {
        Intent intent = new Intent(context, OrderDetailBuyFinishedActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderType", orderType);
        context.startActivity(intent);
    }

    @Override
    protected void initBottomView(final MarketOrderDetailResponseModel response) {
        String[] items = OrderBuyStatus.getStatus(response.getData().getStatus());
        if (TextUtils.isEmpty(items[0]) && TextUtils.isEmpty(items[1])) {
            llBottom.setVisibility(View.GONE);
            return;
        } else if (!TextUtils.isEmpty(items[0]) && !TextUtils.isEmpty(items[1])) {
            tvOperation01.setVisibility(View.VISIBLE);
            tvOperation02.setVisibility(View.VISIBLE);
        } else if (TextUtils.isEmpty(items[0])) {
            tvOperation01.setVisibility(View.GONE);
        } else {
            tvOperation02.setVisibility(View.GONE);
        }
        tvOperation01.setText(OrderBuyStatus.getStatus(response.getData().getStatus())[0]);
        tvOperation02.setText(OrderBuyStatus.getStatus(response.getData().getStatus())[1]);
        tvOperation01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView) v).getText().toString()) {
                    case "取消订单":
                        CancelOrderActivity.newIntent(OrderDetailBuyFinishedActivity.this, response.getData().getId());
                        break;
                    case "申请退款":
                        ApplyRefundActivity.newIntent(OrderDetailBuyFinishedActivity.this, response);
                        break;
                }
            }
        });
        tvOperation02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView) v).getText().toString()) {
                    case "立即支付":
                        PayActivity.newIntent(OrderDetailBuyFinishedActivity.this, response.getData().getOrderCode(), response.getData().getPrice());
                        break;
                    case "提醒发货":
                        break;
                    case "确认收货":
                        DialogUtils.createAlertDialog(OrderDetailBuyFinishedActivity.this, "操作提醒", "你确定收获了吗？", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showWaitingDialog();
                                HttpMethod.getInstance().marketOrderBuyerReceive(new Observer<MarketOrderBuyerReceiveResponseModel>() {
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
                                    public void onNext(MarketOrderBuyerReceiveResponseModel marketOrderBuyerReceiveResponseModel) {
                                        if (marketOrderBuyerReceiveResponseModel == null)
                                            return;
                                        showToast(marketOrderBuyerReceiveResponseModel.getMsg());
                                    }
                                }, setConfirmExpressParams(response.getData().getId()));
                            }
                        });
                        break;
                    case "立即评价":
                        ImmediateEvaluationActivity.newIntent(OrderDetailBuyFinishedActivity.this, response.getData().getId());
                        break;
                    case "查看评价":
                        CheckEvaluateActivity.newIntent(OrderDetailBuyFinishedActivity.this, response.getData().getId());
                        break;
                }
            }
        });
    }

    private MarketOrderBuyerReceiveRequestModel setConfirmExpressParams(int orderId) {
        MarketOrderBuyerReceiveRequestModel marketOrderBuyerReceiveRequestModel = new MarketOrderBuyerReceiveRequestModel();
        marketOrderBuyerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderBuyerReceiveRequestModel.setCmd(ApiInterface.MarketOrderBuyerReceive);
        marketOrderBuyerReceiveRequestModel.setParameters(new MarketOrderBuyerReceiveRequestModel.ParametersEntity(orderId));
        return marketOrderBuyerReceiveRequestModel;
    }
}
