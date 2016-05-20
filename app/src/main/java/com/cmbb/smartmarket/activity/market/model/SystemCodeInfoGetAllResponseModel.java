package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 下午2:14
 * 修改人：N.Sun
 * 修改时间：16/5/19 下午2:14
 * 修改备注：
 */
public class SystemCodeInfoGetAllResponseModel  {

    /**
     * msg : 操作成功
     * data : [{"code":"MMYP","value":"MMYP","name":"妈妈用品","childCodeInfoList":[{"name":"服装","value":"MMYP_FZ","code":"MMYP_FZ"}]}]
     */

    private String msg;
    /**
     * code : MMYP
     * value : MMYP
     * name : 妈妈用品
     * childCodeInfoList : [{"name":"服装","value":"MMYP_FZ","code":"MMYP_FZ"}]
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
        private String code;
        private String value;
        private String name;
        /**
         * name : 服装
         * value : MMYP_FZ
         * code : MMYP_FZ
         */

        private List<ChildCodeInfoListEntity> childCodeInfoList;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public List<ChildCodeInfoListEntity> getChildCodeInfoList() {
            return childCodeInfoList;
        }

        public void setChildCodeInfoList(List<ChildCodeInfoListEntity> childCodeInfoList) {
            this.childCodeInfoList = childCodeInfoList;
        }

        public static class ChildCodeInfoListEntity {
            private String name;
            private String value;
            private String code;

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

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }
        }
    }
}
