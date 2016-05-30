package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/23 下午12:00
 * 修改人：N.Sun
 * 修改时间：16/5/23 下午12:00
 * 修改备注：
 */
public class MarketHomeAdvertInfoRequestModel extends RetrofitRequestModel {

    /**
     * adType : INDEX
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String adType;

        public String getAdType() {
            return adType;
        }

        public void setAdType(String adType) {
            this.adType = adType;
        }
    }
}
