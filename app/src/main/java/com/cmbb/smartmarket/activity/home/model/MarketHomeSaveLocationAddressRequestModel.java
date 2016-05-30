package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/23 上午10:49
 * 修改人：N.Sun
 * 修改时间：16/5/23 上午10:49
 * 修改备注：
 */
public class MarketHomeSaveLocationAddressRequestModel extends RetrofitRequestModel {

    /**
     * locationJosnStr :
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String locationJosnStr;

        public ParametersEntity(String locationJosnStr) {
            this.locationJosnStr = locationJosnStr;
        }

        public String getLocationJosnStr() {
            return locationJosnStr;
        }

        public void setLocationJosnStr(String locationJosnStr) {
            this.locationJosnStr = locationJosnStr;
        }
    }
}
