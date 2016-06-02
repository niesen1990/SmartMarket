package com.cmbb.smartmarket.network;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/10 下午3:46
 * 修改人：N.Sun
 * 修改时间：16/5/10 下午3:46
 * 修改备注：
 */
public class RetrofitRequestModel {

    private String cmd;
    private String token;
    private String resolution;
    private String locationXy;

    private DeviceInfoEntity deviceInfo;
    private String appVersion;

    public String getCmd() {
        return cmd;
    }

    public void setCmd(String cmd) {
        this.cmd = cmd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getLocationXy() {
        return locationXy;
    }

    public void setLocationXy(String locationXy) {
        this.locationXy = locationXy;
    }

    public DeviceInfoEntity getDeviceInfo() {
        return deviceInfo;
    }

    public void setDeviceInfo(DeviceInfoEntity deviceInfo) {
        this.deviceInfo = deviceInfo;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public static class ParametersEntity {
        private String id;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }
    }

    public static class DeviceInfoEntity {
        private String device;
        private String deviceMode;
        private String deviceVersion;
        private String deviceImei;

        public DeviceInfoEntity(String device, String deviceMode, String deviceVersion, String deviceImei) {
            this.device = device;
            this.deviceMode = deviceMode;
            this.deviceVersion = deviceVersion;
            this.deviceImei = deviceImei;
        }

        public String getDevice() {
            return device;
        }

        public void setDevice(String device) {
            this.device = device;
        }

        public String getDeviceMode() {
            return deviceMode;
        }

        public void setDeviceMode(String deviceMode) {
            this.deviceMode = deviceMode;
        }

        public String getDeviceVersion() {
            return deviceVersion;
        }

        public void setDeviceVersion(String deviceVersion) {
            this.deviceVersion = deviceVersion;
        }

        public String getDeviceImei() {
            return deviceImei;
        }

        public void setDeviceImei(String deviceImei) {
            this.deviceImei = deviceImei;
        }
    }
}
