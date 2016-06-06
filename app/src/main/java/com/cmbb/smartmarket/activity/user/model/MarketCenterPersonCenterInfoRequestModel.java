package com.cmbb.smartmarket.activity.user.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/2 下午3:25
 * 修改人：N.Sun
 * 修改时间：16/6/2 下午3:25
 * 修改备注：
 */
public class MarketCenterPersonCenterInfoRequestModel extends RetrofitRequestModel {

    /**
     * userId : 3
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int userId;

        public ParametersEntity(int userId) {
            this.userId = userId;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }
    }
}
