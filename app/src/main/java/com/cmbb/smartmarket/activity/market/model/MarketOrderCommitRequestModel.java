package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 上午11:12
 * 修改人：N.Sun
 * 修改时间：16/5/18 上午11:12
 * 修改备注：
 */
public class MarketOrderCommitRequestModel extends RetrofitRequestModel {

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int productId;
        private double price;
        private double freight;
        private String receiveName;
        private String receivePhone;
        private String address;
        private String postCode;

        public ParametersEntity(int productId, double price, double freight, String receiveName, String receivePhone, String address, String postCode) {
            this.productId = productId;
            this.price = price;
            this.freight = freight;
            this.receiveName = receiveName;
            this.receivePhone = receivePhone;
            this.address = address;
            this.postCode = postCode;
        }

        public int getProductId() {
            return productId;
        }

        public void setProductId(int productId) {
            this.productId = productId;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public double getFreight() {
            return freight;
        }

        public void setFreight(int freight) {
            this.freight = freight;
        }

        public String getReceiveName() {
            return receiveName;
        }

        public void setReceiveName(String receiveName) {
            this.receiveName = receiveName;
        }

        public String getReceivePhone() {
            return receivePhone;
        }

        public void setReceivePhone(String receivePhone) {
            this.receivePhone = receivePhone;
        }

        public String getAddress() {
            return address;
        }

        public void setAddress(String address) {
            this.address = address;
        }

        public String getPostCode() {
            return postCode;
        }

        public void setPostCode(String postCode) {
            this.postCode = postCode;
        }
    }
}
