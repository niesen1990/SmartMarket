package com.cmbb.smartmarket.network;

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
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.activity.home.model.TestRequestModel;
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
import com.cmbb.smartmarket.base.BaseRetrofitModel;

import java.util.List;
import java.util.Map;

import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;
import rx.Observable;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/10 上午11:10
 */
public interface ApiInterface {

    String Base = "http://erpuat.mengbp.com:8094/";
    String HOST = Base + "wine-market-rest/cgi/";
    //    String Base = "http://192.168.100.64:8085/";
    //    String HOST = Base + "wine-market-rest/cgi/";

    String SHARE_NEED = "http://erpuat.mengbp.com:8090/SmartApp/MBPZShare/index.html#/shopDetail/";
    String SHARE_PUBLISH = "http://erpuat.mengbp.com:8090/SmartApp/MBPZShare/index.html#/productDetail/";

    @Headers("Content-Type: application/json")
    @POST("http://mengbaopai.smart-kids.com:82/wine-rest/cgi")
    Observable<BaseRetrofitModel<TestModel>> testApi(@Body TestRequestModel retrofitRequestModel);//测试数据接口

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<LoginResponseModel>> login(@Body LoginRequestModel retrofitRequestModel);

    String login = "market/login";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<SecurityCodeResponseModel>> getSecurityCode(@Body SecurityCodeRequestModel retrofitRequestModel);

    String SecurityCode = "market/getSecurityCode";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<UserInfoUpdateResponseModel>> updateUserInfoRequest(@Body UserInfoUpdateRequestModel retrofitRequestModel);

    String UserInfoUpdate = "market/user/update";

    @Multipart
    @POST(Base + "wine-market-rest/market/user/userImg/")
    Observable<BaseRetrofitModel<UserInfoUpdateResponseModel>> uploadUserInfoImage(@PartMap Map<String, RequestBody> params);

    //发布
    @Multipart
    @POST(Base + "wine-market-rest/product/v1.1/public")
    Observable<BaseRetrofitModel<CommodityPublishResponseModel>> publishCommodityRequest(@PartMap Map<String, RequestBody> params);

    //发布编辑
    @Multipart
    @POST(Base + "wine-market-rest/product/v1.1/edit")
    Observable<BaseRetrofitModel<PublishEditResponseModel>> publishEditRequest(@PartMap Map<String, RequestBody> params);

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<CodeInfoListResponseModel>> codeInfoListRequest(@Body CodeInfoListRequestModel retrofitRequestModel);

    // 商品字典分类
    String CodeInfoList = "system/codeInfoList";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<SystemCodeInfoGetAllResponseModel>> systemCodeInfoGetAllRequest(@Body SystemCodeInfoGetAllRequest retrofitRequestModel);

    // 商品字典分类All
    String SystemCodeInfoGetAll = "system/codeInfo/getAll";

    @Multipart
    @POST("http://erpuat.mengbp.com:8094/wine-market-rest/product/public/edit/")
    Observable<BaseRetrofitModel<CommodityPublishResponseModel>> publishCommodityEditRequest(@PartMap Map<String, RequestBody> params, @Part("imageList") List<RequestBody> files);

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductDetailResponseModel>> productDetailsRequest(@Body ProductDetailRequestModel retrofitRequestModel);

    // 商品详情
    String ProductDetails = "product/details";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductReplayResponseModel>> productReplayRequest(@Body ProductReplayRequestModel retrofitRequestModel);

    // 商品回复
    String ProductReply = "product/reply";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductReplyListResponseModel>> productReplyListRequest(@Body ProductReplyListRequestModel retrofitRequestModel);

    // 商品回复列表
    String ProductReplyList = "product/reply/list";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductDeleteResponseModel>> productDeleteRequest(@Body ProductDeleteRequestModel retrofitRequestModel);

    // 商品删除
    String ProductDelete = "product/delete";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductDeleteReplyResponseModel>> productDeleteReplyRequest(@Body ProductDeleteReplyRequestModel retrofitRequestModel);

    // 商品回复删除
    String ProductDeleteReply = "product/deleteReply";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductGetPageResponseModel>> productGetPageRequest(@Body ProductGetPageRequestModel retrofitRequestModel);

    // 商品列表
    String ProductGetPage = "product/getPage";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductCollectResponseModel>> productCollectRequest(@Body ProductCollectRequestModel retrofitRequestModel);

    // 商品收藏
    String ProductCollect = "product/collect";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<SystemDictListResponseModel>> systemDictListRequest(@Body SystemDictListRequestModel retrofitRequestModel);

