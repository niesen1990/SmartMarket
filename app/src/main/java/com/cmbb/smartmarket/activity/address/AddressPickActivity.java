package com.cmbb.smartmarket.activity.address;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.adapter.AddressPickAdapter;
import com.cmbb.smartmarket.activity.address.model.ProvinceCityGetAllRequestModel;
import com.cmbb.smartmarket.activity.address.model.ProvinceCityGetAllResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
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
 * 创建时间：16/6/2 下午7:14
 * 修改人：N.Sun
 * 修改时间：16/6/2 下午7:14
 * 修改备注：
 */
public class AddressPickActivity extends BaseRecyclerActivity {

    private static final String TAG = AddressPickActivity.class.getSimpleName();

    Observer<ProvinceCityGetAllResponseModel> mProvinceCityGetAllResponseModelObserver = new Observer<ProvinceCityGetAllResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(ProvinceCityGetAllResponseModel provinceCityGetAllResponseModel) {
            if (provinceCityGetAllResponseModel == null)
                return;
            adapter.clear();
            adapter.addAll(provinceCityGetAllResponseModel.getData());
        }
    };

    String parentCode = "0";
    int levelCount = 1;

    String province;
    String provinceCode;
    String city;
    String cityCode;
    String district;
    String districtCode;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("选择省市区");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new AddressPickAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_address_pick_layout;
    }

    @Override
    public void onItemClick(View rootView, int position) {
        switch (levelCount) {
            case 1:
                levelCount = 2;
                parentCode = ((AddressPickAdapter) (adapter)).getItem(position).getCode();
                provinceCode = ((AddressPickAdapter) (adapter)).getItem(position).getCode();
                province = ((AddressPickAdapter) (adapter)).getItem(position).getName();
                onRefresh();
                break;
            case 2:
                levelCount = 3;
                parentCode = ((AddressPickAdapter) (adapter)).getItem(position).getCode();
                cityCode = ((AddressPickAdapter) (adapter)).getItem(position).getCode();
                city = ((AddressPickAdapter) (adapter)).getItem(position).getName();
                onRefresh();
                break;
            case 3:
                districtCode = ((AddressPickAdapter) (adapter)).getItem(position).getCode();
                district = ((AddressPickAdapter) (adapter)).getItem(position).getName();
                Intent intent = new Intent();
                intent.putExtra("province", province);
                intent.putExtra("provinceCode", provinceCode);
                intent.putExtra("city", city);
                intent.putExtra("cityCode", cityCode);
                intent.putExtra("district", district);
                intent.putExtra("districtCode", districtCode);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    @Override
    public void onLoadMore() {
        adapter.stopMore();
    }

    @Override
    public void onRefresh() {
        String parentCode = "0";
        int levelCount = 1;
        subscription = HttpMethod.getInstance().provinceCityGetAll(mProvinceCityGetAllResponseModelObserver, setParams());
    }

    private ProvinceCityGetAllRequestModel setParams() {
        ProvinceCityGetAllRequestModel provinceCityGetAllRequestModel = new ProvinceCityGetAllRequestModel();
        provinceCityGetAllRequestModel.setCmd(ApiInterface.ProvinceCityGetAll);
        provinceCityGetAllRequestModel.setToken(BaseApplication.getToken());
        provinceCityGetAllRequestModel.setParameters(new ProvinceCityGetAllRequestModel.ParametersEntity(parentCode, levelCount));
        return provinceCityGetAllRequestModel;
    }

    public static void newIntent(BaseActivity context, int requestCode) {
        Intent intent = new Intent(context, AddressPickActivity.class);
        context.startActivityForResult(intent, requestCode);
    }

}
