package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午9:59
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午9:59
 * 修改备注：
 */
public class ProductReplayRequestModel extends RetrofitRequestModel {

    /**
     * productId : 1
     * repUserId : 3
     * replyContents : 便宜点喽
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {

        public ParametersEntity(int productId, int repUserId, String resolveProductId, int replyType, String replyContents) {
            this.productId = productId;
            this.repUserId = repUserId;
            this.resolveProductId = resolveProductId;
            this.replyType = replyType;
            this.replyContents = replyContents;
        }

        /**
         * productId : 5
         * repUserId : 3
         * resolveProductId : 2
         * replyType : 1
         * replyContents : 推荐商品
         */



        private int productId;
        private int repUserId;
        private String resolveProductId;
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

        public String getResolveProductId() {
            return resolveProductId;
        }

        public void setResolveProductId(String resolveProductId) {
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
