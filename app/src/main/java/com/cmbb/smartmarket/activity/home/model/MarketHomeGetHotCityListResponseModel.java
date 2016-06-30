package com.cmbb.smartmarket.activity.home.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/24 上午10:44
 * 修改人：N.Sun
 * 修改时间：16/5/24 上午10:44
 * 修改备注：
 */
public class MarketHomeGetHotCityListResponseModel{

    private DataEntity data;
    /**
     * data : {"hotCity":[{"id":7,"dictKey":"110000","name":"北京","value":"110000","typeCode":"city","typeName":"city","enabled":true,"sortNumber":1,"remark":"","creatorId":1,"createTime":"2015-10-08 17:12:24","modifierId":1,"modifyTime":"2015-10-16 14:20:56"},{"id":11,"dictKey":"120000","name":"天津","value":"120000","typeCode":"city","typeName":"city","enabled":true,"sortNumber":1,"remark":"","creatorId":1,"createTime":"2015-10-08 17:14:38","modifierId":"","modifyTime":""},{"id":14,"dictKey":"310000","name":"上海","value":"310000","typeCode":"city","typeName":"city","enabled":true,"sortNumber":1,"remark":"","creatorId":1,"createTime":"2015-10-08 17:16:44","modifierId":"","modifyTime":""},{"id":37,"dictKey":"440000","name":"广东","value":"440000","typeCode":"city","typeName":"city","enabled":true,"sortNumber":1,"remark":"","creatorId":1,"createTime":"2015-10-15 15:47:47","modifierId":"","modifyTime":""}]}
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
         * id : 7
         * dictKey : 110000
         * name : 北京
         * value : 110000
         * typeCode : city
         * typeName : city
         * enabled : true
         * sortNumber : 1
         * remark :
         * creatorId : 1
         * createTime : 2015-10-08 17:12:24
         * modifierId : 1
         * modifyTime : 2015-10-16 14:20:56
         */

        private List<HotCityEntity> hotCity;

        public List<HotCityEntity> getHotCity() {
            return hotCity;
        }

        public void setHotCity(List<HotCityEntity> hotCity) {
            this.hotCity = hotCity;
        }

        public static class HotCityEntity {
            private int id;
            private String dictKey;
            private String name;
            private String value;
            private String typeCode;
            private String typeName;
            private boolean enabled;
            private int sortNumber;
            private String remark;
            private int creatorId;
            private String createTime;
            private int modifierId;
            private String modifyTime;

            public HotCityEntity(String name) {
                this.name = name;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getDictKey() {
                return dictKey;
            }

            public void setDictKey(String dictKey) {
                this.dictKey = dictKey;
            }

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

            public String getTypeName() {
                return typeName;
            }

            public void setTypeName(String typeName) {
                this.typeName = typeName;
            }

            public boolean isEnabled() {
                return enabled;
            }

            public void setEnabled(boolean enabled) {
                this.enabled = enabled;
            }

            public int getSortNumber() {
                return sortNumber;
            }

            public void setSortNumber(int sortNumber) {
                this.sortNumber = sortNumber;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getCreatorId() {
                return creatorId;
            }

            public void setCreatorId(int creatorId) {
                this.creatorId = creatorId;
            }

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getModifierId() {
                return modifierId;
            }

            public void setModifierId(int modifierId) {
                this.modifierId = modifierId;
            }

            public String getModifyTime() {
                return modifyTime;
            }

            public void setModifyTime(String modifyTime) {
                this.modifyTime = modifyTime;
            }
        }
    }
}
