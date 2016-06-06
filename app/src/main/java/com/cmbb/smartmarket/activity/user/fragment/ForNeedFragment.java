package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.NeedDetailActivity;
import com.cmbb.smartmarket.activity.user.adapter.ForNeedAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

public class ForNeedFragment extends BaseRecyclerFragment {
    private static final String ARG_PARAM = "userId";
    private int userId;

    public ForNeedFragment() {
        // Required empty public constructor
    }

    public static ForNeedFragment newInstance(int userId) {
        ForNeedFragment fragment = new ForNeedFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, userId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            userId = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        onRefresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_user_center;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new ForNeedAdapter(getActivity());
    }

    @Override
    public void onItemClick(int position) {
        NeedDetailActivity.newIntent(getActivity(), ((ForNeedAdapter) adapter).getItem(position).getId());

    }

    Observer<MarketCenterSelectProductListResponseModel> mMarketCenterSelectProductListResponseModelObserver = new Observer<MarketCenterSelectProductListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MarketCenterSelectProductListResponseModel marketCenterSelectProductListResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketCenterSelectProductListResponseModel.getData().getContent());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().marketCenterSelectProductList(mMarketCenterSelectProductListResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().marketCenterSelectProductList(mMarketCenterSelectProductListResponseModelObserver, setParams());
    }

    private MarketCenterSelectProductListRequestModel setParams() {
        MarketCenterSelectProductListRequestModel marketCenterSelectProductListRequestModel = new MarketCenterSelectProductListRequestModel();
        marketCenterSelectProductListRequestModel.setCmd(ApiInterface.MarketCenterSelectProductList);
        marketCenterSelectProductListRequestModel.setToken(BaseApplication.getToken());
        marketCenterSelectProductListRequestModel.setParameters(new MarketCenterSelectProductListRequestModel.ParametersEntity(0, userId,pagerSize, pager));
        return marketCenterSelectProductListRequestModel;
    }
}
