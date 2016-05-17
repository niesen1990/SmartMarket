package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
import com.cmbb.smartmarket.activity.wallet.adapter.BalanceDetailAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/5 下午1:33
 * 修改人：N.Sun
 * 修改时间：16/5/5 下午1:33
 * 修改备注：
 */
public class BalanceDetailActivity extends BaseRecyclerActivity {

    private static final String TAG = BalanceDetailActivity.class.getSimpleName();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("余额明细");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new BalanceDetailAdapter(this);
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.half_global_padding)));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_balance_detail_layout;
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

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, BalanceDetailActivity.class);
        context.startActivity(intent);

    }
}
