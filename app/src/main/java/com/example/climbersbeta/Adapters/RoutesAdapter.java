package com.example.climbersbeta.Adapters;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.climbersbeta.R;
import com.example.climbersbeta.RouteViewPage;
import com.example.climbersbeta.models.Route;

import org.parceler.Parcels;

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
        Log.d("smile", "onCreateViewHolder");
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
        RelativeLayout container;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
           tvRouteName = itemView.findViewById(R.id.tvRouteName);
           container = itemView.findViewById(R.id.container);

        }

        public void bind(final Route route) {

            tvRouteName.setText(route.getName());

            container.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v) {

                        Intent sendToRouteViewIntent = new Intent(context, RouteViewPage.class);
                        sendToRouteViewIntent.putExtra("route", Parcels.wrap(route));
                        context.startActivity(sendToRouteViewIntent);


                }
            });
        }


    }
}
