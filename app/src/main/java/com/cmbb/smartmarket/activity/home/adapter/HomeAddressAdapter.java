package com.cmbb.smartmarket.activity.home.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.home.holder.AddressHeadItemHolder;
import com.cmbb.smartmarket.activity.home.holder.AddressHotItemHolder;
import com.cmbb.smartmarket.activity.home.holder.AddressItemHolder;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetAllCityListResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetHotCityListResponseModel;
import com.cmbb.smartmarket.log.Log;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.security.InvalidParameterException;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class HomeAddressAdapter extends RecyclerArrayAdapter<Object> {

    public static final int TYPE_INVALID = 0;
    public static final int TYPE_TAG = 1;
    public static final int TYPE_HOT = 2;
    public static final int TYPE_ALL = 3;

    public HomeAddressAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        if (getItem(position) instanceof String) {
            return TYPE_TAG;
        }else if (getItem(position) instanceof MarketHomeGetHotCityListResponseModel.DataEntity.HotCityEntity) {
            Log.e("MarketHomeGetHotCityListResponseModel", "position = " + position);
            return TYPE_HOT;
        } else if (getItem(position) instanceof MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) {
            Log.e("MarketHomeGetAllCityListResponseModel", "position = " + position);
            return TYPE_ALL;
        }
        return TYPE_INVALID;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_TAG:
                return new AddressHeadItemHolder(parent);
            case TYPE_HOT:
                return new AddressHotItemHolder(parent);
            case TYPE_ALL:
                return new AddressItemHolder(parent);
            default:
                Log.e("TYPE_INVALID");
                throw new InvalidParameterException();
        }
    }
}
