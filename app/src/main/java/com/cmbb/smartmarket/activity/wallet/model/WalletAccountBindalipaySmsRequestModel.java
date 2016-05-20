package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 上午10:43
 * 修改人：N.Sun
 * 修改时间：16/5/19 上午10:43
 * 修改备注：
 */
public class WalletAccountBindalipaySmsRequestModel extends RetrofitRequestModel {

    /**
     * phone : 18684711220
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

        public ParametersEntity(String phone) {
            this.phone = phone;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
