package com.cmbb.smartmarket.activity.user.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/13 上午10:36
 * 修改人：N.Sun
 * 修改时间：16/5/13 上午10:36
 * 修改备注：
 */
public class UserInfoUpdateResponseModel {

    /**
     * sex :
     * provinceText :
     * introduce :
     * imgWidth : 750
     * city : 110100
     * loginAccount : 15901718791
     * id : 1
     * loginToken : MTcyNDgyZDktMGU2YS00Y2ZmLWE4ZmYtZWQ2ZWQwN2MzNGJj
     * nickName : 臻萌兔
     * userLevel : 0
     * province : 110000
     * cityText :
     * userImg : http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910
     * imgHeight : 750
     */

    private DataEntity data;
    /**
     * data : {"sex":"","provinceText":"","introduce":"","imgWidth":750,"city":110100,"loginAccount":"15901718791","id":1,"loginToken":"MTcyNDgyZDktMGU2YS00Y2ZmLWE4ZmYtZWQ2ZWQwN2MzNGJj","nickName":"臻萌兔","userLevel":0,"province":110000,"cityText":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910","imgHeight":750}
     * msg : 操作成功
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

        /**
         * sex : 1
         * provinceText : 北京
         * introduce : 牛逼共产党
         * imgWidth : 512.0
         * city : 110100
         * loginAccount : 13818155072
         * id : 5
         * loginToken : ODBkN2NmYTItNjVjMy00NTU3LTliMjYtNmJlYTRlNWFlOTli
         * nickName : 共产党人
         * userLevel : 0
         * province : 110000
         * cityText : 北京市
         * imUserId : 13818155072
         * userImg : http://smart-test.image.alimmdn.com/market/user/image/2016-06-12/ODYwYjkxMGYtYzYyZS00OTc1LTk3NjEtZDQ1ZjVmZWNjMzQ4
         * imgHeight : 512.01
         */

        private int sex;
        private String provinceText;
        private String introduce;
        private double imgWidth;
        private String city;
        private String loginAccount;
        private int id;
        private String loginToken;
        private String nickName;
        private int userLevel;
        private String province;
        private String cityText;
        private String imUserId;
        private String userImg;
        private double imgHeight;

        public int getSex() {
            return sex;
        }

        public void setSex(int sex) {
            this.sex = sex;
        }

        public String getProvinceText() {
            return provinceText;
        }

        public void setProvinceText(String provinceText) {
            this.provinceText = provinceText;
        }

        public String getIntroduce() {
            return introduce;
        }

        public void setIntroduce(String introduce) {
            this.introduce = introduce;
        }

        public double getImgWidth() {
            return imgWidth;
        }

        public void setImgWidth(double imgWidth) {
            this.imgWidth = imgWidth;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLoginAccount() {
            return loginAccount;
        }

        public void setLoginAccount(String loginAccount) {
            this.loginAccount = loginAccount;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getLoginToken() {
            return loginToken;
        }

        public void setLoginToken(String loginToken) {
            this.loginToken = loginToken;
        }

        public String getNickName() {
            return nickName;
        }

        public void setNickName(String nickName) {
            this.nickName = nickName;
        }

        public int getUserLevel() {
            return userLevel;
        }

        public void setUserLevel(int userLevel) {
            this.userLevel = userLevel;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getCityText() {
            return cityText;
        }

        public void setCityText(String cityText) {
            this.cityText = cityText;
        }

        public String getImUserId() {
            return imUserId;
        }

        public void setImUserId(String imUserId) {
            this.imUserId = imUserId;
        }

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public double getImgHeight() {
            return imgHeight;
        }

        public void setImgHeight(double imgHeight) {
            this.imgHeight = imgHeight;
        }
    }
}
