package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.user.adapter.OffManagerAdapter;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/6 上午9:55
 * 修改人：N.Sun
 * 修改时间：16/6/6 上午9:55
 * 修改备注：
 */
public class OffManagerActivity extends BaseRecyclerActivity {
    private static final String TAG = OffManagerActivity.class.getSimpleName();
    Observer<MyselfProductPublicListResponseModel> mMyselfProductPublicListResponseModelObserver = new Observer<MyselfProductPublicListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MyselfProductPublicListResponseModel myselfProductPublicListResponseModel) {
            if (myselfProductPublicListResponseModel == null)
                return;
            if (pager == 0)
                adapter.clear();
            adapter.addAll(myselfProductPublicListResponseModel.getData().getContent());
        }
    };

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("下架管理");
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new OffManagerAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_off_manager_layout;
    }

    @Override
    public void onItemClick(View rootView, int position) {
        ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(rootView.findViewById(R.id.iv_image), "iv01"));
        CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((OffManagerAdapter) adapter).getItem(position).getId());
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().myselfProductPublicListRequest(mMyselfProductPublicListResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().myselfProductPublicListRequest(mMyselfProductPublicListResponseModelObserver, setParams());
    }

    private MyselfProductPublicListRequestModel setParams() {
        MyselfProductPublicListRequestModel myselfProductPublicListRequestModel = new MyselfProductPublicListRequestModel();
        myselfProductPublicListRequestModel.setCmd(ApiInterface.MyselfProductPublicList);
        myselfProductPublicListRequestModel.setToken(BaseApplication.getToken());
        myselfProductPublicListRequestModel.setParameters(new MyselfProductPublicListRequestModel.ParametersEntity(0, pagerSize, pager, "1"));
        return myselfProductPublicListRequestModel;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, OffManagerActivity.class);
        context.startActivity(intent);
    }
}
