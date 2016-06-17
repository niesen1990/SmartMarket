package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;

import com.cmbb.smartmarket.activity.market.model.ProductGetPageRequestModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.ApiInterface;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/4 下午1:27
 * 修改人：N.Sun
 * 修改时间：16/5/4 下午1:27
 * 修改备注：
 */
public class OfficialRecommendActivity extends BaseRecommendActivity {

    @Override
    protected void initRecommend() {
        setTitle("官方推荐");
    }

    protected ProductGetPageRequestModel setParams() {
        ProductGetPageRequestModel productGetPageRequestModel = new ProductGetPageRequestModel();
        productGetPageRequestModel.setToken(BaseApplication.getToken());
        productGetPageRequestModel.setCmd(ApiInterface.ProductGetPage);
        productGetPageRequestModel.setParameters(new ProductGetPageRequestModel.ParametersEntity(0, "1", pagerSize, pager));
        return productGetPageRequestModel;
    }

    public static void newIntent(Context context, ActivityOptionsCompat activityOptionsCompat) {
        Intent intent = new Intent(context, OfficialRecommendActivity.class);
        context.startActivity(intent, activityOptionsCompat.toBundle());
    }
}
