package com.cmbb.smartmarket.activity.user.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;
import com.cmbb.smartmarket.network.model.UserLocation;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/19 下午6:52
 * 修改人：N.Sun
 * 修改时间：16/5/19 下午6:52
 * 修改备注：
 */
public class MyselfProductPublicListResponseModel {

    /**
     * content : [{"id":14,"title":"优衣库","introduce":"","content":"","originalPrice":500,"currentPrice":100,"freight":100,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"","secondClassify":"MMYP_FZ","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","lontitude":"","latitude":"","province":"","city":"","district":"","address":"","productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":2,"publicDate":"2016-05-13 10:48:58","publicUserDto":"","isCollect":1,"isSpot":1}]
     * last : false
     * totalElements : 6
     * totalPages : 2
     * size : 5
     * number : 0
     * first : true
     * sort : null
     * numberOfElements : 5
     */

    private DataEntity data;
    /**
     * data : {"content":[{"id":14,"title":"优衣库","introduce":"","content":"","originalPrice":500,"currentPrice":100,"freight":100,"priceDesc":"","parentClassify":"MMYP","parentClassifyText":"","secondClassify":"MMYP_FZ","secondClassifyText":"","thirdClassify":"","thirdClassifyText":"","lontitude":"","latitude":"","province":"","city":"","district":"","address":"","productType":0,"productStatus":0,"productStatusText":"上架","isResolve":1,"resolveDate":"","browseNumber":0,"replyNumber":0,"shareNumber":0,"isRecommoned":2,"publicDate":"2016-05-13 10:48:58","publicUserDto":"","isCollect":1,"isSpot":1}],"last":false,"totalElements":6,"totalPages":2,"size":5,"number":0,"first":true,"sort":null,"numberOfElements":5}
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
        private int size;
        private int number;
        private boolean first;
        private Object sort;
        private int numberOfElements;

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

        public boolean isFirst() {
            return first;
        }

        public void setFirst(boolean first) {
            this.first = first;
        }

        public Object getSort() {
            return sort;
        }

        public void setSort(Object sort) {
            this.sort = sort;
        }

        public int getNumberOfElements() {
            return numberOfElements;
        }

        public void setNumberOfElements(int numberOfElements) {
            this.numberOfElements = numberOfElements;
        }

        public List<ContentEntity> getContent() {
            return content;
        }

        public void setContent(List<ContentEntity> content) {
            this.content = content;
        }

        public static class ContentEntity implements Parcelable {


            private int id;
            private String title;
            private String introduce;
            private String content;
            private double originalPrice;
            private double currentPrice;
            private double freight;
            private String priceDesc;
            private String parentClassify;
            private String parentClassifyText;
            private String secondClassify;
            private String secondClassifyText;
            private String thirdClassify;
            private String thirdClassifyText;
            private String lontitude;
            private String latitude;
            private String province;
            private String city;
            private String district;
            private String address;
            private int productType;
            private int productStatus;
            private String productStatusText;
            private int isResolve;
            private String resolveDate;
            private int browseNumber;
            private int replyNumber;
            private int shareNumber;
            private int isRecommoned;
            private String publicDate;
            //add
            private boolean checked;

            private PublicUser publicUser;
            private UserLocation userLocation;

            private int isCollect;
            private int isSpot;

            public boolean isChecked() {
                return checked;
            }

            public void setChecked(boolean checked) {
                this.checked = checked;
            }

            /**
             * imageHeight :
             * location : http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj
             * imageWidth :
             */

            private List<ProductImageList> productImageList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public String getIntroduce() {
                return introduce;
            }

            public void setIntroduce(String introduce) {
                this.introduce = introduce;
            }

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public double getOriginalPrice() {
                return originalPrice;
            }

            public void setOriginalPrice(double originalPrice) {
                this.originalPrice = originalPrice;
            }

            public double getCurrentPrice() {
                return currentPrice;
            }

