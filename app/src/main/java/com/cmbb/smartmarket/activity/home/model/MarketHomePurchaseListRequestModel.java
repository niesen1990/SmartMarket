package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/5 下午12:35
 * 修改人：N.Sun
 * 修改时间：16/6/5 下午12:35
 * 修改备注：
 */
public class MarketHomePurchaseListRequestModel extends RetrofitRequestModel {

    /**
     * type : 1
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
        private String type;
        private int numberOfPerPage;
        private int pageNo;

        public ParametersEntity(String type, int numberOfPerPage, int pageNo) {
            this.type = type;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
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
