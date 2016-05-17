package com.cmbb.smartmarket.activity.market.holder;

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
public class PayItemHolder extends BaseViewHolder<TestModel.DataEntity.RowsEntity> {
    private final String TAG = PayItemHolder.class.getSimpleName();

    public PayItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_pay_list_item);
    }

    public void setData(TestModel.DataEntity.RowsEntity row) {

    }
}
