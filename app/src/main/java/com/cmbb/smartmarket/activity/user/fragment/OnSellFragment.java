package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.user.adapter.OnSellAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

public class OnSellFragment extends BaseRecyclerFragment {
    private static final String ARG_PARAM = "userId";
    private int userId;

    public OnSellFragment() {
        // Required empty public constructor
    }

    public static OnSellFragment newInstance(int userId) {
        OnSellFragment fragment = new OnSellFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, userId);
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
        return new OnSellAdapter(getActivity());
    }

    @Override
    public void onItemClick(View rootView, int position) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), Pair.create(rootView.findViewById(R.id.iv_pic), "iv01"));
        CommodityDetailActivity.newIntent((BaseActivity) getActivity(), activityOptionsCompat, ((OnSellAdapter) adapter).getItem(position).getId(),((OnSellAdapter) adapter).getItem(position).getProductImageList());
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
        marketCenterSelectProductListRequestModel.setParameters(new MarketCenterSelectProductListRequestModel.ParametersEntity(0, userId, "0", pagerSize, pager));
        return marketCenterSelectProductListRequestModel;
    }
}
