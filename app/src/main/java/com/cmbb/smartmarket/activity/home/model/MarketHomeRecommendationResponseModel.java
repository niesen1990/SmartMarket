package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/1 下午1:19
 * 修改人：N.Sun
 * 修改时间：16/6/1 下午1:19
 * 修改备注：
 */
public class MarketHomeRecommendationResponseModel {

    /**
     * content : [{"id":83,"title":"测试数据","introduce":"","content":"魅族手机","originalPrice":6.01,"currentPrice":0.01,"freight":0.01,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"妈妈用品","secondClassify":"MMYP_PS","secondClassifyText":"配饰","thirdClassify":"","thirdClassifyText":"","userLocation":{"id":7,"country":"中国","countryCode":"0","province":"上海市","city":"上海市","cityCode":"289","district":"杨浦区","street":"飞虹路","streetNumber":"568弄-20","address":"中国上海市杨浦区飞虹路568弄-20"},"productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":63,"replyNumber":5,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-24 15:32:04","publicUser":{"id":6,"mbpUserId":100768,"imUserId":"15201921714","loginAccount":"15201921714","nickName":"库里","sex":null,"province":"","provinceText":"","city":"","cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2016-1-25/image_08d10846139348919717a107c73c16ae","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"productImageList":[{"imageHeight":"","businessNumber":"4028e4ed54e78a600154e78a75910128","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-24/MDQ4YWQ2MmEtMWMxOC00OTVmLWI2MzEtMTZkMjBhMDBlOTQ3","imageWidth":""}],"isCollect":1,"isSpot":1}]
     * last : true
     * totalElements : 1
     * totalPages : 1
     * number : 0
     * size : 5
     * numberOfElements : 1
     * first : true
     */

    private DataEntity data;
    /**
     * data : {"content":[{"id":83,"title":"测试数据","introduce":"","content":"魅族手机","originalPrice":6.01,"currentPrice":0.01,"freight":0.01,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"妈妈用品","secondClassify":"MMYP_PS","secondClassifyText":"配饰","thirdClassify":"","thirdClassifyText":"","userLocation":{"id":7,"country":"中国","countryCode":"0","province":"上海市","city":"上海市","cityCode":"289","district":"杨浦区","street":"飞虹路","streetNumber":"568弄-20","address":"中国上海市杨浦区飞虹路568弄-20"},"productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":63,"replyNumber":5,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-24 15:32:04","publicUser":{"id":6,"mbpUserId":100768,"imUserId":"15201921714","loginAccount":"15201921714","nickName":"库里","sex":null,"province":"","provinceText":"","city":"","cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2016-1-25/image_08d10846139348919717a107c73c16ae","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"productImageList":[{"imageHeight":"","businessNumber":"4028e4ed54e78a600154e78a75910128","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-24/MDQ4YWQ2MmEtMWMxOC00OTVmLWI2MzEtMTZkMjBhMDBlOTQ3","imageWidth":""}],"isCollect":1,"isSpot":1}],"last":true,"totalElements":1,"totalPages":1,"number":0,"size":5,"numberOfElements":1,"first":true}
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
        private boolean last;
        private int totalElements;
        private int totalPages;
        private int number;
        private int size;
        private int numberOfElements;
        private boolean first;
        /**
         * id : 83
         * title : 测试数据
         * introduce :
         * content : 魅族手机
         * originalPrice : 6.01
         * currentPrice : 0.01
         * freight : 0.01
         * priceDesc :
         * parentClassify : MMYP
         * parentClassifyText : 妈妈用品
         * secondClassify : MMYP_PS
         * secondClassifyText : 配饰
         * thirdClassify :
         * thirdClassifyText :
         * userLocation : {"id":7,"country":"中国","countryCode":"0","province":"上海市","city":"上海市","cityCode":"289","district":"杨浦区","street":"飞虹路","streetNumber":"568弄-20","address":"中国上海市杨浦区飞虹路568弄-20"}
         * productType : 0
         * productStatus : 0
         * productStatusText : 上架
         * isResolve : 1
         * resolveDate :
         * browseNumber : 63
         * replyNumber : 5
         * shareNumber : 0
         * isRecommoned : 1
         * publicDate : 2016-05-24 15:32:04
         * publicUser : {"id":6,"mbpUserId":100768,"imUserId":"15201921714","loginAccount":"15201921714","nickName":"库里","sex":null,"province":"","provinceText":"","city":"","cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2016-1-25/image_08d10846139348919717a107c73c16ae","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}
         * productImageList : [{"imageHeight":"","businessNumber":"4028e4ed54e78a600154e78a75910128","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-24/MDQ4YWQ2MmEtMWMxOC00OTVmLWI2MzEtMTZkMjBhMDBlOTQ3","imageWidth":""}]
         * isCollect : 1
         * isSpot : 1
         */

        private List<ContentEntity> content;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

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

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

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
            /**
             * id : 7
             * country : 中国
             * countryCode : 0
             * province : 上海市
             * city : 上海市
             * cityCode : 289
             * district : 杨浦区
             * street : 飞虹路
             * streetNumber : 568弄-20
             * address : 中国上海市杨浦区飞虹路568弄-20
             */

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
            /**
             * id : 6
             * mbpUserId : 100768
             * imUserId : 15201921714
             * loginAccount : 15201921714
             * nickName : 库里
             * sex : null
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

            private PublicUser publicUser;
            private int isCollect;
            private int isSpot;
            /**
             * imageHeight :
             * businessNumber : 4028e4ed54e78a600154e78a75910128
             * location : http://smart-test.image.alimmdn.com/market/product/image/2016-05-24/MDQ4YWQ2MmEtMWMxOC00OTVmLWI2MzEtMTZkMjBhMDBlOTQ3
             * imageWidth :
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

        }
    }
}
