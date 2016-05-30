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
        private String type;

        public ParametersEntity(String searchContent, String type) {
            this.searchContent = searchContent;
            this.type = type;
        }

        public String getSearchContent() {
            return searchContent;
        }

        public void setSearchContent(String searchContent) {
            this.searchContent = searchContent;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }
    }
}
