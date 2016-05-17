package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.mobileim.ui.multi.lightservice.MultiPickGalleryActivity;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.PublishItemAdapter;
import com.cmbb.smartmarket.activity.market.model.CommodityPublishResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.TDevice;
import com.jude.easyrecyclerview.EasyRecyclerView;
import com.jude.easyrecyclerview.adapter.RecyclerArrayAdapter;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/28 下午12:54
 */
public class PublishCommodityActivity extends BaseActivity {
    private static final java.lang.String TAG = PublishCommodityActivity.class.getSimpleName();
    protected RecyclerArrayAdapter adapter;
    protected RecyclerArrayAdapter.ItemView footerItemView;
    private final int PIC_REQUEST_CODE = 1001;
    protected int imgCount = 5;

    ArrayList<String> imageUrls;

    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.recyclerView)
    EasyRecyclerView mSmartRecyclerView;
    @BindView(R.id.ll03)
    LinearLayout ll03;
    @BindView(R.id.tv_new_price)
    EditText tvNewPrice;
    @BindView(R.id.tv_old_price)
    EditText tvOldPrice;
    @BindView(R.id.tv_freight)
    EditText tvFreight;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    Observer<CommodityPublishResponseModel> mCommodityPublishResponseModelObserver = new Observer<CommodityPublishResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
        }

        @Override
        public void onNext(CommodityPublishResponseModel commodityPublishResponseModel) {
            hideWaitingDialog();
            showToast(commodityPublishResponseModel.getMsg());
        }
    };

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("发布");
        initRecyclerView();
        footerItemView = new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                ImageView imageView = new ImageView(PublishCommodityActivity.this);
                imageView.setId(R.id.tv_boy);
                imageView.setImageResource(android.R.drawable.ic_menu_add);
                imageView.setLayoutParams(new ViewGroup.LayoutParams(TDevice.dip2px(84, PublishCommodityActivity.this), TDevice.dip2px(84, PublishCommodityActivity.this)));
                return imageView;
            }

            @Override
            public void onBindView(View headerView) {
                headerView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (imgCount == 0) {
                            showToast("最多添加5张图片");
                            return;
                        }
                        Intent intent = new Intent(PublishCommodityActivity.this, MultiPickGalleryActivity.class);
                        intent.putExtra(MultiPickGalleryActivity.MAX_COUNT, 5);
                        intent.putExtra(MultiPickGalleryActivity.MAX_TOAST, "选择的图片不能超过5张");
                        intent.putExtra("titleRightText", "完成");
                        intent.putExtra("need_choose_original_pic", true);
                        startActivityForResult(intent, PIC_REQUEST_CODE);
                    }
                });
            }
        };
        adapter.addFooter(footerItemView);
        tvSubmit.setOnClickListener(this);
    }

    private void initRecyclerView() {
        mSmartRecyclerView = (EasyRecyclerView) findViewById(R.id.recyclerView);
        if (mSmartRecyclerView == null)
            return;
        mSmartRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        adapter = new PublishItemAdapter(this);
        mSmartRecyclerView.setAdapterWithProgress(adapter);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish_commodity_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.iv:

                break;
            case R.id.tv_submit:
                String title = etTitle.getText().toString();
                String content = etContent.getText().toString();
                String currentPrice = "6";
                String originalPrice = "6";
                String freight = tvFreight.getText().toString();
                String parentClassify = "test01";
                String secondClassify = "test02";
                String lontitude = "00001";
                String latitude = "00002";
                String province = "000001";
                String city = "000002";
                String district = "000003";
                String address = "上海黄浦区";
                String productType = "1";
                publishCommodity(title, content, currentPrice, originalPrice, freight, parentClassify, secondClassify, lontitude, latitude, province, city, district, address, productType, imageUrls);
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == PIC_REQUEST_CODE && data != null) {
            imageUrls = data.getStringArrayListExtra("result_list");
            adapter.addAll(imageUrls);
            if (imgCount != 0)
                imgCount = imgCount - imageUrls.size();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private void publishCommodity(String title, String content, String currentPrice, String originalPrice, String freight, String parentClassify,
                                  String secondClassify, String lontitude, String latitude, String province, String city, String district,
                                  String address, String productType, ArrayList<String> images) {
        Map<String, RequestBody> params = new HashMap<>();
        if (!TextUtils.isEmpty(title))
            params.put("title", RequestBody.create(MediaType.parse("multipart/form-data"), title));
        if (!TextUtils.isEmpty(content))
            params.put("content", RequestBody.create(MediaType.parse("multipart/form-data"), content));
        if (!TextUtils.isEmpty(currentPrice))
            params.put("currentPrice", RequestBody.create(MediaType.parse("multipart/form-data"), currentPrice));
        if (!TextUtils.isEmpty(originalPrice))
            params.put("originalPrice", RequestBody.create(MediaType.parse("multipart/form-data"), originalPrice));
        if (!TextUtils.isEmpty(freight))
            params.put("freight", RequestBody.create(MediaType.parse("multipart/form-data"), freight));
        if (!TextUtils.isEmpty(parentClassify))
            params.put("parentClassify", RequestBody.create(MediaType.parse("multipart/form-data"), parentClassify));
        if (!TextUtils.isEmpty(secondClassify))
            params.put("secondClassify", RequestBody.create(MediaType.parse("multipart/form-data"), secondClassify));
        if (!TextUtils.isEmpty(lontitude))
            params.put("lontitude", RequestBody.create(MediaType.parse("multipart/form-data"), lontitude));
        if (!TextUtils.isEmpty(latitude))
            params.put("latitude", RequestBody.create(MediaType.parse("multipart/form-data"), latitude));
        if (!TextUtils.isEmpty(province))
            params.put("province", RequestBody.create(MediaType.parse("multipart/form-data"), province));
        if (!TextUtils.isEmpty(city))
            params.put("city", RequestBody.create(MediaType.parse("multipart/form-data"), city));
        if (!TextUtils.isEmpty(district))
            params.put("district", RequestBody.create(MediaType.parse("multipart/form-data"), district));
        if (!TextUtils.isEmpty(address))
            params.put("address", RequestBody.create(MediaType.parse("multipart/form-data"), address));
        if (!TextUtils.isEmpty(productType))
            params.put("productType", RequestBody.create(MediaType.parse("multipart/form-data"), productType));
        params.put("token", RequestBody.create(MediaType.parse("multipart/form-data"), BaseApplication.getToken()));
        List<RequestBody> files = new ArrayList<>();
        if (images != null && images.size() > 0) {
            for (String image : images) {
                File file = new File(image);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image"), file);
                files.add(requestFile);
            }
        }
        showWaitingDialog();
        subscription = HttpMethod.getInstance().requestPublishCommodity(mCommodityPublishResponseModelObserver, params, files);
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, PublishCommodityActivity.class);
        context.startActivity(intent);
    }
}
