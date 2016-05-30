package com.cmbb.smartmarket.activity.login.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/12 下午3:48
 * 修改人：N.Sun
 * 修改时间：16/5/12 下午3:48
 * 修改备注：
 */
public class LoginResponseModel {

    /**
     * sex : 1
     * provinceText :
     * introduce :
     * imgWidth : 542
     * city : 110100
     * loginAccount : 15901718791
     * id : 1
     * loginToken : ZmFlYTI5M2QtZmU4OC00ZDBiLWI0MmEtNTZhNzUyMzFiZTlk
     * nickName : 臻萌兔
     * userLevel : 0
     * province : 110000
     * imUserId : ["15901718791"]
     * cityText :
     * userImg : http://smart-test.image.alimmdn.com/market/user/image/2016-05-13/ODUxNmNiNDctYjVlZC00N2JiLTljMzAtY2UwMDQxYWE4NjYx
     * imgHeight : 408
     */

    private DataEntity data;
    /**
     * data : {"sex":1,"provinceText":"","introduce":"","imgWidth":542,"city":110100,"loginAccount":"15901718791","id":1,"loginToken":"ZmFlYTI5M2QtZmU4OC00ZDBiLWI0MmEtNTZhNzUyMzFiZTlk","nickName":"臻萌兔","userLevel":0,"province":110000,"imUserId":["15901718791"],"cityText":"","userImg":"http://smart-test.image.alimmdn.com/market/user/image/2016-05-13/ODUxNmNiNDctYjVlZC00N2JiLTljMzAtY2UwMDQxYWE4NjYx","imgHeight":408}
     * msg : 登录成功
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
        private int sex;
        private String provinceText;
        private String introduce;
        private int imgWidth;
        private int city;
        private String loginAccount;
        private int id;
        private String loginToken;
        private String nickName;
        private int userLevel;
        private int province;
        private String cityText;
        private String userImg;
        private int imgHeight;
        private String imUserId;

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

        public int getImgWidth() {
            return imgWidth;
        }

        public void setImgWidth(int imgWidth) {
            this.imgWidth = imgWidth;
        }

        public int getCity() {
            return city;
        }

        public void setCity(int city) {
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

        public int getProvince() {
            return province;
        }

        public void setProvince(int province) {
            this.province = province;
        }

        public String getCityText() {
            return cityText;
        }

        public void setCityText(String cityText) {
            this.cityText = cityText;
        }

        public String getUserImg() {
            return userImg;
        }

        public void setUserImg(String userImg) {
            this.userImg = userImg;
        }

        public int getImgHeight() {
            return imgHeight;
        }

        public void setImgHeight(int imgHeight) {
            this.imgHeight = imgHeight;
        }

        public String getImUserId() {
            return imUserId;
        }

        public void setImUserId(String imUserId) {
            this.imUserId = imUserId;
        }
    }
}
