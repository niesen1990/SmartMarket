package com.cmbb.smartmarket.activity.user.model;

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
public class MarketOrderDetailResponseModel {

    /**
     * id : 99
     * product : {"id":159,"title":"Meizu","introduce":"","content":"Android测试","originalPrice":6.01,"currentPrice":0.01,"freight":0.02,"priceDesc":"","parentClassify":"","parentClassifyText":"","secondClassify":"","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","locationId":1,"type":"","status":"","statusText":"","isResolve":1,"resolveDate":"","browseNumber":1,"replyNumber":1,"shareNumber":1,"isRecommoned":1,"publicDate":"2016-05-30 16:46:16","publicUserId":5,"publicUser":{"id":5,"mbpUserId":101033,"imUserId":"13818155072","loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"?????","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-19/NTE1NTA1ODItYjRhYS00MGE3LWFkNWEtZGZlYTYxYjI0ZjFl","imgWidth":512,"imgHeight":512,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"productImageList":[{"imageHeight":640,"businessNumber":"8a7c7f475500d51f015500d7639b0001","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-30/ZWQ1MWE3MzEtZjQzNy00ZTAyLWIyYTgtOWFjMzNjYzRmZjU2","imageWidth":1138}],"isCollect":1,"isSpot":1}
     * buyUser : {"id":6,"mbpUserId":100768,"imUserId":"15201921714","loginAccount":"15201921714","nickName":"库里","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2016-1-25/image_08d10846139348919717a107c73c16ae","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}
     * status : EVALUATED
     * statusName : 已评价
     * orderCode : 0015998468711915
     * phone : 15201921714
     * price : 0.01
     * payDate : 2016-05-30 16:46:32
     * freight : 0.0
     * express : shentong
     * expressNum : 1346464949797
     * receiveName : 聂森
     * receivePhone : 1520192171
     * postCode : 224021
     * address : 河北省石家庄市长安区测试
     * cancelDate :
     * cancelReason :
     * refundStatus :
     * refundStatusName :
     * refundDate :
     * refundServer :
     * refundReason :
     * refundMark :
     * refundExpress :
     * refundExpressNum :
     * rejectDate :
     * rejectReason :
     * createDate : 2016-05-30 16:46:25
     * process : [{"statusDate":"2016-05-30 16:46:25","statusName":"待付款","logistics":[{"date":"2016-01-08 10:53:00","info":"【郑州市】 河南省邮政速递物流有限公司郑州市同城揽投部已收件（揽投员姓名：张莲花,联系电话:）"}]}]
     */

    private DataEntity data;
    /**
     * data : {"id":99,"product":{"id":159,"title":"Meizu","introduce":"","content":"Android测试","originalPrice":6.01,"currentPrice":0.01,"freight":0.02,"priceDesc":"","parentClassify":"","parentClassifyText":"","secondClassify":"","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","locationId":1,"type":"","status":"","statusText":"","isResolve":1,"resolveDate":"","browseNumber":1,"replyNumber":1,"shareNumber":1,"isRecommoned":1,"publicDate":"2016-05-30 16:46:16","publicUserId":5,"publicUser":{"id":5,"mbpUserId":101033,"imUserId":"13818155072","loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"?????","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-19/NTE1NTA1ODItYjRhYS00MGE3LWFkNWEtZGZlYTYxYjI0ZjFl","imgWidth":512,"imgHeight":512,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"productImageList":[{"imageHeight":640,"businessNumber":"8a7c7f475500d51f015500d7639b0001","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-30/ZWQ1MWE3MzEtZjQzNy00ZTAyLWIyYTgtOWFjMzNjYzRmZjU2","imageWidth":1138}],"isCollect":1,"isSpot":1},"buyUser":{"id":6,"mbpUserId":100768,"imUserId":"15201921714","loginAccount":"15201921714","nickName":"库里","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2016-1-25/image_08d10846139348919717a107c73c16ae","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"status":"EVALUATED","statusName":"已评价","orderCode":"0015998468711915","phone":"15201921714","price":0.01,"payDate":"2016-05-30 16:46:32","freight":0,"express":"shentong","expressNum":"1346464949797","receiveName":"聂森","receivePhone":"1520192171","postCode":"224021","address":"河北省石家庄市长安区测试","cancelDate":"","cancelReason":"","refundStatus":"","refundStatusName":"","refundDate":"","refundServer":"","refundReason":"","refundMark":"","refundExpress":"","refundExpressNum":"","rejectDate":"","rejectReason":"","createDate":"2016-05-30 16:46:25","process":[{"statusDate":"2016-05-30 16:46:25","statusName":"待付款","logistics":[{"date":"2016-01-08 10:53:00","info":"【郑州市】 河南省邮政速递物流有限公司郑州市同城揽投部已收件（揽投员姓名：张莲花,联系电话:）"}]}]}
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
        private int id;
        /**
         * id : 159
         * title : Meizu
         * introduce :
         * content : Android测试
         * originalPrice : 6.01
         * currentPrice : 0.01
         * freight : 0.02
         * priceDesc :
         * parentClassify :
         * parentClassifyText :
         * secondClassify :
         * secondClassifyText :
         * thirdClassify :
         * thirdClassifyText :
         * locationId : 1
         * type :
         * status :
         * statusText :
         * isResolve : 1
         * resolveDate :
         * browseNumber : 1
         * replyNumber : 1
         * shareNumber : 1
         * isRecommoned : 1
         * publicDate : 2016-05-30 16:46:16
         * publicUserId : 5
         * publicUser : {"id":5,"mbpUserId":101033,"imUserId":"13818155072","loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"?????","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-19/NTE1NTA1ODItYjRhYS00MGE3LWFkNWEtZGZlYTYxYjI0ZjFl","imgWidth":512,"imgHeight":512,"userLevel":0,"appVersion":"","device":"","deviceImei":""}
         * productImageList : [{"imageHeight":640,"businessNumber":"8a7c7f475500d51f015500d7639b0001","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-30/ZWQ1MWE3MzEtZjQzNy00ZTAyLWIyYTgtOWFjMzNjYzRmZjU2","imageWidth":1138}]
         * isCollect : 1
         * isSpot : 1
         */

