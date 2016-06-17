package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.BuyFinishedAdapter;
import com.cmbb.smartmarket.activity.user.holder.BuyFinishedItemHolder;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.wallet.BaseAccountRecyclerActivity;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
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

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 下午3:28
 * 修改人：N.Sun
 * 修改时间：16/5/6 下午3:28
 * 修改备注：
 */
public class BuyFinishedActivity extends BaseAccountRecyclerActivity {
    private static final String TAG = BuyFinishedActivity.class.getSimpleName();

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("宝贝已购");
        onRefresh();
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.global_padding)));
    }

    Observer<MarketOrderListResponseModel> mMarketOrderListResponseModelObserver = new Observer<MarketOrderListResponseModel>() {
        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketOrderListResponseModel marketOrderListResponseModel) {
            if (marketOrderListResponseModel != null) {
                if (pager == 0)
                    adapter.clear();
                adapter.addAll(marketOrderListResponseModel.getData().getContent());
            }
        }
    };

    BuyFinishedItemHolder.ConfirmReceiverListener mConfirmReceiverListener = new BuyFinishedItemHolder.ConfirmReceiverListener() {
        @Override
        public void onClick(final int id) {
            if (SPCache.getBoolean(Constants.HAS_WALLET_PSW, false)) {
                showBottomSheet(new Observer<WalletAccountValiatePayPasswordResponseModel>() {
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
                    public void onNext(WalletAccountValiatePayPasswordResponseModel walletAccountValiatePayPasswordResponseModel) {
                        if (walletAccountValiatePayPasswordResponseModel != null) {
                            showWaitingDialog();
                            HttpMethod.getInstance().marketOrderBuyerReceive(new Observer<MarketOrderBuyerReceiveResponseModel>() {
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
                                public void onNext(MarketOrderBuyerReceiveResponseModel marketOrderBuyerReceiveResponseModel) {
                                    if (marketOrderBuyerReceiveResponseModel == null)
                                        return;
                                    showToast(marketOrderBuyerReceiveResponseModel.getMsg());
                                    onRefresh();
                                }
                            }, setConfirmExpressParams(id));

                        }
                    }
                });
            } else {
                DialogUtils.createAlertDialog(BuyFinishedActivity.this, "提示", getString(R.string.tip_deal_psw), true, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });
            }
        }
    };

    @Override
    protected Observer<WalletAccountValiatePayPasswordResponseModel> getPswValiate() {
        return null;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new BuyFinishedAdapter(this, mConfirmReceiverListener);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_finished_layout;
    }

    @Override
    public void onItemClick(View rootView, int position) {
        OrderDetailActivity.newIntent(this, ((BuyFinishedAdapter) adapter).getItem(position).getId(), 100);
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().marketOrderList(mMarketOrderListResponseModelObserver, setParams());
    }

    private MarketOrderListRequestModel setParams() {
        MarketOrderListRequestModel marketOrderListRequestModel = new MarketOrderListRequestModel();
        marketOrderListRequestModel.setCmd(ApiInterface.MarketOrderList);
        marketOrderListRequestModel.setToken(BaseApplication.getToken());
        MarketOrderListRequestModel.ParametersEntity parametersEntity = new MarketOrderListRequestModel.ParametersEntity();
        parametersEntity.setPageNo(pager);
        parametersEntity.setNumberOfPerPage(pagerSize);
        parametersEntity.setOrderType("order");
        parametersEntity.setSaleType("buy");
        marketOrderListRequestModel.setParameters(parametersEntity);
        return marketOrderListRequestModel;
    }

    private MarketOrderBuyerReceiveRequestModel setConfirmExpressParams(int orderId) {
        MarketOrderBuyerReceiveRequestModel marketOrderBuyerReceiveRequestModel = new MarketOrderBuyerReceiveRequestModel();
        marketOrderBuyerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderBuyerReceiveRequestModel.setCmd(ApiInterface.MarketOrderBuyerReceive);
        marketOrderBuyerReceiveRequestModel.setParameters(new MarketOrderBuyerReceiveRequestModel.ParametersEntity(orderId));
        return marketOrderBuyerReceiveRequestModel;
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().marketOrderList(mMarketOrderListResponseModelObserver, setParams());
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            onRefresh();
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, BuyFinishedActivity.class);
        context.startActivity(intent);
    }

}
