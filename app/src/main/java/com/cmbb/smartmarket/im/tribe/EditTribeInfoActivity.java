package com.cmbb.smartmarket.im.tribe;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.alibaba.mobileim.YWIMKit;
import com.alibaba.mobileim.channel.event.IWxCallback;
import com.alibaba.mobileim.fundamental.widget.WXNetworkImageView;
import com.alibaba.mobileim.gingko.model.tribe.YWTribe;
import com.alibaba.mobileim.gingko.model.tribe.YWTribeType;
import com.alibaba.mobileim.tribe.IYWTribeService;
import com.alibaba.mobileim.tribe.YWTribeCreationParam;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.im.IMLoginHelper;
import com.cmbb.smartmarket.im.commom.Notification;

import java.util.ArrayList;
import java.util.List;

public class EditTribeInfoActivity extends BaseActivity {

    private YWIMKit mIMKit;
    private IYWTribeService mTribeService;
    private String mTribeOp;
    private long mTribeId;
    private String mTribeType;

    private EditText mTribeName;
    private EditText mTribeNotice;

    private String oldTribeName;
    private String oldTribeNotice;
    private ModifyTribeInfoCallback callback;


    @Override
    protected void init(Bundle savedInstanceState) {
        init();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.im_activity_edit_tribe_info;
    }

    private void init() {
        mIMKit = IMLoginHelper.getInstance().getIMKit();
        mTribeService = mIMKit.getTribeService();

        mTribeOp = getIntent().getStringExtra(TribeConstants.TRIBE_OP);
        if (mTribeOp.equals(TribeConstants.TRIBE_CREATE)){  //创建群
            mTribeType = getIntent().getStringExtra(TribeConstants.TRIBE_TYPE);
        } else if(mTribeOp.equals(TribeConstants.TRIBE_EDIT)){ //编辑群信息
            mTribeId = getIntent().getLongExtra(TribeConstants.TRIBE_ID, 0);
        }

        WXNetworkImageView headView = (WXNetworkImageView) findViewById(R.id.head);

        mTribeName = (EditText) findViewById(R.id.tribe_name);
        mTribeNotice = (EditText) findViewById(R.id.tribe_description);
        YWTribe tribe = mTribeService.getTribe(mTribeId);
        if (tribe != null) {
            oldTribeName = tribe.getTribeName();
            oldTribeNotice = tribe.getTribeNotice();
            mTribeName.setText(tribe.getTribeName());
            mTribeNotice.setText(tribe.getTribeNotice());
        }

        initTitle();
    }

    private void initTitle() {
        RelativeLayout titleBar = (RelativeLayout) findViewById(R.id.title_bar);
        titleBar.setBackgroundColor(Color.parseColor("#00b4ff"));
        titleBar.setVisibility(View.VISIBLE);

        TextView titleView = (TextView) findViewById(R.id.title_self_title);
        TextView leftButton = (TextView) findViewById(R.id.left_button);
        leftButton.setCompoundDrawablesWithIntrinsicBounds(R.drawable.im_common_back_btn_white, 0, 0, 0);
        leftButton.setTextColor(Color.WHITE);
        leftButton.setText("返回");
        leftButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        titleView.setTextColor(Color.WHITE);
        if (TextUtils.isEmpty(mTribeType)){
            titleView.setText("编辑群信息");
        } else if (mTribeType.equals(YWTribeType.CHATTING_GROUP.toString())) {
            titleView.setText("创建讨论组");
        } else if (mTribeType.equals(YWTribeType.CHATTING_TRIBE.toString())) {
            titleView.setText("创建群组");
        }

        TextView rightButton = (TextView) findViewById(R.id.right_button);
        rightButton.setText("提交");
        rightButton.setTextColor(Color.WHITE);
        rightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTribeOp.equals(TribeConstants.TRIBE_EDIT)){
                    updateTribeInfo();
                } else if (mTribeType.equals(YWTribeType.CHATTING_GROUP.toString())) {
                    createTribe(YWTribeType.CHATTING_GROUP);
                } else if (mTribeType.equals(YWTribeType.CHATTING_TRIBE.toString())) {
                    createTribe(YWTribeType.CHATTING_TRIBE);
                }
            }
        });
    }

    private void updateTribeInfo() {
        String name = mTribeName.getText().toString();
        String notice = mTribeNotice.getText().toString();
        if(name.equals(oldTribeName) && notice.equals(oldTribeNotice)) {
            //没有修改,不提交服务端
            finish();
            return;
        }
        if(callback == null) {
            callback = new ModifyTribeInfoCallback();
        }
        if(name.equals(oldTribeName) && !notice.equals(oldTribeNotice)) {
            mTribeService.modifyTribeInfo(callback, mTribeId, null, notice);
        } else if(!name.equals(oldTribeName) && notice.equals(oldTribeNotice)) {
            mTribeService.modifyTribeInfo(callback, mTribeId, name, null);
        } else {
            mTribeService.modifyTribeInfo(callback, mTribeId, name, notice);
        }
    }

    private void createTribe(final YWTribeType type) {
        List<String> users = new ArrayList<String>();
        users.add(mIMKit.getIMCore().getLoginUserId());
        YWTribeCreationParam param = new YWTribeCreationParam();
        param.setTribeType(type);
        param.setTribeName(mTribeName.getText().toString());
        param.setNotice(mTribeNotice.getText().toString());
        param.setUsers(users);
        mTribeService.createTribe(new IWxCallback() {
            @Override
            public void onSuccess(Object... result) {
                if (result != null && result.length > 0) {
                    YWTribe tribe = (YWTribe) result[0];
                    if (type.equals(YWTribeType.CHATTING_TRIBE)) {
                        Notification.showToastMsg(EditTribeInfoActivity.this, "创建群组成功！");
                    } else {
                        Notification.showToastMsg(EditTribeInfoActivity.this, "创建讨论组成功！");
                    }
                    Intent intent = new Intent(EditTribeInfoActivity.this, TribeInfoActivity.class);
                    intent.putExtra(TribeConstants.TRIBE_ID, tribe.getTribeId());
                    startActivity(intent);
                    finish();
                }
            }

            @Override
            public void onError(int code, String info) {
                Notification.showToastMsg(EditTribeInfoActivity.this, "创建讨论组失败，code = " + code + ", info = " + info);
            }

            @Override
            public void onProgress(int progress) {

            }
        }, param);
    }

    class ModifyTribeInfoCallback implements IWxCallback {
        @Override
        public void onSuccess(Object... result) {
            Notification.showToastMsg(EditTribeInfoActivity.this, "修改群信息成功！");
            finish();
        }

        @Override
        public void onError(int code, String info) {
            Notification.showToastMsg(EditTribeInfoActivity.this, "修改群信息失败，code = " + code + ", info = " + info);
        }

        @Override
        public void onProgress(int progress) {

        }
    }

}
