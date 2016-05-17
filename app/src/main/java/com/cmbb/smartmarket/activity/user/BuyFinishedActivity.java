package com.cmbb.smartmarket.activity.user;

import android.os.Bundle;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.BuyFinishedAdapter;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 下午3:28
 * 修改人：N.Sun
 * 修改时间：16/5/6 下午3:28
 * 修改备注：
 */
public class BuyFinishedActivity extends BaseRecyclerActivity {
    private static final String TAG = BuyFinishedActivity.class.getSimpleName();

    @Override
    protected void initView(Bundle savedInstanceState) {

    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new BuyFinishedAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_finished_layout;
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

}
