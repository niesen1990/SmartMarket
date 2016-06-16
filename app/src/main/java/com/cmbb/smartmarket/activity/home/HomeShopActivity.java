package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.HomeShopAdapter;
import com.cmbb.smartmarket.activity.market.NeedDetailActivity;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:34
 */
public class HomeShopActivity extends BaseHomeActivity {

    private static final String TAG = HomeShopActivity.class.getSimpleName();

    @BindView(R.id.spinner)
    Spinner spinner;
    String spinnerType = "sortType";
    String value = "new_publish";
    List<SystemDictListResponseModel.DataEntity> spinnerData;
    Observer<SystemDictListResponseModel> mSystemDictListResponseModelObserver = new Observer<SystemDictListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());

        }

        @Override
        public void onNext(SystemDictListResponseModel systemDictListResponseModel) {
            hideWaitingDialog();
            if (systemDictListResponseModel == null)
                return;
            spinnerData = systemDictListResponseModel.getData();
            ArrayList<String> items = new ArrayList<>();
            for (SystemDictListResponseModel.DataEntity dataEntity : spinnerData) {
                items.add(dataEntity.getName());
            }
            ArrayAdapter<String> spinnerAdapter = new ArrayAdapter<>(HomeShopActivity.this, R.layout.home_shop_spinner_stick_item, items);
            spinnerAdapter.setDropDownViewResource(R.layout.home_shop_spinner_item);
            spinner.setAdapter(spinnerAdapter);
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("求购");
        tvShop.setSelected(true);
        getToolbar().setDisplayHomeAsUpEnabled(false);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                spinnerType = spinnerData.get(position).getRemark();
                value = spinnerData.get(position).getValue();
                onRefresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        HttpMethod.getInstance().requestSystemDictList(mSystemDictListResponseModelObserver, setDictParams());
    }

    private SystemDictListRequestModel setDictParams() {
        SystemDictListRequestModel systemDictListRequestModel = new SystemDictListRequestModel();
        systemDictListRequestModel.setCmd(ApiInterface.SystemDictList);
        systemDictListRequestModel.setToken(BaseApplication.getToken());
        systemDictListRequestModel.setParameters(new SystemDictListRequestModel.ParametersEntity("product_filtrate_ask_to_buy"));
        return systemDictListRequestModel;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new HomeShopAdapter(this);
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.global_padding)));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_shop;
    }

    @Override
    public void onItemClick(int position) {
        NeedDetailActivity.newIntent(this, ((HomeShopAdapter) adapter).getItem(position).getId());
    }

    Observer<ProductGetPageResponseModel> mProductGetPageResponseModelObserver = new Observer<ProductGetPageResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
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

    private ProductGetPageRequestModel setParams() {
        ProductGetPageRequestModel productGetPageRequestModel = new ProductGetPageRequestModel();
        productGetPageRequestModel.setToken(BaseApplication.getToken());
        productGetPageRequestModel.setCmd(ApiInterface.ProductGetPage);
        productGetPageRequestModel.setParameters(new ProductGetPageRequestModel.ParametersEntity(pagerSize, pager, 1, spinnerType, value));
        return productGetPageRequestModel;
    }

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().requestProductGetPage(mProductGetPageResponseModelObserver, setParams());
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeShopActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
