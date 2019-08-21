package com.precious.dashboard;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.precious.dashboard.db.entity.DashboardFunction;

import java.util.ArrayList;
import java.util.List;

public class DashboardFunctionAdapter
        extends RecyclerView.Adapter<DashboardFunctionAdapter.ViewHolder>{

    private List<DashboardFunction> dashboardFunctions = new ArrayList<>();

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_functions, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DashboardFunction dashboardFunction = dashboardFunctions.get(position);
        holder.TextViewFunctionName.setText(dashboardFunction.getFunctionName());
        holder.imageViewFunctionName.setImageResource(dashboardFunction.getFunctionIcon());

    }

    @Override
    public int getItemCount() {
        return dashboardFunctions.size();
    }

    public void setDashboardFunctions(List<DashboardFunction> dashboardFunctions){
        this.dashboardFunctions = dashboardFunctions;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView TextViewFunctionName;
        private ImageView imageViewFunctionName;

        public ViewHolder(View view) {
            super(view);
            TextViewFunctionName = view.findViewById(R.id.textViewFunctionName);
            imageViewFunctionName = view.findViewById(R.id.imageViewFunction);

        }

    }

}
