package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderSoldStatus;
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
public class OrderDetailSellFinishedActivity extends OrderDetailBaseActivity {

    private static final String TAG = OrderDetailSellFinishedActivity.class.getSimpleName();

    public static void newIntent(Context context, int orderId) {
        Intent intent = new Intent(context, OrderDetailSellFinishedActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivity(intent);
    }

    @Override
    protected void initBottomView(final MarketOrderDetailResponseModel response) {
        String[] items = OrderSoldStatus.getStatus(response.getData().getStatus());
        if (TextUtils.isEmpty(items[0]) && TextUtils.isEmpty(items[1])) {
            llBottom.setVisibility(View.GONE);
            return;
        } else if (!TextUtils.isEmpty(items[0]) && !TextUtils.isEmpty(items[1])) {
            tvOperation01.setVisibility(View.VISIBLE);
            tvOperation02.setVisibility(View.VISIBLE);
            return;
        } else if (TextUtils.isEmpty(items[0])) {
            tvOperation01.setVisibility(View.GONE);
        } else {
            tvOperation02.setVisibility(View.GONE);
        }
        tvOperation01.setText(items[0]);
        tvOperation02.setText(items[1]);
        tvOperation01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        tvOperation02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView) v).getText().toString()) {
                    case "确认发货":
                        ExpressActivity.newIntent(OrderDetailSellFinishedActivity.this, response.getData().getId(), 0);
                        break;
                    case "提醒收货":
                        showWaitingDialog();
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
                    case "查看评价":
                        EvaluationForSellerActivity.newIntent(OrderDetailSellFinishedActivity.this, response.getData().getId());
                        break;
                }
            }
        });
    }

    private MarketOrderNoticeRequestModel setNoticeParams() {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("order", "sell", getIntent().getIntExtra("orderId", -1)));
        return marketOrderNoticeRequestModel;
    }
}
