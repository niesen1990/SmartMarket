package com.cmbb.smartmarket.activity.market.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.ProductDetailResponseModel;
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
public class BannerDetailListAdapter extends StaticPagerAdapter {
    private static final String TAG = BannerDetailListAdapter.class.getSimpleName();
    private List<ProductDetailResponseModel.DataEntity.ProductImageListEntity> list;

    public BannerDetailListAdapter() {
        list = new ArrayList<>();
    }

    public void updateList(List<ProductDetailResponseModel.DataEntity.ProductImageListEntity> data) {
        if (data == null || data.size() == 0)
            return;
        this.list.clear();
        this.list.addAll(data);
        notifyDataSetChanged();
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.banner_image, null);
        ImageLoader.loadCenterCropCache(container.getContext(), list.get(position).getLocation(), imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, list.get(position).getLocation());
            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
