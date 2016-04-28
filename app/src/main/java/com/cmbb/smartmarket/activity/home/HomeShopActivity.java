package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.adapter.HomeShopAdapter;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.ResponseModel;
import com.cmbb.smartmarket.network.OkHttp;

import java.util.HashMap;

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
        getToolbar().setDisplayHomeAsUpEnabled(false);
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new HomeShopAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_shop;
    }

    @Override
    public void onItemClick(int position) {
        CommodityDetailActivity.newIntent(this, "1");
    }

    @Override
    public void onLoadMore() {
        pager++;
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNo", String.valueOf(pager));
        params.put("numberOfPerPage", String.valueOf(pagerSize));
        params.put("typeNum", String.valueOf(0));
        params.put("token", BaseApplication.getToken());
        OkHttp.post("smart/attention/getList", params, new ResponseModel<UserAttentionModel>() {

            @Override
            protected void onSuccess(UserAttentionModel result) {
                adapter.addAll(result.getResponse().getData().getRows());
            }

            @Override
            protected void onFailed() {
                mSmartRecyclerView.showError();
                adapter.pauseMore();
            }
        });
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HashMap<String, String> params = new HashMap<>();
        params.put("pageNo", String.valueOf(pager));
        params.put("numberOfPerPage", String.valueOf(pagerSize));
        params.put("typeNum", String.valueOf(0));
        params.put("token", BaseApplication.getToken());
        OkHttp.post("smart/attention/getList", params, new ResponseModel<UserAttentionModel>() {

            @Override
            protected void onSuccess(UserAttentionModel result) {
                adapter.clear();
                adapter.addAll(result.getResponse().getData().getRows());
            }

            @Override
            protected void onFailed() {
                mSmartRecyclerView.showError();
                adapter.pauseMore();
            }
        });
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeShopActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
