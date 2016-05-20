package com.cmbb.smartmarket.image;

import android.content.Context;
import android.support.annotation.DrawableRes;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.cmbb.smartmarket.R;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/10 上午9:27
 * 修改人：N.Sun
 * 修改时间：16/5/10 上午9:27
 * 修改备注：
 */
public class ImageLoader {

    public static void load(Context context, @DrawableRes int imageRes, ImageView view) {
        Glide.with(context).load(imageRes).crossFade().into(view);
    }

    public static void loadAndDiskCache(Context context, @DrawableRes int imageRes, ImageView view) {
        Glide.with(context).load(imageRes).diskCacheStrategy(DiskCacheStrategy.ALL).crossFade().into(view);
    }

    public static void loadUrlAndDiskCache(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.line)
                .error(R.color.darkgray)
                .crossFade()
                .fitCenter()
                .into(imageView);
    }

    public static void loadCenterCropCache(Context context, String url, ImageView imageView) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.line)
                .error(R.color.darkgray)
                .crossFade()
                .centerCrop()
                .into(imageView);
    }

    public static void loadUrlAndDiskCache(Context context, String url, ImageView imageView, BitmapTransformation bitmapTransformation) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.line)
                .error(R.color.darkgray)
                .crossFade()
                .fitCenter()
                .transform(bitmapTransformation)
                .into(imageView);
    }
}

