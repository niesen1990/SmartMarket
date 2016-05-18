package com.cmbb.smartmarket.activity.market.model;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/18 上午11:53
 * 修改人：N.Sun
 * 修改时间：16/5/18 上午11:53
 * 修改备注：
 */
public class PayItemModel {
    int res;
    String name;
    String content;

    public PayItemModel(int res, String name, String content) {
        this.res = res;
        this.name = name;
        this.content = content;
    }

    public int getRes() {
        return res;
    }

    public void setRes(int res) {
        this.res = res;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
