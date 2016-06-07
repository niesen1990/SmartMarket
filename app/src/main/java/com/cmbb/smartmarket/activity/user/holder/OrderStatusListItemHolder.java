package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class OrderStatusListItemHolder extends BaseViewHolder<MarketOrderDetailResponseModel.DataEntity.ProcessEntity> {
    private final String TAG = OrderStatusListItemHolder.class.getSimpleName();

    private TextView tvStatus;
    private TextView tvTime;

    public OrderStatusListItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_order_detail_status_item_layout);
        tvStatus = $(R.id.tv_status);
        tvTime = $(R.id.tv_time);
    }

    public void setData(MarketOrderDetailResponseModel.DataEntity.ProcessEntity row) {
        if (row == null)
            return;
        tvStatus.setText(row.getStatusName());
        Log.e(TAG, row.getStatusName());
        tvTime.setText(new JTimeTransform(row.getStatusDate()).toString(new RecentDateFormat()));
    }
}
