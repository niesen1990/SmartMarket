package com.cmbb.smartmarket.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.ImageView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/26 上午9:44
 * 修改人：N.Sun
 * 修改时间：16/5/26 上午9:44
 * 修改备注：
 */
public class ProgressImageView extends ImageView {
    private static final String TAG = "ProgressImageView";
    private Context mContext;
    public static final int FONT_SIZE = 14;
    public static final int ROUND_WIDTH = 50;
    public static final int STROKE_WIDTH = 7;
    private int mFontSize;
    private int mRoundWidth;
    private int mStrokeWidth;
    private Paint mPaint;
    private boolean mShowProgress;
    private int mProgress;
    private float mTextY;
    private int mCenterX;
    private int mCenterY;
    private int mRadius;
    private RectF mOval;

    public ProgressImageView(Context context) {
        super(context);
        mContext = context;
    }

    public ProgressImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
    }

    private void init() {
        float scale = mContext.getResources().getDisplayMetrics().density;

        mFontSize = (int) (FONT_SIZE * scale);
        mRoundWidth = (int) (ROUND_WIDTH * scale);
        mStrokeWidth = (int) (STROKE_WIDTH * scale);

        mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setTextSize(mFontSize);

        mCenterX = getWidth() / 2;
        mCenterY = getHeight() / 2;
        mRadius = mRoundWidth / 2;

        mTextY = mCenterY + mFontSize * 11.0f / 28;

        mOval = new RectF(mCenterX - mRadius, mCenterY - mRadius, mCenterX + mRadius, mCenterY + mRadius);
    }

    public void onDraw(Canvas canvas) {
        if (mShowProgress) {
            if (mCenterX == 0 || mCenterY == 0) {
                init();
            }
            // 画最外层的大圆环
            mPaint.setColor(Color.DKGRAY);
            mPaint.setStyle(Paint.Style.STROKE);
            mPaint.setStrokeWidth(mStrokeWidth);
            canvas.drawCircle(mCenterX, mCenterY, mRadius, mPaint);

            // 画进度百分比
            mPaint.setStrokeWidth(0);
            mPaint.setColor(Color.WHITE);
            mPaint.setTypeface(Typeface.MONOSPACE);
            mPaint.setTextAlign(Paint.Align.CENTER);
            String progressStr = mProgress + "%";
            canvas.drawText(progressStr, mCenterX, mTextY, mPaint);

            // 画圆环的进度
            mPaint.setStrokeWidth(mStrokeWidth);
            mPaint.setColor(Color.WHITE);
            canvas.drawArc(mOval, 0, 360 * mProgress / 100, false, mPaint);
        } else {
            super.onDraw(canvas);
        }
    }

    public void startProgress() {
        mShowProgress = true;
        setProgress(0);
    }

    public void setProgress(int progress) {
        if (mShowProgress) {
            mProgress = progress;
            invalidate();
        }
    }

    public void closeProgress() {
        mShowProgress = false;
    }
}
