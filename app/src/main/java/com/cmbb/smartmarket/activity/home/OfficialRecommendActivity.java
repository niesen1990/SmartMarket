package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.HomeRecommendAdapter;
import com.cmbb.smartmarket.activity.home.model.MarketHomeRecommendationRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeRecommendationResponseModel;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/4 下午1:27
 * 修改人：N.Sun
 * 修改时间：16/5/4 下午1:27
 * 修改备注：
 */
public class OfficialRecommendActivity extends BaseRecyclerActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("官方推荐");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new HomeRecommendAdapter(this);
    }

    @Override
    protected RecyclerView.LayoutManager setLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(adapter.obtainGridSpanSizeLookUp(2));
        return gridLayoutManager;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_official_recommend_layout;
    }

    @Override
    public void onItemClick(int position) {
        CommodityDetailActivity.newIntent(this, ((HomeRecommendAdapter) adapter).getItem(position).getId());
    }

    Observer<MarketHomeRecommendationResponseModel> mMarketHomeRecommendationResponseModelObserver = new Observer<MarketHomeRecommendationResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MarketHomeRecommendationResponseModel marketHomeRecommendationResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketHomeRecommendationResponseModel.getData().getContent());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().marketHomeRecommendation(mMarketHomeRecommendationResponseModelObserver, setParams());
    }

    private MarketHomeRecommendationRequestModel setParams() {
        MarketHomeRecommendationRequestModel marketHomeRecommendationRequestModel = new MarketHomeRecommendationRequestModel();
        marketHomeRecommendationRequestModel.setToken(BaseApplication.getToken());
        marketHomeRecommendationRequestModel.setCmd(ApiInterface.MarketHomeRecommendation);
        marketHomeRecommendationRequestModel.setParameters(new MarketHomeRecommendationRequestModel.ParametersEntity(1, 0, pagerSize, pager));
        return marketHomeRecommendationRequestModel;
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().marketHomeRecommendation(mMarketHomeRecommendationResponseModelObserver, setParams());
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, OfficialRecommendActivity.class);
        context.startActivity(intent);
    }
}
