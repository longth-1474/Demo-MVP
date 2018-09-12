package hoanglong.framgia.com.mvpandroid.screen.home;

import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;
import hoanglong.framgia.com.mvpandroid.screen.base.BasePresenter;

public class HomeContract {
    interface View {
        void onGetDataSuccess(MessageHome messageHome);

        void hideProgressBar();
    }

    interface Presenter extends BasePresenter<View> {
        void getListHomeData();
    }
}
