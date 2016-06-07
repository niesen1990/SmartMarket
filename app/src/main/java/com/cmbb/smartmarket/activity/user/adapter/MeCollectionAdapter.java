package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.home.model.MyselfProductCollectListResponseModel;
import com.cmbb.smartmarket.activity.user.holder.MeCollectionItemHolder;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class MeCollectionAdapter extends RecyclerArrayAdapter<MyselfProductCollectListResponseModel.DataEntity.ContentEntity> {

    public MeCollectionAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new MeCollectionItemHolder(parent);
    }
}
