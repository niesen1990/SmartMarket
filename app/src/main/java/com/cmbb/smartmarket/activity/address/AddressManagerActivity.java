package com.cmbb.smartmarket.activity.address;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.adapter.AddressItemAdapter;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageResponseModel;
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
 * 创建时间：16/5/6 下午1:14
 * 修改人：N.Sun
 * 修改时间：16/5/6 下午1:14
 * 修改备注：
 */
public class AddressManagerActivity extends BaseRecyclerActivity {

    private static final String TAG = AddressManagerActivity.class.getSimpleName();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("地址管理");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new AddressItemAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_manager_layout;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_address_manager, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                AddAddressActivity.newIntent(this);
                break;
        }
        return super.onOptionsItemSelected(item);
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
        Intent intent = new Intent(context, AddressManagerActivity.class);
        context.startActivity(intent);
    }
}
