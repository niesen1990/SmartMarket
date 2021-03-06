package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 下午6:52
 * 修改人：N.Sun
 * 修改时间：16/5/19 下午6:52
 * 修改备注：
 */
public class MyselfProductPublicListRequestModel extends RetrofitRequestModel {

    /**
     * type : 0
     * numberOfPerPage : 5
     * pageNo : 0
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int type;
        private int numberOfPerPage;
        private int pageNo;
        private String status;

        public ParametersEntity(int type, int numberOfPerPage, int pageNo) {
            this.type = type;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public ParametersEntity(int type, int numberOfPerPage, int pageNo, String status) {
            this.type = type;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
            this.status = status;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getNumberOfPerPage() {
            return numberOfPerPage;
        }

        public void setNumberOfPerPage(int numberOfPerPage) {
            this.numberOfPerPage = numberOfPerPage;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }
    }
}
