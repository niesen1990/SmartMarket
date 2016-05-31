package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 下午1:31
 * 修改人：N.Sun
 * 修改时间：16/5/31 下午1:31
 * 修改备注：
 */
public class MarketOrderDetailRequestModel extends RetrofitRequestModel {

    /**
     * orderType : order
     * id : 7
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String orderType;
        private int id;

        public ParametersEntity(String orderType, int id) {
            this.orderType = orderType;
            this.id = id;
        }

        public String getOrderType() {
            return orderType;
        }

        public void setOrderType(String orderType) {
            this.orderType = orderType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
