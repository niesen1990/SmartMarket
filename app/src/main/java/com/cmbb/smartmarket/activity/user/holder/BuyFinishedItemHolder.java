package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.ApplyRefundActivity;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class BuyFinishedItemHolder extends BaseViewHolder<MarketOrderListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = BuyFinishedItemHolder.class.getSimpleName();

    private RelativeLayout rl01;
    private TextView tvOrderTag;
    private TextView tvOrder;
    private TextView tvStatus;
    private RelativeLayout rl02;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvContact;
    private TextView tvStatus01;
    private TextView tvStatus02;
    private Context mContext;

    public BuyFinishedItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_buy_finished_list_item);
        mContext = parent.getContext();
        tvStatus01 = $(R.id.tv_status_01);
    }

    public void setData(final MarketOrderListResponseModel.DataEntity.ContentEntity row) {
        tvStatus01.setText("申请退款");
        tvStatus01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ApplyRefundActivity.newIntent(mContext, row.getOrderCode());
            }
        });
    }

}
