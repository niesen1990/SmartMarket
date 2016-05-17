package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:34
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:34
 * 修改备注：
 */
public class ProductRecommendRequestModel extends RetrofitRequestModel {

    /**
     * productId : 5
     * repUserId : 3
     * resolveProductId : 2
     * replyType : 1
     * replyContents : 推荐商品
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
        private int repUserId;
        private int resolveProductId;
        private int replyType;
        private String replyContents;

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public int getRepUserId() {
            return repUserId;
        }

        public void setRepUserId(int repUserId) {
            this.repUserId = repUserId;
        }

        public int getResolveProductId() {
            return resolveProductId;
        }

        public void setResolveProductId(int resolveProductId) {
            this.resolveProductId = resolveProductId;
        }

        public int getReplyType() {
            return replyType;
        }

        public void setReplyType(int replyType) {
            this.replyType = replyType;
        }

        public String getReplyContents() {
            return replyContents;
        }

        public void setReplyContents(String replyContents) {
            this.replyContents = replyContents;
        }
    }
}
