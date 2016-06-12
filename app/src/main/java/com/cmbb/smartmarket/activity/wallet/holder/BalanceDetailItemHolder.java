package com.cmbb.smartmarket.activity.wallet.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBillListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class BalanceDetailItemHolder extends BaseViewHolder<WalletAccountBillListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = BalanceDetailItemHolder.class.getSimpleName();

    private TextView tvStatusTag;
    private TextView tvTime;
    private TextView tvStatus;
    private TextView tvCount;

    public BalanceDetailItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_balance_detail_list_item);
        tvStatusTag = $(R.id.tv_status_tag);
        tvTime = $(R.id.tv_time);
        tvStatus = $(R.id.tv_status);
        tvCount = $(R.id.tv_count);
    }

    public void setData(WalletAccountBillListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        tvStatus.setText(row.getStatusName());
        tvStatusTag.setText(row.getBusinessDetail());
        tvTime.setText(row.getCreateDate());
        tvCount.setText(row.getViewBalance() + "");
    }
}
