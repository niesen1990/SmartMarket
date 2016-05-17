package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
import com.cmbb.smartmarket.activity.wallet.adapter.WithdrawalsAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/5 下午1:57
 * 修改人：N.Sun
 * 修改时间：16/5/5 下午1:57
 * 修改备注：
 */
public class PickAccountActivity extends BaseAccountRecyclerActivity {
    @BindView(R.id.tv_add_account)
    TextView tvAddAccount;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("选择提现账号");
        tvAddAccount.setOnClickListener(this);
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new WithdrawalsAdapter(this);
    }

    @Override
    protected void initRecyclerView() {
        mSmartRecyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        adapter = initAdapter();
        mSmartRecyclerView.setLayoutManager(setLayoutManager());
        mSmartRecyclerView.setAdapterWithProgress(adapter);
        adapter.setMore(R.layout.view_more, this);
        adapter.setOnItemClickListener(this);
        mSmartRecyclerView.setRefreshListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pick_account_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_add_account:
                /*DialogUtils.createAlertDialog(this, "提示", getString(R.string.tip_deal_psw), true, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        onBackPressed();
                    }
                });*/
                AddAccountActivity.newIntent(this);
//                showBottomSheet(tvAddAccount);
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
        Intent intent = new Intent(context, PickAccountActivity.class);
        context.startActivity(intent);
    }
}
