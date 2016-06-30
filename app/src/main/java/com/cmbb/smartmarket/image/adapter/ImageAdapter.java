package com.cmbb.smartmarket.image.adapter;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.cmbb.smartmarket.image.fragment.ImageFragment;
import com.cmbb.smartmarket.image.model.ImageModel;

import java.util.ArrayList;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午11:47
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午11:47
 * 修改备注：
 */
public class ImageAdapter extends FragmentStatePagerAdapter {

    private Context context;
    private ArrayList<ImageModel> lists = new ArrayList<>();

    public ImageAdapter(FragmentManager fm, Context context, ArrayList<ImageModel> data) {
        super(fm);
        this.context = context;
        if (data != null && data.size() > 0) {
            lists.clear();
            lists.addAll(data);
        }
    }

    @Override
    public Fragment getItem(int position) {
        return ImageFragment.newInstance(lists.get(position));
    }

    @Override
    public int getCount() {
        return lists.size();
    }

}
