package com.example.climbersbeta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.climbersbeta.models.fPosts;

import java.util.List;

public class ForumAdapter extends RecyclerView.Adapter<ForumAdapter.forumViewHolder>
{
    Context context;
    List<String> forumPost;

    public ForumAdapter(Context context, List<String> forumPost){
        this.context = context;
        this.forumPost = forumPost;
    }

    // inflates the row layout and initializes the view holder
    @NonNull
    @Override
    public forumViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_forum, viewGroup, false);
        return new forumViewHolder(view);
    }

    // uses the view holder from onCreateViewHolder() method to populate
    // the current row of the recycler view with data
    @Override
    public void onBindViewHolder(@NonNull forumViewHolder holder, int i) {
        String forumPosts = forumPost.get(i);
        holder.tvForum.setText(forumPosts);
    }

    @Override
    public int getItemCount() {
        return forumPost.size();
    }

    class forumViewHolder extends RecyclerView.ViewHolder {

        TextView tvForum;

        public forumViewHolder(View v) {
            super(v);
            tvForum = v.findViewById(R.id.tvForum);
        }
    }
}
