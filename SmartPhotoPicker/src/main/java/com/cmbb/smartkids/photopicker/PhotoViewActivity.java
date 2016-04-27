package com.cmbb.smartkids.photopicker;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.cmbb.smartkids.photopicker.widget.MultiTouchViewPager;
import com.cmbb.smartkids.photopicker.widget.indication.CirclePageIndicator;
import com.squareup.picasso.Callback;
import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;


/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/11/19 下午8:13
 */
public class PhotoViewActivity extends AppCompatActivity {

    private static final String TAG = PhotoViewActivity.class.getSimpleName();

    private ArrayList<String> mDrawables = new ArrayList<>();
    private int index;
    private boolean showIndicator;
    PhotoViewAttacher mAttacher;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_photo_view);
        mDrawables = getIntent().getStringArrayListExtra("Images");
        index = getIntent().getIntExtra("index", 0);
        showIndicator = getIntent().getBooleanExtra("show", true);
        CirclePageIndicator indicator = (CirclePageIndicator) findViewById(R.id.indicator);
        MultiTouchViewPager viewPager = (MultiTouchViewPager) findViewById(R.id.view_pager);
        viewPager.setAdapter(new DraweePagerAdapter());
        indicator.setViewPager(viewPager);
        viewPager.setCurrentItem(index);
        if (!showIndicator) {
            indicator.setVisibility(View.GONE);
        } else {
            indicator.setVisibility(View.VISIBLE);
        }
    }


    public static void IntentPhotoView(Context context, ArrayList<String> images) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putStringArrayListExtra("Images", images);
        context.startActivity(intent);
    }

    public static void IntentPhotoView(Context context, ArrayList<String> images, int position) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putStringArrayListExtra("Images", images);
        intent.putExtra("index", position);
        context.startActivity(intent);
    }

    public static void IntentPhotoView(Context context, ArrayList<String> images, int position, boolean showIndicator) {
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putStringArrayListExtra("Images", images);
        intent.putExtra("index", position);
        intent.putExtra("show", showIndicator);
        context.startActivity(intent);
    }

    public static void IntentPhotoView(Context context, String image) {
        ArrayList<String> ls = new ArrayList<>();
        ls.add(image);
        Intent intent = new Intent(context, PhotoViewActivity.class);
        intent.putStringArrayListExtra("Images", ls);
        context.startActivity(intent);
    }


    public class DraweePagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mDrawables.size();
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

        @Override
        public ImageView instantiateItem(ViewGroup viewGroup, final int position) {
            final PhotoView imageView = (PhotoView) LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_photo_view, viewGroup, false);
            final String uri;
            if (mDrawables.get(position).contains("file://")) {
                uri = mDrawables.get(position);
            } else if (mDrawables.get(position).contains("http://") || mDrawables.get(position).contains("https://")) {
                uri = mDrawables.get(position) + "@watermark=1&object=YXBwL3dhdGVybWFyay93YXRlcm1hcmtfNC5wbmdAMTAwdw&p=9";
            } else {
                uri = "file://" + mDrawables.get(position);
            }
            Picasso.with(viewGroup.getContext())
                    .load(uri)
                    .into(imageView, new Callback() {
                        @Override
                        public void onSuccess() {
                            if (mAttacher != null) {
                                mAttacher.update();
                            } else {
                                mAttacher = new PhotoViewAttacher(imageView);
                            }
                        }

                        @Override
                        public void onError() {

                        }
                    });
            return imageView;
        }
    }


    public void saveBitmap(Bitmap bm, String picName) {
        Log.e(TAG, "保存图片");
        File f = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES), picName);
        if (f.exists()) {
            f.delete();
        }
        try {
            FileOutputStream out = new FileOutputStream(f);
            bm.compress(Bitmap.CompressFormat.PNG, 100, out);
            out.flush();
            out.close();
            Toast.makeText(PhotoViewActivity.this, "图片保存成功", Toast.LENGTH_SHORT).show();
            // 最后通知图库更新
            sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + f.getAbsolutePath())));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


}
