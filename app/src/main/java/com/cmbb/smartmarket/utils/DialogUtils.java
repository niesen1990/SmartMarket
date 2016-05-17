package com.cmbb.smartmarket.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/5 下午2:31
 * 修改人：N.Sun
 * 修改时间：16/5/5 下午2:31
 * 修改备注：
 */
public class DialogUtils {
    public static void createAlertDialog(Context context, String title, String content, boolean canceledOnTouchOutside, DialogInterface.OnClickListener onClickListener) {
        AlertDialog dialog = new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(content)
                .setPositiveButton("确定", onClickListener).create();
        dialog.setCanceledOnTouchOutside(canceledOnTouchOutside);
        dialog.show();
    }
}
