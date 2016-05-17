package com.cmbb.smartmarket.base;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 下午12:29
 * 修改人：N.Sun
 * 修改时间：16/5/6 下午12:29
 * 修改备注：
 */
public abstract class BaseRecyclerFragment extends BaseFragment implements RecyclerArrayAdapter.OnLoadMoreListener, SwipeRefreshLayout.OnRefreshListener, RecyclerArrayAdapter.OnItemClickListener {
    protected RecyclerArrayAdapter adapter;
    protected EasyRecyclerView mSmartRecyclerView;
    protected int pager = 0;
    protected int pagerSize = 10;

    @Override
    protected void initView(View view) {
        initRecyclerView(view);
    }

    protected void initRecyclerView(View view) {
        mSmartRecyclerView = (EasyRecyclerView) view.findViewById(R.id.recyclerView);
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

    public EasyRecyclerView getSmartRecyclerView() {
        return mSmartRecyclerView;
    }

    public void setSmartRecyclerView(EasyRecyclerView smartRecyclerView) {
        mSmartRecyclerView = smartRecyclerView;
    }

    protected RecyclerView.LayoutManager setLayoutManager() {
        return new LinearLayoutManager(getActivity());
    }

    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
    }

    protected abstract RecyclerArrayAdapter initAdapter();
}
