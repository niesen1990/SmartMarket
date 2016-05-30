package com.cmbb.smartmarket.activity.home.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetAllCityListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class AddressItemHolder extends BaseViewHolder<MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity> {
    private final String TAG = AddressItemHolder.class.getSimpleName();

    TextView tvAddress;
    public AddressItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_address_list_item);
        tvAddress = $(R.id.tv_address);
    }

    public void setData(MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity row) {
        tvAddress.setText(row.getName());
    }
}
