package com.cmbb.smartmarket.activity.user.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 下午3:48
 * 修改人：N.Sun
 * 修改时间：16/5/18 下午3:48
 * 修改备注：
 */
public class MarketOrderRefundResponseModel{

    /**
     * status : 200
     * name : 退款中
     */

    private String status;
    private String name;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
