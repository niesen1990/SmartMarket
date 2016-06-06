package com.cmbb.smartmarket.activity.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetPageRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetPageResponseModel;
import com.cmbb.smartmarket.activity.message.adapter.MessageStoreAdapter;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/27 下午7:02
 */
public class StoreMessageActivity extends BaseMessageActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("商品消息");
        onRefresh();
        cancelMessage();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new MessageStoreAdapter(this);
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.global_padding)));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_message_system_layout;
    }

    @Override
    public void onItemClick(int position) {

    }

    Observer<MarketMessageGetPageResponseModel> mMarketMessageGetPageResponseModelObserver = new Observer<MarketMessageGetPageResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MarketMessageGetPageResponseModel marketMessageGetPageResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketMessageGetPageResponseModel.getData().getContent());
        }
    };


    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().marketMessageGetPage(mMarketMessageGetPageResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().marketMessageGetPage(mMarketMessageGetPageResponseModelObserver, setParams());
    }

    private MarketMessageGetPageRequestModel setParams() {
        MarketMessageGetPageRequestModel marketMessageGetPageRequestModel = new MarketMessageGetPageRequestModel();
        marketMessageGetPageRequestModel.setCmd(ApiInterface.MarketMessageGetPage);
        marketMessageGetPageRequestModel.setToken(BaseApplication.getToken());
        marketMessageGetPageRequestModel.setParameters(new MarketMessageGetPageRequestModel.ParametersEntity("product", pagerSize, pager));
        return marketMessageGetPageRequestModel;
    }

    public static void newIntent(Context context, int id) {
        Intent intent = new Intent(context, StoreMessageActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
