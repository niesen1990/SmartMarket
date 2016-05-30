package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/22 下午3:56
 * 修改人：N.Sun
 * 修改时间：16/5/22 下午3:56
 * 修改备注：
 */
public class WalletAccountBindalipayRequestModel extends RetrofitRequestModel {

    /**
     * cardType : 支付宝
     * cardUsername : 冯有双
     * cardCode : 1868471120
     * code : 5387
     * phone : 15901718791
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String cardType;
        private String cardUsername;
        private String cardCode;
        private String code;
        private String phone;

        public ParametersEntity(String cardType, String cardUsername, String cardCode, String code, String phone) {
            this.cardType = cardType;
            this.cardUsername = cardUsername;
            this.cardCode = cardCode;
            this.code = code;
            this.phone = phone;
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

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }
    }
}
