package com.cmbb.smartmarket.activity.address.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午11:35
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午11:35
 * 修改备注：
 */
public class UserAddressDeleteRequestModel extends RetrofitRequestModel {

    /**
     * id : 62
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

        public ParametersEntity(int id) {
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
