package com.cmbb.smartmarket.activity.home.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/3 上午11:01
 * 修改人：N.Sun
 * 修改时间：16/6/3 上午11:01
 * 修改备注：
 */
public class MarketHomeGetScreenResponseModel {

    private DataEntity data;
    /**
     * data : {"priceClassify":[{"value":"beginPrice","name":"开始区间"},{"value":"endPrice","name":"结束区间"}],"intelligentClassify":[{"value":"high_price","name":"价格最高"},{"value":"lowe_price","name":"价格最低"},{"value":"new_publish","name":"最新发布"}]}
     * msg : 数据加载成功
     */

    private String msg;

    public DataEntity getData() {
        return data;
    }

    public void setData(DataEntity data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public static class DataEntity {
        /**
         * value : beginPrice
         * name : 开始区间
         */

        private List<PriceClassifyEntity> priceClassify;
        /**
         * value : high_price
         * name : 价格最高
         */

        private List<IntelligentClassifyEntity> intelligentClassify;

        public List<PriceClassifyEntity> getPriceClassify() {
            return priceClassify;
        }

        public void setPriceClassify(List<PriceClassifyEntity> priceClassify) {
            this.priceClassify = priceClassify;
        }

        public List<IntelligentClassifyEntity> getIntelligentClassify() {
            return intelligentClassify;
        }

        public void setIntelligentClassify(List<IntelligentClassifyEntity> intelligentClassify) {
            this.intelligentClassify = intelligentClassify;
        }

        public static class PriceClassifyEntity {
            private String value;
            private String name;

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

            @Override
            public String toString() {
                return name;
            }
        }

        public static class IntelligentClassifyEntity {
            private String value;
            private String name;

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

            @Override
            public String toString() {
                return name;
            }
        }
    }
}
