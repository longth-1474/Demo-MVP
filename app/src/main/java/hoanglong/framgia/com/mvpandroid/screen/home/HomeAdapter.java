package hoanglong.framgia.com.mvpandroid.screen.home;

import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import hoanglong.framgia.com.mvpandroid.R;
import hoanglong.framgia.com.mvpandroid.data.model.ItemHome;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

    private ArrayList<ItemHome> mItemPlaylists;
    private View.OnClickListener onClickListener;

    public HomeAdapter(ArrayList<ItemHome> mItemPlaylists) {
        this.mItemPlaylists = mItemPlaylists;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.onClickListener = onClickListener;
    }

    @NonNull
    @Override
    public HomeAdapter.HomeViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_home, viewGroup, false);
        view.setOnClickListener(onClickListener);
        return new HomeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.HomeViewHolder homeViewHolder, int i) {
        ItemHome mItemPlaylist = mItemPlaylists.get(i);
        homeViewHolder.mTextHome.setText(mItemPlaylist.getmTitle());
        homeViewHolder.mImageHome.setImageURI(Uri.parse(mItemPlaylist.getmImage()));
        homeViewHolder.mView.setTag(mItemPlaylist);
    }

    @Override
    public int getItemCount() {
        return mItemPlaylists.size();
    }

    class HomeViewHolder extends RecyclerView.ViewHolder {

        private ImageView mImageHome;
        private TextView mTextHome;
        private View mView;

        HomeViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageHome = itemView.findViewById(R.id.image_home);
            mTextHome = itemView.findViewById(R.id.text_home);
            mView = itemView;
        }
    }
}
