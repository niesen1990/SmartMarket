package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/27 下午5:30
 * 修改人：N.Sun
 * 修改时间：16/5/27 下午5:30
 * 修改备注：
 */
public class MarketOrderCancelRequestModel extends RetrofitRequestModel {

    /**
     * id : 6
     * cancelReason : 我不想买了
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int id;
        private String cancelReason;

        public ParametersEntity(int id, String cancelReason) {
            this.id = id;
            this.cancelReason = cancelReason;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCancelReason() {
            return cancelReason;
        }

        public void setCancelReason(String cancelReason) {
            this.cancelReason = cancelReason;
        }
    }
}
