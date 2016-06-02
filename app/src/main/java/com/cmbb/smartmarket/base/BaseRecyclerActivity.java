package com.cmbb.smartmarket.base;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cmbb.smartmarket.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/20 下午4:12
 */
public abstract class BaseRecyclerActivity extends BaseActivity implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener, AppBarLayout.OnOffsetChangedListener {
    protected RecyclerArrayAdapter adapter;
    AppBarLayout appBarLayout;
    protected EasyRecyclerView mSmartRecyclerView;
    protected int pager = 0;
    protected int pagerSize = 10;

    BroadcastReceiver refreshReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            onRefresh();
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        initRecyclerView();
        initView(savedInstanceState);
    }

    protected void initRecyclerView() {
        if (findViewById(R.id.abl) != null)
            appBarLayout = (AppBarLayout) findViewById(R.id.abl);
        mSmartRecyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        if (mSmartRecyclerView == null)
            return;
        adapter = initAdapter();
        mSmartRecyclerView.setLayoutManager(setLayoutManager());
        if (adapter == null)
            return;
        mSmartRecyclerView.setAdapterWithProgress(adapter);
        setSpaceDecoration(mSmartRecyclerView);
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setOnItemClickListener(this);
        mSmartRecyclerView.setRefreshListener(this);
    }

    protected RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(this);
    }

    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract RecyclerArrayAdapter initAdapter();

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(refreshReceiver, new IntentFilter(Constants.INTENT_ACTION_REFRESH));
        if (appBarLayout != null)
            appBarLayout.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        LocalBroadcastManager.getInstance(this).unregisterReceiver(refreshReceiver);
        if (appBarLayout != null)
            appBarLayout.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mSmartRecyclerView == null)
            return;
        if (verticalOffset >= 0) {
            mSmartRecyclerView.getSwipeToRefresh().setEnabled(true);
        } else {
            mSmartRecyclerView.getSwipeToRefresh().setEnabled(false);
        }
    }
}
