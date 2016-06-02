package com.cmbb.smartmarket.activity.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketHomeAdvertInfoResponseModel;
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
    private List<MarketHomeAdvertInfoResponseModel.DataEntity> list = new ArrayList<>();

    public BannerAdapter(ArrayList<MarketHomeAdvertInfoResponseModel.DataEntity> entities) {
        if (entities != null && entities.size() > 0) {
            list.addAll(entities);
        }
    }

    public void updateList(List<MarketHomeAdvertInfoResponseModel.DataEntity> entities) {
        if (entities != null && entities.size() > 0) {
            list.clear();
            list.addAll(entities);
            notifyDataSetChanged();
        }
    }

    @Override
    public View getView(ViewGroup container, final int position) {
        ImageView imageView = (ImageView) LayoutInflater.from(container.getContext()).inflate(R.layout.banner_image, null);
        ImageLoader.loadUrlAndDiskCache(container.getContext(), list.get(position).getAdImg(), imageView);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(TAG, list.get(position).getAdImg());
            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
