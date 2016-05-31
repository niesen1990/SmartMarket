package com.cmbb.smartmarket.activity.user.holder;

import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.activity.user.CheckRefundActivity;
import com.cmbb.smartmarket.activity.user.CheckRejectActivity;
import com.cmbb.smartmarket.activity.user.RejectRefundReasonActivity;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderRefundSellStatus;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.CircleTransform;
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
public class RefundSellItemHolder extends BaseViewHolder<MarketOrderListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = RefundSellItemHolder.class.getSimpleName();

    private RelativeLayout rl01;
    private TextView tvOrderTag;
    private TextView tvOrder;
    private TextView tvStatus;
    private RelativeLayout rl02;
    private ImageView ivImage;
    private TextView tvTitle;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private TextView tvRefundMoneyTag;
    private TextView tvRefundMoney;
    private TextView tvDealMoney;
    private TextView tvDealMoneyTag;
    private TextView tvContact;
    private TextView tvOperation01;
    private TextView tvOperation02;
    private TextView tvOperation03;
    private BaseRecyclerActivity mContext;

    public RefundSellItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_refund_list_item);
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
        tvRefundMoneyTag = $(R.id.tv_refund_money_tag);
        tvRefundMoney = $(R.id.tv_refund_money);
        tvDealMoney = $(R.id.tv_deal_money);
        tvDealMoneyTag = $(R.id.tv_deal_money_tag);
        tvContact = $(R.id.tv_contact);
        tvOperation01 = $(R.id.tv_operation01);
        tvOperation02 = $(R.id.tv_operation02);
        tvOperation03 = $(R.id.tv_operation03);
    }

    public void setData(final MarketOrderListResponseModel.DataEntity.ContentEntity row) {
        if (row == null)
            return;
        tvOrder.setText(row.getOrderCode());
        tvStatus.setText(row.getRefundStatusName());
        ImageLoader.loadUrlAndDiskCache(mContext, row.getProduct().getPublicUser().getUserImg(), ivImage, new CircleTransform(mContext));
        tvTitle.setText(row.getProduct().getTitle());
        tvNewPrice.setText("￥" + row.getProduct().getCurrentPrice());
        tvOldPrice.setText("￥" + row.getProduct().getOriginalPrice());
        tvDealMoney.setText("￥" + row.getPrice());
        tvRefundMoney.setText("￥" + row.getPrice());
        tvContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(row.getProduct().getPublicUser().getImUserId(), IMHelper.getAppKey());
                mContext.startActivity(intent);
            }
        });
        String[] operations = OrderRefundSellStatus.getStatus(row.getRefundStatus());
        tvOperation01.setText(operations[0]);
        tvOperation02.setText(operations[1]);
        tvOperation03.setText(operations[2]);
        tvOperation01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tvOperation02.getText().toString()) {
                    case "退款详情":
                        CheckRefundActivity.newIntent(mContext, row);
                        break;
                }
            }
        });
        tvOperation02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tvOperation02.getText().toString()) {
                    case "拒绝":
                        RejectRefundReasonActivity.newIntent(mContext, row.getId());
                        break;
                }
            }
        });
        tvOperation03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (tvOperation02.getText().toString()) {
                    case "同意":
                        DialogUtils.createAlertDialog(mContext, "警告", "您确定同意付款吗？", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mContext.showWaitingDialog();
                                HttpMethod.getInstance().marketOrderRefund(new Observer<MarketOrderRefundResponseModel>() {
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
                                    public void onNext(MarketOrderRefundResponseModel marketOrderRefundResponseModel) {
                                        if (marketOrderRefundResponseModel == null)
                                            return;
                                        mContext.showToast(marketOrderRefundResponseModel.getMsg());
                                        mContext.onRefresh();
                                    }
                                }, setAgreeParams(row));
                            }
                        });
                        break;
                    case "提醒退货":
                        // TODO: 16/5/31
                        break;
                    case "确认收货":
                        DialogUtils.createAlertDialog(mContext, "警告", "确认收货了吗？", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                mContext.showWaitingDialog();
                                HttpMethod.getInstance().marketOrderSellerReceive(new Observer<MarketOrderSellerReceiveResponseModel>() {
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
                                    public void onNext(MarketOrderSellerReceiveResponseModel marketOrderSellerReceiveResponseModel) {
                                        if (marketOrderSellerReceiveResponseModel == null)
                                            return;
                                        mContext.showToast(marketOrderSellerReceiveResponseModel.getMsg());
                                        mContext.onRefresh();
                                    }
                                }, setReceiverParams(row.getId()));
                            }
                        });
                        break;
                    case "拒绝原因":
                        CheckRejectActivity.newIntent(mContext, row);
                        break;
                }
            }
        });
    }

    private MarketOrderSellerReceiveRequestModel setReceiverParams(int id) {
        MarketOrderSellerReceiveRequestModel marketOrderSellerReceiveRequestModel = new MarketOrderSellerReceiveRequestModel();
        marketOrderSellerReceiveRequestModel.setToken(BaseApplication.getToken());
        marketOrderSellerReceiveRequestModel.setCmd(ApiInterface.MarketOrderSellerReceive);
        marketOrderSellerReceiveRequestModel.setParameters(new MarketOrderSellerReceiveRequestModel.ParametersEntity(id));
        return marketOrderSellerReceiveRequestModel;
    }

    private MarketOrderRefundRequestModel setAgreeParams(MarketOrderListResponseModel.DataEntity.ContentEntity dataEntity) {
        MarketOrderRefundRequestModel marketOrderRefundRequestModel = new MarketOrderRefundRequestModel();
        marketOrderRefundRequestModel.setToken(BaseApplication.getToken());
        marketOrderRefundRequestModel.setCmd(ApiInterface.MarketOrderRefund);
        marketOrderRefundRequestModel.setParameters(new MarketOrderRefundRequestModel.ParametersEntity(dataEntity.getId(), "AGREE", ""));
        return marketOrderRefundRequestModel;
    }

}
