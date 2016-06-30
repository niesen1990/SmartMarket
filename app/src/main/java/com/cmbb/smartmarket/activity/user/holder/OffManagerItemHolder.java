package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.PublishActivity;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class OffManagerItemHolder extends BaseViewHolder<MyselfProductPublicListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = OffManagerItemHolder.class.getSimpleName();

    private BaseRecyclerActivity mContext;

    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvOperation;
    private TextView tvStatus;

    public OffManagerItemHolder(ViewGroup parent, Context context) {
        super(parent, R.layout.activity_off_manager_list_item);
        mContext = (BaseRecyclerActivity) context;
        ivImage = $(R.id.iv_image);
        tvTitle = $(R.id.tv_title);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        tvOperation = $(R.id.tv_operation);
        tvStatus = $(R.id.tv_status);
    }

    public void setData(final MyselfProductPublicListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        if (row.getProductImageList() != null && row.getProductImageList().size() > 0)
            ImageLoader.loadCenterCropCache(mContext, row.getProductImageList().get(0).getLocation(), ivImage);
        tvTitle.setText(row.getTitle());
        tvStatus.setText(row.getProductStatusText());
        tvNewPrice.setText("￥" + row.getCurrentPrice());
        tvOldPrice.setText("￥" + row.getOriginalPrice());
        tvOperation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PublishActivity.newIntent(mContext, row.getId(), "0");
            }
        });
    }

}
