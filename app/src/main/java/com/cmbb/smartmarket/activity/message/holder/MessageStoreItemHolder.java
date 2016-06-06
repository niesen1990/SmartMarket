package com.cmbb.smartmarket.activity.message.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetPageResponseModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class MessageStoreItemHolder extends BaseViewHolder<MarketMessageGetPageResponseModel.DataEntity.ContentEntity> {
    private final String TAG = MessageStoreItemHolder.class.getSimpleName();

    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvTime;
    private TextView tvOldPrice;
    private Context mContext;

    public MessageStoreItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_message_store_list_item);
        mContext = parent.getContext();
        ivImage = $(R.id.iv_image);
        tvTitle = $(R.id.tv_title);
        tvTime = $(R.id.tv_time);
        tvOldPrice = $(R.id.tv_old_price);
    }

    public void setData(MarketMessageGetPageResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        ImageLoader.loadCenterCropCache(mContext, row.getImg(), ivImage);
        tvTitle.setText(row.getTitle());
        tvOldPrice.setText(row.getContents());
        tvTime.setText(new JTimeTransform(row.getCreateDate()).toString(new RecentDateFormat()));
    }
}