    // 求购列表筛选字典
    String SystemDictList = "system/dictList";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductAskToBuyResolveResponseModel>> productAskToBuyResolve(@Body ProductAskToBuyResolveRequestModel retrofitRequestModel);

    // 求购解决
    String ProductAskToBuyResolve = "product/askToBuy/resolve";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductGetPageNeedResponseModel>> productGetPageNeedRequest(@Body ProductGetPageNeedRequestModel retrofitRequestModel);

    // 求购列表
    String ProductGetPageNeed = "product/getPage";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductRecommendResponseModel>> productRecommendRequest(@Body ProductRecommendRequestModel retrofitRequestModel);

    // 求购列表
    String ProductRecommend = "product/recommend";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProductAskToBuySpotResponseModel>> productAskToBuySpotRequest(@Body ProductAskToBuySpotRequestModel retrofitRequestModel);

    // 求购列表
    String ProductAskToBuySpot = "product/askToBuy/spot";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<SystemTipoffsGetPageResponseModel>> systemTipoffsGetPageRequest(@Body SystemTipoffsGetPageRequestModel retrofitRequestModel);

    // 举报页面字典
    String SystemTipoffsGetPage = "system/tipoffs/getPage";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<SystemTipoffsReportResponseModel>> systemTipoffsReportRequest(@Body SystemTipoffsReportRequestModel retrofitRequestModel);

    // 举报
    String SystemTipoffsReport = "system/tipoffs/report";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<UserAddressGetPageResponseModel>> userAddressGetPageRequest(@Body UserAddressGetPageRequestModel retrofitRequestModel);

    // 收货地址列表
    String UserAddressGetPage = "userAddress/getPage";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<UserAddressSaveResponseModel>> userAddressSaveRequest(@Body UserAddressSaveRequestModel retrofitRequestModel);

    // 收货地址列表
    String UserAddressSave = "userAddress/save";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<UserAddressDetailResponseModel>> userAddressDetailRequest(@Body UserAddressDetailRequestModel retrofitRequestModel);

    // 收货地址列表
    String UserAddressDetail = "userAddress/detail";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<UserAddressSetDefaultResponseModel>> userAddressSetDefaultRequest(@Body UserAddressSetDefaultRequestModel retrofitRequestModel);

    // 收货地址列表
    String UserAddressSetDefault = "userAddress/setDefault";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<UserAddressDeleteResponseModel>> userAddressDeleteRequest(@Body UserAddressDeleteRequestModel retrofitRequestModel);

    // 删除地址
    String UserAddressDelete = "userAddress/delete";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderReserveResponseModel>> marketOrderReserveRequest(@Body MarketOrderReserveRequestModel retrofitRequestModel);

    // 预览订单
    String MarketOrderReserve = "market/order/reserve";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderCommitResponseModel>> marketOrderCommitRequest(@Body MarketOrderCommitRequestModel retrofitRequestModel);

    // 提交订单
    String MarketOrderCommit = "market/order/commit";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderPayOrderResponseModel>> marketOrderPayOrderRequest(@Body MarketOrderPayOrderRequestModel retrofitRequestModel);

    // 提交订单
    String MarketOrderPayOrder = "market/order/payOrder";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderApplyRefundResponseModel>> marketOrderApplyRefund(@Body MarketOrderApplyRefundRequestModel retrofitRequestModel);

    // 订单申请退款
    String MarketOrderApplyRefund = "market/order/applyRefund";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderListResponseModel>> marketOrderListRequest(@Body MarketOrderListRequestModel retrofitRequestModel);

    // 订单列表
    String MarketOrderList = "market/order/list";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<SystemGetMultipleDictResponseModel>> systemGetMultipleDictRequest(@Body SystemGetMultipleDictRequestModel retrofitRequestModel);

    // 服务列表查询字典
    String SystemGetMultipleDict = "system/getMultipleDict";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountIndexResponseModel>> walletAccountIndexRequest(@Body WalletAccountIndexRequestModel retrofitRequestModel);

    // 钱包首页
    String WalletAccountIndex = "wallet/account/index";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountSetPasswordResponseModel>> walletAccountSetPasswordRequest(@Body WalletAccountSetPasswordRequestModel retrofitRequestModel);

    // 设置交易密码
    String WalletAccountSetPassword = "wallet/account/setPassword";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountValiatePayPasswordResponseModel>> walletAccountValiatePayPasswordRequest(@Body WalletAccountValiatePayPasswordRequestModel retrofitRequestModel);

