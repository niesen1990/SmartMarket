package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MyselfProductCollectListRequestModel;
import com.cmbb.smartmarket.activity.home.model.MyselfProductCollectListResponseModel;
import com.cmbb.smartmarket.activity.market.DetailSellActivity;
import com.cmbb.smartmarket.activity.user.adapter.MeCollectionAdapter;
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
 * 创建时间：16/4/28 下午12:02
 */
public class MeCollectionActivity extends BaseRecyclerActivity {
    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("宝贝收藏");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new MeCollectionAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_me_collection;
    }

    @Override
    public void onItemClick(View rootView, int position) {
        //        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(rootView.findViewById(R.id.iv01), "iv01"));
        //        CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((MeCollectionAdapter) adapter).getItem(position).getProduct().getId(), ((MeCollectionAdapter) adapter).getItem(position).getProduct().getProductImageList());
        DetailSellActivity.newIntent(this, ((MeCollectionAdapter) adapter).getItem(position).getProduct().getId());
    }

    Observer<MyselfProductCollectListResponseModel> mMyselfProductCollectListResponseModelObserver = new Observer<MyselfProductCollectListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MyselfProductCollectListResponseModel myselfProductCollectListResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(myselfProductCollectListResponseModel.getData().getContent());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().myselfProductCollectList(mMyselfProductCollectListResponseModelObserver, setParams());
    }

    private MyselfProductCollectListRequestModel setParams() {
        MyselfProductCollectListRequestModel myselfGetCountRequestModel = new MyselfProductCollectListRequestModel();
        myselfGetCountRequestModel.setCmd(ApiInterface.MyselfProductCollectList);
        myselfGetCountRequestModel.setToken(BaseApplication.getToken());
        myselfGetCountRequestModel.setParameters(new MyselfProductCollectListRequestModel.ParametersEntity(pagerSize, pager));
        return myselfGetCountRequestModel;
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().myselfProductCollectList(mMyselfProductCollectListResponseModelObserver, setParams());
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, MeCollectionActivity.class);
        context.startActivity(intent);
    }
}
