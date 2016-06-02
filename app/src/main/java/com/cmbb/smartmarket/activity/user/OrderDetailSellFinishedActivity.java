package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderSoldStatus;

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

    public static void newIntent(Context context, int orderId, String orderType) {
        Intent intent = new Intent(context, OrderDetailSellFinishedActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderType", orderType);
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
                        ImmediateEvaluationActivity.newIntent(OrderDetailSellFinishedActivity.this, response.getData().getId());
                        break;
                    case "查看评价":
                        EvaluationForSellerActivity.newIntent(OrderDetailSellFinishedActivity.this, response.getData().getId());
                        break;
                }
            }
        });
    }
}
