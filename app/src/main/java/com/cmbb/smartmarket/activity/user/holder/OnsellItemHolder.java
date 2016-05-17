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
public class OnSellItemHolder extends BaseViewHolder<TestModel.DataEntity.RowsEntity> {
    private final String TAG = OnSellItemHolder.class.getSimpleName();

    public OnSellItemHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_user_center_on_sell_list_item);
    }

    public void setData(TestModel.DataEntity.RowsEntity row) {

    }
}
