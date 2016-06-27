package com.cmbb.smartmarket.activity.market.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.network.model.ProductImageList;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class DetailDetailImageItemHolder extends BaseViewHolder<ProductImageList> {
    private final String TAG = DetailDetailImageItemHolder.class.getSimpleName();

    private ImageView iv01;

    private Context mContext;

    public DetailDetailImageItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_detail_image_list_item);
        this.mContext = parent.getContext();
        iv01 = $(R.id.iv01);
    }

    public void setData(ProductImageList row) {
        if (row == null)
            return;
        ImageLoader.loadUrlAndDiskCache(mContext, row.getLocation(), iv01);
    }
}
