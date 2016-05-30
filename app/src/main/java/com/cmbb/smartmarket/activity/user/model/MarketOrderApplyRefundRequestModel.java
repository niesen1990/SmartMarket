package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午3:48
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午3:48
 * 修改备注：
 */
public class MarketOrderApplyRefundRequestModel extends RetrofitRequestModel {

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int id;
        private String refundServer;
        private String refundReason;
        private String refundMark;

        public ParametersEntity(int id, String refundServer, String refundReason, String refundMark) {
            this.id = id;
            this.refundServer = refundServer;
            this.refundReason = refundReason;
            this.refundMark = refundMark;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getRefundServer() {
            return refundServer;
        }

        public void setRefundServer(String refundServer) {
            this.refundServer = refundServer;
        }

        public String getRefundReason() {
            return refundReason;
        }

        public void setRefundReason(String refundReason) {
            this.refundReason = refundReason;
        }

        public String getRefundMark() {
            return refundMark;
        }

        public void setRefundMark(String refundMark) {
            this.refundMark = refundMark;
        }
    }
}
