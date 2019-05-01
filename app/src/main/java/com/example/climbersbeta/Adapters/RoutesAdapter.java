package com.example.climbersbeta.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.climbersbeta.R;
import com.example.climbersbeta.models.Route;

import java.util.List;

public class RoutesAdapter extends RecyclerView.Adapter<RoutesAdapter.ViewHolder>{

    Context context;
    List<Route> routes;

    public RoutesAdapter(Context context, List<Route> routes) {
        this.context = context;
        this.routes = routes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //inflates the recycler view with the route names
        View view = LayoutInflater.from(context).inflate(R.layout.item_route, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Route route = routes.get(i);

        //binds the data to the viewholder
        viewHolder.bind(route);
    }

    @Override
    public int getItemCount() {
        return routes.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView tvRouteName;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.findViewById(R.id.tvRouteName);
        }

        public void bind(Route route) {
            tvRouteName.setText(route.getName());
        }
    }
}
