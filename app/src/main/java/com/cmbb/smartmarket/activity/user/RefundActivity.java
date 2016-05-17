package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.RefundFragmentAdapter;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午11:34
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午11:34
 * 修改备注：
 */
public class RefundActivity extends BaseActivity {

    private static final String TAG = RefundActivity.class.getSimpleName();

    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("退款管理");
        viewpager.setAdapter(new RefundFragmentAdapter(getSupportFragmentManager(), this));
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_refund_layout;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, RefundActivity.class);
        context.startActivity(intent);
    }

}
