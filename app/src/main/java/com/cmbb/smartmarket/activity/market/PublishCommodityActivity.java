package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v7.widget.LinearLayoutManager;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aigestudio.wheelpicker.core.AbstractWheelPicker;
import com.aigestudio.wheelpicker.view.WheelStraightPicker;
import com.alibaba.mobileim.ui.multi.lightservice.MultiPickGalleryActivity;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.adapter.PublishItemAdapter;
import com.cmbb.smartmarket.activity.market.model.CommodityPublishResponseModel;
import com.cmbb.smartmarket.activity.market.model.PublishImageModel;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllRequest;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.SPCache;
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
    @BindView(R.id.rl_type)
    RelativeLayout rlType;
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
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.tv_old_price)
    EditText tvOldPrice;
    @BindView(R.id.tv_freight)
    EditText tvFreight;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.scroll)
    LinearLayout scroll;
    @BindView(R.id.wv01)
    WheelStraightPicker straightPicker;
    @BindView(R.id.wv02)
    WheelStraightPicker curvedPicker;
    BottomSheetBehavior behavior;

    SystemCodeInfoGetAllResponseModel mSystemCodeInfoGetAllResponseModel;//所有类别
    int classParent = 0;
    int classChild = 0;
    String productType = "0";

    Observer<CommodityPublishResponseModel> mCommodityPublishResponseModelObserver = new Observer<CommodityPublishResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(CommodityPublishResponseModel commodityPublishResponseModel) {
            hideWaitingDialog();
            showToast(commodityPublishResponseModel.getMsg());
            finish();
        }
    };

    //地址请求
    Observer<SystemCodeInfoGetAllResponseModel> mSystemCodeInfoGetAllResponseModelObserver = new Observer<SystemCodeInfoGetAllResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(SystemCodeInfoGetAllResponseModel systemCodeInfoGetAllResponseModel) {
            hideWaitingDialog();
            initWSP();
            if (systemCodeInfoGetAllResponseModel != null) {
                mSystemCodeInfoGetAllResponseModel = systemCodeInfoGetAllResponseModel;
                straightStrings.clear();
                for (SystemCodeInfoGetAllResponseModel.DataEntity dataEntity : systemCodeInfoGetAllResponseModel.getData()) {
                    straightStrings.add(dataEntity.getName());
                }
                straightPicker.setData(straightStrings);
                straightPicker.setItemIndex(0);
            }
        }
    };

    private ArrayList<String> straightStrings = new ArrayList<>();
    private ArrayList<String> curvedStrings = new ArrayList<>();

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("发布");
        productType = getIntent().getStringExtra("productType");
        showWaitingDialog();
        tvOldPrice.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                int posDot = temp.indexOf(".");
                if (posDot <= 0)
                    return;
                if (temp.length() - posDot - 1 > 2) {
                    edt.delete(posDot + 3, posDot + 4);
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
        tvNewPrice.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                int posDot = temp.indexOf(".");
                if (posDot <= 0)
                    return;
                if (temp.length() - posDot - 1 > 2) {
                    edt.delete(posDot + 3, posDot + 4);
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
        tvFreight.addTextChangedListener(new TextWatcher() {
            public void afterTextChanged(Editable edt) {
                String temp = edt.toString();
                int posDot = temp.indexOf(".");
                if (posDot <= 0)
                    return;
                if (temp.length() - posDot - 1 > 2) {
                    edt.delete(posDot + 3, posDot + 4);
                }
            }

            public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }

            public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            }
        });
        subscription = HttpMethod.getInstance().systemCodeInfoGetAllRequest(mSystemCodeInfoGetAllResponseModelObserver, setParams());
        behavior = BottomSheetBehavior.from(scroll);
        initRecyclerView();
        footerItemView = new RecyclerArrayAdapter.ItemView() {
            @Override
            public View onCreateView(ViewGroup parent) {
                ImageView imageView = new ImageView(PublishCommodityActivity.this);
                imageView.setId(R.id.tv_boy);
                imageView.setImageResource(R.drawable.ic_add);
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
        rlType.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
        if (productType.equals("1")) {
            ll03.setVisibility(View.GONE);
        }
    }

    AbstractWheelPicker.SimpleWheelChangeListener straightPickerListener = new AbstractWheelPicker.SimpleWheelChangeListener() {
        @Override
        public void onWheelSelected(int index, String data) {
            classParent = index;
            curvedStrings.clear();
            if (mSystemCodeInfoGetAllResponseModel.getData().get(index).getChildCodeInfoList() == null || mSystemCodeInfoGetAllResponseModel.getData().get(index).getChildCodeInfoList().size() == 0) {
                curvedStrings.add("没有分类");
            } else {
                for (SystemCodeInfoGetAllResponseModel.DataEntity.ChildCodeInfoListEntity entity : mSystemCodeInfoGetAllResponseModel.getData().get(index).getChildCodeInfoList()) {
                    curvedStrings.add(entity.getName());
                }
            }
            curvedPicker.setData(curvedStrings);
            curvedPicker.setItemIndex(0);
        }
    };

    AbstractWheelPicker.SimpleWheelChangeListener curvedPickerListener = new AbstractWheelPicker.SimpleWheelChangeListener() {

        @Override
        public void onWheelSelected(int index, String data) {
            Log.e("02", data);
            classChild = index;
        }
    };

    private void initWSP() {
        straightPicker.setTextColor(0xFFA7A7DB);
        straightPicker.setCurrentTextColor(0xFF536D8A);
        curvedPicker.setTextColor(0xFFA7A7DB);
        curvedPicker.setCurrentTextColor(0xFF536D8A);
        straightPicker.setOnWheelChangeListener(straightPickerListener);
        curvedPicker.setOnWheelChangeListener(curvedPickerListener);
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
            case R.id.tv_cancel:
                behaviorStart(tvCancel);
                break;
            case R.id.tv_confirm:
                behaviorStart(tvConfirm);
                break;
            case R.id.iv:

                break;
            case R.id.tv_submit:
                String title = etTitle.getText().toString();
                if (TextUtils.isEmpty(title)) {
                    showToast("请输入标题");
                    return;
                }
                String content = etContent.getText().toString();
                if (TextUtils.isEmpty(content)) {
                    showToast("请输入宝贝描述");
                    return;
                }
                String currentPrice = tvNewPrice.getText().toString();
                if (TextUtils.isEmpty(currentPrice)) {
                    showToast("请输入当前价格");
                    return;
                }
                String originalPrice = tvOldPrice.getText().toString();
                String freight = tvFreight.getText().toString();
                String parentClassify = mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getValue();
                String secondClassify = mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getChildCodeInfoList() != null ? mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getChildCodeInfoList().get(classChild).getValue() : "";
                String locationJosnStr = SPCache.getString(Constants.LOCATION, "");
                Log.i(TAG, locationJosnStr);
                if (TextUtils.isEmpty(locationJosnStr)) {
                    showToast("您未开启定位功能，可能影响使用");
                }
                publishCommodity(title, content, currentPrice, originalPrice, freight, parentClassify, secondClassify, locationJosnStr, productType, imageUrls);
                break;
            case R.id.rl_type:
                if (mSystemCodeInfoGetAllResponseModel == null)
                    return;
                behaviorStart(rlType);
                break;
        }
    }

    protected SystemCodeInfoGetAllRequest setParams() {
        unSubscribe();
        SystemCodeInfoGetAllRequest systemCodeInfoGetAllRequest = new SystemCodeInfoGetAllRequest();
        systemCodeInfoGetAllRequest.setToken(BaseApplication.getToken());
        systemCodeInfoGetAllRequest.setCmd(ApiInterface.SystemCodeInfoGetAll);
        systemCodeInfoGetAllRequest.setParameters(new SystemCodeInfoGetAllRequest.ParametersEntity("market_product_type", 2));
        return systemCodeInfoGetAllRequest;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == PIC_REQUEST_CODE && data != null) {
            imageUrls = data.getStringArrayListExtra("result_list");
            if (imageUrls != null && imageUrls.size() > 0) {
                List<PublishImageModel> publishImageModels = new ArrayList<>();
                for (String url : imageUrls) {
                    publishImageModels.add(new PublishImageModel(url, 0));
                    /*HttpMethod.getInstance().uploadImageWithProgress(new Observer<ImageUploadResponseModel>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {
                            Log.e(TAG, e.toString());
                        }

                        @Override
                        public void onNext(ImageUploadResponseModel imageUploadResponseModel) {
                            Log.e(TAG, imageUploadResponseModel.toString());
                        }
                    }, setUploadParams(url), new CountingRequestBody.Listener() {
                        @Override
                        public void onRequestProgress(long bytesWritten, long contentLength) {
                            Log.e(TAG, "bytesWritten = " + bytesWritten + " contentLength =  " + contentLength);
                            int i = (int) (contentLength / 2048 / 5);

                        }
                    });*/
                }
                adapter.addAll(publishImageModels);
            }
            if (imgCount != 0)
                imgCount = imgCount - imageUrls.size();
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    private Map<String, RequestBody> setUploadParams(String url) {
        File file = new File(url);
        Map<String, RequestBody> params = new HashMap<>();
        params.put("token", RequestBody.create(MediaType.parse("text/plain"), BaseApplication.getToken()));
        params.put("type", RequestBody.create(MediaType.parse("text/plain"), "1"));
        params.put("imageList\"; filename=\"" + file.getName() + "\"", RequestBody.create(MediaType.parse("image/*"), file));
        return params;
    }

    private void publishCommodity(String title, String content, String currentPrice, String originalPrice, String freight, String parentClassify,
                                  String secondClassify, String locationJosnStr, String productType, ArrayList<String> images) {
        Map<String, RequestBody> params = new HashMap<>();
        if (!TextUtils.isEmpty(title))
            params.put("title", RequestBody.create(MediaType.parse("multipart/form-data"), title));
        if (!TextUtils.isEmpty(content))
            params.put("content", RequestBody.create(MediaType.parse("multipart/form-data"), content));
        if (productType.equals("0")) {
            if (!TextUtils.isEmpty(currentPrice))
                params.put("currentPrice", RequestBody.create(MediaType.parse("multipart/form-data"), currentPrice));
            if (!TextUtils.isEmpty(originalPrice))
                params.put("originalPrice", RequestBody.create(MediaType.parse("multipart/form-data"), originalPrice));
            if (!TextUtils.isEmpty(freight))
                params.put("freight", RequestBody.create(MediaType.parse("multipart/form-data"), freight));
        }
        if (!TextUtils.isEmpty(parentClassify))
            params.put("parentClassify", RequestBody.create(MediaType.parse("multipart/form-data"), parentClassify));
        if (!TextUtils.isEmpty(secondClassify))
            params.put("secondClassify", RequestBody.create(MediaType.parse("multipart/form-data"), secondClassify));
        if (!TextUtils.isEmpty(locationJosnStr))
            params.put("locationJosnStr", RequestBody.create(MediaType.parse("multipart/form-data"), locationJosnStr));
        if (!TextUtils.isEmpty(productType))
            params.put("productType", RequestBody.create(MediaType.parse("multipart/form-data"), productType));
        params.put("token", RequestBody.create(MediaType.parse("multipart/form-data"), BaseApplication.getToken()));
        List<RequestBody> files = new ArrayList<>();
        if (images != null && images.size() > 0) {
            for (String image : images) {
                File file = new File(image);
                RequestBody requestFile = RequestBody.create(MediaType.parse("image/*"), file);
                files.add(requestFile);
            }
        }
        showWaitingDialog();
//        subscription = HttpMethod.getInstance().requestPublishCommodity(mCommodityPublishResponseModelObserver, params, files);
    }

    public void behaviorStart(View view) {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    public static void newIntent(Context context, String productType) {
        Intent intent = new Intent(context, PublishCommodityActivity.class);
        intent.putExtra("productType", productType);
        context.startActivity(intent);
    }
}
