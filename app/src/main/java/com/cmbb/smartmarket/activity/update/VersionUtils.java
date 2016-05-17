package com.cmbb.smartmarket.activity.update;

import android.content.Context;
import android.content.pm.PackageManager;

public class VersionUtils {

    public static String getInstalledVersion(Context context) {
        String version = "";

        try {
            version = context.getPackageManager().getPackageInfo("com.combb.smartmarket", 0).versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }

        return version;
    }

    public static Boolean isInstalled(Context context) {
        Boolean res;

        try {
            context.getPackageManager().getPackageInfo("com.combb.smartmarket", 0);
            res = true;
        } catch (PackageManager.NameNotFoundException e) {
            res = false;
        }

        return res;
    }

    public static Boolean isUpdateAvailable(String installedVersion, String latestVersion) {
        Version installed = new Version(installedVersion);
        Version latest = new Version(latestVersion);

        return installed.compareTo(latest) < 0;
    }

}
