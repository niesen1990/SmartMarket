package com.cmbb.smartmarket.activity.user.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/29 下午4:44
 * 修改人：N.Sun
 * 修改时间：16/5/29 下午4:44
 * 修改备注：
 */
public class MarketEvaluateListResponseModel{

    /**
     * content : [{"content":"感觉这个很好","id":3,"evaluateDate":"2016-05-17 17:50:19","childCount":1,"evaluateUser":{"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":2,"province":110000,"provinceText":"","city":110100,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"orderId":5}]
     * totalPages : 1
     * totalElements : 1
     * last : true
     * size : 5
     * number : 0
     * first : true
     * sort : 2
     * numberOfElements : 1
     */

    private DataEntity data;
    /**
     * data : {"content":[{"content":"感觉这个很好","id":3,"evaluateDate":"2016-05-17 17:50:19","childCount":1,"evaluateUser":{"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":2,"province":110000,"provinceText":"","city":110100,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""},"orderId":5}],"totalPages":1,"totalElements":1,"last":true,"size":5,"number":0,"first":true,"sort":2,"numberOfElements":1}
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
        private int totalPages;
        private int totalElements;
        private boolean last;
        private int size;
        private int number;
        private boolean first;
        private int sort;
        private int numberOfElements;
        /**
         * content : 感觉这个很好
         * id : 3
         * evaluateDate : 2016-05-17 17:50:19
         * childCount : 1
         * evaluateUser : {"id":1,"mbpUserId":108075,"loginAccount":"15901718791","nickName":"臻萌兔","sex":2,"province":110000,"provinceText":"","city":110100,"cityText":"","introduce":"","userImg":"http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910","imgWidth":750,"imgHeight":750,"userLevel":0,"appVersion":"","device":"","deviceImei":""}
         * orderId : 5
         */

        private List<ContentEntity> content;

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

        public boolean isLast() {
            return last;
        }

        public void setLast(boolean last) {
            this.last = last;
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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
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

        public static class ContentEntity {
            private String content;
            private int id;
            private String evaluateDate;
            private int childCount;
            /**
             * id : 1
             * mbpUserId : 108075
             * loginAccount : 15901718791
             * nickName : 臻萌兔
             * sex : 2
             * province : 110000
             * provinceText :
             * city : 110100
             * cityText :
             * introduce :
             * userImg : http://smart.image.alimmdn.com/app/test/2015-12-31/3C32D253-20EB-4AAB-B21E-20D02EB9B910
             * imgWidth : 750
             * imgHeight : 750
             * userLevel : 0
             * appVersion :
             * device :
             * deviceImei :
             */

            private EvaluateUserEntity evaluateUser;
            private int orderId;

            public String getContent() {
                return content;
            }

            public void setContent(String content) {
                this.content = content;
            }

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getEvaluateDate() {
                return evaluateDate;
            }

            public void setEvaluateDate(String evaluateDate) {
                this.evaluateDate = evaluateDate;
            }

            public int getChildCount() {
                return childCount;
            }

            public void setChildCount(int childCount) {
                this.childCount = childCount;
            }

            public EvaluateUserEntity getEvaluateUser() {
                return evaluateUser;
            }

            public void setEvaluateUser(EvaluateUserEntity evaluateUser) {
                this.evaluateUser = evaluateUser;
            }

            public int getOrderId() {
                return orderId;
            }

            public void setOrderId(int orderId) {
                this.orderId = orderId;
            }

            public static class EvaluateUserEntity {
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
                private int imgWidth;
                private int imgHeight;
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
            }
        }
    }
}
