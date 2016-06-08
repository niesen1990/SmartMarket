package com.cmbb.smartmarket.activity.user.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;

import com.cmbb.smartmarket.activity.user.fragment.ForNeedFragment;
import com.cmbb.smartmarket.activity.user.fragment.OnSellFragment;
import com.cmbb.smartmarket.base.BaseRecyclerFragment;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午11:47
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午11:47
 * 修改备注：
 */
public class UserCenterFragmentAdapter extends FragmentStatePagerAdapter {

    final int PAGE_COUNT = 2;
    private String tabTitles[] = new String[]{"在售商品", "求购商品"};
    private Context context;
    private int userId;

    private BaseRecyclerFragment currentFragment;

    public UserCenterFragmentAdapter(FragmentManager fm, Context context, int userId) {
        super(fm);
        this.userId = userId;
        this.context = context;
    }

    public BaseRecyclerFragment getCurrentFragment() {
        return currentFragment;
    }

    public void setCurrentFragment(BaseRecyclerFragment currentFragment) {
        this.currentFragment = currentFragment;
    }

    @Override
    public void setPrimaryItem(ViewGroup container, int position, Object object) {
        currentFragment = (BaseRecyclerFragment) object;
        super.setPrimaryItem(container, position, object);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                currentFragment = OnSellFragment.newInstance(userId);
                break;
            case 1:
                currentFragment = ForNeedFragment.newInstance(userId);
                break;
        }
        return currentFragment;
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
