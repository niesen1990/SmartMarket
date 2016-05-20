package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/20 上午9:51
 * 修改人：N.Sun
 * 修改时间：16/5/20 上午9:51
 * 修改备注：
 */
public class ProductReplyListRequestModel extends RetrofitRequestModel {

    /**
     * productId : 1
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
        private int productId;
        private int numberOfPerPage;
        private int pageNo;

        public ParametersEntity(int productId, int numberOfPerPage, int pageNo) {
            this.productId = productId;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
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
