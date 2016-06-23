package com.cmbb.smartmarket.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.HomeRecommendAdapter;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetScreenRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetScreenResponseModel;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.market.model.CodeInfoListRequestModel;
import com.cmbb.smartmarket.activity.market.model.CodeInfoListResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.TDevice;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/3 上午11:16
 * 修改人：N.Sun
 * 修改时间：16/6/3 上午11:16
 * 修改备注：
 */
public abstract class BaseRecommendActivity extends BaseRecyclerActivity {
    private static final String TAG = BaseRecommendActivity.class.getSimpleName();

    @BindView(R.id.tv01)
    TextView tv01;
    @BindView(R.id.tv02)
    TextView tv02;
    @BindView(R.id.tv03)
    TextView tv03;
    @BindView(R.id.tv04)
    TextView tv04;
    @BindView(R.id.ll_choice)
    LinearLayout llChoice;

    String parentClassify;
    String secondClassify;
    String city;
    String beginPrice;
    String endPrice;
    String sortType;
    ArrayAdapter<MarketHomeGetScreenResponseModel.DataEntity.IntelligentClassifyEntity> mStringArrayAdapter4;
    ListPopupWindow listPopupWindow4;

    ArrayAdapter<CodeInfoListResponseModel.DataEntity> mStringArrayAdapter2;
    ListPopupWindow listPopupWindow2;

