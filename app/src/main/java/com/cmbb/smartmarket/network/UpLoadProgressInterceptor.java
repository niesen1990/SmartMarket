package com.cmbb.smartmarket.network;

import com.cmbb.smartmarket.log.Log;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 下午8:17
 * 修改人：N.Sun
 * 修改时间：16/5/25 下午8:17
 * 修改备注：
 */
public class UpLoadProgressInterceptor implements Interceptor {
    private static CountingRequestBody.Listener progressListener;

    public UpLoadProgressInterceptor() {
    }

    public static CountingRequestBody.Listener getProgressListener() {
        return progressListener;
    }

    public static void setProgressListener(CountingRequestBody.Listener progressListener) {
        UpLoadProgressInterceptor.progressListener = progressListener;
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request originalRequest = chain.request();
        Log.e("UpLoadProgressInterceptor", "UpLoadProgressInterceptor intercept = " + progressListener);
        if (progressListener == null) {
            return chain.proceed(originalRequest);
        } else {
            if (originalRequest.body() == null) {
                return chain.proceed(originalRequest);
            }
            Request progressRequest = originalRequest.newBuilder()
                    .method(originalRequest.method(), new CountingRequestBody(originalRequest.body(), progressListener))
                    .build();
            return chain.proceed(progressRequest);
        }
    }
}
