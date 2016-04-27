package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;

import com.cmbb.smartkids.recyclerview.adapter.BaseViewHolder;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.home.model.UserAttentionModel;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class UserCenterItemHolder extends BaseViewHolder<UserAttentionModel.ResponseEntity.DataEntity.RowsEntity> {
    private final String TAG = UserCenterItemHolder.class.getSimpleName();

    public UserCenterItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_user_center_list_item);
    }

    public void setData(UserAttentionModel.ResponseEntity.DataEntity.RowsEntity row) {

    }
}
