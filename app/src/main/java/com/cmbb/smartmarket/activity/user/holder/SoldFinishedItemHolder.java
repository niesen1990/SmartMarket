package com.cmbb.smartmarket.activity.user.holder;

import android.content.Intent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.activity.user.EvaluationForSellerActivity;
import com.cmbb.smartmarket.activity.user.ExpressActivity;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeResponseModel;
import com.cmbb.smartmarket.activity.user.model.OrderSoldStatus;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

import rx.Observer;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class SoldFinishedItemHolder extends BaseViewHolder<MarketOrderListResponseModel.DataEntity.ContentEntity> {
    private final String TAG = SoldFinishedItemHolder.class.getSimpleName();

    private BaseActivity mContext;
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
    private TextView tvStatus03;

    public SoldFinishedItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_buy_finished_list_item);
        mContext = (BaseActivity) parent.getContext();
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
        tvStatus03 = $(R.id.tv_status_03);
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

        tvStatus01.setText(OrderSoldStatus.getStatus(row.getStatus())[0]);
        tvStatus02.setText(OrderSoldStatus.getStatus(row.getStatus())[1]);
        tvStatus01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        tvStatus02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (((TextView) v).getText().toString()) {
                    case "确认发货":
                        ExpressActivity.newIntent(mContext, row.getId(), 0);
                        break;
                    case "提醒收货":
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
                    case "查看评价":
                        EvaluationForSellerActivity.newIntent(mContext, row.getId());
                        break;
                }
            }
        });
    }

    private MarketOrderNoticeRequestModel setNoticeParams(int orderId) {
        MarketOrderNoticeRequestModel marketOrderNoticeRequestModel = new MarketOrderNoticeRequestModel();
        marketOrderNoticeRequestModel.setCmd(ApiInterface.MarketOrderNotice);
        marketOrderNoticeRequestModel.setToken(BaseApplication.getToken());
        marketOrderNoticeRequestModel.setParameters(new MarketOrderNoticeRequestModel.ParametersEntity("order", "sell", orderId));
        return marketOrderNoticeRequestModel;
    }
}
