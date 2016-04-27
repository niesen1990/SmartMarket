package com.cmbb.smartmarket.log.constant;

/**
 * 日志级别.
 */
public enum LogLevel {

    VERBOSE("VERBOSE"),
    DEBUG("DEBUG"),
    INFO("INFO"),
    WARN("WARN"),
    ERROR("ERROR"),
    WTF("WTF"),
    JSON("JSON");

    private String mValue;

    LogLevel(String value) {
        mValue = value;
    }

    public String getValue() {
        return mValue;
    }
}
