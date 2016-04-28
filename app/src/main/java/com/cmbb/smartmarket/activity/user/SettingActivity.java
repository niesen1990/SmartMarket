package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.im.IMLoginHelper;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.umeng.socialize.UMShareAPI;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午7:41
 */
public class SettingActivity extends BaseActivity {

    private RelativeLayout rlAbout;
    private RelativeLayout rlSuggestion;
    private RelativeLayout rlRule;
    private RelativeLayout rlShare;
    private TextView tvLogout;

    protected void initView() {
        rlAbout = (RelativeLayout) findViewById(R.id.rl_about);
        rlAbout.setOnClickListener(this);
        rlSuggestion = (RelativeLayout) findViewById(R.id.rl_suggestion);
        rlSuggestion.setOnClickListener(this);
        rlRule = (RelativeLayout) findViewById(R.id.rl_rule);
        rlRule.setOnClickListener(this);
        rlShare = (RelativeLayout) findViewById(R.id.rl_share);
        rlShare.setOnClickListener(this);
        tvLogout = (TextView) findViewById(R.id.tv_logout);
        tvLogout.setOnClickListener(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("设置");
        initView();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_about:

                break;
            case R.id.rl_suggestion:
                break;
            case R.id.rl_rule:

                break;
            case R.id.rl_share:
                SocialUtils.share(this, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", "魅族手机PRO6", "MEIZU design and make", "http://www.baidu.com");
                break;
            case R.id.tv_logout:
                // TODO: 16/4/27
                LoginActivity.newIntent(this);
                IMLoginHelper.getInstance().loginOutIM();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting_layout;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }
}
