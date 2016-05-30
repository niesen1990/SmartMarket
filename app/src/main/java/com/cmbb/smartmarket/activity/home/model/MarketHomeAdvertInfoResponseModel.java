package com.cmbb.smartmarket.activity.home.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/23 下午12:00
 * 修改人：N.Sun
 * 修改时间：16/5/23 下午12:00
 * 修改备注：
 */
public class MarketHomeAdvertInfoResponseModel {

    /**
     * data : [{"id":44,"adImg":"http://smart.image.alimmdn.com/oldImage/dc9a1ebffffb49a59dca4b8258eecb02.jpg","imgWidth":"923","imgHeight":"591","systemType":"MBP_APP","adType":"INDEX","redirectType":"INNER","innerRedirectType":"APP_TOPIC","relateId":20777,"redirectUrl":"","isEnabled":true,"sortNum":1,"title":"","remark":"话题广告贴：完美\u201c卸货\u201d，你准备好了吗？","creatorId":9,"createTime":"2016-03-15 10:41:55","modifierId":1,"modifyTime":"","creatorName":"","modifyName":""}]
     * msg : 数据加载成功
     */

    private String msg;
    /**
     * id : 44
     * adImg : http://smart.image.alimmdn.com/oldImage/dc9a1ebffffb49a59dca4b8258eecb02.jpg
     * imgWidth : 923
     * imgHeight : 591
     * systemType : MBP_APP
     * adType : INDEX
     * redirectType : INNER
     * innerRedirectType : APP_TOPIC
     * relateId : 20777
     * redirectUrl :
     * isEnabled : true
     * sortNum : 1
     * title :
     * remark : 话题广告贴：完美“卸货”，你准备好了吗？
     * creatorId : 9
     * createTime : 2016-03-15 10:41:55
     * modifierId : 1
     * modifyTime :
     * creatorName :
     * modifyName :
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

    public static class DataEntity {
        private int id;
        private String adImg;
        private String imgWidth;
        private String imgHeight;
        private String systemType;
        private String adType;
        private String redirectType;
        private String innerRedirectType;
        private int relateId;
        private String redirectUrl;
        private boolean isEnabled;
        private int sortNum;
        private String title;
        private String remark;
        private int creatorId;
        private String createTime;
        private int modifierId;
        private String modifyTime;
        private String creatorName;
        private String modifyName;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getAdImg() {
            return adImg;
        }

        public void setAdImg(String adImg) {
            this.adImg = adImg;
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

        public String getSystemType() {
            return systemType;
        }

        public void setSystemType(String systemType) {
            this.systemType = systemType;
        }

        public String getAdType() {
            return adType;
        }

        public void setAdType(String adType) {
            this.adType = adType;
        }

        public String getRedirectType() {
            return redirectType;
        }

        public void setRedirectType(String redirectType) {
            this.redirectType = redirectType;
        }

        public String getInnerRedirectType() {
            return innerRedirectType;
        }

        public void setInnerRedirectType(String innerRedirectType) {
            this.innerRedirectType = innerRedirectType;
        }

        public int getRelateId() {
            return relateId;
        }

        public void setRelateId(int relateId) {
            this.relateId = relateId;
        }

        public String getRedirectUrl() {
            return redirectUrl;
        }

        public void setRedirectUrl(String redirectUrl) {
            this.redirectUrl = redirectUrl;
        }

        public boolean isIsEnabled() {
            return isEnabled;
        }

        public void setIsEnabled(boolean isEnabled) {
            this.isEnabled = isEnabled;
        }

        public int getSortNum() {
            return sortNum;
        }

        public void setSortNum(int sortNum) {
            this.sortNum = sortNum;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public int getCreatorId() {
            return creatorId;
        }

        public void setCreatorId(int creatorId) {
            this.creatorId = creatorId;
        }

        public String getCreateTime() {
            return createTime;
        }

        public void setCreateTime(String createTime) {
            this.createTime = createTime;
        }

        public int getModifierId() {
            return modifierId;
        }

        public void setModifierId(int modifierId) {
            this.modifierId = modifierId;
        }

        public String getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(String modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getCreatorName() {
            return creatorName;
        }

        public void setCreatorName(String creatorName) {
            this.creatorName = creatorName;
        }

        public String getModifyName() {
            return modifyName;
        }

        public void setModifyName(String modifyName) {
            this.modifyName = modifyName;
        }
    }
}
