package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/29 下午3:50
 * 修改人：N.Sun
 * 修改时间：16/5/29 下午3:50
 * 修改备注：
 */
public class MarketEvaluateSaveRequestModel extends RetrofitRequestModel {

    /**
     * orderId : 5
     * expressSpeed : 5
     * productMatche : 5
     * content : 感觉这个很好
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int orderId;
        private String expressSpeed;
        private String productMatche;
        private String content;
        private int parentId;

        public ParametersEntity(int orderId, int expressSpeed, int productMatche, String content) {
            this.orderId = orderId;
            this.expressSpeed = String.valueOf(expressSpeed);
            this.productMatche = String.valueOf(productMatche);
            this.content = content;
        }

        public ParametersEntity(int parentId, int orderId, String content) {
            this.orderId = orderId;
            this.parentId = parentId;
            this.content = content;
        }

        public int getParentId() {
            return parentId;
        }

        public void setParentId(int parentId) {
            this.parentId = parentId;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public String getExpressSpeed() {
            return expressSpeed;
        }

        public void setExpressSpeed(String expressSpeed) {
            this.expressSpeed = expressSpeed;
        }

        public String getProductMatche() {
            return productMatche;
        }

        public void setProductMatche(String productMatche) {
            this.productMatche = productMatche;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }
}
