package com.cmbb.smartmarket.activity.address.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.model.ProvinceCityGetAllResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class AddressPickItemHolder extends BaseViewHolder<ProvinceCityGetAllResponseModel.DataEntity> {
    private final String TAG = AddressPickItemHolder.class.getSimpleName();

    TextView tvContent;

    public AddressPickItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_address_pick_list_item);
        tvContent = $(R.id.tv_content);
    }

    public void setData(ProvinceCityGetAllResponseModel.DataEntity row) {
        if (row == null)
            return;
        tvContent.setText(row.getName());
    }
}
