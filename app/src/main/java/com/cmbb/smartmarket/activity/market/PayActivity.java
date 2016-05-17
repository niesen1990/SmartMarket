package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.PayReplayAdapter;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/11 下午2:05
 * 修改人：N.Sun
 * 修改时间：16/5/11 下午2:05
 * 修改备注：
 */
public class PayActivity extends BaseRecyclerActivity {

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("确认支付");
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new PayReplayAdapter(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, PayActivity.class);
        context.startActivity(intent);
    }
}
