package com.cmbb.smartmarket.activity.market.model;

import android.text.TextUtils;

import com.cmbb.smartmarket.network.RetrofitRequestModel;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:09
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:09
 * 修改备注：
 */
public class ProductGetPageRequestModel extends RetrofitRequestModel {

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
        private int type;
        private String sortType;
        private String isResolve;

        public ParametersEntity(int numberOfPerPage, int pageNo, int type, String spinnerType, String value) {
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
            this.type = type;
            if (TextUtils.isEmpty(spinnerType))
                return;
            if (spinnerType.equals("sortType")) {
                this.sortType = value;
            } else {
                this.isResolve = value;
            }
        }

        public String getSortType() {
            return sortType;
        }

        public void setSortType(String sortType) {
            this.sortType = sortType;
        }

        public String getIsResolve() {
            return isResolve;
        }

        public void setIsResolve(String isResolve) {
            this.isResolve = isResolve;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
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
