package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MyselfFeedbackOpinionRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfFeedbackOpinionResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 上午11:04
 * 修改人：N.Sun
 * 修改时间：16/5/25 上午11:04
 * 修改备注：
 */
public class SuggestionActivity extends BaseActivity {
    private static final String TAG = SuggestionActivity.class.getSimpleName();

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    Observer<MyselfFeedbackOpinionResponseModel> mMarketHomeSaveLocationAddressResponseModelObserver = new Observer<MyselfFeedbackOpinionResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MyselfFeedbackOpinionResponseModel myselfFeedbackOpinionResponseModel) {
            hideWaitingDialog();
            if (myselfFeedbackOpinionResponseModel != null) {
                showToast(myselfFeedbackOpinionResponseModel.getMsg());
            }
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("意见反馈");
        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etContent.getText().toString())) {
                    showToast("请输入意见反馈内容 ");
                    return;
                }
                showWaitingDialog();
                subscription = HttpMethod.getInstance().myselfFeedbackOpinion(mMarketHomeSaveLocationAddressResponseModelObserver, setParams());
                break;
        }
    }

    private MyselfFeedbackOpinionRequestModel setParams() {
        MyselfFeedbackOpinionRequestModel myselfFeedbackOpinionRequestModel = new MyselfFeedbackOpinionRequestModel();
        myselfFeedbackOpinionRequestModel.setCmd(ApiInterface.MyselfFeedbackOpinion);
        myselfFeedbackOpinionRequestModel.setToken(BaseApplication.getToken());
        myselfFeedbackOpinionRequestModel.setParameters(new MyselfFeedbackOpinionRequestModel.ParametersEntity(etContent.getText().toString()));
        return myselfFeedbackOpinionRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_suggestion_layout;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, SuggestionActivity.class);
        context.startActivity(intent);
    }
}
