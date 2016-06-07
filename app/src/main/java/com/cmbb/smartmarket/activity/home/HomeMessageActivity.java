package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetTypeRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetTypeResponseModel;
import com.cmbb.smartmarket.activity.message.IMConversationActivity;
import com.cmbb.smartmarket.activity.message.OrderMessageActivity;
import com.cmbb.smartmarket.activity.message.StoreMessageActivity;
import com.cmbb.smartmarket.activity.message.SystemMessageActivity;
import com.cmbb.smartmarket.base.BaseApplication;
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
public class HomeMessageActivity extends BaseHomeActivity {
    private static final String TAG = HomeMessageActivity.class.getSimpleName();
    @BindView(R.id.main_content)
    RelativeLayout mainContent;
    @BindView(R.id.rl_sys)
    RelativeLayout rlSys;
    @BindView(R.id.fl)
    FrameLayout fl;
    @BindView(R.id.tv_sys)
    ImageView tvSys;
    @BindView(R.id.tv_message_sys_count)
    TextView tvMessageSysCount;
    @BindView(R.id.tv_sys_content)
    TextView tvSysContent;
    @BindView(R.id.tv_sys_time)
    TextView tvSysTime;
    @BindView(R.id.rl_store)
    RelativeLayout rlStore;
    @BindView(R.id.fl_store)
    FrameLayout flStore;
    @BindView(R.id.tv_store)
    ImageView tvStore;
    @BindView(R.id.tv_message_store_count)
    TextView tvMessageStoreCount;
    @BindView(R.id.tv_store_content)
    TextView tvStoreContent;
    @BindView(R.id.tv_store_time)
    TextView tvStoreTime;
    @BindView(R.id.rl_order)
    RelativeLayout rlOrder;
    @BindView(R.id.fl_order)
    FrameLayout flOrder;
    @BindView(R.id.tv_order)
    ImageView tvOrder;
    @BindView(R.id.tv_message_order_count)
    TextView tvMessageOrderCount;
    @BindView(R.id.tv_order_content)
    TextView tvOrderContent;
    @BindView(R.id.tv_order_time)
    TextView tvOrderTime;
    @BindView(R.id.rl_chat)
    RelativeLayout rlChat;
    @BindView(R.id.fl_chat)
    FrameLayout flChat;
    @BindView(R.id.tv_chat)
    ImageView tvChat;
    @BindView(R.id.tv_message_chat_count)
    TextView tvMessageChatCount;
    @BindView(R.id.tv_chat_content)
    TextView tvChatContent;
    @BindView(R.id.tv_chat_time)
    TextView tvChatTime;

