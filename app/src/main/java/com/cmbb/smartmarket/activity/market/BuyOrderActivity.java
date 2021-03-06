package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.AddressManagerActivity;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderCommitRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderCommitResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderReserveRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderReserveResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/11 下午1:27
 * 修改人：N.Sun
 * 修改时间：16/5/11 下午1:27
 * 修改备注：
 */
public class BuyOrderActivity extends BaseActivity {

    private static final String TAG = BuyOrderActivity.class.getSimpleName();

    @BindView(R.id.ll_head)
    LinearLayout llHead;
    @BindView(R.id.iv_image)
    ImageView ivImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.rl_price)
    RelativeLayout rlPrice;
    @BindView(R.id.tv_new_price)
    TextView tvNewPrice;
    @BindView(R.id.tv_old_price)
    TextView tvOldPrice;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_line)
    TextView tvLine;
    @BindView(R.id.tv_deal_way)
    TextView tvDealWay;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_detail_address)
    TextView tvDetailAddress;
    @BindView(R.id.iv_right)
    ImageView ivRight;
    @BindView(R.id.tv_express_tag)
    TextView tvExpressTag;
    @BindView(R.id.tv_express)
    TextView tvExpress;
    @BindView(R.id.tv_money)
    TextView tvMoney;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;

    int productId;
    String receiveNick;
    String receivePhone;
    String receiveAddress;
    MarketOrderReserveResponseModel mMarketOrderReserveResponseModel;
    Observer<MarketOrderReserveResponseModel> mMarketOrderReserveResponseModelObserver = new Observer<MarketOrderReserveResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(MarketOrderReserveResponseModel marketOrderReserveResponseModel) {
            hideWaitingDialog();
            if (marketOrderReserveResponseModel != null) {
                mMarketOrderReserveResponseModel = marketOrderReserveResponseModel;
                //更新UI
                if (marketOrderReserveResponseModel.getData().getProduct().getProductImageList() != null)
                    ImageLoader.loadCenterCropCache(BuyOrderActivity.this, marketOrderReserveResponseModel.getData().getProduct().getProductImageList().get(0).getLocation(), ivImage);
                tvTitle.setText(marketOrderReserveResponseModel.getData().getProduct().getTitle());
                tvNewPrice.setText("￥" + marketOrderReserveResponseModel.getData().getProduct().getCurrentPrice());
                if (marketOrderReserveResponseModel.getData().getProduct().getOriginalPrice() == 0) {
                    tvOldPrice.setVisibility(View.INVISIBLE);
                } else {
                    tvOldPrice.setVisibility(View.VISIBLE);
                    tvOldPrice.setText("￥" + marketOrderReserveResponseModel.getData().getProduct().getOriginalPrice());
                }
                if (marketOrderReserveResponseModel.getData().getProduct().getUserLocation() != null)
                    tvAddress.setText(marketOrderReserveResponseModel.getData().getProduct().getUserLocation().getCity() + marketOrderReserveResponseModel.getData().getProduct().getUserLocation().getDistrict());
                //设置是否在线交易
                // TODO: 16/5/23
                receiveNick = marketOrderReserveResponseModel.getData().getReceiveName();
                receivePhone = marketOrderReserveResponseModel.getData().getReceivePhone();
                receiveAddress = marketOrderReserveResponseModel.getData().getAddress();
                if (!TextUtils.isEmpty(receiveNick) && !TextUtils.isEmpty(receivePhone))
                    tvName.setText(marketOrderReserveResponseModel.getData().getReceiveName() + " " + marketOrderReserveResponseModel.getData().getReceivePhone());
                if (!TextUtils.isEmpty(receiveAddress))
                    tvDetailAddress.setText(marketOrderReserveResponseModel.getData().getAddress());
                tvExpress.setText("￥" + marketOrderReserveResponseModel.getData().getProduct().getFreight());
                tvMoney.setText("￥" + marketOrderReserveResponseModel.getData().getPrice());
            }
        }
    };

    Observer<MarketOrderCommitResponseModel> mMarketOrderCommitResponseModelObserver = new Observer<MarketOrderCommitResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketOrderCommitResponseModel marketOrderCommitResponseModel) {
            hideWaitingDialog();
            if (marketOrderCommitResponseModel != null) {
                PayActivity.newIntent(BuyOrderActivity.this, marketOrderCommitResponseModel.getData().getOrderCode(), mMarketOrderReserveResponseModel.getData().getPrice());
                finish();
            }
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("购买宝贝");
        productId = getIntent().getIntExtra("productId", -1);
        if (productId != -1)
            subscription = HttpMethod.getInstance().marketOrderReserveDelete(mMarketOrderReserveResponseModelObserver, setParams());
        ivRight.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
    }

    private MarketOrderReserveRequestModel setParams() {
        showWaitingDialog();
        MarketOrderReserveRequestModel requestModel = new MarketOrderReserveRequestModel();
        requestModel.setCmd(ApiInterface.MarketOrderReserve);
        requestModel.setToken(BaseApplication.token);
        requestModel.setParameters(new MarketOrderReserveRequestModel.ParametersEntity(productId));
        return requestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_buy_order_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.iv_right:
                AddressManagerActivity.newIntent(this, 100);
                break;
            case R.id.tv_confirm:
                if (TextUtils.isEmpty(receiveNick) || TextUtils.isEmpty(receiveAddress)) {
                    showToast("请设置收获地址");
                    return;
                }
                showWaitingDialog();
                subscription = HttpMethod.getInstance().marketOrderCommitDelete(mMarketOrderCommitResponseModelObserver, setCommitParams());
                break;
        }
    }

    private MarketOrderCommitRequestModel setCommitParams() {
        MarketOrderCommitRequestModel marketOrderCommitRequestModel = new MarketOrderCommitRequestModel();
        marketOrderCommitRequestModel.setCmd(ApiInterface.MarketOrderCommit);
        marketOrderCommitRequestModel.setToken(BaseApplication.getToken());
        marketOrderCommitRequestModel.setParameters(new MarketOrderCommitRequestModel.ParametersEntity(productId,
                mMarketOrderReserveResponseModel.getData().getPrice(),
                mMarketOrderReserveResponseModel.getData().getFreight(),
                receiveNick,
                receivePhone,
                receiveAddress,
                mMarketOrderReserveResponseModel.getData().getPostCode()));
        return marketOrderCommitRequestModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK && data != null) {
            UserAddressGetPageResponseModel.DataEntity.RowsEntity rowsEntity = data.getParcelableExtra("data");
            receiveNick = rowsEntity.getReceiveName();
            receivePhone = rowsEntity.getReceivePhone();
            receiveAddress = rowsEntity.getProvinceText() + rowsEntity.getCityText() + rowsEntity.getDistrictText() + rowsEntity.getAddress();
            tvName.setText(receiveNick + " " + receivePhone);
            tvDetailAddress.setText(receiveAddress);
        }
    }

    public static void newIntent(Context context, int productId) {
        Intent intent = new Intent(context, BuyOrderActivity.class);
        intent.putExtra("productId", productId);
        context.startActivity(intent);
    }
}
