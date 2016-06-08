package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.EvaluateListAdapter;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/11 上午11:06
 * 修改人：N.Sun
 * 修改时间：16/5/11 上午11:06
 * 修改备注：
 */
public class EvaluateListActivity extends BaseRecyclerActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("全部评论");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new EvaluateListAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_evaluate_list_layout;
    }

    @Override
    public void onItemClick(int position) {
        EvaluateDetailActivity.newIntent(this, ((EvaluateListAdapter) adapter).getItem(position).getOrderId());
    }

    Observer<MarketEvaluateListResponseModel> mMarketEvaluateListResponseModelObserver = new Observer<MarketEvaluateListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MarketEvaluateListResponseModel marketEvaluateListResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketEvaluateListResponseModel.getData().getContent());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().marketEvaluateList(mMarketEvaluateListResponseModelObserver, setParams());
    }

    private MarketEvaluateListRequestModel setParams() {
        MarketEvaluateListRequestModel marketEvaluateListRequestModel = new MarketEvaluateListRequestModel();
        marketEvaluateListRequestModel.setCmd(ApiInterface.MarketEvaluateList);
        marketEvaluateListRequestModel.setToken(BaseApplication.getToken());
        marketEvaluateListRequestModel.setParameters(new MarketEvaluateListRequestModel.ParametersEntity(getIntent().getIntExtra("userId", -1), pagerSize, pager));
        return marketEvaluateListRequestModel;
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().marketEvaluateList(mMarketEvaluateListResponseModelObserver, setParams());
    }

    public static void newIntent(Context context, int userId) {
        Intent intent = new Intent(context, EvaluateListActivity.class);
        intent.putExtra("userId", userId);
        context.startActivity(intent);
    }
}
