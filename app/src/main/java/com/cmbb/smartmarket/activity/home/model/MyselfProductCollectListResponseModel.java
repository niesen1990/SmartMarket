package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;
import com.cmbb.smartmarket.network.model.UserLocation;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 上午10:43
 * 修改人：N.Sun
 * 修改时间：16/5/25 上午10:43
 * 修改备注：
 */
public class MyselfProductCollectListResponseModel {

    /**
     * content : [{"id":56,"userId":6,"isDelete":0,"createDate":"2016-06-07 11:48:35","createUserId":6,"product":{"id":231,"title":"测试数据","introduce":"","content":"Android","originalPrice":9.02,"currentPrice":0.01,"freight":0.01,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"妈妈用品","secondClassify":"MMYP_XB","secondClassifyText":"鞋包","thirdClassify":"","thirdClassifyText":"","userLocation":{"id":153,"country":"中国","countryCode":"0","province":"上海市","city":"上海市","cityCode":"289","district":"杨浦区","street":"飞虹路","streetNumber":"568弄-13","address":"中国上海市杨浦区飞虹路568弄-13"},"productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":19,"replyNumber":1,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-06-06 16:11:09","publicUser":{"id":5,"mbpUserId":101033,"imUserId":"13818155072","loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"哈哈","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-06-03/ZTljYWI0YjUtYjhmYy00YTk4LTk3YWItYWI5ZTMzYmFhNGU5","imgWidth":512,"imgHeight":512,"userLevel":0,"appVersion":"hm_android_1.0.0","device":"ANDROID","deviceImei":"352514065726683"},"productImageList":[{"imageHeight":640,"businessNumber":"8a7c7f4755244eaa015524c3bdee0013","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-06-06/OWE3MzRkMzEtMmFlMi00NjZmLTkyZTktZTE1YTQ1NDlhMWY4","imageWidth":1138}],"isCollect":1,"isSpot":1}}]
     * totalElements : 1
     * totalPages : 1
     * last : true
     * size : 10
     * number : 0
     * first : true
     * sort :
     * numberOfElements : 1
     */

    private DataEntity data;
    /**
     * data : {"content":[{"id":56,"userId":6,"isDelete":0,"createDate":"2016-06-07 11:48:35","createUserId":6,"product":{"id":231,"title":"测试数据","introduce":"","content":"Android","originalPrice":9.02,"currentPrice":0.01,"freight":0.01,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"妈妈用品","secondClassify":"MMYP_XB","secondClassifyText":"鞋包","thirdClassify":"","thirdClassifyText":"","userLocation":{"id":153,"country":"中国","countryCode":"0","province":"上海市","city":"上海市","cityCode":"289","district":"杨浦区","street":"飞虹路","streetNumber":"568弄-13","address":"中国上海市杨浦区飞虹路568弄-13"},"productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":19,"replyNumber":1,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-06-06 16:11:09","publicUser":{"id":5,"mbpUserId":101033,"imUserId":"13818155072","loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"哈哈","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-06-03/ZTljYWI0YjUtYjhmYy00YTk4LTk3YWItYWI5ZTMzYmFhNGU5","imgWidth":512,"imgHeight":512,"userLevel":0,"appVersion":"hm_android_1.0.0","device":"ANDROID","deviceImei":"352514065726683"},"productImageList":[{"imageHeight":640,"businessNumber":"8a7c7f4755244eaa015524c3bdee0013","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-06-06/OWE3MzRkMzEtMmFlMi00NjZmLTkyZTktZTE1YTQ1NDlhMWY4","imageWidth":1138}],"isCollect":1,"isSpot":1}}],"totalElements":1,"totalPages":1,"last":true,"size":10,"number":0,"first":true,"sort":"","numberOfElements":1}
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
        private int totalElements;
        private int totalPages;
        private boolean last;
        private int size;
        private int number;
        private boolean first;
        private String sort;
        private int numberOfElements;
        /**
         * id : 56
         * userId : 6
         * isDelete : 0
         * createDate : 2016-06-07 11:48:35
         * createUserId : 6
         * product : {"id":231,"title":"测试数据","introduce":"","content":"Android","originalPrice":9.02,"currentPrice":0.01,"freight":0.01,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"妈妈用品","secondClassify":"MMYP_XB","secondClassifyText":"鞋包","thirdClassify":"","thirdClassifyText":"","userLocation":{"id":153,"country":"中国","countryCode":"0","province":"上海市","city":"上海市","cityCode":"289","district":"杨浦区","street":"飞虹路","streetNumber":"568弄-13","address":"中国上海市杨浦区飞虹路568弄-13"},"productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":19,"replyNumber":1,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-06-06 16:11:09","publicUser":{"id":5,"mbpUserId":101033,"imUserId":"13818155072","loginAccount":"13818155072","nickName":"共产党","sex":1,"province":"","provinceText":"","city":"","cityText":"","introduce":"哈哈","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-06-03/ZTljYWI0YjUtYjhmYy00YTk4LTk3YWItYWI5ZTMzYmFhNGU5","imgWidth":512,"imgHeight":512,"userLevel":0,"appVersion":"hm_android_1.0.0","device":"ANDROID","deviceImei":"352514065726683"},"productImageList":[{"imageHeight":640,"businessNumber":"8a7c7f4755244eaa015524c3bdee0013","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-06-06/OWE3MzRkMzEtMmFlMi00NjZmLTkyZTktZTE1YTQ1NDlhMWY4","imageWidth":1138}],"isCollect":1,"isSpot":1}
         */

