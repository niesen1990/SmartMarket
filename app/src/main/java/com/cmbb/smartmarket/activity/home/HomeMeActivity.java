package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.AddressManagerActivity;
import com.cmbb.smartmarket.activity.home.model.MyselfGetCountRequestModel;
import com.cmbb.smartmarket.activity.home.model.MyselfGetCountResponseModel;
import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.activity.user.BuyFinishedActivity;
import com.cmbb.smartmarket.activity.user.MeCollectionActivity;
import com.cmbb.smartmarket.activity.user.OffManagerActivity;
import com.cmbb.smartmarket.activity.user.PublishListActivity;
import com.cmbb.smartmarket.activity.user.RefundActivity;
import com.cmbb.smartmarket.activity.user.SettingActivity;
import com.cmbb.smartmarket.activity.user.SoldFinishedActivity;
import com.cmbb.smartmarket.activity.user.UserCenterActivity;
import com.cmbb.smartmarket.activity.wallet.WalletActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.db.DBContent;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/19 上午9:34
 */
public class HomeMeActivity extends BaseHomeActivity implements LoaderManager.LoaderCallbacks<Cursor> {
    private static final String TAG = HomeMeActivity.class.getSimpleName();

    @BindView(R.id.rl_info)
    RelativeLayout rlInfo;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_line01)
    TextView tvLine01;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.rl_wallet)
    RelativeLayout rlWallet;
    @BindView(R.id.rl_refund)
    RelativeLayout rlRefund;
    @BindView(R.id.rl_publish)
    RelativeLayout rlPublish;
    @BindView(R.id.rl_selled)
    RelativeLayout rlSelled;
    @BindView(R.id.rl_not_login)
    RelativeLayout rlNotLogin;
    @BindView(R.id.rl_buy)
    RelativeLayout rlBuy;
    @BindView(R.id.tv_login)
    TextView tvLogin;
    @BindView(R.id.rl_collection)
    RelativeLayout rlCollection;
    @BindView(R.id.rl_off)
    RelativeLayout rlOff;
    @BindView(R.id.rl_address)
    RelativeLayout rlAddress;
    @BindView(R.id.tv_publish_count)
    TextView tvPublishCount;
    @BindView(R.id.tv_sold_count)
    TextView tvSoldCount;
    @BindView(R.id.tv_buyed_count)
    TextView tvBuyedCount;
    @BindView(R.id.tv_collection_count)
    TextView tvCollectionCount;
    private int userId;
    Observer<MyselfGetCountResponseModel> mMyselfGetCountResponseModelObserver = new Observer<MyselfGetCountResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(MyselfGetCountResponseModel myselfGetCountResponseModel) {
            hideWaitingDialog();
            if (myselfGetCountResponseModel != null) {
                // UI
                tvPublishCount.setText("" + myselfGetCountResponseModel.getData().getProductPublicCount());
                tvSoldCount.setText("" + myselfGetCountResponseModel.getData().getProductSoldCount());
                tvBuyedCount.setText("" + myselfGetCountResponseModel.getData().getProductBoughtCount());
                tvCollectionCount.setText("" + myselfGetCountResponseModel.getData().getProductCollectCount());
            }
        }
    };

    protected void init() {
        tvMe.setSelected(true);
        rlWallet.setOnClickListener(this);
        rlInfo.setOnClickListener(this);
        rlRefund.setOnClickListener(this);
        rlPublish.setOnClickListener(this);
        rlSelled.setOnClickListener(this);
        rlBuy.setOnClickListener(this);
        rlCollection.setOnClickListener(this);
        rlOff.setOnClickListener(this);
        rlAddress.setOnClickListener(this);
        tvLogin.setOnClickListener(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        setTitle("我的");
        init();
        getSupportLoaderManager().initLoader(0, null, this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (TextUtils.isEmpty(BaseApplication.getToken())) {
            rlNotLogin.setVisibility(View.VISIBLE);
            rlInfo.setVisibility(View.GONE);
        } else {
            rlNotLogin.setVisibility(View.GONE);
            rlInfo.setVisibility(View.VISIBLE);
        }
        if (!TextUtils.isEmpty(BaseApplication.getToken()))
            subscription = HttpMethod.getInstance().myselfGetCount(mMyselfGetCountResponseModelObserver, setCountParams());
    }

    private MyselfGetCountRequestModel setCountParams() {
        MyselfGetCountRequestModel myselfGetCountRequestModel = new MyselfGetCountRequestModel();
        myselfGetCountRequestModel.setCmd(ApiInterface.MyselfGetCount);
        myselfGetCountRequestModel.setToken(BaseApplication.getToken());
        return myselfGetCountRequestModel;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_wallet:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    WalletActivity.newIntent(this);
                }
                break;
            case R.id.rl_info:
                if (userId == 0)
                    return;
                UserCenterActivity.newIntent(this, userId);
                break;
            case R.id.rl_refund:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    RefundActivity.newIntent(this);
                }
                break;
            case R.id.rl_publish:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    PublishListActivity.newIntent(this);
                }
                break;
            case R.id.rl_selled:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    SoldFinishedActivity.newIntent(this);
                }
                break;
            case R.id.rl_buy:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    BuyFinishedActivity.newIntent(this);
                }
                break;
            case R.id.rl_collection:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    MeCollectionActivity.newIntent(this);
                }
                break;
            case R.id.rl_off:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    OffManagerActivity.newIntent(this);
                }
                break;
            case R.id.rl_address:
                if (TextUtils.isEmpty(BaseApplication.getToken())) {
                    showToast("请登陆");
                } else {
                    AddressManagerActivity.newIntent(this);
                }
                break;
            case R.id.tv_login:
                LoginActivity.newIntent(this);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_me;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_home_me, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_setting:
                SettingActivity.newIntent(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return null;
    }

    @Override
    public void onItemClick(View rootView, int position) {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, DBContent.DBUser.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            Log.i(TAG, cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_TOKEN)));
            userId = cursor.getInt(cursor.getColumnIndex(DBContent.DBUser.USER_ID));
            String headImageUrl = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_HEAD_IMG));
            if (!TextUtils.isEmpty(headImageUrl))
                ImageLoader.loadUrlAndDiskCache(this, headImageUrl, ivHead, new CircleTransform(this));
            String nick = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_NICK_NAME));
            if (!TextUtils.isEmpty(nick))
                tvNick.setText(nick);
            String city = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_CITY));
            if (!TextUtils.isEmpty(city))
                tvAddress.setText(city);
            String sex = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_MALE));
            if (!TextUtils.isEmpty(sex)) {
                switch (sex) {
                    case "1":
                        tvSex.setText("男");
                        break;
                    case "2":
                        tvSex.setText("女");
                        break;
                }
            }
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeMeActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
