package com.cmbb.smartmarket.activity.search.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.home.holder.SearchGoodsItemHolder;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.security.InvalidParameterException;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class SearchAdapter extends RecyclerArrayAdapter<Object> {

    public static final int TYPE_INVALID = 0;
    public static final int TYPE_GOOD = 1;
    public static final int TYPE_USER = 2;

    public SearchAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        if (getItem(position) instanceof String) {
            return TYPE_USER;
        } else if (getItem(position) instanceof MarketHomeSearchResponseModel.DataEntity.ContentEntity) {
            return TYPE_GOOD;
        }
        return TYPE_INVALID;
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_GOOD:
                return new SearchGoodsItemHolder(parent);
            default:
                throw new InvalidParameterException();
        }
    }
}
