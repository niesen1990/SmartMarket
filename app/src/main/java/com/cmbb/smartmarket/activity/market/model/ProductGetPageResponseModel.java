package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:09
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:09
 * 修改备注：
 */
public class ProductGetPageResponseModel {

    /**
     * content : [{"id":5,"title":"配饰","introduce":"","content":"服","originalPrice":500,"currentPrice":100,"freight":20,"priceDesc":"","parentClassify":"3","parentClassifyText":"","secondClassify":"6","secondClassifyText":"","thirdClassify":"3","thirdClassifyText":"","lontitude":0,"latitude":"","province":"","city":"","district":"","address":"","productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":0,"publicDate":"2016-04-29 18:01:21","publicUserDto":"","productImageList":[{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_NzYxNzI2YjgtOTg3Yy00NTlmLTgwM2YtM2FmNmY0Yjc4NjRl","imageWidth":""},{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_MmFjNjZkYzQtNGZkOC00NmEzLTlkNWMtOWQyYzk5OGU4NGM1","imageWidth":""},{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_ZDZlNGQyMzYtMWJhNC00YjllLWI1MjUtNDdiYjYxYzI4YTFk","imageWidth":""}],"productRelysList":[{"id":2,"productId":1,"repUserId":3,"contents":"回复@mywaystay:便宜点喽","type":0,"resolveProductId":1,"isRecommoned":0,"recommonedProductImageList":"","createDate":"2016-05-05 15:17:51","createUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":"","province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}}],"isCollect":2,"isSpot":1}]
     * totalPages : 1
     * totalElements : 4
     * last : true
     * size : 5
     * number : 0
     * sort :
     * first : true
     * numberOfElements : 4
     */

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
        private int totalPages;
        private int totalElements;
        private boolean last;
        private int size;
        private int number;
        private String sort;
        private boolean first;
        private int numberOfElements;
        /**
         * id : 5
         * title : 配饰
         * introduce :
         * content : 服
         * originalPrice : 500
         * currentPrice : 100
         * freight : 20
         * priceDesc :
         * parentClassify : 3
         * parentClassifyText :
         * secondClassify : 6
         * secondClassifyText :
         * thirdClassify : 3
         * thirdClassifyText :
         * lontitude : 0
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
         * isRecommoned : 0
         * publicDate : 2016-04-29 18:01:21
         * publicUserDto :
         * productImageList : [{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_NzYxNzI2YjgtOTg3Yy00NTlmLTgwM2YtM2FmNmY0Yjc4NjRl","imageWidth":""},{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_MmFjNjZkYzQtNGZkOC00NmEzLTlkNWMtOWQyYzk5OGU4NGM1","imageWidth":""},{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_ZDZlNGQyMzYtMWJhNC00YjllLWI1MjUtNDdiYjYxYzI4YTFk","imageWidth":""}]
         * productRelysList : [{"id":2,"productId":1,"repUserId":3,"contents":"回复@mywaystay:便宜点喽","type":0,"resolveProductId":1,"isRecommoned":0,"recommonedProductImageList":"","createDate":"2016-05-05 15:17:51","createUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":"","province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}}]
         * isCollect : 2
         * isSpot : 1
         */

        private List<ContentEntity> content;

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

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

        public String getSort() {
            return sort;
        }

        public void setSort(String sort) {
            this.sort = sort;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
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
            private int originalPrice;
            private int currentPrice;
            private int freight;
            private String priceDesc;
            private String parentClassify;
            private String parentClassifyText;
            private String secondClassify;
            private String secondClassifyText;
            private String thirdClassify;
            private String thirdClassifyText;
            private int lontitude;
            private String latitude;
            private String province;
            private String city;
            private String district;
            private String address;
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
            private String publicUserDto;
            private int isCollect;
            private int isSpot;
            /**
             * imageHeight :
             * location : http://smart-test.image.alimmdn.com/market/product/image/2016-04-29/imageList_NzYxNzI2YjgtOTg3Yy00NTlmLTgwM2YtM2FmNmY0Yjc4NjRl
             * imageWidth :
             */

            private List<ProductImageListEntity> productImageList;
            /**
             * id : 2
             * productId : 1
             * repUserId : 3
             * contents : 回复@mywaystay:便宜点喽
             * type : 0
             * resolveProductId : 1
             * isRecommoned : 0
             * recommonedProductImageList :
             * createDate : 2016-05-05 15:17:51
             * createUser : {"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":"","province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}
             */

            private List<ProductRelysListEntity> productRelysList;

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

            public int getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(int originalPrice) {
                this.originalPrice = originalPrice;
            }

            public int getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(int currentPrice) {
                this.currentPrice = currentPrice;
            }

            public int getFreight() {
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

            public int getLontitude() {
                return lontitude;
            }

            public void setLontitude(int lontitude) {
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

            public String getPublicUserDto() {
                return publicUserDto;
            }

            public void setPublicUserDto(String publicUserDto) {
                this.publicUserDto = publicUserDto;
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

            public List<ProductRelysListEntity> getProductRelysList() {
                return productRelysList;
            }

            public void setProductRelysList(List<ProductRelysListEntity> productRelysList) {
                this.productRelysList = productRelysList;
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

            public static class ProductRelysListEntity {
                private int id;
                private int productId;
                private int repUserId;
                private String contents;
                private int type;
                private int resolveProductId;
                private int isRecommoned;
                private String recommonedProductImageList;
                private String createDate;
                /**
                 * id : 3
                 * mbpUserId : 108074
                 * loginAccount : 18221507236
                 * nickName : mywaystay
                 * sex :
                 * province : 310000
                 * provinceText :
                 * city : 310104
                 * cityText :
                 * introduce :
                 * userImg : http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253
                 * imgWidth :
                 * imgHeight :
                 * userLevel : 0
                 * appVersion :
                 * device :
                 * deviceImei :
                 */

                private CreateUserEntity createUser;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getProductId() {
                    return productId;
                }

                public void setProductId(int productId) {
                    this.productId = productId;
                }

                public int getRepUserId() {
                    return repUserId;
                }

                public void setRepUserId(int repUserId) {
                    this.repUserId = repUserId;
                }

                public String getContents() {
                    return contents;
                }

                public void setContents(String contents) {
                    this.contents = contents;
                }

                public int getType() {
                    return type;
                }

                public void setType(int type) {
                    this.type = type;
                }

                public int getResolveProductId() {
                    return resolveProductId;
                }

                public void setResolveProductId(int resolveProductId) {
                    this.resolveProductId = resolveProductId;
                }

                public int getIsRecommoned() {
                    return isRecommoned;
                }

                public void setIsRecommoned(int isRecommoned) {
                    this.isRecommoned = isRecommoned;
                }

                public String getRecommonedProductImageList() {
                    return recommonedProductImageList;
                }

                public void setRecommonedProductImageList(String recommonedProductImageList) {
                    this.recommonedProductImageList = recommonedProductImageList;
                }

                public String getCreateDate() {
                    return createDate;
                }

                public void setCreateDate(String createDate) {
                    this.createDate = createDate;
                }

                public CreateUserEntity getCreateUser() {
                    return createUser;
                }

                public void setCreateUser(CreateUserEntity createUser) {
                    this.createUser = createUser;
                }

                public static class CreateUserEntity {
                    private int id;
                    private int mbpUserId;
                    private String loginAccount;
                    private String nickName;
                    private String sex;
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

                    public String getSex() {
                        return sex;
                    }

                    public void setSex(String sex) {
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
                }
            }
        }
    }
}