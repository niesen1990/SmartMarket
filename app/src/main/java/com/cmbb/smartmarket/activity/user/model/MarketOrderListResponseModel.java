package com.cmbb.smartmarket.activity.user.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午3:55
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午3:55
 * 修改备注：
 */
public class MarketOrderListResponseModel {

    /**
     * content : [{"id":5,"product":{"id":9,"title":"【求购】 求购服装111","introduce":"","content":"求购服装111","originalPrice":500,"currentPrice":100,"freight":5,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"","secondClassify":"MMYP_FZ","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","lontitude":"","latitude":"","province":"","city":"","district":"","address":"","type":"ASK_TO_BUY","status":"ITEMDOWNSHELF","statusText":"下架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-10 17:03:37","publicUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":1,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"isCollect":1,"isSpot":1},"buyUser":{"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":1,"province":110000,"provinceText":null,"city":110100,"cityText":"","introduce":"","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-13/ODUxNmNiNDctYjVlZC00N2JiLTljMzAtY2UwMDQxYWE4NjYx","imgWidth":542,"imgHeight":408,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"status":"NOT_PAID","statusName":"等待买家付款","orderCode":"00982024","phone":"15901718791","price":100,"payDate":"","freight":5,"express":"","expressNum":"","receiveName":"收货人姓名","receivePhone":"15901718791","postCode":"200000","address":"上海上海市杨浦区飞虹路568弄13号","cancelDate":"","cancelReason":"","refundStatus":1,"refundDate":"","refundServer":"","refundReason":"","refundMark":"","refundExpress":"","refundExpressNum":"","rejectDate":"","rejectReason":"","createDate":"2016-05-16 19:38:38","process":""}]
     * numberOfElements : 3
     * first : true
     */

    private DataEntity data;
    /**
     * data : {"content":[{"id":5,"product":{"id":9,"title":"【求购】 求购服装111","introduce":"","content":"求购服装111","originalPrice":500,"currentPrice":100,"freight":5,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"","secondClassify":"MMYP_FZ","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","lontitude":"","latitude":"","province":"","city":"","district":"","address":"","type":"ASK_TO_BUY","status":"ITEMDOWNSHELF","statusText":"下架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-10 17:03:37","publicUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":1,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"isCollect":1,"isSpot":1},"buyUser":{"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":1,"province":110000,"provinceText":null,"city":110100,"cityText":"","introduce":"","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-13/ODUxNmNiNDctYjVlZC00N2JiLTljMzAtY2UwMDQxYWE4NjYx","imgWidth":542,"imgHeight":408,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"status":"NOT_PAID","statusName":"等待买家付款","orderCode":"00982024","phone":"15901718791","price":100,"payDate":"","freight":5,"express":"","expressNum":"","receiveName":"收货人姓名","receivePhone":"15901718791","postCode":"200000","address":"上海上海市杨浦区飞虹路568弄13号","cancelDate":"","cancelReason":"","refundStatus":1,"refundDate":"","refundServer":"","refundReason":"","refundMark":"","refundExpress":"","refundExpressNum":"","rejectDate":"","rejectReason":"","createDate":"2016-05-16 19:38:38","process":""}],"numberOfElements":3,"first":true}
     * msg : 数据加载成功
     */

