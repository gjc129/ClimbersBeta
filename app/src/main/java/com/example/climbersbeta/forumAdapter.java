package com.example.climbersbeta;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class forumAdapter extends RecyclerView.Adapter{

    // method is called when the adapter is created and initializes ViewHolder(s)
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new forumViewHolder(view);
    }

    // method is called for each ViewHolder to bind it to the adapter.
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        ((forumViewHolder) viewHolder).bindData(models.get(i));
    }

    // returns sizez of collection that contains the items we want to display
    @Override
    public int getItemCount() {
        return models.size();
    }

    // returns the view type
    @Override
    public int getItemViewType(final int position){
        return R.layout.compose_forum_post;
    }
}
