package com.cmbb.smartmarket.activity.wallet.model;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/12 上午10:54
 * 修改人：N.Sun
 * 修改时间：16/6/12 上午10:54
 * 修改备注：
 */
public class WalletAccountBillListRequestModel extends RetrofitRequestModel {

    /**
     * type : CASH
     * pageNo : 0
     * numberOfPerPage : 5
     */

    private ParametersEntity parameters;

    public ParametersEntity getParameters() {
        return parameters;
    }

    public void setParameters(ParametersEntity parameters) {
        this.parameters = parameters;
    }

    public static class ParametersEntity {
        private String type;
        private int pageNo;
        private int numberOfPerPage;

        public ParametersEntity(String type, int pageNo, int numberOfPerPage) {
            this.type = type;
            this.pageNo = pageNo;
            this.numberOfPerPage = numberOfPerPage;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public int getPageNo() {
            return pageNo;
        }

        public void setPageNo(int pageNo) {
            this.pageNo = pageNo;
        }

        public int getNumberOfPerPage() {
            return numberOfPerPage;
        }

        public void setNumberOfPerPage(int numberOfPerPage) {
            this.numberOfPerPage = numberOfPerPage;
        }
    }
}
