package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/5 下午5:06
 * 修改人：N.Sun
 * 修改时间：16/6/5 下午5:06
 * 修改备注：
 */
public class MarketMessageGetPageRequestModel extends RetrofitRequestModel {

    /**
     * modual : product
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String modual;
        private int numberOfPerPage;
        private int pageNo;

        public int getNumberOfPerPage() {
            return numberOfPerPage;
        }

        public ParametersEntity(String modual, int numberOfPerPage, int pageNo) {
            this.modual = modual;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public void setNumberOfPerPage(int numberOfPerPage) {
            this.numberOfPerPage = numberOfPerPage;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }


        public String getModual() {
            return modual;
        }

        public void setModual(String modual) {
            this.modual = modual;
        }
    }
}
