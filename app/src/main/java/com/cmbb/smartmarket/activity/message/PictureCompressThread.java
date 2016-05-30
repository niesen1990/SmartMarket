package com.cmbb.smartmarket.activity.message;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;

import com.alibaba.mobileim.YWChannel;
import com.alibaba.mobileim.aop.AdviceObjectInitUtil;
import com.alibaba.mobileim.aop.BaseAdvice;
import com.alibaba.mobileim.aop.PointCutEnum;
import com.alibaba.mobileim.aop.Pointcut;
import com.alibaba.mobileim.channel.IMChannel;
import com.alibaba.mobileim.channel.helper.ImageMsgPacker;
import com.alibaba.mobileim.channel.util.FileUtils;
import com.alibaba.mobileim.channel.util.WXUtil;
import com.alibaba.mobileim.channel.util.WxLog;
import com.alibaba.mobileim.utility.IMImageCache;
import com.alibaba.mobileim.utility.IMImageUtils;
import com.alibaba.mobileim.utility.IMThumbnailUtils;
import com.alibaba.wxlib.config.StorageConstant;
import com.alibaba.wxlib.util.WXFileTools;
import com.cmbb.smartmarket.log.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：             WxDefaultExecutor.getInstance().submitHttp((new PictureCompressThread(selectedList, this)).setNeedCompress(data.getBooleanExtra("need_compress", false)));
 * <p/>
 * 创建人：N.Sun
 * 创建时间：16/5/4 上午11:38
 * 修改人：N.Sun
 * 修改时间：16/5/4 上午11:38
 * 修改备注：
 */
public class PictureCompressThread extends Thread {
    private static final String TAG = "PictureCompressThread";
    private static int widthpixels;
    private static int heightpixels;
    private List<String> picPaths;
    private Context context;
    private boolean mNeedCompress = true;
    protected boolean mNeedRound = false;
    protected float mRoundPixels = 0.0F;
    private BaseAdvice baseAdviceUI;
    private CompressCallback mCompressCallback;
    private Handler mHandler = new Handler(Looper.myLooper());

    public PictureCompressThread setThumnailNeedRound(boolean mNeedRound) {
        this.mNeedRound = mNeedRound;
        return this;
    }

    public PictureCompressThread setThumnailRoundPixels(float mRoundPixels) {
        this.mRoundPixels = mRoundPixels;
        return this;
    }

    public PictureCompressThread setNeedCompress(boolean mNeedCompress) {
        this.mNeedCompress = mNeedCompress;
        return this;
    }

    public PictureCompressThread(List<String> picPaths, Context context, CompressCallback compressCallback) {
        this.baseAdviceUI = AdviceObjectInitUtil.initAdvice(PointCutEnum.CHATTING_FRAGMENT_UI_POINTCUT, (Pointcut) null);
        this.init(picPaths, context);
        this.mCompressCallback = compressCallback;
    }

    private void init(List<String> picPaths, Context context) {
        this.picPaths = picPaths;
        this.context = context;
        if (widthpixels == 0) {
            widthpixels = context.getResources().getDisplayMetrics().widthPixels * 3;
            Log.e(TAG, " widthpixels = " + widthpixels);
            heightpixels = (int) ((float) context.getResources().getDisplayMetrics().heightPixels - 32.0F * context.getResources().getDisplayMetrics().density);
        }

    }

