package com.cmbb.smartmarket.image;

import android.content.Context;
import android.text.TextUtils;
import android.widget.ImageView;

import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.utils.TDevice;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;
import com.zhy.http.okhttp.OkHttpUtils;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/20 下午5:08
 */
public class PicassoLoader {

    private static Picasso picasso;
    private static OkHttp3Downloader okHttp3Downloader;
    private static int width_Screen;

    public static void init(Context context) {
        okHttp3Downloader = new OkHttp3Downloader(OkHttpUtils.getInstance().getOkHttpClient());
        picasso = new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();
        width_Screen = TDevice.getScreenWidth(context);
    }


    public static void loadImageWithResize(Context context, String url, ImageView into, String width, String height) {
        picasso.with(context)
                .load(url)
                .resize(width_Screen, calculateHeight(width, height)) // resizes the image to these dimensions (in pixel). does not respect aspect ratio
                .into(into);
    }

    public static void loadImageWithResizeCenterCrop(Context context, String url, ImageView into, String width, String height) {
        picasso.with(context)
                .load(url)
                .resize(width_Screen, calculateHeight(width, height)) // resizes the image to these dimensions (in pixel)
                .centerCrop() // this cropping technique scales the image so that it fills the requested bounds and then crops the extra.
                .into(into);
    }

    public static void loadImageWithResizeCenterInside(Context context, String url, ImageView into, String width, String height) {
        picasso.with(context)
                .load(url)
                .resize(width_Screen, calculateHeight(width, height))
                .centerInside() // this scales the image so that both dimensions are equal to or less than the requested bounds.
                .into(into);
    }

    public static void loadImageWithResizeScaleDown(Context context, String url, ImageView into, String width, String height) {
        picasso.with(context)
                .load(url)
                .resize(width_Screen, calculateHeight(width, height))
                .onlyScaleDown() // the image will only be resized if it's bigger than 6000x2000 pixels.
                .into(into);
    }

    public static void loadImageWithFit(Context context, String url, ImageView into) {
        picasso.with(context)
                .load(url)
                .fit().centerCrop()
                // call  .centerInside() or .centerCrop() to avoid a stretched image
                .into(into);
    }

    private static int calculateHeight(String width, String height) {
        if (!TextUtils.isEmpty(width) && !TextUtils.isEmpty(height)) {
            float w = Float.parseFloat(width);
            float h = Float.parseFloat(height);
            float rs = w / h;
            Log.i("height", "height = " + (int) (width_Screen / rs));
            return (int) (width_Screen / rs);
        } else {
            return 100;
        }
    }
}
