package com.cmbb.smartmarket.activity.address.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class AddressItemHolder extends BaseViewHolder<UserAddressGetPageResponseModel.DataEntity.RowsEntity> {
    private final String TAG = AddressItemHolder.class.getSimpleName();

    TextView tvName;
    TextView tvSex;
    TextView tvPhone;
    TextView tvAddress;
    ImageView tvStatus;

    public AddressItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_address_list_item);
        tvName = $(R.id.tv_name);
        tvSex = $(R.id.tv_sex);
        tvPhone = $(R.id.tv_phone);
        tvAddress = $(R.id.tv_address);
        tvStatus = $(R.id.tv_status);
    }

    public void setData(UserAddressGetPageResponseModel.DataEntity.RowsEntity row) {
        if (row == null)
            return;
        tvName.setText(row.getReceiveName());
        tvSex.setText("");
        tvPhone.setText(row.getReceivePhone());
        tvAddress.setText(row.getAddress());
        switch (row.getIsDefault()) {
            case 0:
                // TODO: 16/5/17
                break;
            case 1:
                // TODO: 16/5/17
                break;
        }
    }
}
