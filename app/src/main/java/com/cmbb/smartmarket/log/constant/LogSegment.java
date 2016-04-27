package com.cmbb.smartmarket.log.constant;

/**
 * 日志时间切片.
 */
public enum LogSegment {

    ONE_HOUR(1),
    TWO_HOURS(2),
    THREE_HOURS(3),
    FOUR_HOURS(4),
    SIX_HOURS(6),
    TWELVE_HOURS(12),
    TWENTY_FOUR_HOURS(24);

    private int mValue;

    LogSegment(int value) {
        mValue = value;
    }

    public int getValue() {
        return mValue;
    }
}
