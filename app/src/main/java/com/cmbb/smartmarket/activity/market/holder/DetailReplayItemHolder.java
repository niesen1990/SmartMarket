package com.cmbb.smartmarket.activity.market.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListResponseModel;
import com.cmbb.smartmarket.image.CircleTransform;
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
public class DetailReplayItemHolder extends BaseViewHolder<ProductReplyListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = DetailReplayItemHolder.class.getSimpleName();

    private RelativeLayout llInfo;
    private ImageView ivHead;
    private TextView tvNick;
    private TextView tvTime;
    private TextView tvContent;

    private Context mContext;

    public DetailReplayItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_market_detail_replay_list_item);
        this.mContext = parent.getContext();
        llInfo = $(R.id.ll_info);
        ivHead = $(R.id.iv_head);
        tvNick = $(R.id.tv_nick);
        tvTime = $(R.id.tv_time);
        tvContent = $(R.id.tv_content);
    }

    public void setData(ProductReplyListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        ImageLoader.loadUrlAndDiskCache(mContext, row.getCreateUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvNick.setText(row.getCreateUser().getNickName());
        tvTime.setText(new JTimeTransform(row.getCreateDate()).toString(new RecentDateFormat()));
        tvContent.setText(row.getContents());
    }
}
