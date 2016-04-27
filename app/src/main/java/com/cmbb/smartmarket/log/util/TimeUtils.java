package com.cmbb.smartmarket.log.util;

import android.support.annotation.NonNull;
import android.text.format.DateFormat;

import com.cmbb.smartmarket.log.Log;

import java.util.Calendar;

/**
 * 时间工具类.
 */
public final class TimeUtils {

    private TimeUtils() {
    }

    /**
     * 把时间戳转换成对应的Calendar对象.
     *
     * @param millis 时间戳
     * @return Calendar对象
     */
    public static Calendar getCalendar(final long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);
        return calendar;
    }

    /**
     * 把用户时区的时间戳转成UTC时间戳.
     *
     * @param millis 用户时区的时间戳
     * @return UTC时间戳
     */
    public static long getUtcMillis(final long millis) {
        Calendar calendar = getCalendar(millis);
        long offset = calendar.get(Calendar.ZONE_OFFSET);
        return millis - offset;
    }

    /**
     * 把用户时区的时间戳转成设置时区的时间戳
     *
     * @param millis 用户时区的时间戳
     * @return 目标时区的时间戳
     */
    public static long getMillis(final long millis) {
        return getUtcMillis(millis) + Log.getSettings().getZoneOffset().getValue();
    }

    /**
     * 获取目标时区的当前时间戳（默认为东八区）.
     *
     * @return 目标时区的当前时间戳
     */
    public static long getCurMillis() {
        return getMillis(System.currentTimeMillis());
    }

    /**
     * 获取当前日期（yyyy-MM-dd）.
     *
     * @return 当前日期
     */
    public static String getCurDate() {
        return format(getCurMillis(), "yyyy-MM-dd");
    }

    /**
     * 格式化时间戳.
     *
     * @param millis 时间戳
     * @param fmt    时间格式
     * @return 格式化后的时间文本
     */
    public static String format(long millis, @NonNull String fmt) {
        return DateFormat.format(fmt, millis).toString();
    }

    /**
     * 获取目标时区的当前时间（默认为东八区）.
     *
     * @return 目标时区的当前时间
     */
    public static String getCurTime() {
        return format(getCurMillis(), Log.getSettings().getTimeFormat());
    }

    /**
     * 获取当前小时（0-23）.
     *
     * @return 当前小时
     */
    public static int getCurHour() {
        Calendar calendar = getCalendar(getCurMillis());
        return calendar.get(Calendar.HOUR_OF_DAY);
    }
}