package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageResponseModel;
import com.cmbb.smartmarket.activity.home.adapter.HomeShopAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:34
 */
public class HomeShopActivity extends BaseHomeActivity {

    private static final String TAG = HomeShopActivity.class.getSimpleName();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("求购");
        tvShop.setSelected(true);
        getToolbar().setDisplayHomeAsUpEnabled(false);
        onRefresh();
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
//        CommodityDetailActivity.newIntent(this, ((HomeShopAdapter)adapter).getItem(position).getId());
    }

    Observer<UserAddressGetPageResponseModel> mTestUserAttentionModelObserver = new Observer<UserAddressGetPageResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(UserAddressGetPageResponseModel userAddressGetPageResponseModel) {
            if (pager == 0)
                adapter.clear();
            Log.i(TAG, userAddressGetPageResponseModel.toString());
            adapter.addAll(userAddressGetPageResponseModel.getData().getRows());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().requestUserAddressGetPage(mTestUserAttentionModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().requestUserAddressGetPage(mTestUserAttentionModelObserver, setParams());
    }

    /**
     * 设置参数
     *
     * @return params
     */
    protected UserAddressGetPageRequestModel setParams() {
        unSubscribe();
        UserAddressGetPageRequestModel userAddressGetPageRequestModel = new UserAddressGetPageRequestModel();
        userAddressGetPageRequestModel.setCmd(ApiInterface.UserAddressGetPage);
        userAddressGetPageRequestModel.setToken(BaseApplication.getToken());
        userAddressGetPageRequestModel.setParameters(new UserAddressGetPageRequestModel.ParametersEntity(pager, pagerSize));
        return userAddressGetPageRequestModel;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeShopActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
