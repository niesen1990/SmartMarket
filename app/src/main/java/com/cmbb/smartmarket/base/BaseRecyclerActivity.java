package com.cmbb.smartmarket.base;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cmbb.smartkids.recyclerview.SmartRecyclerView;
import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/20 下午4:12
 */
public abstract class BaseRecyclerActivity extends BaseActivity implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {
    protected RecyclerArrayAdapter adapter;
    protected SmartRecyclerView mSmartRecyclerView;
    protected int pager = 0;
    protected int pagerSize = 10;

    @Override
    protected void init(Bundle savedInstanceState) {
        initRecyclerView();
        initView(savedInstanceState);
    }

    private void initRecyclerView() {
        mSmartRecyclerView = (SmartRecyclerView) findViewById(R.id.recyclerView);
        if (mSmartRecyclerView == null) return;
        mSmartRecyclerView.setLayoutManager(setLayoutManager());
        adapter = initAdapter();
        if (adapter == null) return;
        mSmartRecyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, this);
        adapter.setNoMore(R.layout.view_nomore);
        adapter.setOnItemClickListener(this);
        mSmartRecyclerView.setRefreshListener(this);
        mSmartRecyclerView.showEmpty();
    }

    protected RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(this);
    }

    protected abstract void initView(Bundle savedInstanceState);

    protected abstract RecyclerArrayAdapter initAdapter();
}
