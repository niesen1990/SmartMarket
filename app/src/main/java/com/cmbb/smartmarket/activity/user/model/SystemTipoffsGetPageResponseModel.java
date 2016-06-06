package com.cmbb.smartmarket.activity.user.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/6 上午11:56
 * 修改人：N.Sun
 * 修改时间：16/6/6 上午11:56
 * 修改备注：
 */
public class SystemTipoffsGetPageResponseModel {

    /**
     * data : [{"name":"广告骚扰","value":"1","typeCode":"tipoffReason"},{"name":"政治敏感","value":"2","typeCode":"tipoffReason"},{"name":"违法（暴力恐怖、违禁品等）","value":"3","typeCode":"tipoffReason"},{"name":"其他","value":"4","typeCode":"tipoffReason"}]
     * msg : 操作成功
     */

    private String msg;
    /**
     * name : 广告骚扰
     * value : 1
     * typeCode : tipoffReason
     */

    private List<DataEntity> data;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public List<DataEntity> getData() {
        return data;
    }

    public void setData(List<DataEntity> data) {
        this.data = data;
    }

    public static class DataEntity {
        private String name;
        private String value;
        private String typeCode;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getTypeCode() {
            return typeCode;
        }

        public void setTypeCode(String typeCode) {
            this.typeCode = typeCode;
        }
    }
}

