package com.example.climbersbeta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class BulletinAdapter extends RecyclerView.Adapter<BulletinAdapter.BulletinViewHolder> {

    Context context;
    List<String> bulletinPostPageList;

    // inflates the row layout and initializes the view holder
    @NonNull
    @Override
    public BulletinAdapter.BulletinViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_forum, viewGroup, false);
        return new BulletinViewHolder(view);
    }

    // uses the view holder from onCreateViewHolder() method to populate
    // the current row of the recycler view with data
    @Override
    public void onBindViewHolder(@NonNull BulletinAdapter.BulletinViewHolder holder, int i) {
        String bulletinPostPage = bulletinPostPageList.get(i);
        holder.tvForum.setText(bulletinPostPage);
    }

    @Override
    public int getItemCount() {
        return bulletinPostPageList.size();
    }

    public BulletinAdapter(Context context, List<String> bulletinPostPageList){
        this.context = context;
        this.bulletinPostPageList = bulletinPostPageList;
    }

    class BulletinViewHolder extends RecyclerView.ViewHolder {

        // have to create an item xml for bulletin page
        // also have to change the tvForum, but leaving it for now
        TextView tvForum;

        public BulletinViewHolder(View v) {
            super(v);
            tvForum = v.findViewById(R.id.tvForum);
        }

    }
}
