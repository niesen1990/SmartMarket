package com.cmbb.smartmarket.log.util;

import android.support.annotation.NonNull;

import com.cmbb.smartmarket.log.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 文件工具类.
 */
public class FileUtils {

    /** 读写文件的线程池，单线程模型. */
    private static ExecutorService sExecutorService;

    static {
        sExecutorService = Executors.newSingleThreadExecutor();
    }

    private FileUtils() {
    }

    /**
     * 判断文件或目录是否存在.
     *
     * @param filePath 路径
     * @return true - 存在，false - 不存在
     */
    public static boolean isExist(@NonNull String filePath) {
        File file = new File(filePath);
        return file.exists();
    }

    /**
     * 创建目录，若目录已存在则不处理.
     *
     * @param dirPath 目录路径
     * @return true - 目录存在（创建成功或已存在），false - 目录不存在
     */
    public static boolean createDir(@NonNull String dirPath) {
        File file = new File(dirPath);
        if (!file.exists()) {
            return file.mkdirs();
        }
        return file.exists();
    }

    /**
     * 把文本写入文件中.
     *
     * @param dirPath    目录路径
     * @param fileName   文件名
     * @param content    待写内容
     * @param isOverride 写入模式，true - 覆盖，false - 追加
     */
    public static void write(@NonNull final String dirPath, @NonNull final String fileName, @NonNull final String content, final boolean isOverride) {
        sExecutorService.execute(new Runnable() {
            @Override
            public void run() {
                String filePath = dirPath + File.separator + fileName;
                FileOutputStream fos = null;
                try {
                    if (createDir(dirPath)) {
                        File file = new File(filePath);
                        boolean isExist = file.exists();
                        fos = new FileOutputStream(file, !(!isExist || isOverride));
                        fos.write(content.getBytes(Log.getSettings().getCharset()));
                    }
                } catch (IOException e) {
                    android.util.Log.e("FileUtils", e.getMessage());
                } finally {
                    if (fos != null) {
                        try {
                            fos.close();
                        } catch (IOException e) {
                            android.util.Log.e("FileUtils", e.getMessage());
                        }
                    }
                }
            }
        });
    }
}