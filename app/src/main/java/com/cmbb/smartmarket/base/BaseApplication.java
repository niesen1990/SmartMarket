package com.cmbb.smartmarket.base;

import android.app.Application;
import android.app.Notification;
import android.content.Context;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.support.v4.app.NotificationCompat;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.image.PicassoLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.log.constant.ZoneOffset;
import com.cmbb.smartmarket.utils.SPCache;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;
import com.umeng.message.UTrack;
import com.umeng.message.UmengMessageHandler;
import com.umeng.message.UmengNotificationClickHandler;
import com.umeng.message.entity.UMessage;
import com.umeng.socialize.PlatformConfig;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.concurrent.TimeUnit;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/14 上午11:35
 */
public class BaseApplication extends Application {

    public static PushAgent mPushAgent;
    public static Application context;
    public static String token = "MzYxNGQ0MTUtNWUyYi00OWQ1LTlkZGMtNTQ3OWI0ZjI1ZjA4";


    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        initLog();
        initSharePreference();
        initUmengAnalytics();
        initPushAgent();
        initOkHttp();
        initShare();
    }

    private void initShare() {
        PlatformConfig.setWeixin("wx967daebe835fbeac", "5bb696d9ccd75a38c8a0bfe0675559b3");
        //微信 appid appsecret
        PlatformConfig.setSinaWeibo("3921700954", "04b48b094faeb16683c32669824ebdad");
        //新浪微博 appkey appsecret     PlatformConfig.setYixin("yxc0614e80c9304c11b0391514d09f13bf");
        //易信 appkey        PlatformConfig.setRenren("201874","28401c0964f04a72a14c812d6132fcef","3bf66e42db1e4fa9829b955cc300b737");
        //人人 appid appkey appsecret
        PlatformConfig.setQQZone("100424468", "c7394704798a158208a74ab60104f0ba");
        // qq qzone appid appkey
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
     * 初始化OkHttp
     */
    private void initOkHttp() {
        OkHttpUtils.getInstance().debug("OkHttp").setConnectTimeout(15000, TimeUnit.MILLISECONDS);
        PicassoLoader.init(this);
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
                        Log.e("SmartKids", "message = " + msg);
                        UTrack.getInstance(getApplicationContext()).trackMsgClick(msg);
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
}
