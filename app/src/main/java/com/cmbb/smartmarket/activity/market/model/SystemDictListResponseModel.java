package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:19
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:19
 * 修改备注：
 */
public class SystemDictListResponseModel {

    /**
     * data : [{"remark":"sortType","name":"最新发布","value":"new_publish"},{"remark":"sortType","name":"浏览最多","value":"most_browsenumber"},{"remark":"isResolve","name":"已解决","value":"1"},{"remark":"isResolve","name":"未解决","value":"0"}]
     * msg : 操作成功
     */

    private String msg;
    /**
     * remark : sortType
     * name : 最新发布
     * value : new_publish
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
        private String remark;
        private String name;
        private String value;

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
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
    }
}
