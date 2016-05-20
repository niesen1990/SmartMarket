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
public class HomeItemHolder extends BaseViewHolder<ProductGetPageResponseModel.DataEntity.ContentEntity> {
    private final String TAG = HomeItemHolder.class.getSimpleName();
    private ImageView ivHead;
    private ImageView iv01;
    private ImageView iv02;
    private ImageView iv03;
    private TextView tvNick;
    private TextView tvTime;
    private LinearLayout llImages;
    private TextView tvContent;
    private RelativeLayout rlContent;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private RelativeLayout rlBottom;
    private TextView tvAddress;
    private TextView tvMessage;
    private TextView tvWatch;

    Context mContext;

    public HomeItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_pager_list_item);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
        iv01 = $(R.id.iv01);
        iv02 = $(R.id.iv02);
        iv03 = $(R.id.iv03);
        tvNick = $(R.id.tv_nick);
        tvTime = $(R.id.tv_time);
        llImages = $(R.id.ll_images);
        tvContent = $(R.id.tv_content);
        rlContent = $(R.id.rl_content);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        rlBottom = $(R.id.rl_bottom);
        tvAddress = $(R.id.tv_address);
        tvMessage = $(R.id.tv_message);
        tvWatch = $(R.id.tv_watch);
    }

    public void setData(ProductGetPageResponseModel.DataEntity.ContentEntity row) {

        ImageLoader.loadUrlAndDiskCache(mContext, row.getPublicUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvNick.setText(row.getPublicUser().getNickName());
        tvTime.setText(new JTimeTransform(row.getPublicDate()).toString(new RecentDateFormat()));
        tvContent.setText(row.getContent());
        tvNewPrice.setText("￥" + row.getCurrentPrice());
        tvOldPrice.setText("￥" + row.getOriginalPrice());
        tvAddress.setText(row.getAddress());
        tvMessage.setText(row.getReplyNumber() + "");
        tvWatch.setText(row.getBrowseNumber() + "");
        if (row.getProductImageList() == null || row.getProductImageList().size() == 0) {
            llImages.setVisibility(View.GONE);
        } else {
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
        }
    }
}
