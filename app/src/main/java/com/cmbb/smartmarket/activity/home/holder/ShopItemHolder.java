package com.cmbb.smartmarket.activity.home.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
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
public class ShopItemHolder extends BaseViewHolder<ProductGetPageResponseModel.DataEntity.ContentEntity> {
    private final String TAG = ShopItemHolder.class.getSimpleName();

    private ImageView ivHead;
    private TextView tvNick;
    private TextView tvTime;
    private TextView tvTitle;
    private TextView tvContent;
    private RelativeLayout rlBottom;
    private TextView tvAddress;
    private TextView tvMessage;
    private TextView tvStatus;
    private TextView tvWatch;
    private Context mContext;
    private LinearLayout llImages;
    private ImageView iv01;
    private ImageView iv02;
    private ImageView iv03;

    public ShopItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_shop_list_item);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
        tvNick = $(R.id.tv_nick);
        tvTime = $(R.id.tv_time);
        tvTitle = $(R.id.tv_title);
        tvContent = $(R.id.tv_content);
        rlBottom = $(R.id.rl_bottom);
        tvAddress = $(R.id.tv_address);
        tvMessage = $(R.id.tv_message);
        tvWatch = $(R.id.tv_watch);
        tvStatus = $(R.id.tv_status);
        iv01 = $(R.id.iv01);
        iv02 = $(R.id.iv02);
        iv03 = $(R.id.iv03);
        llImages = $(R.id.ll_images);
    }

    public void setData(ProductGetPageResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        ImageLoader.loadUrlAndDiskCache(mContext, row.getPublicUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvNick.setText(row.getPublicUser().getNickName());
        tvTime.setText(new JTimeTransform(row.getPublicDate()).toString(new RecentDateFormat()));
        tvTitle.setText(row.getTitle());
        tvContent.setText(row.getContent());
        if (row.getUserLocation() != null)
            tvAddress.setText(row.getUserLocation().getCity() + " | " + row.getUserLocation().getDistrict());
        tvMessage.setText(row.getReplyNumber() + "");
        tvWatch.setText(row.getBrowseNumber() + "");
        tvStatus.setText(row.getProductStatusText());

        if (row.getProductImageList() == null || row.getProductImageList().size() == 0) {
            llImages.setVisibility(View.GONE);
        } else if (0 < row.getProductImageList().size() && row.getProductImageList().size() <= 3) {
            llImages.setVisibility(View.VISIBLE);
            switch (row.getProductImageList().size()) {
                case 1:
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), iv01);
                    iv01.setVisibility(View.VISIBLE);
                    iv02.setVisibility(View.INVISIBLE);
                    iv03.setVisibility(View.INVISIBLE);
                    break;
                case 2:
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), iv01);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), iv02);
                    iv01.setVisibility(View.VISIBLE);
                    iv02.setVisibility(View.VISIBLE);
                    iv03.setVisibility(View.INVISIBLE);
                    break;
                case 3:
                    iv01.setVisibility(View.VISIBLE);
                    iv02.setVisibility(View.VISIBLE);
                    iv03.setVisibility(View.VISIBLE);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), iv01);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), iv02);
                    ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(2).getLocation(), iv03);
                    break;
            }
        } else {
            iv01.setVisibility(View.VISIBLE);
            iv02.setVisibility(View.VISIBLE);
            iv03.setVisibility(View.VISIBLE);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), iv01);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(1).getLocation(), iv02);
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(2).getLocation(), iv03);
        }
    }
}
