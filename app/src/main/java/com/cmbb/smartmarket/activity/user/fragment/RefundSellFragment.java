package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.OrderDetailSellRefundActivity;
import com.cmbb.smartmarket.activity.user.adapter.RefundSellAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

public class RefundSellFragment extends BaseRecyclerFragment {
    private static final String ARG_PARAM = "position";
    private static final String TAG = RefundSellFragment.class.getSimpleName();
    private int position;

    Observer<MarketOrderListResponseModel> mMarketOrderListResponseModelObserver = new Observer<MarketOrderListResponseModel>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MarketOrderListResponseModel marketOrderListResponseModel) {
            Log.e(TAG, marketOrderListResponseModel.getMsg());
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketOrderListResponseModel.getData().getContent());
        }
    };

    public RefundSellFragment() {
    }

    public static RefundSellFragment newInstance(int position) {
        RefundSellFragment fragment = new RefundSellFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.global_padding)));
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
        return new RefundSellAdapter(getActivity());
    }

    @Override
    public void onItemClick(int position) {
        OrderDetailSellRefundActivity.newIntent(getActivity(), ((RefundSellAdapter) adapter).getItem(position).getId());
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().marketOrderList(mMarketOrderListResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().marketOrderList(mMarketOrderListResponseModelObserver, setParams());
    }

    private MarketOrderListRequestModel setParams() {
        MarketOrderListRequestModel marketOrderListRequestModel = new MarketOrderListRequestModel();
        marketOrderListRequestModel.setCmd(ApiInterface.MarketOrderList);
        marketOrderListRequestModel.setToken(BaseApplication.getToken());
        MarketOrderListRequestModel.ParametersEntity paramsEntity = new MarketOrderListRequestModel.ParametersEntity();
        paramsEntity.setPageNo(pager);
        paramsEntity.setNumberOfPerPage(pagerSize);
        paramsEntity.setOrderType("refund");
        paramsEntity.setSaleType("sell");
        marketOrderListRequestModel.setParameters(paramsEntity);
        return marketOrderListRequestModel;
    }

}
