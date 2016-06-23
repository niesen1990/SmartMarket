package com.cmbb.smartmarket.network.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/23 下午3:49
 * 修改人：N.Sun
 * 修改时间：16/6/23 下午3:49
 * 修改备注：
 */
public class ProductImageList implements Parcelable {
    private String imageHeight;
    private String location;
    private String imageWidth;
    private String businessNumber;

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public String getImageHeight() {
        return imageHeight;
    }

    public void setImageHeight(String imageHeight) {
        this.imageHeight = imageHeight;
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
    public String toString() {
        return "ProductImageList{" +
                "imageHeight='" + imageHeight + '\'' +
                ", location='" + location + '\'' +
                ", imageWidth='" + imageWidth + '\'' +
                ", businessNumber='" + businessNumber + '\'' +
                '}';
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.imageHeight);
        dest.writeString(this.location);
        dest.writeString(this.imageWidth);
        dest.writeString(this.businessNumber);
    }

    public ProductImageList() {
    }

    protected ProductImageList(Parcel in) {
        this.imageHeight = in.readString();
        this.location = in.readString();
        this.imageWidth = in.readString();
        this.businessNumber = in.readString();
    }

    public static final Parcelable.Creator<ProductImageList> CREATOR = new Parcelable.Creator<ProductImageList>() {
        @Override
        public ProductImageList createFromParcel(Parcel source) {
            return new ProductImageList(source);
        }

        @Override
        public ProductImageList[] newArray(int size) {
            return new ProductImageList[size];
        }
    };
}