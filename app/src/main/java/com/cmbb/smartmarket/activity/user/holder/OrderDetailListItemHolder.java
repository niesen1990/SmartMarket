package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class OrderDetailListItemHolder extends BaseViewHolder<MarketOrderDetailResponseModel.DataEntity.LogisticsEntity> {
    private final String TAG = OrderDetailListItemHolder.class.getSimpleName();


    private TextView tvContent;
    private TextView tvTime;

    public OrderDetailListItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_order_detail_list_item);
        tvContent = $(R.id.tv_content);
        tvTime = $(R.id.tv_time);
    }

    public void setData(MarketOrderDetailResponseModel.DataEntity.LogisticsEntity row) {
        if (row == null)
            return;
        tvContent.setText(row.getInfo());
        tvTime.setText(row.getDate());
    }
}
