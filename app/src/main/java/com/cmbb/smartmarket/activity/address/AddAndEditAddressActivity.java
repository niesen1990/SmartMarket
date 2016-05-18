package com.cmbb.smartmarket.activity.address;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.address.model.UserAddressDetailRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressDetailResponseModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressSaveRequestModel;
import com.cmbb.smartmarket.activity.address.model.UserAddressSaveResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 下午2:13
 * 修改人：N.Sun
 * 修改时间：16/5/6 下午2:13
 * 修改备注：
 */
public class AddAndEditAddressActivity extends BaseActivity {
    private static final String TAG = AddAndEditAddressActivity.class.getSimpleName();

    @BindView(R.id.ll01)
    LinearLayout ll01;
    @BindView(R.id.et_name)
    EditText etName;
    @BindView(R.id.ll02)
    LinearLayout ll02;
    @BindView(R.id.et_phone)
    EditText etPhone;
    @BindView(R.id.ll03)
    LinearLayout ll03;
    @BindView(R.id.ll04)
    LinearLayout ll04;
    @BindView(R.id.et_address_detail)
    EditText etAddressDetail;
    @BindView(R.id.ll05)
    LinearLayout ll05;
    @BindView(R.id.et_zip_code)
    EditText etZipCode;
    @BindView(R.id.ll06)
    LinearLayout ll06;
    @BindView(R.id.switch_default)
    Switch switchDefault;
    @BindView(R.id.tv_submit)
    TextView tvSubmit;

    int isDefault = 0;

    int id = -1;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("添加地址");
        tvSubmit.setOnClickListener(this);
        switchDefault.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    isDefault = 1;
                } else {
                    isDefault = 0;
                }
            }
        });
        id = getIntent().getIntExtra("id", -1);
        if (id != -1) {
            showWaitingDialog();
            unSubscribe();
            UserAddressDetailRequestModel userAddressDetailRequestModel = new UserAddressDetailRequestModel();
            userAddressDetailRequestModel.setToken(BaseApplication.getToken());
            userAddressDetailRequestModel.setCmd(ApiInterface.UserAddressDetail);
            userAddressDetailRequestModel.setParameters(new UserAddressDetailRequestModel.ParametersEntity(id));
            subscription = HttpMethod.getInstance().requestUserAddressDetail(mUserAddressDetailResponseModelObserver, userAddressDetailRequestModel);
        }
    }

    Observer<UserAddressDetailResponseModel> mUserAddressDetailResponseModelObserver = new Observer<UserAddressDetailResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            hideWaitingDialog();
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(UserAddressDetailResponseModel userAddressDetailResponseModel) {
            hideWaitingDialog();
            //更新UI
            etName.setText(userAddressDetailResponseModel.getData().getReceiveName());
            etPhone.setText(userAddressDetailResponseModel.getData().getReceivePhone());
            etAddressDetail.setText(userAddressDetailResponseModel.getData().getAddress());
            etZipCode.setText(userAddressDetailResponseModel.getData().getPostCode());
            switch (userAddressDetailResponseModel.getData().getIsDefault()) {
                case 0:
                    switchDefault.setChecked(false);
                    break;
                case 1:
                    switchDefault.setChecked(true);
                    break;
            }
        }
    };

    Observer<UserAddressSaveResponseModel> mUserAddressSaveResponseModelObserver = new Observer<UserAddressSaveResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
            hideWaitingDialog();
        }

        @Override
        public void onNext(UserAddressSaveResponseModel userAddressSaveResponseModel) {
            hideWaitingDialog();
            showToast(userAddressSaveResponseModel.getMsg());
            setResult(RESULT_OK);
            finish();
        }
    };

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_submit:
                if (TextUtils.isEmpty(etName.getText().toString())) {
                    showToast("请输入您的姓名");
                    return;
                }
                if (TextUtils.isEmpty(etPhone.getText().toString())) {
                    showToast("请输入您的手机号码");
                    return;
                }
                if (TextUtils.isEmpty(etAddressDetail.getText().toString())) {
                    showToast("请输入您的详细地址");
                    return;
                }
                showWaitingDialog();
                UserAddressSaveRequestModel requestModel = new UserAddressSaveRequestModel();
                requestModel.setToken(BaseApplication.getToken());
                requestModel.setCmd(ApiInterface.UserAddressSave);
                UserAddressSaveRequestModel.ParametersEntity parametersEntity = new UserAddressSaveRequestModel.ParametersEntity();
                parametersEntity.setReceiveName(etName.getText().toString());
                parametersEntity.setReceivePhone(etPhone.getText().toString());
                parametersEntity.setAddress(etAddressDetail.getText().toString());
                parametersEntity.setProvince("310000");
                parametersEntity.setCity("310100");
                parametersEntity.setDistrict("310110");
                parametersEntity.setIsDefault(isDefault);
                if (id != -1) {
                    parametersEntity.setId(id + "");
                }
                requestModel.setParameters(parametersEntity);
                subscription = HttpMethod.getInstance().requestUserAddressSave(mUserAddressSaveResponseModelObserver, requestModel);
                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_add_address_layout;
    }

    public static void newIntent(BaseActivity context, int requestCode) {
        Intent intent = new Intent(context, AddAndEditAddressActivity.class);
        context.startActivityForResult(intent, requestCode);
    }

    public static void newIntent(BaseActivity context, int id, int requestCode) {
        Intent intent = new Intent(context, AddAndEditAddressActivity.class);
        intent.putExtra("id", id);
        context.startActivityForResult(intent, requestCode);
    }
}
