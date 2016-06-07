package com.cmbb.smartmarket.network;

import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;

import com.alibaba.mobileim.channel.event.IWxCallback;
import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.db.DBHelper;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.utils.SPCache;
import com.cmbb.smartmarket.utils.TDevice;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/7 上午9:41
 * 修改人：N.Sun
 * 修改时间：16/6/7 上午9:41
 * 修改备注：
 */
public class Logout {

    public static void logout(final Context context) {
        IMHelper.getInstance().logoutIM(new IWxCallback() {
            @Override
            public void onSuccess(Object... objects) {
                new Thread() {
                    @Override
                    public void run() {
                        try {
                            boolean flag = BaseApplication.mPushAgent.removeAlias(SPCache.getInt(Constants.API_USER_ID, -1) + "_" + TDevice.getDeviceId(context), "market");
                            Log.e("Alias", "Alias remove = " + flag);
                            Log.e("Alias", "Alias remove id = " + SPCache.getInt(Constants.API_USER_ID, -1));
                            if (flag) {
                                SPCache.clear();
                                //删除表
                                DBHelper dbHelper = new DBHelper(context);
                                SQLiteDatabase db = dbHelper.getWritableDatabase();
                                dbHelper.delete(db);
                                SPCache.clear();
                                BaseApplication.setToken("");
                                BaseApplication.setUserId(0);
                                //关闭主页面
                                Intent intent = new Intent(Constants.INTENT_ACTION_EXIT_APP);
                                context.sendBroadcast(intent);
                                LoginActivity.newIntent(context);
                            } else {
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }.start();
            }

            @Override
            public void onError(int i, String s) {

            }

            @Override
            public void onProgress(int i) {

            }
        });
    }
}
