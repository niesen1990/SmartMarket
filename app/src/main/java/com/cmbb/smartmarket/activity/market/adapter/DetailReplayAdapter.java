package com.cmbb.smartmarket.activity.market.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.market.holder.DetailReplayItemHolder;
import com.cmbb.smartmarket.activity.market.holder.DetailReplayOfficeItemHolder;
import com.cmbb.smartmarket.activity.market.holder.DetailReplayRecommendItemHolder;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class DetailReplayAdapter extends RecyclerArrayAdapter<ProductReplyListResponseModel.DataEntity.ContentEntity> {

    public static final int TYPE_OFFICE = 1;
    public static final int TYPE_RECOMMEND = 2;
    public static final int TYPE_REPLAY = 3;

    public DetailReplayAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        if (getItem(position).getIsRecommoned() == 1) {
            return TYPE_OFFICE;
        }
        if (getItem(position).getResolveProductId() != -1) {
            return TYPE_RECOMMEND;
        } else {
            return TYPE_REPLAY;
        }
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_OFFICE:
                return new DetailReplayOfficeItemHolder(parent);
            case TYPE_RECOMMEND:
                return new DetailReplayRecommendItemHolder(parent);
            case TYPE_REPLAY:
                return new DetailReplayItemHolder(parent);
            default:
                return new DetailReplayItemHolder(parent);
        }
    }
}
