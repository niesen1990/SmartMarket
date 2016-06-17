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
public class MamiRecommendActivity extends BaseRecommendActivity {

    @Override
    protected void initRecommend() {
        setTitle("妈妈商品");
        setParentClassify("MMYP");
    }

    public static void newIntent(Context context,ActivityOptionsCompat activityOptionsCompat) {
        Intent intent = new Intent(context, MamiRecommendActivity.class);
        context.startActivity(intent,activityOptionsCompat.toBundle());
    }
}
