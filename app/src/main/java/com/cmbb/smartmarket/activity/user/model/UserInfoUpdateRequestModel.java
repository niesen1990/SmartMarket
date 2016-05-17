package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/13 上午10:33
 * 修改人：N.Sun
 * 修改时间：16/5/13 上午10:33
 * 修改备注：
 */
public class UserInfoUpdateRequestModel extends RetrofitRequestModel {

    /**
     * userNike : 臻萌兔
     * userSex :
     * province :
     * provinceText :
     * city :
     * cityText :
     * userPresentation :
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String userNike;
        private String userSex;
        private String province;
        private String provinceText;
        private String city;
        private String cityText;
        private String userPresentation;

        public String getUserNike() {
            return userNike;
        }

        public void setUserNike(String userNike) {
            this.userNike = userNike;
        }

        public String getUserSex() {
            return userSex;
        }

        public void setUserSex(String userSex) {
            this.userSex = userSex;
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

        public String getUserPresentation() {
            return userPresentation;
        }

        public void setUserPresentation(String userPresentation) {
            this.userPresentation = userPresentation;
        }
    }
}
