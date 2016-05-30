package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.BannerDetailListAdapter;
import com.cmbb.smartmarket.activity.market.adapter.DetailReplayAdapter;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuyResolveRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuyResolveResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDeleteReplyResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplayResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListResponseModel;
import com.cmbb.smartmarket.activity.message.im.IMHelper;
import com.cmbb.smartmarket.activity.user.ReportActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
import com.cmbb.smartmarket.widget.MengCoordinatorLayout;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.jude.rollviewpager.RollPagerView;
import com.umeng.socialize.UMShareAPI;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午4:08
 */
public class NeedDetailActivity extends BaseRecyclerActivity {
    private static final String TAG = NeedDetailActivity.class.getSimpleName();
    @BindView(R.id.root)
    MengCoordinatorLayout root;
    @BindView(R.id.roll_view_pager)
    RollPagerView rollViewPager;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.iv_collection)
    ImageView ivCollection;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_buy)
    TextView tvBuy;
    @BindView(R.id.scroll)
    RelativeLayout scroll;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.tv_send_content)
    EditText evSendContent;
    @BindView(R.id.bottom)
    LinearLayout bottom;
    BottomSheetBehavior behaviorBottom;
    //HeadView
    TextView tvTitle;
    TextView tvWatchCount;
    ImageView ivHead;
    TextView tvNick;
    TextView tvContact;
    TextView tvLine;
    RelativeLayout rl02;
    TextView tvIntroduce;
    TextView tvTime;
    TextView tvAddress;
    BannerDetailListAdapter mBannerDetailListAdapter;
    RecyclerArrayAdapter.ItemView headItemView;
    int userId;
    int replayId;
    String imUserId;
    String userNick;
    Observer<ProductDetailResponseModel> mProductDetailResponseModelObserver = new Observer<ProductDetailResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(ProductDetailResponseModel productDetailResponseModel) {
            if (productDetailResponseModel != null) {
                userId = productDetailResponseModel.getData().getPublicUser().getId();
                if (productDetailResponseModel.getData().getPublicUser().getImUserId() != null)
                    imUserId = productDetailResponseModel.getData().getPublicUser().getImUserId();
                mBannerDetailListAdapter.updateList(productDetailResponseModel.getData().getProductImageList());
                userNick = productDetailResponseModel.getData().getPublicUser().getNickName();
                tvTitle.setText(productDetailResponseModel.getData().getTitle());
                tvWatchCount.setText(productDetailResponseModel.getData().getBrowseNumber() + "");
                tvIntroduce.setText(productDetailResponseModel.getData().getContent());
                tvTime.setText(new JTimeTransform(productDetailResponseModel.getData().getPublicDate()).toString(new RecentDateFormat()));
                tvAddress.setText(productDetailResponseModel.getData().getUserLocation().getCity() + " | " + productDetailResponseModel.getData().getUserLocation().getDistrict());
                ImageLoader.loadUrlAndDiskCache(NeedDetailActivity.this, productDetailResponseModel.getData().getPublicUser().getUserImg(), ivHead, new CircleTransform(NeedDetailActivity.this));
                tvNick.setText(productDetailResponseModel.getData().getPublicUser().getNickName());
                if (productDetailResponseModel.getData().getPublicUser().getId() == BaseApplication.getUserId()) {
                    tvBuy.setText("确认解决");
                } else {
                    tvBuy.setText("推荐给TA");
                }
                tvMessage.setText(productDetailResponseModel.getData().getBrowseNumber() + "");
                onRefresh();
            }
        }
    };

    Observer<ProductReplyListResponseModel> mProductReplyListResponseModelObserver = new Observer<ProductReplyListResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(ProductReplyListResponseModel productReplyListResponseModel) {
            if (productReplyListResponseModel != null) {
                if (pager == 0)
                    adapter.clear();
                adapter.addAll(productReplyListResponseModel.getData().getContent());
            }
        }
    };

    Observer<ProductReplayResponseModel> mProductReplayResponseModelObserver = new Observer<ProductReplayResponseModel>() {
        @Override
        public void onCompleted() {
            onRefresh();
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(ProductReplayResponseModel productReplayResponseModel) {
            hideWaitingDialog();
            showToast(productReplayResponseModel.getMsg());
            evSendContent.setText("");
            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(NeedDetailActivity.this.getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        }
    };

    //删除回复
    Observer<ProductDeleteReplyResponseModel> mProductDeleteReplyResponseModelObserver = new Observer<ProductDeleteReplyResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(ProductDeleteReplyResponseModel productDeleteReplyResponseModel) {
            hideWaitingDialog();
            if (productDeleteReplyResponseModel != null) {
                showToast(productDeleteReplyResponseModel.getMsg());
            }
        }
    };

    protected void init() {
        rollViewPager = (RollPagerView) findViewById(R.id.roll_view_pager);
        mBannerDetailListAdapter = new BannerDetailListAdapter();
        rollViewPager.setAdapter(mBannerDetailListAdapter);
        tvMessage.setOnClickListener(this);
        ivCollection.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tvBuy.setOnClickListener(this);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        init();
        tvSend.setOnClickListener(this);
        behaviorBottom = BottomSheetBehavior.from(bottom);
        behaviorBottom.setState(BottomSheetBehavior.STATE_EXPANDED);
        behaviorBottom.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                if (newState == BottomSheetBehavior.STATE_DRAGGING) {
                    behaviorBottom.setState(BottomSheetBehavior.STATE_EXPANDED);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {

            }
        });
        headItemView = new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                LinearLayout header = (LinearLayout) LayoutInflater.from(NeedDetailActivity.this).inflate(R.layout.activity_need_detail_head01, null);
                header.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tvTitle = (TextView) header.findViewById(R.id.tv_title);
                tvWatchCount = (TextView) header.findViewById(R.id.tv_watch_count);
                rl02 = (RelativeLayout) header.findViewById(R.id.rl02);
                tvIntroduce = (TextView) header.findViewById(R.id.tv_introduce);
                tvTime = (TextView) header.findViewById(R.id.tv_time);
                tvAddress = (TextView) header.findViewById(R.id.tv_address);
                ivHead = (ImageView) header.findViewById(R.id.iv_head);
                tvNick = (TextView) header.findViewById(R.id.tv_nick);
                tvContact = (TextView) header.findViewById(R.id.tv_contact);
                tvLine = (TextView) header.findViewById(R.id.tv_line);
                //setOnclick
                tvContact.setOnClickListener(NeedDetailActivity.this);
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        };
        adapter.addHeader(headItemView);
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemClick(final int position) {
                if (((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getId() == BaseApplication.getUserId()) {
                    DialogUtils.createAlertDialog(NeedDetailActivity.this, "操作", "您确定要删除回复吗", true, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            subscription = HttpMethod.getInstance().requestProductDeleteReply(mProductDeleteReplyResponseModelObserver, setDeleteReplay(position));
                        }
                    });
                }
                return true;
            }
        });
        subscription = HttpMethod.getInstance().requestProductDetail(mProductDetailResponseModelObserver, setParams());

    }

    private ProductDeleteReplyRequestModel setDeleteReplay(int position) {
        ProductDeleteReplyRequestModel productDeleteReplyRequestModel = new ProductDeleteReplyRequestModel();
        productDeleteReplyRequestModel.setCmd(ApiInterface.ProductDeleteReply);
        productDeleteReplyRequestModel.setToken(BaseApplication.getToken());
        productDeleteReplyRequestModel.setParameters(new ProductDeleteReplyRequestModel.ParametersEntity(((DetailReplayAdapter) adapter).getItem(position).getId()));
        return productDeleteReplyRequestModel;
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new DetailReplayAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_commodity_detail_layout;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_commodity_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_report:
                ReportActivity.newIntent(this);
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_share:
                SocialUtils.share(this, "http://smart.image.alimmdn.com/system/image/2016-04-18/file_50647_NTFjM2VmMjMtOTNiNC00MTI2LWJhMWMtOWFlZDc2MTg2MDU4", "魅族手机PRO6", "MEIZU design and make", "http://www.baidu.com");
                break;
            case R.id.tv_message:
                // TODO: 16/4/28
                replayId = userId;
                evSendContent.setHint("回复@" + userNick);
                evSendContent.setFocusable(true);
                evSendContent.setFocusableInTouchMode(true);
                evSendContent.requestFocus();
                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
                break;
            case R.id.iv_collection:
                // TODO: 16/4/28  
                break;
            case R.id.tv_buy:
                if (userId == BaseApplication.getUserId()) {
                    // TODO: 16/5/26 确认解决
                    DialogUtils.createAlertDialog(this, "警告", "确认解决？", true, new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            showWaitingDialog();
                            subscription = HttpMethod.getInstance().productAskToBuyResolve(new Observer<ProductAskToBuyResolveResponseModel>() {
                                @Override
                                public void onCompleted() {
                                    hideWaitingDialog();
                                }

                                @Override
                                public void onError(Throwable e) {
                                    hideWaitingDialog();
                                    Log.e(TAG, e.toString());
                                }

                                @Override
                                public void onNext(ProductAskToBuyResolveResponseModel productAskToBuyResolveResponseModel) {
                                    if (productAskToBuyResolveResponseModel == null)
                                        return;
                                    showToast(productAskToBuyResolveResponseModel.getMsg());
                                    finish();
                                }
                            }, setAskResolveParams(getIntent().getIntExtra("id", -1)));
                        }
                    });

                } else {
                    RecommendListActivity.newIntent(this, getIntent().getIntExtra("id", -1), userId);
                }
                break;
            case R.id.tv_send:
                if (TextUtils.isEmpty(evSendContent.getText().toString())) {
                    showToast("请输入回复内容");
                    return;
                }
                showWaitingDialog();
                subscription = HttpMethod.getInstance().requestProductReplay(mProductReplayResponseModelObserver, setReplayParams());
                break;
            case R.id.tv_contact:
                if (!TextUtils.isEmpty(imUserId)) {
                    Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(imUserId, IMHelper.getAppKey());
                    startActivity(intent);
                } else {
                    Log.e(TAG, "IM ID 为空");
                }
                break;
        }
    }

    private ProductAskToBuyResolveRequestModel setAskResolveParams(int productId) {
        ProductAskToBuyResolveRequestModel productAskToBuyResolveRequestModel = new ProductAskToBuyResolveRequestModel();
        productAskToBuyResolveRequestModel.setCmd(ApiInterface.ProductAskToBuyResolve);
        productAskToBuyResolveRequestModel.setToken(BaseApplication.getToken());
        productAskToBuyResolveRequestModel.setParameters(new ProductAskToBuyResolveRequestModel.ParametersEntity(productId));
        return productAskToBuyResolveRequestModel;
    }

    private ProductReplayRequestModel setReplayParams() {
        ProductReplayRequestModel productReplayRequestModel = new ProductReplayRequestModel();
        productReplayRequestModel.setToken(BaseApplication.getToken());
        productReplayRequestModel.setCmd(ApiInterface.ProductReply);
        productReplayRequestModel.setParameters(new ProductReplayRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), replayId, "", 1, evSendContent.getText().toString()));
        return productReplayRequestModel;
    }

    @Override
    public void onItemClick(int position) {
        if (((DetailReplayAdapter) adapter).getItem(position).getIsRecommoned() == 1 || ((DetailReplayAdapter) adapter).getItem(position).getResolveProductId() != -1) {
            CommodityDetailActivity.newIntent(this, ((DetailReplayAdapter) adapter).getItem(position).getResolveProductId());
        } else if (userId == BaseApplication.getUserId()) {
            replayId = ((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getId();
            Log.e(TAG, "replayId = " + replayId);
            evSendContent.setHint("回复@" + ((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getNickName());
            evSendContent.setFocusable(true);
            evSendContent.setFocusableInTouchMode(true);
            evSendContent.requestFocus();
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.toggleSoftInput(0, InputMethodManager.SHOW_FORCED);
        }
    }

    @Override
    public void onLoadMore() {
        pager++;
        HttpMethod.getInstance().productReplyListRequest(mProductReplyListResponseModelObserver, setReplayListParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        HttpMethod.getInstance().productReplyListRequest(mProductReplyListResponseModelObserver, setReplayListParams());
    }

    private ProductReplyListRequestModel setReplayListParams() {
        ProductReplyListRequestModel productReplyListRequestModel = new ProductReplyListRequestModel();
        productReplyListRequestModel.setToken(BaseApplication.getToken());
        productReplyListRequestModel.setCmd(ApiInterface.ProductReplyList);
        productReplyListRequestModel.setParameters(new ProductReplyListRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), 1, pagerSize, pager));
        return productReplyListRequestModel;
    }

    /**
     * 设置参数
     *
     * @return params
     */
    protected ProductDetailRequestModel setParams() {
        ProductDetailRequestModel productDetailRequestModel = new ProductDetailRequestModel();
        productDetailRequestModel.setCmd(ApiInterface.ProductDetails);
        productDetailRequestModel.setToken(BaseApplication.getToken());
        productDetailRequestModel.setParameters(new ProductDetailRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1)));
        return productDetailRequestModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    public static void newIntent(Context context, int id) {
        Intent intent = new Intent(context, NeedDetailActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
