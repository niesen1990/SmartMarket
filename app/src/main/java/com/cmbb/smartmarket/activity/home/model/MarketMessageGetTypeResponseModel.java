package com.cmbb.smartmarket.activity.home.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/24 上午11:06
 * 修改人：N.Sun
 * 修改时间：16/5/24 上午11:06
 * 修改备注：
 */
public class MarketMessageGetTypeResponseModel {

    /**
     * data : [{"id":64771,"noticeContent":"","modual":"system","noticeCount":0}]
     * msg : 数据加载成功
     */

    private String msg;
    /**
     * id : 64771
     * noticeContent :
     * modual : system
     * noticeCount : 0
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
        private int id;
        private String noticeContent;
        private String modual;
        private int noticeCount;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getNoticeContent() {
            return noticeContent;
        }

        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }

        public String getModual() {
            return modual;
        }

        public void setModual(String modual) {
            this.modual = modual;
        }

        public int getNoticeCount() {
            return noticeCount;
        }

        public void setNoticeCount(int noticeCount) {
            this.noticeCount = noticeCount;
        }
    }
}
