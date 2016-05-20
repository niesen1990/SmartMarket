package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 下午2:14
 * 修改人：N.Sun
 * 修改时间：16/5/19 下午2:14
 * 修改备注：
 */
public class SystemCodeInfoGetAllRequest extends RetrofitRequestModel {

    /**
     * typeCode : market_product_type
     * levelCount : 2
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
        private int levelCount;

        public ParametersEntity(String typeCode, int levelCount) {
            this.typeCode = typeCode;
            this.levelCount = levelCount;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }

        public int getLevelCount() {
            return levelCount;
        }

        public void setLevelCount(int levelCount) {
            this.levelCount = levelCount;
        }
    }
}
