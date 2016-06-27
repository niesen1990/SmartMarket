package com.cmbb.smartmarket.network;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;

import com.cmbb.smartmarket.activity.address.model.ProvinceCityGetAllRequestModel;
import com.cmbb.smartmarket.activity.address.model.ProvinceCityGetAllResponseModel;
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
import com.cmbb.smartmarket.activity.home.model.MarketHomeAdvertInfoRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeAdvertInfoResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetAllCityListRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetAllCityListResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetHotCityListRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetHotCityListResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetScreenRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeGetScreenResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeRecommendationRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeRecommendationResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeSaveLocationAddressRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketHomeSaveLocationAddressResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetPageRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetPageResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetTypeRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetTypeResponseModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageSetMessageTypeRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageSetMessageTypeResponseModel;
import com.cmbb.smartmarket.activity.home.model.MyselfGetCountRequestModel;
import com.cmbb.smartmarket.activity.home.model.MyselfGetCountResponseModel;
import com.cmbb.smartmarket.activity.home.model.MyselfProductCollectListRequestModel;
import com.cmbb.smartmarket.activity.home.model.MyselfProductCollectListResponseModel;
import com.cmbb.smartmarket.activity.login.model.LoginRequestModel;
import com.cmbb.smartmarket.activity.login.model.LoginResponseModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeRequestModel;
import com.cmbb.smartmarket.activity.login.model.SecurityCodeResponseModel;
import com.cmbb.smartmarket.activity.market.model.CodeInfoListRequestModel;
import com.cmbb.smartmarket.activity.market.model.CodeInfoListResponseModel;
import com.cmbb.smartmarket.activity.market.model.CommodityPublishResponseModel;
import com.cmbb.smartmarket.activity.market.model.ImageDeleteResponseModel;
import com.cmbb.smartmarket.activity.market.model.ImageUploadResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderCommitRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderCommitResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderPayOrderRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderPayOrderResponseModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderReserveRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderReserveResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuyResolveRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuyResolveResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteResponseModel;
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
import com.cmbb.smartmarket.activity.market.model.PublishEditResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllRequest;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportResponseModel;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchRequestModel;
import com.cmbb.smartmarket.activity.search.model.MarketHomeSearchResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterPersonCenterInfoRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterPersonCenterInfoResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketCenterSelectProductListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateSaveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketEvaluateSaveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketLogoutRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketLogoutResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderApplyRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderApplyRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderBuyerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderCancelRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderCancelResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderNoticeResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderRefundResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerReceiveResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerSendRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderSellerSendResponseModel;
import com.cmbb.smartmarket.activity.user.model.MyselfFeedbackOpinionRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfFeedbackOpinionResponseModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListRequestModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictRequestModel;
import com.cmbb.smartmarket.activity.user.model.SystemGetMultipleDictResponseModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateRequestModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBillListRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBillListResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindListRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindListResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipayRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipayResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipaySmsRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountBindalipaySmsResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountGetCashRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountGetCashResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountIndexResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordNextRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordNextResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountSetPasswordResponseModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
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
public class HttpMethod {

    private static final String TAG = HttpMethod.class.getSimpleName();
    private static HttpMethod ourInstance = new HttpMethod();
    private static final int DEFAULT_TIMEOUT = 15;
    private ApiInterface mApiInterface;
    private OkHttpClient okHttpClient;

    public static HttpMethod getInstance() {
        return ourInstance;
    }

