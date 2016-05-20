package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 上午11:04
 * 修改人：N.Sun
 * 修改时间：16/5/19 上午11:04
 * 修改备注：
 */
public class WalletAccountGetCashRequestModel extends RetrofitRequestModel {

    /**
     * businessBalance : 20.0
     * cardType : 支付宝
     * cardUsername : asas
     * cardCode : 18684711220
     * phone : 18684711220
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
        private double businessBalance;
        private String cardType;
        private String cardUsername;
        private String cardCode;
        private String phone;
        private String password;

        public double getBusinessBalance() {
            return businessBalance;
        }

        public void setBusinessBalance(double businessBalance) {
            this.businessBalance = businessBalance;
        }

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getCardUsername() {
            return cardUsername;
        }

        public void setCardUsername(String cardUsername) {
            this.cardUsername = cardUsername;
        }

        public String getCardCode() {
            return cardCode;
        }

        public void setCardCode(String cardCode) {
            this.cardCode = cardCode;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
}
