package com.cmbb.smartmarket.activity.login.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/12 下午3:46
 * 修改人：N.Sun
 * 修改时间：16/5/12 下午3:46
 * 修改备注：
 */
public class LoginRequestModel extends RetrofitRequestModel {

    /**
     * loginAccount : 15901718791
     * securityCode : 9345
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String loginAccount;
        private String securityCode;

        public ParametersEntity(String loginAccount, String securityCode) {
            this.loginAccount = loginAccount;
            this.securityCode = securityCode;
        }

        public String getLoginAccount() {
            return loginAccount;
        }

        public void setLoginAccount(String loginAccount) {
            this.loginAccount = loginAccount;
        }

        public String getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(String securityCode) {
            this.securityCode = securityCode;
        }
    }
}
