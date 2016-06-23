package com.cmbb.smartmarket.activity.search;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.SearchView;
import android.widget.Spinner;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.market.NeedDetailActivity;
import com.cmbb.smartmarket.activity.search.adapter.SearchAdapter;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchRequestModel;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/21 下午4:09
 */
public class SearchActivity extends BaseRecyclerActivity {
    private static final String TAG = SearchActivity.class.getSimpleName();
    @BindView(R.id.search_view)
    SearchView searchView;
    @BindView(R.id.sp_search)
    Spinner spSearch;
    int type;
    private Handler mHandler = new Handler();
    Observer<MarketHomeSearchResponseModel> mMarketHomeSearchRequestModelObserver = new Observer<MarketHomeSearchResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketHomeSearchResponseModel marketHomeSearchResponseModel) {
            if (marketHomeSearchResponseModel != null) {

                if (pager == 0)
                    adapter.clear();
                adapter.addAll(marketHomeSearchResponseModel.getData().getContent());
            }
        }
    };

    static String content;

    @Override
    protected void initView(Bundle savedInstanceState) {
        initView();
    }

    private MarketHomeSearchRequestModel setSearchParams(String newText) {
        MarketHomeSearchRequestModel marketHomeSearchRequestModel = new MarketHomeSearchRequestModel();
        marketHomeSearchRequestModel.setCmd(ApiInterface.MarketHomeSearch);
        marketHomeSearchRequestModel.setToken(BaseApplication.getToken());
        marketHomeSearchRequestModel.setParameters(new MarketHomeSearchRequestModel.ParametersEntity(newText, type, pagerSize, pager));
        return marketHomeSearchRequestModel;
    }

    @Override
    protected RecyclerView.LayoutManager setLayoutManager() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        gridLayoutManager.setSpanSizeLookup(adapter.obtainGridSpanSizeLookUp(2));
        return gridLayoutManager;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new SearchAdapter(this);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.i(TAG, query);
            searchView.setQuery(query, false);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(SearchActivity.this, SearchRecentProvider.AUTHORITY, SearchRecentProvider.MODE);
            suggestions.saveRecentQuery(query, null);
        }
    }

    protected void initView() {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        int searchCloseButtonId = searchView.getContext().getResources().getIdentifier("android:id/search_close_btn", null, null);
        this.searchView.findViewById(searchCloseButtonId).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchView.setQuery("", false);
            }
        });
        final SearchManager mSearchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchableInfo info = mSearchManager.getSearchableInfo(getComponentName());
        searchView.setSearchableInfo(info); // 需要在Xml文件加下建立searchable.xml,搜索框配置文件
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                Log.i(TAG, query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                unSubscribe();
                content = newText;

                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        subscription = HttpMethod.getInstance().marketHomeSearch(mMarketHomeSearchRequestModelObserver, setSearchParams(content));
                    }
                }, 500);
                return true;
            }
        });
        spSearch.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                type = position;
                subscription = HttpMethod.getInstance().marketHomeSearch(mMarketHomeSearchRequestModelObserver, setSearchParams(content));
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        mSmartRecyclerView.showEmpty();
    }

    /**
     * 清楚搜索记录
     */
    private void clearRecentSearch() {
        SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this, SearchRecentProvider.AUTHORITY, SearchRecentProvider.MODE);
        suggestions.clearHistory();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_search_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
    }

    @Override
    public void onItemClick(View rootView, int position) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(rootView.findViewById(R.id.iv_pic), "iv01"));
        switch (type) {
            case 0:
                CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((MarketHomeSearchResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getId(), ((MarketHomeSearchResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getProductImageList());
                break;
            case 1:
                NeedDetailActivity.newIntent(this, activityOptionsCompat,((MarketHomeSearchResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getId(),((MarketHomeSearchResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getProductImageList());
                break;
            case 2:
                CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((MarketHomeSearchResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getId(), ((MarketHomeSearchResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getProductImageList());
                break;
        }
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().marketHomeSearch(mMarketHomeSearchRequestModelObserver, setSearchParams(content));
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().marketHomeSearch(mMarketHomeSearchRequestModelObserver, setSearchParams(content));
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
