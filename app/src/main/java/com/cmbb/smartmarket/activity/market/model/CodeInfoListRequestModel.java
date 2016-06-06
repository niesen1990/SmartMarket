package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午9:41
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午9:41
 * 修改备注：
 */
public class CodeInfoListRequestModel extends RetrofitRequestModel {

    /**
     * typeCode : market_product_type
     * parentCode : MMYP
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
        private String parentCode;

        public ParametersEntity(String typeCode, String parentCode) {
            this.typeCode = typeCode;
            this.parentCode = parentCode;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }
    }
}
