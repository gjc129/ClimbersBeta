package com.example.climbersbeta;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

public class forumViewHolder extends RecyclerView.ViewHolder{

    private TextView simpleTextView;

    public forumViewHolder(@NonNull View itemView) {
        super(itemView);
        simpleTextView = (TextView) itemView.findViewById(R.id.simplePost);
    }

    public void bindData(final MainForumPage viewModel) {
        simpleTextView.setText(viewModel.getSimplePost());
    }
}
