package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class ApplyRefundItemHolder extends BaseViewHolder<SystemGetMultipleDictResponseModel.DataEntity.RefundReasonEntity> {
    private final String TAG = ApplyRefundItemHolder.class.getSimpleName();

    TextView item;

    public ApplyRefundItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_apply_refund_list_item);
        item = $(R.id.item);
    }

    public void setData(SystemGetMultipleDictResponseModel.DataEntity.RefundReasonEntity row) {
        item.setText(row.getName());
    }

}
