package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderRefundBuyStatus;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

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
public class OrderDetailBuyRefundActivity extends OrderDetailBaseActivity {

    private static final String TAG = OrderDetailBuyRefundActivity.class.getSimpleName();

    public static void newIntent(Context context, int orderId) {
        Intent intent = new Intent(context, OrderDetailBuyRefundActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivity(intent);
    }

    @Override
    protected void initBottomView(final MarketOrderDetailResponseModel response) {
        String[] items = OrderRefundBuyStatus.getStatus(response.getData().getStatus());
        if (TextUtils.isEmpty(items[1]) && TextUtils.isEmpty(items[2])) {
            llBottom.setVisibility(View.GONE);
            return;
        } else if (!TextUtils.isEmpty(items[1]) && !TextUtils.isEmpty(items[2])) {
            tvOperation01.setVisibility(View.VISIBLE);
            tvOperation02.setVisibility(View.VISIBLE);
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
                    case "拒绝原因":
                        CheckRejectActivity.newIntent(OrderDetailBuyRefundActivity.this, response);
                        break;
                }
            }
        });
        tvOperation02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tvOperation02.getText().toString()) {
                    case "退货":
                        ExpressActivity.newIntent(OrderDetailBuyRefundActivity.this, response.getData().getId(), 1);
                        break;
                    case "重新申请退款":
                        ApplyRefundActivity.newIntent(OrderDetailBuyRefundActivity.this, response);
                        break;
                    case "提醒收货":
                        HttpMethod.getInstance().marketOrderNotice(new Observer<MarketOrderNoticeResponseModel>() {
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
                            public void onNext(MarketOrderNoticeResponseModel marketOrderNoticeResponseModel) {
                                if (marketOrderNoticeResponseModel == null)
                                    return;
                                showToast(marketOrderNoticeResponseModel.getMsg());
                            }
                        }, setNoticeParams());
                        break;
                }
            }
        });
    }

    private MarketOrderNoticeRequestModel setNoticeParams() {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("refund", "buy", getIntent().getIntExtra("orderId", -1)));
        return marketOrderNoticeRequestModel;
    }
}
