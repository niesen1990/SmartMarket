package com.cmbb.smartmarket.base;

import android.text.TextUtils;
import android.widget.Toast;

import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.log.Log;
import com.google.gson.Gson;
import com.zhy.http.okhttp.callback.Callback;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Response;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 下午4:15
 */
public abstract class ResponseModel<T extends BaseModel> extends Callback<T> {

    private static final String TAG = ResponseModel.class.getSimpleName();
    Class<T> tClass;

    public ResponseModel() {
        Type genType = getClass().getGenericSuperclass();
        Type[] params = ((ParameterizedType) genType).getActualTypeArguments();
        tClass = (Class) params[0];
    }


    @Override
    public T parseNetworkResponse(Response response) throws Exception {
        if (response != null && response.isSuccessful()) {
            String result = response.body().string();
            if (!TextUtils.isEmpty(result)) {
                Log.i(result);
                return new Gson().fromJson(result, tClass);
            } else {
                return null;
            }
        } else {
            return null;
        }
    }

    @Override
    public void onResponse(T response) {
        if (response == null) return;
        if (response.getError() != null) {
            Toast.makeText(BaseApplication.getContext(), response.getError().getErrorInfo(), Toast.LENGTH_SHORT).show();
            switch (response.getError().getErrorCode()) {
                case 14:
                case 15:
                    // TODO:ErrorCode
                    LoginActivity.newIntent(BaseApplication.getContext());
                    break;
            }
        } else if (response.getStatusCode() != 200) {
            switch (response.getStatusCode()) {
                case 403:
                    // TODO:403处理
                    onFailed();
                    break;
            }
        } else {
            onSuccess(response);
        }
    }

    @Override
    public void onError(Call call, Exception e) {
        call.cancel();
        Log.e(TAG, e.toString());
        Toast.makeText(BaseApplication.getContext(), e.toString(), Toast.LENGTH_SHORT).show();
    }

    protected abstract void onSuccess(T result);

    protected abstract void onFailed();
}
