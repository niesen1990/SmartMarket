package com.cmbb.smartmarket.activity.search.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/24 下午5:06
 * 修改人：N.Sun
 * 修改时间：16/5/24 下午5:06
 * 修改备注：
 */
public class MarketHomeSearchRequestModel extends RetrofitRequestModel {

    /**
     * searchContent : 服
     * type : 0
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String searchContent;
        private int type;
        private int numberOfPerPage;
        private int pageNo;

        public ParametersEntity(String searchContent, int type, int numberOfPerPage, int pageNo) {
            this.searchContent = searchContent;
            this.type = type;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
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

        public String getSearchContent() {
            return searchContent;
        }

        public void setSearchContent(String searchContent) {
            this.searchContent = searchContent;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }
    }
}
