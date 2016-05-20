package com.cmbb.smartmarket.network;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.cmbb.smartmarket.activity.address.model.UserAddressDeleteRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressDeleteResponseModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressDetailRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressDetailResponseModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressGetPageResponseModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressSaveRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressSaveResponseModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressSetDefaultRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressSetDefaultResponseModel;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
import com.cmbb.smartmarket.activity.login.model.LoginRequestModel;
import com.cmbb.smartmarket.activity.login.model.LoginResponseModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeRequestModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeResponseModel;
import com.cmbb.smartmarket.activity.market.model.CodeInfoListRequestModel;
import com.cmbb.smartmarket.activity.market.model.CodeInfoListResponseModel;
import com.cmbb.smartmarket.activity.market.model.CommodityPublishResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderCommitRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderCommitResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderPayOrderRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderPayOrderResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderReserveRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderReserveResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageNeedRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageNeedResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductRecommendRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductRecommendResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllRequest;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictRequestModel;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictResponseModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateRequestModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipaySmsRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipaySmsResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountGetCashRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountGetCashResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRetrofitModel;
import com.cmbb.smartmarket.base.Constants;

import java.util.List;
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
public class HttpMethod {

    private static final String TAG = HttpMethod.class.getSimpleName();
    private static HttpMethod ourInstance = new HttpMethod();
    private static final int DEFAULT_TIMEOUT = 15;
    private ApiInterface mApiInterface;

    public static HttpMethod getInstance() {
        return ourInstance;
    }

