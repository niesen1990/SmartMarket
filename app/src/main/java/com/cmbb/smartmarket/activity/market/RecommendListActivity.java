package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.RecommendItemAdapter;
import com.cmbb.smartmarket.activity.market.model.ProductReplayRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayResponseModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/26 下午7:50
 * 修改人：N.Sun
 * 修改时间：16/5/26 下午7:50
 * 修改备注：
 */
public class RecommendListActivity extends BaseRecyclerActivity {
    private static final String TAG = RecommendListActivity.class.getSimpleName();

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    MyselfProductPublicListResponseModel mMyselfProductPublicListResponseModel;
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
            mMyselfProductPublicListResponseModel = myselfProductPublicListResponseModel;
            adapter.addAll(myselfProductPublicListResponseModel.getData().getContent());
        }
    };

    Observer<ProductReplayResponseModel> mProductReplayResponseModelObserver = new Observer<ProductReplayResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(ProductReplayResponseModel productReplayResponseModel) {
            hideWaitingDialog();
            if (productReplayResponseModel == null)
                return;
            showToast(productReplayResponseModel.getMsg());
            finish();
        }
    };

    int resolveProductId = -1;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("选择推荐商品");
        tvSubmit.setOnClickListener(this);
        onRefresh();
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new RecommendItemAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_recommend_layout;
    }

    @Override
    public void onItemClick(int position) {
        clearChecked();
        ((RecommendItemAdapter) adapter).getItem(position).setChecked(true);
        resolveProductId = ((RecommendItemAdapter) adapter).getItem(position).getId();
        adapter.notifyDataSetChanged();
    }

    private void clearChecked() {
        for (MyselfProductPublicListResponseModel.DataEntity.ContentEntity entity : mMyselfProductPublicListResponseModel.getData().getContent()) {
            entity.setChecked(false);
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etContent.getText().toString())) {
                    showToast("请填写回复内容");
                    return;
                }
                if (resolveProductId == -1) {
                    showToast("请选择推荐商品");
                    return;
                }
                showWaitingDialog();
                subscription = HttpMethod.getInstance().requestProductReplay(mProductReplayResponseModelObserver, setReplayParams());
                break;
        }
    }

    private ProductReplayRequestModel setReplayParams() {
        ProductReplayRequestModel productReplayRequestModel = new ProductReplayRequestModel();
        productReplayRequestModel.setToken(BaseApplication.getToken());
        productReplayRequestModel.setCmd(ApiInterface.ProductReply);
        productReplayRequestModel.setParameters(new ProductReplayRequestModel.ParametersEntity(getIntent().getIntExtra("productId", -1), getIntent().getIntExtra("repUserId", -1), resolveProductId + "", 1, etContent.getText().toString()));
        return productReplayRequestModel;
    }

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
        myselfProductPublicListRequestModel.setParameters(new MyselfProductPublicListRequestModel.ParametersEntity(0, pagerSize, pager));
        return myselfProductPublicListRequestModel;
    }

    public static void newIntent(Context context, int productId, int repUserId) {
        Intent intent = new Intent(context, RecommendListActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("repUserId", repUserId);
        context.startActivity(intent);
    }
}
