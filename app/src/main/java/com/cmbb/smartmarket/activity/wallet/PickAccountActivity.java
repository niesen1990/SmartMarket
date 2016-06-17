package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.adapter.WithdrawalsAdapter;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindListRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindListResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
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
    private static final String TAG = PickAccountActivity.class.getSimpleName();
    @BindView(R.id.tv_add_account)
    TextView tvAddAccount;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle(getIntent().getStringExtra("title"));
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
                if (getIntent().getBooleanExtra("hasPsw", false)) {
                    showBottomSheet();
                } else {
                    DialogUtils.createAlertDialog(this, "提示", getString(R.string.tip_deal_psw), true, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            onBackPressed();
                        }
                    });
                }
                break;
        }
    }

    @Override
    protected Observer<WalletAccountValiatePayPasswordResponseModel> getPswValiate() {
        return new Observer<WalletAccountValiatePayPasswordResponseModel>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {
                Log.e(TAG, e.toString());
                hideWaitingDialog();
            }

            @Override
            public void onNext(WalletAccountValiatePayPasswordResponseModel walletAccountValiatePayPasswordResponseModel) {
                hideWaitingDialog();
                if (walletAccountValiatePayPasswordResponseModel != null) {
                    showToast(walletAccountValiatePayPasswordResponseModel.getMsg());
                    if (walletAccountValiatePayPasswordResponseModel.isData()) {
                        AddAccountActivity.newIntent(PickAccountActivity.this);//密码验证成功
                        finish();
                    }
                }
            }
        };
    }

    @Override
    public void onItemClick(View rootView, int position) {
        if (getIntent().getBooleanExtra("isClick", false)) {
            WithdrawalsActivity.newIntent(this, ((WithdrawalsAdapter) adapter).getItem(position));
        }
    }

    Observer<WalletAccountBindListResponseModel> mWalletAccountBindListResponseModelObserver = new Observer<WalletAccountBindListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(WalletAccountBindListResponseModel walletAccountBindListResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(walletAccountBindListResponseModel.getData());
        }
    };

    @Override
    public void onLoadMore() {
        adapter.pauseMore();
    }

    @Override
    public void onRefresh() {
        HttpMethod.getInstance().walletAccountBindListRequest(mWalletAccountBindListResponseModelObserver, setParams());
    }

    /**
     * 设置参数
     *
     * @return params
     */
    protected WalletAccountBindListRequestModel setParams() {
        unSubscribe();
        WalletAccountBindListRequestModel walletAccountBindListRequestModel = new WalletAccountBindListRequestModel();
        walletAccountBindListRequestModel.setToken(BaseApplication.getToken());
        walletAccountBindListRequestModel.setCmd(ApiInterface.WalletAccountBindList);
        return walletAccountBindListRequestModel;
    }

    public static void newIntent(Context context, boolean hasPsw, boolean isClick, String title) {
        Intent intent = new Intent(context, PickAccountActivity.class);
        intent.putExtra("hasPsw", hasPsw);
        intent.putExtra("isClick", isClick);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }
}
