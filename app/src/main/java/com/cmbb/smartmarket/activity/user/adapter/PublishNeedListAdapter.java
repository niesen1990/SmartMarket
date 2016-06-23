package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.user.holder.PublishNeedListItemOneHolder;
import com.cmbb.smartmarket.activity.user.holder.PublishNeedListItemThreeHolder;
import com.cmbb.smartmarket.activity.user.holder.PublishNeedListItemTwoHolder;
import com.cmbb.smartmarket.activity.user.holder.PublishNeedListItemZeroHolder;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class PublishNeedListAdapter extends RecyclerArrayAdapter<MyselfProductPublicListResponseModel.DataEntity.ContentEntity> {

    public static final int TYPE_ZERO = 0;
    public static final int TYPE_ONE = 1;
    public static final int TYPE_TWO = 2;
    public static final int TYPE_THREE = 3;

    public PublishNeedListAdapter(Context context) {
        super(context);
    }

    @Override
    public int getViewType(int position) {
        if (getItem(position).getProductImageList() == null || getItem(position).getProductImageList().size() == 0) {
            return TYPE_ZERO;
        } else {
            switch (getItem(position).getProductImageList().size()) {
                case TYPE_ONE:
                    return TYPE_ONE;
                case TYPE_TWO:
                    return TYPE_TWO;
                case TYPE_THREE:
                    return TYPE_THREE;
                default:
                    return TYPE_THREE;
            }
        }
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case TYPE_ZERO:
                return new PublishNeedListItemZeroHolder(parent);
            case TYPE_ONE:
                return new PublishNeedListItemOneHolder(parent);
            case TYPE_TWO:
                return new PublishNeedListItemTwoHolder(parent);
            case TYPE_THREE:
                return new PublishNeedListItemThreeHolder(parent);
            default:
                return new PublishNeedListItemThreeHolder(parent);
        }
    }
}