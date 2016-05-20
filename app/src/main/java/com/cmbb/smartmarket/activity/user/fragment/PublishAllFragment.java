package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.view.View;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.PublishListAdapter;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import rx.Observer;

public class PublishAllFragment extends BaseRecyclerFragment {
    private static final String ARG_PARAM = "position";
    private int position;

    public PublishAllFragment() {
        // Required empty public constructor
    }

    public static PublishAllFragment newInstance(int position) {
        PublishAllFragment fragment = new PublishAllFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM, position);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void setSpaceDecoration(EasyRecyclerView recyclerView) {
        recyclerView.addItemDecoration(new SpaceItemDecoration(0, 0, 0, getResources().getDimensionPixelOffset(R.dimen.global_padding)));
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            position = getArguments().getInt(ARG_PARAM);
        }
    }

    @Override
    protected void initView(View view) {
        super.initView(view);
        onRefresh();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sell_refund;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new PublishListAdapter(getActivity());
    }

    @Override
    public void onItemClick(int position) {

    }

    Observer<MyselfProductPublicListResponseModel> mMyselfProductPublicListResponseModelObserver = new Observer<MyselfProductPublicListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MyselfProductPublicListResponseModel myselfProductPublicListResponseModel) {
            if (pager == 0)
                adapter.clear();
            adapter.addAll(myselfProductPublicListResponseModel.getData().getContent());
        }
    };

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().myselfProductPublicListRequest(mMyselfProductPublicListResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().myselfProductPublicListRequest(mMyselfProductPublicListResponseModelObserver, setParams());
    }

    private MyselfProductPublicListRequestModel setParams() {
        MyselfProductPublicListRequestModel myselfProductPublicListRequestModel = new MyselfProductPublicListRequestModel();
        myselfProductPublicListRequestModel.setCmd(ApiInterface.MyselfProductPublicList);
        myselfProductPublicListRequestModel.setToken(BaseApplication.getToken());
        switch (position) {
            case 0:
                myselfProductPublicListRequestModel.setParameters(new MyselfProductPublicListRequestModel.ParametersEntity(0, pagerSize, pager));
                break;
            case 1:
                myselfProductPublicListRequestModel.setParameters(new MyselfProductPublicListRequestModel.ParametersEntity(1, pagerSize, pager));
                break;
        }
        return myselfProductPublicListRequestModel;
    }

}
