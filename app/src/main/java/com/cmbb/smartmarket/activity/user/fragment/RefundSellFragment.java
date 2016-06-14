package com.cmbb.smartmarket.activity.user.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.OrderDetailActivity;
import com.cmbb.smartmarket.activity.user.adapter.RefundSellAdapter;
import com.cmbb.smartmarket.activity.user.holder.RefundSellItemHolder;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveResponseModel;
import com.cmbb.smartmarket.activity.wallet.BaseAccountRecyclerFragment;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.cmbb.smartmarket.utils.SPCache;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

public class RefundSellFragment extends BaseAccountRecyclerFragment {
    private static final String ARG_PARAM = "position";
    private static final String TAG = RefundSellFragment.class.getSimpleName();
    private int position;

    Observer<MarketOrderListResponseModel> mMarketOrderListResponseModelObserver = new Observer<MarketOrderListResponseModel>() {
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
        public void onNext(MarketOrderListResponseModel marketOrderListResponseModel) {
            Log.e(TAG, marketOrderListResponseModel.getMsg());
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketOrderListResponseModel.getData().getContent());
        }
    };

    public RefundSellFragment() {
    }

    public static RefundSellFragment newInstance(int position) {
        RefundSellFragment fragment = new RefundSellFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.global_padding)));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        onRefresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sell_refund;
    }

    RefundSellItemHolder.ConfirmReceiver mConfirmReceiver = new RefundSellItemHolder.ConfirmReceiver() {
        @Override
        public void onClick(final int id) {
            if (SPCache.getBoolean(Constants.HAS_WALLET_PSW, false)) {
                showBottomSheet(new Observer<WalletAccountValiatePayPasswordResponseModel>() {
                    @Override
                    public void onCompleted() {
                        ((BaseActivity) getActivity()).hideWaitingDialog();
                    }

                    @Override
                    public void onError(Throwable e) {
                        ((BaseActivity) getActivity()).hideWaitingDialog();
                        Log.e(TAG, e.toString());
                    }

                    @Override
                    public void onNext(WalletAccountValiatePayPasswordResponseModel walletAccountValiatePayPasswordResponseModel) {
                        if (walletAccountValiatePayPasswordResponseModel == null)
                            return;

                        ((BaseActivity) getActivity()).showWaitingDialog();
                        HttpMethod.getInstance().marketOrderSellerReceive(new Observer<MarketOrderSellerReceiveResponseModel>() {
                            @Override
                            public void onCompleted() {
                                ((BaseActivity) getActivity()).hideWaitingDialog();
                            }

                            @Override
                            public void onError(Throwable e) {
                                ((BaseActivity) getActivity()).hideWaitingDialog();
                                Log.e(TAG, e.toString());
                            }

                            @Override
                            public void onNext(MarketOrderSellerReceiveResponseModel marketOrderSellerReceiveResponseModel) {
                                if (marketOrderSellerReceiveResponseModel == null)
                                    return;
                                ((BaseActivity) getActivity()).showToast(marketOrderSellerReceiveResponseModel.getMsg());
                                onRefresh();
                            }
                        }, setReceiverParams(id));

                    }
                });
            } else {
                DialogUtils.createAlertDialog(getActivity(), "提示", getString(R.string.tip_deal_psw), true, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
            }
        }
    };

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new RefundSellAdapter(getActivity(), mConfirmReceiver);
    }

    @Override
    public void onItemClick(int position) {
        OrderDetailActivity.newIntent(this, ((RefundSellAdapter) adapter).getItem(position).getId(), 100);
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().marketOrderList(mMarketOrderListResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().marketOrderList(mMarketOrderListResponseModelObserver, setParams());
    }

    private MarketOrderListRequestModel setParams() {
        MarketOrderListRequestModel marketOrderListRequestModel = new MarketOrderListRequestModel();
        marketOrderListRequestModel.setCmd(ApiInterface.MarketOrderList);
        marketOrderListRequestModel.setToken(BaseApplication.getToken());
        MarketOrderListRequestModel.ParametersEntity paramsEntity = new MarketOrderListRequestModel.ParametersEntity();
        paramsEntity.setPageNo(pager);
        paramsEntity.setNumberOfPerPage(pagerSize);
        paramsEntity.setOrderType("refund");
        paramsEntity.setSaleType("sell");
        marketOrderListRequestModel.setParameters(paramsEntity);
        return marketOrderListRequestModel;
    }

    private MarketOrderSellerReceiveRequestModel setReceiverParams(int id) {
        MarketOrderSellerReceiveRequestModel marketOrderSellerReceiveRequestModel = new MarketOrderSellerReceiveRequestModel();
        marketOrderSellerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderSellerReceiveRequestModel.setCmd(ApiInterface.MarketOrderSellerReceive);
        marketOrderSellerReceiveRequestModel.setParameters(new MarketOrderSellerReceiveRequestModel.ParametersEntity(id));
        return marketOrderSellerReceiveRequestModel;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == 100 && resultCode == -1) {
            onRefresh();
        }
        super.onActivityResult(requestCode, resultCode, data);

    }

    @Override
    protected Observer<WalletAccountValiatePayPasswordResponseModel> getPswValiate() {
        return null;
    }
}
