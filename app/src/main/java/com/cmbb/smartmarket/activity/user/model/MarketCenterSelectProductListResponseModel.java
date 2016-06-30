package com.cmbb.smartmarket.activity.user.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 上午11:25
 * 修改人：N.Sun
 * 修改时间：16/5/25 上午11:25
 * 修改备注：
 */
public class MarketCenterSelectProductListResponseModel {

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

    public static class DataEntity {
        private int totalElements;
        private boolean last;
        private int totalPages;
        private int size;
        private int number;
        private boolean first;
        private String sort;
        private int numberOfElements;
        /**
         * id : 18
         * title : 优衣库7777
         * introduce :
         * content :
         * originalPrice : 500
         * currentPrice : 100
         * freight : 500.0
         * priceDesc :
         * parentClassify : MMYP
         * parentClassifyText :
         * secondClassify : MMYP_FZ
         * secondClassifyText :
         * thirdClassify :
         * thirdClassifyText :
         * lontitude :
         * latitude :
         * province :
         * city :
         * district :
         * address :
         * productType : 0
         * productStatus : 0
         * productStatusText : 上架
         * isResolve : 1
         * resolveDate :
         * browseNumber : 0
         * replyNumber : 0
         * shareNumber : 0
         * isRecommoned : 1
         * publicDate : 2016-05-16 15:44:47
         * publicUser :
         * productImageList : [{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-16/Yjc2YzNlMTYtYzJjYS00NGFmLWEwMzktNDhmNTJhNzEwNWI3","imageWidth":""}]
         * isCollect : 1
         * isSpot : 2
         */

        private List<ContentEntity> content;

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
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

            private UserLocationEntity userLocation;
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

            private boolean checked;

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            /**
             * id : 6
             * mbpUserId : 100768
             * imUserId : 15201921714
             * loginAccount : 15201921714
             * nickName : Dota2
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

            private PublicUserEntity publicUser;
            private int isCollect;
            private int isSpot;
            /**
             * imageHeight :
             * location : http://smart-test.image.alimmdn.com/market/product/image/2016-05-24/MDQ4YWQ2MmEtMWMxOC00OTVmLWI2MzEtMTZkMjBhMDBlOTQ3
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

            public UserLocationEntity getUserLocation() {
                return userLocation;
            }

            public void setUserLocation(UserLocationEntity userLocation) {
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

            public static class ProductImageListEntity {
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
            }
        }
    }
}
