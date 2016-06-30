package com.cmbb.smartmarket.activity.user.fragment;

import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.NeedDetailActivity;
import com.cmbb.smartmarket.activity.market.PublishActivity;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteResponseModel;
import com.cmbb.smartmarket.activity.user.adapter.PublishNeedListAdapter;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;
import com.cmbb.smartmarket.image.model.ImageModel;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.NestedScrollView;
import com.cmbb.smartmarket.widget.SpaceItemDecoration;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import rx.Observer;

public class PublishNeedFragment extends BaseRecyclerFragment {
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

    public PublishNeedFragment() {
        // Required empty public constructor
    }

    public static PublishNeedFragment newInstance(int position) {
        PublishNeedFragment fragment = new PublishNeedFragment();
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
                PublishActivity.newIntent(getActivity(), ((PublishNeedListAdapter) adapter).getItem((Integer) tvEdit.getTag()).getId(), "1");
                startBehavior();
                break;
            case R.id.tv_delete:
                if (tvDelete.getTag() == null)
                    return;
                int position = (int) tvDelete.getTag();
                ((BaseActivity) getActivity()).showWaitingDialog();
                subscription = HttpMethod.getInstance().productDeleteRequest(mProductDeleteResponseModelObserver, setDeleteParams(position));
                startBehavior();
                break;
        }

    }

    private ProductDeleteRequestModel setDeleteParams(int position) {
        ProductDeleteRequestModel productDeleteRequestModel = new ProductDeleteRequestModel();
        productDeleteRequestModel.setCmd(ApiInterface.ProductDelete);
        productDeleteRequestModel.setToken(BaseApplication.getToken());
        productDeleteRequestModel.setParameters(new ProductDeleteRequestModel.ParametersEntity(((PublishNeedListAdapter) adapter).getItem(position).getId()));
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
        return new PublishNeedListAdapter(getActivity());
    }

    @Override
    public void onItemClick(View rootView, int position) {
        if (((PublishNeedListAdapter) adapter).getItem(position).getProductImageList() == null || ((PublishNeedListAdapter) adapter).getItem(position).getProductImageList().size() == 0) {
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeScaleUpAnimation(rootView,
                    rootView.getLeft(), rootView.getTop(), //拉伸开始的坐标
                    rootView.getWidth(), rootView.getHeight());//拉伸开始的区域大小，这里用（0，0）表示从无到全屏
            NeedDetailActivity.newIntent((BaseActivity) getActivity(), activityOptionsCompat, ((PublishNeedListAdapter) adapter).getItem(position).getId());
        } else {
            ActivityOptionsCompat activityOptionsCompat1 = ActivityOptionsCompat.makeSceneTransitionAnimation(getActivity(), Pair.create(rootView.findViewById(R.id.iv01), "iv01"));
            List<ImageModel> imageModels = new ArrayList<>();
            for (MyselfProductPublicListResponseModel.DataEntity.ContentEntity.ProductImageListEntity entity : ((PublishNeedListAdapter) adapter).getItem(position).getProductImageList()) {
                imageModels.add(new ImageModel(entity.getImageHeight(), entity.getBusinessNumber(), entity.getLocation(), entity.getImageWidth()));
            }
            NeedDetailActivity.newIntent((BaseActivity) getActivity(), activityOptionsCompat1, ((PublishNeedListAdapter) adapter).getItem(position).getId(), imageModels);
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
