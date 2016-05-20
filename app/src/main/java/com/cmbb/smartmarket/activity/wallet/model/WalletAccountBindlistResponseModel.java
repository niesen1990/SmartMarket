package com.cmbb.smartmarket.activity.wallet.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 上午10:46
 * 修改人：N.Sun
 * 修改时间：16/5/19 上午10:46
 * 修改备注：
 */
public class WalletAccountBindlistResponseModel{

    /**
     * data : [{"cardType":"支付宝","cardUsername":"213","cardCode":"18684711220","isDefault":true,"phone":"18684711220","createDate":"2016-05-04 19:28:07","createUserId":2}]
     * msg : 加载成功
     */

    private String msg;
    /**
     * cardType : 支付宝
     * cardUsername : 213
     * cardCode : 18684711220
     * isDefault : true
     * phone : 18684711220
     * createDate : 2016-05-04 19:28:07
     * createUserId : 2
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
        private String cardType;
        private String cardUsername;
        private String cardCode;
        private boolean isDefault;
        private String phone;
        private String createDate;
        private int createUserId;

        public String getCardType() {
            return cardType;
        }

        public void setCardType(String cardType) {
            this.cardType = cardType;
        }

        public String getCardUsername() {
            return cardUsername;
        }

        public void setCardUsername(String cardUsername) {
            this.cardUsername = cardUsername;
        }

        public String getCardCode() {
            return cardCode;
        }

        public void setCardCode(String cardCode) {
            this.cardCode = cardCode;
        }

        public boolean isIsDefault() {
            return isDefault;
        }

        public void setIsDefault(boolean isDefault) {
            this.isDefault = isDefault;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
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
    }
}
