package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;

import com.alipay.sdk.app.PayTask;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.PayReplayAdapter;
import com.cmbb.smartmarket.activity.market.model.MarketOrderPayOrderRequestModel;
import com.cmbb.smartmarket.activity.market.model.MarketOrderPayOrderResponseModel;
import com.cmbb.smartmarket.activity.market.model.PayItemModel;
import com.cmbb.smartmarket.activity.market.model.PayResult;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/11 下午2:05
 * 修改人：N.Sun
 * 修改时间：16/5/11 下午2:05
 * 修改备注：
 */
public class PayActivity extends BaseRecyclerActivity {
    private static final String TAG = PayActivity.class.getSimpleName();
    // 商户PID
    public static final String PARTNER = "2088021604444292";
    // 商户私钥，pkcs8格式
    public static final String RSA_PRIVATE = "MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBANBP6Nl0z1xXrGNk0FuC4mjvEva3HwETYL8gQkgLyNwknMvGaiO9G0m44RHu5KgDSAqYJZasBcuH2BK7GBT71Rd5/uIscYliC6lyFK5WQLSSaA397DFu7zTZ/ZJAGlb/GOobwUAuPq86daLe2/j5sP3McP/Fvng99w2fv9+qQFrPAgMBAAECgYEAjIEZoXL0WmiYUgIxt0e0xupadCZXtzYGz2NG0amBNVtMlvWhqbFnsnYM+TeU6u4rrVmqINKupfVefGPNfnnN4+v8AvN5e+of07oC/kYW63mWjJAGerqjch7/kTSCqexodGbJctwTwiVI+QvIdTCXqJxdhx2dfj5BAk/Rwl4BKGECQQDyAn//T2OaZXz69LTBp5PfdLGtwtF2EX9mHb3ZeCkeziMcvB6T2ctGQrehFK0reH1ERmaUl6QaeZNYxYA7q+3lAkEA3Fq4B6wrjOFTxCgybAFun83puPeTn9RAwTas4WMnyf5H3ogTRzE4Cbl+9lPzSOY8K79efvvPvRqO9YdAajo6owJBAM5+QZant5XyyHwcteqSwQKmQEDB/RVgArMv52CaPYPSYXVQMkr3R5GwtZwU11lDGqdZ5ocdCGGqoIXbJvpDTd0CQQC6Uxt5oWPR5FZob3TzTuKzzfHrrazuYRPATPMyQh3K93DeAkIK2NuBnZB1ydbVtZj7hP3qchLe3C41/v/A0yvxAkBrM3KH7XgitJ/WaWsQLaEESZO2RdCgRrmGLwDM+ZiuMw2riuwHR1anfXXZLKrLSQesX7OGMBAOzc+Qxy7iAM5w";
    // 商户收款账号
    public static final String SELLER = "ios_android_smart@smart-kids.com";
    private static final int SDK_PAY_FLAG = 1;
    private static final int SDK_CHECK_FLAG = 2;
    @BindView(R.id.tv_whole)
    TextView tvWhole;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    int payWay = 0;// 0：支付宝 1:微信
    MarketOrderPayOrderResponseModel mMarketOrderPayOrderResponseModel;//支付数据
    Observer<MarketOrderPayOrderResponseModel> mSmartServicesPayOrderResponseModelObserver = new Observer<MarketOrderPayOrderResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(MarketOrderPayOrderResponseModel marketOrderPayOrderResponseModel) {
            hideWaitingDialog();
            mMarketOrderPayOrderResponseModel = marketOrderPayOrderResponseModel;
            Log.e(TAG, "paymentData : " + marketOrderPayOrderResponseModel.getData().getPayTypes().get(payWay).getPaymentData());//打印支付数据
        }
    };

    private Handler mHandler = new Handler() {
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case SDK_PAY_FLAG: {
                    PayResult payResult = new PayResult((String) msg.obj);
                    // 支付宝返回此次支付结果及加签，建议对支付宝签名信息拿签约时支付宝提供的公钥做验签
                    String resultInfo = payResult.getResult();
                    String resultStatus = payResult.getResultStatus();
                    // 判断resultStatus 为“9000”则代表支付成功，具体状态码代表含义可参考接口文档
                    if (TextUtils.equals(resultStatus, "9000")) {
                        showToast("支付成功");
                        Intent intent = new Intent();
                        intent.putExtra("orderCode", getIntent().getStringExtra("orderCode"));
                        setResult(RESULT_OK, intent);
                        finish();
                    } else {
                        // 判断resultStatus 为非“9000”则代表可能支付失败
                        // “8000”代表支付结果因为支付渠道原因或者系统原因还在等待支付结果确认，最终交易是否成功以服务端异步通知为准（小概率状态）
                        if (TextUtils.equals(resultStatus, "8000")) {
                            showToast("支付结果确认中");
                        } else {
                            // 其他值就可以判断为支付失败，包括用户主动取消支付，或者系统返回的错误
                            showToast("支付失败");
                        }
                    }
                    break;
                }
                case SDK_CHECK_FLAG: {
                    showToast("检查结果为：" + msg.obj);
                    break;
                }
                default:
                    break;
            }
        }
    };

    @Override
    protected int getLayoutId() {
        return R.layout.activity_pay_layout;
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("确认支付");
        tvSubmit.setOnClickListener(this);
        tvWhole.setText("￥" + getIntent().getDoubleExtra("money", 0));
        onRefresh();
    }

    private MarketOrderPayOrderRequestModel setParams() {
        MarketOrderPayOrderRequestModel marketOrderPayOrderRequestModel = new MarketOrderPayOrderRequestModel();
        marketOrderPayOrderRequestModel.setCmd(ApiInterface.MarketOrderPayOrder);
        marketOrderPayOrderRequestModel.setToken(BaseApplication.getToken());
        marketOrderPayOrderRequestModel.setParameters(new MarketOrderPayOrderRequestModel.ParametersEntity(getIntent().getStringExtra("orderCode"), 1));
        return marketOrderPayOrderRequestModel;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (mMarketOrderPayOrderResponseModel != null)
                    aliPay();
                break;
        }
    }

    /**
     * 支付宝
     */
    private void aliPay() {
        if (TextUtils.isEmpty(PARTNER) || TextUtils.isEmpty(RSA_PRIVATE) || TextUtils.isEmpty(SELLER)) {
            DialogUtils.createAlertDialog(PayActivity.this, "警告", "需要配置PARTNER | RSA_PRIVATE| SELLER", false, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    finish();
                }
            });
            return;
        }
        Runnable payRunnable = new Runnable() {
            @Override
            public void run() {
                // 构造PayTask 对象
                PayTask alipay = new PayTask(PayActivity.this);
                // 调用支付接口，获取支付结果
                String result = alipay.pay(mMarketOrderPayOrderResponseModel.getData().getPayTypes().get(payWay).getPaymentData(), true);
                Message msg = new Message();
                msg.what = SDK_PAY_FLAG;
                msg.obj = result;
                mHandler.sendMessage(msg);
            }
        };
        Thread payThread = new Thread(payRunnable);
        payThread.start();
    }

    /**
     * 微信
     */
    private void weixinPay() {
        //微信支付
        /*try {
            Log.e(TAG, "payWayModel is null :" + payWayModel == null);
            if (payWayModel != null) {
                PayReq req = new PayReq();
                req.appId = payWayModel.getPayTypes().get(1).getWeixinData().getAppid();
                req.partnerId = payWayModel.getPayTypes().get(1).getWeixinData().getPartnerid();
                req.prepayId = payWayModel.getPayTypes().get(1).getWeixinData().getPrepayid();
                req.nonceStr = payWayModel.getPayTypes().get(1).getWeixinData().getNoncestr();
                req.timeStamp = payWayModel.getPayTypes().get(1).getWeixinData().getTimestamp();
                req.packageValue = payWayModel.getPayTypes().get(1).getWeixinData().getPackageX();
                req.sign = payWayModel.getPayTypes().get(1).getWeixinData().getSign();

                api.registerApp(req.appId);
                Log.e(TAG, payWayModel.getPayTypes().get(1).getWeixinData().toString());
                showShortToast("正在启动微信支付...");
                api.sendReq(req);
            } else {
                Log.d("PAY_GET", "服务器请求错误");
                showShortToast("服务器请求错误");
            }
        } catch (Exception e) {
            Log.e("PAY_GET", "异常：" + e.getMessage());
            showShortToast("异常：" + e.getMessage());
        }*/
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new PayReplayAdapter(this);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore() {
        adapter.pauseMore();
    }

    @Override
    public void onRefresh() {
        adapter.clear();
        adapter.add(new PayItemModel(R.drawable.ic_zhifubao, "支付宝", "推荐支付宝用户使用"));
        unSubscribe();
        showWaitingDialog();
        subscription = HttpMethod.getInstance().marketOrderPayOrder(mSmartServicesPayOrderResponseModelObserver, setParams());
    }

    public static void newIntent(Context context, String orderCode, double money) {
        Intent intent = new Intent(context, PayActivity.class);
        intent.putExtra("orderCode", orderCode);
        intent.putExtra("money", money);
        context.startActivity(intent);
    }
}
