package com.cmbb.smartmarket.activity.market.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/20 下午2:59
 * 修改人：N.Sun
 * 修改时间：16/5/20 下午2:59
 * 修改备注：
 */
public class ProductDeleteResponseModel  {

    /**
     * productId : 1
     */

    private ParametersEntity parameters;
    /**
     * msg : 商品删除成功
     */

    private String msg;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
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
