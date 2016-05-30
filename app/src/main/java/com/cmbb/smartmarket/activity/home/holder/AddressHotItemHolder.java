package com.cmbb.smartmarket.activity.home.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetHotCityListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class AddressHotItemHolder extends BaseViewHolder<MarketHomeGetHotCityListResponseModel.DataEntity.HotCityEntity> {
    private final String TAG = AddressHotItemHolder.class.getSimpleName();

    TextView tvAddress;
    public AddressHotItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_address_list_item);
        tvAddress = $(R.id.tv_address);
    }

    public void setData(MarketHomeGetHotCityListResponseModel.DataEntity.HotCityEntity row) {
        tvAddress.setText(row.getName());
    }
}
