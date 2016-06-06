package com.cmbb.smartmarket.activity.home.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.home.holder.OfficeRecommendItemHolder;
import com.cmbb.smartmarket.activity.home.model.MarketHomeRecommendationResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class OfficeRecommendAdapter extends RecyclerArrayAdapter<MarketHomeRecommendationResponseModel.DataEntity.ContentEntity> {

    public OfficeRecommendAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new OfficeRecommendItemHolder(parent);
    }
}
