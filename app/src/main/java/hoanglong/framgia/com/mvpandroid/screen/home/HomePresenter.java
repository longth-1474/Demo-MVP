package hoanglong.framgia.com.mvpandroid.screen.home;

import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;
import hoanglong.framgia.com.mvpandroid.data.repository.HomeRepository;
import hoanglong.framgia.com.mvpandroid.data.source.CallBack;

public class HomePresenter implements HomeContract.Presenter {

    private HomeContract.View mView;
    private HomeRepository mHomeRepository;

    public HomePresenter(HomeRepository mHomeRepository) {
        this.mHomeRepository = mHomeRepository;
    }

    @Override
    public void setView(HomeContract.View view) {
        mView = view;
    }

    @Override
    public void onStart() {

    }

    @Override
    public void onStop() {

    }

    @Override
    public void getListHomeData() {
        mHomeRepository.getPlayList(new CallBack<MessageHome>() {
            @Override
            public void getDataSuccess(MessageHome data) {
                mView.onGetDataSuccess(data);
                mView.hideProgressBar();
            }

            @Override
            public void getDataFailure(Exception e) {
                e.printStackTrace();
            }
        });
    }
}
