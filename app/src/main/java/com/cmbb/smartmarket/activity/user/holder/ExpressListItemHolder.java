package com.cmbb.smartmarket.activity.user.holder;

import android.view.ViewGroup;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.SystemDictListResponseModel;
import com.jude.easyrecyclerview.adapter.BaseViewHolder;

/**
 * 项目名称：LovelyBaby
 * 类描述：
 * 创建人：javon
 * 创建时间：2015/8/24 14:25
 */
public class ExpressListItemHolder extends BaseViewHolder<SystemDictListResponseModel.DataEntity> {
    private final String TAG = ExpressListItemHolder.class.getSimpleName();
    TextView title;

    public ExpressListItemHolder(ViewGroup parent) {
        super(parent, R.layout.activity_express_list_item);
        title = $(R.id.title);
    }

    public void setData(SystemDictListResponseModel.DataEntity row) {
        if (row == null)
            return;
        title.setText(row.getName());
    }
}
