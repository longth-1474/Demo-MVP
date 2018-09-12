package hoanglong.framgia.com.mvpandroid.data.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class MessageHome implements Parcelable {
    private String mTitle;
    private ArrayList<ItemHome> mItemHomes;

    public MessageHome(String mTitle, ArrayList<ItemHome> mItemHomes) {
        this.mTitle = mTitle;
        this.mItemHomes = mItemHomes;
    }

    public MessageHome(ArrayList<ItemHome> mItemHomes) {
        this.mItemHomes = mItemHomes;
    }

    private MessageHome(MessageHomeBuilder mBuilder) {
        mTitle = mBuilder.mTitle;
        mItemHomes = mBuilder.mItemHomes;
    }

    private MessageHome(Parcel in) {
        mTitle = in.readString();
        mItemHomes = in.createTypedArrayList(ItemHome.CREATOR);
    }

    public static final Creator<MessageHome> CREATOR = new Creator<MessageHome>() {
        @Override
        public MessageHome createFromParcel(Parcel in) {
            return new MessageHome(in);
        }

        @Override
        public MessageHome[] newArray(int size) {
            return new MessageHome[size];
        }
    };

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public ArrayList<ItemHome> getmItemHomes() {
        return mItemHomes;
    }

    public void setmItemHomes(ArrayList<ItemHome> mItemHomes) {
        this.mItemHomes = mItemHomes;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(mTitle);
        parcel.writeTypedList(mItemHomes);
    }

    public static class MessageHomeBuilder {
        private String mTitle;
        private ArrayList<ItemHome> mItemHomes;

        public MessageHomeBuilder setmTitle(String mTitle) {
            this.mTitle = mTitle;
            return this;
        }

        public MessageHomeBuilder setmItemHomes(ArrayList<ItemHome> mItemHomes) {
            this.mItemHomes = mItemHomes;
            return this;
        }

        public MessageHome build() {
            return new MessageHome(this);
        }
    }
}
