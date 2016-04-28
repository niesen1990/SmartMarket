package com.cmbb.smartmarket.im.tribe;

import android.os.Bundle;
import android.widget.TextView;

import com.alibaba.mobileim.YWAccount;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.im.IMLoginHelper;

/**
 * Created by weiquanyun on 15/11/9.
 * 测试Activity
 */
public class TribePersonalSettingActivity extends BaseActivity {

    public static final String TAG = TribePersonalSettingActivity.class.getSimpleName();

    private TextView getAllSettings;
    private TextView getCommonSettings;
    private TextView getTribeSettings;
    private TextView getPeerSettings;
    private TextView setTribe;
    private TextView set_msgRemindNoDisturb;
    private TextView set_receiveWwPcOL;
    private TextView set_keepOnline;
    private TextView set_pushWwPcOL;
    private TextView set_nonPushAtNight;
    private TextView setPeer;
    private TextView setCustomSetting;
    private TextView getCustomSetting;
    private YWAccount account;
    private long mTribeId;


    @Override
    protected void init(Bundle savedInstanceState) {
        initViews();
        account = IMLoginHelper.getInstance().getIMKit().getIMCore();
        mTribeId = getIntent().getLongExtra("tribeId", 0);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.im_activity_tribe_personal_setting;
    }

    private void initViews() {
        getAllSettings = (TextView) findViewById(R.id.get_all_settings);
        getCommonSettings = (TextView) findViewById(R.id.get_common_settings);
        getTribeSettings = (TextView) findViewById(R.id.get_tribe_settings);
        getPeerSettings = (TextView) findViewById(R.id.get_peer_settings);
        setTribe = (TextView) findViewById(R.id.set_tribe);
        setPeer = (TextView) findViewById(R.id.set_peer);

        set_msgRemindNoDisturb = (TextView) findViewById(R.id.set_msgRemindNoDisturb);
        set_receiveWwPcOL = (TextView) findViewById(R.id.set_receiveWwPcOL);
        set_keepOnline = (TextView) findViewById(R.id.set_keepOnline);
        set_pushWwPcOL = (TextView) findViewById(R.id.set_pushWwPcOL);
        set_nonPushAtNight = (TextView) findViewById(R.id.set_nonPushAtNight);

        setCustomSetting = (TextView) findViewById(R.id.setCustomSettings);
        getCustomSetting = (TextView) findViewById(R.id.get_custom_settings);

    }
}
