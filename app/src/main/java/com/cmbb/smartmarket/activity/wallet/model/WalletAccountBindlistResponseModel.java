package com.cmbb.smartmarket.activity.wallet.model;

import android.os.Parcel;
import android.os.Parcelable;

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
public class WalletAccountBindListResponseModel {

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

    public static class DataEntity implements Parcelable {
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

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.cardType);
            dest.writeString(this.cardUsername);
            dest.writeString(this.cardCode);
            dest.writeByte(this.isDefault ? (byte) 1 : (byte) 0);
            dest.writeString(this.phone);
            dest.writeString(this.createDate);
            dest.writeInt(this.createUserId);
        }

        public DataEntity() {
        }

        protected DataEntity(Parcel in) {
            this.cardType = in.readString();
            this.cardUsername = in.readString();
            this.cardCode = in.readString();
            this.isDefault = in.readByte() != 0;
            this.phone = in.readString();
            this.createDate = in.readString();
            this.createUserId = in.readInt();
        }

        public static final Parcelable.Creator<DataEntity> CREATOR = new Parcelable.Creator<DataEntity>() {
            @Override
            public DataEntity createFromParcel(Parcel source) {
                return new DataEntity(source);
            }

            @Override
            public DataEntity[] newArray(int size) {
                return new DataEntity[size];
            }
        };
    }
}
