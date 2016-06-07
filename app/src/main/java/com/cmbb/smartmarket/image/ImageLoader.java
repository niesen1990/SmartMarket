package com.cmbb.smartmarket.image;

import android.content.Context;
import android.os.AsyncTask;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.DrawableRes;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.GlideDrawableImageViewTarget;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.ImageUploadResponseModel;
import com.cmbb.smartmarket.activity.market.model.PublishImageModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.HttpMethod;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;

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

    private static final String TAG = ImageLoader.class.getSimpleName();
    private static Handler handler = new Handler(Looper.myLooper());

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

    public static void loadWithUploadListener(final Context context, final PublishImageModel row, final ImageView imageView, final ProgressBar progressBar) {
        Glide.with(context)
                .load(row.getImageUrl())
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.color.line)
                .error(R.color.darkgray)
                .crossFade()
                .centerCrop()
                .into(new GlideDrawableImageViewTarget(imageView) {
                    @Override
                    public void onResourceReady(GlideDrawable resource, GlideAnimation<? super GlideDrawable> animation) {
                        // here it's similar to RequestListener, but with less information (e.g. no model available)
                        super.onResourceReady(resource, animation);
                        // here you can be sure it's already set
                        //上传
                        Log.e(TAG, "上传");
                        if (TextUtils.isEmpty(row.getBusinessNumber())) {
                            progressBar.setVisibility(View.VISIBLE);
                            new AsyncTask<String, Void, Map<String, RequestBody>>() {
                                @Override
                                protected Map<String, RequestBody> doInBackground(String... params) {
                                    return setUploadParams(params[0]);
                                }

                                @Override
                                protected void onPostExecute(Map<String, RequestBody> stringRequestBodyMap) {
                                    row.setSubscription(HttpMethod.getInstance().uploadImageWithProgress(new Observer<ImageUploadResponseModel>() {
                                        @Override
                                        public void onCompleted() {

                                        }

                                        @Override
                                        public void onError(Throwable e) {
                                            Log.e(TAG, e.toString());
                                            progressBar.setVisibility(View.GONE);
                                            imageView.setImageResource(R.drawable.ic_refresh);
                                            imageView.setOnClickListener(new View.OnClickListener() {
                                                @Override
                                                public void onClick(View v) {
                                                    progressBar.setVisibility(View.VISIBLE);
                                                    loadWithUploadListener(context, row, imageView, progressBar);
                                                }
                                            });
                                        }

                                        @Override
                                        public void onNext(ImageUploadResponseModel imageUploadResponseModel) {
                                            progressBar.setVisibility(View.GONE);
                                            imageView.setOnClickListener(null);
                                            row.setBusinessNumber(imageUploadResponseModel.getData().get(0).getBusinessNumber());
                                        }
                                    }, stringRequestBodyMap));
                                }
                            }.execute(row.getImageUrl());
                        } else {
                            progressBar.setVisibility(View.GONE);
                        }
                    }

                    // +++++ OR +++++
                    @Override
                    protected void setResource(GlideDrawable resource) {
                        // this.getView().setImageDrawable(resource); is about to be called
                        super.setResource(resource);
                        // here you can be sure it's already set
                    }
                });
    }

    private static Map<String, RequestBody> setUploadParams(String url) {
        Map<String, RequestBody> params = new HashMap<>();
        params.put("token", RequestBody.create(MediaType.parse("text/plain"), BaseApplication.getToken()));
        params.put("type", RequestBody.create(MediaType.parse("text/plain"), "1"));
        params.put("imageList\"; filename=\"" + "image" + "\"", RequestBody.create(MediaType.parse("image/*"), ExifUtils.decodeFile(url).toByteArray()));
        return params;
    }

    public static void loadUrlAndDiskCache(Context context, String url, ImageView imageView, BitmapTransformation bitmapTransformation) {
        Glide.with(context)
                .load(url)
                .diskCacheStrategy(DiskCacheStrategy.SOURCE)
                .placeholder(R.drawable.ic_head_default)
                .error(R.drawable.ic_head_default)
                .crossFade()
                .fitCenter()
                .transform(bitmapTransformation)
                .into(imageView);

    }
}

