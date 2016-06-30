package com.cmbb.smartmarket.image.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.cmbb.smartmarket.R;
import com.cmbb.smartmarket.base.BaseFragment;
import com.cmbb.smartmarket.image.model.ImageModel;
import com.cmbb.smartmarket.utils.DialogUtils;

import uk.co.senab.photoview.PhotoView;
import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/27 下午4:56
 * 修改人：N.Sun
 * 修改时间：16/6/27 下午4:56
 * 修改备注：
 */
public class ImageFragment extends BaseFragment {
    private PhotoView mImageView;
    private ProgressBar mProgressBar;

    public static ImageFragment newInstance(ImageModel productImageList) {
        ImageFragment fragment = new ImageFragment();
        Bundle args = new Bundle();
        args.putParcelable("productImageList", productImageList);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected void initView(View view) {
        mImageView = (PhotoView) view.findViewById(R.id.iv_photo);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progressBar);
        mImageView.setOnPhotoTapListener(new PhotoViewAttacher.OnPhotoTapListener() {
            @Override
            public void onPhotoTap(View view, float x, float y) {
                getActivity().onBackPressed();
            }

            @Override
            public void onOutsidePhotoTap() {

            }
        });
        mImageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                DialogUtils.createAlertDialog(getActivity(), "操作", "保存", true, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        showToast("保存成功");
                    }
                });
                return true;
            }
        });
        if (getArguments().getParcelable("productImageList") != null)
            Glide.with(this)
                    .load(((ImageModel) getArguments().getParcelable("productImageList")).getLocation())
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String s, Target<GlideDrawable> target, boolean b) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable glideDrawable, String s, Target<GlideDrawable> target, boolean b, boolean b1) {
                            mProgressBar.setVisibility(View.GONE);
                            return false;
                        }
                    })
                    .diskCacheStrategy(DiskCacheStrategy.ALL)
                    .into(mImageView);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_image_layout;
    }
}
