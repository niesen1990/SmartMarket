package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 下午8:29
 * 修改人：N.Sun
 * 修改时间：16/5/25 下午8:29
 * 修改备注：
 */
public class ImageUploadResponseModel {

    /**
     * data : [{"businessNumber":"4028e4ed54e64a3c0154e64a3ccd0000","height":350,"width":1024,"isSuccess":true,"url":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-25/NjVmOWEzYzAtODNjNS00ZGQzLTlkOGQtOGVmNTc4MmVlZjQz"},{"businessNumber":"4028e4ed54e64a3c0154e64a3ccd0001","height":350,"width":1024,"isSuccess":true,"url":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-25/YWZiNzNhODItOTcxOC00YzkxLTlhNWQtNDAxN2U0MjZlMjAy"}]
     * msg : 操作成功
     */

    private String msg;
    /**
     * businessNumber : 4028e4ed54e64a3c0154e64a3ccd0000
     * height : 350
     * width : 1024
     * isSuccess : true
     * url : http://smart-test.image.alimmdn.com/market/product/image/2016-05-25/NjVmOWEzYzAtODNjNS00ZGQzLTlkOGQtOGVmNTc4MmVlZjQz
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
        private String businessNumber;
        private int height;
        private int width;
        private boolean isSuccess;
        private String url;

        public String getBusinessNumber() {
            return businessNumber;
        }

        public void setBusinessNumber(String businessNumber) {
            this.businessNumber = businessNumber;
        }

        public int getHeight() {
            return height;
        }

        public void setHeight(int height) {
            this.height = height;
        }

        public int getWidth() {
            return width;
        }

        public void setWidth(int width) {
            this.width = width;
        }

        public boolean isIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "businessNumber='" + businessNumber + '\'' +
                    ", height=" + height +
                    ", width=" + width +
                    ", isSuccess=" + isSuccess +
                    ", url='" + url + '\'' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ImageUploadResponseModel{" +
                "msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
