package com.cmbb.smartmarket.activity.user.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateListResponseModel;
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
public class EvaluateListItemHolder extends BaseViewHolder<MarketEvaluateListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = EvaluateListItemHolder.class.getSimpleName();

    private ImageView ivHead;
    private TextView tvFrom;
    private TextView tvContent;
    private TextView tvTime;
    private TextView tvAddEvaluate;

    private Context mContext;

    public EvaluateListItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_evaluate_list_item);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
        tvFrom = $(R.id.tv_from);
        tvContent = $(R.id.tv_content);
        tvTime = $(R.id.tv_time);
        tvAddEvaluate = $(R.id.tv_add_evaluate);
    }

    public void setData(MarketEvaluateListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        ImageLoader.loadUrlAndDiskCache(mContext, row.getEvaluateUser().getUserImg(), ivHead, new CircleTransform(mContext));
        tvFrom.setText(row.getEvaluateUser().getNickName());
        tvContent.setText(row.getContent());
        tvTime.setText(new JTimeTransform(row.getEvaluateDate()).toString(new RecentDateFormat()));
        tvAddEvaluate.setText(row.getChildCount() + "追加");
    }
}
