package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.ListPopupWindow;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.HomeRecommendAdapter;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.TDevice;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/4 下午1:27
 * 修改人：N.Sun
 * 修改时间：16/5/4 下午1:27
 * 修改备注：
 */
public class BabyRecommendActivity extends BaseRecyclerActivity {
    @BindView(R.id.tv01)
    TextView tv01;
    @BindView(R.id.tv02)
    TextView tv02;
    @BindView(R.id.tv03)
    TextView tv03;
    @BindView(R.id.tv04)
    TextView tv04;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("宝宝用品");
        tv01.setOnClickListener(this);
        tv02.setOnClickListener(this);
        tv03.setOnClickListener(this);
        tv04.setOnClickListener(this);
        onRefresh();
    }

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
        return R.layout.activity_home_babay_recommend_layout;
    }

    @Override
    public void onItemClick(int position) {

    }

    String[] products = {"Camera", "Laptop", "Watch", "SmartPhone", "Television"};

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv01:
                HomeAddressActivity.newIntent(this, 100);
                break;
            case R.id.tv02:
                break;
            case R.id.tv03:
                break;
            case R.id.tv04:
                ListPopupWindow listPopupWindow = new ListPopupWindow(this);
                listPopupWindow.setAdapter(new ArrayAdapter(this, R.layout.home_shop_spinner_item, products));
                listPopupWindow.setAnchorView(tv04);
                listPopupWindow.setWidth(TDevice.getScreenWidth(this));
                listPopupWindow.setHeight(ListPopupWindow.WRAP_CONTENT);
                listPopupWindow.setModal(true);
                listPopupWindow.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    }
                });
                listPopupWindow.show();
                break;
        }
    }

    Observer<TestModel> mTestUserAttentionModelObserver = new Observer<TestModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(TestModel testModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(testModel.getData().getRows());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().getTestData(mTestUserAttentionModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().getTestData(mTestUserAttentionModelObserver, setParams());
    }

    /**
     * 设置参数
     *
     * @return params
     */
    protected TestRequestModel setParams() {
        unSubscribe();
        TestRequestModel testRequestModel = new TestRequestModel();
        testRequestModel.setCmd("smart/attention/getList");
        testRequestModel.setToken(BaseApplication.getToken());
        testRequestModel.setParameters(new TestRequestModel.ParametersEntity(pager, pagerSize, 0));
        return testRequestModel;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, BabyRecommendActivity.class);
        context.startActivity(intent);
    }
}
