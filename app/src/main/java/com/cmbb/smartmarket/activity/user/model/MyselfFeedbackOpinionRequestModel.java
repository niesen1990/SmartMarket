package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 上午11:09
 * 修改人：N.Sun
 * 修改时间：16/5/25 上午11:09
 * 修改备注：
 */
public class MyselfFeedbackOpinionRequestModel extends RetrofitRequestModel {

    /**
     * contents : test
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String contents;

        public ParametersEntity(String contents) {
            this.contents = contents;
        }

        public String getContents() {
            return contents;
        }

        public void setContents(String contents) {
            this.contents = contents;
        }
    }
}