        private List<ContentEntity> content;

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity {
            private int id;
            private int userId;
            private int isDelete;
            private String createDate;
            private int createUserId;

            private ProductEntity product;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public int getCreateUserId() {
                return createUserId;
            }

            public void setCreateUserId(int createUserId) {
                this.createUserId = createUserId;
            }

            public ProductEntity getProduct() {
                return product;
            }

            public void setProduct(ProductEntity product) {
                this.product = product;
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

                private UserLocation userLocation;
                private int productType;
                private int productStatus;
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
                 * imUserId : 13818155072
                 * loginAccount : 13818155072
                 * nickName : 共产党
                 * sex : 1
                 * province :
                 * provinceText :
                 * city :
                 * cityText :
                 * introduce : 哈哈
                 * userImg : http://smart-test.image.alimmdn.com/market/user/image/2016-06-03/ZTljYWI0YjUtYjhmYy00YTk4LTk3YWItYWI5ZTMzYmFhNGU5
                 * imgWidth : 512.0
                 * imgHeight : 512.0
                 * userLevel : 0
                 * appVersion : hm_android_1.0.0
                 * device : ANDROID
                 * deviceImei : 352514065726683
                 */

                private PublicUser publicUser;
                private int isCollect;
                private int isSpot;
                /**
                 * imageHeight : 640
                 * businessNumber : 8a7c7f4755244eaa015524c3bdee0013
                 * location : http://smart-test.image.alimmdn.com/market/product/image/2016-06-06/OWE3MzRkMzEtMmFlMi00NjZmLTkyZTktZTE1YTQ1NDlhMWY4
                 * imageWidth : 1138
                 */

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

                public UserLocation getUserLocation() {
                    return userLocation;
                }

                public void setUserLocation(UserLocation userLocation) {
                    this.userLocation = userLocation;
                }

                public int getProductType() {
                    return productType;
                }

                public void setProductType(int productType) {
                    this.productType = productType;
                }

                public int getProductStatus() {
                    return productStatus;
                }

                public void setProductStatus(int productStatus) {
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

                public static class UserLocationEntity {
                    private int id;
                    private String country;
                    private String countryCode;
                    private String province;
                    private String city;
                    private String cityCode;
                    private String district;
                    private String street;
                    private String streetNumber;
                    private String address;

                    public int getId() {
                        return id;
                    }

                    public void setId(int id) {
                        this.id = id;
                    }

                    public String getCountry() {
                        return country;
                    }

                    public void setCountry(String country) {
                        this.country = country;
                    }

                    public String getCountryCode() {
                        return countryCode;
                    }

                    public void setCountryCode(String countryCode) {
                        this.countryCode = countryCode;
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

                    public String getCityCode() {
                        return cityCode;
                    }

                    public void setCityCode(String cityCode) {
                        this.cityCode = cityCode;
                    }

                    public String getDistrict() {
                        return district;
                    }

                    public void setDistrict(String district) {
                        this.district = district;
                    }

                    public String getStreet() {
                        return street;
                    }

                    public void setStreet(String street) {
                        this.street = street;
                    }

                    public String getStreetNumber() {
                        return streetNumber;
                    }

                    public void setStreetNumber(String streetNumber) {
                        this.streetNumber = streetNumber;
                    }

                    public String getAddress() {
                        return address;
                    }

                    public void setAddress(String address) {
                        this.address = address;
                    }
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
                    private double imgWidth;
                    private double imgHeight;
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

                    public double getImgWidth() {
                        return imgWidth;
                    }

                    public void setImgWidth(double imgWidth) {
                        this.imgWidth = imgWidth;
                    }

                    public double getImgHeight() {
                        return imgHeight;
                    }

                    public void setImgHeight(double imgHeight) {
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
        }
    }
}
