package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/30 下午2:42
 * 修改人：N.Sun
 * 修改时间：16/5/30 下午2:42
 * 修改备注：
 */
public class MarketOrderSellerSendRequestModel extends RetrofitRequestModel {

    /**
     * id : 7
     * express : ems
     * expressNum : 1030486038880
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int id;
        private String express;
        private String expressNum;

        public ParametersEntity(int id, String express, String expressNum) {
            this.id = id;
            this.express = express;
            this.expressNum = expressNum;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getExpress() {
            return express;
        }

        public void setExpress(String express) {
            this.express = express;
        }

        public String getExpressNum() {
            return expressNum;
        }

        public void setExpressNum(String expressNum) {
            this.expressNum = expressNum;
        }
    }
}
