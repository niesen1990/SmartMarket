package com.cmbb.smartmarket.activity.message;

import com.cmbb.smartmarket.activity.home.model.MarketMessageSetMessageTypeRequestModel;
import com.cmbb.smartmarket.activity.home.model.MarketMessageSetMessageTypeResponseModel;
import com.cmbb.smartmarket.base.BaseApplication;
import com.cmbb.smartmarket.base.BaseRecyclerActivity;
import com.cmbb.smartmarket.log.Log;
import com.cmbb.smartmarket.network.ApiInterface;
import com.cmbb.smartmarket.network.HttpMethod;

import rx.Observer;

/**
 * 项目名称：SmartMarket
 * 类描述：
 * 创建人：N.Sun
 * 创建时间：16/6/5 下午5:42
 * 修改人：N.Sun
 * 修改时间：16/6/5 下午5:42
 * 修改备注：
 */
public abstract class BaseMessageActivity extends BaseRecyclerActivity {
    private static final String TAG = BaseMessageActivity.class.getSimpleName();

    Observer<MarketMessageSetMessageTypeResponseModel> mMarketMessageSetMessageTypeResponseModel = new Observer<MarketMessageSetMessageTypeResponseModel>() {
        @Override
        public void onCompleted() {

        }

        @Override
        public void onError(Throwable e) {
            Log.e(TAG, e.toString());
        }

        @Override
        public void onNext(MarketMessageSetMessageTypeResponseModel marketMessageSetMessageTypeResponseModel) {

        }
    };

    protected void cancelMessage() {
        HttpMethod.getInstance().marketMessageSetMessageType(mMarketMessageSetMessageTypeResponseModel, setCancelParams());
    }

    protected MarketMessageSetMessageTypeRequestModel setCancelParams() {
        MarketMessageSetMessageTypeRequestModel marketMessageSetMessageTypeRequestModel = new MarketMessageSetMessageTypeRequestModel();
        marketMessageSetMessageTypeRequestModel.setCmd(ApiInterface.MarketMessageSetMessageType);
        marketMessageSetMessageTypeRequestModel.setToken(BaseApplication.getToken());
        marketMessageSetMessageTypeRequestModel.setParameters(new MarketMessageSetMessageTypeRequestModel.ParametersEntity(getIntent().getIntExtra("id", -1)));
        return marketMessageSetMessageTypeRequestModel;
    }

}
