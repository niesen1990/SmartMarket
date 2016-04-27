package com.cmbb.smartmarket.log.printer;


import com.cmbb.smartmarket.log.constant.LogLevel;
import com.cmbb.smartmarket.log.util.SysUtils;

/**
 * 打印接口.
 */
public interface Printer {

    String LINE_SEPARATOR = SysUtils.getLineSeparator();

    /**
     * 日志打印输出到控制台.
     *
     * @param level   级别
     * @param tag     标签
     * @param message 信息
     * @param element 堆栈元素
     */
    void printConsole(LogLevel level, String tag, String message, StackTraceElement element);

    /**
     * 日志打印输出到文件.
     *
     * @param level   级别
     * @param tag     标签
     * @param message 信息
     * @param element 堆栈元素
     */
    void printFile(LogLevel level, String tag, String message, StackTraceElement element);
}
