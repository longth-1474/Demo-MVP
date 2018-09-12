package hoanglong.framgia.com.mvpandroid.data.source.remote;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

import hoanglong.framgia.com.mvpandroid.data.model.ItemHome;
import hoanglong.framgia.com.mvpandroid.utils.Constants;

public class FetchDataFromApi {
    public static String getJsonStringFromUrl(String urlString) throws IOException {
        HttpURLConnection mUrlConnection;
        URL mUrl = new URL(urlString);
        mUrlConnection = (HttpURLConnection) mUrl.openConnection();
        mUrlConnection.setRequestMethod(Constants.JsonKey.METHOD_GET);
        mUrlConnection.setReadTimeout(Constants.JsonKey.READ_TIME_OUT);
        mUrlConnection.setConnectTimeout(Constants.JsonKey.CONNECTION_TIME_OUT);
        mUrlConnection.setDoOutput(true);
        mUrlConnection.connect();
        BufferedReader mBufferReader = new BufferedReader(new InputStreamReader(mUrl.openStream()));
        StringBuilder mStringBuilder = new StringBuilder();
        String mLine;
        while ((mLine = mBufferReader.readLine()) != null) {
            mStringBuilder.append(mLine).append("\n");
        }
        mBufferReader.close();
        String mJsonString = mStringBuilder.toString();
        mUrlConnection.disconnect();
        return mJsonString;
    }

    public static ArrayList<ItemHome> getDataHome(String mJson) throws JSONException {
        ArrayList<ItemHome> mListHome = new ArrayList<>();
        JSONObject mRoot = new JSONObject(mJson);
        JSONObject mMessage = mRoot.getJSONObject(Constants.Home.MESSAGE);
        JSONArray mArray = mMessage.getJSONArray(Constants.Home.ARRAY);
        for (int i = 0; i < mArray.length(); i++) {
            JSONObject mJsonObject = mArray.getJSONObject(i);
            ItemHome mItemHome = new ItemHome(mJsonObject);
            mListHome.add(mItemHome);
        }
        return mListHome;
    }
}
