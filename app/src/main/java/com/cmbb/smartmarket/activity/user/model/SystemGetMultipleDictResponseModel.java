package com.cmbb.smartmarket.activity.user.model;

import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午5:18
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午5:18
 * 修改备注：
 */
public class SystemGetMultipleDictResponseModel{

    private DataEntity data;
    /**
     * data : {"refund_server":[{"remark":"","name":"仅退款","value":"TK"},{"remark":"","name":"退款并退货","value":"TKTH"}],"refund_reason":[{"remark":"","name":"协商一致退款","value":"协商一致退款"},{"remark":"","name":"缺货","value":"缺货"},{"remark":"","name":"未按约定时间发货","value":"未按约定时间发货"},{"remark":"","name":"拍错/多拍/不想要","value":"拍错/多拍/不想要"},{"remark":"","name":"其他","value":"其他"}]}
     * msg : 操作成功
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
        /**
         * remark :
         * name : 仅退款
         * value : TK
         */

        private List<RefundReasonEntity> refund_server;
        /**
         * remark :
         * name : 协商一致退款
         * value : 协商一致退款
         */

        private List<RefundReasonEntity> refund_reason;

        public List<RefundReasonEntity> getRefund_server() {
            return refund_server;
        }

        public void setRefund_server(List<RefundReasonEntity> refund_server) {
            this.refund_server = refund_server;
        }

        public List<RefundReasonEntity> getRefund_reason() {
            return refund_reason;
        }

        public void setRefund_reason(List<RefundReasonEntity> refund_reason) {
            this.refund_reason = refund_reason;
        }


        public static class RefundReasonEntity {
            private String remark;
            private String name;
            private String value;

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }
        }
    }
}
