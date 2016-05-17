package com.cmbb.smartmarket.activity.home.holder;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.TestModel;
import com.cmbb.smartmarket.image.ImageLoader;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class HomeItemHolder extends BaseViewHolder<TestModel.DataEntity.RowsEntity> {
    private final String TAG = HomeItemHolder.class.getSimpleName();
    private ImageView ivHead;
    private ImageView iv01;
    private ImageView iv02;
    private ImageView iv03;
    private TextView tvNick;
    private TextView tvTime;
    private LinearLayout llImages;
    private TextView tvContent;
    private RelativeLayout rlContent;
    private TextView tvNewPrice;
    private TextView tvOldPrice;
    private RelativeLayout rlBottom;
    private TextView tvAddress;
    private TextView tvMessage;
    private TextView tvWatch;

    Context mContext;

    public HomeItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_home_pager_list_item);
        mContext = parent.getContext();
        ivHead = $(R.id.iv_head);
        iv01 = $(R.id.iv01);
        iv02 = $(R.id.iv02);
        iv03 = $(R.id.iv03);
        tvNick = $(R.id.tv_nick);
        tvTime = $(R.id.tv_time);
        llImages = $(R.id.ll_images);
        tvContent = $(R.id.tv_content);
        rlContent = $(R.id.rl_content);
        tvNewPrice = $(R.id.tv_new_price);
        tvOldPrice = $(R.id.tv_old_price);
        rlBottom = $(R.id.rl_bottom);
        tvAddress = $(R.id.tv_address);
        tvMessage = $(R.id.tv_message);
        tvWatch = $(R.id.tv_watch);
    }

    public void setData(TestModel.DataEntity.RowsEntity row) {
        ImageLoader.loadUrlAndDiskCache(mContext, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", iv01);
        ImageLoader.loadUrlAndDiskCache(mContext, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", iv02);
        ImageLoader.loadUrlAndDiskCache(mContext, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", iv03);
    }
}
