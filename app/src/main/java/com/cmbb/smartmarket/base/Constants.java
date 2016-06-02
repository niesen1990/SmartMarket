package com.cmbb.smartmarket.base;

import java.util.regex.Pattern;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/18 下午4:32
 */
public class Constants {
    public static final String INTENT_ACTION_EXIT_APP = "com.cmbb.smartmarket.exit";
    public static final String INTENT_ACTION_ALIAS = "com.cmbb.smartmarket.alias";
    public static final String INTENT_ACTION_ERROR_INFRO = "com.cmbb.smartmarket.err";
    public static final String INTENT_ACTION_REFRESH = "com.cmbb.smartmarket.refresh";
    public static final String INTENT_ACTION_LOCATION = "com.cmbb.smartmarket.location";
    public static final String AUTO_LOGIN_STATE_ACTION = "com.cmbb.smartmarket.autoLoginStateActionn";
    public static final String IM_USER_ID = "im_user_id";
    public static final String IM_USER_PASSWORD = "im_user_password";
    public static final String API_TOKEN = "api_token";
    public static final String API_USER_ID = "api_user_id";
    public final static String APP_ID = "wx_app_id";

    public final static String LOCATION = "location";
    public final static String LOCATION_CITY = "location_city";
    public final static String HAS_WALLET_PSW = "has_wallet_psw";

    /**
     * 验证支付密码
     *
     * @param psw
     * @return
     */
    public static boolean regExpAccount(String psw) {
        String regex = "(?!^\\\\d+$)(?!^[a-zA-Z]+$)(?!^[_#@]+$).{4,16}";
        return Pattern.matches(regex, psw);
    }

    /**
     * 验证中文字符
     *
     * @param str
     * @return
     */
    public static boolean regExpChinese(String str) {
        String regex = "^[\\u4e00-\\u9fa5]+$";
        return Pattern.matches(regex, str);
    }

    /**
     * 验证字母
     *
     * @param str
     * @return
     */
    public static boolean regExpLetter(String str) {
        String regex = "^[a-zA-Z]+$";
        return Pattern.matches(regex, str);
    }

}
