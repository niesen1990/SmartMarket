package com.cmbb.smartmarket.widget;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：15/7/29 上午11:11
 */
public class MengCoordinatorLayout extends CoordinatorLayout {

    private boolean allowForScrool = true;

    private OnResizeListener mListener;

    public OnResizeListener getResizeListener() {
        return mListener;
    }

    public void setResizeListener(OnResizeListener listener) {
        mListener = listener;
    }

    public boolean isAllowForScrool() {
        return allowForScrool;
    }

    public void setAllowForScrool(boolean allowForScrool) {
        this.allowForScrool = allowForScrool;
    }

    public MengCoordinatorLayout(Context context) {
        super(context);
    }

    public MengCoordinatorLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MengCoordinatorLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onStartNestedScroll(View child, View target, int nestedScrollAxes) {
        return allowForScrool && super.onStartNestedScroll(child, target, nestedScrollAxes);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        if (mListener != null) {
            mListener.OnResize(w, h, oldw, oldh);
        }
    }

    public interface OnResizeListener {
        void OnResize(int w, int h, int oldw, int oldh);
    }
}
