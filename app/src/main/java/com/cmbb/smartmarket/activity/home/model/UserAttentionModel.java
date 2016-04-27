package com.cmbb.smartmarket.activity.home.model;

import com.cmbb.smartmarket.base.BaseModel;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 下午3:05
 */
public class UserAttentionModel extends BaseModel {

    private ResponseEntity response;

    public ResponseEntity getResponse() {
        return response;
    }

    public void setResponse(ResponseEntity response) {
        this.response = response;
    }


    public static class ResponseEntity {
        /**
         * page : 1
         * records : 8
         * rows : [{"userId":100004,"userNike":"妮妮妈","userSex":"2","userBigImg":"http://smart.image.alimmdn.com/oldImage/b5501b2708b948aa80af51c374c3f871.jpg","userBigWidth":640,"userBigHeight":360,"userSmallImg":"http://smart.image.alimmdn.com/oldImage/b5501b2708b948aa80af51c374c3f871.jpg","userSmallWidth":640,"userSmallHeight":360,"userRole":[{"eredarName":"萌宝用户","eredarCode":0}]},{"userId":100359,"userNike":"小糖果麻麻","userSex":"1","userBigImg":"http://smart.image.alimmdn.com/oldImage/f29b852070244d969c9ba09927012d88mage","userBigWidth":583,"userBigHeight":518,"userSmallImg":"http://smart.image.alimmdn.com/app/test/2016-2-10/image_392d88fea3eb4a64ae538ee6a5c204cb","userSmallWidth":439,"userSmallHeight":440,"userRole":[{"eredarName":"萌宝大咖","eredarCode":4}]},{"userId":101012,"userNike":"薄灰","userSex":"4","userBigImg":"http://smart.image.alimmdn.com/oldImage/e411ccdfc5ec47ca9567d66ddd641d42.jpg","userBigWidth":960,"userBigHeight":360,"userSmallImg":"http://smart.image.alimmdn.com/oldImage/e411ccdfc5ec47ca9567d66ddd641d42.jpg","userSmallWidth":960,"userSmallHeight":360,"userRole":[{"eredarName":"萌宝大咖","eredarCode":4}]},{"userId":100997,"userNike":"陈津津","userSex":"4","userBigImg":"http://smart.image.alimmdn.com/oldImage/1a80f927e9dc4ec5a5743940a101314e.png","userBigWidth":148,"userBigHeight":210,"userSmallImg":"http://smart.image.alimmdn.com/oldImage/1a80f927e9dc4ec5a5743940a101314e.png","userSmallWidth":148,"userSmallHeight":210,"userRole":[{"eredarName":"专家","eredarCode":4}]},{"userId":100798,"userNike":"我没说","userSex":"3","userBigImg":"http://smart.image.alimmdn.com/oldImage/bd2f26458d6349efbace1e6e20e60fa8mage","userBigWidth":160,"userBigHeight":160,"userSmallImg":"http://smart.image.alimmdn.com/oldImage/bd2f26458d6349efbace1e6e20e60fa8mage","userSmallWidth":160,"userSmallHeight":160,"userRole":[{"eredarName":"萌宝用户","eredarCode":0}]},{"userId":103097,"userNike":"niesen918","userSex":"3","userBigImg":"http://smart.image.alimmdn.com/oldImage/d3fe44b2f40f40de9b87accb0b8e7839mage","userBigWidth":360,"userBigHeight":640,"userSmallImg":"http://smart.image.alimmdn.com/app/test/2016-2-4/image_acb7c364b8c14ad59180f59307d7e5d1","userSmallWidth":2448,"userSmallHeight":3264,"userRole":[{"eredarName":"萌宝用户","eredarCode":0}]},{"userId":100768,"userNike":"N.Sun","userSex":"2","userBigImg":"http://smart.image.alimmdn.com/oldImage/874a731bc22a409791f2ba92cb7b6647mage","userBigWidth":770,"userBigHeight":360,"userSmallImg":"http://smart.image.alimmdn.com/app/test/2016-1-8/image_07822f9ea8794e898be0c50b79c1d7c8","userSmallWidth":160,"userSmallHeight":160,"userRole":[{"eredarName":"萌宝用户","eredarCode":0}]},{"userId":100717,"userNike":"Mattmatt","userSex":"2","userBigImg":"http://smart.image.alimmdn.com/oldImage/6cf1be910c764d068ca2c443adb756f0.jpg","userBigWidth":640,"userBigHeight":360,"userSmallImg":"http://smart.image.alimmdn.com/oldImage/6cf1be910c764d068ca2c443adb756f0.jpg","userSmallWidth":640,"userSmallHeight":360,"userRole":[{"eredarName":"萌宝大咖","eredarCode":4}]}]
         * total : 1
         */

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
             * userId : 100004
             * userNike : 妮妮妈
             * userSex : 2
             * userBigImg : http://smart.image.alimmdn.com/oldImage/b5501b2708b948aa80af51c374c3f871.jpg
             * userBigWidth : 640.0
             * userBigHeight : 360.0
             * userSmallImg : http://smart.image.alimmdn.com/oldImage/b5501b2708b948aa80af51c374c3f871.jpg
             * userSmallWidth : 640.0
             * userSmallHeight : 360.0
             * userRole : [{"eredarName":"萌宝用户","eredarCode":0}]
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

