package com.cmbb.smartmarket.activity.wallet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Spinner;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.adapter.BalanceDetailAdapter;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBillListRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBillListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
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
    @BindView(R.id.sp_status)
    Spinner spinner;
    private String type;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("余额明细");
        onRefresh();
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        type = "";
                        break;
                    case 1:
                        type = "CASH";
                        break;
                    case 2:
                        type = "RECEIPT";
                        break;
                    case 3:
                        type = "REFUND";
                        break;
                }
                onRefresh();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
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

    Observer<WalletAccountBillListResponseModel> mWalletAccountBillListResponseModelObserver = new Observer<WalletAccountBillListResponseModel>() {
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
        public void onNext(WalletAccountBillListResponseModel testModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(testModel.getData().getContent());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().walletAccountBillList(mWalletAccountBillListResponseModelObserver, setParams());
    }

    private WalletAccountBillListRequestModel setParams() {
        WalletAccountBillListRequestModel walletAccountBillListRequestModel = new WalletAccountBillListRequestModel();
        walletAccountBillListRequestModel.setToken(BaseApplication.getToken());
        walletAccountBillListRequestModel.setCmd(ApiInterface.WalletAccountBillList);
        walletAccountBillListRequestModel.setParameters(new WalletAccountBillListRequestModel.ParametersEntity(type, pager, pagerSize));
        return walletAccountBillListRequestModel;
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().walletAccountBillList(mWalletAccountBillListResponseModelObserver, setParams());
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, BalanceDetailActivity.class);
        context.startActivity(intent);

    }
}
