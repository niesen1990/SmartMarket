package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.BannerDetailListAdapter;
import com.cmbb.smartmarket.activity.market.adapter.DetailReplayAdapter;
import com.cmbb.smartmarket.activity.market.model.ProductDetailRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductDetailResponseModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListRequestModel;
import com.cmbb.smartmarket.activity.market.model.ProductReplyListResponseModel;
import com.cmbb.smartmarket.activity.user.ReportActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SocialUtils;
import com.cmbb.smartmarket.utils.date.JTimeTransform;
import com.cmbb.smartmarket.utils.date.RecentDateFormat;
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
                mBannerDetailListAdapter.updateList(productDetailResponseModel.getData().getProductImageList());
                tvTitle.setText(productDetailResponseModel.getData().getTitle());
                tvWatchCount.setText(productDetailResponseModel.getData().getBrowseNumber() + "");
                tvRealPrice.setText("￥" + productDetailResponseModel.getData().getCurrentPrice());
                tvOldPrice.setText("￥" + productDetailResponseModel.getData().getOriginalPrice());
                tvFreight.setText("运费：" + productDetailResponseModel.getData().getFreight());
                tvIntroduce.setText(productDetailResponseModel.getData().getIntroduce());
                tvTime.setText(new JTimeTransform(productDetailResponseModel.getData().getPublicDate()).toString(new RecentDateFormat()));
                tvAddress.setText(productDetailResponseModel.getData().getAddress());
                ImageLoader.loadUrlAndDiskCache(CommodityDetailActivity.this, productDetailResponseModel.getData().getPublicUser().getUserImg(), ivHead, new CircleTransform(CommodityDetailActivity.this));
                tvNick.setText(productDetailResponseModel.getData().getPublicUser().getNickName());

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
                return header;
            }

            @Override
            public void onBindView(View headerView) {

            }
        };
        adapter.addHeader(headItemView);
        subscription = HttpMethod.getInstance().requestProductDetail(mProductDetailResponseModelObserver, setParams());
        onRefresh();
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
                break;
            case R.id.iv_collection:
                // TODO: 16/4/28  
                break;
            case R.id.tv_buy:
                // TODO: 16/4/28
                BuyOrderActivity.newIntent(this, 12);
                break;
        }
    }

    @Override
    public void onItemClick(int position) {

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

    private ProductReplyListRequestModel setReplayListParams() {
        ProductReplyListRequestModel productReplyListRequestModel = new ProductReplyListRequestModel();
        productReplyListRequestModel.setToken(BaseApplication.getToken());
        productReplyListRequestModel.setCmd(ApiInterface.ProductReplyList);
        productReplyListRequestModel.setParameters(new ProductReplyListRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1), pagerSize, pager));
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
