package com.cmbb.smartmarket.utils;

import android.os.CountDownTimer;
import android.widget.TextView;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/11/2 15:23
 */
public class TimeCount extends CountDownTimer {
    private TextView tvCount;
    /**
     * @param millisInFuture    The number of millis in the future from the call
     *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
     *                          is called.
     * @param countDownInterval The interval along the way to receive
     *                          {@link #onTick(long)} callbacks.
     */
    public TimeCount(long millisInFuture, long countDownInterval) {
        super(millisInFuture, countDownInterval);
    }

    public TimeCount(long millisInFuture, long countDownInterval, TextView tvCount) {
        this(millisInFuture, countDownInterval);
        this.tvCount = tvCount;
    }

    @Override
    public void onTick(long millisUntilFinished) {
        tvCount.setEnabled(false);
        tvCount.setText(millisUntilFinished / 1000 < 10 ? "验证码0" + (millisUntilFinished / 1000 ) + "s" : "验证码" + (millisUntilFinished / 1000 ) + "s");
    }

    @Override
    public void onFinish() {
        tvCount.setText("获取验证码");
//        tvCount.setTextColor(tvCount.getContext().getResources().getColor(R.color.primaryColor));
        tvCount.setEnabled(true);
    }
}
