package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateDetailResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;

import butterknife.BindView;
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
public class EvaluateDetailActivity extends BaseActivity {
    private static final String TAG = EvaluateDetailActivity.class.getSimpleName();

    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.rl01)
    RelativeLayout rl01;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_from)
    TextView tvFrom;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.rl02)
    RelativeLayout rl02;
    @BindView(R.id.tv_content)
    TextView tvContent;
    @BindView(R.id.iv_store_image)
    ImageView ivStoreImage;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.ll03)
    LinearLayout ll03;
    @BindView(R.id.tv_count)
    TextView tvCount;
    @BindView(R.id.iv_child_head)
    ImageView ivChildHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_child_time)
    TextView tvChildTime;
    @BindView(R.id.tv_child_content)
    TextView tvChildContent;

    Observer<MarketEvaluateDetailResponseModel> mMarketEvaluateDetailResponseModelObserver = new Observer<MarketEvaluateDetailResponseModel>() {
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
        public void onNext(MarketEvaluateDetailResponseModel marketEvaluateDetailResponseModel) {
            if (marketEvaluateDetailResponseModel == null)
                return;
            ImageLoader.loadUrlAndDiskCache(EvaluateDetailActivity.this, marketEvaluateDetailResponseModel.getData().getEvaluateUser().getUserImg(), ivHead, new CircleTransform(EvaluateDetailActivity.this));
            tvFrom.setText(marketEvaluateDetailResponseModel.getData().getEvaluateUser().getNickName());
            tvTime.setText(new JTimeTransform(marketEvaluateDetailResponseModel.getData().getEvaluateDate()).toString(new RecentDateFormat()));
            tvTitle.setText(marketEvaluateDetailResponseModel.getData().getProduct().getTitle());
            tvContent.setText(marketEvaluateDetailResponseModel.getData().getContent());
            if (marketEvaluateDetailResponseModel.getData().getProduct().getProductImageList() != null && marketEvaluateDetailResponseModel.getData().getProduct().getProductImageList().size() > 0)
                ImageLoader.loadCenterCropCache(EvaluateDetailActivity.this, marketEvaluateDetailResponseModel.getData().getProduct().getProductImageList().get(0).getLocation(), ivStoreImage);
            if (marketEvaluateDetailResponseModel.getData().getChildEvaluate() != null) {
                ll02.setVisibility(View.VISIBLE);
                ll03.setVisibility(View.VISIBLE);
                ImageLoader.loadUrlAndDiskCache(EvaluateDetailActivity.this, marketEvaluateDetailResponseModel.getData().getChildEvaluate().getEvaluateUser().getUserImg(), ivChildHead, new CircleTransform(EvaluateDetailActivity.this));
                tvNick.setText(marketEvaluateDetailResponseModel.getData().getChildEvaluate().getEvaluateUser().getNickName());
                tvChildTime.setText(new JTimeTransform(marketEvaluateDetailResponseModel.getData().getChildEvaluate().getEvaluateDate()).toString(new RecentDateFormat()));
                tvChildContent.setText(marketEvaluateDetailResponseModel.getData().getChildEvaluate().getContent());
            } else {
                ll02.setVisibility(View.GONE);
                ll03.setVisibility(View.GONE);
            }
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("评价详情");
        showWaitingDialog();
        subscription = HttpMethod.getInstance().marketEvaluateDetail(mMarketEvaluateDetailResponseModelObserver, setParams());
    }

    private MarketEvaluateDetailRequestModel setParams() {
        MarketEvaluateDetailRequestModel marketEvaluateDetailRequestModel = new MarketEvaluateDetailRequestModel();
        marketEvaluateDetailRequestModel.setCmd(ApiInterface.MarketEvaluateDetail);
        marketEvaluateDetailRequestModel.setToken(BaseApplication.getToken());
        marketEvaluateDetailRequestModel.setParameters(new MarketEvaluateDetailRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1)));
        return marketEvaluateDetailRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_evaluate_detail_layout;
    }

    public static void newIntent(Context context, int orderId) {
        Intent intent = new Intent(context, EvaluateDetailActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivity(intent);
    }
}
