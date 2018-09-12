package hoanglong.framgia.com.mvpandroid.data.source.remote;

import android.os.AsyncTask;

import org.json.JSONException;

import java.io.IOException;
import java.util.ArrayList;

import hoanglong.framgia.com.mvpandroid.data.model.ItemHome;
import hoanglong.framgia.com.mvpandroid.data.model.MessageHome;
import hoanglong.framgia.com.mvpandroid.data.source.CallBack;

public class HomeRemoteAsyncTask extends AsyncTask<String, String, ArrayList<ItemHome>> {

    private CallBack<MessageHome> mCallBack;
    private Exception mException;

    HomeRemoteAsyncTask(CallBack<MessageHome> mCallBack) {
        this.mCallBack = mCallBack;
    }

    @Override
    protected ArrayList<ItemHome> doInBackground(String... strings) {
        ArrayList<ItemHome> mListHome = new ArrayList<>();
        try {
            String mJson = FetchDataFromApi.getJsonStringFromUrl(strings[0]);
            mListHome = FetchDataFromApi.getDataHome(mJson);
        } catch (IOException | JSONException e) {
            e.printStackTrace();
            mException = e;
        }
        return mListHome;
    }

    @Override
    protected void onPostExecute(ArrayList<ItemHome> itemHomes) {
        super.onPostExecute(itemHomes);
        if (mCallBack == null) {
            return;
        }

        if (mException == null) {
            mCallBack.getDataSuccess(new MessageHome(itemHomes));
        } else {
            mCallBack.getDataFailure(mException);
        }
    }
}
