package com.cmbb.smartmarket.activity.market;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aigestudio.wheelpicker.core.AbstractWheelPicker;
import com.aigestudio.wheelpicker.view.WheelStraightPicker;
import com.alibaba.mobileim.ui.multi.lightservice.MultiPickGalleryActivity;
import com.alibaba.mobileim.utility.IMFileTools;
import com.alibaba.wxlib.config.StorageConstant;
import com.alibaba.wxlib.util.IMPrefsTools;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.login.LoginActivity;
import com.cmbb.smartmarket.activity.market.model.CommodityPublishResponseModel;
import com.cmbb.smartmarket.activity.market.model.ImageDeleteResponseModel;
import com.cmbb.smartmarket.activity.market.model.PublishEditResponseModel;
import com.cmbb.smartmarket.activity.market.model.PublishImageModel;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllRequest;
import com.cmbb.smartmarket.activity.market.model.SystemCodeInfoGetAllResponseModel;
import com.cmbb.smartmarket.activity.user.model.MyselfProductPublicListResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.Constants;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.image.MediaCamera;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.utils.DialogUtils;
import com.cmbb.smartmarket.utils.KeyboardUtil;
import com.cmbb.smartmarket.utils.SPCache;
import com.cmbb.smartmarket.utils.lbs.Location;
import com.cmbb.smartmarket.widget.NestedScrollView;
import com.google.gson.Gson;

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
public class PublishActivity extends BaseActivity {
    private static final String TAG = PublishActivity.class.getSimpleName();
    private final int PIC_REQUEST_CODE = 1001;

