package com.cmbb.smartmarket.activity.address;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.adapter.AddressItemAdapter;
import com.cmbb.smartmarket.activity.address.model.UserAddressDeleteRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressDeleteResponseModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
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

    int requestCode;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("地址管理");
        requestCode = getIntent().getIntExtra("requestCode", -1);
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemClick(final int position) {
                DialogUtils.createAlertDialog(AddressManagerActivity.this, "操作", "您确定要删除这个地址吗？", true, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        unSubscribe();
                        UserAddressDeleteRequestModel userAddressDeleteRequestModel = new UserAddressDeleteRequestModel();
                        userAddressDeleteRequestModel.setCmd(ApiInterface.UserAddressDelete);
                        userAddressDeleteRequestModel.setToken(BaseApplication.getToken());
                        userAddressDeleteRequestModel.setParameters(new UserAddressDeleteRequestModel.ParametersEntity(((AddressItemAdapter) adapter).getItem(position).getId()));
                        showWaitingDialog();
                        subscription = HttpMethod.getInstance().requestUserAddressDelete(mUserAddressDeleteResponseModelObserver, userAddressDeleteRequestModel);
                    }
                });
                return true;
            }
        });
        onRefresh();
    }

    Observer<UserAddressDeleteResponseModel> mUserAddressDeleteResponseModelObserver = new Observer<UserAddressDeleteResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());

        }

        @Override
        public void onNext(UserAddressDeleteResponseModel userAddressDeleteResponseModel) {
            hideWaitingDialog();
            if (userAddressDeleteResponseModel != null) {
                showToast(userAddressDeleteResponseModel.getMsg());
                onRefresh();
            }
        }
    };

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
        if (requestCode == -1) {
            AddAndEditAddressActivity.newIntent(this, ((AddressItemAdapter) adapter).getItem(position).getId(), 100);
        } else {
            Intent intent = new Intent();
            intent.putExtra("data", ((AddressItemAdapter) adapter).getItem(position));
            setResult(RESULT_OK, intent);
            finish();
        }
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
                AddAndEditAddressActivity.newIntent(this, 100);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    Observer<UserAddressGetPageResponseModel> mUserAddressGetPageResponseModelObserver = new Observer<UserAddressGetPageResponseModel>() {
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
        HttpMethod.getInstance().requestUserAddressGetPage(mUserAddressGetPageResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().requestUserAddressGetPage(mUserAddressGetPageResponseModelObserver, setParams());
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case 100:
                if (resultCode == RESULT_OK) {
                    onRefresh();
                }
                break;
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, AddressManagerActivity.class);
        context.startActivity(intent);
    }

    public static void newIntent(BaseActivity context, int requestCode) {
        Intent intent = new Intent(context, AddressManagerActivity.class);
        intent.putExtra("requestCode", requestCode);
        context.startActivityForResult(intent, requestCode);
    }
}
