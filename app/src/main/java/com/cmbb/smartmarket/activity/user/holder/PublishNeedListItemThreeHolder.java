package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
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
public class PublishNeedListItemThreeHolder extends BaseViewHolder<MyselfProductPublicListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = PublishNeedListItemThreeHolder.class.getSimpleName();
    private ImageView ivHead;
    private ImageView iv01;
    private ImageView iv02;
    private ImageView iv03;
    private TextView tvNick;
    private TextView tvTime;
    private TextView tvContent;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvAddress;
    private TextView tvMessage;
    private TextView tvWatch;
    private RelativeLayout rlContent;

    Context mContext;

    public PublishNeedListItemThreeHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_pager_list_item_three);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
        iv01 = $(R.id.iv01);
        iv02 = $(R.id.iv02);
        iv03 = $(R.id.iv03);
        tvNick = $(R.id.tv_nick);
        tvTime = $(R.id.tv_time);
        tvContent = $(R.id.tv_content);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        tvAddress = $(R.id.tv_address);
        tvMessage = $(R.id.tv_message);
        tvWatch = $(R.id.tv_watch);
        rlContent = $(R.id.rl_content);
    }

    public void setData(MyselfProductPublicListResponseModel.DataEntity.ContentEntity row) {
        rlContent.setVisibility(View.GONE);
        ImageLoader.loadUrlAndDiskCache(mContext, row.getPublicUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvNick.setText(row.getPublicUser().getNickName());
        tvTime.setText(new JTimeTransform(row.getPublicDate()).toString(new RecentDateFormat()));
        tvContent.setText(row.getContent());
        tvNewPrice.setText("￥" + row.getCurrentPrice());
        if (row.getOriginalPrice() == 0) {
            tvOldPrice.setVisibility(View.INVISIBLE);
        } else {
            tvOldPrice.setVisibility(View.VISIBLE);
            tvOldPrice.setText("￥" + row.getOriginalPrice());
        }
        if (row.getUserLocation() != null)
            tvAddress.setText(row.getUserLocation().getCity() + "  " + row.getUserLocation().getDistrict());
        tvMessage.setText(row.getReplyNumber() + "");
        tvWatch.setText(row.getBrowseNumber() + "");
        if (row.getProductImageList() != null && row.getProductImageList().size() > 0) {
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), iv01);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), iv02);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(2).getLocation(), iv03);
        }
    }
}
