package com.cmbb.smartmarket.utils.date;

import com.cmbb.smartmarket.log.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/11/18 上午11:41
 */
public class JTimeTransform {
    public static final int SECOND = 60;
    public static final int HOUR = 3600;
    public static final int DAY = 86400;
    public static final int WEEK = 604800;


    Calendar currentTime;


    public JTimeTransform() {
        currentTime = new GregorianCalendar();
        currentTime.setTime(new Date());
    }

    public JTimeTransform(long timestamp) {
        currentTime = new GregorianCalendar();
        currentTime.setTime(new Date(timestamp * 1000));
    }

    public JTimeTransform(String timestamp) {
        currentTime = new GregorianCalendar();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        try {
            Date date = sdf.parse(timestamp);
            Log.e("Date", "Date = " + date.toString());
            currentTime.setTime(date);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public JTimeTransform(int year, int month, int day) {
        currentTime = new GregorianCalendar(year, month, day);
    }


    public int getDay() {
        return currentTime.get(Calendar.DATE);
    }

    public int getMonth() {
        return currentTime.get(Calendar.MONTH) + 1;
    }

    public int getYear() {
        return currentTime.get(Calendar.YEAR);
    }

    public long getTimestamp() {
        return currentTime.getTime().getTime() / 1000;
    }


    /**
     * 格式化输出日期
     * 年:y		月:M		日:d		时:h(12制)/H(24值)	分:m		秒:s		毫秒:S
     *
     * @param formatString
     */
    public String toString(String formatString) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        String date = format.format(currentTime.getTime());
        return date;
    }


    /**
     * 格式化解析日期文本
     * 年:y		月:M		日:d		时:h(12制)/H(24值)	分:m		秒:s		毫秒:S
     *
     * @param formatString
     */
    public JTimeTransform parse(String formatString, String content) {
        SimpleDateFormat format = new SimpleDateFormat(formatString);
        try {
            currentTime.setTime(format.parse(content));
            return this;
        } catch (ParseException e) {
            return null;
        }
    }


    public interface DateFormat {
        public String format(JTimeTransform date, long delta);
    }

    public String toString(DateFormat format) {
        long delta = (System.currentTimeMillis() - currentTime.getTime().getTime()) / 1000;
        return format.format(this, delta);
    }
}
