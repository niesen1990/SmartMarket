package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/1 下午1:19
 * 修改人：N.Sun
 * 修改时间：16/6/1 下午1:19
 * 修改备注：
 */
public class MarketHomeRecommendationRequestModel extends RetrofitRequestModel {

    /**
     * isProductRecommoned : 1
     * type : 0
     * numberOfPerPage : 4
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
        private int isProductRecommoned;
        private int type;
        private int numberOfPerPage;
        private int pageNo;

        public ParametersEntity(int isProductRecommoned, int type, int numberOfPerPage, int pageNo) {
            this.isProductRecommoned = isProductRecommoned;
            this.type = type;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public int getIsProductRecommoned() {
            return isProductRecommoned;
        }

        public void setIsProductRecommoned(int isProductRecommoned) {
            this.isProductRecommoned = isProductRecommoned;
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
