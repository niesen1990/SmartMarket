package com.cmbb.smartmarket.activity.home;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.HomeAddressAdapter;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetAllCityListRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetAllCityListResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetHotCityListRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetHotCityListResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SPCache;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/24 上午10:23
 * 修改人：N.Sun
 * 修改时间：16/5/24 上午10:23
 * 修改备注：
 */
public class HomeAddressActivity extends BaseRecyclerActivity {
    private static final String TAG = HomeAddressActivity.class.getSimpleName();

    @BindView(R.id.et_content)
    EditText etContent;
    ArrayList<Object> cityAll = new ArrayList<>();
    Observer<Object> mMarketHomeGetAllCityListResponseModelObserver = new Observer<Object>() {
        @Override
        public void onCompleted() {
            adapter.clear();
            adapter.addAll(cityAll);
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(Object object) {
            //处理数据
            if (object instanceof MarketHomeGetHotCityListResponseModel) {
                cityAll.add("热门城市");
                cityAll.addAll(((MarketHomeGetHotCityListResponseModel) object).getData().getHotCity());
            } else if (object instanceof MarketHomeGetAllCityListResponseModel) {
                for (MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity allCityEntity : ((MarketHomeGetAllCityListResponseModel) object).getData().getAllCity()) {
                    cityAll.add(allCityEntity.getName());
                    cityAll.addAll(allCityEntity.getArrays());
                }
            }
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        cityAll.add(SPCache.getString(Constants.LOCATION_CITY, "您可能未开启定位权限"));
        etContent.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (cityAll == null || cityAll.size() == 0)
                    return;
                String content = etContent.getText().toString();
                ArrayList<MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity> cacheList = new ArrayList<MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity>();
                if (Constants.regExpChinese(content)) {
                    //中文
                    for (Object o : cityAll) {
                        if (o instanceof MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) {
                            if (((MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) o).getName().contains(content)) {
                                cacheList.add((MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) o);
                            }
                        }
                    }
                    adapter.clear();
                    adapter.addAll(cacheList);
                } else if (Constants.regExpLetter(content)) {
                    //英文
                    content = content.toLowerCase();
                    for (Object o : cityAll) {
                        if (o instanceof MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) {
                            if (((MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) o).getPhoneticize().contains(content)) {
                                cacheList.add((MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) o);
                            }
                        }
                    }
                    adapter.clear();
                    adapter.addAll(cacheList);
                } else {
                    adapter.clear();
                    adapter.addAll(cityAll);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new HomeAddressAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_address_layout;
    }

    @Override
    public void onItemClick(int position) {
        if (cityAll.get(position) instanceof MarketHomeGetHotCityListResponseModel.DataEntity.HotCityEntity) {
            //热门城市点击
        } else if (cityAll.get(position) instanceof MarketHomeGetAllCityListResponseModel.DataEntity.AllCityEntity.ArraysEntity) {
            // 普通城市点击
        }
    }

    @Override
    public void onLoadMore() {
        adapter.stopMore();
    }

    @Override
    public void onRefresh() {
        subscription = HttpMethod.getInstance().marketHomeGetHotCityList(mMarketHomeGetAllCityListResponseModelObserver, setHotParams(), setAllCityParams());
    }

    private MarketHomeGetHotCityListRequestModel setHotParams() {
        MarketHomeGetHotCityListRequestModel marketHomeGetHotCityListRequestModel = new MarketHomeGetHotCityListRequestModel();
        marketHomeGetHotCityListRequestModel.setToken(marketHomeGetHotCityListRequestModel.getToken());
        marketHomeGetHotCityListRequestModel.setCmd(ApiInterface.MarketHomeGetHotCityList);
        return marketHomeGetHotCityListRequestModel;
    }

    private MarketHomeGetAllCityListRequestModel setAllCityParams() {
        MarketHomeGetAllCityListRequestModel marketHomeGetAllCityListRequestModel = new MarketHomeGetAllCityListRequestModel();
        marketHomeGetAllCityListRequestModel.setCmd(ApiInterface.MarketHomeGetAllCityList);
        return marketHomeGetAllCityListRequestModel;
    }

    public static void newIntent(BaseActivity context, int requestCode) {
        Intent intent = new Intent(context, HomeAddressActivity.class);
        context.startActivityForResult(intent, requestCode);
    }
}
