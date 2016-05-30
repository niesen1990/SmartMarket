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
        private int expressSpeed;
        private int productMatche;
        private String content;

        public ParametersEntity(int orderId, int expressSpeed, int productMatche, String content) {
            this.orderId = orderId;
            this.expressSpeed = expressSpeed;
            this.productMatche = productMatche;
            this.content = content;
        }

        public int getOrderId() {
            return orderId;
        }

        public void setOrderId(int orderId) {
            this.orderId = orderId;
        }

        public int getExpressSpeed() {
            return expressSpeed;
        }

        public void setExpressSpeed(int expressSpeed) {
            this.expressSpeed = expressSpeed;
        }

        public int getProductMatche() {
            return productMatche;
        }

        public void setProductMatche(int productMatche) {
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
