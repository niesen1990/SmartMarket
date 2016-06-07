package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.user.holder.OrderDetailFirstItemHolder;
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

    public static final int TYPE_FIRST = 0;
    public static final int TYPE_TAG = 1;

    public OrderDetailListAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        if (position == 0) {
            return TYPE_FIRST;
        } else {
            return TYPE_TAG;
        }
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new OrderDetailFirstItemHolder(parent);
            case 1:
                return new OrderDetailListItemHolder(parent);
            default:
                return new OrderDetailListItemHolder(parent);
        }
    }
}
