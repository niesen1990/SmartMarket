package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListResponseModel;
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
public class ForNeedItemHolder extends BaseViewHolder<MarketCenterSelectProductListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = ForNeedItemHolder.class.getSimpleName();

    private ImageView ivHead;
    private TextView tvNick;
    private TextView tvTime;
    private TextView tvTitle;
    private TextView tvContent;
    private RelativeLayout rlBottom;
    private TextView tvAddress;
    private TextView tvMessage;
    private TextView tvWatch;
    private Context mContext;

    public ForNeedItemHolder(ViewGroup parent) {
        super(parent, R.layout.fragment_user_center_for_need_list_item);
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
    }

    public void setData(MarketCenterSelectProductListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        ImageLoader.loadUrlAndDiskCache(mContext, row.getPublicUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvNick.setText(row.getPublicUser().getNickName());
        tvTime.setText(new JTimeTransform(row.getPublicDate()).toString(new RecentDateFormat()));
        tvTitle.setText(row.getTitle());
        tvContent.setText(row.getContent());
        tvAddress.setText(row.getUserLocation().getCity() + " " + row.getUserLocation().getDistrict());
        tvMessage.setText(row.getReplyNumber() + "");
        tvWatch.setText(row.getBrowseNumber() + "");
    }
}
