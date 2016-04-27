package com.cmbb.smartmarket.activity.market.holder;

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
public class DetailReplayItemHolder extends BaseViewHolder<UserAttentionModel.ResponseEntity.DataEntity.RowsEntity> {
    private final String TAG = DetailReplayItemHolder.class.getSimpleName();


    public DetailReplayItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_market_detail_replay_list_item);
    }

    public void setData(UserAttentionModel.ResponseEntity.DataEntity.RowsEntity row) {

    }
}
