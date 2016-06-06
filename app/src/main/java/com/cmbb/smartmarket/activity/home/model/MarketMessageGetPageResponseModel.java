package com.cmbb.smartmarket.activity.home.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/5 下午5:06
 * 修改人：N.Sun
 * 修改时间：16/6/5 下午5:06
 * 修改备注：
 */
public class MarketMessageGetPageResponseModel  {

    /**
     * content : [{"id":699,"modual":"order","title":"购买通知","contents":"你的商品已经被购买，订单号：0017777027294830","img":"http://smart-test.image.alimmdn.com/market/product/image/2016-06-02/NDA2MTJjMTktZWVhOC00ZjUyLTk4ZjYtMzFjNjAzNzYyYjJk","extraData":"","imgWidth":2322,"createDate":"2016-06-02 15:16:10","relateField":"120","imgHeight":4128}]
     * last : true
     * totalElements : 2
     * totalPages : 1
     * sort : 1
     * first : true
     * numberOfElements : 2
     * size : 5
     * number : 0
     */

    private DataEntity data;
    /**
     * data : {"content":[{"id":699,"modual":"order","title":"购买通知","contents":"你的商品已经被购买，订单号：0017777027294830","img":"http://smart-test.image.alimmdn.com/market/product/image/2016-06-02/NDA2MTJjMTktZWVhOC00ZjUyLTk4ZjYtMzFjNjAzNzYyYjJk","extraData":"","imgWidth":2322,"createDate":"2016-06-02 15:16:10","relateField":"120","imgHeight":4128}],"last":true,"totalElements":2,"totalPages":1,"sort":1,"first":true,"numberOfElements":2,"size":5,"number":0}
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
        private boolean last;
        private int totalElements;
        private int totalPages;
        private int sort;
        private boolean first;
        private int numberOfElements;
        private int size;
        private int number;
        /**
         * id : 699
         * modual : order
         * title : 购买通知
         * contents : 你的商品已经被购买，订单号：0017777027294830
         * img : http://smart-test.image.alimmdn.com/market/product/image/2016-06-02/NDA2MTJjMTktZWVhOC00ZjUyLTk4ZjYtMzFjNjAzNzYyYjJk
         * extraData :
         * imgWidth : 2322.0
         * createDate : 2016-06-02 15:16:10
         * relateField : 120
         * imgHeight : 4128.0
         */

        private List<ContentEntity> content;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public int getSize() {
            return size;
        }

        public void setSize(int size) {
            this.size = size;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity {
            private int id;
            private String modual;
            private String title;
            private String contents;
            private String img;
            private String extraData;
            private double imgWidth;
            private String createDate;
            private String relateField;
            private double imgHeight;

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

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public String getImg() {
                return img;
            }

            public void setImg(String img) {
                this.img = img;
            }

            public String getExtraData() {
                return extraData;
            }

            public void setExtraData(String extraData) {
                this.extraData = extraData;
            }

            public double getImgWidth() {
                return imgWidth;
            }

            public void setImgWidth(double imgWidth) {
                this.imgWidth = imgWidth;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public String getRelateField() {
                return relateField;
            }

            public void setRelateField(String relateField) {
                this.relateField = relateField;
            }

            public double getImgHeight() {
                return imgHeight;
            }

            public void setImgHeight(double imgHeight) {
                this.imgHeight = imgHeight;
            }
        }
    }
}
