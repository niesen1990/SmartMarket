package com.cmbb.smartmarket.activity.user.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/23 下午6:39
 */
public enum OrderSoldStatus {

    等待买家付款("NOT_PAID", "", ""),
    等待卖家发货("PAID", "", "确认发货"),
    等待买家收货("RECEIVING", "", "提醒收货"),
    等待买家评价("EVALUATING", "", ""),
    已评价("EVALUATED", "", "查看评价"),
    退款处理中("REFUND", "", ""),
    交易完成("COMPLETE", "", ""),
    已取消("CANCEL", "", ""),
    交易关闭("CLOSED", "", "");

    private String status;
    private String operationLeft;
    private String operationRight;

    OrderSoldStatus(String status, String operationLeft, String operationRight) {
        this.status = status;
        this.operationLeft = operationLeft;
        this.operationRight = operationRight;
    }

    // 普通方法
    public static String[] getStatus(String status) {
        String[] results = new String[2];
        for (OrderSoldStatus s : OrderSoldStatus.values()) {
            if (s.getStatus().equals(status)) {
                results[0] = s.getOperationLeft();
                results[1] = s.getOperationRight();
            }
        }
        return results;
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
