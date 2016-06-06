package com.cmbb.smartmarket.activity.user.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/2 下午3:25
 * 修改人：N.Sun
 * 修改时间：16/6/2 下午3:25
 * 修改备注：
 */
public class MarketCenterPersonCenterInfoResponseModel {

    /**
     * collectCount : 28
     * tradeCount : 0
     * userInfo : {"id":3,"mbpUserId":108074,"imUserId":"","loginAccount":"18221507236","nickName":"mywaystay","sex":1,"province":310000,"provinceText":"上海","city":310100,"cityText":"上海市","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""}
     * evaluteCount : 0
     */

    private DataEntity data;
    /**
     * data : {"collectCount":28,"tradeCount":0,"userInfo":{"id":3,"mbpUserId":108074,"imUserId":"","loginAccount":"18221507236","nickName":"mywaystay","sex":1,"province":310000,"provinceText":"上海","city":310100,"cityText":"上海市","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"evaluteCount":0}
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
        private int collectCount;
        private int tradeCount;
        /**
         * id : 3
         * mbpUserId : 108074
         * imUserId :
         * loginAccount : 18221507236
         * nickName : mywaystay
         * sex : 1
         * province : 310000
         * provinceText : 上海
         * city : 310100
         * cityText : 上海市
         * introduce :
         * userImg : http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253
         * imgWidth : 750
         * imgHeight : 750
         * userLevel : 0
         * appVersion :
         * device :
         * deviceImei :
         */

        private UserInfoEntity userInfo;
        private int evaluteCount;

        public int getCollectCount() {
            return collectCount;
        }

        public void setCollectCount(int collectCount) {
            this.collectCount = collectCount;
        }

        public int getTradeCount() {
            return tradeCount;
        }

        public void setTradeCount(int tradeCount) {
            this.tradeCount = tradeCount;
        }

        public UserInfoEntity getUserInfo() {
            return userInfo;
        }

        public void setUserInfo(UserInfoEntity userInfo) {
            this.userInfo = userInfo;
        }

        public int getEvaluteCount() {
            return evaluteCount;
        }

        public void setEvaluteCount(int evaluteCount) {
            this.evaluteCount = evaluteCount;
        }

        public static class UserInfoEntity {
            private int id;
            private int mbpUserId;
            private String imUserId;
            private String loginAccount;
            private String nickName;
            private int sex;
            private int province;
            private String provinceText;
            private int city;
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
    }
}
