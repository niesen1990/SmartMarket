package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.log.Log;
import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.util.ArrayList;

import io.github.wangeason.multiphotopicker.PhotoPickerActivity;
import io.github.wangeason.multiphotopicker.utils.PhotoPickerIntent;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午7:57
 */
public class InfoActivity extends BaseActivity {

    private static final java.lang.String TAG = InfoActivity.class.getSimpleName();
    private RelativeLayout rlHead;
    private TextView tvHead;
    private ImageView ivHead;
    private RelativeLayout rlSex;
    private TextView tvSexTag;
    private RelativeLayout rlRule;
    private TextView tvAddressTag;
    private RelativeLayout rlIntroduce;
    private TextView tvIntroduceTag;
    private BottomSheetBehavior behaviorSex;
    private TextView tvBoy, tvGirl;


    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("我的资料");
        initView();
    }

    protected void initView() {
        behaviorSex = BottomSheetBehavior.from(findViewById(R.id.scroll));
        rlHead = (RelativeLayout) findViewById(R.id.rl_head);
        rlHead.setOnClickListener(this);
        tvHead = (TextView) findViewById(R.id.tv_head);
        ivHead = (ImageView) findViewById(R.id.iv_head);
        rlSex = (RelativeLayout) findViewById(R.id.rl_sex);
        rlSex.setOnClickListener(this);
        tvSexTag = (TextView) findViewById(R.id.tv_sex_tag);
        rlRule = (RelativeLayout) findViewById(R.id.rl_rule);
        rlRule.setOnClickListener(this);
        tvAddressTag = (TextView) findViewById(R.id.tv_address_tag);
        rlIntroduce = (RelativeLayout) findViewById(R.id.rl_introduce);
        rlIntroduce.setOnClickListener(this);
        tvIntroduceTag = (TextView) findViewById(R.id.tv_introduce_tag);
        tvBoy = (TextView) findViewById(R.id.tv_boy);
        tvBoy.setOnClickListener(this);
        tvGirl = (TextView) findViewById(R.id.tv_girl);
        tvGirl.setOnClickListener(this);
    }

    private final int PIC_REQUEST_CODE = 1001;

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_head:
                PhotoPickerIntent intent = new PhotoPickerIntent(this);
                intent.setMultiChoose(false);
                intent.setPhotoCount(1);
                intent.setShowCamera(true);
                startActivityForResult(intent, PIC_REQUEST_CODE);

               /* Intent intent = new Intent(MainActivity.this, PhotoPagerActivity.class);
                intent.putExtra(PhotoPagerActivity.EXTRA_CURRENT_ITEM, position);
                intent.putExtra(PhotoPagerActivity.EXTRA_PHOTOS, imgPaths);
                startActivityForResult(intent, MODIFY_CHOOSE);*/
                break;
            case R.id.rl_sex:
                intro(rlSex);
                break;
            case R.id.rl_rule:
                break;
            case R.id.rl_introduce:
                break;
            case R.id.tv_boy:
                showToast("boy");
                behaviorSex.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
            case R.id.tv_girl:
                showToast("girl");
                behaviorSex.setState(BottomSheetBehavior.STATE_COLLAPSED);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_info_layout;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == PIC_REQUEST_CODE && data != null) {
            final ArrayList<String> tempUrls = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            Uri source = Uri.fromFile(new File(tempUrls.get(0)));
            Uri destination = Uri.fromFile(new File(getCacheDir(), "cache_head"));
            Crop.of(source, destination).start(this);
        } else if (resultCode == -1 && requestCode == Crop.REQUEST_CROP) {
            if (Crop.getOutput(data) != null) {
                Log.i(TAG, Crop.getOutput(data).getPath());
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void intro(View view) {
        if (behaviorSex.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behaviorSex.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behaviorSex.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, InfoActivity.class);
        context.startActivity(intent);
    }
}
