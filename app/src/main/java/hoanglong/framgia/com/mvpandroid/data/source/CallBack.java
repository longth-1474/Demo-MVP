package hoanglong.framgia.com.mvpandroid.data.source;

public interface CallBack<T> {
    void getDataSuccess(T data);

    void getDataFailure(Exception e);
}