            public void setCurrentPrice(double currentPrice) {
                this.currentPrice = currentPrice;
            }

            public double getFreight() {
                return freight;
            }

            public void setFreight(double freight) {
                this.freight = freight;
            }

            public String getPriceDesc() {
                return priceDesc;
            }

            public void setPriceDesc(String priceDesc) {
                this.priceDesc = priceDesc;
            }

            public String getParentClassify() {
                return parentClassify;
            }

            public void setParentClassify(String parentClassify) {
                this.parentClassify = parentClassify;
            }

            public String getParentClassifyText() {
                return parentClassifyText;
            }

            public void setParentClassifyText(String parentClassifyText) {
                this.parentClassifyText = parentClassifyText;
            }

            public String getSecondClassify() {
                return secondClassify;
            }

            public void setSecondClassify(String secondClassify) {
                this.secondClassify = secondClassify;
            }

            public String getSecondClassifyText() {
                return secondClassifyText;
            }

            public void setSecondClassifyText(String secondClassifyText) {
                this.secondClassifyText = secondClassifyText;
            }

            public String getThirdClassify() {
                return thirdClassify;
            }

            public void setThirdClassify(String thirdClassify) {
                this.thirdClassify = thirdClassify;
            }

            public String getThirdClassifyText() {
                return thirdClassifyText;
            }

            public void setThirdClassifyText(String thirdClassifyText) {
                this.thirdClassifyText = thirdClassifyText;
            }

            public String getLontitude() {
                return lontitude;
            }

            public void setLontitude(String lontitude) {
                this.lontitude = lontitude;
            }

            public String getLatitude() {
                return latitude;
            }

