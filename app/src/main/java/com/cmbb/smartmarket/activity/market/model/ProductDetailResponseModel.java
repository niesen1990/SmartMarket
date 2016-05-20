package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午9:51
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午9:51
 * 修改备注：
 */
public class ProductDetailResponseModel {

    /**
     * id : 52
     * title : 很重要
     * introduce :
     * content : 经济
     * originalPrice : 6.0
     * currentPrice : 6.0
     * freight : 6.0
     * priceDesc :
     * parentClassify : JJYP
     * parentClassifyText :
     * secondClassify :
     * secondClassifyText :
     * thirdClassify :
     * thirdClassifyText :
     * lontitude :
     * latitude :
     * province :
     * city :
     * district :
     * address :
     * productType :
     * productStatus :
     * productStatusText :
     * isResolve : 1
     * resolveDate :
     * browseNumber : 8
     * replyNumber : 2
     * shareNumber : 0
     * isRecommoned : 1
     * publicDate : 2016-05-19 19:35:27
     * publicUser : {"id":5,"mbpUserId":101033,"loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"?????","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-16/YTk3MzI1MjgtZGM0NS00YmUwLTk1NTItNzMwMTk2ZDAwNjYx","imgWidth":2148,"imgHeight":2148,"userLevel":0,"appVersion":"","device":"","deviceImei":""}
     * productImageList : [{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj","imageWidth":""}]
     * isCollect : 0
     * isSpot : 1
     */

    private DataEntity data;
    /**
     * data : {"id":52,"title":"很重要","introduce":"","content":"经济","originalPrice":6,"currentPrice":6,"freight":6,"priceDesc":"","parentClassify":"JJYP","parentClassifyText":"","secondClassify":"","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","lontitude":"","latitude":"","province":"","city":"","district":"","address":"","productType":"","productStatus":"","productStatusText":"","isResolve":1,"resolveDate":"","browseNumber":8,"replyNumber":2,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-19 19:35:27","publicUser":{"id":5,"mbpUserId":101033,"loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"?????","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-16/YTk3MzI1MjgtZGM0NS00YmUwLTk1NTItNzMwMTk2ZDAwNjYx","imgWidth":2148,"imgHeight":2148,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"productImageList":[{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj","imageWidth":""}],"isCollect":0,"isSpot":1}
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
        private String productType;
        private String productStatus;
        private String productStatusText;
        private int isResolve;
        private String resolveDate;
        private int browseNumber;
        private int replyNumber;
        private int shareNumber;
        private int isRecommoned;
        private String publicDate;
        /**
         * id : 5
         * mbpUserId : 101033
         * loginAccount : 13818155072
         * nickName : 共产党
         * sex : 1
         * province :
         * provinceText :
         * city :
         * cityText :
         * introduce : ?????
         * userImg : http://smart-test.image.alimmdn.com/market/user/image/2016-05-16/YTk3MzI1MjgtZGM0NS00YmUwLTk1NTItNzMwMTk2ZDAwNjYx
         * imgWidth : 2148
         * imgHeight : 2148
         * userLevel : 0
         * appVersion :
         * device :
         * deviceImei :
         */

        private PublicUserEntity publicUser;
        private int isCollect;
        private int isSpot;
        /**
         * imageHeight :
         * location : http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj
         * imageWidth :
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

        public String getProductType() {
            return productType;
        }

        public void setProductType(String productType) {
            this.productType = productType;
        }

        public String getProductStatus() {
            return productStatus;
        }

        public void setProductStatus(String productStatus) {
            this.productStatus = productStatus;
        }

        public String getProductStatusText() {
            return productStatusText;
        }

        public void setProductStatusText(String productStatusText) {
            this.productStatusText = productStatusText;
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

        public List<ProductImageListEntity> getProductImageList() {
            return productImageList;
        }

        public void setProductImageList(List<ProductImageListEntity> productImageList) {
            this.productImageList = productImageList;
        }

        public static class PublicUserEntity {
            private int id;
            private int mbpUserId;
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
            private String imageHeight;
            private String location;
            private String imageWidth;

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
        }
    }
}
