package com.cmbb.smartmarket.activity.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.AdModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/20 下午4:29
 */
public class BannerAdapter extends StaticPagerAdapter {
    private static final java.lang.String TAG = BannerAdapter.class.getSimpleName();
    private List<AdModel> list;

    public BannerAdapter() {
        list = new ArrayList<>();
        list.add(new AdModel("http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", "1", "3521", "1599"));
        list.add(new AdModel("http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", "2", "3521", "1599"));
        list.add(new AdModel("http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", "3", "3521", "1599"));
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.banner_image, null);
        //        ImageView imageView = new ImageView(container.getContext());
        //        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 480);
        //        imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
        //加载图片
        //        PicassoLoader.loadImageWithResizeCenterCrop(container.getContext(), list.get(position).getImg(), imageView, list.get(position).getWidth(), list.get(position).getHeight());
        //        PicassoLoader.loadImageWithFit(container.getContext(), list.get(position).getImg(), imageView);

        ImageLoader.loadUrlAndDiskCache(container.getContext(), list.get(position).getImg(), imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, list.get(position).getImg());
            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
