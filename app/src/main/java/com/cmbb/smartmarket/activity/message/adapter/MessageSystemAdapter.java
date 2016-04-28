package com.cmbb.smartmarket.activity.message.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartkids.recyclerview.adapter.BaseViewHolder;
import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;
import com.cmbb.smartmarket.activity.message.holder.MessageSystemItemHolder;


/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class MessageSystemAdapter extends RecyclerArrayAdapter<UserAttentionModel.ResponseEntity.DataEntity.RowsEntity> {

    public MessageSystemAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MessageSystemItemHolder(parent);
    }
}
