package hoanglong.framgia.com.mvpandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import org.json.JSONException;
import org.json.JSONObject;

import hoanglong.framgia.com.mvpandroid.utils.Constants;

public class ItemHome implements Parcelable {
    private int mId;
    private String mIdPlayList;
    private String mTitle;
    private String mCountry;
    private String mImage;
    private int mCount;
    private int mSort;
    private String mType;

    private ItemHome(Parcel in) {
        mId = in.readInt();
        mIdPlayList = in.readString();
        mTitle = in.readString();
        mCountry = in.readString();
        mImage = in.readString();
        mCount = in.readInt();
        mSort = in.readInt();
        mType = in.readString();
    }

    public ItemHome(JSONObject jsonObject) throws JSONException {
        mId = jsonObject.getInt(Constants.Home.ID);
        mIdPlayList = jsonObject.getString(Constants.Home.ID_PLAYLIST);
        mTitle = jsonObject.getString(Constants.Home.TITLE);
        mCountry = jsonObject.getString(Constants.Home.COUNTRY);
        mImage = jsonObject.getString(Constants.Home.IMAGE);
        mCount = jsonObject.getInt(Constants.Home.COUNT);
        mSort = jsonObject.getInt(Constants.Home.SORT);
        mType = jsonObject.getString(Constants.Home.TYPE);
    }

    public ItemHome(ItemHomeBuilder mItemHomeBuilder) {
        mId = mItemHomeBuilder.mId;
        mIdPlayList = mItemHomeBuilder.mIdPlayList;
        mTitle = mItemHomeBuilder.mTitle;
        mCountry = mItemHomeBuilder.mCountry;
        mImage = mItemHomeBuilder.mImage;
        mCount = mItemHomeBuilder.mCount;
        mSort = mItemHomeBuilder.mSort;
        mType = mItemHomeBuilder.mType;
    }

    public static final Creator<ItemHome> CREATOR = new Creator<ItemHome>() {
        @Override
        public ItemHome createFromParcel(Parcel in) {
            return new ItemHome(in);
        }

        @Override
        public ItemHome[] newArray(int size) {
            return new ItemHome[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(mId);
        parcel.writeString(mIdPlayList);
        parcel.writeString(mTitle);
        parcel.writeString(mCountry);
        parcel.writeString(mImage);
        parcel.writeInt(mCount);
        parcel.writeInt(mSort);
        parcel.writeString(mType);
    }

    public static class ItemHomeBuilder {
        private int mId;
        private String mIdPlayList;
        private String mTitle;
        private String mCountry;
        private String mImage;
        private int mCount;
        private int mSort;
        private String mType;

        public ItemHomeBuilder setmId(int mId) {
            this.mId = mId;
            return this;
        }

        public ItemHomeBuilder setmIdPlayList(String mIdPlayList) {
            this.mIdPlayList = mIdPlayList;
            return this;
        }

        public ItemHomeBuilder setmTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        public ItemHomeBuilder setmCountry(String mCountry) {
            this.mCountry = mCountry;
            return this;
        }

        public ItemHomeBuilder setmImage(String mImage) {
            this.mImage = mImage;
            return this;
        }

        public ItemHomeBuilder setmCount(int mCount) {
            this.mCount = mCount;
            return this;
        }

        public ItemHomeBuilder setmSort(int mSort) {
            this.mSort = mSort;
            return this;
        }

        public ItemHomeBuilder setmType(String mType) {
            this.mType = mType;
            return this;
        }
    }

    public int getmId() {
        return mId;
    }

    public void setmId(int mId) {
        this.mId = mId;
    }

    public String getmIdPlayList() {
        return mIdPlayList;
    }

    public void setmIdPlayList(String mIdPlayList) {
        this.mIdPlayList = mIdPlayList;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public String getmCountry() {
        return mCountry;
    }

    public void setmCountry(String mCountry) {
        this.mCountry = mCountry;
    }

    public String getmImage() {
        return mImage;
    }

    public void setmImage(String mImage) {
        this.mImage = mImage;
    }

    public int getmCount() {
        return mCount;
    }

    public void setmCount(int mCount) {
        this.mCount = mCount;
    }

    public int getmSort() {
        return mSort;
    }

    public void setmSort(int mSort) {
        this.mSort = mSort;
    }

    public String getmType() {
        return mType;
    }

    public void setmType(String mType) {
        this.mType = mType;
    }
}
