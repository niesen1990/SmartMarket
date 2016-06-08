package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 上午11:25
 * 修改人：N.Sun
 * 修改时间：16/5/25 上午11:25
 * 修改备注：
 */
public class MarketCenterSelectProductListRequestModel extends RetrofitRequestModel {

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
        private int userId;
        private String status;

        public ParametersEntity(int type, int userId, String status, int numberOfPerPage, int pageNo) {
            this.type = type;
            this.userId = userId;
            this.status = status;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;

        }

        public ParametersEntity(int type, int userId, int numberOfPerPage, int pageNo) {
            this.type = type;
            this.userId = userId;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }


        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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
