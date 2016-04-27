package com.cmbb.smartmarket.widget;

import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;

import com.cmbb.smartmarket.R;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/18 下午5:10
 */
public class ProgressDialog extends AlertDialog {

    public ProgressDialog(Context context) {
        super(context);
    }

    public ProgressDialog(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }

    public ProgressDialog(Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setView(LayoutInflater.from(getContext()).inflate(R.layout.progress_dialog, null));
        super.onCreate(savedInstanceState);
    }
}
