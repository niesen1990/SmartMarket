package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;
import com.cmbb.smartmarket.activity.market.adapter.DetailReplayAdapter;
import com.cmbb.smartmarket.activity.user.ReportActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.base.ResponseModel;
import com.cmbb.smartmarket.network.OkHttp;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.umeng.socialize.UMShareAPI;

import java.util.HashMap;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午4:08
 */
public class CommodityDetailActivity extends BaseRecyclerActivity {
    private static final String TAG = CommodityDetailActivity.class.getSimpleName();

    private AppBarLayout abl;
    private ImageView rollViewPager;
    private TextView tvMessage;
    private ImageView ivCollection;
    private TextView tvShare;
    private TextView tvBuy;

    protected void init() {
        rollViewPager = (ImageView) findViewById(R.id.roll_view_pager);
        tvMessage = (TextView) findViewById(R.id.tv_message);
        tvMessage.setOnClickListener(this);
        ivCollection = (ImageView) findViewById(R.id.iv_collection);
        ivCollection.setOnClickListener(this);
        tvShare = (TextView) findViewById(R.id.tv_share);
        tvShare.setOnClickListener(this);
        tvBuy = (TextView) findViewById(R.id.tv_buy);
        tvBuy.setOnClickListener(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        init();
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
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_commodity_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_report:
                ReportActivity.newIntent(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_share:
                SocialUtils.share(this, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", "魅族手机PRO6", "MEIZU design and make", "http://www.baidu.com");
                break;
            case R.id.tv_message:
                // TODO: 16/4/28  
                break;
            case R.id.iv_collection:
                // TODO: 16/4/28  
                break;
            case R.id.tv_buy:
                // TODO: 16/4/28
                break;
        }
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public static void newIntent(Context context, String id) {
        Intent intent = new Intent(context, CommodityDetailActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