    private HttpMethod() {
        SmartLogInterceptor interceptor = new SmartLogInterceptor();
        interceptor.setLevel(SmartLogInterceptor.Level.BODY);
        okHttpClient = new OkHttpClient.Builder()
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
                //重新登陆
                if (httpResult.getError().getErrorCode() == 14 || httpResult.getError().getErrorCode() == 15) {
                    Logout.logout(BaseApplication.getContext());
                }
                throw new ApiException(httpResult.getError().getErrorInfo());
            }
            return httpResult.getResponse();
        }
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
    public Subscription requestPublishCommodity(Observer<CommodityPublishResponseModel> observer, Map<String, RequestBody> params) {
        Observable<CommodityPublishResponseModel> observable = mApiInterface
                .publishCommodityRequest(params)
                .map(new HttpResultFunc<CommodityPublishResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 发布/求购 编辑
     *
     * @param observer
     * @return
     */
    public Subscription publishEditRequest(Observer<PublishEditResponseModel> observer, Map<String, RequestBody> params) {
        Observable<PublishEditResponseModel> observable = mApiInterface
                .publishEditRequest(params)
                .map(new HttpResultFunc<PublishEditResponseModel>());
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
     * 获取产品详情(merge)
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription requestProductDetailMergeReplay(Observer<Object> observer, ProductDetailRequestModel retrofitRequestModel, ProductReplyListRequestModel retrofitRequestModel2) {
        Observable<ProductDetailResponseModel> observable = mApiInterface
                .productDetailsRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductDetailResponseModel>());
        return mergeReplaySubscribe(observable, observer, retrofitRequestModel2);
    }

    /**
     * 合并Observer
     *
     * @param o Observable<T>
     * @param s Subscriber<T>
     */
    private Subscription mergeReplaySubscribe(Observable o, Observer s, ProductReplyListRequestModel retrofitRequestModel) {
        return o.mergeWith(mApiInterface.productReplyListRequest(retrofitRequestModel).map(new HttpResultFunc<ProductReplyListResponseModel>()))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
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
     * 商品删除
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription productDeleteRequest(Observer<ProductDeleteResponseModel> observer, ProductDeleteRequestModel retrofitRequestModel) {
        Observable<ProductDeleteResponseModel> observable = mApiInterface
                .productDeleteRequest(retrofitRequestModel)
                .map(new HttpResultFunc<ProductDeleteResponseModel>());
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
    public Subscription systemTipoffsReportRequest(Observer<SystemTipoffsReportResponseModel> observer, SystemTipoffsReportRequestModel retrofitRequestModel) {
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
    public Subscription marketOrderApplyRefund(Observer<MarketOrderApplyRefundResponseModel> observer, MarketOrderApplyRefundRequestModel retrofitRequestModel) {
        Observable<MarketOrderApplyRefundResponseModel> observable = mApiInterface
                .marketOrderApplyRefund(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderApplyRefundResponseModel>());
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
     * 修改交易密码下一步
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountSetPasswordNextRequest(Observer<WalletAccountSetPasswordNextResponseModel> observer, WalletAccountSetPasswordNextRequestModel retrofitRequestModel) {
        Observable<WalletAccountSetPasswordNextResponseModel> observable = mApiInterface
                .walletAccountSetPasswordNextRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountSetPasswordNextResponseModel>());
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
     * 绑定支付宝账号
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountBindalipay(Observer<WalletAccountBindalipayResponseModel> observer, WalletAccountBindalipayRequestModel retrofitRequestModel) {
        Observable<WalletAccountBindalipayResponseModel> observable = mApiInterface
                .walletAccountBindalipay(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountBindalipayResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 绑定的提现支付宝账号列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountBindListRequest(Observer<WalletAccountBindListResponseModel> observer, WalletAccountBindListRequestModel retrofitRequestModel) {
        Observable<WalletAccountBindListResponseModel> observable = mApiInterface
                .walletAccountBindListRequest(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountBindListResponseModel>());
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

    /**
     * 保存定位地址
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeSaveLocationAddressRequest(Observer<MarketHomeSaveLocationAddressResponseModel> observer, MarketHomeSaveLocationAddressRequestModel retrofitRequestModel) {
        Observable<MarketHomeSaveLocationAddressResponseModel> observable = mApiInterface
                .marketHomeSaveLocationAddressRequest(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeSaveLocationAddressResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取所有城市
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeGetAllCityList(Observer<MarketHomeGetAllCityListResponseModel> observer, MarketHomeGetAllCityListRequestModel retrofitRequestModel) {
        Observable<MarketHomeGetAllCityListResponseModel> observable = mApiInterface
                .marketHomeGetAllCityList(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeGetAllCityListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取热门城市
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeGetHotCityList(Observer<Object> observer, MarketHomeGetHotCityListRequestModel retrofitRequestModel, MarketHomeGetAllCityListRequestModel retrofitRequestModel2) {
        Observable<MarketHomeGetHotCityListResponseModel> observable = mApiInterface
                .marketHomeGetHotCityList(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeGetHotCityListResponseModel>());
        return mergeSubscribe(observable, observer, retrofitRequestModel2);
    }

    /**
     * 合并Observer
     *
     * @param o Observable<T>
     * @param s Subscriber<T>
     */
    private Subscription mergeSubscribe(Observable o, Observer s, MarketHomeGetAllCityListRequestModel retrofitRequestModel) {
        return o.mergeWith(mApiInterface.marketHomeGetAllCityList(retrofitRequestModel).map(new HttpResultFunc<MarketHomeGetAllCityListResponseModel>()))
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(s);
    }

    /**
     * 获取消息数
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketMessageGetType(Observer<MarketMessageGetTypeResponseModel> observer, MarketMessageGetTypeRequestModel retrofitRequestModel) {
        Observable<MarketMessageGetTypeResponseModel> observable = mApiInterface
                .marketMessageGetType(retrofitRequestModel)
                .map(new HttpResultFunc<MarketMessageGetTypeResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 首页检索
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeSearch(Observer<MarketHomeSearchResponseModel> observer, MarketHomeSearchRequestModel retrofitRequestModel) {
        Observable<MarketHomeSearchResponseModel> observable = mApiInterface
                .marketHomeSearch(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeSearchResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 首页检索
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription myselfGetCount(Observer<MyselfGetCountResponseModel> observer, MyselfGetCountRequestModel retrofitRequestModel) {
        Observable<MyselfGetCountResponseModel> observable = mApiInterface
                .myselfGetCount(retrofitRequestModel)
                .map(new HttpResultFunc<MyselfGetCountResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 宝贝收藏列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription myselfProductCollectList(Observer<MyselfProductCollectListResponseModel> observer, MyselfProductCollectListRequestModel retrofitRequestModel) {
        Observable<MyselfProductCollectListResponseModel> observable = mApiInterface
                .myselfProductCollectList(retrofitRequestModel)
                .map(new HttpResultFunc<MyselfProductCollectListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 意见反馈
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription myselfFeedbackOpinion(Observer<MyselfFeedbackOpinionResponseModel> observer, MyselfFeedbackOpinionRequestModel retrofitRequestModel) {
        Observable<MyselfFeedbackOpinionResponseModel> observable = mApiInterface
                .myselfFeedbackOpinion(retrofitRequestModel)
                .map(new HttpResultFunc<MyselfFeedbackOpinionResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取在售/求购商品列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketCenterSelectProductList(Observer<MarketCenterSelectProductListResponseModel> observer, MarketCenterSelectProductListRequestModel retrofitRequestModel) {
        Observable<MarketCenterSelectProductListResponseModel> observable = mApiInterface
                .marketCenterSelectProductList(retrofitRequestModel)
                .map(new HttpResultFunc<MarketCenterSelectProductListResponseModel>());
        return addSubscribe(observable, observer);
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
        observable.subscribeOn(Schedulers.io());
        return addSubscribe(observable, observer);
    }

    /**
     * 上传图片带进度条
     *
     * @param observer
     * @return
     */
    public Subscription imageDelete(Observer<ImageDeleteResponseModel> observer, Map<String, RequestBody> params) {
        Observable<ImageDeleteResponseModel> observable = mApiInterface
                .imageDelete(params)
                .map(new HttpResultFunc<ImageDeleteResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 买家取消订单
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderCancel(Observer<MarketOrderCancelResponseModel> observer, MarketOrderCancelRequestModel retrofitRequestModel) {
        Observable<MarketOrderCancelResponseModel> observable = mApiInterface
                .marketOrderCancel(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderCancelResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 保存/追加评价
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketEvaluateSave(Observer<MarketEvaluateSaveResponseModel> observer, MarketEvaluateSaveRequestModel retrofitRequestModel) {
        Observable<MarketEvaluateSaveResponseModel> observable = mApiInterface
                .marketEvaluateSave(retrofitRequestModel)
                .map(new HttpResultFunc<MarketEvaluateSaveResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 评价列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketEvaluateList(Observer<MarketEvaluateListResponseModel> observer, MarketEvaluateListRequestModel retrofitRequestModel) {
        Observable<MarketEvaluateListResponseModel> observable = mApiInterface
                .marketEvaluateList(retrofitRequestModel)
                .map(new HttpResultFunc<MarketEvaluateListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 查看评价 评价详情
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketEvaluateDetail(Observer<MarketEvaluateDetailResponseModel> observer, MarketEvaluateDetailRequestModel retrofitRequestModel) {
        Observable<MarketEvaluateDetailResponseModel> observable = mApiInterface
                .marketEvaluateDetail(retrofitRequestModel)
                .map(new HttpResultFunc<MarketEvaluateDetailResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 卖家发货
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderSellerSend(Observer<MarketOrderSellerSendResponseModel> observer, MarketOrderSellerSendRequestModel retrofitRequestModel) {
        Observable<MarketOrderSellerSendResponseModel> observable = mApiInterface
                .marketOrderSellerSend(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderSellerSendResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 买家发货
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderBuyerSend(Observer<MarketOrderSellerSendResponseModel> observer, MarketOrderSellerSendRequestModel retrofitRequestModel) {
        Observable<MarketOrderSellerSendResponseModel> observable = mApiInterface
                .marketOrderBuyerSend(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderSellerSendResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 买家确认收货
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderBuyerReceive(Observer<MarketOrderBuyerReceiveResponseModel> observer, MarketOrderBuyerReceiveRequestModel retrofitRequestModel) {
        Observable<MarketOrderBuyerReceiveResponseModel> observable = mApiInterface
                .marketOrderBuyerReceive(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderBuyerReceiveResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 求购解决
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription productAskToBuyResolve(Observer<ProductAskToBuyResolveResponseModel> observer, ProductAskToBuyResolveRequestModel retrofitRequestModel) {
        Observable<ProductAskToBuyResolveResponseModel> observable = mApiInterface
                .productAskToBuyResolve(retrofitRequestModel)
                .map(new HttpResultFunc<ProductAskToBuyResolveResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 卖家审核退款
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderRefund(Observer<MarketOrderRefundResponseModel> observer, MarketOrderRefundRequestModel retrofitRequestModel) {
        Observable<MarketOrderRefundResponseModel> observable = mApiInterface
                .marketOrderRefund(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderRefundResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 卖家确认收货
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderSellerReceive(Observer<MarketOrderSellerReceiveResponseModel> observer, MarketOrderSellerReceiveRequestModel retrofitRequestModel) {
        Observable<MarketOrderSellerReceiveResponseModel> observable = mApiInterface
                .marketOrderSellerReceive(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderSellerReceiveResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 订单详情
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderDetail(Observer<MarketOrderDetailResponseModel> observer, MarketOrderDetailRequestModel retrofitRequestModel) {
        Observable<MarketOrderDetailResponseModel> observable = mApiInterface
                .marketOrderDetail(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderDetailResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 获取广告位信息
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeAdvertInfo(Observer<MarketHomeAdvertInfoResponseModel> observer, MarketHomeAdvertInfoRequestModel retrofitRequestModel) {
        Observable<MarketHomeAdvertInfoResponseModel> observable = mApiInterface
                .marketHomeAdvertInfo(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeAdvertInfoResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 官方推荐
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeRecommendation(Observer<MarketHomeRecommendationResponseModel> observer, MarketHomeRecommendationRequestModel retrofitRequestModel) {
        Observable<MarketHomeRecommendationResponseModel> observable = mApiInterface
                .marketHomeRecommendation(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeRecommendationResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 提醒发货/收货/退货
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketOrderNotice(Observer<MarketOrderNoticeResponseModel> observer, MarketOrderNoticeRequestModel retrofitRequestModel) {
        Observable<MarketOrderNoticeResponseModel> observable = mApiInterface
                .marketOrderNotice(retrofitRequestModel)
                .map(new HttpResultFunc<MarketOrderNoticeResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 提醒发货/收货/退货
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketCenterPersonCenterInfo(Observer<MarketCenterPersonCenterInfoResponseModel> observer, MarketCenterPersonCenterInfoRequestModel retrofitRequestModel) {
        Observable<MarketCenterPersonCenterInfoResponseModel> observable = mApiInterface
                .marketCenterPersonCenterInfo(retrofitRequestModel)
                .map(new HttpResultFunc<MarketCenterPersonCenterInfoResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 收货地址城市字典
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription provinceCityGetAll(Observer<ProvinceCityGetAllResponseModel> observer, ProvinceCityGetAllRequestModel retrofitRequestModel) {
        Observable<ProvinceCityGetAllResponseModel> observable = mApiInterface
                .provinceCityGetAll(retrofitRequestModel)
                .map(new HttpResultFunc<ProvinceCityGetAllResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 筛选类型
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketHomeGetScreen(Observer<MarketHomeGetScreenResponseModel> observer, MarketHomeGetScreenRequestModel retrofitRequestModel) {
        Observable<MarketHomeGetScreenResponseModel> observable = mApiInterface
                .marketHomeGetScreen(retrofitRequestModel)
                .map(new HttpResultFunc<MarketHomeGetScreenResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 消息列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketMessageGetPage(Observer<MarketMessageGetPageResponseModel> observer, MarketMessageGetPageRequestModel retrofitRequestModel) {
        Observable<MarketMessageGetPageResponseModel> observable = mApiInterface
                .marketMessageGetPage(retrofitRequestModel)
                .map(new HttpResultFunc<MarketMessageGetPageResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 消息列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketMessageSetMessageType(Observer<MarketMessageSetMessageTypeResponseModel> observer, MarketMessageSetMessageTypeRequestModel retrofitRequestModel) {
        Observable<MarketMessageSetMessageTypeResponseModel> observable = mApiInterface
                .marketMessageSetMessageType(retrofitRequestModel)
                .map(new HttpResultFunc<MarketMessageSetMessageTypeResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 消息列表
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription walletAccountBillList(Observer<WalletAccountBillListResponseModel> observer, WalletAccountBillListRequestModel retrofitRequestModel) {
        Observable<WalletAccountBillListResponseModel> observable = mApiInterface
                .walletAccountBillList(retrofitRequestModel)
                .map(new HttpResultFunc<WalletAccountBillListResponseModel>());
        return addSubscribe(observable, observer);
    }

    /**
     * 注销登录
     *
     * @param observer
     * @param retrofitRequestModel
     * @return
     */
    public Subscription marketLogout(Observer<MarketLogoutResponseModel> observer, MarketLogoutRequestModel retrofitRequestModel) {
        Observable<MarketLogoutResponseModel> observable = mApiInterface
                .marketLogout(retrofitRequestModel)
                .map(new HttpResultFunc<MarketLogoutResponseModel>());
        return addSubscribe(observable, observer);
    }

}