    private String msg;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataEntity {
        private int numberOfElements;
        private boolean first;

        private List<ContentEntity> content;

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity implements Parcelable {
            private int id;
            private ProductEntity product;
            private BuyUserEntity buyUser;
            private String status;
            private String statusName;
            private String orderCode;
            private String phone;
            private double price;
            private String payDate;
            private double freight;
            private String express;
            private String expressNum;
            private String receiveName;
            private String receivePhone;
            private String postCode;
            private String address;
            private String cancelDate;
            private String cancelReason;
            private String refundStatus;
            private String refundStatusName;
            private String refundDate;
            private String refundServer;
            private String refundReason;
            private String refundMark;
            private String refundExpress;
            private String refundExpressNum;
            private String rejectDate;
            private String rejectReason;
            private String createDate;
            private String process;

            public String getRefundStatusName() {
                return refundStatusName;
            }

            public void setRefundStatusName(String refundStatusName) {
                this.refundStatusName = refundStatusName;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public ProductEntity getProduct() {
                return product;
            }

            public void setProduct(ProductEntity product) {
                this.product = product;
            }

            public BuyUserEntity getBuyUser() {
                return buyUser;
            }

            public void setBuyUser(BuyUserEntity buyUser) {
                this.buyUser = buyUser;
            }

            public String getStatus() {
                return status;
            }

            public void setStatus(String status) {
                this.status = status;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            public String getOrderCode() {
                return orderCode;
            }

            public void setOrderCode(String orderCode) {
                this.orderCode = orderCode;
            }

            public String getPhone() {
                return phone;
            }

            public void setPhone(String phone) {
                this.phone = phone;
            }

            public double getPrice() {
                return price;
            }

            public void setPrice(double price) {
                this.price = price;
            }

            public String getPayDate() {
                return payDate;
            }

            public void setPayDate(String payDate) {
                this.payDate = payDate;
            }

            public double getFreight() {
                return freight;
            }

            public void setFreight(double freight) {
                this.freight = freight;
            }

            public String getExpress() {
                return express;
            }

            public void setExpress(String express) {
                this.express = express;
            }

            public String getExpressNum() {
                return expressNum;
            }

            public void setExpressNum(String expressNum) {
                this.expressNum = expressNum;
            }

            public String getReceiveName() {
                return receiveName;
            }

            public void setReceiveName(String receiveName) {
                this.receiveName = receiveName;
            }

            public String getReceivePhone() {
                return receivePhone;
            }

            public void setReceivePhone(String receivePhone) {
                this.receivePhone = receivePhone;
            }

            public String getPostCode() {
                return postCode;
            }

            public void setPostCode(String postCode) {
                this.postCode = postCode;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public String getCancelDate() {
                return cancelDate;
            }

            public void setCancelDate(String cancelDate) {
                this.cancelDate = cancelDate;
            }

            public String getCancelReason() {
                return cancelReason;
            }

            public void setCancelReason(String cancelReason) {
                this.cancelReason = cancelReason;
            }

            public String getRefundStatus() {
                return refundStatus;
            }

            public void setRefundStatus(String refundStatus) {
                this.refundStatus = refundStatus;
            }

            public String getRefundDate() {
                return refundDate;
            }

            public void setRefundDate(String refundDate) {
                this.refundDate = refundDate;
            }

            public String getRefundServer() {
                return refundServer;
            }

            public void setRefundServer(String refundServer) {
                this.refundServer = refundServer;
            }

            public String getRefundReason() {
                return refundReason;
            }

            public void setRefundReason(String refundReason) {
                this.refundReason = refundReason;
            }

            public String getRefundMark() {
                return refundMark;
            }

            public void setRefundMark(String refundMark) {
                this.refundMark = refundMark;
            }

            public String getRefundExpress() {
                return refundExpress;
            }

            public void setRefundExpress(String refundExpress) {
                this.refundExpress = refundExpress;
            }

            public String getRefundExpressNum() {
                return refundExpressNum;
            }

            public void setRefundExpressNum(String refundExpressNum) {
                this.refundExpressNum = refundExpressNum;
            }

            public String getRejectDate() {
                return rejectDate;
            }

            public void setRejectDate(String rejectDate) {
                this.rejectDate = rejectDate;
            }

            public String getRejectReason() {
                return rejectReason;
            }

            public void setRejectReason(String rejectReason) {
                this.rejectReason = rejectReason;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getProcess() {
                return process;
            }

            public void setProcess(String process) {
                this.process = process;
            }

            public static class ProductEntity implements Parcelable {
                private int id;
                private String title;
                private String introduce;
                private String content;
                private double originalPrice;
                private double currentPrice;
                private double freight;
                private String priceDesc;
                private String parentClassify;
                private String parentClassifyText;
                private String secondClassify;
                private String secondClassifyText;
                private String thirdClassify;
                private String thirdClassifyText;
                private String lontitude;
                private String latitude;
                private String province;
                private String city;
                private String district;
                private String address;
                private String type;
                private String status;
                private String statusText;
                private int isResolve;
                private String resolveDate;
                private int browseNumber;
                private int replyNumber;
                private int shareNumber;
                private int isRecommoned;
                private String publicDate;
                private List<ProductImageListEntity> productImageList;
                private PublicUserEntity publicUser;
                private int isCollect;
                private int isSpot;

                public List<ProductImageListEntity> getProductImageList() {
                    return productImageList;
                }

                public void setProductImageList(List<ProductImageListEntity> productImageList) {
                    this.productImageList = productImageList;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public String getTitle() {
                    return title;
                }

                public void setTitle(String title) {
                    this.title = title;
                }

                public String getIntroduce() {
                    return introduce;
                }

                public void setIntroduce(String introduce) {
                    this.introduce = introduce;
                }

                public String getContent() {
                    return content;
                }

                public void setContent(String content) {
                    this.content = content;
                }

                public double getOriginalPrice() {
                    return originalPrice;
                }

                public void setOriginalPrice(double originalPrice) {
                    this.originalPrice = originalPrice;
                }

                public double getCurrentPrice() {
                    return currentPrice;
                }

                public void setCurrentPrice(double currentPrice) {
                    this.currentPrice = currentPrice;
                }

                public double getFreight() {
                    return freight;
                }

                public void setFreight(int freight) {
                    this.freight = freight;
                }

                public String getPriceDesc() {
                    return priceDesc;
                }

                public void setPriceDesc(String priceDesc) {
                    this.priceDesc = priceDesc;
                }

                public String getParentClassify() {
                    return parentClassify;
                }

                public void setParentClassify(String parentClassify) {
                    this.parentClassify = parentClassify;
                }

                public String getParentClassifyText() {
                    return parentClassifyText;
                }

                public void setParentClassifyText(String parentClassifyText) {
                    this.parentClassifyText = parentClassifyText;
                }

                public String getSecondClassify() {
                    return secondClassify;
                }

                public void setSecondClassify(String secondClassify) {
                    this.secondClassify = secondClassify;
                }

                public String getSecondClassifyText() {
                    return secondClassifyText;
                }

                public void setSecondClassifyText(String secondClassifyText) {
                    this.secondClassifyText = secondClassifyText;
                }

                public String getThirdClassify() {
                    return thirdClassify;
                }

                public void setThirdClassify(String thirdClassify) {
                    this.thirdClassify = thirdClassify;
                }

                public String getThirdClassifyText() {
                    return thirdClassifyText;
                }

                public void setThirdClassifyText(String thirdClassifyText) {
                    this.thirdClassifyText = thirdClassifyText;
                }

                public String getLontitude() {
                    return lontitude;
                }

                public void setLontitude(String lontitude) {
                    this.lontitude = lontitude;
                }

                public String getLatitude() {
                    return latitude;
                }

                public void setLatitude(String latitude) {
                    this.latitude = latitude;
                }

                public String getProvince() {
                    return province;
                }

                public void setProvince(String province) {
                    this.province = province;
                }

                public String getCity() {
                    return city;
                }

                public void setCity(String city) {
                    this.city = city;
                }

                public String getDistrict() {
                    return district;
                }

                public void setDistrict(String district) {
                    this.district = district;
                }

                public String getAddress() {
                    return address;
                }

                public void setAddress(String address) {
                    this.address = address;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getStatus() {
                    return status;
                }

                public void setStatus(String status) {
                    this.status = status;
                }

                public String getStatusText() {
                    return statusText;
                }

                public void setStatusText(String statusText) {
                    this.statusText = statusText;
                }

                public int getIsResolve() {
                    return isResolve;
                }

                public void setIsResolve(int isResolve) {
                    this.isResolve = isResolve;
                }

                public String getResolveDate() {
                    return resolveDate;
                }

                public void setResolveDate(String resolveDate) {
                    this.resolveDate = resolveDate;
                }

                public int getBrowseNumber() {
                    return browseNumber;
                }

                public void setBrowseNumber(int browseNumber) {
                    this.browseNumber = browseNumber;
                }

                public int getReplyNumber() {
                    return replyNumber;
                }

                public void setReplyNumber(int replyNumber) {
                    this.replyNumber = replyNumber;
                }

                public int getShareNumber() {
                    return shareNumber;
                }

                public void setShareNumber(int shareNumber) {
                    this.shareNumber = shareNumber;
                }

                public int getIsRecommoned() {
                    return isRecommoned;
                }

                public void setIsRecommoned(int isRecommoned) {
                    this.isRecommoned = isRecommoned;
                }

                public String getPublicDate() {
                    return publicDate;
                }

                public void setPublicDate(String publicDate) {
                    this.publicDate = publicDate;
                }

                public PublicUserEntity getPublicUser() {
                    return publicUser;
                }

                public void setPublicUser(PublicUserEntity publicUser) {
                    this.publicUser = publicUser;
                }

                public int getIsCollect() {
                    return isCollect;
                }

                public void setIsCollect(int isCollect) {
                    this.isCollect = isCollect;
                }

                public int getIsSpot() {
                    return isSpot;
                }

                public void setIsSpot(int isSpot) {
                    this.isSpot = isSpot;
                }

                public static class PublicUserEntity implements Parcelable {
                    private int id;
                    private int mbpUserId;
                    private String loginAccount;
                    private String nickName;
                    private int sex;
                    private int province;
                    private String provinceText;
                    private int city;
                    private String cityText;
                    private String introduce;
                    private String userImg;
                    private String imgWidth;
                    private String imgHeight;
                    private int userLevel;
                    private String appVersion;
                    private String device;
                    private String deviceImei;
                    private String imUserId;

                    public String getImUserId() {
                        return imUserId;
                    }

                    public void setImUserId(String imUserId) {
                        this.imUserId = imUserId;
                    }

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public int getMbpUserId() {
                        return mbpUserId;
                    }

                    public void setMbpUserId(int mbpUserId) {
                        this.mbpUserId = mbpUserId;
                    }

                    public String getLoginAccount() {
                        return loginAccount;
                    }

                    public void setLoginAccount(String loginAccount) {
                        this.loginAccount = loginAccount;
                    }

                    public String getNickName() {
                        return nickName;
                    }

                    public void setNickName(String nickName) {
                        this.nickName = nickName;
                    }

                    public int getSex() {
                        return sex;
                    }

                    public void setSex(int sex) {
                        this.sex = sex;
                    }

                    public int getProvince() {
                        return province;
                    }

                    public void setProvince(int province) {
                        this.province = province;
                    }

                    public String getProvinceText() {
                        return provinceText;
                    }

                    public void setProvinceText(String provinceText) {
                        this.provinceText = provinceText;
                    }

                    public int getCity() {
                        return city;
                    }

                    public void setCity(int city) {
                        this.city = city;
                    }

                    public String getCityText() {
                        return cityText;
                    }

                    public void setCityText(String cityText) {
                        this.cityText = cityText;
                    }

                    public String getIntroduce() {
                        return introduce;
                    }

                    public void setIntroduce(String introduce) {
                        this.introduce = introduce;
                    }

                    public String getUserImg() {
                        return userImg;
                    }

                    public void setUserImg(String userImg) {
                        this.userImg = userImg;
                    }

                    public String getImgWidth() {
                        return imgWidth;
                    }

                    public void setImgWidth(String imgWidth) {
                        this.imgWidth = imgWidth;
                    }

                    public String getImgHeight() {
                        return imgHeight;
                    }

                    public void setImgHeight(String imgHeight) {
                        this.imgHeight = imgHeight;
                    }

                    public int getUserLevel() {
                        return userLevel;
                    }

                    public void setUserLevel(int userLevel) {
                        this.userLevel = userLevel;
                    }

                    public String getAppVersion() {
                        return appVersion;
                    }

                    public void setAppVersion(String appVersion) {
                        this.appVersion = appVersion;
                    }

                    public String getDevice() {
                        return device;
                    }

                    public void setDevice(String device) {
                        this.device = device;
                    }

                    public String getDeviceImei() {
                        return deviceImei;
                    }

                    public void setDeviceImei(String deviceImei) {
                        this.deviceImei = deviceImei;
                    }

                    @Override
                    public int describeContents() {
                        return 0;
                    }

                    @Override
                    public void writeToParcel(Parcel dest, int flags) {
                        dest.writeInt(this.id);
                        dest.writeInt(this.mbpUserId);
                        dest.writeString(this.loginAccount);
                        dest.writeString(this.nickName);
                        dest.writeInt(this.sex);
                        dest.writeInt(this.province);
                        dest.writeString(this.provinceText);
                        dest.writeInt(this.city);
                        dest.writeString(this.cityText);
                        dest.writeString(this.introduce);
                        dest.writeString(this.userImg);
                        dest.writeString(this.imgWidth);
                        dest.writeString(this.imgHeight);
                        dest.writeInt(this.userLevel);
                        dest.writeString(this.appVersion);
                        dest.writeString(this.device);
                        dest.writeString(this.deviceImei);
                        dest.writeString(this.imUserId);
                    }

                    public PublicUserEntity() {
                    }

                    protected PublicUserEntity(Parcel in) {
                        this.id = in.readInt();
                        this.mbpUserId = in.readInt();
                        this.loginAccount = in.readString();
                        this.nickName = in.readString();
                        this.sex = in.readInt();
                        this.province = in.readInt();
                        this.provinceText = in.readString();
                        this.city = in.readInt();
                        this.cityText = in.readString();
                        this.introduce = in.readString();
                        this.userImg = in.readString();
                        this.imgWidth = in.readString();
                        this.imgHeight = in.readString();
                        this.userLevel = in.readInt();
                        this.appVersion = in.readString();
                        this.device = in.readString();
                        this.deviceImei = in.readString();
                        this.imUserId = in.readString();
                    }

                    public static final Parcelable.Creator<PublicUserEntity> CREATOR = new Parcelable.Creator<PublicUserEntity>() {
                        @Override
                        public PublicUserEntity createFromParcel(Parcel source) {
                            return new PublicUserEntity(source);
                        }

                        @Override
                        public PublicUserEntity[] newArray(int size) {
                            return new PublicUserEntity[size];
                        }
                    };
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.id);
                    dest.writeString(this.title);
                    dest.writeString(this.introduce);
                    dest.writeString(this.content);
                    dest.writeDouble(this.originalPrice);
                    dest.writeDouble(this.currentPrice);
                    dest.writeDouble(this.freight);
                    dest.writeString(this.priceDesc);
                    dest.writeString(this.parentClassify);
                    dest.writeString(this.parentClassifyText);
                    dest.writeString(this.secondClassify);
                    dest.writeString(this.secondClassifyText);
                    dest.writeString(this.thirdClassify);
                    dest.writeString(this.thirdClassifyText);
                    dest.writeString(this.lontitude);
                    dest.writeString(this.latitude);
                    dest.writeString(this.province);
                    dest.writeString(this.city);
                    dest.writeString(this.district);
                    dest.writeString(this.address);
                    dest.writeString(this.type);
                    dest.writeString(this.status);
                    dest.writeString(this.statusText);
                    dest.writeInt(this.isResolve);
                    dest.writeString(this.resolveDate);
                    dest.writeInt(this.browseNumber);
                    dest.writeInt(this.replyNumber);
                    dest.writeInt(this.shareNumber);
                    dest.writeInt(this.isRecommoned);
                    dest.writeString(this.publicDate);
                    dest.writeTypedList(this.productImageList);
                    dest.writeParcelable(this.publicUser, flags);
                    dest.writeInt(this.isCollect);
                    dest.writeInt(this.isSpot);
                }

                public ProductEntity() {
                }

                protected ProductEntity(Parcel in) {
                    this.id = in.readInt();
                    this.title = in.readString();
                    this.introduce = in.readString();
                    this.content = in.readString();
                    this.originalPrice = in.readDouble();
                    this.currentPrice = in.readDouble();
                    this.freight = in.readDouble();
                    this.priceDesc = in.readString();
                    this.parentClassify = in.readString();
                    this.parentClassifyText = in.readString();
                    this.secondClassify = in.readString();
                    this.secondClassifyText = in.readString();
                    this.thirdClassify = in.readString();
                    this.thirdClassifyText = in.readString();
                    this.lontitude = in.readString();
                    this.latitude = in.readString();
                    this.province = in.readString();
                    this.city = in.readString();
                    this.district = in.readString();
                    this.address = in.readString();
                    this.type = in.readString();
                    this.status = in.readString();
                    this.statusText = in.readString();
                    this.isResolve = in.readInt();
                    this.resolveDate = in.readString();
                    this.browseNumber = in.readInt();
                    this.replyNumber = in.readInt();
                    this.shareNumber = in.readInt();
                    this.isRecommoned = in.readInt();
                    this.publicDate = in.readString();
                    this.productImageList = in.createTypedArrayList(ProductImageListEntity.CREATOR);
                    this.publicUser = in.readParcelable(PublicUserEntity.class.getClassLoader());
                    this.isCollect = in.readInt();
                    this.isSpot = in.readInt();
                }

                public static final Creator<ProductEntity> CREATOR = new Creator<ProductEntity>() {
                    @Override
                    public ProductEntity createFromParcel(Parcel source) {
                        return new ProductEntity(source);
                    }

                    @Override
                    public ProductEntity[] newArray(int size) {
                        return new ProductEntity[size];
                    }
                };
            }

            public static class ProductImageListEntity implements Parcelable {
                private String imageHeight;
                private String location;
                private String imageWidth;
                private String businessNumber;

                public String getBusinessNumber() {
                    return businessNumber;
                }

                public void setBusinessNumber(String businessNumber) {
                    this.businessNumber = businessNumber;
                }

                public String getImageHeight() {
                    return imageHeight;
                }

                public void setImageHeight(String imageHeight) {
                    this.imageHeight = imageHeight;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public String getImageWidth() {
                    return imageWidth;
                }

                public void setImageWidth(String imageWidth) {
                    this.imageWidth = imageWidth;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeString(this.imageHeight);
                    dest.writeString(this.location);
                    dest.writeString(this.imageWidth);
                    dest.writeString(this.businessNumber);
                }

                public ProductImageListEntity() {
                }

                protected ProductImageListEntity(Parcel in) {
                    this.imageHeight = in.readString();
                    this.location = in.readString();
                    this.imageWidth = in.readString();
                    this.businessNumber = in.readString();
                }

                public static final Parcelable.Creator<ProductImageListEntity> CREATOR = new Parcelable.Creator<ProductImageListEntity>() {
                    @Override
                    public ProductImageListEntity createFromParcel(Parcel source) {
                        return new ProductImageListEntity(source);
                    }

                    @Override
                    public ProductImageListEntity[] newArray(int size) {
                        return new ProductImageListEntity[size];
                    }
                };
            }

            public static class BuyUserEntity implements Parcelable {
                private int id;
                private int mbpUserId;
                private String loginAccount;
                private String nickName;
                private int sex;
                private int province;
                private String provinceText;
                private int city;
                private String cityText;
                private String introduce;
                private String userImg;
                private int imgWidth;
                private int imgHeight;
                private int userLevel;
                private String appVersion;
                private String device;
                private String deviceImei;
                private String imUserId;

                public String getImUserId() {
                    return imUserId;
                }

                public void setImUserId(String imUserId) {
                    this.imUserId = imUserId;
                }

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getMbpUserId() {
                    return mbpUserId;
                }

                public void setMbpUserId(int mbpUserId) {
                    this.mbpUserId = mbpUserId;
                }

                public String getLoginAccount() {
                    return loginAccount;
                }

                public void setLoginAccount(String loginAccount) {
                    this.loginAccount = loginAccount;
                }

                public String getNickName() {
                    return nickName;
                }

                public void setNickName(String nickName) {
                    this.nickName = nickName;
                }

                public int getSex() {
                    return sex;
                }

                public void setSex(int sex) {
                    this.sex = sex;
                }

                public int getProvince() {
                    return province;
                }

                public void setProvince(int province) {
                    this.province = province;
                }

                public String getProvinceText() {
                    return provinceText;
                }

                public void setProvinceText(String provinceText) {
                    this.provinceText = provinceText;
                }

                public int getCity() {
                    return city;
                }

                public void setCity(int city) {
                    this.city = city;
                }

                public String getCityText() {
                    return cityText;
                }

                public void setCityText(String cityText) {
                    this.cityText = cityText;
                }

                public String getIntroduce() {
                    return introduce;
                }

                public void setIntroduce(String introduce) {
                    this.introduce = introduce;
                }

                public String getUserImg() {
                    return userImg;
                }

                public void setUserImg(String userImg) {
                    this.userImg = userImg;
                }

                public int getImgWidth() {
                    return imgWidth;
                }

                public void setImgWidth(int imgWidth) {
                    this.imgWidth = imgWidth;
                }

                public int getImgHeight() {
                    return imgHeight;
                }

                public void setImgHeight(int imgHeight) {
                    this.imgHeight = imgHeight;
                }

                public int getUserLevel() {
                    return userLevel;
                }

                public void setUserLevel(int userLevel) {
                    this.userLevel = userLevel;
                }

                public String getAppVersion() {
                    return appVersion;
                }

                public void setAppVersion(String appVersion) {
                    this.appVersion = appVersion;
                }

                public String getDevice() {
                    return device;
                }

                public void setDevice(String device) {
                    this.device = device;
                }

                public String getDeviceImei() {
                    return deviceImei;
                }

                public void setDeviceImei(String deviceImei) {
                    this.deviceImei = deviceImei;
                }

                @Override
                public int describeContents() {
                    return 0;
                }

                @Override
                public void writeToParcel(Parcel dest, int flags) {
                    dest.writeInt(this.id);
                    dest.writeInt(this.mbpUserId);
                    dest.writeString(this.loginAccount);
                    dest.writeString(this.nickName);
                    dest.writeInt(this.sex);
                    dest.writeInt(this.province);
                    dest.writeString(this.provinceText);
                    dest.writeInt(this.city);
                    dest.writeString(this.cityText);
                    dest.writeString(this.introduce);
                    dest.writeString(this.userImg);
                    dest.writeInt(this.imgWidth);
                    dest.writeInt(this.imgHeight);
                    dest.writeInt(this.userLevel);
                    dest.writeString(this.appVersion);
                    dest.writeString(this.device);
                    dest.writeString(this.deviceImei);
                    dest.writeString(this.imUserId);
                }

                public BuyUserEntity() {
                }

                protected BuyUserEntity(Parcel in) {
                    this.id = in.readInt();
                    this.mbpUserId = in.readInt();
                    this.loginAccount = in.readString();
                    this.nickName = in.readString();
                    this.sex = in.readInt();
                    this.province = in.readInt();
                    this.provinceText = in.readString();
                    this.city = in.readInt();
                    this.cityText = in.readString();
                    this.introduce = in.readString();
                    this.userImg = in.readString();
                    this.imgWidth = in.readInt();
                    this.imgHeight = in.readInt();
                    this.userLevel = in.readInt();
                    this.appVersion = in.readString();
                    this.device = in.readString();
                    this.deviceImei = in.readString();
                    this.imUserId = in.readString();
                }

                public static final Parcelable.Creator<BuyUserEntity> CREATOR = new Parcelable.Creator<BuyUserEntity>() {
                    @Override
                    public BuyUserEntity createFromParcel(Parcel source) {
                        return new BuyUserEntity(source);
                    }

                    @Override
                    public BuyUserEntity[] newArray(int size) {
                        return new BuyUserEntity[size];
                    }
                };
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeParcelable(this.product, flags);
                dest.writeParcelable(this.buyUser, flags);
                dest.writeString(this.status);
                dest.writeString(this.statusName);
                dest.writeString(this.orderCode);
                dest.writeString(this.phone);
                dest.writeDouble(this.price);
                dest.writeString(this.payDate);
                dest.writeDouble(this.freight);
                dest.writeString(this.express);
                dest.writeString(this.expressNum);
                dest.writeString(this.receiveName);
                dest.writeString(this.receivePhone);
                dest.writeString(this.postCode);
                dest.writeString(this.address);
                dest.writeString(this.cancelDate);
                dest.writeString(this.cancelReason);
                dest.writeString(this.refundStatus);
                dest.writeString(this.refundStatusName);
                dest.writeString(this.refundDate);
                dest.writeString(this.refundServer);
                dest.writeString(this.refundReason);
                dest.writeString(this.refundMark);
                dest.writeString(this.refundExpress);
                dest.writeString(this.refundExpressNum);
                dest.writeString(this.rejectDate);
                dest.writeString(this.rejectReason);
                dest.writeString(this.createDate);
                dest.writeString(this.process);
            }

            public ContentEntity() {
            }

            protected ContentEntity(Parcel in) {
                this.id = in.readInt();
                this.product = in.readParcelable(ProductEntity.class.getClassLoader());
                this.buyUser = in.readParcelable(BuyUserEntity.class.getClassLoader());
                this.status = in.readString();
                this.statusName = in.readString();
                this.orderCode = in.readString();
                this.phone = in.readString();
                this.price = in.readDouble();
                this.payDate = in.readString();
                this.freight = in.readDouble();
                this.express = in.readString();
                this.expressNum = in.readString();
                this.receiveName = in.readString();
                this.receivePhone = in.readString();
                this.postCode = in.readString();
                this.address = in.readString();
                this.cancelDate = in.readString();
                this.cancelReason = in.readString();
                this.refundStatus = in.readString();
                this.refundStatusName = in.readString();
                this.refundDate = in.readString();
                this.refundServer = in.readString();
                this.refundReason = in.readString();
                this.refundMark = in.readString();
                this.refundExpress = in.readString();
                this.refundExpressNum = in.readString();
                this.rejectDate = in.readString();
                this.rejectReason = in.readString();
                this.createDate = in.readString();
                this.process = in.readString();
            }

            public static final Parcelable.Creator<ContentEntity> CREATOR = new Parcelable.Creator<ContentEntity>() {
                @Override
                public ContentEntity createFromParcel(Parcel source) {
                    return new ContentEntity(source);
                }

                @Override
                public ContentEntity[] newArray(int size) {
                    return new ContentEntity[size];
                }
            };
        }
    }
}
