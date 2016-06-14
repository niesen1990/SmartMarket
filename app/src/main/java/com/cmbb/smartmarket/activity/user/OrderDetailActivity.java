package com.cmbb.smartmarket.activity.user;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.PayActivity;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.activity.user.adapter.OrderDetailListAdapter;
import com.cmbb.smartmarket.activity.user.adapter.OrderDetailStatusListAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderBuyStatus;
import com.cmbb.smartmarket.activity.user.model.OrderRefundBuyStatus;
import com.cmbb.smartmarket.activity.user.model.OrderRefundSellStatus;
import com.cmbb.smartmarket.activity.user.model.OrderSoldStatus;
import com.cmbb.smartmarket.activity.wallet.BaseAccountRecyclerActivity;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.cmbb.smartmarket.utils.SPCache;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 下午1:17
 * 修改人：N.Sun
 * 修改时间：16/5/31 下午1:17
 * 修改备注：
 */
public class OrderDetailActivity extends BaseAccountRecyclerActivity {
    private static final String TAG = OrderDetailActivity.class.getSimpleName();

    @BindView(R.id.tv_head)
    ImageView tvHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_contact)
    TextView tvContact;
    @BindView(R.id.iv_com)
    ImageView ivCom;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_price)
    TextView tvPrice;
    @BindView(R.id.tv_receiver)
    TextView tvReceiver;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_sell_nick)
    TextView tvSellNick;
    @BindView(R.id.tv_order_code)
    TextView tvOrderCode;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.recycler)
    EasyRecyclerView recycler;

    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.tv_operation01)
    TextView tvOperation01;
    @BindView(R.id.tv_operation02)
    TextView tvOperation02;
    OrderDetailStatusListAdapter recyclerAdapter;
    String imUserIdBuy;
    String imUserIdSell;
    String orderType;
    String saleType;

    Observer<MarketOrderDetailResponseModel> mMarketOrderDetailResponseModelObserver = new Observer<MarketOrderDetailResponseModel>() {
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
        public void onNext(MarketOrderDetailResponseModel marketOrderDetailResponseModel) {
            if (marketOrderDetailResponseModel == null)
                return;
            orderType = marketOrderDetailResponseModel.getData().getOrderType();
            saleType = marketOrderDetailResponseModel.getData().getSaleType();
            recyclerAdapter.clear();
            adapter.clear();
            if (marketOrderDetailResponseModel.getData().getLogistics() == null) {
                mSmartRecyclerView.showEmpty();
            } else {
                adapter.addAll(marketOrderDetailResponseModel.getData().getLogistics());
            }

            if (marketOrderDetailResponseModel.getData().getProcess() != null && marketOrderDetailResponseModel.getData().getProcess().size() > 0)
                recyclerAdapter.addAll(marketOrderDetailResponseModel.getData().getProcess());
            //更新UI
            imUserIdBuy = marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getImUserId();
            imUserIdSell = marketOrderDetailResponseModel.getData().getBuyUser().getImUserId();
            if (marketOrderDetailResponseModel.getData().getProduct().getProductImageList() != null && marketOrderDetailResponseModel.getData().getProduct().getProductImageList().size() > 0)
                ImageLoader.loadCenterCropCache(OrderDetailActivity.this, marketOrderDetailResponseModel.getData().getProduct().getProductImageList().get(0).getLocation(), ivCom);
            if (saleType.equals("buy")) {
                ImageLoader.loadUrlAndDiskCache(OrderDetailActivity.this, marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getUserImg(), tvHead, new CircleTransform(OrderDetailActivity.this));
                tvNick.setText(marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getNickName());
                tvContact.setOnClickListener(OrderDetailActivity.this);
            } else {
                ImageLoader.loadUrlAndDiskCache(OrderDetailActivity.this, marketOrderDetailResponseModel.getData().getBuyUser().getUserImg(), tvHead, new CircleTransform(OrderDetailActivity.this));
                tvNick.setText(marketOrderDetailResponseModel.getData().getBuyUser().getNickName());
                tvContact.setOnClickListener(OrderDetailActivity.this);
            }

            tvTitle.setText(marketOrderDetailResponseModel.getData().getProduct().getTitle());
            if (marketOrderDetailResponseModel.getData().getProduct().getFreight() == 0) {
                tvPrice.setText("￥" + marketOrderDetailResponseModel.getData().getProduct().getCurrentPrice() + " ( 包含快递费 ) ");
            } else {
                tvPrice.setText("￥" + (marketOrderDetailResponseModel.getData().getProduct().getCurrentPrice() + marketOrderDetailResponseModel.getData().getProduct().getFreight()) + " ( 含" + marketOrderDetailResponseModel.getData().getProduct().getFreight() + "元运费）");
            }
            tvReceiver.setText(marketOrderDetailResponseModel.getData().getReceiveName() + "  " + marketOrderDetailResponseModel.getData().getReceivePhone());
            tvAddress.setText(marketOrderDetailResponseModel.getData().getAddress());
            tvSellNick.setText(marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getNickName());
            tvOrderCode.setText(marketOrderDetailResponseModel.getData().getOrderCode());
            tvTime.setText(marketOrderDetailResponseModel.getData().getPayDate());
            initBottomView(marketOrderDetailResponseModel);
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("订单详情");
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        recyclerAdapter = new OrderDetailStatusListAdapter(this);
        recycler.setLayoutManager(linearLayoutManager);
        recycler.setAdapter(recyclerAdapter);
        onRefresh();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_contact:
                if (saleType.equals("buy")) {
                    if (TextUtils.isEmpty(imUserIdBuy))
                        return;
                    Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(imUserIdBuy, IMHelper.getAppKey());
                    startActivity(intent);
                } else {
                    if (TextUtils.isEmpty(imUserIdSell))
                        return;
                    Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(imUserIdSell, IMHelper.getAppKey());
                    startActivity(intent);
                }
                break;
        }
    }

    @Override
    protected Observer<WalletAccountValiatePayPasswordResponseModel> getPswValiate() {
        return null;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new OrderDetailListAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_order_detail_layout;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore() {
        adapter.stopMore();
        mSmartRecyclerView.showEmpty();
    }

    @Override
    public void onRefresh() {
        subscription = HttpMethod.getInstance().marketOrderDetail(mMarketOrderDetailResponseModelObserver, setParams());
    }

    protected void initBottomView(final MarketOrderDetailResponseModel response) {
        if (orderType.equals("order") && saleType.equals("buy")) {
            String[] items = OrderBuyStatus.getStatus(response.getData().getStatus());
            if (TextUtils.isEmpty(items[0]) && TextUtils.isEmpty(items[1])) {
                llBottom.setVisibility(View.GONE);
                return;
            } else if (!TextUtils.isEmpty(items[0]) && !TextUtils.isEmpty(items[1])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.VISIBLE);
            } else if (TextUtils.isEmpty(items[0])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.GONE);
            } else {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.GONE);
            }
            tvOperation01.setText(OrderBuyStatus.getStatus(response.getData().getStatus())[0]);
            tvOperation02.setText(OrderBuyStatus.getStatus(response.getData().getStatus())[1]);
            tvOperation01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (((TextView) v).getText().toString()) {
                        case "取消订单":
                            CancelOrderActivity.newIntent(OrderDetailActivity.this, response.getData().getId());
                            break;
                        case "申请退款":
                            ApplyRefundActivity.newIntent(OrderDetailActivity.this, response);
                            break;
                    }
                }
            });
            tvOperation02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (((TextView) v).getText().toString()) {
                        case "立即支付":
                            PayActivity.newIntent(OrderDetailActivity.this, response.getData().getOrderCode(), response.getData().getPrice());
                            break;
                        case "提醒发货":
                            HttpMethod.getInstance().marketOrderNotice(new Observer<MarketOrderNoticeResponseModel>() {
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
                                public void onNext(MarketOrderNoticeResponseModel marketOrderNoticeResponseModel) {
                                    if (marketOrderNoticeResponseModel == null)
                                        return;
                                    showToast(marketOrderNoticeResponseModel.getMsg());
                                }
                            }, setOrderBuyNoticeParams());
                            break;
                        case "确认收货":
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
                                        hideWaitingDialog();
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
                                                    finish();
                                                }
                                            }, setOrderBuyConfirmExpressParams(response.getData().getId()));
                                        }
                                    }
                                });
                            } else {
                                DialogUtils.createAlertDialog(OrderDetailActivity.this, "提示", getString(R.string.tip_deal_psw), true, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        onBackPressed();
                                    }
                                });
                            }
                            break;
                        case "立即评价":
                            ImmediateEvaluationActivity.newIntent(OrderDetailActivity.this, response.getData().getId());
                            break;
                        case "查看评价":
                            CheckEvaluateActivity.newIntent(OrderDetailActivity.this, response.getData().getId());
                            break;
                    }
                }
            });
        } else if (orderType.equals("order") && saleType.equals("sell")) {
            String[] items = OrderSoldStatus.getStatus(response.getData().getStatus());
            if (TextUtils.isEmpty(items[0]) && TextUtils.isEmpty(items[1])) {
                llBottom.setVisibility(View.GONE);
                return;
            } else if (!TextUtils.isEmpty(items[0]) && !TextUtils.isEmpty(items[1])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.VISIBLE);
                return;
            } else if (TextUtils.isEmpty(items[0])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.GONE);
            } else {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.GONE);
            }
            tvOperation01.setText(items[0]);
            tvOperation02.setText(items[1]);
            tvOperation01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                }
            });
            tvOperation02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (((TextView) v).getText().toString()) {
                        case "确认发货":
                            ExpressActivity.newIntent(OrderDetailActivity.this, response.getData().getId(), 0);
                            break;
                        case "提醒收货":
                            showWaitingDialog();
                            HttpMethod.getInstance().marketOrderNotice(new Observer<MarketOrderNoticeResponseModel>() {
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
                                public void onNext(MarketOrderNoticeResponseModel marketOrderNoticeResponseModel) {
                                    if (marketOrderNoticeResponseModel == null)
                                        return;
                                    showToast(marketOrderNoticeResponseModel.getMsg());
                                }
                            }, setOrderSellNoticeParams());
                            break;
                        case "查看评价":
                            EvaluationForSellerActivity.newIntent(OrderDetailActivity.this, response.getData().getId());
                            break;
                    }
                }
            });
        } else if (orderType.equals("refund") && saleType.equals("buy")) {
            String[] items = OrderRefundBuyStatus.getStatus(response.getData().getStatus());
            if (TextUtils.isEmpty(items[1]) && TextUtils.isEmpty(items[2])) {
                llBottom.setVisibility(View.GONE);
                return;
            } else if (!TextUtils.isEmpty(items[1]) && !TextUtils.isEmpty(items[2])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.VISIBLE);
            } else if (TextUtils.isEmpty(items[1])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.GONE);
            } else {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.GONE);
            }
            tvOperation01.setText(items[1]);
            tvOperation02.setText(items[2]);
            tvOperation01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (tvOperation02.getText().toString()) {
                        case "拒绝原因":
                            CheckRejectForBuyActivity.newIntent(OrderDetailActivity.this, response);
                            break;
                    }
                }
            });
            tvOperation02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (tvOperation02.getText().toString()) {
                        case "退货":
                            ExpressActivity.newIntent(OrderDetailActivity.this, response.getData().getId(), 1);
                            break;
                        case "重新申请退款":
                            ApplyRefundActivity.newIntent(OrderDetailActivity.this, response);
                            break;
                        case "提醒收货":
                            HttpMethod.getInstance().marketOrderNotice(new Observer<MarketOrderNoticeResponseModel>() {
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
                                public void onNext(MarketOrderNoticeResponseModel marketOrderNoticeResponseModel) {
                                    if (marketOrderNoticeResponseModel == null)
                                        return;
                                    showToast(marketOrderNoticeResponseModel.getMsg());
                                }
                            }, setRefundBuyNoticeParams());
                            break;
                    }
                }
            });
        } else if (orderType.equals("refund") && saleType.equals("sell")) {
            String[] items = OrderRefundSellStatus.getStatus(response.getData().getStatus());
            Log.e(TAG, "items = " + items[1] + "  " + items[2]);
            Log.e(TAG, "getStatus = " + response.getData().getStatus());
            if (TextUtils.isEmpty(items[1]) && TextUtils.isEmpty(items[2])) {
                llBottom.setVisibility(View.GONE);
                return;
            } else if (!TextUtils.isEmpty(items[1]) && !TextUtils.isEmpty(items[2])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.VISIBLE);
                return;
            } else if (TextUtils.isEmpty(items[1])) {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation01.setVisibility(View.GONE);
            } else {
                llBottom.setVisibility(View.VISIBLE);
                tvOperation02.setVisibility(View.GONE);
            }

            tvOperation01.setText(items[1]);
            tvOperation02.setText(items[2]);
            tvOperation01.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (tvOperation02.getText().toString()) {
                        case "拒绝":
                            RejectRefundReasonActivity.newIntent(OrderDetailActivity.this, response.getData().getId());
                            break;
                    }
                }
            });
            tvOperation02.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    switch (tvOperation02.getText().toString()) {
                        case "同意":
                            DialogUtils.createAlertDialog(OrderDetailActivity.this, "警告", "您确定同意付款吗？", true, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    showWaitingDialog();
                                    HttpMethod.getInstance().marketOrderRefund(new Observer<MarketOrderRefundResponseModel>() {
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
                                        public void onNext(MarketOrderRefundResponseModel marketOrderRefundResponseModel) {
                                            if (marketOrderRefundResponseModel == null)
                                                return;
                                            showToast(marketOrderRefundResponseModel.getMsg());
                                            onRefresh();
                                        }
                                    }, setRefundSellAgreeParams(response));
                                }
                            });
                            break;
                        case "提醒退货":
                            // TODO: 16/5/31
                            HttpMethod.getInstance().marketOrderNotice(new Observer<MarketOrderNoticeResponseModel>() {
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
                                public void onNext(MarketOrderNoticeResponseModel marketOrderNoticeResponseModel) {
                                    if (marketOrderNoticeResponseModel == null)
                                        return;
                                    showToast(marketOrderNoticeResponseModel.getMsg());
                                }
                            }, setRefundSellNoticeParams());
                            break;
                        case "确认收货":
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
                                            HttpMethod.getInstance().marketOrderSellerReceive(new Observer<MarketOrderSellerReceiveResponseModel>() {
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
                                                public void onNext(MarketOrderSellerReceiveResponseModel marketOrderSellerReceiveResponseModel) {
                                                    if (marketOrderSellerReceiveResponseModel == null)
                                                        return;
                                                    showToast(marketOrderSellerReceiveResponseModel.getMsg());
                                                    finish();
                                                }
                                            }, setRefundSellReceiverParams(response.getData().getId()));
                                        }
                                    }
                                });
                            } else {
                                DialogUtils.createAlertDialog(OrderDetailActivity.this, "提示", getString(R.string.tip_deal_psw), true, new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface dialog, int which) {
                                        onBackPressed();
                                    }
                                });
                            }
                            break;
                        case "拒绝原因":
                            CheckRejectForBuyActivity.newIntent(OrderDetailActivity.this, response);
                            break;
                    }
                }
            });
        }
    }

    private MarketOrderDetailRequestModel setParams() {
        MarketOrderDetailRequestModel marketOrderDetailRequestModel = new MarketOrderDetailRequestModel();
        marketOrderDetailRequestModel.setToken(BaseApplication.getToken());
        marketOrderDetailRequestModel.setCmd(ApiInterface.MarketOrderDetail);
        marketOrderDetailRequestModel.setParameters(new MarketOrderDetailRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1)));
        return marketOrderDetailRequestModel;
    }

    private MarketOrderNoticeRequestModel setRefundBuyNoticeParams() {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("refund", "buy", getIntent().getIntExtra("orderId", -1)));
        return marketOrderNoticeRequestModel;
    }

    private MarketOrderNoticeRequestModel setOrderSellNoticeParams() {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("order", "sell", getIntent().getIntExtra("orderId", -1)));
        return marketOrderNoticeRequestModel;
    }

    private MarketOrderNoticeRequestModel setOrderBuyNoticeParams() {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("order", "buy", getIntent().getIntExtra("orderId", -1)));
        return marketOrderNoticeRequestModel;
    }

    private MarketOrderBuyerReceiveRequestModel setOrderBuyConfirmExpressParams(int orderId) {
        MarketOrderBuyerReceiveRequestModel marketOrderBuyerReceiveRequestModel = new MarketOrderBuyerReceiveRequestModel();
        marketOrderBuyerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderBuyerReceiveRequestModel.setCmd(ApiInterface.MarketOrderBuyerReceive);
        marketOrderBuyerReceiveRequestModel.setParameters(new MarketOrderBuyerReceiveRequestModel.ParametersEntity(orderId));
        return marketOrderBuyerReceiveRequestModel;
    }

    private MarketOrderNoticeRequestModel setRefundSellNoticeParams() {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("refund", "sell", getIntent().getIntExtra("orderId", -1)));
        return marketOrderNoticeRequestModel;
    }

    private MarketOrderSellerReceiveRequestModel setRefundSellReceiverParams(int id) {
        MarketOrderSellerReceiveRequestModel marketOrderSellerReceiveRequestModel = new MarketOrderSellerReceiveRequestModel();
        marketOrderSellerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderSellerReceiveRequestModel.setCmd(ApiInterface.MarketOrderSellerReceive);
        marketOrderSellerReceiveRequestModel.setParameters(new MarketOrderSellerReceiveRequestModel.ParametersEntity(id));
        return marketOrderSellerReceiveRequestModel;
    }

    private MarketOrderRefundRequestModel setRefundSellAgreeParams(MarketOrderDetailResponseModel response) {
        MarketOrderRefundRequestModel marketOrderRefundRequestModel = new MarketOrderRefundRequestModel();
        marketOrderRefundRequestModel.setToken(BaseApplication.getToken());
        marketOrderRefundRequestModel.setCmd(ApiInterface.MarketOrderRefund);
        marketOrderRefundRequestModel.setParameters(new MarketOrderRefundRequestModel.ParametersEntity(response.getData().getId(), "AGREE", ""));
        return marketOrderRefundRequestModel;
    }

    public static void newIntent(BaseActivity context, int orderId, int requestCode) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivityForResult(intent, requestCode);
    }

    public static void newIntent(Fragment context, int orderId, int requestCode) {
        Intent intent = new Intent(context.getContext(), OrderDetailActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivityForResult(intent, requestCode);
    }

}
