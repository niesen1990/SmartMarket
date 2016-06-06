package com.cmbb.smartmarket.activity.home.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.market.model.ProductGetPageResponseModel;

import java.util.ArrayList;
import java.util.List;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/5/12 下午3:21
 * 修改人：N.Sun
 * 修改时间：16/5/12 下午3:21
 * 修改备注：
 */
public class ViewFlipperAdapter extends BaseAdapter {

    private List<ProductGetPageResponseModel.DataEntity.ContentEntity> mRowsEntities;

    public ViewFlipperAdapter() {
        mRowsEntities = new ArrayList<>();
    }

    public void updateEntities(List<ProductGetPageResponseModel.DataEntity.ContentEntity> rowsEntities) {
        if (rowsEntities != null) {
            mRowsEntities.clear();
            mRowsEntities.addAll(rowsEntities);
        }
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mRowsEntities.size();
    }

    @Override
    public ProductGetPageResponseModel.DataEntity.ContentEntity getItem(int position) {
        return mRowsEntities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_home_head_flipper_item, null);
            holder = new ViewHolder();
            holder.tv_head_zan_content = (TextView) convertView.findViewById(R.id.tv_head_zan_content);
            holder.tv_head_xin_content = (TextView) convertView.findViewById(R.id.tv_head_xin_content);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.tv_head_zan_content.setText(getItem(position).getTitle());
        if (position + 1 == getCount()) {
            holder.tv_head_xin_content.setText(getItem(0).getTitle());
        } else {
            holder.tv_head_xin_content.setText(getItem(position + 1).getTitle());
        }
        return convertView;
    }

    class ViewHolder {
        public TextView tv_head_zan_content;
        public TextView tv_head_xin_content;
    }
}
