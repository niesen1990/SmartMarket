package com.cmbb.smartmarket.utils;

import android.app.Activity;
import android.widget.Toast;

import com.cmbb.smartmarket.log.Log;
import com.umeng.socialize.ShareAction;
import com.umeng.socialize.UMAuthListener;
import com.umeng.socialize.UMShareAPI;
import com.umeng.socialize.UMShareListener;
import com.umeng.socialize.bean.SHARE_MEDIA;
import com.umeng.socialize.media.UMImage;
import com.umeng.socialize.shareboard.SnsPlatform;
import com.umeng.socialize.utils.ShareBoardlistener;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/4/27 下午3:39
 */
public class SocialUtils {

    /**
     * 第三方登陆授权
     * 注意： @Override
     * protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     * super.onActivityResult(requestCode, resultCode, data);
     * mShareAPI.onActivityResult(requestCode, resultCode, data);
     * }
     *
     * @param context        Activity
     * @param platform       SHARE_MEDIA
     * @param umAuthListener UMAuthListener
     */
    public static void OAuth(Activity context, SHARE_MEDIA platform, UMAuthListener umAuthListener) {
        UMShareAPI mShareAPI = UMShareAPI.get(context);
        mShareAPI.doOauthVerify(context, platform, umAuthListener);
       /* private UMAuthListener umAuthListener = new UMAuthListener() {
            @Override
            public void onComplete(SHARE_MEDIA platform, int action, Map<String, String> data) {
                Toast.makeText(getApplicationContext(), "Authorize succeed", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onError(SHARE_MEDIA platform, int action, Throwable t) {
                Toast.makeText(getApplicationContext(), "Authorize fail", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onCancel(SHARE_MEDIA platform, int action) {
                Toast.makeText(getApplicationContext(), "Authorize cancel", Toast.LENGTH_SHORT).show();
            }
        };*/
    }

    /**
     * 取消授权
     *
     * @param context        Activity
     * @param platform       SHARE_MEDIA
     * @param umAuthListener UMAuthListener
     */
    public static void deleteOAuth(Activity context, SHARE_MEDIA platform, UMAuthListener umAuthListener) {
        UMShareAPI mShareAPI = UMShareAPI.get(context);
        mShareAPI.deleteOauth(context, platform, umAuthListener);
    }

    /**
     * 分享
     * 注意：@Override
     * protected void onActivityResult(int requestCode, int resultCode, Intent data) {
     * super.onActivityResult(requestCode, resultCode, data);
     * UMShareAPI.get( this ).onActivityResult( requestCode, resultCode, data);
     * }
     *
     * @param context
     * @param title
     * @param content
     * @param targetUrl
     */
    public static void share(final Activity context, String imageUrl, final String title, final String content, final String targetUrl) {
        final UMImage image = new UMImage(context, imageUrl);
        new ShareAction(context).setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.SINA)
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                        if (snsPlatform.mShowWord.equals("umeng_sharebutton_custom")) {
                            Toast.makeText(context, "自定义按钮", Toast.LENGTH_LONG).show();
                        } else {
                            new ShareAction(context).withText("来自萌宝铺子的分享")
                                    .setPlatform(share_media)
                                    .withTitle(title)
                                    .withText(content)
                                    .withMedia(image)
                                    .withTargetUrl(targetUrl)
                                    .setCallback(new UMShareListener() {
                                        @Override
                                        public void onResult(SHARE_MEDIA platform) {
                                            Log.d("plat", "platform" + platform);
                                            Toast.makeText(context, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onError(SHARE_MEDIA platform, Throwable t) {
                                            Log.e("onError", t.getMessage());
                                            Toast.makeText(context, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onCancel(SHARE_MEDIA platform) {
                                            Toast.makeText(context, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .share();
                        }
                    }
                }).open();
    }

    public static void share(final Activity context, int imageUrl, final String title, final String content, final String targetUrl) {
        final UMImage image = new UMImage(context, imageUrl);
        new ShareAction(context).setDisplayList(SHARE_MEDIA.WEIXIN, SHARE_MEDIA.WEIXIN_CIRCLE, SHARE_MEDIA.QQ, SHARE_MEDIA.QZONE, SHARE_MEDIA.SINA)
                .setShareboardclickCallback(new ShareBoardlistener() {
                    @Override
                    public void onclick(SnsPlatform snsPlatform, SHARE_MEDIA share_media) {
                        if (snsPlatform.mShowWord.equals("umeng_sharebutton_custom")) {
                            Toast.makeText(context, "自定义按钮", Toast.LENGTH_LONG).show();
                        } else {
                            new ShareAction(context).withText("来自萌宝铺子的分享")
                                    .setPlatform(share_media)
                                    .withTitle(title)
                                    .withText(content)
                                    .withMedia(image)
                                    .withTargetUrl(targetUrl)
                                    .setCallback(new UMShareListener() {
                                        @Override
                                        public void onResult(SHARE_MEDIA platform) {
                                            Log.d("plat", "platform" + platform);
                                            Toast.makeText(context, platform + " 分享成功啦", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onError(SHARE_MEDIA platform, Throwable t) {
                                            Log.e("onError", t.getMessage());
                                            Toast.makeText(context, platform + " 分享失败啦", Toast.LENGTH_SHORT).show();
                                        }

                                        @Override
                                        public void onCancel(SHARE_MEDIA platform) {
                                            Toast.makeText(context, platform + " 分享取消了", Toast.LENGTH_SHORT).show();
                                        }
                                    })
                                    .share();

                        }
                    }
                }).open();
    }

}
