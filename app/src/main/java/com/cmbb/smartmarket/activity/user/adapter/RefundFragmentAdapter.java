package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cmbb.smartmarket.activity.user.fragment.RefundBuyFragment;
import com.cmbb.smartmarket.activity.user.fragment.RefundSellFragment;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午11:47
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午11:47
 * 修改备注：
 */
public class RefundFragmentAdapter extends FragmentStatePagerAdapter {

    private static final String TAG = RefundFragmentAdapter.class.getSimpleName();
    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"出售", "购买"};
    private Context context;

    public RefundFragmentAdapter(FragmentManager fm, Context context) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return RefundSellFragment.newInstance(position);
            case 1:
                return RefundBuyFragment.newInstance(position);
            default:
                return RefundSellFragment.newInstance(position);
        }
    }

    @Override
    public int getCount() {
        return PAGE_COUNT;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabTitles[position];
    }
}
