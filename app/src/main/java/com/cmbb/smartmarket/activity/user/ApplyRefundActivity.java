package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.ApplyRefundAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictRequestModel;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午4:47
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午4:47
 * 修改备注：
 */
public class ApplyRefundActivity extends BaseActivity implements RecyclerArrayAdapter.OnItemClickListener {

    private static final String TAG = ApplyRefundActivity.class.getSimpleName();

    @BindView(R.id.tv_type)
    TextView tvType;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.tv_choice)
    TextView tvChoice;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_enclosure)
    TextView tvEnclosure;
    @BindView(R.id.et_reason)
    EditText etReason;
    @BindView(R.id.behaviorRecyclerView01)
    EasyRecyclerView behaviorRecyclerView01;
    @BindView(R.id.behaviorRecyclerView02)
    EasyRecyclerView behaviorRecyclerView02;
    BottomSheetBehavior behavior01;
    BottomSheetBehavior behavior02;

    ApplyRefundAdapter adapter01;
    ApplyRefundAdapter adapter02;
    SystemGetMultipleDictResponseModel mSystemGetMultipleDictResponseModel;
    Observer<SystemGetMultipleDictResponseModel> mSystemGetMultipleDictResponseModelObserver = new Observer<SystemGetMultipleDictResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(SystemGetMultipleDictResponseModel systemGetMultipleDictResponseModel) {
            hideWaitingDialog();
            if (systemGetMultipleDictResponseModel != null) {
                mSystemGetMultipleDictResponseModel = systemGetMultipleDictResponseModel;
                behavior01 = BottomSheetBehavior.from(behaviorRecyclerView01);
                behavior02 = BottomSheetBehavior.from(behaviorRecyclerView02);
                refundServer = systemGetMultipleDictResponseModel.getData().getRefund_server().get(0).getValue();
                initAdapter();
            }
        }
    };

    Observer<MarketOrderRefundResponseModel> mMarketOrderRefundResponseModelObserver = new Observer<MarketOrderRefundResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketOrderRefundResponseModel marketOrderRefundResponseModel) {
            hideWaitingDialog();
            showToast(marketOrderRefundResponseModel.getName());
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("申请退款");
        ll01.setOnClickListener(this);
        ll02.setOnClickListener(this);
        tvSubmit.setOnClickListener(this);
        showWaitingDialog();
        subscription = HttpMethod.getInstance().systemGetMultipleDict(mSystemGetMultipleDictResponseModelObserver, setParams());
    }

    private void initAdapter() {
        adapter01 = new ApplyRefundAdapter(this);
        adapter02 = new ApplyRefundAdapter(this);
        behaviorRecyclerView01.setLayoutManager(new LinearLayoutManager(this));
        behaviorRecyclerView02.setLayoutManager(new LinearLayoutManager(this));
        behaviorRecyclerView01.setAdapterWithProgress(adapter01);
        behaviorRecyclerView02.setAdapterWithProgress(adapter02);
        adapter01.setOnItemClickListener(this);
        adapter02.setOnItemClickListener(this);
        adapter01.addAll(mSystemGetMultipleDictResponseModel.getData().getRefund_server());
        adapter02.addAll(mSystemGetMultipleDictResponseModel.getData().getRefund_reason());
    }

    private SystemGetMultipleDictRequestModel setParams() {
        SystemGetMultipleDictRequestModel systemGetMultipleDictRequestModel = new SystemGetMultipleDictRequestModel();
        systemGetMultipleDictRequestModel.setCmd(ApiInterface.SystemGetMultipleDict);
        systemGetMultipleDictRequestModel.setToken(BaseApplication.getToken());
        systemGetMultipleDictRequestModel.setParameters(new SystemGetMultipleDictRequestModel.ParametersEntity("refund_server,refund_reason"));
        return systemGetMultipleDictRequestModel;
    }

    int whichItem;

    String refundServer;
    String refundReason;

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ll01:
                whichItem = 0;
                behavior01Start();
                break;
            case R.id.ll02:
                whichItem = 1;
                behavior02Start();
                break;
            case R.id.tv_submit:
                unSubscribe();
                if (TextUtils.isEmpty(refundReason)) {
                    showToast("请选择退货原因");
                    return;
                }
                subscription = HttpMethod.getInstance().marketOrderRefund(mMarketOrderRefundResponseModelObserver, setRefundParams());
                break;
        }
    }

    private MarketOrderRefundRequestModel setRefundParams() {
        MarketOrderRefundRequestModel marketOrderRefundRequestModel = new MarketOrderRefundRequestModel();
        marketOrderRefundRequestModel.setCmd(ApiInterface.MarketOrderRefund);
        marketOrderRefundRequestModel.setToken(BaseApplication.getToken());
        marketOrderRefundRequestModel.setParameters(new MarketOrderRefundRequestModel.ParametersEntity(getIntent().getStringExtra("orderCode"), refundServer, refundReason, etReason.getText().toString()));
        return marketOrderRefundRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_apply_refund_layout;
    }

    public void behavior01Start() {
        if (behavior02.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior02.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
        if (behavior01.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior01.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior01.setState(BottomSheetBehavior.STATE_EXPANDED);
        }

    }

    public void behavior02Start() {
        if (behavior01.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior01.setState(BottomSheetBehavior.STATE_COLLAPSED);
        }
        if (behavior02.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior02.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior02.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    public void onItemClick(int position) {
        behavior02.setState(BottomSheetBehavior.STATE_COLLAPSED);
        behavior01.setState(BottomSheetBehavior.STATE_COLLAPSED);
        switch (whichItem) {
            case 0:
                tvType.setText(adapter01.getItem(position).getName());
                refundServer = adapter01.getItem(position).getValue();
                break;
            case 1:
                tvChoice.setText(adapter02.getItem(position).getName());
                refundReason = adapter02.getItem(position).getValue();
                break;
        }
    }

    public static void newIntent(Context context, String orderCode) {
        Intent intent = new Intent(context, ApplyRefundActivity.class);
        intent.putExtra("orderCode", orderCode);
        context.startActivity(intent);
    }
}
