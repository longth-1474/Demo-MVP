package hoanglong.framgia.com.mvpandroid.data.source;

import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;

public interface HomeDataSource {
    interface remoteDataSource {
        void getPlayList(CallBack<MessageHome> callBack);
    }

    interface localDataSource {

    }
}
