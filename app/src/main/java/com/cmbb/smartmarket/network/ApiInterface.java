package com.cmbb.smartmarket.network;

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
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageNeedRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageNeedResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductRecommendRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductRecommendResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemDictListResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsGetPageResponseModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportRequestModel;
import com.cmbb.smartmarket.activity.market.model.SystemTipoffsReportResponseModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateRequestModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateResponseModel;
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
        String HOST = "http://192.168.100.109:8080/cgi/";
//    String HOST = "http://erpuat.mengbp.com:8094/wine-market-rest/cgi/";

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
    @POST("http://erpuat.mengbp.com:8094/wine-market-rest/market/user/userImg/")
    Observable<BaseRetrofitModel<UserInfoUpdateResponseModel>> uploadUserInfoImage(@PartMap Map<String, RequestBody> params);

    @Multipart
    @POST("http://erpuat.mengbp.com:8094/wine-market-rest/product/public/")
    Observable<BaseRetrofitModel<CommodityPublishResponseModel>> publishCommodityRequest(@PartMap Map<String, RequestBody> params, @Part("imageList") List<RequestBody> files);

    @Headers("Content-Type: application/json")
    @POST(HOST)
    Observable<BaseRetrofitModel<CodeInfoListResponseModel>> codeInfoListRequest(@Body CodeInfoListRequestModel retrofitRequestModel);

    // 商品字典分类
    String CodeInfoList = "system/codeInfoList";

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

    // 举报页面字典
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

}
