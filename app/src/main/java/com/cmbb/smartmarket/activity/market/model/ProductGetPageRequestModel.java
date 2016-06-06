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

        // 刷选
        private String parentClassify;
        private String secondClassify;
        private String city;
        private String beginPrice;
        private String endPrice;

        private String isProductRecommoned;

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

        public ParametersEntity(int numberOfPerPage, int pageNo, int type) {
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
            this.type = type;
        }

        public ParametersEntity(int numberOfPerPage, int pageNo, int type, String city) {
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
            this.type = type;
            if (!TextUtils.isEmpty(city))
                this.city = city;
        }

        public ParametersEntity(int numberOfPerPage, int pageNo, String parentClassify, String secondClassify, String city, String beginPrice, String endPrice, String sortType) {
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
            this.parentClassify = parentClassify;
            this.secondClassify = secondClassify;
            this.city = city;
            this.beginPrice = beginPrice;
            this.endPrice = endPrice;
            this.sortType = sortType;
        }

        public ParametersEntity(int type, String isProductRecommoned, int numberOfPerPage, int pageNo) {
            this.type = type;
            this.isProductRecommoned = isProductRecommoned;
            this.numberOfPerPage = numberOfPerPage;
            this.pageNo = pageNo;
        }

        public String getIsProductRecommoned() {
            return isProductRecommoned;
        }

        public void setIsProductRecommoned(String isProductRecommoned) {
            this.isProductRecommoned = isProductRecommoned;
        }

        public String getParentClassify() {
            return parentClassify;
        }

        public void setParentClassify(String parentClassify) {
            this.parentClassify = parentClassify;
        }

        public String getSecondClassify() {
            return secondClassify;
        }

        public void setSecondClassify(String secondClassify) {
            this.secondClassify = secondClassify;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getBeginPrice() {
            return beginPrice;
        }

        public void setBeginPrice(String beginPrice) {
            this.beginPrice = beginPrice;
        }

        public String getEndPrice() {
            return endPrice;
        }

        public void setEndPrice(String endPrice) {
            this.endPrice = endPrice;
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
