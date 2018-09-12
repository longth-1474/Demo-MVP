package hoanglong.framgia.com.mvpandroid.data.repository;

import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;
import hoanglong.framgia.com.mvpandroid.data.source.CallBack;
import hoanglong.framgia.com.mvpandroid.data.source.HomeDataSource;
import hoanglong.framgia.com.mvpandroid.data.source.remote.HomeRemoteDataSource;

public class HomeRepository implements HomeDataSource.localDataSource, HomeDataSource.remoteDataSource {

    private static HomeRepository mInstance;
    private HomeRemoteDataSource mHomeRemoteDataSource;

    private HomeRepository(HomeRemoteDataSource mHomeRemoteDataSource) {
        this.mHomeRemoteDataSource = mHomeRemoteDataSource;
    }

    public static HomeRepository getInstance(HomeRemoteDataSource mHomeRemoteDataSource) {
        if (mInstance == null)
            mInstance = new HomeRepository(mHomeRemoteDataSource);
        return mInstance;
    }

    @Override
    public void getPlayList(CallBack<MessageHome> callBack) {
        mHomeRemoteDataSource.getPlayList(callBack);
    }
}
