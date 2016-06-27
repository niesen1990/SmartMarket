package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;
import com.cmbb.smartmarket.network.model.UserLocation;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/5 下午12:35
 * 修改人：N.Sun
 * 修改时间：16/6/5 下午12:35
 * 修改备注：
 */
public class MarketHomePurchaseListResponseModel  {


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

            private PublicUser publicUser;
            private UserLocation userLocation;
            private int isCollect;
            private int isSpot;

            private List<ProductImageList> productImageList;

            public UserLocation getUserLocation() {
                return userLocation;
            }

            public void setUserLocation(UserLocation userLocation) {
                this.userLocation = userLocation;
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
        }
    }
}
