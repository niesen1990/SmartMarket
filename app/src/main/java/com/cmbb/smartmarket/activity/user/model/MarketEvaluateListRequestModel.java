package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/29 下午4:44
 * 修改人：N.Sun
 * 修改时间：16/5/29 下午4:44
 * 修改备注：
 */
public class MarketEvaluateListRequestModel extends RetrofitRequestModel {

    /**
     * userId : 1
     * numberOfPerPage : 1
     * pageNo : 1
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int userId;
        private int numberOfPerPage;
        private int pageNo;

        public ParametersEntity(int userId, int numberOfPerPage, int pageNo) {
            this.userId = userId;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
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
