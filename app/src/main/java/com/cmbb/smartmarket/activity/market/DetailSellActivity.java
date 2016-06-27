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
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.DetailReplayAdapter;
import com.cmbb.smartmarket.activity.market.adapter.DetailSellAdapter;
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
import com.cmbb.smartmarket.network.model.ProductImageList;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.cmbb.smartmarket.utils.KeyboardUtil;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;
import com.umeng.socialize.UMShareAPI;

import java.util.List;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/23 下午4:46
 * 修改人：N.Sun
 * 修改时间：16/6/23 下午4:46
 * 修改备注：
 */
public class DetailSellActivity extends BaseRecyclerActivity {
    private static final String TAG = DetailSellActivity.class.getSimpleName();
    RecyclerArrayAdapter.ItemView headItemView;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_contact)
    TextView tvContact;
    @BindView(R.id.bottom)
    LinearLayout bottom;
    BottomSheetBehavior behaviorBottom;

    @BindView(R.id.tv_send_content)
    EditText tvSendContent;
    @BindView(R.id.tv_send)
    TextView tvSend;
    @BindView(R.id.tv_message)
    TextView tvMessage;
    @BindView(R.id.iv_collection)
    TextView ivCollection;
    @BindView(R.id.tv_share)
    TextView tvShare;
    @BindView(R.id.tv_buy)
    TextView tvBuy;

    //HeadView
    private TextView tvTag;
    private TextView tvTitle;
    private TextView tvWatchCount;
    private TextView tvRealPrice;
    private TextView tvOldPrice;
    private TextView tvFreight;
    private TextView tvIntroduce;
    private TextView tvTime;
    private TextView tvAddress;
    ProductDetailResponseModel mProductDetailResponseModel;
    int isCollection;
    int replayId;
    String imUserId;
    Observer<Object> mObjectObserver = new Observer<Object>() {

        @Override
        public void onCompleted() {
        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(Object o) {
            if (o instanceof ProductDetailResponseModel) {
                mProductDetailResponseModel = (ProductDetailResponseModel) o;
                isCollection = mProductDetailResponseModel.getData().getIsCollect();
                if (mProductDetailResponseModel.getData().getPublicUser().getImUserId() != null)
                    imUserId = mProductDetailResponseModel.getData().getPublicUser().getImUserId();
                // 更新用户数据
                ImageLoader.loadUrlAndDiskCache(DetailSellActivity.this, ((ProductDetailResponseModel) o).getData().getPublicUser().getUserImg(), ivHead, new CircleTransform(DetailSellActivity.this));
                tvNick.setText(((ProductDetailResponseModel) o).getData().getPublicUser().getNickName());
                //UI 装载数据
                if (((ProductDetailResponseModel) o).getData().getIsRecommoned() == 1) {
                    tvTag.setVisibility(View.VISIBLE);
                } else {
                    tvTag.setVisibility(View.GONE);
                }
                tvTitle.setText(((ProductDetailResponseModel) o).getData().getTitle());
                tvWatchCount.setText(((ProductDetailResponseModel) o).getData().getBrowseNumber() + "");
                tvRealPrice.setText("￥" + ((ProductDetailResponseModel) o).getData().getCurrentPrice());
                if (((ProductDetailResponseModel) o).getData().getOriginalPrice() == 0) {
                    tvOldPrice.setVisibility(View.INVISIBLE);
                } else {
                    tvOldPrice.setVisibility(View.VISIBLE);
                    tvOldPrice.setText("￥" + ((ProductDetailResponseModel) o).getData().getOriginalPrice());
                }
                tvFreight.setText("运费：" + ((ProductDetailResponseModel) o).getData().getFreight());
                tvIntroduce.setText(((ProductDetailResponseModel) o).getData().getContent());
                tvTime.setText(new JTimeTransform(((ProductDetailResponseModel) o).getData().getPublicDate()).toString(new RecentDateFormat()));
                if (((ProductDetailResponseModel) o).getData().getUserLocation() != null)
                    tvAddress.setText(((ProductDetailResponseModel) o).getData().getUserLocation().getCity() + " | " + ((ProductDetailResponseModel) o).getData().getUserLocation().getDistrict());

                if (mProductDetailResponseModel.getData().getProductStatus() == 0) {
                    tvBuy.setText("我要买");
                } else {
                    tvBuy.setText(mProductDetailResponseModel.getData().getProductStatusText());
                    tvBuy.setOnClickListener(null);
                    tvBuy.setBackgroundResource(R.color.dimgray);
                }

                //设置Collection
                switch (mProductDetailResponseModel.getData().getIsCollect()) {
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
                tvMessage.setText(mProductDetailResponseModel.getData().getReplyNumber() + "");
                // adapter装载数据
                detailProductImageLists = ((ProductDetailResponseModel) o).getData().getProductImageList();
                adapter.addAll(((ProductDetailResponseModel) o).getData().getProductImageList());
            } else if (o instanceof ProductReplyListResponseModel) {
                adapter.addAll(((ProductReplyListResponseModel) o).getData().getContent());
            }
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
                if (pager == 0) {
                    adapter.clear();
                    adapter.addAll(detailProductImageLists);
                }
                if (productReplyListResponseModel.getData() == null || productReplyListResponseModel.getData().getContent() == null || productReplyListResponseModel.getData().getContent().size() == 0) {
                    adapter.stopMore();
                } else {
                    adapter.addAll(productReplyListResponseModel.getData().getContent());
                }
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
            tvSendContent.setText("");
            KeyboardUtil.hideKeyboard(DetailSellActivity.this);
            onRefresh();
        }
    };

    List<ProductImageList> detailProductImageLists;

    @Override
    protected void initView(Bundle savedInstanceState) {
        setTitle("宝贝详情");
        ivHead.setOnClickListener(this);
        tvContact.setOnClickListener(this);
        tvSend.setOnClickListener(this);
        tvMessage.setOnClickListener(this);
        ivCollection.setOnClickListener(this);
        tvShare.setOnClickListener(this);
        tvBuy.setOnClickListener(this);
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
                LinearLayout header = (LinearLayout) LayoutInflater.from(DetailSellActivity.this).inflate(R.layout.activity_detail_sell_head01, null);
                header.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
                tvTag = (TextView) header.findViewById(R.id.tv_tag);
                tvTitle = (TextView) header.findViewById(R.id.tv_title);
                tvWatchCount = (TextView) header.findViewById(R.id.tv_watch_count);
                tvRealPrice = (TextView) header.findViewById(R.id.tv_real_price);
                tvOldPrice = (TextView) header.findViewById(R.id.tv_old_price);
                tvFreight = (TextView) header.findViewById(R.id.tv_freight);
                tvIntroduce = (TextView) header.findViewById(R.id.tv_introduce);
                tvTime = (TextView) header.findViewById(R.id.tv_time);
                tvAddress = (TextView) header.findViewById(R.id.tv_address);
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
                if (adapter.getItem(position) instanceof ProductReplyListResponseModel.DataEntity.ContentEntity) {
                    if (((ProductReplyListResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getCreateUser().getId() == BaseApplication.getUserId()) {
                        DialogUtils.createAlertDialog(DetailSellActivity.this, "操作", "您确定要删除回复吗", true, new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                subscription = HttpMethod.getInstance().requestProductDeleteReply(mProductDeleteReplyResponseModelObserver, setDeleteReplay(position));
                            }
                        });
                    }
                }
                return true;
            }
        });
        //详情和第一组回复
        subscription = HttpMethod.getInstance().requestProductDetailMergeReplay(mObjectObserver, setDetailParams(), setReplayListParams());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_sell_detail, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_report:
                if (mProductDetailResponseModel != null)
                    ReportActivity.newIntent(this, mProductDetailResponseModel.getData().getId());
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        if (mProductDetailResponseModel == null)
            return;
        switch (v.getId()) {
            case R.id.iv_head:
                UserCenterActivity.newIntent(this, mProductDetailResponseModel.getData().getPublicUser().getId());
                break;
            case R.id.tv_share:
                if (mProductDetailResponseModel.getData().getProductImageList() != null && mProductDetailResponseModel.getData().getProductImageList().size() > 0) {
                    SocialUtils.share(this, mProductDetailResponseModel.getData().getProductImageList().get(0).getLocation(), mProductDetailResponseModel.getData().getTitle(), mProductDetailResponseModel.getData().getContent(), ApiInterface.SHARE_PUBLISH + getIntent().getIntExtra("id", -1));
                } else {
                    SocialUtils.share(this, R.mipmap.ic_good_bac, mProductDetailResponseModel.getData().getTitle(), mProductDetailResponseModel.getData().getContent(), ApiInterface.SHARE_PUBLISH + getIntent().getIntExtra("id", -1));
                }
                break;
            case R.id.tv_message:
                replayId = mProductDetailResponseModel.getData().getPublicUser().getId();
                tvSendContent.setHint("回复@" + mProductDetailResponseModel.getData().getPublicUser().getNickName());
                tvSendContent.setFocusable(true);
                tvSendContent.setFocusableInTouchMode(true);
                tvSendContent.requestFocus();
                KeyboardUtil.showKeyboard(this);
                break;
            case R.id.iv_collection:
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
                BuyOrderActivity.newIntent(this, getIntent().getIntExtra("id", -1));
                break;
            case R.id.tv_send:
                if (TextUtils.isEmpty(tvSendContent.getText().toString())) {
                    showToast("请输入回复内容");
                    return;
                }
                showWaitingDialog();
                subscription = HttpMethod.getInstance().requestProductReplay(mProductReplayResponseModelObserver, setReplayParams());
                break;
            case R.id.tv_contact:
                if (!TextUtils.isEmpty(imUserId) && IMHelper.getInstance().getIMKit() != null) {
                    Intent intent = IMHelper.getInstance().getIMKit().getChattingActivityIntent(imUserId, IMHelper.getAppKey());
                    startActivity(intent);
                } else {
                    showToast("请登录");
                }
                break;
        }
    }

    @Override
    protected RecyclerArrayAdapter initAdapter() {
        return new DetailSellAdapter(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_detail_sell_layout;
    }

    @Override
    public void onItemClick(View view, int position) {
        if (adapter.getItem(position) instanceof ProductReplyListResponseModel.DataEntity.ContentEntity) {
            replayId = ((ProductReplyListResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getCreateUser().getId();
            tvSendContent.setHint("回复@" + ((ProductReplyListResponseModel.DataEntity.ContentEntity) adapter.getItem(position)).getCreateUser().getNickName());
            tvSendContent.setFocusable(true);
            tvSendContent.setFocusableInTouchMode(true);
            tvSendContent.requestFocus();
            KeyboardUtil.showKeyboard(this);
        }
    }

    @Override
    public void onLoadMore() {
        pager++;
        subscription = HttpMethod.getInstance().productReplyListRequest(mProductReplyListResponseModelObserver, setReplayListParams());
    }

    @Override
    public void onRefresh() {
        pager = 0;
        subscription = HttpMethod.getInstance().productReplyListRequest(mProductReplyListResponseModelObserver, setReplayListParams());
    }

    /**
     * 详情设置参数
     *
     * @return ProductDetailRequestModel
     */
    protected ProductDetailRequestModel setDetailParams() {
        ProductDetailRequestModel productDetailRequestModel = new ProductDetailRequestModel();
        productDetailRequestModel.setCmd(ApiInterface.ProductDetails);
        productDetailRequestModel.setToken(BaseApplication.getToken());
        productDetailRequestModel.setParameters(new ProductDetailRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1)));
        return productDetailRequestModel;
    }

    private ProductDeleteReplyRequestModel setDeleteReplay(int position) {
        ProductDeleteReplyRequestModel productDeleteReplyRequestModel = new ProductDeleteReplyRequestModel();
        productDeleteReplyRequestModel.setCmd(ApiInterface.ProductDeleteReply);
        productDeleteReplyRequestModel.setToken(BaseApplication.getToken());
        productDeleteReplyRequestModel.setParameters(new ProductDeleteReplyRequestModel.ParametersEntity(((DetailReplayAdapter) adapter).getItem(position).getId()));
        return productDeleteReplyRequestModel;
    }

    /**
     * 回复列表参数
     *
     * @return ProductReplyListRequestModel
     */
    private ProductReplyListRequestModel setReplayListParams() {
        ProductReplyListRequestModel productReplyListRequestModel = new ProductReplyListRequestModel();
        productReplyListRequestModel.setToken(BaseApplication.getToken());
        productReplyListRequestModel.setCmd(ApiInterface.ProductReplyList);
        productReplyListRequestModel.setParameters(new ProductReplyListRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), 0, pagerSize, pager));
        return productReplyListRequestModel;
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
        productReplayRequestModel.setParameters(new ProductReplayRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), replayId, "", 0, tvSendContent.getText().toString()));
        return productReplayRequestModel;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        UMShareAPI.get(this).onActivityResult(requestCode, resultCode, data);
    }

    /**
     * 无动画启动入口
     *
     * @param context Context
     * @param id      详情ID
     */
    public static void newIntent(Context context, int id) {
        Intent intent = new Intent(context, DetailSellActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }

}
