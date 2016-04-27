package com.cmbb.smartmarket.network;

import com.cmbb.smartmarket.log.Log;
import com.google.gson.Gson;

import java.util.Iterator;
import java.util.Map;

/**
 * 项目名称：SmartApp
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/3/1 上午10:23
 */
public class RequestModel {

    private String cmd;
    private Map<String, String> parameters;
    private String token;

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }


    public void setToken(String token) {
        this.token = token;
    }

    public String getCmd() {
        return cmd;
    }


    public String getToken() {
        return token;
    }

    public Map<String, String> getParameters() {
        return parameters;
    }

    public void setParameters(Map<String, String> parameters) {
        this.parameters = parameters;
    }


    /**
     * 请求数据json
     *
     * @param urlPath cmd Url地址
     * @param params  Param[]
     * @return String
     */
    public static String param2Json(String urlPath, Map<String, String> params) {
        RequestModel requestModel = new RequestModel();
        requestModel.setCmd(urlPath);
        for (Iterator<String> it = params.keySet().iterator(); it.hasNext(); ) {
            String val = it.next();
            if (val.equals("token")) {
                requestModel.setToken(params.get(val));
                it.remove();
            }
        }
        requestModel.setParameters(params);
        String requestParams = new Gson().toJson(requestModel);
        Log.json("RequestParams", requestParams);
        return requestParams;
    }
}
