package com.cmbb.smartmarket.image;

import android.content.ActivityNotFoundException;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.Toast;

import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.log.Log;

import java.io.File;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/7 下午2:07
 * 修改人：N.Sun
 * 修改时间：16/6/7 下午2:07
 * 修改备注：
 */
public class MediaCamera {

    public static void startCameraActivity(BaseActivity context, File sdcardTempFile, int requestCode) {
        String status = Environment.getExternalStorageState();
        if (status.equals("mounted") && sdcardTempFile != null) {
            try {
                Intent illegalStateException = new Intent("android.media.action.IMAGE_CAPTURE");
                ContentValues contentValues = new ContentValues(1);
                contentValues.put("_data", sdcardTempFile.getAbsolutePath());
                Uri uri = context.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                illegalStateException.putExtra("output", uri);
                context.startActivityForResult(illegalStateException, requestCode);
            } catch (ActivityNotFoundException var8) {
                Log.e("IMMediaTools", "startCameraActivity = " + var8);
            } catch (IllegalStateException var9) {
                Log.e("IMMediaTools", "startCameraActivity= " + var9);
            }
        } else if (sdcardTempFile == null) {
            Toast.makeText(context, com.alibaba.sdk.android.R.string.aliwx_start_camera_error, Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, com.alibaba.sdk.android.R.string.aliwx_camera_fail, Toast.LENGTH_SHORT).show();
        }

    }
}
