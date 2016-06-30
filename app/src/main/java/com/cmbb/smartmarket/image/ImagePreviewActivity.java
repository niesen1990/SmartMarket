package com.cmbb.smartmarket.image;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.image.adapter.ImageAdapter;
import com.cmbb.smartmarket.image.model.ImageModel;
import com.cmbb.smartmarket.widget.ViewPagerFixed;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/27 下午4:35
 * 修改人：N.Sun
 * 修改时间：16/6/27 下午4:35
 * 修改备注：
 */
public class ImagePreviewActivity extends BaseActivity {

    @BindView(R.id.viewpager)
    ViewPagerFixed viewpager;

    @Override
    protected void init(Bundle savedInstanceState) {
        //        viewpager.setHintView(new PointHintView(this));
        //        viewpager.setPlayDelay(1000 * 60 * 60);
        viewpager.setAdapter(new ImageAdapter(getSupportFragmentManager(), this, getIntent().<ImageModel>getParcelableArrayListExtra("data")));
        viewpager.setCurrentItem(getIntent().getIntExtra("position", 0));
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_image_preview_layout;
    }

    public static void newIntent(Context context, List<ImageModel> data) {
        if (data == null || data.size() == 0)
            return;
        Intent intent = new Intent(context, ImagePreviewActivity.class);
        intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) data);
        context.startActivity(intent);
    }


    /**
     * 无动画
     *
     * @param context
     * @param position
     */
    public static void newIntent(BaseActivity context, int position, List<ImageModel> productImageLists) {
        Intent intent = new Intent(context, ImagePreviewActivity.class);
        intent.putExtra("position", position);
        intent.putParcelableArrayListExtra("data", (ArrayList<? extends Parcelable>) productImageLists);
        context.startActivity(intent);
    }
}
