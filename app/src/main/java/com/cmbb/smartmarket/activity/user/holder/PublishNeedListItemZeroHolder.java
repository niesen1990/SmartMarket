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
public class PublishNeedListItemZeroHolder extends BaseViewHolder<MyselfProductPublicListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = PublishNeedListItemZeroHolder.class.getSimpleName();

    private ImageView ivHead;
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

    public PublishNeedListItemZeroHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_pager_list_item_zero);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
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
        ImageLoader.loadUrlAndDiskCache(mContext, row.getPublicUser().getUserImg(), ivHead, new CircleTransform(mContext));
        rlContent.setVisibility(View.GONE);
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
    }
}
