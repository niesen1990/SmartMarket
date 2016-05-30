package com.cmbb.smartmarket.activity.search;

import android.app.SearchManager;
import android.app.SearchableInfo;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.provider.SearchRecentSuggestions;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.SearchView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.search.adapter.SearchAdapter;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchRequestModel;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/21 下午4:09
 */
public class SearchActivity extends BaseRecyclerActivity {

    private static final String TAG = SearchActivity.class.getSimpleName();
    private SearchView searchView;
    private Handler mHandler = new Handler();
    Observer<MarketHomeSearchResponseModel> mMarketHomeSearchRequestModelObserver = new Observer<MarketHomeSearchResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {

        }

        @Override
        public void onNext(MarketHomeSearchResponseModel marketHomeSearchResponseModel) {
            if (marketHomeSearchResponseModel != null) {
                adapter.clear();
                adapter.addAll(marketHomeSearchResponseModel.getData().getContent());
            }
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        initView();
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(final String newText) {
                unSubscribe();
                mHandler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        subscription = HttpMethod.getInstance().marketHomeSearch(mMarketHomeSearchRequestModelObserver, setSearchParams(newText));
                    }
                }, 500);
                return true;
            }
        });
    }

    private MarketHomeSearchRequestModel setSearchParams(String newText) {
        MarketHomeSearchRequestModel marketHomeSearchRequestModel = new MarketHomeSearchRequestModel();
        marketHomeSearchRequestModel.setCmd(ApiInterface.MarketHomeSearch);
        marketHomeSearchRequestModel.setToken(BaseApplication.getToken());
        marketHomeSearchRequestModel.setParameters(new MarketHomeSearchRequestModel.ParametersEntity(newText, "0"));
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
        super.onNewIntent(intent);
        if (Intent.ACTION_SEARCH.equals(intent.getAction())) {
            String query = intent.getStringExtra(SearchManager.QUERY);
            Log.i(TAG, query);
            SearchRecentSuggestions suggestions = new SearchRecentSuggestions(this, SearchRecentProvider.AUTHORITY, SearchRecentProvider.MODE);
            suggestions.saveRecentQuery(query, null);
        }
    }

    protected void initView() {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        searchView = (SearchView) findViewById(R.id.search_view);
        SearchManager mSearchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
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
                Log.i(TAG, newText);
                return false;
            }
        });
        searchView.setOnSearchClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, "setOnSearchClickListener");
            }
        });
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
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, SearchActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
