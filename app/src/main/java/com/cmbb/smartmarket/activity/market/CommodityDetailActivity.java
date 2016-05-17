package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
import com.cmbb.smartmarket.activity.market.adapter.DetailReplayAdapter;
import com.cmbb.smartmarket.activity.user.ReportActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.umeng.socialize.UMShareAPI;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午4:08
 */
public class CommodityDetailActivity extends BaseRecyclerActivity {
    private static final String TAG = CommodityDetailActivity.class.getSimpleName();
    @BindView(R.id.roll_view_pager)
    ImageView rollViewPager;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_buy)
    TextView tvBuy;

    protected void init() {
        rollViewPager = (ImageView) findViewById(R.id.roll_view_pager);
        ImageLoader.loadUrlAndDiskCache(this, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", rollViewPager);
        tvMessage.setOnClickListener(this);
        ivCollection.setOnClickListener(this);
        tvShare.setOnClickListener(this);
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
                BuyOrderActivity.newIntent(this);
                break;
        }
    }

    @Override
    public void onItemClick(int position) {

    }

    Observer<TestModel> mTestUserAttentionModelObserver = new Observer<TestModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
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
