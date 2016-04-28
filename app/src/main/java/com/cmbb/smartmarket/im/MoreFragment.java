package com.cmbb.smartmarket.im;


import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.alibaba.mobileim.IYWLoginService;
import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.channel.util.WxLog;
import com.alibaba.mobileim.channel.util.YWLog;
import com.alibaba.mobileim.contact.IYWContact;
import com.alibaba.mobileim.conversation.IYWMessageListener;
import com.alibaba.mobileim.conversation.YWMessage;
import com.alibaba.mobileim.fundamental.widget.YWAlertDialog;
import com.alibaba.mobileim.login.YWLoginState;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.im.commom.IMSharePreferenceKVStore;
import com.cmbb.smartmarket.im.commom.Notification;
import com.cmbb.smartmarket.im.custom.IMWebViewActivity;
import com.cmbb.smartmarket.im.test.MultiAccountTestActivity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class MoreFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = MoreFragment.class
            .getSimpleName();
    private static final String PAGE1 = "http://chuye.cloud7.com.cn/7086991";
    private static final String PAGE2 = "http://im.baichuan.taobao.com";
    private Activity mContext;
    private String mUserId;
    private View logout;
    private View mView;
    private YWIMKit mIMKit;
    private CheckBox soundCheckBox;
    private CheckBox vibrationCheckBox;
    private CheckBox quietCheckBox;
    private NotificationInitHelper mNotificationSettings;

    public MoreFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mIMKit = IMLoginHelper.getInstance().getIMKit();
        if (mIMKit == null) {
            return;
        }
        mUserId = mIMKit.getIMCore().getLoginUserId();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mContext = getActivity();
        // Inflate the layout for this fragment
        mView = inflater.inflate(R.layout.im_fragment_more, container, false);
        init();
        return mView;
    }

    protected void init() {
        mContext.getWindow().setWindowAnimations(0);
        initTitle();
        initNotificationSettings();
        logout = mView.findViewById(R.id.more_logout);
        logout.setOnClickListener(this);

        TextView getBlackList = (TextView) mView.findViewById(R.id.sync_black_list);
        getBlackList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //获取黑名单列表
                mIMKit.getIMCore().getContactManager().syncBlackContacts(new IWxCallback() {
                    @Override
                    public void onSuccess(Object... obj) {
                        List<IYWContact> blackList = (List<IYWContact>) obj[0];
                        StringBuilder builder = new StringBuilder();
                        if (blackList != null && blackList.size() > 0) {
                            for (IYWContact user : blackList) {
                                builder.append(user.getAppKey()).append(user.getUserId()).append("\n");
                            }
                        }
                        if (TextUtils.isEmpty(builder.toString())) {
                            Notification.showToastMsg(mContext, "黑名单列表为空~");
                        } else {
                            Notification.showToastMsg(mContext, builder.toString());
                            WxLog.i(TAG, builder.toString());
                        }
                    }

                    @Override
                    public void onError(int code, String info) {
                        Notification.showToastMsg(mContext, "getBlackList error, code = " + code + ", info = " + info);
                    }

                    @Override
                    public void onProgress(int progress) {

                    }
                });
            }
        });
        initTest();
    }

    private void initTitle() {
        RelativeLayout titleBar = (RelativeLayout) mView.findViewById(R.id.title_bar);
        TextView titleView = (TextView) mView.findViewById(R.id.title_self_title);
        TextView leftButton = (TextView) mView.findViewById(R.id.left_button);

        titleBar.setBackgroundColor(Color.parseColor("#00b4ff"));
        titleView.setTextColor(Color.WHITE);
        titleView.setText("更多");
        titleBar.setVisibility(View.VISIBLE);
        leftButton.setVisibility(View.GONE);
    }

    /**
     * 初始化消息提醒状态
     */
    private void initNotificationSettings() {
        mNotificationSettings = new NotificationInitHelper(null);

        View soundRelativeLayout = mView.findViewById(R.id.setting_sound_layout);
        soundRelativeLayout.setOnClickListener(this);
        View vibrationRelativeLayout = mView.findViewById(R.id.setting_vibration_layout);
        vibrationRelativeLayout.setOnClickListener(this);
        View quietRelativeLayout = mView.findViewById(R.id.setting_quiet_layout);
        quietRelativeLayout.setOnClickListener(this);

        soundCheckBox = (CheckBox) mView.findViewById(R.id.setting_sound_check);
        soundCheckBox.setChecked(IMSharePreferenceKVStore.getNeedSound() == 1);
        vibrationCheckBox = (CheckBox) mView.findViewById(R.id.setting_vibration_check);
        vibrationCheckBox.setChecked(IMSharePreferenceKVStore.getNeedVibration() == 1);
        quietCheckBox = (CheckBox) mView.findViewById(R.id.setting_quiet_check);
    }


    private List<YWMessage> mMsgList;

    private IYWMessageListener msgListener = new IYWMessageListener() {
        @Override
        public void onItemUpdated() {
            WxLog.d(TAG, "onItemUpdated");
        }

        @Override
        public void onItemComing() {
            WxLog.d(TAG, "onItemComing");
        }

        @Override
        public void onInputStatus(byte status) {
            WxLog.d(TAG, "onInputStatus");
        }
    };

    @Override
    public void onClick(View v) {
        boolean oldCheck;
        switch (v.getId()) {
            case R.id.more_logout:
                showAlertDialog();
                break;
            // 该示例为了简单起见没有对通知栏消息设置做持久化，这会导致用户退出重登或者应用被杀死再次启动后用户设置失效。
            // 开发者在使用时最好对用户设置进行持久化存储，例如保存到SharedPreferences或者数据库中。
            case R.id.setting_sound_layout:
                oldCheck = soundCheckBox.isChecked();
                mNotificationSettings.setNeedSound(!oldCheck);
                soundCheckBox.setChecked(!oldCheck);
                IMSharePreferenceKVStore.setNeedSound(!oldCheck ? 1 : 0);

                break;
            case R.id.setting_vibration_layout:
                oldCheck = vibrationCheckBox.isChecked();
                mNotificationSettings.setNeedVibrator(!oldCheck);
                vibrationCheckBox.setChecked(!oldCheck);
                IMSharePreferenceKVStore.setNeedVibration(!oldCheck ? 1 : 0);
                break;
            case R.id.setting_quiet_layout:
                oldCheck = quietCheckBox.isChecked();
                mNotificationSettings.setNeedQuiet(!oldCheck);
                quietCheckBox.setChecked(!oldCheck);
                break;
            default:
                break;
        }
    }


    private void showAlertDialog() {
        AlertDialog.Builder builder = new YWAlertDialog.Builder(getActivity());
        builder.setMessage(getResources().getString(R.string.quit_confirm))
                .setCancelable(false)
                .setPositiveButton("确定",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                logout();
                            }
                        })
                .setNegativeButton(R.string.cancel,
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog,
                                                int id) {
                                dialog.dismiss();
                            }
                        });
        AlertDialog dialog = builder.create();
        if (!dialog.isShowing()) {
            dialog.show();
        }
    }

    public void logout() {
        // openIM SDK提供的登录服务
        IYWLoginService mLoginService = mIMKit.getLoginService();
        mLoginService.logout(new IWxCallback() {
            //此时logout已关闭所有基于IMBaseActivity的OpenIM相关Actiivity，s
            @Override
            public void onSuccess(Object... arg0) {
                Toast.makeText(BaseApplication.getContext(), "退出成功", Toast.LENGTH_SHORT).show();
                YWLog.i(TAG, "退出成功");
                IMLoginHelper.getInstance().setAutoLoginState(YWLoginState.idle);
                getActivity().finish();
                Intent intent = new Intent(BaseApplication.getContext(), LoginActivity.class);
                startActivity(intent);
            }

            @Override
            public void onProgress(int arg0) {

            }

            @Override
            public void onError(int arg0, String arg1) {
                Toast.makeText(BaseApplication.getContext(), "退出失败,请重新登录", Toast.LENGTH_SHORT).show();
            }
        });
    }

    /**
     * 内置WebView打开（如果不支持，再用系统的浏览器打开）
     *
     * @param url
     * @param title
     */
    private void viewUrlInSimpleWebView(String url, String title) {
        Intent intent = new Intent(getActivity(), IMWebViewActivity.class);
        intent.putExtra(IMWebViewActivity.URL, url);
        intent.putExtra(IMWebViewActivity.TITLE, title);
        startActivity(intent);
    }

    @Override
    public void onResume() {
        super.onResume();
    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        YWLog.e(TAG, "onDestroy");
    }

    private void initTest() {
        TextView test = (TextView) mView.findViewById(R.id.more_test_multi_account);
        test.setVisibility(View.VISIBLE);
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MultiAccountTestActivity.class);
                startActivity(intent);
            }
        });
    }

}
