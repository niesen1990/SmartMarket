package com.cmbb.smartmarket.activity.wallet.adapter;

import android.content.Context;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.wallet.holder.BalanceDetailItemHolder;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBillListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 13:31
 */
public class BalanceDetailAdapter extends RecyclerArrayAdapter<WalletAccountBillListResponseModel.DataEntity.ContentEntity> {

    public BalanceDetailAdapter(Context context) {
        super(context);
    }

    @Override
    public BaseViewHolder OnCreateViewHolder(ViewGroup parent, int viewType) {
        return new BalanceDetailItemHolder(parent);
    }
}
