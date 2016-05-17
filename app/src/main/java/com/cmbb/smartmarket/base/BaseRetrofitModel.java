package com.cmbb.smartmarket.base;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 下午7:01
 */
public class BaseRetrofitModel<T> {

    private String messageId;
    private String requestId;

    private ErrorEntity error;
    private int statusCode;
    private String cmd;
    private String responseTime;
    private String responseTimestamp;
    private int duration;
    private String debugInfo;
    private String clientIp;
    private boolean usedCache;
    private ExtraInfoEntity extraInfo;
    private AuthEntity auth;
    private T response;

    public T getResponse() {
        return response;
    }

    public void setResponse(T response) {
        this.response = response;
    }

    public String getMessageId() {
        return messageId;
    }

    public void setMessageId(String messageId) {
        this.messageId = messageId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public ErrorEntity getError() {
        return error;
    }

    public void setError(ErrorEntity error) {
        this.error = error;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getResponseTime() {
        return responseTime;
    }

    public void setResponseTime(String responseTime) {
        this.responseTime = responseTime;
    }

    public String getResponseTimestamp() {
        return responseTimestamp;
    }

    public void setResponseTimestamp(String responseTimestamp) {
        this.responseTimestamp = responseTimestamp;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public String getDebugInfo() {
        return debugInfo;
    }

    public void setDebugInfo(String debugInfo) {
        this.debugInfo = debugInfo;
    }

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public boolean isUsedCache() {
        return usedCache;
    }

    public void setUsedCache(boolean usedCache) {
        this.usedCache = usedCache;
    }

    public ExtraInfoEntity getExtraInfo() {
        return extraInfo;
    }

    public void setExtraInfo(ExtraInfoEntity extraInfo) {
        this.extraInfo = extraInfo;
    }

    public AuthEntity getAuth() {
        return auth;
    }

    public void setAuth(AuthEntity auth) {
        this.auth = auth;
    }

    public static class ErrorEntity {
        private int errorCode;
        private String errorInfo;

        public int getErrorCode() {
            return errorCode;
        }

        public void setErrorCode(int errorCode) {
            this.errorCode = errorCode;
        }

        public String getErrorInfo() {
            return errorInfo;
        }

        public void setErrorInfo(String errorInfo) {
            this.errorInfo = errorInfo;
        }
    }

    public static class ExtraInfoEntity {
        private String consuming;
        private String serverName;

        public String getConsuming() {
            return consuming;
        }

        public void setConsuming(String consuming) {
            this.consuming = consuming;
        }

        public String getServerName() {
            return serverName;
        }

        public void setServerName(String serverName) {
            this.serverName = serverName;
        }
    }

    public static class AuthEntity {
        private boolean tokenValid;

        public boolean isTokenValid() {
            return tokenValid;
        }

        public void setTokenValid(boolean tokenValid) {
            this.tokenValid = tokenValid;
        }
    }

    @Override
    public String toString() {
        return "BaseRetrofitModel{" +
                "messageId='" + messageId + '\'' +
                ", requestId='" + requestId + '\'' +
                ", error=" + error +
                ", statusCode=" + statusCode +
                ", cmd='" + cmd + '\'' +
                ", responseTime='" + responseTime + '\'' +
                ", responseTimestamp='" + responseTimestamp + '\'' +
                ", duration=" + duration +
                ", debugInfo='" + debugInfo + '\'' +
                ", clientIp='" + clientIp + '\'' +
                ", usedCache=" + usedCache +
                ", extraInfo=" + extraInfo +
                ", auth=" + auth +
                ", response=" + response +
                '}';
    }
}
