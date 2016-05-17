package com.cmbb.smartmarket.activity.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.activity.user.adapter.UserCenterFragmentAdapter;
import com.cmbb.smartmarket.base.BaseActivity;
import com.cmbb.smartmarket.widget.MengCoordinatorLayout;

import butterknife.BindView;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/26 下午7:03
 */
public class UserCenterActivity extends BaseActivity implements AppBarLayout.OnOffsetChangedListener {

    private static final String TAG = UserCenterActivity.class.getSimpleName();

    @BindView(R.id.main_content)
    MengCoordinatorLayout mainContent;
    @BindView(R.id.abl)
    AppBarLayout abl;
    @BindView(R.id.iv_home_myself)
    RelativeLayout ivHomeMyself;
    @BindView(R.id.iv_head)
    ImageView ivHead;
    @BindView(R.id.tv_nick)
    TextView tvNick;
    @BindView(R.id.ratingBar)
    RatingBar ratingBar;
    @BindView(R.id.ll_bottom)
    LinearLayout llBottom;
    @BindView(R.id.ll_collection)
    LinearLayout llCollection;
    @BindView(R.id.tv_collection_count)
    TextView tvCollectionCount;
    @BindView(R.id.tv_collection_count_tag)
    TextView tvCollectionCountTag;
    @BindView(R.id.tv_collectio_name)
    TextView tvCollectioName;
    @BindView(R.id.ll_deal)
    LinearLayout llDeal;
    @BindView(R.id.tv_deal_count)
    TextView tvDealCount;
    @BindView(R.id.tv_deal_count_tag)
    TextView tvDealCountTag;
    @BindView(R.id.tv_deal_name)
    TextView tvDealName;
    @BindView(R.id.ll_evaluate)
    LinearLayout llEvaluate;
    @BindView(R.id.tv_evaluate_count)
    TextView tvEvaluateCount;
    @BindView(R.id.tv_evaluate_count_tag)
    TextView tvEvaluateCountTag;
    @BindView(R.id.tv_evaluate_name)
    TextView tvEvaluateName;
    @BindView(R.id.tablayout)
    TabLayout tablayout;
    @BindView(R.id.viewpager)
    ViewPager viewpager;

    UserCenterFragmentAdapter mUserCenterFragmentAdapter;

    @Override
    protected void init(Bundle savedInstanceState) {
        mUserCenterFragmentAdapter = new UserCenterFragmentAdapter(getSupportFragmentManager(), this);
        viewpager.setAdapter(mUserCenterFragmentAdapter);
        tablayout.setupWithViewPager(viewpager);
        tablayout.setTabMode(TabLayout.MODE_FIXED);
        llEvaluate.setOnClickListener(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_user_center_layout;
    }

    @Override
    public void onClick(View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.ll_evaluate:
                EvaluateListActivity.newIntent(this);
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (abl != null)
            abl.addOnOffsetChangedListener(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (abl != null)
            abl.removeOnOffsetChangedListener(this);
    }

    @Override
    public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
        if (mUserCenterFragmentAdapter.getCurrentFragment().getSmartRecyclerView() == null)
            return;
        if (verticalOffset >= 0) {
            mUserCenterFragmentAdapter.getCurrentFragment().getSmartRecyclerView().getSwipeToRefresh().setEnabled(true);
        } else {
            mUserCenterFragmentAdapter.getCurrentFragment().getSmartRecyclerView().getSwipeToRefresh().setEnabled(false);
        }
    }

    /**
     * @param context Context
     * @param id      UserId
     */
    public static void newIntent(Context context, int id) {
        Intent intent = new Intent(context, UserCenterActivity.class);
        intent.putExtra("id", id);
        context.startActivity(intent);
    }
}
