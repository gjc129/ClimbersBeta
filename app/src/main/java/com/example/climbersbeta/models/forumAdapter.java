package com.example.climbersbeta.models;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.climbersbeta.MainForumPage;
import com.example.climbersbeta.R;

public class forumAdapter extends MainForumPage.Adapter {

    // initializes ViewHolder(s)
    @Override
    public MainForumPage.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType){
        final View view = LayoutInflater.from(parent.getContext()).inflate(viewType, parent, false);
        return new forumAdapter(view);
    }

    // this is where we pass our data to our ViewHolder
    @Override
    public void onBindViewHolder(final MainForumPage.ViewHolder holder, final int position) {
        ((forumAdapter) holder).bindData(models.get(position));
    }

    // returns the size of the collection that contains the items we want to display
    @Override
    public int getItemCount() {
        return models.size();
    }

    // returns an integer which represents the view type
    @Override
    public int getItemViewType(final int position) {
        return R.layout.item_simple_itemview;
    }
}
