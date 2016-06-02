package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderRefundSellStatus;
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
public class OrderDetailSellRefundActivity extends OrderDetailBaseActivity {

    private static final String TAG = OrderDetailSellRefundActivity.class.getSimpleName();

    public static void newIntent(Context context, int orderId, String orderType) {
        Intent intent = new Intent(context, OrderDetailSellRefundActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderType", orderType);
        context.startActivity(intent);
    }

    @Override
    protected void initBottomView(final MarketOrderDetailResponseModel response) {
        String[] items = OrderRefundSellStatus.getStatus(response.getData().getStatus());
        if (TextUtils.isEmpty(items[1]) && TextUtils.isEmpty(items[2])) {
            llBottom.setVisibility(View.GONE);
            return;
        } else if (!TextUtils.isEmpty(items[1]) && !TextUtils.isEmpty(items[2])) {
            tvOperation01.setVisibility(View.VISIBLE);
            tvOperation02.setVisibility(View.VISIBLE);
            return;
        } else if (TextUtils.isEmpty(items[1])) {
            tvOperation01.setVisibility(View.GONE);
        } else {
            tvOperation02.setVisibility(View.GONE);
        }
        tvOperation01.setText(items[1]);
        tvOperation02.setText(items[2]);
        tvOperation01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tvOperation02.getText().toString()) {
                    case "拒绝":
                        RejectRefundReasonActivity.newIntent(OrderDetailSellRefundActivity.this, response.getData().getId());
                        break;
                }
            }
        });
        tvOperation02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tvOperation02.getText().toString()) {
                    case "同意":
                        DialogUtils.createAlertDialog(OrderDetailSellRefundActivity.this, "警告", "您确定同意付款吗？", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showWaitingDialog();
                                HttpMethod.getInstance().marketOrderRefund(new Observer<MarketOrderRefundResponseModel>() {
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
                                        onRefresh();
                                    }
                                }, setAgreeParams(response));
                            }
                        });
                        break;
                    case "提醒退货":
                        // TODO: 16/5/31
                        break;
                    case "确认收货":
                        DialogUtils.createAlertDialog(OrderDetailSellRefundActivity.this, "警告", "确认收货了吗？", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                showWaitingDialog();
                                HttpMethod.getInstance().marketOrderSellerReceive(new Observer<MarketOrderSellerReceiveResponseModel>() {
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
                                    public void onNext(MarketOrderSellerReceiveResponseModel marketOrderSellerReceiveResponseModel) {
                                        if (marketOrderSellerReceiveResponseModel == null)
                                            return;
                                        showToast(marketOrderSellerReceiveResponseModel.getMsg());
                                    }
                                }, setReceiverParams(response.getData().getId()));
                            }
                        });
                        break;
                    case "拒绝原因":
                        CheckRejectActivity.newIntent(OrderDetailSellRefundActivity.this, response);
                        break;
                }
            }
        });
    }

    private MarketOrderSellerReceiveRequestModel setReceiverParams(int id) {
        MarketOrderSellerReceiveRequestModel marketOrderSellerReceiveRequestModel = new MarketOrderSellerReceiveRequestModel();
        marketOrderSellerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderSellerReceiveRequestModel.setCmd(ApiInterface.MarketOrderSellerReceive);
        marketOrderSellerReceiveRequestModel.setParameters(new MarketOrderSellerReceiveRequestModel.ParametersEntity(id));
        return marketOrderSellerReceiveRequestModel;
    }

    private MarketOrderRefundRequestModel setAgreeParams(MarketOrderDetailResponseModel response) {
        MarketOrderRefundRequestModel marketOrderRefundRequestModel = new MarketOrderRefundRequestModel();
        marketOrderRefundRequestModel.setToken(BaseApplication.getToken());
        marketOrderRefundRequestModel.setCmd(ApiInterface.MarketOrderRefund);
        marketOrderRefundRequestModel.setParameters(new MarketOrderRefundRequestModel.ParametersEntity(response.getData().getId(), "AGREE", ""));
        return marketOrderRefundRequestModel;
    }

}
