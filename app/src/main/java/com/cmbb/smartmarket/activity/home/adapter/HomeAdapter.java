package com.cmbb.smartmarket.activity.home.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.home.holder.HomeItemOneHolder;
import com.cmbb.smartmarket.activity.home.holder.HomeItemThreeHolder;
import com.cmbb.smartmarket.activity.home.holder.HomeItemTwoHolder;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class HomeAdapter extends RecyclerArrayAdapter<ProductGetPageResponseModel.DataEntity.ContentEntity> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    public HomeAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        switch (getItem(position).getProductImageList().size()) {
            case 1:
                return TYPE_ONE;
            case 2:
                return TYPE_TWO;
            case 3:
                return TYPE_THREE;
            default:
                return TYPE_THREE;
        }
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 1:
                return new HomeItemOneHolder(parent);
            case 2:
                return new HomeItemTwoHolder(parent);
            case 3:
                return new HomeItemThreeHolder(parent);
            default:
                return new HomeItemThreeHolder(parent);
        }
    }
}
