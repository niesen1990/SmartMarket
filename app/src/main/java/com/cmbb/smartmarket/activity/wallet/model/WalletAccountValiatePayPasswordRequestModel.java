package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 上午10:40
 * 修改人：N.Sun
 * 修改时间：16/5/19 上午10:40
 * 修改备注：
 */
public class WalletAccountValiatePayPasswordRequestModel extends RetrofitRequestModel {

    /**
     * password : 123123
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

        public ParametersEntity(String password) {
            this.password = password;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
