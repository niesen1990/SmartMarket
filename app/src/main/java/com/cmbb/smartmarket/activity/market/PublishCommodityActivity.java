package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.cmbb.smartkids.recyclerview.SmartRecyclerView;
import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.PublishItemAdapter;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.utils.TDevice;

import java.util.ArrayList;

import io.github.wangeason.multiphotopicker.PhotoPickerActivity;
import io.github.wangeason.multiphotopicker.utils.PhotoPickerIntent;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/28 下午12:54
 */
public class PublishCommodityActivity extends BaseActivity {
    protected RecyclerArrayAdapter adapter;
    protected SmartRecyclerView mSmartRecyclerView;
    protected RecyclerArrayAdapter.ItemView footerItemView;
    private final int PIC_REQUEST_CODE = 1001;

    protected int imgCount = 5;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("发布");
        initRecyclerView();
        footerItemView = new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                ImageView imageView = new ImageView(PublishCommodityActivity.this);
                imageView.setId(R.id.tv_boy);
                imageView.setImageResource(android.R.drawable.ic_menu_add);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(TDevice.dip2px(84, PublishCommodityActivity.this), TDevice.dip2px(84, PublishCommodityActivity.this)));
                return imageView;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (imgCount == 0) {
                            showToast("最多添加5张图片");
                            return;
                        }
                        PhotoPickerIntent intent = new PhotoPickerIntent(PublishCommodityActivity.this);
                        intent.setMultiChoose(true);
                        intent.setPhotoCount(imgCount);
                        intent.setShowCamera(true);
                        startActivityForResult(intent, PIC_REQUEST_CODE);
                    }
                });
            }
        };
        adapter.addFooter(footerItemView);
    }

    private void initRecyclerView() {
        mSmartRecyclerView = (SmartRecyclerView) findViewById(R.id.recyclerView);
        if (mSmartRecyclerView == null) return;
        mSmartRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new PublishItemAdapter(this);
        mSmartRecyclerView.setAdapterWithProgress(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish_commodity_layout;
    }


    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.iv:

                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == PIC_REQUEST_CODE && data != null) {
            final ArrayList<String> tempUrls = data.getStringArrayListExtra(PhotoPickerActivity.KEY_SELECTED_PHOTOS);
            adapter.addAll(tempUrls);
            if (imgCount != 0)
                imgCount = imgCount - tempUrls.size();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }


    public static void newIntent(Context context) {
        Intent intent = new Intent(context, PublishCommodityActivity.class);
        context.startActivity(intent);
    }
}
