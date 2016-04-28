package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.SystemMessageActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:34
 */
public class HomeMessageActivity extends BaseHomeActivity {

    private RelativeLayout mainContent;
    private RelativeLayout rlSys;
    private FrameLayout fl;
    private ImageView tvSys;
    private TextView tvMessageSysCount;
    private TextView tvSysContent;
    private TextView tvSysTime;
    private RelativeLayout rlStore;
    private FrameLayout flStore;
    private ImageView tvStore;
    private TextView tvMessageStoreCount;
    private TextView tvStoreContent;
    private TextView tvStoreTime;
    private RelativeLayout rlOrder;
    private FrameLayout flOrder;
    private ImageView tvOrder;
    private TextView tvMessageOrderCount;
    private TextView tvOrderContent;
    private TextView tvOrderTime;
    private RelativeLayout rlChat;
    private FrameLayout flChat;
    private ImageView tvChat;
    private TextView tvMessageChatCount;
    private TextView tvChatContent;
    private TextView tvChatTime;

    protected void init() {
        mainContent = (RelativeLayout) findViewById(R.id.main_content);
        rlSys = (RelativeLayout) findViewById(R.id.rl_sys);
        rlSys.setOnClickListener(this);
        fl = (FrameLayout) findViewById(R.id.fl);
        tvSys = (ImageView) findViewById(R.id.tv_sys);
        tvMessageSysCount = (TextView) findViewById(R.id.tv_message_sys_count);
        tvSysContent = (TextView) findViewById(R.id.tv_sys_content);
        tvSysTime = (TextView) findViewById(R.id.tv_sys_time);
        rlStore = (RelativeLayout) findViewById(R.id.rl_store);
        rlStore.setOnClickListener(this);
        flStore = (FrameLayout) findViewById(R.id.fl_store);
        tvStore = (ImageView) findViewById(R.id.tv_store);
        tvMessageStoreCount = (TextView) findViewById(R.id.tv_message_store_count);
        tvStoreContent = (TextView) findViewById(R.id.tv_store_content);
        tvStoreTime = (TextView) findViewById(R.id.tv_store_time);
        rlOrder = (RelativeLayout) findViewById(R.id.rl_order);
        rlOrder.setOnClickListener(this);
        flOrder = (FrameLayout) findViewById(R.id.fl_order);
        tvOrder = (ImageView) findViewById(R.id.tv_order);
        tvMessageOrderCount = (TextView) findViewById(R.id.tv_message_order_count);
        tvOrderContent = (TextView) findViewById(R.id.tv_order_content);
        tvOrderTime = (TextView) findViewById(R.id.tv_order_time);
        rlChat = (RelativeLayout) findViewById(R.id.rl_chat);
        rlChat.setOnClickListener(this);
        flChat = (FrameLayout) findViewById(R.id.fl_chat);
        tvChat = (ImageView) findViewById(R.id.tv_chat);
        tvMessageChatCount = (TextView) findViewById(R.id.tv_message_chat_count);
        tvChatContent = (TextView) findViewById(R.id.tv_chat_content);
        tvChatTime = (TextView) findViewById(R.id.tv_chat_time);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        setTitle("消息");
        init();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_sys:
                SystemMessageActivity.newIntent(this);
                break;
            case R.id.rl_store:
                break;
            case R.id.rl_order:
                break;
            case R.id.rl_chat:
                break;
        }
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_message;
    }


    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeMessageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
