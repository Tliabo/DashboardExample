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

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    private List<DashboardDialogItem> dashboardDialogItemList;

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView imageViewFunction;
        private TextView textViewFunctionName;

        public ViewHolder(View view, OnItemClickListener listener) {
            super(view);
            imageViewFunction = view.findViewById(R.id.imageView);
            textViewFunctionName = view.findViewById(R.id.functionName);

            view.setOnClickListener(v -> {
                if (listener != null){
                    int position = getAdapterPosition();
                    if (position != RecyclerView.NO_POSITION){
                        listener.onItemClick(position);
                    }
                }
            });
        }
    }

    public DashboardFunctionAdapter(List<DashboardDialogItem> itemsList) {
        dashboardDialogItemList = itemsList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.dashboard_dialog_item, parent, false);
        return new ViewHolder(view, listener);
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
