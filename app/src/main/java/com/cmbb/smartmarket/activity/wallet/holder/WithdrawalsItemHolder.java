package com.cmbb.smartmarket.activity.wallet.holder;

import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class WithdrawalsItemHolder extends BaseViewHolder<WalletAccountBindListResponseModel.DataEntity> {
    private final String TAG = WithdrawalsItemHolder.class.getSimpleName();

    private ImageView tvZhifubao;
    private TextView tvName;
    private TextView tvAccount;

    public WithdrawalsItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_withdrawals_list_item);
        tvZhifubao = $(R.id.tv_zhifubao);
        tvName = $(R.id.tv_name);
        tvAccount = $(R.id.tv_account);
    }

    public void setData(WalletAccountBindListResponseModel.DataEntity row) {
        tvName.setText(row.getCardUsername());
        tvAccount.setText(row.getCardCode());
    }
}
