package com.cmbb.smartmarket.activity.home.holder;

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
public class HeadItemHolder extends BaseViewHolder<TestModel.DataEntity.RowsEntity> {
    private final String TAG = HeadItemHolder.class.getSimpleName();

    public HeadItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_head_list_item);
    }

    public void setData(TestModel.DataEntity.RowsEntity row) {

    }
}
