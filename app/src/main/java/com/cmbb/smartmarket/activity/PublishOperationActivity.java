package com.cmbb.smartmarket.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.PublishActivity;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/1 下午2:46
 * 修改人：N.Sun
 * 修改时间：16/6/1 下午2:46
 * 修改备注：
 */
public class PublishOperationActivity extends BaseActivity {
    private static final String TAG = PublishOperationActivity.class.getSimpleName();

    @BindView(R.id.iv_publish)
    TextView ivPublish;
    @BindView(R.id.iv_need)
    TextView ivNeed;
    @BindView(R.id.tv_close)
    ImageView tvClose;

    @Override
    protected void init(Bundle savedInstanceState) {
        tvClose.setOnClickListener(this);
        ivPublish.setOnClickListener(this);
        ivNeed.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_close:
                break;
            case R.id.iv_publish:
                PublishActivity.newIntent(this, "发布", "0");
                break;
            case R.id.iv_need:
                PublishActivity.newIntent(this, "求购", "1");
                break;
        }
        finish();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish_operation_layout;
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, PublishOperationActivity.class);
        context.startActivity(intent);
    }
}