    // 验证交易密码
    String WalletAccountValiatePayPassword = "wallet/account/valiatePayPassword";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountBindalipaySmsResponseModel>> walletAccountBindalipaySmsRequest(@Body WalletAccountBindalipaySmsRequestModel retrofitRequestModel);

    // 绑定支付宝账号发送的手机验证码
    String WalletAccountBindalipaySms = "wallet/account/bindalipay/sms";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountBindalipayResponseModel>> walletAccountBindalipay(@Body WalletAccountBindalipayRequestModel retrofitRequestModel);

    // 绑定支付宝账号
    String WalletAccountBindalipay = "wallet/account/bindalipay";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountBindListResponseModel>> walletAccountBindListRequest(@Body WalletAccountBindListRequestModel retrofitRequestModel);

    // 绑定的提现支付宝账号列表
    String WalletAccountBindList = "wallet/account/bindlist";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountSetPasswordNextResponseModel>> walletAccountSetPasswordNextRequest(@Body WalletAccountSetPasswordNextRequestModel retrofitRequestModel);

    // 修改交易密码下一步
    String WalletAccountSetPasswordNext = "wallet/account/setPasswordNext";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountGetCashResponseModel>> walletAccountGetCashRequest(@Body WalletAccountGetCashRequestModel retrofitRequestModel);

    // 提现
    String WalletAccountGetCash = "wallet/account/getCash";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<WalletAccountBillListResponseModel>> walletAccountBillList(@Body WalletAccountBillListRequestModel retrofitRequestModel);

    // 余额明细
    String WalletAccountBillList = "wallet/account/billList";

    /* *******************************我的***********************************/
    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MyselfProductPublicListResponseModel>> myselfProductPublicListRequest(@Body MyselfProductPublicListRequestModel retrofitRequestModel);

    // 宝贝发布列表
    String MyselfProductPublicList = "myself/productPublic/list";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MyselfGetCountResponseModel>> myselfGetCount(@Body MyselfGetCountRequestModel retrofitRequestModel);

    // 宝贝发布列表
    String MyselfGetCount = "myself/getCount";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MyselfProductCollectListResponseModel>> myselfProductCollectList(@Body MyselfProductCollectListRequestModel retrofitRequestModel);

    // 宝贝收藏列表
    String MyselfProductCollectList = "myself/productCollect/list";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MyselfFeedbackOpinionResponseModel>> myselfFeedbackOpinion(@Body MyselfFeedbackOpinionRequestModel retrofitRequestModel);

    // 意见反馈
    String MyselfFeedbackOpinion = "myself/feedback/opinion";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketCenterSelectProductListResponseModel>> marketCenterSelectProductList(@Body MarketCenterSelectProductListRequestModel retrofitRequestModel);

    // 意见反馈
    String MarketCenterSelectProductList = "market/center/selectProductList";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketCenterPersonCenterInfoResponseModel>> marketCenterPersonCenterInfo(@Body MarketCenterPersonCenterInfoRequestModel retrofitRequestModel);

    // 获取个人中心基本信息
    String MarketCenterPersonCenterInfo = "market/center/personCenterInfo";

    /* *******************************我的***********************************/
    /* *******************************首页***********************************/
    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeSaveLocationAddressResponseModel>> marketHomeSaveLocationAddressRequest(@Body MarketHomeSaveLocationAddressRequestModel retrofitRequestModel);

    // 保存定位地址
    String MarketHomeSaveLocationAddress = "market/home/saveLocationAddress";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeGetAllCityListResponseModel>> marketHomeGetAllCityList(@Body MarketHomeGetAllCityListRequestModel retrofitRequestModel);

    // 获取所有城市
    String MarketHomeGetAllCityList = "market/home/getAllCityList";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeGetHotCityListResponseModel>> marketHomeGetHotCityList(@Body MarketHomeGetHotCityListRequestModel retrofitRequestModel);

    // 获取热门城市
    String MarketHomeGetHotCityList = "market/home/getHotCityList";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketMessageGetTypeResponseModel>> marketMessageGetType(@Body MarketMessageGetTypeRequestModel retrofitRequestModel);

    //获取消息数
    String MarketMessageGetType = "market/message/getType";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketMessageGetPageResponseModel>> marketMessageGetPage(@Body MarketMessageGetPageRequestModel retrofitRequestModel);

