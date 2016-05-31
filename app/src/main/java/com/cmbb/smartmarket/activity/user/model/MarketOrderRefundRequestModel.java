package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 上午11:33
 * 修改人：N.Sun
 * 修改时间：16/5/31 上午11:33
 * 修改备注：
 */
public class MarketOrderRefundRequestModel extends RetrofitRequestModel {

    /**
     * id : 24
     * refundStatus : REJECT
     * rejectReason : 我们的货很正常
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
        private String refundStatus;
        private String rejectReason;

        public ParametersEntity(int id, String refundStatus, String rejectReason) {
            this.id = id;
            this.refundStatus = refundStatus;
            this.rejectReason = rejectReason;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRefundStatus() {
            return refundStatus;
        }

        public void setRefundStatus(String refundStatus) {
            this.refundStatus = refundStatus;
        }

        public String getRejectReason() {
            return rejectReason;
        }

        public void setRejectReason(String rejectReason) {
            this.rejectReason = rejectReason;
        }
    }
}
