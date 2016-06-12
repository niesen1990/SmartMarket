package com.cmbb.smartmarket.base;

import android.app.Application;
import android.app.Notification;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.multidex.MultiDex;
import android.support.multidex.MultiDexApplication;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.LocalBroadcastManager;
import android.widget.Toast;

import com.alibaba.mobileim.YWAPI;
import com.alibaba.wxlib.util.SysUtil;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.activity.message.im.custom.CustomHelper;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.log.constant.ZoneOffset;
import com.cmbb.smartmarket.utils.MessageNotification;
import com.cmbb.smartmarket.utils.SPCache;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.PlatformConfig;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/14 上午11:35
 */
public class BaseApplication extends MultiDexApplication {

    public static PushAgent mPushAgent;
    public static Application context;
    public static String token = "";
    public static int userId;

    @Override
    public void onCreate() {
        MultiDex.install(this);
        super.onCreate();
        context = this;
        initLog();
        if (insideApplicationOnCreate())
            return;//todo 如果在":TCMSSevice"进程中，无需进行openIM和app业务的初始化，以节省内存
        initIM();
        initSharePreference();
        initUmengAnalytics();
        initPushAgent();
        initShare();
        initBroadcastReceiver();
        setToken(SPCache.getString(Constants.API_TOKEN, ""));
        setUserId(SPCache.getInt(Constants.API_USER_ID, -1));
    }

    private void initBroadcastReceiver() {
        LocalBroadcastManager.getInstance(this).registerReceiver(new BroadcastReceiver() {
            @Override
            public void onReceive(Context context, Intent intent) {
                Toast.makeText(BaseApplication.getContext(), intent.getStringExtra("err"), Toast.LENGTH_SHORT).show();
            }
        }, new IntentFilter(Constants.INTENT_ACTION_ERROR_INFRO));
        // 注册推送别名注册器
        LocalBroadcastManager.getInstance(this).registerReceiver(pushAliasReceiver, new IntentFilter(Constants.INTENT_ACTION_ALIAS));
    }

    private void initIM() {
        if (SysUtil.isMainProcess()) {
            // ------[todo step1]-------------
            //［IM定制初始化］，如果不需要定制化，可以去掉此方法的调用
            //todo 注意：由于增加全局初始化，该配置需最先执行！
            CustomHelper.initCustom();
            // ------[todo step2]-------------
            //SDK初始化
            IMHelper.getInstance().initSdk(getContext());
            //后期将使用Override的方式进行集中配置，请参照YWSDKGlobalConfigSample
            YWAPI.enableSDKLogOutput(true);
        }
    }

    private void initShare() {
        PlatformConfig.setWeixin("wx941fa298a9f13cab", "26eab825b4bed490b97c020aa8a65f1b");
        PlatformConfig.setSinaWeibo("3195048701", "96ae214825838c1fd26d9637ab39460d");
        PlatformConfig.setQQZone("1105407394", "CAcc37XOA1WR6Fg");
    }

    public static int getUserId() {
        return userId;
    }

    public static void setUserId(int userId) {
        BaseApplication.userId = userId;
    }

    public static String getToken() {
        return token;
    }

    public static void setToken(String token) {
        BaseApplication.token = token;
    }

    public static Application getContext() {
        return context;
    }

    public static void setContext(Application context) {
        BaseApplication.context = context;
    }

    /**
     * 初始化日志
     */
    private void initLog() {
        Log.init(this)
                .writeToFile(false)
                .setLogDir(getString(R.string.app_name))
                .setZoneOffset(ZoneOffset.P0800);
    }

    /**
     * 初始化SharePreference
     */
    private void initSharePreference() {
        SPCache.init(this);
    }

    /**
     * 友盟数据统计
     */
    private void initUmengAnalytics() {
        MobclickAgent.setDebugMode(true);
    }

    /**
     * 初始化友盟推送
     */
    private void initPushAgent() {
        mPushAgent = PushAgent.getInstance(this);
        mPushAgent.setDebugMode(true);

        /**
         * 该Handler是在IntentService中被调用，故
         * 1. 如果需启动Activity，需添加Intent.FLAG_ACTIVITY_NEW_TASK
         * 2. IntentService里的onHandleIntent方法是并不处于主线程中，因此，如果需调用到主线程，需如下所示;
         * 	      或者可以直接启动Service
         * */
        UmengMessageHandler messageHandler = new UmengMessageHandler() {
            @Override
            public void dealWithCustomMessage(final Context context, final UMessage msg) {
                new Handler(getMainLooper()).post(new Runnable() {

                    @Override
                    public void run() {
                        // TODO Auto-generated method stub
                        Log.e("SmartKids", "message" + msg);
                        UTrack.getInstance(getApplicationContext()).trackMsgClick(msg);
                        MessageNotification.notify(getContext(), msg.custom, 0);
                    }
                });
            }

            @Override
            public Notification getNotification(Context context, UMessage msg) {
                switch (msg.builder_id) {
                    case 0:
                        NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(context)
                                .setLargeIcon(BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher))
                                .setSmallIcon(R.mipmap.ic_launcher)
                                .setContentTitle(msg.title)
                                .setCategory(msg.text)
                                .setContentText(msg.text);
                        mBuilder.setAutoCancel(true);
                        return mBuilder.build();
                    default:
                        //默认为0，若填写的builder_id并不存在，也使用默认。
                        return super.getNotification(context, msg);
                }
            }
        };
        mPushAgent.setMessageHandler(messageHandler);

        /**
         * 该Handler是在BroadcastReceiver中被调用，故
         * 如果需启动Activity，需添加Intent.FLAG_ACTIVITY_NEW_TASK
         * */
        UmengNotificationClickHandler notificationClickHandler = new UmengNotificationClickHandler() {
            @Override
            public void dealWithCustomAction(Context context, UMessage msg) {
                Log.e("SmartMarket", "message = " + msg.custom);
            }
        };
        mPushAgent.setNotificationClickHandler(notificationClickHandler);
    }

    /**
     * 设置推送用户别名
     */
    private BroadcastReceiver pushAliasReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, final Intent intent) {
            Log.e("Alias", "Alias 设置");
            new Thread() {
                @Override
                public void run() {
                    try {
                        Log.e("Alias", "Alias 设置参数 ＝ " + intent.getStringExtra("umeng_id"));
                        Log.e("Alias", "Alias 设置参数 ＝ " + intent.getStringExtra("umeng_type"));
                        boolean flag = mPushAgent.addAlias(intent.getStringExtra("umeng_id"), intent.getStringExtra("umeng_type"));
                        Log.e("Alias", "Alias 设置是否成功 ＝ " + flag);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }.start();
        }
    };

    private boolean insideApplicationOnCreate() {
        //必须的初始化
        SysUtil.setApplication(this);
        return SysUtil.isTCMSServiceProcess(this);
    }
}
