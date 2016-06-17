package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.ActivityOptionsCompat;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/4 下午1:27
 * 修改人：N.Sun
 * 修改时间：16/5/4 下午1:27
 * 修改备注：
 */
public class BabyRecommendActivity extends BaseRecommendActivity {
    private static final String TAG = BabyRecommendActivity.class.getSimpleName();

    @Override
    protected void initRecommend() {
        setTitle("宝宝用品");
        setParentClassify("BBYP");
    }

    public static void newIntent(Context context,ActivityOptionsCompat activityOptionsCompat) {
        Intent intent = new Intent(context, BabyRecommendActivity.class);
        context.startActivity(intent,activityOptionsCompat.toBundle());
    }

}