    private HttpMethod() {
        SmartLogInterceptor interceptor = new SmartLogInterceptor();
        interceptor.setLevel(SmartLogInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
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
     * 获取测试数据接口
     *
     * @param observer 调用者传过来的观察者对象
     */
    public Subscription getTestData(Observer<TestModel> observer, TestRequestModel retrofitRequestModel) {
        Observable<TestModel> observable = mApiInterface
                .testApi(retrofitRequestModel)
                .map(new HttpResultFunc<TestModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 登陆接口
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestLogin(Observer<LoginResponseModel> observer, LoginRequestModel retrofitRequestModel) {
        Observable<LoginResponseModel> observable = mApiInterface
                .login(retrofitRequestModel)
                .map(new HttpResultFunc<LoginResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取登陆验证码
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestSecurityCode(Observer<SecurityCodeResponseModel> observer, SecurityCodeRequestModel retrofitRequestModel) {
        Observable<SecurityCodeResponseModel> observable = mApiInterface
                .getSecurityCode(retrofitRequestModel)
                .map(new HttpResultFunc<SecurityCodeResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 更新用户信息
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestUpdateUserInfo(Observer<UserInfoUpdateResponseModel> observer, UserInfoUpdateRequestModel retrofitRequestModel) {
        Observable<UserInfoUpdateResponseModel> observable = mApiInterface
                .updateUserInfoRequest(retrofitRequestModel)
                .map(new HttpResultFunc<UserInfoUpdateResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 上传用户头像
     *
     * @param observer
     * @return
     */
    public Subscription requestUpdateInfoImage(Observer<UserInfoUpdateResponseModel> observer, Map<String, RequestBody> params) {
        Observable<UserInfoUpdateResponseModel> observable = mApiInterface
                .uploadUserInfoImage(params)
                .map(new HttpResultFunc<UserInfoUpdateResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 发布/求购产品
     *
     * @param observer
     * @return
     */
    public Subscription requestPublishCommodity(Observer<CommodityPublishResponseModel> observer, Map<String, RequestBody> params, List<RequestBody> files) {
        Observable<CommodityPublishResponseModel> observable = mApiInterface
                .publishCommodityRequest(params, files)
                .map(new HttpResultFunc<CommodityPublishResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品字典分类
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestCodeInfoList(Observer<CodeInfoListResponseModel> observer, CodeInfoListRequestModel retrofitRequestModel) {
        Observable<CodeInfoListResponseModel> observable = mApiInterface
                .codeInfoListRequest(retrofitRequestModel)
                .map(new HttpResultFunc<CodeInfoListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品字典分类All
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription systemCodeInfoGetAllRequest(Observer<SystemCodeInfoGetAllResponseModel> observer, SystemCodeInfoGetAllRequest retrofitRequestModel) {
        Observable<SystemCodeInfoGetAllResponseModel> observable = mApiInterface
                .systemCodeInfoGetAllRequest(retrofitRequestModel)
                .map(new HttpResultFunc<SystemCodeInfoGetAllResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取产品详情
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductDetail(Observer<ProductDetailResponseModel> observer, ProductDetailRequestModel retrofitRequestModel) {
        Observable<ProductDetailResponseModel> observable = mApiInterface
                .productDetailsRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductDetailResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品回复
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductReplay(Observer<ProductReplayResponseModel> observer, ProductReplayRequestModel retrofitRequestModel) {
        Observable<ProductReplayResponseModel> observable = mApiInterface
                .productReplayRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductReplayResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品回复列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription productReplyListRequest(Observer<ProductReplyListResponseModel> observer, ProductReplyListRequestModel retrofitRequestModel) {
        Observable<ProductReplyListResponseModel> observable = mApiInterface
                .productReplyListRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductReplyListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品回复删除
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductDeleteReply(Observer<ProductDeleteReplyResponseModel> observer, ProductDeleteReplyRequestModel retrofitRequestModel) {
        Observable<ProductDeleteReplyResponseModel> observable = mApiInterface
                .productDeleteReplyRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductDeleteReplyResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductGetPage(Observer<ProductGetPageResponseModel> observer, ProductGetPageRequestModel retrofitRequestModel) {
        Observable<ProductGetPageResponseModel> observable = mApiInterface
                .productGetPageRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductGetPageResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 商品收藏
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductCollect(Observer<ProductCollectResponseModel> observer, ProductCollectRequestModel retrofitRequestModel) {
        Observable<ProductCollectResponseModel> observable = mApiInterface
                .productCollectRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductCollectResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 求购列表筛选字典
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestSystemDictList(Observer<SystemDictListResponseModel> observer, SystemDictListRequestModel retrofitRequestModel) {
        Observable<SystemDictListResponseModel> observable = mApiInterface
                .systemDictListRequest(retrofitRequestModel)
                .map(new HttpResultFunc<SystemDictListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 求购列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductGetPageNeed(Observer<ProductGetPageNeedResponseModel> observer, ProductGetPageNeedRequestModel retrofitRequestModel) {
        Observable<ProductGetPageNeedResponseModel> observable = mApiInterface
                .productGetPageNeedRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductGetPageNeedResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 求购商品推荐
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductRecommend(Observer<ProductRecommendResponseModel> observer, ProductRecommendRequestModel retrofitRequestModel) {
        Observable<ProductRecommendResponseModel> observable = mApiInterface
                .productRecommendRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductRecommendResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 求购点赞
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductAskToBuySpot(Observer<ProductAskToBuySpotResponseModel> observer, ProductAskToBuySpotRequestModel retrofitRequestModel) {
        Observable<ProductAskToBuySpotResponseModel> observable = mApiInterface
                .productAskToBuySpotRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductAskToBuySpotResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 举报页面字典
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestSystemTipoffsGetPage(Observer<SystemTipoffsGetPageResponseModel> observer, SystemTipoffsGetPageRequestModel retrofitRequestModel) {
        Observable<SystemTipoffsGetPageResponseModel> observable = mApiInterface
                .systemTipoffsGetPageRequest(retrofitRequestModel)
                .map(new HttpResultFunc<SystemTipoffsGetPageResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 举报提交
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestSystemTipoffsGetPage(Observer<SystemTipoffsReportResponseModel> observer, SystemTipoffsReportRequestModel retrofitRequestModel) {
        Observable<SystemTipoffsReportResponseModel> observable = mApiInterface
                .systemTipoffsReportRequest(retrofitRequestModel)
                .map(new HttpResultFunc<SystemTipoffsReportResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 收货地址列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestUserAddressGetPage(Observer<UserAddressGetPageResponseModel> observer, UserAddressGetPageRequestModel retrofitRequestModel) {
        Observable<UserAddressGetPageResponseModel> observable = mApiInterface
                .userAddressGetPageRequest(retrofitRequestModel)
                .map(new HttpResultFunc<UserAddressGetPageResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 新增/修改收货地址
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestUserAddressSave(Observer<UserAddressSaveResponseModel> observer, UserAddressSaveRequestModel retrofitRequestModel) {
        Observable<UserAddressSaveResponseModel> observable = mApiInterface
                .userAddressSaveRequest(retrofitRequestModel)
                .map(new HttpResultFunc<UserAddressSaveResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取收货地址详情
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestUserAddressDetail(Observer<UserAddressDetailResponseModel> observer, UserAddressDetailRequestModel retrofitRequestModel) {
        Observable<UserAddressDetailResponseModel> observable = mApiInterface
                .userAddressDetailRequest(retrofitRequestModel)
                .map(new HttpResultFunc<UserAddressDetailResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 设置默认地址
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestUserAddressSetDefault(Observer<UserAddressSetDefaultResponseModel> observer, UserAddressSetDefaultRequestModel retrofitRequestModel) {
        Observable<UserAddressSetDefaultResponseModel> observable = mApiInterface
                .userAddressSetDefaultRequest(retrofitRequestModel)
                .map(new HttpResultFunc<UserAddressSetDefaultResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 删除地址
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestUserAddressDelete(Observer<UserAddressDeleteResponseModel> observer, UserAddressDeleteRequestModel retrofitRequestModel) {
        Observable<UserAddressDeleteResponseModel> observable = mApiInterface
                .userAddressDeleteRequest(retrofitRequestModel)
                .map(new HttpResultFunc<UserAddressDeleteResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 预览订单
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderReserveDelete(Observer<MarketOrderReserveResponseModel> observer, MarketOrderReserveRequestModel retrofitRequestModel) {
        Observable<MarketOrderReserveResponseModel> observable = mApiInterface
                .marketOrderReserveRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderReserveResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 提交订单
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderCommitDelete(Observer<MarketOrderCommitResponseModel> observer, MarketOrderCommitRequestModel retrofitRequestModel) {
        Observable<MarketOrderCommitResponseModel> observable = mApiInterface
                .marketOrderCommitRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderCommitResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 订单发起支付
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderPayOrder(Observer<MarketOrderPayOrderResponseModel> observer, MarketOrderPayOrderRequestModel retrofitRequestModel) {
        Observable<MarketOrderPayOrderResponseModel> observable = mApiInterface
                .marketOrderPayOrderRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderPayOrderResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 订单申请退款
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderRefund(Observer<MarketOrderRefundResponseModel> observer, MarketOrderRefundRequestModel retrofitRequestModel) {
        Observable<MarketOrderRefundResponseModel> observable = mApiInterface
                .marketOrderRefundRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderRefundResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 订单列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderList(Observer<MarketOrderListResponseModel> observer, MarketOrderListRequestModel retrofitRequestModel) {
        Observable<MarketOrderListResponseModel> observable = mApiInterface
                .marketOrderListRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 服务列表查询字典
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription systemGetMultipleDict(Observer<SystemGetMultipleDictResponseModel> observer, SystemGetMultipleDictRequestModel retrofitRequestModel) {
        Observable<SystemGetMultipleDictResponseModel> observable = mApiInterface
                .systemGetMultipleDictRequest(retrofitRequestModel)
                .map(new HttpResultFunc<SystemGetMultipleDictResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 钱包首页
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountIndexRequest(Observer<WalletAccountIndexResponseModel> observer, WalletAccountIndexRequestModel retrofitRequestModel) {
        Observable<WalletAccountIndexResponseModel> observable = mApiInterface
                .walletAccountIndexRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountIndexResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 设置交易密码
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountSetPasswordRequest(Observer<WalletAccountSetPasswordResponseModel> observer, WalletAccountSetPasswordRequestModel retrofitRequestModel) {
        Observable<WalletAccountSetPasswordResponseModel> observable = mApiInterface
                .walletAccountSetPasswordRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountSetPasswordResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 验证交易密码
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountValiatePayPasswordRequest(Observer<WalletAccountValiatePayPasswordResponseModel> observer, WalletAccountValiatePayPasswordRequestModel retrofitRequestModel) {
        Observable<WalletAccountValiatePayPasswordResponseModel> observable = mApiInterface
                .walletAccountValiatePayPasswordRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountValiatePayPasswordResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 绑定支付宝账号发送的手机验证码
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountBindalipaySmsRequest(Observer<WalletAccountBindalipaySmsResponseModel> observer, WalletAccountBindalipaySmsRequestModel retrofitRequestModel) {
        Observable<WalletAccountBindalipaySmsResponseModel> observable = mApiInterface
                .walletAccountBindalipaySmsRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountBindalipaySmsResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 提现
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountGetCashRequest(Observer<WalletAccountGetCashResponseModel> observer, WalletAccountGetCashRequestModel retrofitRequestModel) {
        Observable<WalletAccountGetCashResponseModel> observable = mApiInterface
                .walletAccountGetCashRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountGetCashResponseModel>());
        return addSubscribe(observable, observer);
    }



    /**
     * 宝贝发布列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription myselfProductPublicListRequest(Observer<MyselfProductPublicListResponseModel> observer, MyselfProductPublicListRequestModel retrofitRequestModel) {
        Observable<MyselfProductPublicListResponseModel> observable = mApiInterface
                .myselfProductPublicListRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MyselfProductPublicListResponseModel>());
        return addSubscribe(observable, observer);
    }
}
