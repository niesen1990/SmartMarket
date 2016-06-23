package com.cmbb.smartmarket.network;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.cmbb.smartmarket.activity.market.model.ImageUploadResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.model.BaseRetrofitModel;
import com.cmbb.smartmarket.base.Constants;

import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/10 上午11:15
 */
public class HttpUpload {

    private static final String TAG = HttpUpload.class.getSimpleName();
    private static final int DEFAULT_TIMEOUT = 15;
    private ApiInterface mApiInterface;
    private OkHttpClient okHttpClient;

    public HttpUpload(CountingRequestBody.Listener listener) {
        UpLoadProgressInterceptor upLoadProgressInterceptor = new UpLoadProgressInterceptor();
        okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(upLoadProgressInterceptor)
                .retryOnConnectionFailure(true)
                .connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS)
                .build();
        Retrofit retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(ApiInterface.HOST)
                .build();
        mApiInterface = retrofit.create(ApiInterface.class);
    }

    /**
     * 注册Subscriber,分配线程
     *
     * @param o   Observable<T>
     * @param s   Subscriber<T>
     * @param <T> 返回处理对象
     */
    private <T> Subscription addSubscribe(Observable<T> o, Observer<T> s) {
        return o.subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 统一处理Http的resultCode,并将HttpResult的Data部分剥离出来返回给subscriber
     *
     * @param <T> Subscriber真正需要的数据类型，也就是Data部分的数据类型
     */
    class HttpResultFunc<T> implements Func1<BaseRetrofitModel<T>, T> {

        @Override
        public T call(BaseRetrofitModel<T> httpResult) {
            if (httpResult.getError() != null) {
                Intent intent = new Intent(Constants.INTENT_ACTION_ERROR_INFRO);
                intent.putExtra("err", httpResult.getError().getErrorInfo());
                LocalBroadcastManager.getInstance(BaseApplication.getContext()).sendBroadcast(intent);
                throw new ApiException(httpResult.getError().getErrorInfo());
            }
            return httpResult.getResponse();
        }
    }

    /**
     * 上传图片带进度条
     *
     * @param observer
     * @return
     */
    public Subscription uploadImageWithProgress(Observer<ImageUploadResponseModel> observer, Map<String, RequestBody> params) {
        Observable<ImageUploadResponseModel> observable = mApiInterface
                .uploadImageWithProgress(params)
                .map(new HttpResultFunc<ImageUploadResponseModel>());
        return addSubscribe(observable, observer);
    }
}