    //消息列表
    String MarketMessageGetPage = "market/message/getPage";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketMessageSetMessageTypeResponseModel>> marketMessageSetMessageType(@Body MarketMessageSetMessageTypeRequestModel retrofitRequestModel);

    //进入列表，消息数清0
    String MarketMessageSetMessageType = "market/message/setMessageType";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeAdvertInfoResponseModel>> marketHomeAdvertInfo(@Body MarketHomeAdvertInfoRequestModel retrofitRequestModel);

    // 获取广告位信息
    String MarketHomeAdvertInfo = "market/home/advert/info";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeRecommendationResponseModel>> marketHomeRecommendation(@Body MarketHomeRecommendationRequestModel retrofitRequestModel);

    // 获取广告位信息
    String MarketHomeRecommendation = "market/home/recommendation";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeGetScreenResponseModel>> marketHomeGetScreen(@Body MarketHomeGetScreenRequestModel retrofitRequestModel);

    //筛选类型
    String MarketHomeGetScreen = "market/home/getScreen";

    /* *******************************首页***********************************/
    /* *******************************搜索***********************************/
    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketHomeSearchResponseModel>> marketHomeSearch(@Body MarketHomeSearchRequestModel retrofitRequestModel);

    // 首页检索
    String MarketHomeSearch = "market/home/search";

    /* *******************************搜索***********************************/
    /* ******************************* 图片上传***********************************/
    @Multipart
    @POST(Base + "wine-market-rest/media/image/upload")
    Observable<BaseRetrofitModel<ImageUploadResponseModel>> uploadImageWithProgress(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST(Base + "wine-market-rest/media/image/delete")
    Observable<BaseRetrofitModel<ImageDeleteResponseModel>> imageDelete(@PartMap Map<String, RequestBody> params);

    /* *******************************图片上传***********************************/
    /* *******************************订单**********************************/
    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderCancelResponseModel>> marketOrderCancel(@Body MarketOrderCancelRequestModel retrofitRequestModel);

    // 意见反馈
    String MarketOrderCancel = "market/order/cancel";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketEvaluateSaveResponseModel>> marketEvaluateSave(@Body MarketEvaluateSaveRequestModel retrofitRequestModel);

    // 保存/追加评价
    String MarketEvaluateSave = "market/evaluate/save";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketEvaluateListResponseModel>> marketEvaluateList(@Body MarketEvaluateListRequestModel retrofitRequestModel);

    // 评价列表
    String MarketEvaluateList = "market/evaluate/list";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketEvaluateDetailResponseModel>> marketEvaluateDetail(@Body MarketEvaluateDetailRequestModel retrofitRequestModel);

    // 查看评价
    String MarketEvaluateDetail = "market/evaluate/detail";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderSellerSendResponseModel>> marketOrderSellerSend(@Body MarketOrderSellerSendRequestModel retrofitRequestModel);

    // 卖家发货
    String MarketOrderSellerSend = "market/order/sellerSend";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderBuyerReceiveResponseModel>> marketOrderBuyerReceive(@Body MarketOrderBuyerReceiveRequestModel retrofitRequestModel);

    // 买家确认收货
    String MarketOrderBuyerReceive = "market/order/buyerReceive";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderNoticeResponseModel>> marketOrderNotice(@Body MarketOrderNoticeRequestModel retrofitRequestModel);

    // 提醒发货/收货/退货
    String MarketOrderNotice = "market/order/notice";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderSellerSendResponseModel>> marketOrderBuyerSend(@Body MarketOrderSellerSendRequestModel retrofitRequestModel);

    // 买家发货（退货）
    String MarketOrderBuyerSend = "market/order/buyerSend";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderRefundResponseModel>> marketOrderRefund(@Body MarketOrderRefundRequestModel retrofitRequestModel);

    // 卖家审核退款
    String MarketOrderRefund = "market/order/refund";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderSellerReceiveResponseModel>> marketOrderSellerReceive(@Body MarketOrderSellerReceiveRequestModel retrofitRequestModel);

    // 卖家确认收货
    String MarketOrderSellerReceive = "market/order/sellerReceive";

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<MarketOrderDetailResponseModel>> marketOrderDetail(@Body MarketOrderDetailRequestModel retrofitRequestModel);

    // 订单详情
    String MarketOrderDetail = "market/order/detail";

    /* *******************************订单***********************************/

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<ProvinceCityGetAllResponseModel>> provinceCityGetAll(@Body ProvinceCityGetAllRequestModel retrofitRequestModel);

    // 订单详情
    String ProvinceCityGetAll = "provinceCity/getAll";

}
