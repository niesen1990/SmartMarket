package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class PublishNeedListItemHolder extends BaseViewHolder<MyselfProductPublicListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = PublishNeedListItemHolder.class.getSimpleName();

    private LinearLayout ll01;
    private ImageView tv01;
    private ImageView tv02;
    private ImageView tv03;
    private RelativeLayout rl02;
    private TextView tvTitle;
    private TextView tvDelete;
    private TextView tvEdit;

    private Context mContext;

    public PublishNeedListItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_publish_need_list_item);
        this.mContext = parent.getContext();
        ll01 = $(R.id.ll01);
        tv01 = $(R.id.tv01);
        tv02 = $(R.id.tv02);
        tv03 = $(R.id.tv03);
        rl02 = $(R.id.rl02);
        tvTitle = $(R.id.tv_title);
        tvDelete = $(R.id.tv_delete);
        tvEdit = $(R.id.tv_edit);
    }

    public void setData(MyselfProductPublicListResponseModel.DataEntity.ContentEntity row) {
        tvTitle.setText(row.getTitle());
        if (row.getProductImageList() == null || row.getProductImageList().size() == 0) {
            ll01.setVisibility(View.GONE);
        } else if (0 < row.getProductImageList().size() && row.getProductImageList().size() <= 3) {
            ll01.setVisibility(View.VISIBLE);
            switch (row.getProductImageList().size()) {
                case 1:
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), tv01);
                    tv01.setVisibility(View.VISIBLE);
                    tv02.setVisibility(View.INVISIBLE);
                    tv03.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), tv01);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), tv02);
                    tv01.setVisibility(View.VISIBLE);
                    tv02.setVisibility(View.VISIBLE);
                    tv03.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    tv01.setVisibility(View.VISIBLE);
                    tv02.setVisibility(View.VISIBLE);
                    tv03.setVisibility(View.VISIBLE);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), tv01);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), tv02);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(2).getLocation(), tv03);
                    break;
            }
        } else {
            tv01.setVisibility(View.VISIBLE);
            tv02.setVisibility(View.VISIBLE);
            tv03.setVisibility(View.VISIBLE);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), tv01);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), tv02);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(2).getLocation(), tv03);
        }

        tvDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }
}
