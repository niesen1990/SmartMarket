package com.cmbb.smartmarket.activity.market.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.market.holder.DetailDetailImageItemHolder;
import com.cmbb.smartmarket.activity.market.holder.DetailReplayItemHolder;
import com.cmbb.smartmarket.activity.market.holder.DetailReplayOfficeItemHolder;
import com.cmbb.smartmarket.activity.market.holder.DetailReplayRecommendItemHolder;
import com.cmbb.smartmarket.activity.market.model.ProductDetailResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class DetailSellAdapter extends RecyclerArrayAdapter<Object> {

    public static final int TYPE_IMAGE = 1;
    public static final int TYPE_REPLAY = 2;

    public static final int TYPE_REPLAY_OFFICE = 3;
    public static final int TYPE_REPLAY_RECOMMEND = 4;
    public static final int TYPE_REPLAY_NORMAL = 5;

    public DetailSellAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        if (getItem(position) instanceof ProductDetailResponseModel.DataEntity.ProductImageListEntity) {
            return TYPE_IMAGE;
        }
        if (getItem(position) instanceof ProductReplyListResponseModel.DataEntity.ContentEntity) {
            if (((ProductReplyListResponseModel.DataEntity.ContentEntity) getItem(position)).getIsRecommoned() == 1) {
                return TYPE_REPLAY_OFFICE;
            }
            if (((ProductReplyListResponseModel.DataEntity.ContentEntity) getItem(position)).getResolveProductId() != -1) {
                return TYPE_REPLAY_RECOMMEND;
            } else {
                return TYPE_REPLAY_NORMAL;
            }
        } else {
            return TYPE_REPLAY_NORMAL;
        }
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_IMAGE:
                return new DetailDetailImageItemHolder(parent);
            case TYPE_REPLAY_OFFICE:
                return new DetailReplayOfficeItemHolder(parent);
            case TYPE_REPLAY_RECOMMEND:
                return new DetailReplayRecommendItemHolder(parent);
            case TYPE_REPLAY_NORMAL:
                return new DetailReplayItemHolder(parent);
            default:
                return new DetailReplayItemHolder(parent);
        }
    }
}
