package com.cmbb.smartmarket.utils;

import android.content.Context;
import android.view.inputmethod.InputMethodManager;

import com.cmbb.smartmarket.base.BaseActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/7 下午3:47
 * 修改人：N.Sun
 * 修改时间：16/6/7 下午3:47
 * 修改备注：
 */
public class KeyboardUtil {

    public static void hideKeyboard(BaseActivity context) {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(context.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public static void showKeyboard(BaseActivity context) {
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
    }
}
