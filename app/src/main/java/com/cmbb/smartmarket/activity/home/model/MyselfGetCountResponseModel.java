package com.cmbb.smartmarket.activity.home.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 上午10:23
 * 修改人：N.Sun
 * 修改时间：16/5/25 上午10:23
 * 修改备注：
 */
public class MyselfGetCountResponseModel {

    /**
     * productCollectCount : 1
     * productSoldCount : 3
     * productBoughtCount : 0
     * productPublicCount : 12
     */

    private DataEntity data;
    /**
     * data : {"productCollectCount":1,"productSoldCount":3,"productBoughtCount":0,"productPublicCount":12}
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
        private int productCollectCount;
        private int productSoldCount;
        private int productBoughtCount;
        private int productPublicCount;

        public int getProductCollectCount() {
            return productCollectCount;
        }

        public void setProductCollectCount(int productCollectCount) {
            this.productCollectCount = productCollectCount;
        }

        public int getProductSoldCount() {
            return productSoldCount;
        }

        public void setProductSoldCount(int productSoldCount) {
            this.productSoldCount = productSoldCount;
        }

        public int getProductBoughtCount() {
            return productBoughtCount;
        }

        public void setProductBoughtCount(int productBoughtCount) {
            this.productBoughtCount = productBoughtCount;
        }

        public int getProductPublicCount() {
            return productPublicCount;
        }

        public void setProductPublicCount(int productPublicCount) {
            this.productPublicCount = productPublicCount;
        }
    }
}
