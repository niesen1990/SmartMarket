package com.cmbb.smartmarket.activity.market.model;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListResponseModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class RecommendListItemHolder extends BaseViewHolder<MarketCenterSelectProductListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = RecommendListItemHolder.class.getSimpleName();

    private RadioButton check;
    private ImageView ivGood;
    private TextView tvTitle;
    private TextView tvContent;
    private Context mContext;

    public RecommendListItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_recommend_list_item);
        this.mContext = parent.getContext();
        check = $(R.id.check);
        ivGood = $(R.id.iv_good);
        tvTitle = $(R.id.tv_title);
        tvContent = $(R.id.tv_content);

    }

    public void setData(final MarketCenterSelectProductListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        tvTitle.setText(row.getTitle());
        if (row.getProductImageList() != null && row.getProductImageList().size() > 0)
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), ivGood);
        tvContent.setText(row.getContent());
        check.setChecked(row.isChecked());
    }
}
