package com.cmbb.smartmarket.activity.market.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.PublishImageModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class PublishItemHolder extends BaseViewHolder<PublishImageModel> {
    private final String TAG = PublishItemHolder.class.getSimpleName();

    private ImageView iv;
    private ImageView ivDelete;
    private ProgressBar progress;
    private Context mContext;

    public PublishItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_publish_commodity_list_item);
        mContext = parent.getContext();
        iv = $(R.id.iv);
        ivDelete = $(R.id.iv_delete);
        progress = $(R.id.progress);
    }

    public void setData(PublishImageModel row) {
        if (row == null)
            return;
        ImageLoader.loadCenterCropCache(mContext, row.getImageUrl(), iv);

    }
}
