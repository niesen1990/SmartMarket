package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartkids.recyclerview.adapter.RecyclerArrayAdapter;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.InfoActivity;
import com.cmbb.smartmarket.activity.user.SettingActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:34
 */
public class HomeMeActivity extends BaseHomeActivity {
    private static final String TAG = HomeMeActivity.class.getSimpleName();

    private ImageView ivHead;
    private TextView tvNick;
    private TextView tvSex;
    private TextView tvLine01;
    private TextView tvAddress;
    private RelativeLayout rlWallet;
    private RelativeLayout rlInfo;
    private RelativeLayout rlRefund;
    private RelativeLayout rlPublish;
    private RelativeLayout rlSelled;
    private RelativeLayout rlBuy;
    private RelativeLayout rlCollection;
    private RelativeLayout rlOff;
    private RelativeLayout rlAddress;

    protected void init() {
        ivHead = (ImageView) findViewById(R.id.iv_head);
        tvNick = (TextView) findViewById(R.id.tv_nick);
        tvSex = (TextView) findViewById(R.id.tv_sex);
        tvLine01 = (TextView) findViewById(R.id.tv_line01);
        tvAddress = (TextView) findViewById(R.id.tv_address);
        rlWallet = (RelativeLayout) findViewById(R.id.rl_wallet);
        rlWallet.setOnClickListener(this);
        rlInfo = (RelativeLayout) findViewById(R.id.rl_info);
        rlInfo.setOnClickListener(this);
        rlRefund = (RelativeLayout) findViewById(R.id.rl_refund);
        rlRefund.setOnClickListener(this);
        rlPublish = (RelativeLayout) findViewById(R.id.rl_publish);
        rlPublish.setOnClickListener(this);
        rlSelled = (RelativeLayout) findViewById(R.id.rl_selled);
        rlSelled.setOnClickListener(this);
        rlBuy = (RelativeLayout) findViewById(R.id.rl_buy);
        rlBuy.setOnClickListener(this);
        rlCollection = (RelativeLayout) findViewById(R.id.rl_collection);
        rlCollection.setOnClickListener(this);
        rlOff = (RelativeLayout) findViewById(R.id.rl_off);
        rlOff.setOnClickListener(this);
        rlAddress = (RelativeLayout) findViewById(R.id.rl_address);
        rlAddress.setOnClickListener(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        setTitle("我的");
        init();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_wallet:
                break;
            case R.id.rl_info:
                InfoActivity.newIntent(this);
                break;
            case R.id.rl_refund:
                break;
            case R.id.rl_publish:
                break;
            case R.id.rl_selled:
                break;
            case R.id.rl_buy:
                break;
            case R.id.rl_collection:
                break;
            case R.id.rl_off:
                break;
            case R.id.rl_address:
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_me;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                SettingActivity.newIntent(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return null;
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
        Intent intent = new Intent(context, HomeMeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
