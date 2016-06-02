package com.cmbb.smartmarket.activity.user;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.OrderDetailListAdapter;
import com.cmbb.smartmarket.activity.user.adapter.OrderDetailStatusListAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
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
public abstract class OrderDetailBaseActivity extends BaseRecyclerActivity {
    private static final String TAG = OrderDetailBaseActivity.class.getSimpleName();

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
            recyclerAdapter.clear();
            adapter.clear();
            recyclerAdapter.addAll(marketOrderDetailResponseModel.getData().getProcess());
            adapter.addAll(marketOrderDetailResponseModel.getData().getLogistics());
            //更新UI
            ImageLoader.loadUrlAndDiskCache(OrderDetailBaseActivity.this, marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getUserImg(), tvHead, new CircleTransform(OrderDetailBaseActivity.this));
            if (marketOrderDetailResponseModel.getData().getProduct().getProductImageList() != null && marketOrderDetailResponseModel.getData().getProduct().getProductImageList().size() > 0)
                ImageLoader.loadCenterCropCache(OrderDetailBaseActivity.this, marketOrderDetailResponseModel.getData().getProduct().getProductImageList().get(0).getLocation(), ivCom);
            tvNick.setText(marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getNickName());
            tvContact.setOnClickListener(OrderDetailBaseActivity.this);
            tvTitle.setText(marketOrderDetailResponseModel.getData().getProduct().getTitle());
            if (marketOrderDetailResponseModel.getData().getProduct().getFreight() == 0) {
                tvPrice.setText("￥" + marketOrderDetailResponseModel.getData().getProduct().getCurrentPrice() + " ( 包快递费 ) ");
            } else {
                tvPrice.setText("￥" + (marketOrderDetailResponseModel.getData().getProduct().getCurrentPrice() + marketOrderDetailResponseModel.getData().getProduct().getFreight()) + " ( 含" + marketOrderDetailResponseModel.getData().getProduct().getFreight() + "元运费）");
            }
            tvReceiver.setText(marketOrderDetailResponseModel.getData().getReceiveName());
            tvAddress.setText(marketOrderDetailResponseModel.getData().getAddress());
            tvSellNick.setText(marketOrderDetailResponseModel.getData().getProduct().getPublicUser().getNickName());
            tvOrderCode.setText(marketOrderDetailResponseModel.getData().getOrderCode());
            tvTime.setText(new JTimeTransform(marketOrderDetailResponseModel.getData().getPayDate()).toString(new RecentDateFormat()));

            initBottomView(marketOrderDetailResponseModel);
        }
    };

    protected abstract void initBottomView(MarketOrderDetailResponseModel response);

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("订单详情");
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 20);
        gridLayoutManager.setSpanSizeLookup(adapter.obtainGridSpanSizeLookUp(4));
        recyclerAdapter = new OrderDetailStatusListAdapter(this);
        recycler.setLayoutManager(gridLayoutManager);
        recycler.setAdapter(recyclerAdapter);
        onRefresh();
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

    private MarketOrderDetailRequestModel setParams() {
        MarketOrderDetailRequestModel marketOrderDetailRequestModel = new MarketOrderDetailRequestModel();
        marketOrderDetailRequestModel.setToken(BaseApplication.getToken());
        marketOrderDetailRequestModel.setCmd(ApiInterface.MarketOrderDetail);
        marketOrderDetailRequestModel.setParameters(new MarketOrderDetailRequestModel.ParametersEntity(getIntent().getStringExtra("orderType"), getIntent().getIntExtra("orderId", -1)));
        return marketOrderDetailRequestModel;
    }

}
