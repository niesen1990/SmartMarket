package com.cmbb.smartmarket.activity.home.holder;

import android.view.ViewGroup;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class SearchGoodsItemHolder extends BaseViewHolder<MarketHomeSearchResponseModel.DataEntity.ContentEntity> {
    private final String TAG = SearchGoodsItemHolder.class.getSimpleName();

    public SearchGoodsItemHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_user_center_on_sell_list_item);
    }

    public void setData(MarketHomeSearchResponseModel.DataEntity.ContentEntity row) {

    }
}