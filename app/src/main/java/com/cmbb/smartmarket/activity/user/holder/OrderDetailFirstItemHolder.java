package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
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
public class OrderDetailFirstItemHolder extends BaseViewHolder<MarketOrderDetailResponseModel.DataEntity.LogisticsEntity> {
    private final String TAG = OrderDetailFirstItemHolder.class.getSimpleName();

    private TextView tvContent;
    private ImageView image;
    private TextView tvTime;

    public OrderDetailFirstItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_order_detail_list_item);
        tvContent = $(R.id.tv_content);
        tvTime = $(R.id.tv_time);
        image = $(R.id.image);
        image.setImageResource(R.drawable.shape_color_circle);
    }

    public void setData(MarketOrderDetailResponseModel.DataEntity.LogisticsEntity row) {
        if (row == null)
            return;
        tvContent.setText(row.getInfo());
        tvTime.setText(row.getDate());
    }
}
