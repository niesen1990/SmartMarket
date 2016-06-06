package com.cmbb.smartmarket.activity.user.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/23 下午6:39
 */
public enum OrderRefundBuyStatus {

    买家申请退款("APPLY", "", "", ""),
    等待买家发货("SENDING", "", "", "退货"),
    等待卖家收货("WAIT_RECEIVE", "", "", "提醒收货"),
    退款处理中("REFUNDING", "", "", ""),
    卖家拒绝退款("REJECT", "", "拒绝原因", "重新申请退款"),
    退款完成("REFUNDED", "", "", "");

    private String status;
    private String operationLeft;
    private String operationMid;
    private String operationRight;

    OrderRefundBuyStatus(String status, String operationLeft, String operationMid, String operationRight) {
        this.status = status;
        this.operationLeft = operationLeft;
        this.operationMid = operationMid;
        this.operationRight = operationRight;
    }

    // 普通方法
    public static String[] getStatus(String status) {
        String[] results = new String[3];
        for (OrderRefundBuyStatus s : OrderRefundBuyStatus.values()) {
            if (s.getStatus().equals(status)) {
                results[0] = s.getOperationLeft();
                results[1] = s.getOperationMid();
                results[2] = s.getOperationRight();
            }
        }
        return results;
    }

    public String getOperationMid() {
        return operationMid;
    }

    public void setOperationMid(String operationMid) {
        this.operationMid = operationMid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getOperationLeft() {
        return operationLeft;
    }

    public void setOperationLeft(String operationLeft) {
        this.operationLeft = operationLeft;
    }

    public String getOperationRight() {
        return operationRight;
    }

    public void setOperationRight(String operationRight) {
        this.operationRight = operationRight;
    }
}
