package com.cmbb.smartmarket.activity.user.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 下午1:31
 * 修改人：N.Sun
 * 修改时间：16/5/31 下午1:31
 * 修改备注：
 */
public class MarketOrderDetailResponseModel implements Parcelable {

    private DataEntity data;

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

    public static class DataEntity implements Parcelable {
        private int id;
        private ProductEntity product;
        private BuyUserEntity buyUser;
        private List<ProcessEntity> process;
        private List<LogisticsEntity> logistics;
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
        private String orderType;
        private String saleType;

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

        public String getRefundStatusName() {
            return refundStatusName;
        }

        public void setRefundStatusName(String refundStatusName) {
            this.refundStatusName = refundStatusName;
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
        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getSaleType() {
            return saleType;
        }

        public void setSaleType(String saleType) {
            this.saleType = saleType;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public List<ProcessEntity> getProcess() {
            return process;
        }

        public void setProcess(List<ProcessEntity> process) {
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
            private int locationId;
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
            private int publicUserId;
            private PublicUser publicUser;
            private int isCollect;
            private int isSpot;
            private List<ProductImageList> productImageList;

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

            public void setFreight(double freight) {
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

            public int getLocationId() {
                return locationId;
            }

            public void setLocationId(int locationId) {
                this.locationId = locationId;
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

            public int getPublicUserId() {
                return publicUserId;
            }

            public void setPublicUserId(int publicUserId) {
                this.publicUserId = publicUserId;
            }

            public PublicUser getPublicUser() {
                return publicUser;
            }

            public void setPublicUser(PublicUser publicUser) {
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

            public List<ProductImageList> getProductImageList() {
                return productImageList;
            }

            public void setProductImageList(List<ProductImageList> productImageList) {
                this.productImageList = productImageList;
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
                dest.writeInt(this.locationId);
                dest.writeString(this.type);
                dest.writeString(this.status);
                dest.writeString(this.statusText);
                dest.writeString(this.statusText);
                dest.writeInt(this.isResolve);
                dest.writeString(this.resolveDate);
                dest.writeInt(this.browseNumber);
                dest.writeInt(this.replyNumber);
                dest.writeInt(this.shareNumber);
                dest.writeInt(this.isRecommoned);
                dest.writeString(this.publicDate);
                dest.writeInt(this.publicUserId);
                dest.writeParcelable(this.publicUser, flags);
                dest.writeInt(this.isCollect);
                dest.writeInt(this.isSpot);
                dest.writeTypedList(this.productImageList);
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
                this.locationId = in.readInt();
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
                this.publicUserId = in.readInt();
                this.publicUser = in.readParcelable(PublicUser.class.getClassLoader());
                this.isCollect = in.readInt();
                this.isSpot = in.readInt();
                this.productImageList = in.createTypedArrayList(ProductImageList.CREATOR);
            }

            public static final Parcelable.Creator<ProductEntity> CREATOR = new Parcelable.Creator<ProductEntity>() {
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

        public static class BuyUserEntity implements Parcelable {
            private int id;
            private int mbpUserId;
            private String imUserId;
            private String loginAccount;
            private String nickName;
            private int sex;
            private String province;
            private String provinceText;
            private String city;
            private String cityText;
            private String introduce;
            private String userImg;
            private String imgWidth;
            private String imgHeight;
            private int userLevel;
            private String appVersion;
            private String device;
            private String deviceImei;

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

            public String getImUserId() {
                return imUserId;
            }

            public void setImUserId(String imUserId) {
                this.imUserId = imUserId;
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

            public String getProvince() {
                return province;
            }

            public void setProvince(String province) {
                this.province = province;
            }

            public String getProvinceText() {
                return provinceText;
            }

            public void setProvinceText(String provinceText) {
                this.provinceText = provinceText;
            }

            public String getCity() {
                return city;
            }

            public void setCity(String city) {
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
                dest.writeString(this.imUserId);
                dest.writeString(this.loginAccount);
                dest.writeString(this.nickName);
                dest.writeInt(this.sex);
                dest.writeString(this.province);
                dest.writeString(this.provinceText);
                dest.writeString(this.city);
                dest.writeString(this.cityText);
                dest.writeString(this.introduce);
                dest.writeString(this.userImg);
                dest.writeString(this.imgWidth);
                dest.writeString(this.imgHeight);
                dest.writeInt(this.userLevel);
                dest.writeString(this.appVersion);
                dest.writeString(this.device);
                dest.writeString(this.deviceImei);
            }

            public BuyUserEntity() {
            }

            protected BuyUserEntity(Parcel in) {
                this.id = in.readInt();
                this.mbpUserId = in.readInt();
                this.imUserId = in.readString();
                this.loginAccount = in.readString();
                this.nickName = in.readString();
                this.sex = in.readInt();
                this.province = in.readString();
                this.provinceText = in.readString();
                this.city = in.readString();
                this.cityText = in.readString();
                this.introduce = in.readString();
                this.userImg = in.readString();
                this.imgWidth = in.readString();
                this.imgHeight = in.readString();
                this.userLevel = in.readInt();
                this.appVersion = in.readString();
                this.device = in.readString();
                this.deviceImei = in.readString();
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



        public List<LogisticsEntity> getLogistics() {
            return logistics;
        }

        public void setLogistics(List<LogisticsEntity> logistics) {
            this.logistics = logistics;
        }

        public static class LogisticsEntity implements Parcelable {
            private String date;
            private String info;

            public String getDate() {
                return date;
            }

            public void setDate(String date) {
                this.date = date;
            }

            public String getInfo() {
                return info;
            }

            public void setInfo(String info) {
                this.info = info;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.date);
                dest.writeString(this.info);
            }

            public LogisticsEntity() {
            }

            protected LogisticsEntity(Parcel in) {
                this.date = in.readString();
                this.info = in.readString();
            }

            public static final Parcelable.Creator<LogisticsEntity> CREATOR = new Parcelable.Creator<LogisticsEntity>() {
                @Override
                public LogisticsEntity createFromParcel(Parcel source) {
                    return new LogisticsEntity(source);
                }

                @Override
                public LogisticsEntity[] newArray(int size) {
                    return new LogisticsEntity[size];
                }
            };
        }

        public static class ProcessEntity implements Parcelable {
            private String statusDate;
            private String statusName;

            /**
             * date : 2016-01-08 10:53:00
             * info : 【郑州市】 河南省邮政速递物流有限公司郑州市同城揽投部已收件（揽投员姓名：张莲花,联系电话:）
             */

            public String getStatusDate() {
                return statusDate;
            }

            public void setStatusDate(String statusDate) {
                this.statusDate = statusDate;
            }

            public String getStatusName() {
                return statusName;
            }

            public void setStatusName(String statusName) {
                this.statusName = statusName;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeString(this.statusDate);
                dest.writeString(this.statusName);
            }

            public ProcessEntity() {
            }

            protected ProcessEntity(Parcel in) {
                this.statusDate = in.readString();
                this.statusName = in.readString();
            }

            public static final Parcelable.Creator<ProcessEntity> CREATOR = new Parcelable.Creator<ProcessEntity>() {
                @Override
                public ProcessEntity createFromParcel(Parcel source) {
                    return new ProcessEntity(source);
                }

                @Override
                public ProcessEntity[] newArray(int size) {
                    return new ProcessEntity[size];
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
            dest.writeString(this.orderType);
            dest.writeString(this.saleType);
            dest.writeString(this.rejectReason);
            dest.writeString(this.createDate);
            dest.writeTypedList(this.process);
            dest.writeTypedList(this.logistics);
        }

        public DataEntity() {
        }

        protected DataEntity(Parcel in) {
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
            this.orderType = in.readString();
            this.saleType = in.readString();
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
            this.process = in.createTypedArrayList(ProcessEntity.CREATOR);
            this.logistics = in.createTypedArrayList(LogisticsEntity.CREATOR);
        }

        public static final Parcelable.Creator<DataEntity> CREATOR = new Parcelable.Creator<DataEntity>() {
            @Override
            public DataEntity createFromParcel(Parcel source) {
                return new DataEntity(source);
            }

            @Override
            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeParcelable(this.data, flags);
        dest.writeString(this.msg);
    }

    public MarketOrderDetailResponseModel() {
    }

    protected MarketOrderDetailResponseModel(Parcel in) {
        this.data = in.readParcelable(DataEntity.class.getClassLoader());
        this.msg = in.readString();
    }

    public static final Parcelable.Creator<MarketOrderDetailResponseModel> CREATOR = new Parcelable.Creator<MarketOrderDetailResponseModel>() {
        @Override
        public MarketOrderDetailResponseModel createFromParcel(Parcel source) {
            return new MarketOrderDetailResponseModel(source);
        }

        @Override
        public MarketOrderDetailResponseModel[] newArray(int size) {
            return new MarketOrderDetailResponseModel[size];
        }
    };
}
