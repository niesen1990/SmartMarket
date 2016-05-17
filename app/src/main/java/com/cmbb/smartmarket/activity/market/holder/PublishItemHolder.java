package com.cmbb.smartmarket.activity.market.holder;

import android.view.ViewGroup;

import com.cmbb.smartmarket.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class PublishItemHolder extends BaseViewHolder<String> {
    private final String TAG = PublishItemHolder.class.getSimpleName();


    public PublishItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_publish_commodity_list_item);
    }

    public void setData(String row) {

    }
}
