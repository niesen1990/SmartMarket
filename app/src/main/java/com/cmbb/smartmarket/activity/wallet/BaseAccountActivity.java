package com.cmbb.smartmarket.activity.wallet;

import android.support.design.widget.BottomSheetBehavior;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.widget.NestedScrollView;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午10:37
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午10:37
 * 修改备注：
 */
public abstract class BaseAccountActivity extends BaseActivity {
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.iv_cancel)
    ImageView ivCancel;
    @BindView(R.id.et01)
    EditText et01;
    @BindView(R.id.et02)
    EditText et02;
    @BindView(R.id.et03)
    EditText et03;
    @BindView(R.id.et04)
    EditText et04;
    @BindView(R.id.et05)
    EditText et05;
    @BindView(R.id.et06)
    EditText et06;

    public void showBottomSheet(View view) {
        BottomSheetBehavior behaviorPsw = BottomSheetBehavior.from(scroll);
        if (behaviorPsw.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behaviorPsw.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behaviorPsw.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }
}
