package com.cmbb.smartmarket.activity.login;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.utility.IMPrefsTools;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.login.model.LoginRequestModel;
import com.cmbb.smartmarket.activity.login.model.LoginResponseModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeRequestModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeResponseModel;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.db.DBContent;
import com.cmbb.smartmarket.db.DBHelper;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SPCache;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/25 下午2:13
 */
public class LoginActivity extends BaseActivity {

    private static final java.lang.String TAG = LoginActivity.class.getSimpleName();
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.et_check)
    EditText etCheck;
    @BindView(R.id.tv_check)
    TextView tvCheck;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    DBHelper dbHelper;

    @Override
    protected void init(Bundle savedInstanceState) {
        dbHelper = new DBHelper(this);
        tvLogin.setOnClickListener(this);
        tvCheck.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_login:
                handleLogin();
                break;
            case R.id.tv_check:
                handleSecurityCode();
                break;
        }
    }

    Observer<LoginResponseModel> mLoginResponseModelObserver = new Observer<LoginResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(final LoginResponseModel loginResponseModel) {
            SQLiteDatabase db = dbHelper.getWritableDatabase();
            dbHelper.delete(db);
            ContentValues values = new ContentValues();
            Log.i(TAG, "token = " + loginResponseModel.getData().getLoginToken());
            values.put(DBContent.DBUser.USER_TOKEN, loginResponseModel.getData().getLoginToken());
            values.put(DBContent.DBUser.USER_ID, loginResponseModel.getData().getId());
            values.put(DBContent.DBUser.USER_HEAD_IMG, loginResponseModel.getData().getUserImg());
            values.put(DBContent.DBUser.USER_NICK_NAME, loginResponseModel.getData().getNickName());
            values.put(DBContent.DBUser.USER_MALE, loginResponseModel.getData().getSex());
            values.put(DBContent.DBUser.USER_PHONE, loginResponseModel.getData().getLoginAccount());
            values.put(DBContent.DBUser.USER_PROVINCE_ID, loginResponseModel.getData().getProvince());
            values.put(DBContent.DBUser.USER_CITY_ID, loginResponseModel.getData().getCity());
            values.put(DBContent.DBUser.USER_LEVEL, loginResponseModel.getData().getUserLevel());
            values.put(DBContent.DBUser.USER_INTRODUCE, loginResponseModel.getData().getIntroduce());
            getContentResolver().insert(DBContent.DBUser.CONTENT_URI, values);
            BaseApplication.setToken(loginResponseModel.getData().getLoginToken());
            SPCache.putString(Constants.API_TOKEN, loginResponseModel.getData().getLoginToken());
            //阿里旺旺
            IMHelper.getInstance().loginIM("niesen918", "123456", new IWxCallback() {
                @Override
                public void onSuccess(Object... objects) {
                    showToast("IM 登陆成功");
                    showToast(loginResponseModel.getMsg());
                    hideWaitingDialog();
                    IMPrefsTools.setStringPrefs(LoginActivity.this, Constants.IM_USER_ID, "niesen918");
                    IMPrefsTools.setStringPrefs(LoginActivity.this, Constants.IM_USER_PASSWORD, "123456");
                    finish();
                }

                @Override
                public void onError(int i, String s) {
                    showToast("IM 登陆失败");
                }

                @Override
                public void onProgress(int i) {

                }
            });
        }
    };

    Observer<SecurityCodeResponseModel> mSecurityCodeResponseModelObserver = new Observer<SecurityCodeResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(SecurityCodeResponseModel securityCodeResponseModel) {
            hideWaitingDialog();
            showToast(securityCodeResponseModel.getMsg());
        }
    };

    private void handleLogin() {
        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            showToast("请输入手机号码");
            return;
        }
        if (TextUtils.isEmpty(etCheck.getText().toString().trim())) {
            showToast("请输入验证码");
            return;
        }
        initIM("niesen918");
        unSubscribe();
        showWaitingDialog();
        LoginRequestModel loginRequestModel = new LoginRequestModel();
        loginRequestModel.setCmd(ApiInterface.login);
        loginRequestModel.setParameters(new LoginRequestModel.ParametersEntity(etPhone.getText().toString().trim(), etCheck.getText().toString().trim()));
        subscription = HttpMethod.getInstance().requestLogin(mLoginResponseModelObserver, loginRequestModel);
    }

    private void handleSecurityCode() {
        if (TextUtils.isEmpty(etPhone.getText().toString().trim())) {
            showToast("请输入手机号码");
            return;
        }
        unSubscribe();
        showWaitingDialog();
        SecurityCodeRequestModel securityCodeRequestModel = new SecurityCodeRequestModel();
        securityCodeRequestModel.setCmd(ApiInterface.SecurityCode);
        securityCodeRequestModel.setParameters(new SecurityCodeRequestModel.ParametersEntity(etPhone.getText().toString().trim()));
        subscription = HttpMethod.getInstance().requestSecurityCode(mSecurityCodeResponseModelObserver, securityCodeRequestModel);
    }

    private void initIM(String account) {
        if (IMHelper.getInstance().getIMKit() == null) {
            IMHelper.getInstance().initIMKit(account, IMHelper.getAppKey());
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, LoginActivity.class);
        //        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
    }
}
