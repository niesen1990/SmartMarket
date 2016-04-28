package com.cmbb.smartmarket.activity.market.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartkids.recyclerview.adapter.BaseViewHolder;
import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.activity.market.holder.PublishItemHolder;


/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class PublishItemAdapter extends RecyclerArrayAdapter<String> {

    public PublishItemAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new PublishItemHolder(parent);
    }
}
