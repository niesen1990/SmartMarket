package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;
import com.cmbb.smartmarket.network.model.UserLocation;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/30 上午10:22
 * 修改人：N.Sun
 * 修改时间：16/5/30 上午10:22
 * 修改备注：
 */
public class MarketEvaluateDetailResponseModel {

    /**
     * id : 3
     * parentId : 1
     * product : {"id":9,"title":"【求购】 求购服装111","introduce":"","content":"求购服装111","originalPrice":500,"currentPrice":100,"freight":5,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"","secondClassify":"MMYP_FZ","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","type":"ASK_TO_BUY","status":"ITEMDOWNSHELF","statusText":"下架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-10 17:03:37","publicUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":null,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"isCollect":1,"isSpot":1}
     * orderId : 5
     * expressSpeed : 5
     * productMatche : 5
     * content : 感觉这个很好
     * evaluateUser : {"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":1,"province":110000,"provinceText":"","city":110100,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""}
     * evaluateDate : 2016-05-17 17:50:19
     * childEvaluate : {"id":4,"parentId":3,"product":"","orderId":3,"expressSpeed":0,"productMatche":0,"content":"谢谢你的好评","evaluateUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":null,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"evaluateDate":"2016-05-17 17:54:26"}
     */

    private DataEntity data;
    /**
     * data : {"id":3,"parentId":1,"product":{"id":9,"title":"【求购】 求购服装111","introduce":"","content":"求购服装111","originalPrice":500,"currentPrice":100,"freight":5,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"","secondClassify":"MMYP_FZ","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","type":"ASK_TO_BUY","status":"ITEMDOWNSHELF","statusText":"下架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":1,"publicDate":"2016-05-10 17:03:37","publicUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":null,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"isCollect":1,"isSpot":1},"orderId":5,"expressSpeed":5,"productMatche":5,"content":"感觉这个很好","evaluateUser":{"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":1,"province":110000,"provinceText":"","city":110100,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"evaluateDate":"2016-05-17 17:50:19","childEvaluate":{"id":4,"parentId":3,"product":"","orderId":3,"expressSpeed":0,"productMatche":0,"content":"谢谢你的好评","evaluateUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":null,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""},"evaluateDate":"2016-05-17 17:54:26"}}
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
        private int parentId;
        /**
         * id : 9
         * title : 【求购】 求购服装111
         * introduce :
         * content : 求购服装111
         * originalPrice : 500.0
         * currentPrice : 100.0
         * freight : 5.0
         * priceDesc :
         * parentClassify : MMYP
         * parentClassifyText :
         * secondClassify : MMYP_FZ
         * secondClassifyText :
         * thirdClassify :
         * thirdClassifyText :
         * type : ASK_TO_BUY
         * status : ITEMDOWNSHELF
         * statusText : 下架
         * isResolve : 1
         * resolveDate :
         * browseNumber : 0
         * replyNumber : 0
         * shareNumber : 0
         * isRecommoned : 1
         * publicDate : 2016-05-10 17:03:37
         * publicUser : {"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":null,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}
         * isCollect : 1
         * isSpot : 1
         */

        private ProductEntity product;
        private int orderId;
        private int expressSpeed;
        private int productMatche;
        private String content;
        /**
         * id : 1
         * mbpUserId : 108075
         * loginAccount : 15901718791
         * nickName : 臻萌兔
         * sex : 1
         * province : 110000
         * provinceText :
         * city : 110100
         * cityText :
         * introduce :
         * userImg : http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910
         * imgWidth : 750
         * imgHeight : 750
         * userLevel : 0
         * appVersion :
         * device :
         * deviceImei :
         */

        private EvaluateUserEntity evaluateUser;
        private String evaluateDate;
        /**
         * id : 4
         * parentId : 3
         * product :
         * orderId : 3
         * expressSpeed : 0
         * productMatche : 0
         * content : 谢谢你的好评
         * evaluateUser : {"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":null,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}
         * evaluateDate : 2016-05-17 17:54:26
         */

        private ChildEvaluateEntity childEvaluate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public ProductEntity getProduct() {
            return product;
        }

        public void setProduct(ProductEntity product) {
            this.product = product;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getExpressSpeed() {
            return expressSpeed;
        }

        public void setExpressSpeed(int expressSpeed) {
            this.expressSpeed = expressSpeed;
        }

        public int getProductMatche() {
            return productMatche;
        }

        public void setProductMatche(int productMatche) {
            this.productMatche = productMatche;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public EvaluateUserEntity getEvaluateUser() {
            return evaluateUser;
        }

        public void setEvaluateUser(EvaluateUserEntity evaluateUser) {
            this.evaluateUser = evaluateUser;
        }

        public String getEvaluateDate() {
            return evaluateDate;
        }

        public void setEvaluateDate(String evaluateDate) {
            this.evaluateDate = evaluateDate;
        }

        public ChildEvaluateEntity getChildEvaluate() {
            return childEvaluate;
        }

        public void setChildEvaluate(ChildEvaluateEntity childEvaluate) {
            this.childEvaluate = childEvaluate;
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
            private UserLocation userLocation;
            private List<ProductImageList> productImageList;
            private PublicUser publicUser;
            private int isCollect;
            private int isSpot;

            public UserLocation getUserLocation() {
                return userLocation;
            }

            public void setUserLocation(UserLocation userLocation) {
                this.userLocation = userLocation;
            }

            public List<ProductImageList> getProductImageList() {
                return productImageList;
            }

            public void setProductImageList(List<ProductImageList> productImageList) {
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
        }


        public static class ChildEvaluateEntity {
            private int id;
            private int parentId;
            private String product;
            private int orderId;
            private int expressSpeed;
            private int productMatche;
            private String content;
            private PublicUser evaluateUser;
            private String evaluateDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getParentId() {
                return parentId;
            }

            public void setParentId(int parentId) {
                this.parentId = parentId;
            }

            public String getProduct() {
                return product;
            }

            public void setProduct(String product) {
                this.product = product;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public int getExpressSpeed() {
                return expressSpeed;
            }

            public void setExpressSpeed(int expressSpeed) {
                this.expressSpeed = expressSpeed;
            }

            public int getProductMatche() {
                return productMatche;
            }

            public void setProductMatche(int productMatche) {
                this.productMatche = productMatche;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public PublicUser getEvaluateUser() {
                return evaluateUser;
            }

            public void setEvaluateUser(PublicUser evaluateUser) {
                this.evaluateUser = evaluateUser;
            }

            public String getEvaluateDate() {
                return evaluateDate;
            }

            public void setEvaluateDate(String evaluateDate) {
                this.evaluateDate = evaluateDate;
            }


        }
    }

    public static class EvaluateUserEntity {

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
}
