package com.precious.dashboard;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;
import androidx.fragment.app.DialogFragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.precious.dashboard.db.entity.DashboardFunction;

import java.util.ArrayList;
import java.util.List;

public class DashboardFunctionPickDialog extends AppCompatDialogFragment {

    public static final String EXTRA_POS1 = "com.example.diplomarbeit.ui.shop.EXTRA_POS1";
    public static final String EXTRA_POS2 = "com.example.diplomarbeit.ui.shop.EXTRA_POS2";
    public static final String EXTRA_POS3 = "com.example.diplomarbeit.ui.shop.EXTRA_POS3";
    public static final String EXTRA_POS4 = "com.example.diplomarbeit.ui.shop.EXTRA_POS4";
    public static final String EXTRA_POS5 = "com.example.diplomarbeit.ui.shop.EXTRA_POS5";
    public static final String EXTRA_POS6 = "com.example.diplomarbeit.ui.shop.EXTRA_POS6";
    public static final String EXTRA_POS7 = "com.example.diplomarbeit.ui.shop.EXTRA_POS7";
    public static final String EXTRA_POS8 = "com.example.diplomarbeit.ui.shop.EXTRA_POS8";

    private List<DashboardDialogItem> dialogItems = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dashboard_dialog_list, null);

        builder.setView(view)
                .setTitle("Choose Function");

        addItems();

        recyclerView = view.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new DashboardFunctionAdapter(dialogItems);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

        return builder.create();
    }

    private void addItems() {
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_timer, "TimeTracking"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_email, "Email"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_message, "Information"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_shopping_cart, "Shop"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_stelle_wechseln, "Stellenangebote"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_launch, "ERP"));
    }


}
