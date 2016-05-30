package com.cmbb.smartmarket.activity.wallet;

import android.support.design.widget.BottomSheetBehavior;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordRequestModel;
import com.cmbb.smartmarket.activity.wallet.model.WalletAccountValiatePayPasswordResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;
import com.cmbb.smartmarket.widget.NestedScrollView;

import butterknife.BindView;
import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/6 上午10:37
 * 修改人：N.Sun
 * 修改时间：16/5/6 上午10:37
 * 修改备注：
 */
public abstract class BaseAccountActivity extends BaseActivity {
    @BindView(R.id.scroll)
    NestedScrollView scroll;
    @BindView(R.id.iv_cancel)
    ImageView ivCancel;
    @BindView(R.id.iv_confirm)
    ImageView ivConfirm;
    @BindView(R.id.et_psw)
    EditText etPsw;

    boolean needValPsw = true;

    public boolean isNeedValPsw() {
        return needValPsw;
    }

    public void setNeedValPsw(boolean needValPsw) {
        this.needValPsw = needValPsw;
    }

    public void showBottomSheet() {
        ivCancel.setOnClickListener(this);
        ivConfirm.setOnClickListener(this);
        BottomSheetBehavior behaviorPsw = BottomSheetBehavior.from(scroll);
        if (behaviorPsw.getState() == BottomSheetBehavior.STATE_EXPANDED) {
            behaviorPsw.setState(BottomSheetBehavior.STATE_COLLAPSED);
        } else {
            behaviorPsw.setState(BottomSheetBehavior.STATE_EXPANDED);
        }
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.iv_cancel:
                showBottomSheet();
                break;
            case R.id.iv_confirm:
                if (TextUtils.isEmpty(etPsw.getText().toString())) {
                    showToast("请输入交易密码");
                    return;
                }
                if (needValPsw) {
                    showWaitingDialog();
                    subscription = HttpMethod.getInstance().walletAccountValiatePayPasswordRequest(getPswValiate(), setPswParams());
                } else {
                    showBottomSheet();
                    pswOnConfirm(etPsw.getText().toString());
                }
                break;
        }
    }

    protected abstract void pswOnConfirm(String psw);

    protected abstract Observer<WalletAccountValiatePayPasswordResponseModel> getPswValiate();

    protected WalletAccountValiatePayPasswordRequestModel setPswParams() {
        WalletAccountValiatePayPasswordRequestModel walletAccountValiatePayPasswordRequestModel = new WalletAccountValiatePayPasswordRequestModel();
        walletAccountValiatePayPasswordRequestModel.setToken(BaseApplication.getToken());
        walletAccountValiatePayPasswordRequestModel.setCmd(ApiInterface.WalletAccountValiatePayPassword);
        walletAccountValiatePayPasswordRequestModel.setParameters(new WalletAccountValiatePayPasswordRequestModel.ParametersEntity(etPsw.getText().toString()));
        return walletAccountValiatePayPasswordRequestModel;
    }
}
