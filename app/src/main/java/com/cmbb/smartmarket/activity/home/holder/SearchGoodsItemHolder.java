package com.cmbb.smartmarket.activity.home.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchResponseModel;
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
public class SearchGoodsItemHolder extends BaseViewHolder<MarketHomeSearchResponseModel.DataEntity.ContentEntity> {
    private final String TAG = SearchGoodsItemHolder.class.getSimpleName();

    private ImageView ivPic;
    private TextView tvContent;
    private RelativeLayout rlContent;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private RelativeLayout rlBottom;
    private TextView tvAddress;
    private TextView tvTime;
    private Context mContext;

    public SearchGoodsItemHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_user_center_on_sell_list_item);
        mContext = parent.getContext();
        ivPic = $(R.id.iv_pic);
        tvContent = $(R.id.tv_content);
        rlContent = $(R.id.rl_content);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        rlBottom = $(R.id.rl_bottom);
        tvAddress = $(R.id.tv_address);
        tvTime = $(R.id.tv_time);
    }

    public void setData(MarketHomeSearchResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        if (row.getProductImageList() != null && row.getProductImageList().size() > 0)
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), ivPic);
        tvContent.setText(row.getTitle());
        tvNewPrice.setText("￥" + row.getCurrentPrice());
        if (row.getOriginalPrice() == 0) {
            tvOldPrice.setVisibility(View.INVISIBLE);
        } else {
            tvOldPrice.setVisibility(View.INVISIBLE);
            tvOldPrice.setText("￥" + row.getOriginalPrice());
        }
        tvAddress.setText(row.getUserLocation().getCity() + " " + row.getUserLocation().getDistrict());
        tvTime.setText(new JTimeTransform(row.getPublicDate()).toString(new RecentDateFormat()));
    }
}