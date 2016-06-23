package com.cmbb.smartmarket.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/23 下午3:51
 * 修改人：N.Sun
 * 修改时间：16/6/23 下午3:51
 * 修改备注：
 */
public class UserLocation implements Parcelable {

    /**
     * id : 362
     * country : 中国
     * countryCode : 0
     * province : 上海市
     * city : 上海市
     * cityCode : 289
     * district : 杨浦区
     * street : 飞虹路
     * streetNumber : 568弄-20
     * address : 中国上海市杨浦区飞虹路568弄-20
     */

    private int id;
    private String country;
    private String countryCode;
    private String province;
    private String city;
    private String cityCode;
    private String district;
    private String street;
    private String streetNumber;
    private String address;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeString(this.country);
        dest.writeString(this.countryCode);
        dest.writeString(this.province);
        dest.writeString(this.city);
        dest.writeString(this.cityCode);
        dest.writeString(this.district);
        dest.writeString(this.street);
        dest.writeString(this.streetNumber);
        dest.writeString(this.address);
    }

    public UserLocation() {
    }

    protected UserLocation(Parcel in) {
        this.id = in.readInt();
        this.country = in.readString();
        this.countryCode = in.readString();
        this.province = in.readString();
        this.city = in.readString();
        this.cityCode = in.readString();
        this.district = in.readString();
        this.street = in.readString();
        this.streetNumber = in.readString();
        this.address = in.readString();
    }

    public static final Parcelable.Creator<UserLocation> CREATOR = new Parcelable.Creator<UserLocation>() {
        @Override
        public UserLocation createFromParcel(Parcel source) {
            return new UserLocation(source);
        }

        @Override
        public UserLocation[] newArray(int size) {
            return new UserLocation[size];
        }
    };
}