            public void setLatitude(String latitude) {
                this.latitude = latitude;
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

            public String getDistrict() {
                return district;
            }

            public void setDistrict(String district) {
                this.district = district;
            }

            public String getAddress() {
                return address;
            }

            public void setAddress(String address) {
                this.address = address;
            }

            public int getProductType() {
                return productType;
            }

            public void setProductType(int productType) {
                this.productType = productType;
            }

            public int getProductStatus() {
                return productStatus;
            }

            public void setProductStatus(int productStatus) {
                this.productStatus = productStatus;
            }

            public String getProductStatusText() {
                return productStatusText;
            }

            public void setProductStatusText(String productStatusText) {
                this.productStatusText = productStatusText;
            }

            public int getIsResolve() {
                return isResolve;
            }

            public void setIsResolve(int isResolve) {
                this.isResolve = isResolve;
            }

            public String getResolveDate() {
                return resolveDate;
            }

            public void setResolveDate(String resolveDate) {
                this.resolveDate = resolveDate;
            }

            public int getBrowseNumber() {
                return browseNumber;
            }

            public void setBrowseNumber(int browseNumber) {
                this.browseNumber = browseNumber;
            }

            public int getReplyNumber() {
                return replyNumber;
            }

            public void setReplyNumber(int replyNumber) {
                this.replyNumber = replyNumber;
            }

            public int getShareNumber() {
                return shareNumber;
            }

            public void setShareNumber(int shareNumber) {
                this.shareNumber = shareNumber;
            }

            public int getIsRecommoned() {
                return isRecommoned;
            }

            public void setIsRecommoned(int isRecommoned) {
                this.isRecommoned = isRecommoned;
            }

            public String getPublicDate() {
                return publicDate;
            }

            public void setPublicDate(String publicDate) {
                this.publicDate = publicDate;
            }

            public PublicUser getPublicUser() {
                return publicUser;
            }

            public void setPublicUser(PublicUser publicUser) {
                this.publicUser = publicUser;
            }

            public UserLocation getUserLocation() {
                return userLocation;
            }

            public void setUserLocation(UserLocation userLocation) {
                this.userLocation = userLocation;
            }

            public int getIsCollect() {
                return isCollect;
            }

            public void setIsCollect(int isCollect) {
                this.isCollect = isCollect;
            }

            public int getIsSpot() {
                return isSpot;
            }

            public void setIsSpot(int isSpot) {
                this.isSpot = isSpot;
            }

            public List<ProductImageList> getProductImageList() {
                return productImageList;
            }

            public void setProductImageList(List<ProductImageList> productImageList) {
                this.productImageList = productImageList;
            }





            @Override
            public int describeContents() {
                return 0;
            }

            @Override
            public void writeToParcel(Parcel dest, int flags) {
                dest.writeInt(this.id);
                dest.writeString(this.title);
                dest.writeString(this.introduce);
                dest.writeString(this.content);
                dest.writeDouble(this.originalPrice);
                dest.writeDouble(this.currentPrice);
                dest.writeDouble(this.freight);
                dest.writeString(this.priceDesc);
                dest.writeString(this.parentClassify);
                dest.writeString(this.parentClassifyText);
                dest.writeString(this.secondClassify);
                dest.writeString(this.secondClassifyText);
                dest.writeString(this.thirdClassify);
                dest.writeString(this.thirdClassifyText);
                dest.writeString(this.lontitude);
                dest.writeString(this.latitude);
                dest.writeString(this.province);
                dest.writeString(this.city);
                dest.writeString(this.district);
                dest.writeString(this.address);
                dest.writeInt(this.productType);
                dest.writeInt(this.productStatus);
                dest.writeString(this.productStatusText);
                dest.writeInt(this.isResolve);
                dest.writeString(this.resolveDate);
                dest.writeInt(this.browseNumber);
                dest.writeInt(this.replyNumber);
                dest.writeInt(this.shareNumber);
                dest.writeInt(this.isRecommoned);
                dest.writeString(this.publicDate);
                dest.writeParcelable(this.publicUser, flags);
                dest.writeParcelable(this.userLocation, flags);
                dest.writeInt(this.isCollect);
                dest.writeInt(this.isSpot);
                dest.writeTypedList(this.productImageList);
            }

            public ContentEntity() {
            }

            protected ContentEntity(Parcel in) {
                this.id = in.readInt();
                this.title = in.readString();
                this.introduce = in.readString();
                this.content = in.readString();
                this.originalPrice = in.readDouble();
                this.currentPrice = in.readDouble();
                this.freight = in.readDouble();
                this.priceDesc = in.readString();
                this.parentClassify = in.readString();
                this.parentClassifyText = in.readString();
                this.secondClassify = in.readString();
                this.secondClassifyText = in.readString();
                this.thirdClassify = in.readString();
                this.thirdClassifyText = in.readString();
                this.lontitude = in.readString();
                this.latitude = in.readString();
                this.province = in.readString();
                this.city = in.readString();
                this.district = in.readString();
                this.address = in.readString();
                this.productType = in.readInt();
                this.productStatus = in.readInt();
                this.productStatusText = in.readString();
                this.isResolve = in.readInt();
                this.resolveDate = in.readString();
                this.browseNumber = in.readInt();
                this.replyNumber = in.readInt();
                this.shareNumber = in.readInt();
                this.isRecommoned = in.readInt();
                this.publicDate = in.readString();
                this.publicUser = in.readParcelable(PublicUser.class.getClassLoader());
                this.userLocation = in.readParcelable(UserLocation.class.getClassLoader());
                this.isCollect = in.readInt();
                this.isSpot = in.readInt();
                this.productImageList = in.createTypedArrayList(ProductImageList.CREATOR);
            }

            public static final Parcelable.Creator<ContentEntity> CREATOR = new Parcelable.Creator<ContentEntity>() {
                @Override
                public ContentEntity createFromParcel(Parcel source) {
                    return new ContentEntity(source);
                }

                @Override
                public ContentEntity[] newArray(int size) {
                    return new ContentEntity[size];
                }
            };
        }
    }
}
