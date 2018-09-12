package hoanglong.framgia.com.mvpandroid.screen.base;

public interface BasePresenter<T> {
    void setView(T view);

    void onStart();

    void onStop();
}
