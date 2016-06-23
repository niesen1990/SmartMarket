package com.cmbb.smartmarket.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/23 下午3:53
 * 修改人：N.Sun
 * 修改时间：16/6/23 下午3:53
 * 修改备注：
 */
public class PublicUser implements Parcelable {
    private int id;
    private int mbpUserId;
    private String loginAccount;
    private String nickName;
    private int sex;
    private String province;
    private String provinceText;
    private String city;
    private String cityText;
    private String introduce;
    private String userImg;
    private int imgWidth;
    private int imgHeight;
    private int userLevel;
    private String appVersion;
    private String device;
    private String deviceImei;
    private String imUserId;

    public String getImUserId() {
        return imUserId;
    }

    public void setImUserId(String imUserId) {
        this.imUserId = imUserId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMbpUserId() {
        return mbpUserId;
    }

    public void setMbpUserId(int mbpUserId) {
        this.mbpUserId = mbpUserId;
    }

    public String getLoginAccount() {
        return loginAccount;
    }

    public void setLoginAccount(String loginAccount) {
        this.loginAccount = loginAccount;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getProvinceText() {
        return provinceText;
    }

    public void setProvinceText(String provinceText) {
        this.provinceText = provinceText;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCityText() {
        return cityText;
    }

    public void setCityText(String cityText) {
        this.cityText = cityText;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getUserImg() {
        return userImg;
    }

    public void setUserImg(String userImg) {
        this.userImg = userImg;
    }

    public int getImgWidth() {
        return imgWidth;
    }

    public void setImgWidth(int imgWidth) {
        this.imgWidth = imgWidth;
    }

    public int getImgHeight() {
        return imgHeight;
    }

    public void setImgHeight(int imgHeight) {
        this.imgHeight = imgHeight;
    }

    public int getUserLevel() {
        return userLevel;
    }

    public void setUserLevel(int userLevel) {
        this.userLevel = userLevel;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getDevice() {
        return device;
    }

    public void setDevice(String device) {
        this.device = device;
    }

    public String getDeviceImei() {
        return deviceImei;
    }

    public void setDeviceImei(String deviceImei) {
        this.deviceImei = deviceImei;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(this.id);
        dest.writeInt(this.mbpUserId);
        dest.writeString(this.loginAccount);
        dest.writeString(this.nickName);
        dest.writeInt(this.sex);
        dest.writeString(this.province);
        dest.writeString(this.provinceText);
        dest.writeString(this.city);
        dest.writeString(this.cityText);
        dest.writeString(this.imUserId);
        dest.writeString(this.introduce);
        dest.writeString(this.userImg);
        dest.writeInt(this.imgWidth);
        dest.writeInt(this.imgHeight);
        dest.writeInt(this.userLevel);
        dest.writeString(this.appVersion);
        dest.writeString(this.device);
        dest.writeString(this.deviceImei);
    }

    public PublicUser() {
    }

    protected PublicUser(Parcel in) {
        this.id = in.readInt();
        this.mbpUserId = in.readInt();
        this.loginAccount = in.readString();
        this.nickName = in.readString();
        this.imUserId = in.readString();
        this.sex = in.readInt();
        this.province = in.readString();
        this.provinceText = in.readString();
        this.city = in.readString();
        this.cityText = in.readString();
        this.introduce = in.readString();
        this.userImg = in.readString();
        this.imgWidth = in.readInt();
        this.imgHeight = in.readInt();
        this.userLevel = in.readInt();
        this.appVersion = in.readString();
        this.device = in.readString();
        this.deviceImei = in.readString();
    }

    public static final Parcelable.Creator<PublicUser> CREATOR = new Parcelable.Creator<PublicUser>() {
        @Override
        public PublicUser createFromParcel(Parcel source) {
            return new PublicUser(source);
        }

        @Override
        public PublicUser[] newArray(int size) {
            return new PublicUser[size];
        }
    };
}
