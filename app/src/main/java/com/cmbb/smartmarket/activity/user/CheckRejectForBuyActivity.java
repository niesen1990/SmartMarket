package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.model.MarketOrderDetailResponseModel;
import com.cmbb.smartmarket.activity.user.model.MarketOrderListResponseModel;
import com.cmbb.smartmarket.base.BaseActivity;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/31 上午9:46
 * 修改人：N.Sun
 * 修改时间：16/5/31 上午9:46
 * 修改备注：
 */
public class CheckRejectForBuyActivity extends BaseActivity {
    private static final String TAG = CheckRejectForBuyActivity.class.getSimpleName();

    @BindView(R.id.tv_reason)
    TextView tvReason;
    @BindView(R.id.tv_apply)
    TextView tvApply;
    @BindView(R.id.tv_contact)
    TextView tvContact;

    MarketOrderListResponseModel.DataEntity.ContentEntity data;
    MarketOrderDetailResponseModel dataFormDetail;

    @Override
    protected void init(Bundle savedInstanceState) {
        setTitle("查看拒绝原因");
        if (getIntent().getParcelableExtra("entity") instanceof MarketOrderListResponseModel.DataEntity.ContentEntity) {
            data = getIntent().getParcelableExtra("entity");
        } else {
            dataFormDetail = getIntent().getParcelableExtra("entity");
        }
        tvApply.setOnClickListener(this);
        tvContact.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.tv_apply:
                if (data != null) {
                    ApplyRefundActivity.newIntent(this, data);
                } else {
                    ApplyRefundActivity.newIntent(this, dataFormDetail);
                }
                break;
            case R.id.tv_contact:
                // TODO: 16/5/31 联系客服

                break;
        }
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_check_reject_layout;
    }

    public static void newIntent(Context context, MarketOrderListResponseModel.DataEntity.ContentEntity entity) {
        Intent intent = new Intent(context, CheckRejectForBuyActivity.class);
        intent.putExtra("data", entity);
        context.startActivity(intent);
    }

    public static void newIntent(Context context, MarketOrderDetailResponseModel entity) {
        Intent intent = new Intent(context, CheckRejectForBuyActivity.class);
        intent.putExtra("data", entity);
        context.startActivity(intent);
    }
}
