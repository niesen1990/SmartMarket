package com.cmbb.smartmarket.activity.message;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.widget.TextView;

import com.alibaba.mobileim.conversation.IYWConversationService;
import com.alibaba.mobileim.conversation.IYWConversationUnreadChangeListener;
import com.alibaba.mobileim.conversation.IYWMessageLifeCycleListener;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.base.BaseActivity;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/29 下午3:01
 */
public class IMConversationActivity extends BaseActivity {
    private static final String TAG = IMConversationActivity.class.getSimpleName();
    private IYWConversationService mConversationService;
    private IYWConversationUnreadChangeListener mConversationUnreadChangeListener;
    private IYWMessageLifeCycleListener mMessageLifeCycleListener;

    private Handler mHandler = new Handler(Looper.getMainLooper());

    private TextView mUnread;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("最近联系人");
        if (IMHelper.getInstance().getIMKit() == null) return;
        mConversationService = IMHelper.getInstance().getIMKit().getConversationService();
        getSupportFragmentManager().beginTransaction().add(R.id.container, IMHelper.getInstance().getIMKit().getConversationFragment()).commit();
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_im_conversation_layout;
    }


    public static void newIntent(Context context) {
        Intent intent = new Intent(context, IMConversationActivity.class);
        context.startActivity(intent);
    }
}
