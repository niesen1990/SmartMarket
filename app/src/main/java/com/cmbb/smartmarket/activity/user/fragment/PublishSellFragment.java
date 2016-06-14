package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.CommodityDetailActivity;
import com.cmbb.smartmarket.activity.market.NeedDetailActivity;
import com.cmbb.smartmarket.activity.market.PublishActivity;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteResponseModel;
import com.cmbb.smartmarket.activity.user.adapter.PublishSellListAdapter;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.NestedScrollView;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

public class PublishSellFragment extends BaseRecyclerFragment {
    private static final String ARG_PARAM = "position";
    private int position;

    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.tv_delete)
    TextView tvDelete;
    @BindView(R.id.tv_edit)
    TextView tvEdit;

    BottomSheetBehavior mBottomSheetBehavior;

    Observer<ProductDeleteResponseModel> mProductDeleteResponseModelObserver = new Observer<ProductDeleteResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            ((BaseActivity) getActivity()).hideWaitingDialog();
        }

        @Override
        public void onNext(ProductDeleteResponseModel productDeleteResponseModel) {
            ((BaseActivity) getActivity()).hideWaitingDialog();
            if (productDeleteResponseModel == null)
                return;
            showToast(productDeleteResponseModel.getMsg());
            onRefresh();
            //清除缓存
            tvDelete.setTag(null);
            tvEdit.setTag(null);
        }
    };

    public PublishSellFragment() {
        // Required empty public constructor
    }

    public static PublishSellFragment newInstance(int position) {
        PublishSellFragment fragment = new PublishSellFragment();
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
        mBottomSheetBehavior = BottomSheetBehavior.from(scroll);
        tvDelete.setOnClickListener(this);
        tvEdit.setOnClickListener(this);
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemClick(int position) {
                startBehavior();
                tvDelete.setTag(position);
                tvEdit.setTag(position);
                return true;
            }
        });
        onRefresh();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_edit:
                startBehavior();
                switch (position) {
                    case 0:
                        PublishActivity.newIntent(getActivity(), ((PublishSellListAdapter) adapter).getItem((Integer) tvEdit.getTag()), "0");
                        break;
                    case 1:
                        PublishActivity.newIntent(getActivity(), ((PublishSellListAdapter) adapter).getItem((Integer) tvEdit.getTag()), "1");
                        break;
                }

                break;
            case R.id.tv_delete:
                startBehavior();
                if (tvDelete.getTag() == null)
                    return;
                int position = (int) tvDelete.getTag();
                ((BaseActivity) getActivity()).showWaitingDialog();
                subscription = HttpMethod.getInstance().productDeleteRequest(mProductDeleteResponseModelObserver, setDeleteParams(position));
                break;
        }

    }

    private ProductDeleteRequestModel setDeleteParams(int position) {
        ProductDeleteRequestModel productDeleteRequestModel = new ProductDeleteRequestModel();
        productDeleteRequestModel.setCmd(ApiInterface.ProductDelete);
        productDeleteRequestModel.setToken(BaseApplication.getToken());
        productDeleteRequestModel.setParameters(new ProductDeleteRequestModel.ParametersEntity(((PublishSellListAdapter) adapter).getItem(position).getId()));
        return productDeleteRequestModel;
    }

    public void startBehavior() {
        if (mBottomSheetBehavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            mBottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_publish;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new PublishSellListAdapter(getActivity());
    }

    @Override
    public void onItemClick(int position) {
        switch (this.position) {
            case 0:
                CommodityDetailActivity.newIntent(getActivity(), ((PublishSellListAdapter) adapter).getItem(position).getId());
                break;
            case 1:
                NeedDetailActivity.newIntent(getActivity(), ((PublishSellListAdapter) adapter).getItem(position).getId());
                break;
        }
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