    MarketMessageGetTypeResponseModel mMarketMessageGetTypeResponseModel;
    Observer<MarketMessageGetTypeResponseModel> mMarketMessageGetTypeResponseModelObserver = new Observer<MarketMessageGetTypeResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketMessageGetTypeResponseModel marketMessageGetTypeResponseModel) {
            mMarketMessageGetTypeResponseModel = marketMessageGetTypeResponseModel;
            if (marketMessageGetTypeResponseModel != null && marketMessageGetTypeResponseModel.getData().size() == 3) {
                for (MarketMessageGetTypeResponseModel.DataEntity dataEntity : marketMessageGetTypeResponseModel.getData()) {
                    switch (dataEntity.getModual()) {
                        case "system":
                            if (dataEntity.getNoticeCount() == 0) {
                                tvMessageSysCount.setVisibility(View.GONE);
                            } else {
                                tvMessageSysCount.setVisibility(View.VISIBLE);
                                tvMessageSysCount.setText(dataEntity.getNoticeCount() + "");
                            }
                            if (!TextUtils.isEmpty(dataEntity.getNoticeContent()))
                                tvSysContent.setText(dataEntity.getNoticeContent());
                            break;
                        case "order":
                            if (dataEntity.getNoticeCount() == 0) {
                                tvMessageOrderCount.setVisibility(View.GONE);
                            } else {
                                tvMessageOrderCount.setVisibility(View.VISIBLE);
                                tvMessageOrderCount.setText(dataEntity.getNoticeCount() + "");
                            }
                            if (!TextUtils.isEmpty(dataEntity.getNoticeContent()))
                                tvOrderContent.setText(dataEntity.getNoticeContent());
                            break;
                        case "product":
                            if (dataEntity.getNoticeCount() == 0) {
                                tvMessageStoreCount.setVisibility(View.GONE);
                            } else {
                                tvMessageStoreCount.setVisibility(View.VISIBLE);
                                tvMessageStoreCount.setText(dataEntity.getNoticeCount() + "");
                            }
                            if (!TextUtils.isEmpty(dataEntity.getNoticeContent()))
                                tvStoreContent.setText(dataEntity.getNoticeContent());
                            break;
                    }
                }

            }
        }
    };

    protected void init() {
        tvMessage.setSelected(true);
        mainContent = (RelativeLayout) findViewById(R.id.main_content);
        rlSys.setOnClickListener(this);
        rlStore.setOnClickListener(this);
        tvMessageStoreCount = (TextView) findViewById(R.id.tv_message_store_count);
        rlOrder.setOnClickListener(this);
        rlChat.setOnClickListener(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        getToolbar().setDisplayHomeAsUpEnabled(false);
        setTitle("消息");
        init();
    }

    @Override
    public void updateMessage(int unReadCount) {
        super.updateMessage(unReadCount);
        if (unReadCount > 0) {
            tvMessageChatCount.setVisibility(View.VISIBLE);
            if (unReadCount < 100) {
                tvMessageChatCount.setText(unReadCount + "");
            } else {
                tvMessageChatCount.setText("99+");
            }
        } else {
            tvMessageChatCount.setVisibility(View.INVISIBLE);
        }
    }

    private MarketMessageGetTypeRequestModel setMessageParams() {
        MarketMessageGetTypeRequestModel marketMessageGetTypeRequestModel = new MarketMessageGetTypeRequestModel();
        marketMessageGetTypeRequestModel.setCmd(ApiInterface.MarketMessageGetType);
        marketMessageGetTypeRequestModel.setToken(BaseApplication.getToken());
        return marketMessageGetTypeRequestModel;
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (!TextUtils.isEmpty(BaseApplication.getToken()))
            subscription = HttpMethod.getInstance().marketMessageGetType(mMarketMessageGetTypeResponseModelObserver, setMessageParams());
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_sys:
                if (mMarketMessageGetTypeResponseModel == null)
                    return;
                for (MarketMessageGetTypeResponseModel.DataEntity dataEntity : mMarketMessageGetTypeResponseModel.getData()) {
                    switch (dataEntity.getModual()) {
                        case "system":
                            SystemMessageActivity.newIntent(this, dataEntity.getId());
                            break;
                    }
                }
                break;
            case R.id.rl_store:
                if (mMarketMessageGetTypeResponseModel == null)
                    return;
                for (MarketMessageGetTypeResponseModel.DataEntity dataEntity : mMarketMessageGetTypeResponseModel.getData()) {
                    switch (dataEntity.getModual()) {
                        case "product":
                            StoreMessageActivity.newIntent(this, dataEntity.getId());
                            break;
                    }
                }
                break;
            case R.id.rl_order:
                if (mMarketMessageGetTypeResponseModel == null)
                    return;
                for (MarketMessageGetTypeResponseModel.DataEntity dataEntity : mMarketMessageGetTypeResponseModel.getData()) {
                    switch (dataEntity.getModual()) {
                        case "order":
                            OrderMessageActivity.newIntent(this, dataEntity.getId());
                            break;
                    }
                }
                break;
            case R.id.rl_chat:
                if (mConversationUnreadChangeListener != null && mConversationService != null)
                    IMConversationActivity.newIntent(this);
                break;
        }
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return null;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home_message;
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onLoadMore() {

    }

    @Override
    public void onRefresh() {

    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, HomeMessageActivity.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
        context.startActivity(intent);
    }
}
