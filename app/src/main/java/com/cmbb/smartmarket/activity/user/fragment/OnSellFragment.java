package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
import com.cmbb.smartmarket.activity.user.adapter.OnSellAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

public class OnSellFragment extends BaseRecyclerFragment {
    private static final String ARG_PARAM = "position";
    private int position;

    public OnSellFragment() {
        // Required empty public constructor
    }

    public static OnSellFragment newInstance(int position) {
        OnSellFragment fragment = new OnSellFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected RecyclerView.LayoutManager setLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(), 2);
        gridLayoutManager.setSpanSizeLookup(adapter.obtainGridSpanSizeLookUp(2));
        return gridLayoutManager;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        onRefresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sell_refund;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new OnSellAdapter(getActivity());
    }

    @Override
    public void onItemClick(int position) {

    }

    Observer<TestModel> mTestUserAttentionModelObserver = new Observer<TestModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(TestModel testModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(testModel.getData().getRows());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().getTestData(mTestUserAttentionModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().getTestData(mTestUserAttentionModelObserver, setParams());
    }

    /**
     * 设置参数
     *
     * @return params
     */
    protected TestRequestModel setParams() {
        unSubscribe();
        TestRequestModel testRequestModel = new TestRequestModel();
        testRequestModel.setCmd("smart/attention/getList");
        testRequestModel.setToken(BaseApplication.getToken());
        testRequestModel.setParameters(new TestRequestModel.ParametersEntity(pager, pagerSize, 0));
        return testRequestModel;
    }
}