    PopupWindow popupWindow;
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
            if (pager == 0)
                adapter.clear();
            adapter.addAll(productGetPageResponseModel.getData().getContent());
        }
    };

    Observer<ProductGetPageResponseModel> mProductGetPageResponseModelObserverFresh = new Observer<ProductGetPageResponseModel>() {
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
            if (pager == 0)
                adapter.clear();

            if (productGetPageResponseModel.getData().getContent() == null || productGetPageResponseModel.getData().getContent().size() == 0) {
                adapter.clear();
            } else {
                adapter.addAll(productGetPageResponseModel.getData().getContent());
            }
        }
    };

    Observer<CodeInfoListResponseModel> mCodeInfoListResponseModelObserver = new Observer<CodeInfoListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(CodeInfoListResponseModel codeInfoListResponseModel) {
            if (codeInfoListResponseModel == null)
                return;
            mStringArrayAdapter2.clear();
            codeInfoListResponseModel.getData().add(0, new CodeInfoListResponseModel.DataEntity("全部", ""));
            mStringArrayAdapter2.addAll(codeInfoListResponseModel.getData());
        }
    };

    Observer<MarketHomeGetScreenResponseModel> mMarketHomeGetScreenResponseModelObserver = new Observer<MarketHomeGetScreenResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketHomeGetScreenResponseModel marketHomeGetScreenResponseModel) {
            if (marketHomeGetScreenResponseModel == null)
                return;
            mStringArrayAdapter4.clear();
            mStringArrayAdapter4.addAll(marketHomeGetScreenResponseModel.getData().getIntelligentClassify());
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        initRecommend();
        if (TextUtils.isEmpty(parentClassify)) {
            llChoice.setVisibility(View.GONE);
        } else {
            llChoice.setVisibility(View.VISIBLE);
            tv01.setOnClickListener(this);
            tv02.setOnClickListener(this);
            tv03.setOnClickListener(this);
            tv04.setOnClickListener(this);
            listPopupWindow4 = new ListPopupWindow(this);
            mStringArrayAdapter4 = new ArrayAdapter<>(this, R.layout.home_shop_spinner_item);
            listPopupWindow4.setAdapter(mStringArrayAdapter4);
            listPopupWindow4.setAnchorView(tv04);
            listPopupWindow4.setWidth(TDevice.getScreenWidth(this));
            listPopupWindow4.setHeight(ListPopupWindow.WRAP_CONTENT);
            listPopupWindow4.setModal(true);
            listPopupWindow4.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    pager = 0;
                    sortType = mStringArrayAdapter4.getItem(position).getValue();
                    subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserverFresh, setParams());
                    listPopupWindow4.dismiss();
                }
            });

            listPopupWindow2 = new ListPopupWindow(this);
            mStringArrayAdapter2 = new ArrayAdapter<>(this, R.layout.home_shop_spinner_item);
            listPopupWindow2.setAdapter(mStringArrayAdapter2);
            listPopupWindow2.setAnchorView(tv02);
            listPopupWindow2.setWidth(TDevice.getScreenWidth(this));
            listPopupWindow2.setHeight(ListPopupWindow.WRAP_CONTENT);
            listPopupWindow2.setModal(true);
            listPopupWindow2.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                    pager = 0;
                    secondClassify = mStringArrayAdapter2.getItem(position).getValue();
                    subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserverFresh, setParams());
                    listPopupWindow2.dismiss();
                }
            });
            HttpMethod.getInstance().requestCodeInfoList(mCodeInfoListResponseModelObserver, setCodeParams());
            HttpMethod.getInstance().marketHomeGetScreen(mMarketHomeGetScreenResponseModelObserver, setScreenParams());
        }
        onRefresh();
    }

    protected abstract void initRecommend();

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
        return R.layout.activity_home_recommend_layout;
    }

    @Override
    public void onItemClick(View rootView, int position) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(rootView.findViewById(R.id.iv_pic), "iv01"));
        CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((HomeRecommendAdapter) adapter).getItem(position).getId(), ((HomeRecommendAdapter) adapter).getItem(position).getProductImageList());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv01:
                HomeAddressActivity.newIntent(this, false, 100);
                break;
            case R.id.tv02:
                listPopupWindow2.show();
                break;
            case R.id.tv03:
                showPopupWindow(tv03);
                break;
            case R.id.tv04:
                listPopupWindow4.show();
                break;
            case R.id.tv_cancel:
                pager = 0;
                beginPrice = "";
                endPrice = "";
                popupWindow.dismiss();
                subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
                break;
        }
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        parentClassify = getParentClassify();
        subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserverFresh, setParams());
    }

    public String getParentClassify() {
        return parentClassify;
    }

    public void setParentClassify(String parentClassify) {
        this.parentClassify = parentClassify;
    }

    private void showPopupWindow(View view) {
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(this).inflate(R.layout.baby_recommend_popup, null);
        // 设置按钮的点击事件
        final EditText etPriceLow = (EditText) contentView.findViewById(R.id.et_price_low);
        final EditText etPriceHigh = (EditText) contentView.findViewById(R.id.et_price_high);

        final TextView tvConfirm = (TextView) contentView.findViewById(R.id.tv_confirm);

        final TextView tvCancel = (TextView) contentView.findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pager = 0;
                beginPrice = etPriceLow.getText().toString();
                endPrice = etPriceHigh.getText().toString();
                subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
                popupWindow.dismiss();
            }
        });
        etPriceHigh.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    //do something;
                    pager = 0;
                    beginPrice = etPriceLow.getText().toString();
                    endPrice = etPriceHigh.getText().toString();
                    subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
                    popupWindow.dismiss();
                    return true;
                }
                return false;
            }
        });
        popupWindow = new PopupWindow(contentView, TDevice.getScreenWidth(this), RelativeLayout.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setTouchable(true);
        popupWindow.setTouchInterceptor(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                // 这里如果返回true的话，touch事件将被拦截
                // 拦截后 PopupWindow的onTouchEvent不被调用，这样点击外部区域无法dismiss
                return false;
            }
        });
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        // 我觉得这里是API的一个bug
        popupWindow.setBackgroundDrawable(getResources().getDrawable(R.drawable.shape_gray_stroke_no_corner));
        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);
    }

    protected ProductGetPageRequestModel setParams() {
        ProductGetPageRequestModel productGetPageRequestModel = new ProductGetPageRequestModel();
        productGetPageRequestModel.setToken(BaseApplication.getToken());
        productGetPageRequestModel.setCmd(ApiInterface.ProductGetPage);
        productGetPageRequestModel.setParameters(new ProductGetPageRequestModel.ParametersEntity(pagerSize, pager, parentClassify, secondClassify, city, beginPrice, endPrice, sortType));
        return productGetPageRequestModel;
    }

    private MarketHomeGetScreenRequestModel setScreenParams() {
        MarketHomeGetScreenRequestModel marketHomeGetScreenRequestModel = new MarketHomeGetScreenRequestModel();
        marketHomeGetScreenRequestModel.setCmd(ApiInterface.MarketHomeGetScreen);
        marketHomeGetScreenRequestModel.setToken(BaseApplication.getToken());
        return marketHomeGetScreenRequestModel;
    }

    private CodeInfoListRequestModel setCodeParams() {
        CodeInfoListRequestModel codeInfoListRequestModel = new CodeInfoListRequestModel();
        codeInfoListRequestModel.setToken(BaseApplication.getToken());
        codeInfoListRequestModel.setCmd(ApiInterface.CodeInfoList);
        codeInfoListRequestModel.setParameters(new CodeInfoListRequestModel.ParametersEntity("market_product_type", getParentClassify()));
        return codeInfoListRequestModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            //地址选择返回数据
            city = data.getStringExtra("city");
            Log.e(TAG, data.getStringExtra("city"));
            pager = 0;
            subscription = HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserverFresh, setParams());
            tv01.setText(city);
        }
    }
}
