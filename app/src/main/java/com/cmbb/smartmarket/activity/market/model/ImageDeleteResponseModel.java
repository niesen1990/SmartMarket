package com.cmbb.smartmarket.activity.market.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/26 上午11:56
 * 修改人：N.Sun
 * 修改时间：16/5/26 上午11:56
 * 修改备注：
 */
public class ImageDeleteResponseModel {

    /**
     * data : [{"businessNumber":"4028e4ed54e688420154e68842700000","isSuccess":true},{"businessNumber":"4028e4ed54e688420154e68842700001","isSuccess":true}]
     * msg : 操作成功
     */

    private String msg;
    /**
     * businessNumber : 4028e4ed54e688420154e68842700000
     * isSuccess : true
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
        private String businessNumber;
        private boolean isSuccess;

        public String getBusinessNumber() {
            return businessNumber;
        }

        public void setBusinessNumber(String businessNumber) {
            this.businessNumber = businessNumber;
        }

        public boolean isIsSuccess() {
            return isSuccess;
        }

        public void setIsSuccess(boolean isSuccess) {
            this.isSuccess = isSuccess;
        }
    }
}
