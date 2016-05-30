package com.cmbb.smartmarket.activity.wallet.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/22 下午3:56
 * 修改人：N.Sun
 * 修改时间：16/5/22 下午3:56
 * 修改备注：
 */
public class WalletAccountBindalipayResponseModel {

    /**
     * data : false
     * msg : 绑定失败
     */

    private boolean data;
    private String msg;

    public boolean isData() {
        return data;
    }

    public void setData(boolean data) {
        this.data = data;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
