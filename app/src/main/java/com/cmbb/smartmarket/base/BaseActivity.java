package com.cmbb.smartmarket.base;

import android.content.BroadcastReceiver;
import android.content.DialogInterface;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.broadcast.ExitBroadcast;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.widget.ProgressDialog;
import com.umeng.analytics.MobclickAgent;
import com.umeng.message.PushAgent;

import butterknife.ButterKnife;
import rx.Subscription;

/**
 * 项目名称：SmartMarket
 * 类描述：Activity基础类
 * 创建人：N.Sun
 * 创建时间：16/4/14 上午11:24
 */
public abstract class BaseActivity extends AppCompatActivity implements View.OnClickListener, DialogInterface.OnDismissListener {

    private static final String TAG = BaseActivity.class.getSimpleName();
    protected Subscription subscription;
    private BroadcastReceiver existReceiver;// EXIT
    private ProgressDialog _progressDialog;
    private ActionBar toolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        intToolbar();
        initPush();
        initBroadcast();
        init(savedInstanceState);
    }

    private void intToolbar() {
        if (findViewById(R.id.toolbar) != null) {
            setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
            toolbar = getSupportActionBar();
            assert toolbar != null;
            toolbar.setDisplayHomeAsUpEnabled(true);
            toolbar.setDisplayShowTitleEnabled(false);
        }
    }

    protected abstract void init(Bundle savedInstanceState);

    protected abstract
    @LayoutRes
    int getLayoutId();

    public ActionBar getToolbar() {
        return toolbar;
    }

    public void setToolbar(ActionBar toolbar) {
        this.toolbar = toolbar;
    }

    /**
     * 设置标题
     *
     * @param title 标题
     */
    protected void setTitle(String title) {
        TextView tvTitle = (TextView) findViewById(R.id.title);
        if (tvTitle != null) {
            tvTitle.setText(title);
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(existReceiver);
        unSubscribe();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {

    }

    /**
     * Toast Message
     *
     * @param message String
     */
    protected void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    /**
     * 显示加载中...
     */
    protected void showWaitingDialog() {
        if (_progressDialog == null) {
            _progressDialog = new ProgressDialog(this, R.style.ProgressBarWaiting);
            _progressDialog.setCanceledOnTouchOutside(false);
            _progressDialog.setOnDismissListener(this);
            _progressDialog.show();
        } else {
            _progressDialog.show();
        }
    }

    protected void hideWaitingDialog() {
        if (_progressDialog != null && _progressDialog.isShowing()) {
            _progressDialog.dismiss();
            _progressDialog = null;
        }
    }

    private void initPush() {
        PushAgent.getInstance(this).onAppStart();
    }

    @Override
    public void onBackPressed() {
        unSubscribe();
        super.onBackPressed();
    }

    /**
     * 取消Subscribe
     */
    protected void unSubscribe() {
        if (subscription != null && !subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

    /**
     * 程序退出
     */
    private void initBroadcast() {
        existReceiver = new ExitBroadcast(this);
        IntentFilter filter = new IntentFilter(Constants.INTENT_ACTION_EXIT_APP);
        registerReceiver(existReceiver, filter);
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        unSubscribe();
    }
}
