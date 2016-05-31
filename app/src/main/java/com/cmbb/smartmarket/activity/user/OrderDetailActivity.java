package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.OrderDetailListAdapter;
import com.cmbb.smartmarket.activity.user.adapter.OrderDetailStatusListAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
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
 * 创建时间：16/5/31 下午1:17
 * 修改人：N.Sun
 * 修改时间：16/5/31 下午1:17
 * 修改备注：
 */
public class OrderDetailActivity extends BaseRecyclerActivity {
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
            //
        }
    };

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

    public static void newIntent(Context context, int orderId, String orderType) {
        Intent intent = new Intent(context, OrderDetailActivity.class);
        intent.putExtra("orderId", orderId);
        intent.putExtra("orderType", orderType);
        context.startActivity(intent);
    }
}