    public void run() {
        if (this.picPaths != null && !this.picPaths.isEmpty()) {
            Iterator iterator = this.picPaths.iterator();
            while (true) {
                String pic;
                int fileSize;
                //设置 pic 的值
                do {
                    if (!iterator.hasNext()) {
                        mHandler.post(new Runnable() {
                            @Override
                            public void run() {
                                mCompressCallback.completed();
                            }
                        });
                        return;
                    }
                    pic = (String) iterator.next();
                    fileSize = 0;
                } while (TextUtils.isEmpty(pic));

                File f = new File(pic);
                if (f.exists() && f.isFile()) {
                    fileSize = (int) f.length();
                } else {
                    WxLog.w("PicSendThread", "pic:" + pic + " is empty, pls check!");
                }

                String originPath;
                if (pic.endsWith(".gif")) {
                    originPath = StorageConstant.getFilePath() + File.separator + WXUtil.getMD5FileName(pic);
                    FileUtils.copyFile(new File(pic), new File(originPath));
                    BitmapFactory.Options ori1 = new BitmapFactory.Options();
                    ori1.inJustDecodeBounds = true;
                    BitmapFactory.decodeFile(pic, ori1);
                    // TODO: 16/5/4 处理gif
                        /*final YWMessage origin1 = YWMessageChannel.createGifImageMessage(originPath, originPath, ori1.outWidth, ori1.outHeight, fileSize);
                        if (this.messageSender != null) {
                            this.mHandler.post(new Runnable() {
                                public void run() {
                                    PictureCompressThread.this.messageSender.sendPicMessage(origin1);
                                }
                            });
                        }*/
                } else {
                    originPath = StorageConstant.getFilePath() + File.separator + WXUtil.getMD5FileName(pic);
                    int ori = IMImageUtils.getOrientation(pic, this.context, (Uri) null);
                    Bitmap origin = null;
                    if (this.mNeedCompress) {
                        origin = IMThumbnailUtils.compressFileAndRotateToBitmapThumb(pic, widthpixels, heightpixels, ori, originPath, true);
                        if (origin == null) {
                            continue;
                        }

                        File compressedPath = new File(originPath);
                        if (compressedPath.exists() && compressedPath.isFile()) {
                            fileSize = (int) compressedPath.length();
                        } else {
                            WxLog.w("PicSendThread", "pic:" + pic + " is empty, pls check!");
                        }
                    } else {
                        if (fileSize == 0) {
                            continue;
                        }

                        origin = IMThumbnailUtils.compressFileAndRotateToBitmapThumb(pic, widthpixels, heightpixels, ori, originPath, false);
                        if (origin == null) {
                            WxLog.d("PicSendThread", " IMFileTools.decodeBitmap(pic) fail !TOO BIG ");
                            continue;
                        }

                        f = new File(originPath);
                        if (f.exists() && f.isFile()) {
                            fileSize = (int) f.length();
                            WxLog.d("PicSendThread@OriginalPic", "文件大小: " + WXFileTools.bytes2KOrM((long) fileSize) + "(" + fileSize + ")");
                        }
                    }

                    String compressedPath1 = StorageConstant.getFilePath() + File.separator + WXUtil.getMD5FileName(pic) + "_comp";
                    ImageMsgPacker imageMsgPacker = new ImageMsgPacker(YWChannel.getApplication());
                    int mMaxHeight = imageMsgPacker.getMaxNeedServerToGiveThumnailHeight();
                    int mMinWidth = imageMsgPacker.getMinWidth();
                    int[] resizedDimension = IMThumbnailUtils.getResizedDimensionOfThumbnail(origin.getWidth(), origin.getHeight(), mMinWidth, mMaxHeight);
                    Bitmap scalebBitmap = IMThumbnailUtils.getCropAndScaledBitmap(origin, resizedDimension[0], resizedDimension[1], resizedDimension[2], resizedDimension[3], false);
                    if (scalebBitmap != null) {
                        FileOutputStream out = null;

                        try {
                            out = new FileOutputStream(compressedPath1);
                            if (out != null) {
                                scalebBitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                            }
                        } catch (FileNotFoundException var27) {
                            WxLog.w("PicSendThread", "run", var27);
                        } finally {
                            if (out != null) {
                                try {
                                    out.close();
                                } catch (IOException var26) {
                                    ;
                                }
                            }

                        }

                        IMImageCache wxImageCache = IMImageCache.findOrCreateCache(this.context, StorageConstant.getFilePath());
                        scalebBitmap = IMImageUtils.getAndCacheChattingBitmap(compressedPath1, scalebBitmap, this.mNeedRound, this.mRoundPixels, this.baseAdviceUI, wxImageCache, true);
                        Rect oriRect = new Rect();
                        oriRect.set(0, 0, origin.getWidth(), origin.getHeight());
                        Rect compRect = new Rect();
                        compRect.set(0, 0, scalebBitmap.getWidth(), scalebBitmap.getHeight());
                        String imageType = "jpg";
                        if (!TextUtils.isEmpty(originPath)) {
                            File msg = new File(originPath);
                            if (msg.exists() && msg.isFile()) {
                                BitmapFactory.Options decodeOptions = new BitmapFactory.Options();
                                decodeOptions.inJustDecodeBounds = true;
                                BitmapFactory.decodeFile(originPath, decodeOptions);
                                if (decodeOptions != null && IMChannel.DEBUG.booleanValue()) {
                                    WxLog.d("PicSendThread@OriginalPic", "send pic mimeType = " + decodeOptions.outMimeType);
                                }

                                if (decodeOptions != null && !TextUtils.isEmpty(decodeOptions.outMimeType) && (decodeOptions.outMimeType.contains("png") || decodeOptions.outMimeType.contains("PNG"))) {
                                    imageType = "png";
                                }
                            }
                        }

                        Log.i(TAG, "originPath = " + originPath);
                        Log.i(TAG, "compressedPath1 = " + compressedPath1);
                        Log.i(TAG, "fileSize = " + fileSize);
                        Log.i(TAG, "oriRect.width() = " + oriRect.width());
                        Log.i(TAG, "oriRect.height() = " + oriRect.height());
                        Log.i(TAG, "this.mNeedCompress = " + this.mNeedCompress);

                        mCompressCallback.callback(originPath, compressedPath1);

                    }
                }
            }
        }
    }

    public interface CompressCallback {
        void callback(String originPath, String compressedPath);

        void completed();
    }

}
