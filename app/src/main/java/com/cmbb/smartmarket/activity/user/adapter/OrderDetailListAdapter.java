package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.user.holder.OrderDetailListItemHolder;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class OrderDetailListAdapter extends RecyclerArrayAdapter<MarketOrderDetailResponseModel.DataEntity.LogisticsEntity> {

    public OrderDetailListAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OrderDetailListItemHolder(parent);
    }
}
