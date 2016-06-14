package com.cmbb.smartmarket.activity.user;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RatingBar;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateSaveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateSaveResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

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
public class ImmediateEvaluationActivity extends BaseActivity {
    private static final String TAG = ImmediateEvaluationActivity.class.getSimpleName();

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.ratingBar01)
    RatingBar ratingBar01;
    @BindView(R.id.ratingBar02)
    RatingBar ratingBar02;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    int desNum;
    int expNum;

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

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("立即评价");
        tvSubmit.setOnClickListener(this);
        ratingBar01.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                desNum = (int) rating;
            }
        });
        ratingBar02.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                expNum = (int) rating;
            }
        });
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etContent.getText().toString())) {
                    showToast("请输入评价内容");
                    return;
                }
                if (desNum == 0 || expNum == 0) {
                    showToast("请选择评价星级");
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
        marketEvaluateSaveRequestModel.setParameters(new MarketEvaluateSaveRequestModel.ParametersEntity(getIntent().getIntExtra("orderId", -1) + "", expNum, desNum, etContent.getText().toString()));
        return marketEvaluateSaveRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_immediate_evaluation_layout;
    }

    public static void newIntent(BaseActivity context, int orderId) {
        Intent intent = new Intent(context, ImmediateEvaluationActivity.class);
        intent.putExtra("orderId", orderId);
        context.startActivityForResult(intent, 100);
    }
}
