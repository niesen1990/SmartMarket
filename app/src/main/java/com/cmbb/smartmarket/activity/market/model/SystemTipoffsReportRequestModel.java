package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:46
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:46
 * 修改备注：
 */
public class SystemTipoffsReportRequestModel extends RetrofitRequestModel {

    /**
     * reportContentType : 4
     * relateId : 1
     * reportContent : 无聊哦22
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int reportContentType;
        private int relateId;
        private String reportContent;

        public int getReportContentType() {
            return reportContentType;
        }

        public void setReportContentType(int reportContentType) {
            this.reportContentType = reportContentType;
        }

        public int getRelateId() {
            return relateId;
        }

        public void setRelateId(int relateId) {
            this.relateId = relateId;
        }

        public String getReportContent() {
            return reportContent;
        }

        public void setReportContent(String reportContent) {
            this.reportContent = reportContent;
        }
    }
}
