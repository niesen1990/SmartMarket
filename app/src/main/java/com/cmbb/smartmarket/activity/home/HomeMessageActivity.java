package com.cmbb.smartmarket.activity.home;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.mobileim.conversation.IYWConversationService;
import com.alibaba.mobileim.conversation.IYWConversationUnreadChangeListener;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetTypeRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageGetTypeResponseModel;
import com.cmbb.smartmarket.activity.message.IMConversationActivity;
import com.cmbb.smartmarket.activity.message.OrderMessageActivity;
import com.cmbb.smartmarket.activity.message.StoreMessageActivity;
import com.cmbb.smartmarket.activity.message.SystemMessageActivity;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
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

    private IYWConversationUnreadChangeListener mConversationUnreadChangeListener;
    private IYWConversationService mConversationService;
    private Handler mHandler = new Handler(Looper.getMainLooper());

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
            if (marketMessageGetTypeResponseModel != null && marketMessageGetTypeResponseModel.getData().size() == 3) {
                tvMessageSysCount.setText(marketMessageGetTypeResponseModel.getData().get(0).getNoticeCount());
                tvSysContent.setText(marketMessageGetTypeResponseModel.getData().get(0).getNoticeContent());

                tvMessageStoreCount.setText(marketMessageGetTypeResponseModel.getData().get(1).getNoticeCount());
                tvStoreContent.setText(marketMessageGetTypeResponseModel.getData().get(1).getNoticeContent());

                tvMessageOrderCount.setText(marketMessageGetTypeResponseModel.getData().get(2).getNoticeCount());
                tvOrderContent.setText(marketMessageGetTypeResponseModel.getData().get(2).getNoticeContent());
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
        initListener();
        subscription = HttpMethod.getInstance().marketMessageGetType(mMarketMessageGetTypeResponseModelObserver, setMessageParams());
    }

    private MarketMessageGetTypeRequestModel setMessageParams() {
        MarketMessageGetTypeRequestModel marketMessageGetTypeRequestModel = new MarketMessageGetTypeRequestModel();
        marketMessageGetTypeRequestModel.setCmd(ApiInterface.MarketMessageGetType);
        marketMessageGetTypeRequestModel.setToken(BaseApplication.getToken());
        return marketMessageGetTypeRequestModel;
    }

    private void initListener() {
        mConversationService = IMHelper.getInstance().getIMKit().getConversationService();
        //初始化并添加会话变更监听
        mConversationUnreadChangeListener = new IYWConversationUnreadChangeListener() {

            //当未读数发生变化时会回调该方法，开发者可以在该方法中更新未读数
            @Override
            public void onUnreadChange() {
                mHandler.post(new Runnable() {
                    @Override
                    public void run() {
                        //获取当前登录用户的所有未读数
                        int unReadCount = mConversationService.getAllUnreadCount();
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
                });
            }
        };
    }

    @Override
    protected void onResume() {
        super.onResume();
        //resume时需要检查全局未读消息数并做处理，因为离开此界面时删除了全局消息监听器
        mConversationUnreadChangeListener.onUnreadChange();
        //在Tab栏增加会话未读消息变化的全局监听器
        mConversationService.addTotalUnreadChangeListener(mConversationUnreadChangeListener);
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在Tab栏删除会话未读消息变化的全局监听器
        mConversationService.removeTotalUnreadChangeListener(mConversationUnreadChangeListener);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_sys:
                SystemMessageActivity.newIntent(this);
                break;
            case R.id.rl_store:
                StoreMessageActivity.newIntent(this);
                break;
            case R.id.rl_order:
                OrderMessageActivity.newIntent(this);
                break;
            case R.id.rl_chat:
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
