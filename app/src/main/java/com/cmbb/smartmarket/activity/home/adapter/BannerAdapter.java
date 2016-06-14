package com.cmbb.smartmarket.activity.home.adapter;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketHomeAdvertInfoResponseModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.jude.rollviewpager.adapter.StaticPagerAdapter;
import com.thefinestartist.finestwebview.FinestWebView;

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
                if (list.get(position) != null && !TextUtils.isEmpty(list.get(position).getRedirectUrl()))
                    new FinestWebView.Builder(v.getContext())
                            .theme(R.style.FinestWebViewTheme)
                            .titleDefault("萌宝铺子")
                            .showUrl(false)
                            .statusBarColorRes(R.color.colorPrimary)
                            .toolbarColorRes(R.color.colorPrimary)
                            .titleColorRes(R.color.finestWhite)
                            .urlColorRes(R.color.colorPrimary)
                            .iconDefaultColorRes(R.color.finestWhite)
                            .progressBarColorRes(R.color.finestWhite)
                            .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                            .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                            .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                            .showSwipeRefreshLayout(false)
                            .showIconMenu(false)
                            .dividerHeight(0)
                            .gradientDivider(false)
                            .show(list.get(position).getRedirectUrl());
            }
        });
        return imageView;
    }

    @Override
    public int getCount() {
        return list.size();
    }
}
