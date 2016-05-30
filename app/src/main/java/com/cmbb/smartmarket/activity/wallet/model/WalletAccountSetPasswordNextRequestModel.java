package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/22 下午2:34
 * 修改人：N.Sun
 * 修改时间：16/5/22 下午2:34
 * 修改备注：
 */
public class WalletAccountSetPasswordNextRequestModel extends RetrofitRequestModel {

    /**
     * phone : 15901718791
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
        private String phone;
        private String securityCode;

        public ParametersEntity(String phone, String securityCode) {
            this.phone = phone;
            this.securityCode = securityCode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getSecurityCode() {
            return securityCode;
        }

        public void setSecurityCode(String securityCode) {
            this.securityCode = securityCode;
        }
    }
}