        private ProductEntity product;
        /**
         * id : 6
         * mbpUserId : 100768
         * imUserId : 15201921714
         * loginAccount : 15201921714
         * nickName : 库里
         * sex : 1
         * province :
         * provinceText :
         * city :
         * cityText :
         * introduce :
         * userImg : http://smart.image.alimmdn.com/app/test/2016-1-25/image_08d10846139348919717a107c73c16ae
         * imgWidth :
         * imgHeight :
         * userLevel : 0
         * appVersion :
         * device :
         * deviceImei :
         */

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
        /**
         * statusDate : 2016-05-30 16:46:25
         * statusName : 待付款
         * logistics : [{"date":"2016-01-08 10:53:00","info":"【郑州市】 河南省邮政速递物流有限公司郑州市同城揽投部已收件（揽投员姓名：张莲花,联系电话:）"}]
         */

        private List<ProcessEntity> process;

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

        public static class ProductEntity {
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
            /**
             * id : 5
             * mbpUserId : 101033
             * imUserId : 13818155072
             * loginAccount : 13818155072
             * nickName : 共产党
             * sex : 1
             * province :
             * provinceText :
             * city :
             * cityText :
             * introduce : ?????
             * userImg : http://smart-test.image.alimmdn.com/market/user/image/2016-05-19/NTE1NTA1ODItYjRhYS00MGE3LWFkNWEtZGZlYTYxYjI0ZjFl
             * imgWidth : 512
             * imgHeight : 512
             * userLevel : 0
             * appVersion :
             * device :
             * deviceImei :
             */

            private PublicUserEntity publicUser;
            private int isCollect;
            private int isSpot;
            /**
             * imageHeight : 640
             * businessNumber : 8a7c7f475500d51f015500d7639b0001
             * location : http://smart-test.image.alimmdn.com/market/product/image/2016-05-30/ZWQ1MWE3MzEtZjQzNy00ZTAyLWIyYTgtOWFjMzNjYzRmZjU2
             * imageWidth : 1138
             */

            private List<ProductImageListEntity> productImageList;

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

            public List<ProductImageListEntity> getProductImageList() {
                return productImageList;
            }

            public void setProductImageList(List<ProductImageListEntity> productImageList) {
                this.productImageList = productImageList;
            }

            public static class PublicUserEntity {
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
                private int imgWidth;
                private int imgHeight;
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
            }

            public static class ProductImageListEntity {
                private int imageHeight;
                private String businessNumber;
                private String location;
                private int imageWidth;

                public int getImageHeight() {
                    return imageHeight;
                }

                public void setImageHeight(int imageHeight) {
                    this.imageHeight = imageHeight;
                }

                public String getBusinessNumber() {
                    return businessNumber;
                }

                public void setBusinessNumber(String businessNumber) {
                    this.businessNumber = businessNumber;
                }

                public String getLocation() {
                    return location;
                }

                public void setLocation(String location) {
                    this.location = location;
                }

                public int getImageWidth() {
                    return imageWidth;
                }

                public void setImageWidth(int imageWidth) {
                    this.imageWidth = imageWidth;
                }
            }
        }

        public static class BuyUserEntity {
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
        }
        private List<LogisticsEntity> logistics;
        public List<LogisticsEntity> getLogistics() {
            return logistics;
        }

        public void setLogistics(List<LogisticsEntity> logistics) {
            this.logistics = logistics;
        }

        public static class LogisticsEntity {
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
        }
        public static class ProcessEntity {
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


        }
    }
}
