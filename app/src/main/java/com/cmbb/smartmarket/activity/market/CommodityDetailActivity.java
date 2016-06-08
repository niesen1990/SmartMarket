package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
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
import com.cmbb.smartmarket.activity.market.model.ProductCollectRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductCollectResponseModel;
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
public class CommodityDetailActivity extends BaseRecyclerActivity {
    private static final String TAG = CommodityDetailActivity.class.getSimpleName();
    @BindView(R.id.root)
    MengCoordinatorLayout root;
    @BindView(R.id.roll_view_pager)
    RollPagerView rollViewPager;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.iv_collection)
    TextView ivCollection;
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
    private LinearLayout ll01;
    private TextView tvTag;
    private TextView tvTitle;
    private TextView tvWatchCount;
    private RelativeLayout rl02;
    private TextView tvRealPrice;
    private TextView tvOldPrice;
    private TextView tvFreight;
    private TextView tvIntroduce;
    private TextView tvTime;
    private TextView tvLine01;
    private TextView tvAddress;
    private ImageView ivHead;
    private TextView tvNick;
    private TextView tvContact;
    private TextView tvLine;
    BannerDetailListAdapter mBannerDetailListAdapter;
    RecyclerArrayAdapter.ItemView headItemView;
    int replayId;
    String imUserId;
    int isCollection;
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
                isCollection = productDetailResponseModel.getData().getIsCollect();
                if (productDetailResponseModel.getData().getPublicUser().getImUserId() != null)
                    imUserId = productDetailResponseModel.getData().getPublicUser().getImUserId();
                mBannerDetailListAdapter.updateList(productDetailResponseModel.getData().getProductImageList());
                if (productDetailResponseModel.getData().getIsRecommoned() == 1) {
                    tvTag.setVisibility(View.VISIBLE);
                } else {
                    tvTag.setVisibility(View.GONE);
                }
                tvTitle.setText(productDetailResponseModel.getData().getTitle());
                tvWatchCount.setText(productDetailResponseModel.getData().getBrowseNumber() + "");
                tvRealPrice.setText("￥" + productDetailResponseModel.getData().getCurrentPrice());
                if (productDetailResponseModel.getData().getOriginalPrice() == 0) {
                    tvOldPrice.setVisibility(View.INVISIBLE);
                } else {
                    tvOldPrice.setVisibility(View.VISIBLE);
                    tvOldPrice.setText("￥" + productDetailResponseModel.getData().getOriginalPrice());
                }
                tvFreight.setText("运费：" + productDetailResponseModel.getData().getFreight());
                tvIntroduce.setText(productDetailResponseModel.getData().getContent());
                tvTime.setText(new JTimeTransform(productDetailResponseModel.getData().getPublicDate()).toString(new RecentDateFormat()));
                if (productDetailResponseModel.getData().getUserLocation() != null)
                    tvAddress.setText(productDetailResponseModel.getData().getUserLocation().getCity() + " | " + productDetailResponseModel.getData().getUserLocation().getDistrict());
                ImageLoader.loadUrlAndDiskCache(CommodityDetailActivity.this, productDetailResponseModel.getData().getPublicUser().getUserImg(), ivHead, new CircleTransform(CommodityDetailActivity.this));
                tvNick.setText(productDetailResponseModel.getData().getPublicUser().getNickName());
                if (productDetailResponseModel.getData().getProductStatus() == 0) {
                    tvBuy.setText("我要买");
                } else {
                    tvBuy.setText(productDetailResponseModel.getData().getProductStatusText());
                    tvBuy.setOnClickListener(null);
                    tvBuy.setBackgroundResource(R.color.dimgray);
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
            KeyboardUtil.hideKeyboard(CommodityDetailActivity.this);
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
                RelativeLayout header = (RelativeLayout) LayoutInflater.from(CommodityDetailActivity.this).inflate(R.layout.activity_commodity_detail_head01, null);
                header.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                ll01 = (LinearLayout) header.findViewById(R.id.ll01);
                tvTag = (TextView) header.findViewById(R.id.tv_tag);
                tvTitle = (TextView) header.findViewById(R.id.tv_title);
                tvWatchCount = (TextView) header.findViewById(R.id.tv_watch_count);
                rl02 = (RelativeLayout) header.findViewById(R.id.rl02);
                tvRealPrice = (TextView) header.findViewById(R.id.tv_real_price);
                tvOldPrice = (TextView) header.findViewById(R.id.tv_old_price);
                tvFreight = (TextView) header.findViewById(R.id.tv_freight);
                tvIntroduce = (TextView) header.findViewById(R.id.tv_introduce);
                tvTime = (TextView) header.findViewById(R.id.tv_time);
                tvLine01 = (TextView) header.findViewById(R.id.tv_line01);
                tvAddress = (TextView) header.findViewById(R.id.tv_address);
                ivHead = (ImageView) header.findViewById(R.id.iv_head);
                tvNick = (TextView) header.findViewById(R.id.tv_nick);
                tvContact = (TextView) header.findViewById(R.id.tv_contact);
                tvLine = (TextView) header.findViewById(R.id.tv_line);
                //setOnclick
                tvContact.setOnClickListener(CommodityDetailActivity.this);
                return header;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.findViewById(R.id.iv_head).setOnClickListener(CommodityDetailActivity.this);
            }
        };
        adapter.addHeader(headItemView);
        adapter.setOnItemLongClickListener(new RecyclerArrayAdapter.OnItemLongClickListener() {
            @Override
            public boolean onItemClick(final int position) {
                if (((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getId() == BaseApplication.getUserId()) {
                    DialogUtils.createAlertDialog(CommodityDetailActivity.this, "操作", "您确定要删除回复吗", true, new DialogInterface.OnClickListener() {
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
                ReportActivity.newIntent(this, mProductDetailResponseModel.getData().getId());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.iv_head:
                UserCenterActivity.newIntent(this, mProductDetailResponseModel.getData().getPublicUser().getId());
                break;
            case R.id.tv_share:
                if (mProductDetailResponseModel.getData().getProductImageList() != null & mProductDetailResponseModel.getData().getProductImageList().size() > 0) {
                    SocialUtils.share(this, mProductDetailResponseModel.getData().getProductImageList().get(0).getLocation(), mProductDetailResponseModel.getData().getTitle(), mProductDetailResponseModel.getData().getContent(), ApiInterface.SHARE_PUBLISH + getIntent().getIntExtra("id", -1));
                } else {
                    SocialUtils.share(this, R.mipmap.ic_good_bac, mProductDetailResponseModel.getData().getTitle(), mProductDetailResponseModel.getData().getContent(), ApiInterface.SHARE_PUBLISH + getIntent().getIntExtra("id", -1));
                }
                break;
            case R.id.tv_message:
                // TODO: 16/4/28
                replayId = mProductDetailResponseModel.getData().getPublicUser().getId();
                evSendContent.setHint("回复@" + mProductDetailResponseModel.getData().getPublicUser().getNickName());
                evSendContent.setFocusable(true);
                evSendContent.setFocusableInTouchMode(true);
                evSendContent.requestFocus();
                KeyboardUtil.showKeyboard(this);
                break;
            case R.id.iv_collection:
                // TODO: 16/4/28
                HttpMethod.getInstance().requestProductCollect(new Observer<ProductCollectResponseModel>() {
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
                    public void onNext(ProductCollectResponseModel productCollectResponseModel) {
                        if (productCollectResponseModel == null)
                            return;
                        showToast(productCollectResponseModel.getMsg());
                        isCollection = isCollection == 0 ? 1 : 0;
                        switch (isCollection) {
                            case 0:
                                Drawable drawable0 = getResources().getDrawable(R.drawable.ic_collection_normal);
                                drawable0.setBounds(0, 0, drawable0.getMinimumWidth(), drawable0.getMinimumHeight());
                                ivCollection.setCompoundDrawables(drawable0, null, null, null);
                                break;
                            case 1:
                                Drawable drawable1 = getResources().getDrawable(R.drawable.ic_collected);
                                drawable1.setBounds(0, 0, drawable1.getMinimumWidth(), drawable1.getMinimumHeight());
                                ivCollection.setCompoundDrawables(drawable1, null, null, null);
                                break;
                        }
                    }
                }, setCollectionParams());
                break;
            case R.id.tv_buy:
                // TODO: 16/4/28
                BuyOrderActivity.newIntent(this, getIntent().getIntExtra("id", -1));
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

    private ProductCollectRequestModel setCollectionParams() {
        ProductCollectRequestModel productCollectRequestModel = new ProductCollectRequestModel();
        productCollectRequestModel.setCmd(ApiInterface.ProductCollect);
        productCollectRequestModel.setToken(BaseApplication.getToken());
        productCollectRequestModel.setParameters(new ProductCollectRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), isCollection == 0 ? 1 : 0));
        return productCollectRequestModel;
    }

    private ProductReplayRequestModel setReplayParams() {
        ProductReplayRequestModel productReplayRequestModel = new ProductReplayRequestModel();
        productReplayRequestModel.setToken(BaseApplication.getToken());
        productReplayRequestModel.setCmd(ApiInterface.ProductReply);
        productReplayRequestModel.setParameters(new ProductReplayRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), replayId, "", 0, evSendContent.getText().toString()));
        return productReplayRequestModel;
    }

    @Override
    public void onItemClick(int position) {
        replayId = ((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getId();
        Log.e(TAG, "replayId = " + replayId);
        evSendContent.setHint("回复@" + ((DetailReplayAdapter) adapter).getItem(position).getCreateUser().getNickName());
        evSendContent.setFocusable(true);
        evSendContent.setFocusableInTouchMode(true);
        evSendContent.requestFocus();
        KeyboardUtil.showKeyboard(this);
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
        productReplyListRequestModel.setParameters(new ProductReplyListRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), 0, pagerSize, pager));
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
        Intent intent = new Intent(context, CommodityDetailActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
