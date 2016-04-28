package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartkids.recyclerview.adapter.BaseViewHolder;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class MeCollectionItemHolder extends BaseViewHolder<UserAttentionModel.ResponseEntity.DataEntity.RowsEntity> {
    private final String TAG = MeCollectionItemHolder.class.getSimpleName();

    private ImageView imageView;
    private TextView textView;

    public MeCollectionItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_me_collection_list_item);
//        imageView = $(R.id.imageView);
//        textView = $(R.id.textView);
    }

    public void setData(UserAttentionModel.ResponseEntity.DataEntity.RowsEntity row) {
//        textView.setText(row.getUserNike());

    }
}