            public static class RowsEntity {
                private int userId;
                private String userNike;
                private String userSex;
                private String userBigImg;
                private double userBigWidth;
                private double userBigHeight;
                private String userSmallImg;
                private double userSmallWidth;
                private double userSmallHeight;
                /**
                 * eredarName : 萌宝用户
                 * eredarCode : 0
                 */

                private List<UserRoleEntity> userRole;

                public int getUserId() {
                    return userId;
                }

                public void setUserId(int userId) {
                    this.userId = userId;
                }

                public String getUserNike() {
                    return userNike;
                }

                public void setUserNike(String userNike) {
                    this.userNike = userNike;
                }

                public String getUserSex() {
                    return userSex;
                }

                public void setUserSex(String userSex) {
                    this.userSex = userSex;
                }

                public String getUserBigImg() {
                    return userBigImg;
                }

                public void setUserBigImg(String userBigImg) {
                    this.userBigImg = userBigImg;
                }

                public double getUserBigWidth() {
                    return userBigWidth;
                }

                public void setUserBigWidth(double userBigWidth) {
                    this.userBigWidth = userBigWidth;
                }

                public double getUserBigHeight() {
                    return userBigHeight;
                }

                public void setUserBigHeight(double userBigHeight) {
                    this.userBigHeight = userBigHeight;
                }

                public String getUserSmallImg() {
                    return userSmallImg;
                }

                public void setUserSmallImg(String userSmallImg) {
                    this.userSmallImg = userSmallImg;
                }

                public double getUserSmallWidth() {
                    return userSmallWidth;
                }

                public void setUserSmallWidth(double userSmallWidth) {
                    this.userSmallWidth = userSmallWidth;
                }

                public double getUserSmallHeight() {
                    return userSmallHeight;
                }

                public void setUserSmallHeight(double userSmallHeight) {
                    this.userSmallHeight = userSmallHeight;
                }

                public List<UserRoleEntity> getUserRole() {
                    return userRole;
                }

                public void setUserRole(List<UserRoleEntity> userRole) {
                    this.userRole = userRole;
                }

                public static class UserRoleEntity {
                    private String eredarName;
                    private int eredarCode;

                    public String getEredarName() {
                        return eredarName;
                    }

                    public void setEredarName(String eredarName) {
                        this.eredarName = eredarName;
                    }

                    public int getEredarCode() {
                        return eredarCode;
                    }

                    public void setEredarCode(int eredarCode) {
                        this.eredarCode = eredarCode;
                    }
                }
            }
        }
    }

    @Override
    public String toString() {
        return "UserAttentionModel{" +
                "response=" + response +
                '}';
    }
}
