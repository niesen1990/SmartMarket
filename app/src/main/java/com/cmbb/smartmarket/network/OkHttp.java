package com.cmbb.smartmarket.network;

import com.cmbb.smartmarket.base.ResponseModel;
import com.zhy.http.okhttp.OkHttpUtils;

import java.util.Map;

import okhttp3.MediaType;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/20 下午2:56
 */
public class OkHttp {

    private static final String TAG = OkHttp.class.getSimpleName();

    public static void post(String url, Map<String, String> params, ResponseModel responseCallback) {
        OkHttpUtils
                .postString()
                .url("http://mengbaopai.smart-kids.com:82/wine-rest/cgi")
                .mediaType(MediaType.parse("application/json; charset=utf-8"))
                .content(RequestModel.param2Json(url, params))
                .build()
                .execute(responseCallback);
    }

}
