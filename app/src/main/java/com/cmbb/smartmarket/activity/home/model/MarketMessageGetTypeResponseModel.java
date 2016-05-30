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
     * data : [{"noticeContent":"官方测试消息","id":32277,"modual":"system","noticeCount":54},{"noticeContent":"商品回复消息","id":32278,"modual":"product","noticeCount":3},{"noticeContent":"订单动态消息","id":32279,"modual":"order","noticeCount":10}]
     * msg : 数据加载成功
     */

    private String msg;
    /**
     * noticeContent : 官方测试消息
     * id : 32277
     * modual : system
     * noticeCount : 54
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
        private String noticeContent;
        private int id;
        private String modual;
        private int noticeCount;

        public String getNoticeContent() {
            return noticeContent;
        }

        public void setNoticeContent(String noticeContent) {
            this.noticeContent = noticeContent;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
