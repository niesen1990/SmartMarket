package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;
import com.cmbb.smartmarket.network.model.UserLocation;

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
        private PublicUser publicUser;
        private int isCollect;
        private int isSpot;

        public UserLocation getUserLocation() {
            return userLocation;
        }

        public void setUserLocation(UserLocation userLocation) {
            this.userLocation = userLocation;
        }

        /**
         * imageHeight :
         * location : http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj
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
