package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.user.holder.PublishSellListItemOneHolder;
import com.cmbb.smartmarket.activity.user.holder.PublishSellListItemThreeHolder;
import com.cmbb.smartmarket.activity.user.holder.PublishSellListItemTwoHolder;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class PublishSellListAdapter extends RecyclerArrayAdapter<MyselfProductPublicListResponseModel.DataEntity.ContentEntity> {

    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    public PublishSellListAdapter(Context context) {
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
            case TYPE_ONE:
                return new PublishSellListItemOneHolder(parent);
            case TYPE_TWO:
                return new PublishSellListItemTwoHolder(parent);
            case TYPE_THREE:
                return new PublishSellListItemThreeHolder(parent);
            default:
                return new PublishSellListItemThreeHolder(parent);
        }
    }
}