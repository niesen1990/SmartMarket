package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:19
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:19
 * 修改备注：
 */
public class SystemDictListRequestModel extends RetrofitRequestModel {

    /**
     * typeCode : product_filtrate_ask_to_buy
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String typeCode;

        public ParametersEntity(String typeCode) {
            this.typeCode = typeCode;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }
    }
}
