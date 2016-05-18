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
     * orderId : 1
     * payTypes : [{"paymentTypeId":"1","name":"支付宝","paymentData":"partner=\"2088511925288803\"&seller_id=\"pay@123.com\"&out_trade_no=\"1DCMEP7OZA95CNC\"&subject=\"魅力香水\"&body=\"新年特惠 adidas 阿迪达斯走珠 香体止汗走珠 多种香型可选\"&total_fee=\"1.00\"&notify_url=\"http%3A%2F%2Fwwww.xxx.com\"&service=\"mobile.securitypay.pay\"&_input_charset=\"utf-8\"&payment_type=\"1\"&return_url=\"www.xxx.com\"&it_b_pay=\"1d\"&show_url=\"www.xxx.com\"&sign=\"lY6mpkwtZz6AKrdzwfaXVdFM88%2Bq3TsePUQGCVQcrV94AvpoCd9EYqNNtIsAC2mmQAHimyEWZoTxBrb3df1NEhv5N9IsDD%2B0q4Ba8ah4xM0XNYGtkht%2FWiNmSd%2FNS7AMYUPT%2B8ef2YtTESlQfZfpMidpLitE%2Bc9bj64SbX7BHNs%3D\"&sign_type=\"RSA\""}]
     */

    private String orderId;
    /**
     * paymentTypeId : 1
     * name : 支付宝
     * paymentData : partner="2088511925288803"&seller_id="pay@123.com"&out_trade_no="1DCMEP7OZA95CNC"&subject="魅力香水"&body="新年特惠 adidas 阿迪达斯走珠 香体止汗走珠 多种香型可选"&total_fee="1.00"&notify_url="http%3A%2F%2Fwwww.xxx.com"&service="mobile.securitypay.pay"&_input_charset="utf-8"&payment_type="1"&return_url="www.xxx.com"&it_b_pay="1d"&show_url="www.xxx.com"&sign="lY6mpkwtZz6AKrdzwfaXVdFM88%2Bq3TsePUQGCVQcrV94AvpoCd9EYqNNtIsAC2mmQAHimyEWZoTxBrb3df1NEhv5N9IsDD%2B0q4Ba8ah4xM0XNYGtkht%2FWiNmSd%2FNS7AMYUPT%2B8ef2YtTESlQfZfpMidpLitE%2Bc9bj64SbX7BHNs%3D"&sign_type="RSA"
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
        private String paymentTypeId;
        private String name;
        private String paymentData;

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

        public String getPaymentData() {
            return paymentData;
        }

        public void setPaymentData(String paymentData) {
            this.paymentData = paymentData;
        }
    }
}
