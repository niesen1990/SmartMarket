package com.cmbb.smartmarket.activity.market.model;

import rx.Subscription;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/25 下午7:49
 * 修改人：N.Sun
 * 修改时间：16/5/25 下午7:49
 * 修改备注：
 */
public class PublishImageModel {
    String imageUrl;
    int progress;
    String businessNumber;

    Subscription mSubscription;

    public String getBusinessNumber() {
        return businessNumber;
    }

    public void setBusinessNumber(String businessNumber) {
        this.businessNumber = businessNumber;
    }

    public PublishImageModel(String imageUrl, int progress) {
        this.imageUrl = imageUrl;
        this.progress = progress;
    }

    public PublishImageModel(String imageUrl, int progress, String businessNumber) {
        this.imageUrl = imageUrl;
        this.progress = progress;
        this.businessNumber = businessNumber;
    }

    public Subscription getSubscription() {
        return mSubscription;
    }

    public void setSubscription(Subscription subscription) {
        if (this.mSubscription != null) {
            this.mSubscription.unsubscribe();
        }
        mSubscription = subscription;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public int getProgress() {
        return progress;
    }

    public void setProgress(int progress) {
        this.progress = progress;
    }
}
