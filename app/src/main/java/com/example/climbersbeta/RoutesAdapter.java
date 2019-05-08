package com.example.climbersbeta;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.routesViewHolder> {

    Context context;
    List<String> routes;

    public RoutesAdapter(Context context, List<String> routes) {
        this.context = context;
        this.routes = routes;
    }

    // inflates the row layout and initializes the view holder
    @NonNull
    @Override
    public routesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_routes, viewGroup, false);
        return new routesViewHolder(view);
    }

    // uses the view holder from onCreateViewHolder() method to populate
    // the current row of the recycler view with data
    @Override
    public void onBindViewHolder(@NonNull routesViewHolder holder, int i) {
        String routesList = routes.get(i);
        holder.tvRoutes.setText(routesList);
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

    class routesViewHolder extends RecyclerView.ViewHolder {

        TextView tvRoutes;

        public routesViewHolder(View v) {
            super(v);
            tvRoutes = v.findViewById(R.id.tvRoutes);
        }
    }
}
