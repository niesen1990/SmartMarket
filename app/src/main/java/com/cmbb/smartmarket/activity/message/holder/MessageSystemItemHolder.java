package com.cmbb.smartmarket.activity.message.holder;

import android.view.ViewGroup;

import com.cmbb.smartkids.recyclerview.adapter.BaseViewHolder;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class MessageSystemItemHolder extends BaseViewHolder<UserAttentionModel.ResponseEntity.DataEntity.RowsEntity> {
    private final String TAG = MessageSystemItemHolder.class.getSimpleName();

    public MessageSystemItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_message_system_list_item);
    }

    public void setData(UserAttentionModel.ResponseEntity.DataEntity.RowsEntity row) {

    }
}
