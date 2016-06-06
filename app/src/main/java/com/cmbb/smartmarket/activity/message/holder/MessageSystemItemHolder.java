package com.cmbb.smartmarket.activity.message.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetPageResponseModel;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class MessageSystemItemHolder extends BaseViewHolder<MarketMessageGetPageResponseModel.DataEntity.ContentEntity> {
    private final String TAG = MessageSystemItemHolder.class.getSimpleName();

    private TextView tvTitle;
    private TextView tvTime;
    private TextView tvContent;
    private Context mContext;

    public MessageSystemItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_message_system_list_item);
        mContext = parent.getContext();
        tvTitle = $(R.id.tv_title);
        tvTime = $(R.id.tv_time);
        tvContent = $(R.id.tv_content);
    }

    public void setData(MarketMessageGetPageResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        tvTitle.setText(row.getTitle());
        tvTime.setText(new JTimeTransform(row.getCreateDate()).toString(new RecentDateFormat()));
        tvContent.setText(row.getContents());
    }
}
