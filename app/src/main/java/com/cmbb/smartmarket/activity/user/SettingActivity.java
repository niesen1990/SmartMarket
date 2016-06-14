package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketLogoutRequestModel;
import com.cmbb.smartmarket.activity.user.model.MarketLogoutResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.network.Logout;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.cmbb.smartmarket.utils.TDevice;
import com.thefinestartist.finestwebview.FinestWebView;
import com.umeng.socialize.UMShareAPI;

import org.lzh.framework.updatepluginlib.UpdateBuilder;
import org.lzh.framework.updatepluginlib.model.Update;
import org.lzh.framework.updatepluginlib.strategy.UpdateStrategy;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午7:41
 */
public class SettingActivity extends BaseActivity {

    private static final String TAG = SettingActivity.class.getSimpleName();
    @BindView(R.id.rl_about)
    RelativeLayout rlAbout;
    @BindView(R.id.rl_info)
    RelativeLayout rlInfo;
    @BindView(R.id.rl_suggestion)
    RelativeLayout rlSuggestion;
    @BindView(R.id.rl_rule)
    RelativeLayout rlRule;
    @BindView(R.id.rl_share)
    RelativeLayout rlShare;
    @BindView(R.id.rl_update)
    RelativeLayout rlUpdate;
    @BindView(R.id.tv_logout)
    TextView tvLogout;

    protected void initView() {
        rlAbout.setOnClickListener(this);
        rlSuggestion.setOnClickListener(this);
        rlRule.setOnClickListener(this);
        rlShare.setOnClickListener(this);
        tvLogout.setOnClickListener(this);
        rlUpdate.setOnClickListener(this);
        rlInfo.setOnClickListener(this);
        // UpdateBuilder中可设置的配置与UpdateConfig中一致。检查更新入口调用check方法
        // 对于UpdateBuilder中未设置的参数。会默认使用UpdateConfig中的配置
        UpdateBuilder.create().strategy(new UpdateStrategy() {
            @Override
            public boolean isShowUpdateDialog(Update update) {
                return true;
            }

            @Override
            public boolean isAutoInstall() {
                return true;
            }

            @Override
            public boolean isShowInstallDialog() {
                return false;
            }

            @Override
            public boolean isShowDownloadDialog() {
                return true;
            }
        }).check(this);
    }

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("设置");
        initView();
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_info:
                InfoActivity.newIntent(this);
                break;
            case R.id.rl_about:
                new FinestWebView.Builder(this)
                        .theme(R.style.FinestWebViewTheme)
                        .titleDefault("萌宝铺子")
                        .webViewBuiltInZoomControls(true)
                        .webViewDisplayZoomControls(true)
                        .showUrl(false)
                        .statusBarColorRes(R.color.colorPrimary)
                        .toolbarColorRes(R.color.colorPrimary)
                        .titleColorRes(R.color.finestWhite)
                        .urlColorRes(R.color.colorPrimary)
                        .iconDefaultColorRes(R.color.finestWhite)
                        .progressBarColorRes(R.color.finestWhite)
                        //                        .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                        //                        .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                        //                        .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                        .showSwipeRefreshLayout(false)
                        .showIconMenu(false)
                        .dividerHeight(0)
                        .gradientDivider(false)
                        .show("http://mbpz.file.alimmdn.com/index.html?version=" + TDevice.getVersionName() + "&type=2");
                break;
            case R.id.rl_suggestion:
                SuggestionActivity.newIntent(this);
                break;
            case R.id.rl_rule:
                new FinestWebView.Builder(this)
                        .theme(R.style.FinestWebViewTheme)
                        .titleDefault("萌宝铺子")
                        .showUrl(false)
                        .statusBarColorRes(R.color.colorPrimary)
                        .toolbarColorRes(R.color.colorPrimary)
                        .titleColorRes(R.color.finestWhite)
                        .urlColorRes(R.color.colorPrimary)
                        .iconDefaultColorRes(R.color.finestWhite)
                        .progressBarColorRes(R.color.finestWhite)
                        //                        .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                        //                        .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                        //                        .stringResCopiedToClipboard(R.string.copied_to_clipboard)
                        .showSwipeRefreshLayout(false)
                        .showIconMenu(false)
                        .dividerHeight(0)
                        .gradientDivider(false)
                        //                        .setCustomAnimations(R.anim.slide_up, R.anim.hold, R.anim.hold, R.anim.slide_down)
                        .show("http://mbpz.file.alimmdn.com/question.html?version=" + TDevice.getVersionName() + "&type=2");
                break;
            case R.id.rl_share:
                SocialUtils.share(this, R.mipmap.ic_launcher, "萌宝铺子", "我分享了一个用家中闲置物品赚钱的神器，妈妈们都来试试身手吧！", ApiInterface.SHARE_APP);
                break;
            case R.id.tv_logout:
                // TODO: 16/4/27
                if (!TextUtils.isEmpty(BaseApplication.getToken())) {
                    showWaitingDialog();
                    HttpMethod.getInstance().marketLogout(new Observer<MarketLogoutResponseModel>() {
                        @Override
                        public void onCompleted() {
                            hideWaitingDialog();
                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, e.toString());
                            hideWaitingDialog();
                        }

                        @Override
                        public void onNext(MarketLogoutResponseModel marketLogoutResponseModel) {
                            if (marketLogoutResponseModel != null) {
                                Logout.logout(SettingActivity.this);
                            }
                        }
                    }, setParams());
                } else {
                    showToast("您还没有登陆");
                }
                break;
            case R.id.rl_update:

                break;
        }
    }

    private MarketLogoutRequestModel setParams() {
        MarketLogoutRequestModel marketLogoutRequestModel = new MarketLogoutRequestModel();
        marketLogoutRequestModel.setToken(BaseApplication.getToken());
        marketLogoutRequestModel.setCmd(ApiInterface.MarketLogout);
        return marketLogoutRequestModel;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_setting_layout;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, SettingActivity.class);
        context.startActivity(intent);
    }

}
