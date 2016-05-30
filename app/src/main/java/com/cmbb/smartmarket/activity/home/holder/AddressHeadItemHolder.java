package com.cmbb.smartmarket.activity.home.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class AddressHeadItemHolder extends BaseViewHolder<String> {
    private final String TAG = AddressHeadItemHolder.class.getSimpleName();

    TextView tvAddress;

    public AddressHeadItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_address_head_list_item);
        tvAddress = $(R.id.tv_address);
    }

    public void setData(String row) {
        tvAddress.setText(row);
    }
}
