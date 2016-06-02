package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.view.View;

import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderBuyStatus;
import com.cmbb.smartmarket.activity.user.model.OrderRefundBuyStatus;

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

    public static void newIntent(Context context, int orderId, String orderType) {
        Intent intent = new Intent(context, OrderDetailBuyRefundActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderType", orderType);
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
        tvOperation01.setText(OrderBuyStatus.getStatus(response.getData().getStatus())[1]);
        tvOperation02.setText(OrderBuyStatus.getStatus(response.getData().getStatus())[2]);
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
                }
            }
        });
    }

}
