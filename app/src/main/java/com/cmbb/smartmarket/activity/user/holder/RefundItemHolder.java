package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class RefundItemHolder extends BaseViewHolder<TestModel.DataEntity.RowsEntity> {
    private final String TAG = RefundItemHolder.class.getSimpleName();


    public RefundItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_refund_list_item);
    }

    public void setData(TestModel.DataEntity.RowsEntity row) {

    }
}
