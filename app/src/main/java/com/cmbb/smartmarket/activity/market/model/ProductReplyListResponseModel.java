package com.cmbb.smartmarket.activity.market.model;

import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.network.model.PublicUser;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/20 上午9:51
 * 修改人：N.Sun
 * 修改时间：16/5/20 上午9:51
 * 修改备注：
 */
public class ProductReplyListResponseModel  {

    /**
     * content : [{"id":1,"productId":1,"repUserId":3,"contents":"回复@mywaystay:便宜点喽","type":0,"resolveProductId":1,"isRecommoned":0,"recommonedProductImageList":[{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj","imageWidth":""}],"createDate":"2016-05-05 15:17:51","createUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":2,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}}]
     * last : true
     * totalPages : 1
     * totalElements : 1
     * size : 5
     * number : 0
     * first : true
     * sort : [{"direction":"DESC","property":"createDate","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}]
     * numberOfElements : 1
     */

    private DataEntity data;
    /**
     * data : {"content":[{"id":1,"productId":1,"repUserId":3,"contents":"回复@mywaystay:便宜点喽","type":0,"resolveProductId":1,"isRecommoned":0,"recommonedProductImageList":[{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj","imageWidth":""}],"createDate":"2016-05-05 15:17:51","createUser":{"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":2,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}}],"last":true,"totalPages":1,"totalElements":1,"size":5,"number":0,"first":true,"sort":[{"direction":"DESC","property":"createDate","ignoreCase":false,"nullHandling":"NATIVE","ascending":false}],"numberOfElements":1}
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
        private int totalPages;
        private int totalElements;
        private int size;
        private int number;
        private boolean first;
        private int numberOfElements;
        /**
         * id : 1
         * productId : 1
         * repUserId : 3
         * contents : 回复@mywaystay:便宜点喽
         * type : 0
         * resolveProductId : 1
         * isRecommoned : 0
         * recommonedProductImageList : [{"imageHeight":"","location":"http://smart-test.image.alimmdn.com/market/product/image/2016-05-19/NzQ2YThmYmUtNjliMy00ZGRmLTg1YjItYjc2ZjQ3ZTUxNjFj","imageWidth":""}]
         * createDate : 2016-05-05 15:17:51
         * createUser : {"id":3,"mbpUserId":108074,"loginAccount":"18221507236","nickName":"mywaystay","sex":2,"province":310000,"provinceText":"","city":310104,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-8/C6BDAD0C-A958-428A-8287-745234FE9253","imgWidth":"","imgHeight":"","userLevel":0,"appVersion":"","device":"","deviceImei":""}
         */

        private List<ContentEntity> content;
        /**
         * direction : DESC
         * property : createDate
         * ignoreCase : false
         * nullHandling : NATIVE
         * ascending : false
         */

        private List<SortEntity> sort;

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
        }

        public int getTotalPages() {
            return totalPages;
        }

        public void setTotalPages(int totalPages) {
            this.totalPages = totalPages;
        }

        public int getTotalElements() {
            return totalElements;
        }

        public void setTotalElements(int totalElements) {
            this.totalElements = totalElements;
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

        public List<SortEntity> getSort() {
            return sort;
        }

        public void setSort(List<SortEntity> sort) {
            this.sort = sort;
        }

        public static class ContentEntity {
            private int id;
            private int productId;
            private int repUserId;
            private String contents;
            private int type;
            private int resolveProductId = -1;
            private int isRecommoned;
            private String createDate;
            private PublicUser createUser;
            private List<ProductImageList> recommonedProductImageList;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public int getRepUserId() {
                return repUserId;
            }

            public void setRepUserId(int repUserId) {
                this.repUserId = repUserId;
            }

            public String getContents() {
                return contents;
            }

            public void setContents(String contents) {
                this.contents = contents;
            }

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public int getResolveProductId() {
                return resolveProductId;
            }

            public void setResolveProductId(int resolveProductId) {
                this.resolveProductId = resolveProductId;
            }

            public int getIsRecommoned() {
                return isRecommoned;
            }

            public void setIsRecommoned(int isRecommoned) {
                this.isRecommoned = isRecommoned;
            }

            public String getCreateDate() {
                return createDate;
            }

            public void setCreateDate(String createDate) {
                this.createDate = createDate;
            }

            public PublicUser getCreateUser() {
                return createUser;
            }

            public void setCreateUser(PublicUser createUser) {
                this.createUser = createUser;
            }

            public List<ProductImageList> getRecommonedProductImageList() {
                return recommonedProductImageList;
            }

            public void setRecommonedProductImageList(List<ProductImageList> recommonedProductImageList) {
                this.recommonedProductImageList = recommonedProductImageList;
            }

            public static class CreateUserEntity {
                private int id;
                private int mbpUserId;
                private String loginAccount;
                private String nickName;
                private int sex;
                private int province;
                private String provinceText;
                private int city;
                private String cityText;
                private String introduce;
                private String userImg;
                private String imgWidth;
                private String imgHeight;
                private int userLevel;
                private String appVersion;
                private String device;
                private String deviceImei;

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

                public int getProvince() {
                    return province;
                }

                public void setProvince(int province) {
                    this.province = province;
                }

                public String getProvinceText() {
                    return provinceText;
                }

                public void setProvinceText(String provinceText) {
                    this.provinceText = provinceText;
                }

                public int getCity() {
                    return city;
                }

                public void setCity(int city) {
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

                public String getImgWidth() {
                    return imgWidth;
                }

                public void setImgWidth(String imgWidth) {
                    this.imgWidth = imgWidth;
                }

                public String getImgHeight() {
                    return imgHeight;
                }

                public void setImgHeight(String imgHeight) {
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
            }

            public static class RecommonedProductImageListEntity {
                private String imageHeight;
                private String location;
                private String imageWidth;

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
            }
        }

        public static class SortEntity {
            private String direction;
            private String property;
            private boolean ignoreCase;
            private String nullHandling;
            private boolean ascending;

            public String getDirection() {
                return direction;
            }

            public void setDirection(String direction) {
                this.direction = direction;
            }

            public String getProperty() {
                return property;
            }

            public void setProperty(String property) {
                this.property = property;
            }

            public boolean isIgnoreCase() {
                return ignoreCase;
            }

            public void setIgnoreCase(boolean ignoreCase) {
                this.ignoreCase = ignoreCase;
            }

            public String getNullHandling() {
                return nullHandling;
            }

            public void setNullHandling(String nullHandling) {
                this.nullHandling = nullHandling;
            }

            public boolean isAscending() {
                return ascending;
            }

            public void setAscending(boolean ascending) {
                this.ascending = ascending;
            }
        }
    }
}
