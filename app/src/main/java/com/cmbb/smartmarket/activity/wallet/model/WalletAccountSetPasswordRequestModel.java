package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 上午10:36
 * 修改人：N.Sun
 * 修改时间：16/5/19 上午10:36
 * 修改备注：
 */
public class WalletAccountSetPasswordRequestModel extends RetrofitRequestModel {

    /**
     * password : 123123
     * rePassword : 123123
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String password;
        private String rePassword;

        public ParametersEntity(String password, String rePassword) {
            this.password = password;
            this.rePassword = rePassword;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }

        public String getRePassword() {
            return rePassword;
        }

        public void setRePassword(String rePassword) {
            this.rePassword = rePassword;
        }
    }
}
