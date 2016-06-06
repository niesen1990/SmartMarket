package com.cmbb.smartmarket.activity.address.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/17 上午10:52
 * 修改人：N.Sun
 * 修改时间：16/5/17 上午10:52
 * 修改备注：
 */
public class UserAddressGetPageResponseModel {

    private DataEntity data;
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
        private int page;
        private int records;
        private int total;
        /**
         * id : 73
         * userRelationId : 101033
         * receiveName : 测试2
         * receivePhone : 15201921714
         * postCode : 224021
         * province : 150000
         * city : 150100
         * district : 150102
         * address : 世界级上课上课
         * isDefault : 0
         * isDelete : 0
         * createDate : 2016-04-07 11:38:24
         * createUserId : 101033
         * updateDate : 2016-04-15 14:23:28
         * updateUserId : 101033
         * provinceText : 内蒙古自治区
         * cityText : 呼和浩特市
         * districtText : 新城区
         */

        private List<RowsEntity> rows;

        public int getPage() {
            return page;
        }

        public void setPage(int page) {
            this.page = page;
        }

        public int getRecords() {
            return records;
        }

        public void setRecords(int records) {
            this.records = records;
        }

        public int getTotal() {
            return total;
        }

        public void setTotal(int total) {
            this.total = total;
        }

        public List<RowsEntity> getRows() {
            return rows;
        }

        public void setRows(List<RowsEntity> rows) {
            this.rows = rows;
        }

        public static class RowsEntity implements Parcelable {
            private int id;
            private int userRelationId;
            private String receiveName;
            private String receivePhone;
            private String postCode;
            private int province;
            private int city;
            private int district;
            private String address;
            private int isDefault;
            private int isDelete;
            private String createDate;
            private int createUserId;
            private String updateDate;
            private int updateUserId;
            private String provinceText;
            private String cityText;
            private String districtText;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getUserRelationId() {
                return userRelationId;
            }

            public void setUserRelationId(int userRelationId) {
                this.userRelationId = userRelationId;
            }

            public String getReceiveName() {
                return receiveName;
            }

            public void setReceiveName(String receiveName) {
                this.receiveName = receiveName;
            }

            public String getReceivePhone() {
                return receivePhone;
            }

            public void setReceivePhone(String receivePhone) {
                this.receivePhone = receivePhone;
            }

            public String getPostCode() {
                return postCode;
            }

            public void setPostCode(String postCode) {
                this.postCode = postCode;
            }

            public int getProvince() {
                return province;
            }

            public void setProvince(int province) {
                this.province = province;
            }

            public int getCity() {
                return city;
            }

            public void setCity(int city) {
                this.city = city;
            }

            public int getDistrict() {
                return district;
            }

            public void setDistrict(int district) {
                this.district = district;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getIsDefault() {
                return isDefault;
            }

            public void setIsDefault(int isDefault) {
                this.isDefault = isDefault;
            }

            public int getIsDelete() {
                return isDelete;
            }

            public void setIsDelete(int isDelete) {
                this.isDelete = isDelete;
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

            public String getProvinceText() {
                return provinceText;
            }

            public void setProvinceText(String provinceText) {
                this.provinceText = provinceText;
            }

            public String getCityText() {
                return cityText;
            }

            public void setCityText(String cityText) {
                this.cityText = cityText;
            }

            public String getDistrictText() {
                return districtText;
            }

            public void setDistrictText(String districtText) {
                this.districtText = districtText;
            }

            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeInt(this.userRelationId);
                dest.writeString(this.receiveName);
                dest.writeString(this.receivePhone);
                dest.writeString(this.postCode);
                dest.writeInt(this.province);
                dest.writeInt(this.city);
                dest.writeInt(this.district);
                dest.writeString(this.address);
                dest.writeInt(this.isDefault);
                dest.writeInt(this.isDelete);
                dest.writeString(this.createDate);
                dest.writeInt(this.createUserId);
                dest.writeString(this.updateDate);
                dest.writeInt(this.updateUserId);
                dest.writeString(this.provinceText);
                dest.writeString(this.cityText);
                dest.writeString(this.districtText);
            }

            public RowsEntity() {
            }

            protected RowsEntity(Parcel in) {
                this.id = in.readInt();
                this.userRelationId = in.readInt();
                this.receiveName = in.readString();
                this.receivePhone = in.readString();
                this.postCode = in.readString();
                this.province = in.readInt();
                this.city = in.readInt();
                this.district = in.readInt();
                this.address = in.readString();
                this.isDefault = in.readInt();
                this.isDelete = in.readInt();
                this.createDate = in.readString();
                this.createUserId = in.readInt();
                this.updateDate = in.readString();
                this.updateUserId = in.readInt();
                this.provinceText = in.readString();
                this.cityText = in.readString();
                this.districtText = in.readString();
            }

            public static final Parcelable.Creator<RowsEntity> CREATOR = new Parcelable.Creator<RowsEntity>() {
                @Override
                public RowsEntity createFromParcel(Parcel source) {
                    return new RowsEntity(source);
                }

                @Override
                public RowsEntity[] newArray(int size) {
                    return new RowsEntity[size];
                }
            };
        }

        @Override
        public String toString() {
            return "DataEntity{" +
                    "page=" + page +
                    ", records=" + records +
                    ", total=" + total +
                    ", rows=" + rows +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ResponseEntity{" +
                "data=" + data +
                ", msg='" + msg + '\'' +
                '}';
    }

}
