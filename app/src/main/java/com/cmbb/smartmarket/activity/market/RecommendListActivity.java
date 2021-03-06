package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.RecommendItemAdapter;
import com.cmbb.smartmarket.activity.market.model.ProductReplayRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.KeyboardUtil;
import com.jude.easyrecyclerview.EasyRecyclerView;
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
    MarketCenterSelectProductListResponseModel mMarketCenterSelectProductListResponseModel;
    Observer<MarketCenterSelectProductListResponseModel> mMarketCenterSelectProductListResponseModelObserver = new Observer<MarketCenterSelectProductListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            mSmartRecyclerView.showError();
            adapter.pauseMore();
        }

        @Override
        public void onNext(MarketCenterSelectProductListResponseModel marketCenterSelectProductListResponseModel) {
            mMarketCenterSelectProductListResponseModel = marketCenterSelectProductListResponseModel;
            if (pager == 0)
                adapter.clear();
            adapter.addAll(marketCenterSelectProductListResponseModel.getData().getContent());
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
        adapter.addFooter(new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                LinearLayout header = (LinearLayout) LayoutInflater.from(RecommendListActivity.this).inflate(R.layout.activity_recommend_head01, null);
                header.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT));
                return header;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.findViewById(R.id.tv_publish).setOnClickListener(RecommendListActivity.this);
            }
        });
        onRefresh();
    }

    @Override
    protected void onPause() {
        super.onPause();
        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    protected void initRecyclerView() {
        mSmartRecyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        if (mSmartRecyclerView == null)
            return;
        adapter = initAdapter();
        mSmartRecyclerView.setLayoutManager(setLayoutManager());
        if (adapter == null)
            return;
        mSmartRecyclerView.setAdapterWithProgress(adapter);
        setSpaceDecoration(mSmartRecyclerView);
        adapter.setMore(R.layout.view_more, this);
        adapter.setOnItemClickListener(this);
        mSmartRecyclerView.setRefreshListener(this);
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
    public void onItemClick(View rootView, int position) {
        for (MarketCenterSelectProductListResponseModel.DataEntity.ContentEntity contentEntity : ((RecommendItemAdapter) adapter).getAll()) {
            contentEntity.setChecked(false);
        }
        ((RecommendItemAdapter) adapter).getItem(position).setChecked(true);
        resolveProductId = ((RecommendItemAdapter) adapter).getItem(position).getId();
        adapter.notifyDataSetChanged();
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
                KeyboardUtil.hideKeyboard(RecommendListActivity.this);
                showWaitingDialog();
                subscription = HttpMethod.getInstance().requestProductReplay(mProductReplayResponseModelObserver, setReplayParams());
                break;
            case R.id.tv_publish:
                PublishActivity.newIntent(this, "发布", "0");
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
        HttpMethod.getInstance().marketCenterSelectProductList(mMarketCenterSelectProductListResponseModelObserver, setParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().marketCenterSelectProductList(mMarketCenterSelectProductListResponseModelObserver, setParams());
    }

    private MarketCenterSelectProductListRequestModel setParams() {
        MarketCenterSelectProductListRequestModel marketCenterSelectProductListRequestModel = new MarketCenterSelectProductListRequestModel();
        marketCenterSelectProductListRequestModel.setCmd(ApiInterface.MarketCenterSelectProductList);
        marketCenterSelectProductListRequestModel.setToken(BaseApplication.getToken());
        marketCenterSelectProductListRequestModel.setParameters(new MarketCenterSelectProductListRequestModel.ParametersEntity(0, BaseApplication.getUserId(), "0", pagerSize, pager));
        return marketCenterSelectProductListRequestModel;
    }

    public static void newIntent(Context context, int productId, int repUserId) {
        Intent intent = new Intent(context, RecommendListActivity.class);
        intent.putExtra("productId", productId);
        intent.putExtra("repUserId", repUserId);
        context.startActivity(intent);
    }
}
