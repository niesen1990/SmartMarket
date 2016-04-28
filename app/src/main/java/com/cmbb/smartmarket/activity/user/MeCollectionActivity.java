package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.user.adapter.MeCollectionAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.base.ResponseModel;
import com.cmbb.smartmarket.network.OkHttp;

import java.util.HashMap;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/28 下午12:02
 */
public class MeCollectionActivity extends BaseRecyclerActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("宝贝收藏");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new MeCollectionAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me_collection;
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
        Intent intent = new Intent(context, MeCollectionActivity.class);
        context.startActivity(intent);
    }
}