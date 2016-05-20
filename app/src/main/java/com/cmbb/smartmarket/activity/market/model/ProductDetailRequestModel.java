package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午9:49
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午9:49
 * 修改备注：
 */
public class ProductDetailRequestModel extends RetrofitRequestModel {

    /**
     * productId : 5
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

        public ParametersEntity(int productId) {
            this.productId = productId;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }
    }
}
