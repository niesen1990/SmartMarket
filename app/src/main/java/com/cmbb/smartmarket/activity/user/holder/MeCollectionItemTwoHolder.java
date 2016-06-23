package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MyselfProductCollectListResponseModel;
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
public class MeCollectionItemTwoHolder extends BaseViewHolder<MyselfProductCollectListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = MeCollectionItemTwoHolder.class.getSimpleName();

    private ImageView ivHead;
    private ImageView iv01;
    private ImageView iv02;
    private TextView tvNick;
    private TextView tvTime;
    private TextView tvContent;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvAddress;
    private TextView tvMessage;
    private TextView tvWatch;
    private TextView tvStatus;

    Context mContext;

    public MeCollectionItemTwoHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_pager_list_item_two);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
        iv01 = $(R.id.iv01);
        iv02 = $(R.id.iv02);
        tvNick = $(R.id.tv_nick);
        tvTime = $(R.id.tv_time);
        tvContent = $(R.id.tv_content);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        tvAddress = $(R.id.tv_address);
        tvMessage = $(R.id.tv_message);
        tvWatch = $(R.id.tv_watch);
        tvStatus = $(R.id.tv_status);
    }

    public void setData(MyselfProductCollectListResponseModel.DataEntity.ContentEntity row) {
        ImageLoader.loadUrlAndDiskCache(mContext, row.getProduct().getPublicUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvNick.setText(row.getProduct().getPublicUser().getNickName());
        tvTime.setText(new JTimeTransform(row.getProduct().getPublicDate()).toString(new RecentDateFormat()));
        tvContent.setText(row.getProduct().getContent());
        tvStatus.setText(row.getProduct().getProductStatusText());
        tvNewPrice.setText("￥" + row.getProduct().getCurrentPrice());
        if (row.getProduct().getOriginalPrice() == 0) {
            tvOldPrice.setVisibility(View.INVISIBLE);
        } else {
            tvOldPrice.setVisibility(View.VISIBLE);
            tvOldPrice.setText("￥" + row.getProduct().getOriginalPrice());
        }
        if (row.getProduct().getUserLocation() != null)
            tvAddress.setText(row.getProduct().getUserLocation().getCity() + "  " + row.getProduct().getUserLocation().getDistrict());
        tvMessage.setText(row.getProduct().getReplyNumber() + "");
        tvWatch.setText(row.getProduct().getBrowseNumber() + "");
        if (row.getProduct().getProductImageList() != null && row.getProduct().getProductImageList().size() > 0) {
            ImageLoader.loadCenterCropCache(mContext, row.getProduct().getProductImageList().get(0).getLocation(), iv01);
            ImageLoader.loadCenterCropCache(mContext, row.getProduct().getProductImageList().get(1).getLocation(), iv02);
        }
    }
}
