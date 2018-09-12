package hoanglong.framgia.com.mvpandroid.screen.home;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;

import hoanglong.framgia.com.mvpandroid.R;
import hoanglong.framgia.com.mvpandroid.data.model.ItemHome;
import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;
import hoanglong.framgia.com.mvpandroid.data.repository.HomeRepository;
import hoanglong.framgia.com.mvpandroid.data.source.remote.HomeRemoteDataSource;
import hoanglong.framgia.com.mvpandroid.screen.base.BaseActivity;

public class MainActivity extends BaseActivity implements HomeContract.View {

    private RecyclerView mRecyclerHome;
    private ProgressBar mProgressBar;
    private HomePresenter mHomePresent;

    @Override
    protected int getLayoutResources() {
        return R.layout.activity_main;
    }

    @Override
    protected void initComponent() {
        mRecyclerHome = findViewById(R.id.recycler_home);
        mProgressBar = findViewById(R.id.progress_bar);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mHomePresent = new HomePresenter(HomeRepository.getInstance(HomeRemoteDataSource.getInstance()));
        mHomePresent.setView(this);
        loadData();
    }

    private void loadData() {
        mHomePresent.getListHomeData();
    }

    @Override
    public void onGetDataSuccess(MessageHome messageHome) {
        initRecyclerView(messageHome.getmItemHomes());
    }

    private void initRecyclerView(ArrayList<ItemHome> itemHomes) {
        HomeAdapter mHomeAdapter = new HomeAdapter(itemHomes);
        mRecyclerHome.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        mRecyclerHome.setHasFixedSize(true);
        mRecyclerHome.setAdapter(mHomeAdapter);
    }

    @Override
    public void hideProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
