package com.cmbb.smartmarket.utils;

import android.content.Context;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.WindowManager;

import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;

import java.util.UUID;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/20 下午4:27
 */
public class TDevice {

    private static final String TAG = TDevice.class.getSimpleName();

    /**
     * 将px类型的尺寸转换成dp类型的尺寸
     *
     * @param pxValue
     * @param context
     * @return
     */
    public static int px2dip(Context context, float pxValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将dp类型的尺寸转换成px类型的尺寸
     *
     * @param size
     * @param context
     * @return
     */
    public static int dip2px(int size, Context context) {
        DisplayMetrics metrics = getDefaultDisplay(context);
        return (int) ((float) size * metrics.density + 0.5);
    }

    public static int getScreenWidth(Context context) {
        DisplayMetrics metrics = getDefaultDisplay(context);
        int widthPixels = metrics.widthPixels;
        int densityDpi = metrics.densityDpi;
        Log.i(TAG, "widthPixels  = " + widthPixels);
        Log.i(TAG, "densityDpi  = " + densityDpi);
        return widthPixels;
    }

    public static int getScreenHeight(Context context) {
        DisplayMetrics metrics = getDefaultDisplay(context);
        int heightPixels = metrics.heightPixels;
        int densityDpi = metrics.densityDpi;
        Log.i(TAG, "heightPixels  = " + heightPixels);
        Log.i(TAG, "densityDpi  = " + densityDpi);
        return heightPixels;
    }

    public static DisplayMetrics getDefaultDisplay(Context context) {
        // pixels, dpi
        DisplayMetrics metrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay().getMetrics(metrics);
        return metrics;
    }

    /**
     * 获取设备的唯一标识码
     *
     * @param context
     * @return
     */
    public static String getDeviceId(Context context) {
        try {
            android.telephony.TelephonyManager tm = (android.telephony.TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);

            String device_id = tm.getDeviceId();

            android.net.wifi.WifiManager wifi = (android.net.wifi.WifiManager) context.getSystemService(Context.WIFI_SERVICE);

            String mac = wifi.getConnectionInfo().getMacAddress();

            if (TextUtils.isEmpty(device_id)) {
                device_id = mac;
            }

            if (TextUtils.isEmpty(device_id)) {
                device_id = android.provider.Settings.Secure.getString(context.getContentResolver(), android.provider.Settings.Secure.ANDROID_ID);
            }

            return device_id;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return UUID.randomUUID().toString();
    }

    /**
     * app version
     * @return
     */
    public static String getVersionName() {
        String name = "";
        try {
            name = BaseApplication.getContext().getPackageManager().getPackageInfo(BaseApplication.getContext().getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException ex) {
            name = "";
        }
        return name;
    }

}


