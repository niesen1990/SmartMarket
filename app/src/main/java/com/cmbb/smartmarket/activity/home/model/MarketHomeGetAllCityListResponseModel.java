package com.cmbb.smartmarket.activity.home.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/23 上午11:26
 * 修改人：N.Sun
 * 修改时间：16/5/23 上午11:26
 * 修改备注：
 */
public class MarketHomeGetAllCityListResponseModel {

    private DataEntity data;
    /**
     * data : {"allCity":[{"name":"A","arrays":[{"name":"阿坝藏族羌族自治州","code":"513200","level":2,"parentId":2293,"parentProvinceCity":"","parentCode":"510000","type":"2","phoneticize":"abazangzuqiangzuzizhizhou","pinyinSort":"A"}]}]}
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
         * name : A
         * arrays : [{"name":"阿坝藏族羌族自治州","code":"513200","level":2,"parentId":2293,"parentProvinceCity":"","parentCode":"510000","type":"2","phoneticize":"abazangzuqiangzuzizhizhou","pinyinSort":"A"}]
         */

        private List<AllCityEntity> allCity;

        public List<AllCityEntity> getAllCity() {
            return allCity;
        }

        public void setAllCity(List<AllCityEntity> allCity) {
            this.allCity = allCity;
        }

        public static class AllCityEntity {
            private String name;
            /**
             * name : 阿坝藏族羌族自治州
             * code : 513200
             * level : 2
             * parentId : 2293
             * parentProvinceCity :
             * parentCode : 510000
             * type : 2
             * phoneticize : abazangzuqiangzuzizhizhou
             * pinyinSort : A
             */

            private List<ArraysEntity> arrays;

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public List<ArraysEntity> getArrays() {
                return arrays;
            }

            public void setArrays(List<ArraysEntity> arrays) {
                this.arrays = arrays;
            }

            public static class ArraysEntity {
                private String name;
                private String code;
                private int level;
                private int parentId;
                private String parentProvinceCity;
                private String parentCode;
                private String type;
                private String phoneticize;
                private String pinyinSort;

                public String getName() {
                    return name;
                }

                public void setName(String name) {
                    this.name = name;
                }

                public String getCode() {
                    return code;
                }

                public void setCode(String code) {
                    this.code = code;
                }

                public int getLevel() {
                    return level;
                }

                public void setLevel(int level) {
                    this.level = level;
                }

                public int getParentId() {
                    return parentId;
                }

                public void setParentId(int parentId) {
                    this.parentId = parentId;
                }

                public String getParentProvinceCity() {
                    return parentProvinceCity;
                }

                public void setParentProvinceCity(String parentProvinceCity) {
                    this.parentProvinceCity = parentProvinceCity;
                }

                public String getParentCode() {
                    return parentCode;
                }

                public void setParentCode(String parentCode) {
                    this.parentCode = parentCode;
                }

                public String getType() {
                    return type;
                }

                public void setType(String type) {
                    this.type = type;
                }

                public String getPhoneticize() {
                    return phoneticize;
                }

                public void setPhoneticize(String phoneticize) {
                    this.phoneticize = phoneticize;
                }

                public String getPinyinSort() {
                    return pinyinSort;
                }

                public void setPinyinSort(String pinyinSort) {
                    this.pinyinSort = pinyinSort;
                }
            }
        }
    }
}
