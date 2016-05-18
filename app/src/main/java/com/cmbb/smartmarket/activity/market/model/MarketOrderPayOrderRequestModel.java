package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午12:05
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午12:05
 * 修改备注：
 */
public class MarketOrderPayOrderRequestModel extends RetrofitRequestModel {

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String orderCode;
        private int paymentTypeId;

        public ParametersEntity(String orderCode, int paymentTypeId) {
            this.orderCode = orderCode;
            this.paymentTypeId = paymentTypeId;
        }

        public String getOrderCode() {
            return orderCode;
        }

        public void setOrderCode(String orderCode) {
            this.orderCode = orderCode;
        }

        public int getPaymentTypeId() {
            return paymentTypeId;
        }

        public void setPaymentTypeId(int paymentTypeId) {
            this.paymentTypeId = paymentTypeId;
        }
    }
}
