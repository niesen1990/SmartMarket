package com.cmbb.smartmarket.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateSaveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateSaveResponseModel;
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
 * 创建时间：16/5/29 下午3:22
 * 修改人：N.Sun
 * 修改时间：16/5/29 下午3:22
 * 修改备注：
 */
public class EvaluationForSellerActivity extends BaseActivity {
    private static final String TAG = EvaluationForSellerActivity.class.getSimpleName();

    @BindView(R.id.rl01)
    RelativeLayout rl01;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_from)
    TextView tvFrom;
    @BindView(R.id.tv_time)
    TextView tvTime;
    @BindView(R.id.et_content)
    TextView etContent;
    @BindView(R.id.et_evaluate)
    EditText etEvaluate;
    @BindView(R.id.ratingBar01)
    RatingBar ratingBar01;
    @BindView(R.id.ratingBar02)
    RatingBar ratingBar02;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    int parentId;

    Observer<MarketEvaluateSaveResponseModel> mMarketEvaluateSaveResponseModelObserver = new Observer<MarketEvaluateSaveResponseModel>() {
        @Override
        public void onCompleted() {
            hideWaitingDialog();
        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
        }

        @Override
        public void onNext(MarketEvaluateSaveResponseModel marketEvaluateSaveResponseModel) {
            if (marketEvaluateSaveResponseModel == null)
                return;
            showToast(marketEvaluateSaveResponseModel.getMsg());
            setResult(RESULT_OK);
            finish();
        }
    };

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
            parentId = marketEvaluateDetailResponseModel.getData().getId();
            Log.e(TAG, "parentId = " + parentId);
            ImageLoader.loadUrlAndDiskCache(EvaluationForSellerActivity.this, marketEvaluateDetailResponseModel.getData().getEvaluateUser().getUserImg(), ivHead, new CircleTransform(EvaluationForSellerActivity.this));
            tvFrom.setText(marketEvaluateDetailResponseModel.getData().getEvaluateUser().getNickName());
            tvTime.setText(new JTimeTransform(marketEvaluateDetailResponseModel.getData().getEvaluateDate()).toString(new RecentDateFormat()));
            etContent.setText(marketEvaluateDetailResponseModel.getData().getContent());
            ratingBar01.setRating(marketEvaluateDetailResponseModel.getData().getProductMatche());
            ratingBar02.setRating(marketEvaluateDetailResponseModel.getData().getExpressSpeed());
            if (marketEvaluateDetailResponseModel.getData().getChildEvaluate() != null) {
                etEvaluate.setText(marketEvaluateDetailResponseModel.getData().getChildEvaluate().getContent());
                etEvaluate.setEnabled(false);
                tvSubmit.setVisibility(View.GONE);
            } else {
                tvSubmit.setVisibility(View.VISIBLE);
                etEvaluate.setEnabled(true);
            }
        }
    };

    private MarketEvaluateDetailRequestModel setDetailParams() {
        MarketEvaluateDetailRequestModel marketEvaluateDetailRequestModel = new MarketEvaluateDetailRequestModel();
        marketEvaluateDetailRequestModel.setCmd(ApiInterface.MarketEvaluateDetail);
        marketEvaluateDetailRequestModel.setToken(BaseApplication.getToken());
        marketEvaluateDetailRequestModel.setParameters(new MarketEvaluateDetailRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1)));
        return marketEvaluateDetailRequestModel;
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("立即评价");
        tvSubmit.setOnClickListener(this);
        showWaitingDialog();
        subscription = HttpMethod.getInstance().marketEvaluateDetail(mMarketEvaluateDetailResponseModelObserver, setDetailParams());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etEvaluate.getText().toString())) {
                    showToast("请输入评价内容");
                    return;
                }
                showWaitingDialog();
                subscription = HttpMethod.getInstance().marketEvaluateSave(mMarketEvaluateSaveResponseModelObserver, setParams());
                break;
        }
    }

    private MarketEvaluateSaveRequestModel setParams() {
        MarketEvaluateSaveRequestModel marketEvaluateSaveRequestModel = new MarketEvaluateSaveRequestModel();
        marketEvaluateSaveRequestModel.setCmd(ApiInterface.MarketEvaluateSave);
        marketEvaluateSaveRequestModel.setToken(BaseApplication.getToken());
        marketEvaluateSaveRequestModel.setParameters(new MarketEvaluateSaveRequestModel.ParametersEntity(parentId + "", etEvaluate.getText().toString()));
        return marketEvaluateSaveRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_evaluation_for_sell_layout;
    }

    public static void newIntent(BaseActivity context, int orderId) {
        Intent intent = new Intent(context, EvaluationForSellerActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivityForResult(intent, 100);
    }
}
