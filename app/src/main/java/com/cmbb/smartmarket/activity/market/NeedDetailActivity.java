package com.cmbb.smartmarket.activity.market;

import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.util.Pair;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
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
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductAskToBuySpotResponseModel;
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
import com.cmbb.smartmarket.activity.user.UserCenterActivity;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.cmbb.smartmarket.utils.KeyboardUtil;
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
    @BindView(R.id.iv_spot)
    TextView ivSpot;
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
    @BindView(R.id.collapsing_toolbar)
    CollapsingToolbarLayout collapsingToolbar;
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
    int replayId;
    String imUserId;
    int isSpot;
    ProductDetailResponseModel mProductDetailResponseModel;
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
                mProductDetailResponseModel = productDetailResponseModel;
                if (productDetailResponseModel.getData().getPublicUser().getImUserId() != null)
                    imUserId = productDetailResponseModel.getData().getPublicUser().getImUserId();
                if (productDetailResponseModel.getData().getProductImageList() != null && productDetailResponseModel.getData().getProductImageList().size() > 0) {
                    mBannerDetailListAdapter.updateList(productDetailResponseModel.getData().getProductImageList());
                } else {
                    collapsingToolbar.setBackgroundResource(R.mipmap.ic_good_bac);
                }
                isSpot = productDetailResponseModel.getData().getIsSpot();
                tvTitle.setText(productDetailResponseModel.getData().getTitle());
                tvWatchCount.setText(productDetailResponseModel.getData().getBrowseNumber() + "");
                tvIntroduce.setText(productDetailResponseModel.getData().getContent());
                tvTime.setText(new JTimeTransform(productDetailResponseModel.getData().getPublicDate()).toString(new RecentDateFormat()));
                if (productDetailResponseModel.getData().getUserLocation() != null)
                    tvAddress.setText(productDetailResponseModel.getData().getUserLocation().getCity() + " | " + productDetailResponseModel.getData().getUserLocation().getDistrict());
                ImageLoader.loadUrlAndDiskCache(NeedDetailActivity.this, productDetailResponseModel.getData().getPublicUser().getUserImg(), ivHead, new CircleTransform(NeedDetailActivity.this));
                tvNick.setText(productDetailResponseModel.getData().getPublicUser().getNickName());
                if (productDetailResponseModel.getData().getProductStatus() == 0) {
                    if (productDetailResponseModel.getData().getPublicUser().getId() == BaseApplication.getUserId() && productDetailResponseModel.getData().getIsResolve() == 0) {
                        tvBuy.setText("确认解决");
                        tvBuy.setOnClickListener(NeedDetailActivity.this);
                    } else if (productDetailResponseModel.getData().getIsResolve() == 1) {
                        tvBuy.setText("已解决");
                        tvBuy.setBackgroundResource(R.color.dimgray);
                        tvBuy.setOnClickListener(null);
                    } else {
                        tvBuy.setText("推荐给TA");
                        tvBuy.setOnClickListener(NeedDetailActivity.this);
                    }
                } else {
                    tvBuy.setText(productDetailResponseModel.getData().getProductStatusText());
                    tvBuy.setOnClickListener(null);
                    tvBuy.setBackgroundResource(R.color.dimgray);
                }

                //设置Collection
                switch (productDetailResponseModel.getData().getIsSpot()) {
                    case 0:
                        Drawable drawable0 = getResources().getDrawable(R.drawable.ic_great_gray);
                        drawable0.setBounds(0, 0, drawable0.getMinimumWidth(), drawable0.getMinimumHeight());
                        ivSpot.setCompoundDrawables(drawable0, null, null, null);
                        break;
                    case 1:
                        Drawable drawable1 = getResources().getDrawable(R.drawable.ic_great_color);
                        drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                        ivSpot.setCompoundDrawables(drawable1, null, null, null);
                        break;
                }

                tvMessage.setText(productDetailResponseModel.getData().getReplyNumber() + "");
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
            KeyboardUtil.hideKeyboard(NeedDetailActivity.this);
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
        ivSpot.setOnClickListener(this);
        tvShare.setOnClickListener(this);

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
                headerView.findViewById(R.id.iv_head).setOnClickListener(NeedDetailActivity.this);
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
        return R.layout.activity_need_detail_layout;
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
                ReportActivity.newIntent(this, mProductDetailResponseModel.getData().getId());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_head:
                UserCenterActivity.newIntent(this, mProductDetailResponseModel.getData().getPublicUser().getId());
                break;
            case R.id.tv_share:
                if (mProductDetailResponseModel.getData().getProductImageList() != null & mProductDetailResponseModel.getData().getProductImageList().size() > 0) {
                    SocialUtils.share(this, mProductDetailResponseModel.getData().getProductImageList().get(0).getLocation(), mProductDetailResponseModel.getData().getTitle(), mProductDetailResponseModel.getData().getContent(), ApiInterface.SHARE_NEED + getIntent().getIntExtra("id", -1));
                } else {
                    SocialUtils.share(this, R.mipmap.ic_good_bac, mProductDetailResponseModel.getData().getTitle(), mProductDetailResponseModel.getData().getContent(), ApiInterface.SHARE_NEED + getIntent().getIntExtra("id", -1));
                }
                break;
            case R.id.tv_message:
                Log.e(TAG, "tv_message");
                replayId = mProductDetailResponseModel.getData().getPublicUser().getId();
                evSendContent.setHint("回复@" + mProductDetailResponseModel.getData().getPublicUser().getNickName());
                evSendContent.setFocusable(true);
                evSendContent.setFocusableInTouchMode(true);
                evSendContent.requestFocus();
                KeyboardUtil.showKeyboard(this);
                break;
            case R.id.iv_spot:
                HttpMethod.getInstance().requestProductAskToBuySpot(new Observer<ProductAskToBuySpotResponseModel>() {
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
                    public void onNext(ProductAskToBuySpotResponseModel productAskToBuySpotResponseModel) {
                        if (productAskToBuySpotResponseModel == null)
                            return;
                        showToast(productAskToBuySpotResponseModel.getMsg());
                        isSpot = isSpot == 0 ? 1 : 0;
                        switch (isSpot) {
                            case 0:
                                Drawable drawable0 = getResources().getDrawable(R.drawable.ic_great_gray);
                                drawable0.setBounds(0, 0, drawable0.getMinimumWidth(), drawable0.getMinimumHeight());
                                ivSpot.setCompoundDrawables(drawable0, null, null, null);
                                break;
                            case 1:
                                Drawable drawable1 = getResources().getDrawable(R.drawable.ic_great_color);
                                drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                                ivSpot.setCompoundDrawables(drawable1, null, null, null);
                                break;
                        }
                    }
                }, setSpotParams());
                break;
            case R.id.tv_buy:
                Log.e(TAG, "tv_buy");
                if (mProductDetailResponseModel.getData().getPublicUser().getId() == BaseApplication.getUserId()) {
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
                    RecommendListActivity.newIntent(this, getIntent().getIntExtra("id", -1), mProductDetailResponseModel.getData().getPublicUser().getId());
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

    private ProductAskToBuySpotRequestModel setSpotParams() {
        ProductAskToBuySpotRequestModel productAskToBuySpotRequestModel = new ProductAskToBuySpotRequestModel();
        productAskToBuySpotRequestModel.setCmd(ApiInterface.ProductAskToBuySpot);
        productAskToBuySpotRequestModel.setToken(BaseApplication.getToken());
        productAskToBuySpotRequestModel.setParameters(new ProductAskToBuySpotRequestModel.ParametersEntity(isSpot == 0 ? 1 : 0, getIntent().getIntExtra("id", -1)));
        return productAskToBuySpotRequestModel;
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
    public void onItemClick(View rootView, int position) {
        if (((DetailReplayAdapter) adapter).getItem(position).getIsRecommoned() == 1 || ((DetailReplayAdapter) adapter).getItem(position).getResolveProductId() != -1) {
            ActivityOptionsCompat activityOptionsCompat = ActivityOptionsCompat.makeSceneTransitionAnimation(this, Pair.create(rootView.findViewById(R.id.iv_good), "iv01"));
            CommodityDetailActivity.newIntent(this, activityOptionsCompat, ((DetailReplayAdapter) adapter).getItem(position).getResolveProductId());
        } else if (mProductDetailResponseModel.getData().getPublicUser().getId() == BaseApplication.getUserId()) {
            replayId = ((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getId();
            Log.e(TAG, "replayId = " + replayId);
            evSendContent.setHint("回复@" + ((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getNickName());
            evSendContent.setFocusable(true);
            evSendContent.setFocusableInTouchMode(true);
            evSendContent.requestFocus();
            KeyboardUtil.showKeyboard(this);
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

    public static void newIntent(BaseActivity context, ActivityOptionsCompat activityOptionsCompat, int id) {
        Intent intent = new Intent(context, NeedDetailActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent, activityOptionsCompat.toBundle());
    }

    public static void newIntent(Application context, int id) {
        Intent intent = new Intent(context, NeedDetailActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
