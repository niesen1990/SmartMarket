package com.cmbb.smartmarket.activity.address.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/2 下午6:45
 * 修改人：N.Sun
 * 修改时间：16/6/2 下午6:45
 * 修改备注：
 */
public class ProvinceCityGetAllRequestModel extends RetrofitRequestModel {

    /**
     * parentCode : 0
     * levelCount : 1
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String parentCode;
        private int levelCount;

        public ParametersEntity(String parentCode, int levelCount) {
            this.parentCode = parentCode;
            this.levelCount = levelCount;
        }

        public String getParentCode() {
            return parentCode;
        }

        public void setParentCode(String parentCode) {
            this.parentCode = parentCode;
        }

        public int getLevelCount() {
            return levelCount;
        }

        public void setLevelCount(int levelCount) {
            this.levelCount = levelCount;
        }
    }
}
