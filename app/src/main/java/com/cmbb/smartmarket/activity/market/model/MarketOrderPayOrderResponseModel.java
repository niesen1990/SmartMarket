package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午12:05
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午12:05
 * 修改备注：
 */
public class MarketOrderPayOrderResponseModel {

    /**
     * orderId : 33
     * payTypes : [{"paymentData":"partner=\"2088021604444292\"&seller_id=\"ios_android_smart@smart-kids.com\"&out_trade_no=\"0007566162107685_1463991662096\"&subject=\"共产党\"&body=\"共产党\"&total_fee=\"12\"&notify_url=\"http%3A%2F%2F120.26.88.135%3A8094%2Fwine-market-rest%2Fnotify%2Falipay%2Fpay\"&service=\"mobile.securitypay.pay\"&_input_charset=\"UTF-8\"&payment_type=\"1\"&it_b_pay=\"1m\"&sign=\"4caa8a5dedde4b14fbf3667f03fd8ffc\"&sign_type=\"MD5\"","paymentTypeId":"1","name":"支付宝"}]
     */

    private DataEntity data;
    /**
     * data : {"orderId":"33","payTypes":[{"paymentData":"partner=\"2088021604444292\"&seller_id=\"ios_android_smart@smart-kids.com\"&out_trade_no=\"0007566162107685_1463991662096\"&subject=\"共产党\"&body=\"共产党\"&total_fee=\"12\"&notify_url=\"http%3A%2F%2F120.26.88.135%3A8094%2Fwine-market-rest%2Fnotify%2Falipay%2Fpay\"&service=\"mobile.securitypay.pay\"&_input_charset=\"UTF-8\"&payment_type=\"1\"&it_b_pay=\"1m\"&sign=\"4caa8a5dedde4b14fbf3667f03fd8ffc\"&sign_type=\"MD5\"","paymentTypeId":"1","name":"支付宝"}]}
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
        private String orderId;
        /**
         * paymentData : partner="2088021604444292"&seller_id="ios_android_smart@smart-kids.com"&out_trade_no="0007566162107685_1463991662096"&subject="共产党"&body="共产党"&total_fee="12"&notify_url="http%3A%2F%2F120.26.88.135%3A8094%2Fwine-market-rest%2Fnotify%2Falipay%2Fpay"&service="mobile.securitypay.pay"&_input_charset="UTF-8"&payment_type="1"&it_b_pay="1m"&sign="4caa8a5dedde4b14fbf3667f03fd8ffc"&sign_type="MD5"
         * paymentTypeId : 1
         * name : 支付宝
         */

        private List<PayTypesEntity> payTypes;

        public String getOrderId() {
            return orderId;
        }

        public void setOrderId(String orderId) {
            this.orderId = orderId;
        }

        public List<PayTypesEntity> getPayTypes() {
            return payTypes;
        }

        public void setPayTypes(List<PayTypesEntity> payTypes) {
            this.payTypes = payTypes;
        }

        public static class PayTypesEntity {
            private String paymentData;
            private String paymentTypeId;
            private String name;

            public String getPaymentData() {
                return paymentData;
            }

            public void setPaymentData(String paymentData) {
                this.paymentData = paymentData;
            }

            public String getPaymentTypeId() {
                return paymentTypeId;
            }

            public void setPaymentTypeId(String paymentTypeId) {
                this.paymentTypeId = paymentTypeId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }
        }
    }
}
