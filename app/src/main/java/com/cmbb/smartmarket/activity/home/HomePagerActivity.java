package com.cmbb.smartmarket.activity.home;

import android.Manifest;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterViewFlipper;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.BannerAdapter;
import com.cmbb.smartmarket.activity.home.adapter.HomeAdapter;
import com.cmbb.smartmarket.activity.home.adapter.ViewFlipperAdapter;
import com.cmbb.smartmarket.activity.home.model.MarketHomeAdvertInfoRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeAdvertInfoResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeSaveLocationAddressRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeSaveLocationAddressResponseModel;
import com.cmbb.smartmarket.activity.market.DetailSellActivity;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.cmbb.smartmarket.activity.search.SearchActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SPCache;
import com.cmbb.smartmarket.utils.lbs.BaiduLocation;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.PointHintView;
import com.jude.rollviewpager.RollPagerView;

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
    String city;

    AdapterViewFlipper adapterViewFlipper;
    RecyclerArrayAdapter.ItemView head;
    ViewFlipperAdapter mViewFlipperAdapter;
    BannerAdapter mBannerAdapter;
    BroadcastReceiver locationReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            //保存数据
            if (!TextUtils.isEmpty(BaseApplication.getToken()))
                HttpMethod.getInstance().marketHomeSaveLocationAddressRequest(mMarketHomeSaveLocationAddressResponseModelObserver, setLocationParams(intent.getStringExtra("location")));
            city = SPCache.getString(Constants.LOCATION_CITY, "");
            if (TextUtils.isEmpty(city))
                return;
            tvCity.setText(city);
            unSubscribe();
            subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
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
            }
            adapter.addAll(productGetPageResponseModel.getData().getContent());
        }
    };

    Observer<ProductGetPageResponseModel> mProductGetPageResponseModelObserverFlip = new Observer<ProductGetPageResponseModel>() {
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
            adapterViewFlipper.stopFlipping();
            mViewFlipperAdapter.updateEntities(productGetPageResponseModel.getData().getContent());
            adapterViewFlipper.startFlipping();
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

    Observer<MarketHomeAdvertInfoResponseModel> mMarketHomeAdvertInfoResponseModelObserver = new Observer<MarketHomeAdvertInfoResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketHomeAdvertInfoResponseModel marketHomeAdvertInfoResponseModel) {
            if (marketHomeAdvertInfoResponseModel == null)
                return;
            mBannerAdapter.updateList(marketHomeAdvertInfoResponseModel.getData());
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        tvHome.setSelected(true);
        tvCity.setOnClickListener(this);
        city = SPCache.getString(Constants.LOCATION_CITY, "");
        getToolbar().setDisplayHomeAsUpEnabled(false);
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                FrameLayout header = (FrameLayout) LayoutInflater.from(HomePagerActivity.this).inflate(R.layout.activity_home_pager_head02, null);
                RollPagerView rollPagerView = (RollPagerView) header.findViewById(R.id.roll_view_pager);
                rollPagerView.setHintView(new PointHintView(HomePagerActivity.this));
                rollPagerView.setHintPadding(0, 0, 0, 5);
                mBannerAdapter = new BannerAdapter(null);
                rollPagerView.setAdapter(mBannerAdapter);
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
                headerView.findViewById(R.id.head02).setOnClickListener(HomePagerActivity.this);
            }
        };

        adapter.addHeader(head);
        onRefresh();
        //                String target = "niesen714";// 消息接收者ID
        //                Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(target, IMHelper.getAppKey());
        //                startActivity(intent);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if ((requestCode == 4000 || requestCode == 5000) && grantResults.length > 0) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Log.e("product/getPage", "onRequestPermissionsResult");
                BaiduLocation.getInstance().getLocationClient().start();
            } else {
                showToast("关闭定位权限可能影响使用");
            }
        }
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    protected void onResume() {
        super.onResume();
        LocalBroadcastManager.getInstance(this).registerReceiver(locationReceiver, new IntentFilter(Constants.INTENT_ACTION_LOCATION));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED || ContextCompat.checkSelfPermission(this, Manifest.permission.READ_PHONE_STATE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 4000);
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_PHONE_STATE}, 5000);
        } else {
            BaiduLocation.getInstance().getLocationClient().start();
        }
    }

    @Override
    protected void onPause() {
        LocalBroadcastManager.getInstance(this).unregisterReceiver(locationReceiver);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
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
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(v, "title"));
        switch (v.getId()) {
            case R.id.tv_guanfangtuijian:
                OfficialRecommendActivity.newIntent(this, activityOptionsCompat);
                break;
            case R.id.tv_baobaoyongping:
                BabyRecommendActivity.newIntent(this, activityOptionsCompat);
                break;
            case R.id.tv_mamashangping:
                MamiRecommendActivity.newIntent(this, activityOptionsCompat);
                break;
            case R.id.tv_jujiashangping:
                HouseRecommendActivity.newIntent(this, activityOptionsCompat);
                break;
            case R.id.tv_city:
                HomeAddressActivity.newIntent(this, true, 100);
                break;
            case R.id.head02:
                HomeShopActivity.newIntent(this);
                break;
        }
    }

    @Override
    public void onItemClick(View rootView, int position) {
        //        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(rootView.findViewById(R.id.iv01), "iv01"));
        //        CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((HomeAdapter) adapter).getItem(position).getId(),((HomeAdapter) adapter).getItem(position).getProductImageList());
        DetailSellActivity.newIntent(this, ((HomeAdapter) adapter).getItem(position).getId());
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
        HttpMethod.getInstance().marketHomeAdvertInfo(mMarketHomeAdvertInfoResponseModelObserver, setAdParams());
        HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserverFlip, setFlipperParams());
    }

    private MarketHomeAdvertInfoRequestModel setAdParams() {
        MarketHomeAdvertInfoRequestModel marketHomeAdvertInfoRequestModel = new MarketHomeAdvertInfoRequestModel();
        marketHomeAdvertInfoRequestModel.setCmd(ApiInterface.MarketHomeAdvertInfo);
        marketHomeAdvertInfoRequestModel.setParameters(new MarketHomeAdvertInfoRequestModel.ParametersEntity("INDEX"));
        return marketHomeAdvertInfoRequestModel;
    }

    private MarketHomeSaveLocationAddressRequestModel setLocationParams(String locationJson) {
        MarketHomeSaveLocationAddressRequestModel marketHomeSaveLocationAddressRequestModel = new MarketHomeSaveLocationAddressRequestModel();
        marketHomeSaveLocationAddressRequestModel.setCmd(ApiInterface.MarketHomeSaveLocationAddress);
        marketHomeSaveLocationAddressRequestModel.setToken(BaseApplication.getToken());
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
        productGetPageRequestModel.setCmd(ApiInterface.ProductGetPage);
        productGetPageRequestModel.setParameters(new ProductGetPageRequestModel.ParametersEntity(pagerSize, pager, 0, city));
        return productGetPageRequestModel;
    }

    protected ProductGetPageRequestModel setFlipperParams() {
        ProductGetPageRequestModel productGetPageRequestModel = new ProductGetPageRequestModel();
        productGetPageRequestModel.setCmd(ApiInterface.ProductGetPage);
        productGetPageRequestModel.setParameters(new ProductGetPageRequestModel.ParametersEntity(pagerSize, pager, 1));
        return productGetPageRequestModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        /*if (requestCode == 100 && resultCode == -1) {
            Log.i(TAG, data.getBooleanExtra("need_compress", false) + "");
            ArrayList<String> selectedList = data.getStringArrayListExtra("result_list");
            for (String result : selectedList) {
                Log.i(TAG, result);
            }
            //            WxDefaultExecutor.getInstance().submitHttp((new PictureCompressThread(selectedList, this)).setNeedCompress(data.getBooleanExtra("need_compress", false)));
        }*/
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            //地址选择返回数据
            city = data.getStringExtra("city");
            tvCity.setText(city);
            subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomePagerActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}