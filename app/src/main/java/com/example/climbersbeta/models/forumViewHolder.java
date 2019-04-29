package com.example.climbersbeta.models;

import android.view.View;
import android.widget.TextView;

import com.example.climbersbeta.MainForumPage;
import com.example.climbersbeta.R;

public class forumViewHolder extends MainForumPage.ViewHolder {
    private TextView forumPost;

    public forumViewHolder(final View view) {
        super(itemView);
        forumPost = (TextView) itemView.findViewById(R.id.simple_text);
    }

    // bind our data to the TextView
    public void bindData(final forumViewModel viewModel) {
        forumPost.setText(viewModel.getForumPost());
    }
}
