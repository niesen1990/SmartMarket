package com.cmbb.smartmarket.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.SystemDictListRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListResponseModel;
import com.cmbb.smartmarket.activity.user.adapter.ExpressListAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerSendRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerSendResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.KeyboardUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/30 下午1:43
 * 修改人：N.Sun
 * 修改时间：16/5/30 下午1:43
 * 修改备注：
 */
public class ExpressActivity extends BaseRecyclerActivity {

    private static final String TAG = ExpressActivity.class.getSimpleName();

    @BindView(R.id.tv_choose)
    TextView tvChoose;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.et_code)
    EditText etCode;

    String express;
    int tag;//0 : 卖家 ；1 ： 买家

    BottomSheetBehavior behavior;
    Observer<SystemDictListResponseModel> mSystemDictListResponseModelObserver = new Observer<SystemDictListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(SystemDictListResponseModel systemDictListResponseModel) {
            if (systemDictListResponseModel == null)
                return;
            adapter.clear();
            adapter.addAll(systemDictListResponseModel.getData());
        }
    };

    Observer<MarketOrderSellerSendResponseModel> mMarketOrderSellerSendResponseModelObserver = new Observer<MarketOrderSellerSendResponseModel>() {
        @Override
        public void onCompleted() {
            hideWaitingDialog();
        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketOrderSellerSendResponseModel marketOrderSellerSendResponseModel) {
            if (marketOrderSellerSendResponseModel == null)
                return;
            showToast(marketOrderSellerSendResponseModel.getMsg());
            KeyboardUtil.hideKeyboard(ExpressActivity.this);
            setResult(RESULT_OK);
            finish();
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_express_layout;
    }

    protected void initRecyclerView() {
        mSmartRecyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        if (mSmartRecyclerView == null)
            return;
        adapter = initAdapter();
        mSmartRecyclerView.setLayoutManager(setLayoutManager());
        if (adapter == null)
            return;
        mSmartRecyclerView.setAdapterWithProgress(adapter);
        setSpaceDecoration(mSmartRecyclerView);
        adapter.setOnItemClickListener(this);
        mSmartRecyclerView.setRefreshListener(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("物流信息");
        tag = getIntent().getIntExtra("tag", -1);
        tvChoose.setOnClickListener(this);
        tvSubmit.setOnClickListener(this);
        behavior = BottomSheetBehavior.from(mSmartRecyclerView);
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new ExpressListAdapter(this);
    }

    @Override
    public void onItemClick(View rootView, int position) {
        express = ((ExpressListAdapter) adapter).getItem(position).getValue();
        tvChoose.setText(((ExpressListAdapter) adapter).getItem(position).getName());
        behavior();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_choose:
                behavior();
                break;
            case R.id.tv_submit:
                if (TextUtils.isEmpty(express)) {
                    showToast("请选择快递公司");
                    return;
                }
                if (TextUtils.isEmpty(etCode.getText().toString())) {
                    showToast("请输入快递单号");
                    return;
                }
                showWaitingDialog();
                switch (tag) {
                    case 0:
                        subscription = HttpMethod.getInstance().marketOrderSellerSend(mMarketOrderSellerSendResponseModelObserver, setSendSellerParams());
                        break;
                    case 1:
                        subscription = HttpMethod.getInstance().marketOrderBuyerSend(mMarketOrderSellerSendResponseModelObserver, setSendBuyerParams());
                        break;
                }
                break;
        }
    }

    private MarketOrderSellerSendRequestModel setSendSellerParams() {
        MarketOrderSellerSendRequestModel marketOrderSellerSendRequestModel = new MarketOrderSellerSendRequestModel();
        marketOrderSellerSendRequestModel.setToken(BaseApplication.getToken());
        marketOrderSellerSendRequestModel.setCmd(ApiInterface.MarketOrderSellerSend);
        marketOrderSellerSendRequestModel.setParameters(new MarketOrderSellerSendRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1), express, etCode.getText().toString()));
        return marketOrderSellerSendRequestModel;
    }

    private MarketOrderSellerSendRequestModel setSendBuyerParams() {
        MarketOrderSellerSendRequestModel marketOrderSellerSendRequestModel = new MarketOrderSellerSendRequestModel();
        marketOrderSellerSendRequestModel.setToken(BaseApplication.getToken());
        marketOrderSellerSendRequestModel.setCmd(ApiInterface.MarketOrderBuyerSend);
        marketOrderSellerSendRequestModel.setParameters(new MarketOrderSellerSendRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1), express, etCode.getText().toString()));
        return marketOrderSellerSendRequestModel;
    }

    @Override
    public void onLoadMore() {
        adapter.pauseMore();
    }

    @Override
    public void onRefresh() {
        subscription = HttpMethod.getInstance().requestSystemDictList(mSystemDictListResponseModelObserver, setParams());
    }

    public void behavior() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    private SystemDictListRequestModel setParams() {
        SystemDictListRequestModel systemDictListRequestModel = new SystemDictListRequestModel();
        systemDictListRequestModel.setCmd(ApiInterface.SystemDictList);
        systemDictListRequestModel.setToken(BaseApplication.getToken());
        systemDictListRequestModel.setParameters(new SystemDictListRequestModel.ParametersEntity("expressCompany"));
        return systemDictListRequestModel;
    }

    public static void newIntent(BaseActivity context, int orderId, int tag) {
        Intent intent = new Intent(context, ExpressActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("tag", tag);
        context.startActivityForResult(intent, 100);
    }
}
