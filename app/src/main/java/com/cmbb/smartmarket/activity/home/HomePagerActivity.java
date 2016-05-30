package com.cmbb.smartmarket.activity.home;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.BannerAdapter;
import com.cmbb.smartmarket.activity.home.adapter.HomeAdapter;
import com.cmbb.smartmarket.activity.home.adapter.ViewFlipperAdapter;
import com.cmbb.smartmarket.activity.home.model.MarketHomeSaveLocationAddressRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeSaveLocationAddressResponseModel;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.cmbb.smartmarket.activity.search.SearchActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.TDevice;
import com.cmbb.smartmarket.utils.lbs.BaiduLocation;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.PointHintView;
import com.jude.rollviewpager.RollPagerView;

import java.util.ArrayList;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：主页(Home)
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:34
 */
public class HomePagerActivity extends BaseHomeActivity {
    private static final String TAG = HomePagerActivity.class.getSimpleName();

    @BindView(R.id.tv_city)
    TextView tvCity;

    AdapterViewFlipper adapterViewFlipper;
    RecyclerArrayAdapter.ItemView head;
    ViewFlipperAdapter mViewFlipperAdapter;
    BroadcastReceiver locationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            subscription = HttpMethod.getInstance().marketHomeSaveLocationAddressRequest(mMarketHomeSaveLocationAddressResponseModelObserver, setLocationParams(intent.getStringExtra("location")));
        }
    };
    Observer<ProductGetPageResponseModel> mProductGetPageResponseModelObserver = new Observer<ProductGetPageResponseModel>() {
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
        public void onNext(ProductGetPageResponseModel productGetPageResponseModel) {
            if (pager == 0) {
                adapter.clear();
                //                adapterViewFlipper.stopFlipping();
                //                mViewFlipperAdapter.updateEntities(productGetPageResponseModel.getData().getContent());
                //                adapterViewFlipper.startFlipping();
            }
            adapter.addAll(productGetPageResponseModel.getData().getContent());
        }
    };

    Observer<MarketHomeSaveLocationAddressResponseModel> mMarketHomeSaveLocationAddressResponseModelObserver = new Observer<MarketHomeSaveLocationAddressResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketHomeSaveLocationAddressResponseModel marketHomeSaveLocationAddressResponseModel) {
            Log.i(TAG, "location save = " + marketHomeSaveLocationAddressResponseModel.getMsg());
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvHome.setSelected(true);
        setTitle(getString(R.string.title_home_pager_title));
        tvCity.setOnClickListener(this);
        getToolbar().setDisplayHomeAsUpEnabled(false);
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                RollPagerView header = new RollPagerView(HomePagerActivity.this);
                header.setHintView(new PointHintView(HomePagerActivity.this));
                header.setHintPadding(0, 0, 0, TDevice.dip2px(8, HomePagerActivity.this));
                header.setPlayDelay(2000);
                header.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, TDevice.dip2px(163, HomePagerActivity.this)));
                header.setAdapter(new BannerAdapter());
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        head = new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                RelativeLayout header = (RelativeLayout) LayoutInflater.from(HomePagerActivity.this).inflate(R.layout.activity_home_pager_head01, null);
                header.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                adapterViewFlipper = (AdapterViewFlipper) header.findViewById(R.id.adapterViewFlipper);
                mViewFlipperAdapter = new ViewFlipperAdapter();
                adapterViewFlipper.setAdapter(mViewFlipperAdapter);
                return header;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.findViewById(R.id.tv_guanfangtuijian).setOnClickListener(HomePagerActivity.this);
                headerView.findViewById(R.id.tv_baobaoyongping).setOnClickListener(HomePagerActivity.this);
                headerView.findViewById(R.id.tv_mamashangping).setOnClickListener(HomePagerActivity.this);
                headerView.findViewById(R.id.tv_jujiashangping).setOnClickListener(HomePagerActivity.this);

            }
        };

        adapter.addHeader(head);
        onRefresh();
        //                String target = "niesen714";// 消息接收者ID
        //                Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(target, IMHelper.getAppKey());
        //                startActivity(intent);
        BaiduLocation.getInstance().getLocationClient().start();
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(locationReceiver, new IntentFilter(Constants.INTENT_ACTION_LOCATION));
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        BaiduLocation.getInstance().getLocationClient().stop();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new HomeAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_pager;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_page, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                SearchActivity.newIntent(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_guanfangtuijian:
                OfficialRecommendActivity.newIntent(this);
                break;
            case R.id.tv_baobaoyongping:
                BabyRecommendActivity.newIntent(this);
                break;
            case R.id.tv_mamashangping:
                MamiRecommendActivity.newIntent(this);
                break;
            case R.id.tv_jujiashangping:
                HouseRecommendActivity.newIntent(this);
                break;
            case R.id.tv_city:
                HomeAddressActivity.newIntent(this, 100);
                break;
        }

    }

    @Override
    public void onItemClick(int position) {
        CommodityDetailActivity.newIntent(this, ((HomeAdapter) adapter).getItem(position).getId());
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
    }

    private MarketHomeSaveLocationAddressRequestModel setLocationParams(String locationJson) {
        MarketHomeSaveLocationAddressRequestModel marketHomeSaveLocationAddressRequestModel = new MarketHomeSaveLocationAddressRequestModel();
        marketHomeSaveLocationAddressRequestModel.setToken(BaseApplication.getToken());
        marketHomeSaveLocationAddressRequestModel.setCmd(ApiInterface.MarketHomeSaveLocationAddress);
        marketHomeSaveLocationAddressRequestModel.setParameters(new MarketHomeSaveLocationAddressRequestModel.ParametersEntity(locationJson));
        return marketHomeSaveLocationAddressRequestModel;
    }

    /**
     * 设置参数
     *
     * @return params
     */
    protected ProductGetPageRequestModel setParams() {
        unSubscribe();
        ProductGetPageRequestModel productGetPageRequestModel = new ProductGetPageRequestModel();
        productGetPageRequestModel.setToken(BaseApplication.getToken());
        productGetPageRequestModel.setCmd(ApiInterface.ProductGetPage);
        productGetPageRequestModel.setParameters(new ProductGetPageRequestModel.ParametersEntity(pagerSize, pager, 0, "", ""));
        return productGetPageRequestModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == -1) {
            Log.i(TAG, data.getBooleanExtra("need_compress", false) + "");
            ArrayList<String> selectedList = data.getStringArrayListExtra("result_list");
            for (String result : selectedList) {
                Log.i(TAG, result);
            }
            //            WxDefaultExecutor.getInstance().submitHttp((new PictureCompressThread(selectedList, this)).setNeedCompress(data.getBooleanExtra("need_compress", false)));
        }
        super.onActivityResult(requestCode, resultCode, data);
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomePagerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }

}