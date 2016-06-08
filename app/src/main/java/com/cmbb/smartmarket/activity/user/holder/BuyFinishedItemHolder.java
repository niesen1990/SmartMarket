package com.cmbb.smartmarket.activity.user.holder;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.PayActivity;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.activity.user.ApplyRefundActivity;
import com.cmbb.smartmarket.activity.user.CancelOrderActivity;
import com.cmbb.smartmarket.activity.user.CheckEvaluateActivity;
import com.cmbb.smartmarket.activity.user.ImmediateEvaluationActivity;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderBuyStatus;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import rx.Observer;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class BuyFinishedItemHolder extends BaseViewHolder<MarketOrderListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = BuyFinishedItemHolder.class.getSimpleName();

    private BaseRecyclerActivity mContext;
    private RelativeLayout rl01;
    private TextView tvOrderTag;
    private TextView tvOrder;
    private TextView tvStatus;
    private RelativeLayout rl02;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvContact;
    private TextView tvStatus01;
    private TextView tvStatus02;

    public BuyFinishedItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_buy_finished_list_item);
        mContext = (BaseRecyclerActivity) parent.getContext();
        rl01 = $(R.id.rl01);
        tvOrderTag = $(R.id.tv_order_tag);
        tvOrder = $(R.id.tv_order);
        tvStatus = $(R.id.tv_status);
        rl02 = $(R.id.rl02);
        ivImage = $(R.id.iv_image);
        tvTitle = $(R.id.tv_title);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        tvContact = $(R.id.tv_contact);
        tvStatus01 = $(R.id.tv_status_01);
        tvStatus02 = $(R.id.tv_status_02);
    }

    public void setData(final MarketOrderListResponseModel.DataEntity.ContentEntity row) {
        tvOrder.setText(row.getOrderCode());
        if (row.getProduct().getProductImageList() != null && row.getProduct().getProductImageList().size() > 0)
            ImageLoader.loadCenterCropCache(mContext, row.getProduct().getProductImageList().get(0).getLocation(), ivImage);
        tvTitle.setText(row.getProduct().getTitle());
        tvNewPrice.setText("￥" + row.getProduct().getCurrentPrice());
        if (row.getProduct().getOriginalPrice() == 0) {
            tvOldPrice.setVisibility(View.INVISIBLE);
        } else {
            tvOldPrice.setVisibility(View.VISIBLE);
            tvOldPrice.setText("￥" + row.getProduct().getOriginalPrice());
        }
        tvStatus.setText(row.getStatusName());
        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (row.getProduct().getPublicUser().getImUserId() == null)
                    return;
                Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(row.getProduct().getPublicUser().getImUserId(), IMHelper.getAppKey());
                mContext.startActivity(intent);
            }
        });

        tvStatus01.setText(OrderBuyStatus.getStatus(row.getStatus())[0]);
        tvStatus02.setText(OrderBuyStatus.getStatus(row.getStatus())[1]);
        tvStatus01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView) v).getText().toString()) {
                    case "取消订单":
                        CancelOrderActivity.newIntent(mContext, row.getId());
                        break;
                    case "申请退款":
                        ApplyRefundActivity.newIntent(mContext, row);
                        break;
                }
            }
        });
        tvStatus02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView) v).getText().toString()) {
                    case "立即支付":
                        PayActivity.newIntent(mContext, row.getOrderCode(), row.getPrice());
                        break;
                    case "提醒发货":
                        HttpMethod.getInstance().marketOrderNotice(new Observer<MarketOrderNoticeResponseModel>() {
                            @Override
                            public void onCompleted() {
                                mContext.hideWaitingDialog();
                            }

                            @Override
                            public void onError(Throwable e) {
                                mContext.hideWaitingDialog();
                                Log.e(TAG, e.toString());
                            }

                            @Override
                            public void onNext(MarketOrderNoticeResponseModel marketOrderNoticeResponseModel) {
                                if (marketOrderNoticeResponseModel == null)
                                    return;
                                mContext.showToast(marketOrderNoticeResponseModel.getMsg());
                            }
                        }, setNoticeParams(row.getId()));
                        break;
                    case "确认收货":
                        DialogUtils.createAlertDialog(mContext, "操作提醒", "你确定收获了吗？", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mContext.showWaitingDialog();
                                HttpMethod.getInstance().marketOrderBuyerReceive(new Observer<MarketOrderBuyerReceiveResponseModel>() {
                                    @Override
                                    public void onCompleted() {
                                        mContext.hideWaitingDialog();
                                    }

                                    @Override
                                    public void onError(Throwable e) {
                                        mContext.hideWaitingDialog();
                                        Log.e(TAG, e.toString());
                                    }

                                    @Override
                                    public void onNext(MarketOrderBuyerReceiveResponseModel marketOrderBuyerReceiveResponseModel) {
                                        if (marketOrderBuyerReceiveResponseModel == null)
                                            return;
                                        mContext.showToast(marketOrderBuyerReceiveResponseModel.getMsg());
                                        LocalBroadcastManager.getInstance(mContext).sendBroadcast(new Intent(Constants.INTENT_ACTION_REFRESH));
                                    }
                                }, setConfirmExpressParams(row.getId()));
                            }
                        });
                        break;
                    case "立即评价":
                        ImmediateEvaluationActivity.newIntent(mContext, row.getId());
                        break;
                    case "查看评价":
                        CheckEvaluateActivity.newIntent(mContext, row.getId());
                        break;
                }
            }
        });
    }

    private MarketOrderNoticeRequestModel setNoticeParams(int orderId) {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("order", "buy", orderId));
        return marketOrderNoticeRequestModel;
    }

    private MarketOrderBuyerReceiveRequestModel setConfirmExpressParams(int orderId) {
        MarketOrderBuyerReceiveRequestModel marketOrderBuyerReceiveRequestModel = new MarketOrderBuyerReceiveRequestModel();
        marketOrderBuyerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderBuyerReceiveRequestModel.setCmd(ApiInterface.MarketOrderBuyerReceive);
        marketOrderBuyerReceiveRequestModel.setParameters(new MarketOrderBuyerReceiveRequestModel.ParametersEntity(orderId));
        return marketOrderBuyerReceiveRequestModel;
    }

}
