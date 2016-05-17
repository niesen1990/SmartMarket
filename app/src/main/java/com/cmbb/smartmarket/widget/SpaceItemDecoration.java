package com.cmbb.smartmarket.widget;

import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/4 下午4:50
 * 修改人：N.Sun
 * 修改时间：16/5/4 下午4:50
 * 修改备注：
 */
public class SpaceItemDecoration extends RecyclerView.ItemDecoration {
    private int spaceLeft;
    private int spaceRight;
    private int spaceTop;
    private int spaceBottom;

    public SpaceItemDecoration(int left, int right, int top, int bottom) {
        this.spaceLeft = left;
        this.spaceRight = right;
        this.spaceTop = top;
        this.spaceBottom = bottom;
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        outRect.left = spaceLeft;
        outRect.right = spaceRight;
        outRect.top = spaceTop;
        outRect.bottom = spaceBottom;

        // Add top margin only for the first item to avoid double space between items
        /*if (parent.getChildLayoutPosition(view) == 0) {
            outRect.top = spaceBottom;
        } else {
            outRect.top = 0;
        }*/
    }
}
