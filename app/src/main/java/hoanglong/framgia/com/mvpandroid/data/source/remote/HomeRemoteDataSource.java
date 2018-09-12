package hoanglong.framgia.com.mvpandroid.data.source.remote;

import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;
import hoanglong.framgia.com.mvpandroid.data.source.CallBack;
import hoanglong.framgia.com.mvpandroid.data.source.HomeDataSource;
import hoanglong.framgia.com.mvpandroid.utils.Constants;

public class HomeRemoteDataSource implements HomeDataSource.remoteDataSource {

    public static HomeRemoteDataSource mInstance;

    public static HomeRemoteDataSource getInstance() {
        if (mInstance == null)
            mInstance = new HomeRemoteDataSource();
        return mInstance;
    }

    private void getDataHomeFormApi(CallBack<MessageHome> mCallBack) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(Constants.Api.BASE_URL)
                .append(Constants.Api.DATA_HOME);
        String url = stringBuilder.toString();
        new HomeRemoteAsyncTask(mCallBack).execute(url);
    }

    @Override
    public void getPlayList(CallBack<MessageHome> callBack) {
        getDataHomeFormApi(callBack);
    }
}
