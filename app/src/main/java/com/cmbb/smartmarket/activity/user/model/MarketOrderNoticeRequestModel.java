package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/2 下午2:26
 * 修改人：N.Sun
 * 修改时间：16/6/2 下午2:26
 * 修改备注：
 */
public class MarketOrderNoticeRequestModel extends RetrofitRequestModel {

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String orderType;
        private String saleType;
        private int id;

        public ParametersEntity(String orderType, String saleType, int orderId) {
            this.orderType = orderType;
            this.saleType = saleType;
            this.id = orderId;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public String getSaleType() {
            return saleType;
        }

        public void setSaleType(String saleType) {
            this.saleType = saleType;
        }
    }
}
