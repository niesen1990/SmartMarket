package com.cmbb.smartmarket.activity.user;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateRequestModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.db.DBContent;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/27 上午10:01
 */
public class IntroduceActivity extends BaseActivity {
    private static final String TAG = IntroduceActivity.class.getSimpleName();

    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("个人简介");
        etContent.setText(getIntent().getStringExtra("content"));
        tvSubmit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etContent.getText().toString())) {
                    showToast("请输入简介");
                    return;
                }
                showWaitingDialog();
                updateRequest(etContent.getText().toString());
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_introduce_layout;
    }

    public static void newIntent(Context context, String content) {
        Intent intent = new Intent(context, IntroduceActivity.class);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    Observer<UserInfoUpdateResponseModel> mUserInfoUpdateResponseModelObserver = new Observer<UserInfoUpdateResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(UserInfoUpdateResponseModel userInfoUpdateResponseModel) {
            hideWaitingDialog();
            showToast(userInfoUpdateResponseModel.getMsg());
            ContentValues values = new ContentValues();
            values.put(DBContent.DBUser.USER_TOKEN, userInfoUpdateResponseModel.getData().getLoginToken());
            values.put(DBContent.DBUser.USER_ID, userInfoUpdateResponseModel.getData().getId());
            values.put(DBContent.DBUser.USER_HEAD_IMG, userInfoUpdateResponseModel.getData().getUserImg());
            values.put(DBContent.DBUser.USER_NICK_NAME, userInfoUpdateResponseModel.getData().getNickName());
            values.put(DBContent.DBUser.USER_MALE, userInfoUpdateResponseModel.getData().getSex());
            values.put(DBContent.DBUser.USER_PHONE, userInfoUpdateResponseModel.getData().getLoginAccount());
            values.put(DBContent.DBUser.USER_PROVINCE_ID, userInfoUpdateResponseModel.getData().getProvince());
            values.put(DBContent.DBUser.USER_CITY_ID, userInfoUpdateResponseModel.getData().getCity());
            values.put(DBContent.DBUser.USER_LEVEL, userInfoUpdateResponseModel.getData().getUserLevel());
            values.put(DBContent.DBUser.USER_INTRODUCE, userInfoUpdateResponseModel.getData().getIntroduce());
            values.put(DBContent.DBUser.IM_USER_ID, userInfoUpdateResponseModel.getData().getImUserId().get(0));
            getContentResolver().update(DBContent.DBUser.CONTENT_URI, values, DBContent.DBUser.USER_ID + " = " + userInfoUpdateResponseModel.getData().getId(), null);
        }
    };

    private void updateRequest(String introduce) {
        UserInfoUpdateRequestModel userInfoUpdateRequestModel = new UserInfoUpdateRequestModel();
        userInfoUpdateRequestModel.setCmd(ApiInterface.UserInfoUpdate);
        userInfoUpdateRequestModel.setToken(BaseApplication.getToken());
        UserInfoUpdateRequestModel.ParametersEntity parametersEntity = new UserInfoUpdateRequestModel.ParametersEntity();
        if (!TextUtils.isEmpty(introduce))
            parametersEntity.setUserPresentation(introduce);
        userInfoUpdateRequestModel.setParameters(parametersEntity);
        subscription = HttpMethod.getInstance().requestUpdateUserInfo(mUserInfoUpdateResponseModelObserver, userInfoUpdateRequestModel);
    }
}

