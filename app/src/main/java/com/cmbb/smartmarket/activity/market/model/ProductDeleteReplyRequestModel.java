package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:04
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:04
 * 修改备注：
 */
public class ProductDeleteReplyRequestModel extends RetrofitRequestModel {

    /**
     * replyId : 1
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int replyId;

        public ParametersEntity(int replyId) {
            this.replyId = replyId;
        }

        public int getReplyId() {
            return replyId;
        }

        public void setReplyId(int replyId) {
            this.replyId = replyId;
        }
    }
}
