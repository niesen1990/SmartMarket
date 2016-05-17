package com.cmbb.smartmarket.activity.address.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:52
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:52
 * 修改备注：
 */
public class UserAddressGetPageRequestModel extends RetrofitRequestModel {

    /**
     * numberOfPerPage : 0
     * pageNo : 1
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private int numberOfPerPage;
        private int pageNo;

        public ParametersEntity(int pageNo,int numberOfPerPage ) {
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public int getNumberOfPerPage() {
            return numberOfPerPage;
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
    }
}