    @BindView(R.id.et_title)
    EditText etTitle;
    @BindView(R.id.et_content)
    EditText etContent;
    @BindView(R.id.ll02)
    HorizontalScrollView ll02;
    @BindView(R.id.item01)
    FrameLayout item01;
    @BindView(R.id.iv01)
    ImageView iv01;
    @BindView(R.id.iv_delete01)
    ImageView ivDelete01;
    @BindView(R.id.progress01)
    ProgressBar progress01;
    @BindView(R.id.item02)
    FrameLayout item02;
    @BindView(R.id.iv02)
    ImageView iv02;
    @BindView(R.id.iv_delete02)
    ImageView ivDelete02;
    @BindView(R.id.progress02)
    ProgressBar progress02;
    @BindView(R.id.item03)
    FrameLayout item03;
    @BindView(R.id.iv03)
    ImageView iv03;
    @BindView(R.id.iv_delete03)
    ImageView ivDelete03;
    @BindView(R.id.progress03)
    ProgressBar progress03;
    @BindView(R.id.item04)
    FrameLayout item04;
    @BindView(R.id.iv04)
    ImageView iv04;
    @BindView(R.id.iv_delete04)
    ImageView ivDelete04;
    @BindView(R.id.progress04)
    ProgressBar progress04;
    @BindView(R.id.item05)
    FrameLayout item05;
    @BindView(R.id.iv05)
    ImageView iv05;
    @BindView(R.id.iv_delete05)
    ImageView ivDelete05;
    @BindView(R.id.progress05)
    ProgressBar progress05;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.ll03)
    LinearLayout ll03;
    @BindView(R.id.tv_new_price)
    EditText tvNewPrice;
    @BindView(R.id.tv_old_price)
    EditText tvOldPrice;
    @BindView(R.id.tv_freight)
    EditText tvFreight;
    @BindView(R.id.rl_type)
    RelativeLayout rlType;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;
    @BindView(R.id.scroll)
    LinearLayout scroll;
    @BindView(R.id.tv_cancel)
    TextView tvCancel;
    @BindView(R.id.tv_class)
    TextView tvClass;
    @BindView(R.id.tv_confirm)
    TextView tvConfirm;
    @BindView(R.id.add)
    ImageView add;

    @BindView(R.id.pic)
    NestedScrollView pic;
    @BindView(R.id.tv_camera)
    TextView tvCamera;
    @BindView(R.id.tv_gallery)
    TextView tvGallery;
    BottomSheetBehavior behaviorPic;

    @BindView(R.id.wv01)
    WheelStraightPicker straightPicker;
    @BindView(R.id.wv02)
    WheelStraightPicker curvedPicker;
    BottomSheetBehavior behavior;

    MyselfProductPublicListResponseModel.DataEntity.ContentEntity goodModel;
    SystemCodeInfoGetAllResponseModel mSystemCodeInfoGetAllResponseModel;//所有类别
    int classParent = 0;
    int classChild = 0;
    String productType = "0";
    String parentClassify;
    String secondClassify;

    int imageCount = 5;
    List<PublishImageModel> publishImageModels = new ArrayList<>();

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

    Observer<PublishEditResponseModel> mPublishEditResponseModelObserver = new Observer<PublishEditResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(PublishEditResponseModel publishEditResponseModel) {
            hideWaitingDialog();
            showToast(publishEditResponseModel.getMsg());
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
                curvedStrings.clear();
                // 第一组数据
                for (SystemCodeInfoGetAllResponseModel.DataEntity dataEntity : systemCodeInfoGetAllResponseModel.getData()) {
                    straightStrings.add(dataEntity.getName());
                }
                straightPicker.setData(straightStrings);
                straightPicker.setItemIndex(0);
                // 第二组数据
                for (SystemCodeInfoGetAllResponseModel.DataEntity.ChildCodeInfoListEntity childCodeInfoListEntity : systemCodeInfoGetAllResponseModel.getData().get(0).getChildCodeInfoList()) {
                    curvedStrings.add(childCodeInfoListEntity.getName());
                }
                curvedPicker.setData(curvedStrings);
                curvedPicker.setItemIndex(0);
            }
        }
    };

    //分类数据
    private ArrayList<String> straightStrings = new ArrayList<>();
    private ArrayList<String> curvedStrings = new ArrayList<>();
    Location location;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle(getIntent().getStringExtra("title"));
        if (TextUtils.isEmpty(BaseApplication.getToken())) {
            DialogUtils.createAlertDialog(this, "警告", "您还没有登陆哦...", true, new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    LoginActivity.newIntent(PublishActivity.this);
                }
            });
        }
        productType = getIntent().getStringExtra("productType");
        goodModel = getIntent().getParcelableExtra("data");
        if (!TextUtils.isEmpty(SPCache.getString(Constants.LOCATION, ""))) {
            location = new Gson().fromJson(SPCache.getString(Constants.LOCATION, ""), Location.class);
            tvAddress.setText(location.getCity() + " " + location.getDistrict());
        } else {
            tvAddress.setText("无法定位");
        }
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
        behaviorPic = BottomSheetBehavior.from(pic);
        tvSubmit.setOnClickListener(this);
        rlType.setOnClickListener(this);
        tvCancel.setOnClickListener(this);
        tvConfirm.setOnClickListener(this);
        add.setOnClickListener(this);
        ivDelete01.setOnClickListener(this);
        ivDelete02.setOnClickListener(this);
        ivDelete03.setOnClickListener(this);
        ivDelete04.setOnClickListener(this);
        ivDelete05.setOnClickListener(this);
        tvCamera.setOnClickListener(this);
        tvGallery.setOnClickListener(this);
        if (productType.equals("1")) {
            ll03.setVisibility(View.GONE);
        }
        if (goodModel != null) {
            setTitle("编辑");
            parentClassify = goodModel.getParentClassify();
            secondClassify = goodModel.getSecondClassify();
            etTitle.setText(goodModel.getTitle());
            etContent.setText(goodModel.getContent());
            tvNewPrice.setText(goodModel.getCurrentPrice() + "");
            tvOldPrice.setText(goodModel.getOriginalPrice() + "");
            tvClass.setText(goodModel.getParentClassifyText() + " - " + goodModel.getSecondClassifyText());

            for (MyselfProductPublicListResponseModel.DataEntity.ContentEntity.ProductImageListEntity model : goodModel.getProductImageList()) {
                publishImageModels.add(new PublishImageModel(model.getLocation(), 0, model.getBusinessNumber()));
            }
            imageCount = imageCount - publishImageModels.size();
            imageControl(publishImageModels);
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
            classChild = 0;
        }
    };

    AbstractWheelPicker.SimpleWheelChangeListener curvedPickerListener = new AbstractWheelPicker.SimpleWheelChangeListener() {

        @Override
        public void onWheelSelected(int index, String data) {
            Log.e(TAG, data);
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

    @Override
    protected int getLayoutId() {
        return R.layout.activity_publish_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_cancel:
                behaviorStart();
                parentClassify = "";
                secondClassify = "";
                tvClass.setText("");
                break;
            case R.id.tv_confirm:
                behaviorStart();
                tvClass.setText(mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getName() + " - " + mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getChildCodeInfoList().get(classChild).getName());
                parentClassify = mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getValue();
                secondClassify = mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getChildCodeInfoList() != null ? mSystemCodeInfoGetAllResponseModel.getData().get(classParent).getChildCodeInfoList().get(classChild).getValue() : "";
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
                if ((TextUtils.isEmpty(currentPrice) || Double.parseDouble(currentPrice) == 0) && productType.equals("0")) {
                    showToast("请输入当前价格");
                    return;
                }
                if (TextUtils.isEmpty(parentClassify)) {
                    showToast("请选择商品类型");
                    return;
                }
                String originalPrice = tvOldPrice.getText().toString();
                String freight = tvFreight.getText().toString();
                String locationJosnStr = SPCache.getString(Constants.LOCATION, "");
                Log.i(TAG, locationJosnStr);
                if (TextUtils.isEmpty(locationJosnStr)) {
                    showToast("您未开启定位功能，可能影响使用");
                }
                if (goodModel == null) {
                    publishCommodity(title, content, currentPrice, originalPrice, freight, parentClassify, secondClassify, locationJosnStr, productType);
                } else {
                    editCommodity(title, content, currentPrice, originalPrice, freight, parentClassify, secondClassify, locationJosnStr, productType);
                }
                break;
            case R.id.rl_type:
                if (mSystemCodeInfoGetAllResponseModel == null)
                    return;
                behaviorStart();
                break;
            case R.id.add:
                if (imageCount == 0) {
                    showToast("最多添加5张图片");
                    return;
                }
                KeyboardUtil.hideKeyboard(this);
                behaviorPic();
                break;
            case R.id.iv_delete01:
                deleteImage(publishImageModels.get(0).getBusinessNumber(), 0);
                break;
            case R.id.iv_delete02:
                deleteImage(publishImageModels.get(1).getBusinessNumber(), 1);
                break;
            case R.id.iv_delete03:
                deleteImage(publishImageModels.get(2).getBusinessNumber(), 2);
                break;
            case R.id.iv_delete04:
                deleteImage(publishImageModels.get(3).getBusinessNumber(), 3);
                break;
            case R.id.iv_delete05:
                deleteImage(publishImageModels.get(4).getBusinessNumber(), 4);
                break;
            case R.id.tv_camera:
                imageTempFile = IMFileTools.createImageFile(StorageConstant.getFilePath());
                MediaCamera.startCameraActivity(this, imageTempFile, 700);
                behaviorPic();
                break;
            case R.id.tv_gallery:
                Intent intent = new Intent(this, MultiPickGalleryActivity.class);
                intent.putExtra(MultiPickGalleryActivity.MAX_COUNT, imageCount);
                intent.putExtra(MultiPickGalleryActivity.MAX_TOAST, "选择的图片不能超过" + imageCount + "张");
                intent.putExtra("titleRightText", "完成");
                intent.putExtra("need_choose_original_pic", true);
                startActivityForResult(intent, PIC_REQUEST_CODE);
                behaviorPic();
                break;
        }
    }

    protected SystemCodeInfoGetAllRequest setParams() {
        unSubscribe();
        SystemCodeInfoGetAllRequest systemCodeInfoGetAllRequest = new SystemCodeInfoGetAllRequest();
        //        systemCodeInfoGetAllRequest.setToken(BaseApplication.getToken());
        systemCodeInfoGetAllRequest.setCmd(ApiInterface.SystemCodeInfoGetAll);
        systemCodeInfoGetAllRequest.setParameters(new SystemCodeInfoGetAllRequest.ParametersEntity("market_product_type", 2));
        return systemCodeInfoGetAllRequest;
    }

    File imageTempFile;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == PIC_REQUEST_CODE && data != null) {
            if (data.getStringArrayListExtra("result_list") != null && data.getStringArrayListExtra("result_list").size() > 0) {
                for (String url : data.getStringArrayListExtra("result_list")) {
                    publishImageModels.add(new PublishImageModel(url, 0));
                    Log.e(TAG, "imageUrl = " + url);
                }
                /*WxDefaultExecutor.getInstance().submitHttp((new PictureCompressThread(data.getStringArrayListExtra("result_list"), PublishActivity.this, new PictureCompressThread.CompressCallback() {
                    @Override
                    public void callback(String originPath, String compressedPath) {
                        publishImageModels.add(new PublishImageModel(compressedPath, 0));
                        Log.e(TAG, "publishImageModels size " + publishImageModels.size());
                    }

                    @Override
                    public void completed() {
                        Log.e(TAG, "publishImageModels completed ");

                        imageControl(publishImageModels);
                    }
                })).setNeedCompress(data.getBooleanExtra("need_compress", false)));*/
                imageControl(publishImageModels);
            }
            if (imageCount != 0)
                imageCount = imageCount - data.getStringArrayListExtra("result_list").size();
        } else if (resultCode == RESULT_OK && requestCode == 700) {
            // camera
            if (this.imageTempFile == null && !TextUtils.isEmpty(IMPrefsTools.getStringPrefs(this, "imageTempFile"))) {
                this.imageTempFile = new File(IMPrefsTools.getStringPrefs(this, "imageTempFile"));
            }

            if (this.imageTempFile != null) {
                Log.e("data", this.imageTempFile.getAbsolutePath());
                publishImageModels.add(new PublishImageModel(this.imageTempFile.getAbsolutePath(), 0));
                imageControl(publishImageModels);
                if (imageCount != 0)
                    imageCount = imageCount - 1;
            }
            IMPrefsTools.removePrefs(this, "imageTempFile");
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
                                  String secondClassify, String locationJosnStr, String productType) {
        Map<String, RequestBody> params = new HashMap<>();
        if (!TextUtils.isEmpty(title))
            params.put("title", RequestBody.create(MediaType.parse("text/plain"), title));
        if (!TextUtils.isEmpty(content))
            params.put("content", RequestBody.create(MediaType.parse("text/plain"), content));
        if (productType.equals("0")) {
            if (!TextUtils.isEmpty(currentPrice))
                params.put("currentPrice", RequestBody.create(MediaType.parse("text/plain"), currentPrice));
            if (!TextUtils.isEmpty(originalPrice))
                params.put("originalPrice", RequestBody.create(MediaType.parse("text/plain"), originalPrice));
            if (!TextUtils.isEmpty(freight))
                params.put("freight", RequestBody.create(MediaType.parse("text/plain"), freight));
        }
        if (!TextUtils.isEmpty(parentClassify))
            params.put("parentClassify", RequestBody.create(MediaType.parse("text/plain"), parentClassify));
        if (!TextUtils.isEmpty(secondClassify))
            params.put("secondClassify", RequestBody.create(MediaType.parse("text/plain"), secondClassify));
        if (!TextUtils.isEmpty(locationJosnStr))
            params.put("locationJosnStr", RequestBody.create(MediaType.parse("text/plain"), locationJosnStr));
        if (!TextUtils.isEmpty(productType))
            params.put("productType", RequestBody.create(MediaType.parse("text/plain"), productType));
        params.put("token", RequestBody.create(MediaType.parse("text/plain"), BaseApplication.getToken()));
        if (publishImageModels.size() > 0) {
            String businessNumberParam = "";
            for (PublishImageModel model : publishImageModels) {
                if (TextUtils.isEmpty(model.getBusinessNumber())) {
                    showToast("图片正在上传或者失败");
                    return;
                } else {
                    businessNumberParam = TextUtils.isEmpty(businessNumberParam) ? model.getBusinessNumber() : businessNumberParam + "," + model.getBusinessNumber();
                }
            }
            params.put("businessNumber", RequestBody.create(MediaType.parse("text/plain"), businessNumberParam));
        } else if (productType.equals("0")) {
            showToast("请上传商品图片");
            return;
        }
        showWaitingDialog();
        subscription = HttpMethod.getInstance().requestPublishCommodity(mCommodityPublishResponseModelObserver, params);
    }

    private void editCommodity(String title, String content, String currentPrice, String originalPrice, String freight, String parentClassify,
                               String secondClassify, String locationJosnStr, String productType) {
        Map<String, RequestBody> params = new HashMap<>();
        params.put("id", RequestBody.create(MediaType.parse("text/plain"), goodModel.getId() + ""));
        if (!TextUtils.isEmpty(title))
            params.put("title", RequestBody.create(MediaType.parse("text/plain"), title));
        if (!TextUtils.isEmpty(content))
            params.put("content", RequestBody.create(MediaType.parse("text/plain"), content));
        if (productType.equals("0")) {
            if (!TextUtils.isEmpty(currentPrice))
                params.put("currentPrice", RequestBody.create(MediaType.parse("text/plain"), currentPrice));
            if (!TextUtils.isEmpty(originalPrice))
                params.put("originalPrice", RequestBody.create(MediaType.parse("text/plain"), originalPrice));
            if (!TextUtils.isEmpty(freight))
                params.put("freight", RequestBody.create(MediaType.parse("text/plain"), freight));
        }
        if (!TextUtils.isEmpty(parentClassify))
            params.put("parentClassify", RequestBody.create(MediaType.parse("text/plain"), parentClassify));
        if (!TextUtils.isEmpty(secondClassify))
            params.put("secondClassify", RequestBody.create(MediaType.parse("text/plain"), secondClassify));
        if (!TextUtils.isEmpty(locationJosnStr))
            params.put("locationJosnStr", RequestBody.create(MediaType.parse("text/plain"), locationJosnStr));
        if (!TextUtils.isEmpty(productType))
            params.put("productType", RequestBody.create(MediaType.parse("text/plain"), productType));
        params.put("token", RequestBody.create(MediaType.parse("text/plain"), BaseApplication.getToken()));
        if (publishImageModels.size() > 0) {
            String businessNumberParam = "";
            for (PublishImageModel model : publishImageModels) {
                if (TextUtils.isEmpty(model.getBusinessNumber())) {
                    showToast("图片正在上传或者失败");
                    return;
                } else {
                    businessNumberParam = TextUtils.isEmpty(businessNumberParam) ? model.getBusinessNumber() : businessNumberParam + "," + model.getBusinessNumber();
                }
            }
            params.put("businessNumber", RequestBody.create(MediaType.parse("text/plain"), businessNumberParam));
            Log.e(TAG, "businessNumberParam = " + businessNumberParam);
        }
        showWaitingDialog();
        subscription = HttpMethod.getInstance().publishEditRequest(mPublishEditResponseModelObserver, params);
    }

    public void imageControl(List<PublishImageModel> publishImageModels) {
        switch (publishImageModels.size()) {
            case 0:
                item01.setVisibility(View.GONE);
                item02.setVisibility(View.GONE);
                item03.setVisibility(View.GONE);
                item04.setVisibility(View.GONE);
                item05.setVisibility(View.GONE);
                break;
            case 1:
                item01.setVisibility(View.VISIBLE);
                item02.setVisibility(View.GONE);
                item03.setVisibility(View.GONE);
                item04.setVisibility(View.GONE);
                item05.setVisibility(View.GONE);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(0), iv01, progress01);
                break;
            case 2:
                item01.setVisibility(View.VISIBLE);
                item02.setVisibility(View.VISIBLE);
                item03.setVisibility(View.GONE);
                item04.setVisibility(View.GONE);
                item05.setVisibility(View.GONE);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(0), iv01, progress01);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(1), iv02, progress02);
                break;
            case 3:
                item01.setVisibility(View.VISIBLE);
                item02.setVisibility(View.VISIBLE);
                item03.setVisibility(View.VISIBLE);
                item04.setVisibility(View.GONE);
                item05.setVisibility(View.GONE);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(0), iv01, progress01);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(1), iv02, progress02);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(2), iv03, progress03);
                break;
            case 4:
                item01.setVisibility(View.VISIBLE);
                item02.setVisibility(View.VISIBLE);
                item03.setVisibility(View.VISIBLE);
                item04.setVisibility(View.VISIBLE);
                item05.setVisibility(View.GONE);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(0), iv01, progress01);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(1), iv02, progress02);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(2), iv03, progress03);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(3), iv04, progress04);
                break;
            case 5:
                item01.setVisibility(View.VISIBLE);
                item02.setVisibility(View.VISIBLE);
                item03.setVisibility(View.VISIBLE);
                item04.setVisibility(View.VISIBLE);
                item05.setVisibility(View.VISIBLE);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(0), iv01, progress01);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(1), iv02, progress02);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(2), iv03, progress03);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(3), iv04, progress04);
                ImageLoader.loadWithUploadListener(this, publishImageModels.get(4), iv05, progress05);
                break;
        }
    }

    private void deleteImage(final String businessNumber, int position) {
        if (!TextUtils.isEmpty(businessNumber)) {
            showWaitingDialog();
            HttpMethod.getInstance().imageDelete(new Observer<ImageDeleteResponseModel>() {
                @Override
                public void onCompleted() {
                    hideWaitingDialog();
                }

                @Override
                public void onError(Throwable e) {
                    hideWaitingDialog();
                }

                @Override
                public void onNext(ImageDeleteResponseModel imageDeleteResponseModel) {
                    if (imageDeleteResponseModel != null) {
                        showToast(imageDeleteResponseModel.getMsg());
                        deletePublishImageModels(businessNumber);
                        imageControl(publishImageModels);
                        imageCount++;
                    }
                }
            }, setDeleteParams(businessNumber));
        } else {
            if (publishImageModels.get(position).getSubscription() == null)
                return;
            publishImageModels.get(position).getSubscription().unsubscribe();
            publishImageModels.remove(position);
            imageCount++;
            imageControl(publishImageModels);
        }
    }

    private Map<String, RequestBody> setDeleteParams(String businessNumber) {
        Map<String, RequestBody> params = new HashMap<>();
        params.put("token", RequestBody.create(MediaType.parse("text/plain"), BaseApplication.getToken()));
        Log.e(TAG, "token = " + BaseApplication.getToken());
        params.put("type", RequestBody.create(MediaType.parse("text/plain"), "1"));
        Log.e(TAG, "type = " + 1);
        params.put("businessNumber", RequestBody.create(MediaType.parse("text/plain"), businessNumber));
        Log.e(TAG, "businessNumber = " + businessNumber);
        return params;
    }

    private void deletePublishImageModels(String businessNumber) {
        for (int i = 0; i < publishImageModels.size(); i++) {
            if (publishImageModels.get(i).getBusinessNumber().equals(businessNumber)) {
                publishImageModels.remove(i);
            }
        }
    }

    public void behaviorStart() {
        if (behavior.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    public void behaviorPic() {
        if (behaviorPic.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behaviorPic.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behaviorPic.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        Log.e(TAG, "onConfigurationChanged");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e(TAG, "onDestroy");
    }

    public static void newIntent(Context context, String title, String productType) {
        Intent intent = new Intent(context, PublishActivity.class);
        intent.putExtra("productType", productType);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    public static void newIntent(Context context, MyselfProductPublicListResponseModel.DataEntity.ContentEntity entity, String productType) {
        Intent intent = new Intent(context, PublishActivity.class);
        intent.putExtra("productType", productType);
        intent.putExtra("data", entity);
        context.startActivity(intent);
    }
}
