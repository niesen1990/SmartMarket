package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.AddressManagerActivity;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/11 下午1:27
 * 修改人：N.Sun
 * 修改时间：16/5/11 下午1:27
 * 修改备注：
 */
public class BuyOrderActivity extends BaseActivity {

    @BindView(R.id.ll_head)
    LinearLayout llHead;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_price)
    RelativeLayout rlPrice;
    @BindView(R.id.tv_new_price)
    TextView tvNewPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_line)
    TextView tvLine;
    @BindView(R.id.tv_deal_way)
    TextView tvDealWay;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_detail_address)
    TextView tvDetailAddress;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_express_tag)
    TextView tvExpressTag;
    @BindView(R.id.tv_express)
    TextView tvExpress;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("购买宝贝");
        ivRight.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_order_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.iv_right:
                AddressManagerActivity.newIntent(this);
                break;
            case R.id.tv_confirm:
                PayActivity.newIntent(this);
                break;
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, BuyOrderActivity.class);
        context.startActivity(intent);
    }
}
