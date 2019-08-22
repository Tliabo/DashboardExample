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
        extends RecyclerView.Adapter<DashboardFunctionAdapter.ViewHolder> {

    private List<DashboardDialogItem> dashboardDialogItemList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFunction;
        private TextView textViewFunctionName;

        public ViewHolder(View view) {
            super(view);
            imageViewFunction = view.findViewById(R.id.imageView);
            textViewFunctionName = view.findViewById(R.id.functionName);
        }
    }

    public DashboardFunctionAdapter(List<DashboardDialogItem> itemsList) {
        dashboardDialogItemList = itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_dialog_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        DashboardDialogItem dashboardDialogItem = dashboardDialogItemList.get(position);

        holder.imageViewFunction.setImageResource(dashboardDialogItem.getImageResource());
        holder.textViewFunctionName.setText(dashboardDialogItem.getFunctionName());
    }

    @Override
    public int getItemCount() {
        return dashboardDialogItemList.size();
    }

}
