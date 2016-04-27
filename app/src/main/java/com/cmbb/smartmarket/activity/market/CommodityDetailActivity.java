package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;
import com.cmbb.smartmarket.activity.market.adapter.DetailReplayAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.base.ResponseModel;
import com.cmbb.smartmarket.network.OkHttp;

import java.util.HashMap;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午4:08
 */
public class CommodityDetailActivity extends BaseRecyclerActivity {
    private static final String TAG = CommodityDetailActivity.class.getSimpleName();

    @Override
    protected void initView(Bundle savedInstanceState) {
        adapter.addHeader(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                RelativeLayout header = (RelativeLayout) LayoutInflater.from(CommodityDetailActivity.this).inflate(R.layout.activity_commodity_detail_head01, null);
                header.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        });
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new DetailReplayAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_detail_layout;
    }

    @Override
    public void onItemClick(int position) {

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

    public static void newIntent(Context context, String id) {
        Intent intent = new Intent(context, CommodityDetailActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
