package com.cmbb.smartmarket.activity.user;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.CursorLoader;
import android.support.v4.content.Loader;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.mobileim.ui.multi.lightservice.MultiPickGalleryActivity;
import com.alibaba.mobileim.utility.IMFileTools;
import com.alibaba.wxlib.config.StorageConstant;
import com.alibaba.wxlib.util.IMPrefsTools;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.AddressPickActivity;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateRequestModel;
import com.cmbb.smartmarket.activity.user.model.UserInfoUpdateResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.db.DBContent;
import com.cmbb.smartmarket.image.CircleTransform;
import com.cmbb.smartmarket.image.ImageLoader;
import com.cmbb.smartmarket.image.MediaCamera;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.NestedScrollView;
import com.soundcloud.android.crop.Crop;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import okhttp3.MediaType;
import okhttp3.RequestBody;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午7:57
 */
public class InfoActivity extends BaseActivity implements LoaderManager.LoaderCallbacks<Cursor> {

    private static final String TAG = InfoActivity.class.getSimpleName();
    @BindView(R.id.rl_head)
    RelativeLayout rlHead;
    @BindView(R.id.rl_nick)
    RelativeLayout rlNick;
    @BindView(R.id.tv_head)
    TextView tvHead;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.rl_sex)
    RelativeLayout rlSex;
    @BindView(R.id.tv_sex_tag)
    TextView tvSexTag;
    @BindView(R.id.tv_sex)
    TextView tvSex;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.tv_address)
    TextView tvAddress;
    @BindView(R.id.tv_introduce)
    TextView tvIntroduce;
    @BindView(R.id.rl_rule)
    RelativeLayout rlRule;
    @BindView(R.id.tv_address_tag)
    TextView tvAddressTag;
    @BindView(R.id.rl_introduce)
    RelativeLayout rlIntroduce;
    @BindView(R.id.tv_introduce_tag)
    TextView tvIntroduceTag;
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.tv_boy)
    TextView tvBoy;
    @BindView(R.id.tv_girl)
    TextView tvGirl;
    BottomSheetBehavior behaviorSex;

    @BindView(R.id.pic)
    NestedScrollView pic;
    @BindView(R.id.tv_camera)
    TextView tvCamera;
    @BindView(R.id.tv_gallery)
    TextView tvGallery;
    BottomSheetBehavior behaviorPic;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("我的资料");
        initView();
        getSupportLoaderManager().initLoader(0, null, this);
    }

    protected void initView() {
        behaviorSex = BottomSheetBehavior.from(scroll);
        behaviorPic = BottomSheetBehavior.from(pic);
        rlHead.setOnClickListener(this);
        rlSex.setOnClickListener(this);
        rlRule.setOnClickListener(this);
        rlIntroduce.setOnClickListener(this);
        tvBoy.setOnClickListener(this);
        tvGirl.setOnClickListener(this);
        rlNick.setOnClickListener(this);
        tvCamera.setOnClickListener(this);
        tvGallery.setOnClickListener(this);
    }

    private final int PIC_REQUEST_CODE = 1001;
    File imageTempFile;
    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.rl_head:
                behaviorPic();
                /*Intent intent = new Intent(this, MultiPickGalleryActivity.class);
                intent.putExtra(MultiPickGalleryActivity.MAX_COUNT, 1);
                intent.putExtra(MultiPickGalleryActivity.MAX_TOAST, "选择的图片不能超过5张");
                intent.putExtra("titleRightText", "完成");
                intent.putExtra("need_choose_original_pic", true);
                startActivityForResult(intent, PIC_REQUEST_CODE);*/

                /*PhotoPickerIntent intent = new PhotoPickerIntent(this);
                intent.setMultiChoose(false);
                intent.setPhotoCount(1);
                intent.setShowCamera(true);
                startActivityForResult(intent, PIC_REQUEST_CODE);*/

               /* Intent intent = new Intent(MainActivity.this, PhotoPagerActivity.class);
                intent.putExtra(PhotoPagerActivity.EXTRA_CURRENT_ITEM, position);
                intent.putExtra(PhotoPagerActivity.EXTRA_PHOTOS, imgPaths);
                startActivityForResult(intent, MODIFY_CHOOSE);*/
                break;
            case R.id.rl_nick:
                NickActivity.newIntent(this, tvNick.getText().toString());
                break;
            case R.id.rl_sex:
                intro(rlSex);
                break;
            case R.id.rl_rule:
                AddressPickActivity.newIntent(this, 100);
                break;
            case R.id.rl_introduce:
                IntroduceActivity.newIntent(this, tvIntroduce.getText().toString());
                break;
            case R.id.tv_boy:
                tvSex.setText("男");
                behaviorSex.setState(BottomSheetBehavior.STATE_COLLAPSED);
                updateRequest("", "1", "", "", "", "", "");
                break;
            case R.id.tv_girl:
                tvSex.setText("女");
                behaviorSex.setState(BottomSheetBehavior.STATE_COLLAPSED);
                updateRequest("", "2", "", "", "", "", "");
                break;
            case R.id.tv_camera:
                imageTempFile = IMFileTools.createImageFile(StorageConstant.getFilePath());
                MediaCamera.startCameraActivity(this, imageTempFile, 700);
                behaviorPic();
                break;
            case R.id.tv_gallery:
                Intent intent = new Intent(this, MultiPickGalleryActivity.class);
                intent.putExtra(MultiPickGalleryActivity.MAX_COUNT, 1);
                intent.putExtra(MultiPickGalleryActivity.MAX_TOAST, "选择的图片不能超过1张");
                intent.putExtra("titleRightText", "完成");
                intent.putExtra("need_choose_original_pic", true);
                startActivityForResult(intent, PIC_REQUEST_CODE);
                behaviorPic();
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_info_layout;
    }

    String province;
    String provinceCode;
    String city;
    String cityCode;
    String district;
    String districtCode;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == -1 && requestCode == PIC_REQUEST_CODE && data != null) {
            final ArrayList<String> tempUrls = data.getStringArrayListExtra("result_list");
            Uri source = Uri.fromFile(new File(tempUrls.get(0)));
            Uri destination = Uri.fromFile(new File(getCacheDir(), "cache_head"));
            Crop.of(source, destination).start(this);
        } else if (resultCode == -1 && requestCode == Crop.REQUEST_CROP) {
            if (Crop.getOutput(data) != null) {
                Log.i(TAG, Crop.getOutput(data).getPath());
                if (TextUtils.isEmpty(Crop.getOutput(data).getPath()))
                    return;
                showWaitingDialog();
                File file = new File(Crop.getOutput(data).getPath());
                Map<String, RequestBody> params = new HashMap<>();
                params.put("token", RequestBody.create(MediaType.parse("text/plain"), BaseApplication.getToken()));
                params.put("userImg\"; filename=\"" + file.getName() + "\"", RequestBody.create(MediaType.parse("image/*"), file));
                subscription = HttpMethod.getInstance().requestUpdateInfoImage(mUserInfoUpdateResponseModelObserver, params);
            }
        } else if (requestCode == 100 & resultCode == RESULT_OK) {
            province = data.getStringExtra("province");
            provinceCode = data.getStringExtra("provinceCode");
            city = data.getStringExtra("city");
            cityCode = data.getStringExtra("cityCode");
            district = data.getStringExtra("district");
            districtCode = data.getStringExtra("districtCode");
            updateRequest("", "", province, provinceCode, city, cityCode, "");
            tvAddress.setText(province + " | " + city);
        } else if (resultCode == RESULT_OK && requestCode == 700) {
            // camera
            if (this.imageTempFile == null && !TextUtils.isEmpty(IMPrefsTools.getStringPrefs(this, "imageTempFile"))) {
                this.imageTempFile = new File(IMPrefsTools.getStringPrefs(this, "imageTempFile"));
            }

            if (this.imageTempFile != null) {
                Log.e("data", this.imageTempFile.getAbsolutePath());
                Uri source = Uri.fromFile(new File(this.imageTempFile.getAbsolutePath()));
                Uri destination = Uri.fromFile(new File(getCacheDir(), "cache_head"));
                Crop.of(source, destination).start(this);
            }
            IMPrefsTools.removePrefs(this, "imageTempFile");
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

    public void intro(View view) {
        if (behaviorSex.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behaviorSex.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behaviorSex.setState(BottomSheetBehavior.STATE_EXPANDED);
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
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new CursorLoader(this, DBContent.DBUser.CONTENT_URI, null, null, null, null);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        if (cursor != null && cursor.moveToFirst()) {
            String nick = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_NICK_NAME));
            if (!TextUtils.isEmpty(nick))
                tvNick.setText(nick);
            String headImageUrl = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_HEAD_IMG));
            if (!TextUtils.isEmpty(headImageUrl))
                ImageLoader.loadUrlAndDiskCache(this, headImageUrl, ivHead, new CircleTransform(this));
            String city = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_CITY));
            String province = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_PROVINCE));
            if (!TextUtils.isEmpty(city) && !TextUtils.isEmpty(province))
                tvAddress.setText(province + " | " + city);
            String sex = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_MALE));
            if (!TextUtils.isEmpty(sex)) {
                switch (sex) {
                    case "1":
                        tvSex.setText("男");
                        break;
                    case "2":
                        tvSex.setText("女");
                        break;
                }
            }
            String introduce = cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_INTRODUCE));
            if (!TextUtils.isEmpty(introduce))
                tvIntroduce.setText(introduce);
            Log.i(TAG, cursor.getString(cursor.getColumnIndex(DBContent.DBUser.USER_TOKEN)));
        }
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }

    Observer<UserInfoUpdateResponseModel> mUserInfoUpdateResponseModelObserver = new Observer<UserInfoUpdateResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(UserInfoUpdateResponseModel userInfoUpdateResponseModel) {
            hideWaitingDialog();
            showToast(userInfoUpdateResponseModel.getMsg());
            ContentValues values = new ContentValues();
            values.put(DBContent.DBUser.USER_TOKEN, userInfoUpdateResponseModel.getData().getLoginToken());
            values.put(DBContent.DBUser.USER_ID, userInfoUpdateResponseModel.getData().getId());
            values.put(DBContent.DBUser.USER_HEAD_IMG, userInfoUpdateResponseModel.getData().getUserImg());
            values.put(DBContent.DBUser.USER_NICK_NAME, userInfoUpdateResponseModel.getData().getNickName());
            values.put(DBContent.DBUser.USER_MALE, userInfoUpdateResponseModel.getData().getSex());
            values.put(DBContent.DBUser.USER_PHONE, userInfoUpdateResponseModel.getData().getLoginAccount());
            values.put(DBContent.DBUser.USER_PROVINCE_ID, userInfoUpdateResponseModel.getData().getProvince());
            values.put(DBContent.DBUser.USER_CITY_ID, userInfoUpdateResponseModel.getData().getCity());
            values.put(DBContent.DBUser.USER_LEVEL, userInfoUpdateResponseModel.getData().getUserLevel());
            values.put(DBContent.DBUser.USER_INTRODUCE, userInfoUpdateResponseModel.getData().getIntroduce());
            values.put(DBContent.DBUser.IM_USER_ID, userInfoUpdateResponseModel.getData().getImUserId());
            getContentResolver().update(DBContent.DBUser.CONTENT_URI, values, DBContent.DBUser.USER_ID + " = " + userInfoUpdateResponseModel.getData().getId(), null);
        }
    };

    private void updateRequest(String nick, String sex, String provinceId, String province, String cityId, String city, String introduce) {
        UserInfoUpdateRequestModel userInfoUpdateRequestModel = new UserInfoUpdateRequestModel();
        userInfoUpdateRequestModel.setCmd(ApiInterface.UserInfoUpdate);
        userInfoUpdateRequestModel.setToken(BaseApplication.getToken());
        UserInfoUpdateRequestModel.ParametersEntity parametersEntity = new UserInfoUpdateRequestModel.ParametersEntity();
        if (!TextUtils.isEmpty(nick))
            parametersEntity.setUserNike(nick);
        if (!TextUtils.isEmpty(sex))
            parametersEntity.setUserSex(sex);
        if (!TextUtils.isEmpty(provinceId))
            parametersEntity.setProvince(provinceId);
        if (!TextUtils.isEmpty(province))
            parametersEntity.setProvinceText(province);
        if (!TextUtils.isEmpty(cityId))
            parametersEntity.setCity(cityId);
        if (!TextUtils.isEmpty(city))
            parametersEntity.setCityText(city);
        if (!TextUtils.isEmpty(introduce))
            parametersEntity.setUserPresentation(introduce);
        userInfoUpdateRequestModel.setParameters(parametersEntity);
        showWaitingDialog();
        subscription = HttpMethod.getInstance().requestUpdateUserInfo(mUserInfoUpdateResponseModelObserver, userInfoUpdateRequestModel);
    }

    public static void newIntent(Context context) {
        Intent intent = new Intent(context, InfoActivity.class);
        context.startActivity(intent);
    }
}
