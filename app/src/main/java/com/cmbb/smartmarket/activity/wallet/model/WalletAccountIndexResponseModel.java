package com.cmbb.smartmarket.activity.wallet.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 上午10:32
 * 修改人：N.Sun
 * 修改时间：16/5/19 上午10:32
 * 修改备注：
 */
public class WalletAccountIndexResponseModel{

    /**
     * userId : 2
     * balance : 20
     * prePayment : 0
     * createDate : 2016-05-04 17:37:36
     * createUserId : 2
     * updateDate : 2016-05-05 17:30:41
     * updateUserId : 2
     */

    private DataEntity data;
    /**
     * data : {"userId":2,"balance":20,"prePayment":0,"createDate":"2016-05-04 17:37:36","createUserId":2,"updateDate":"2016-05-05 17:30:41","updateUserId":2}
     * msg : 加载成功
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
        private int userId;
        private int balance;
        private int prePayment;
        private String createDate;
        private int createUserId;
        private String updateDate;
        private int updateUserId;

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public int getBalance() {
            return balance;
        }

        public void setBalance(int balance) {
            this.balance = balance;
        }

        public int getPrePayment() {
            return prePayment;
        }

        public void setPrePayment(int prePayment) {
            this.prePayment = prePayment;
        }

        public String getCreateDate() {
            return createDate;
        }

        public void setCreateDate(String createDate) {
            this.createDate = createDate;
        }

        public int getCreateUserId() {
            return createUserId;
        }

        public void setCreateUserId(int createUserId) {
            this.createUserId = createUserId;
        }

        public String getUpdateDate() {
            return updateDate;
        }

        public void setUpdateDate(String updateDate) {
            this.updateDate = updateDate;
        }

        public int getUpdateUserId() {
            return updateUserId;
        }

        public void setUpdateUserId(int updateUserId) {
            this.updateUserId = updateUserId;
        }
    }
}
