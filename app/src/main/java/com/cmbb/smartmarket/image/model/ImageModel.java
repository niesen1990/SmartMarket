package com.cmbb.smartmarket.image.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/30 上午10:15
 * 修改人：N.Sun
 * 修改时间：16/6/30 上午10:15
 * 修改备注：
 */
public class ImageModel implements Parcelable {

    private String imageHeight;
    private String businessNumber;
    private String location;
    private String imageWidth;

    public ImageModel(String imageHeight, String businessNumber, String location, String imageWidth) {
        this.imageHeight = imageHeight;
        this.businessNumber = businessNumber;
        this.location = location;
        this.imageWidth = imageWidth;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
    }

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getImageWidth() {
        return imageWidth;
    }

    public void setImageWidth(String imageWidth) {
        this.imageWidth = imageWidth;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageHeight);
        dest.writeString(this.businessNumber);
        dest.writeString(this.location);
        dest.writeString(this.imageWidth);
    }

    public ImageModel() {
    }

    protected ImageModel(Parcel in) {
        this.imageHeight = in.readString();
        this.businessNumber = in.readString();
        this.location = in.readString();
        this.imageWidth = in.readString();
    }

    public static final Parcelable.Creator<ImageModel> CREATOR = new Parcelable.Creator<ImageModel>() {
        @Override
        public ImageModel createFromParcel(Parcel source) {
            return new ImageModel(source);
        }

        @Override
        public ImageModel[] newArray(int size) {
            return new ImageModel[size];
        }
    };
}
