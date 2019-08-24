package com.precious.dashboard;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

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

    private List<DashboardDialogItem> dialogItems = new ArrayList<>();

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DashboardFunctionAdapter adapter;
    private DialogListener dialogListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.dashboard_dialog_list, null);

        builder.setView(view)
                .setTitle("Choose Function");

        addItems();

        buildRecyclerView(view);

        return builder.create();
    }

    private void addItems() {
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_calender, "Kalender"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_timer, "TimeTracking"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_email, "Mail"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_message, "Information"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_shopping_cart, "Shop"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_stelle_wechseln, "Stellenangebote"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_launch, "ERP"));
        dialogItems.add(new DashboardDialogItem(R.drawable.ic_outline_add_circle, "default"));
    }

    private void buildRecyclerView(View view) {
        recyclerView = view.findViewById(R.id.recyclerView);

        layoutManager = new LinearLayoutManager(getContext());
        adapter = new DashboardFunctionAdapter(dialogItems);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);
        recyclerView.setAdapter(adapter);

        adapter.setOnItemClickListener(position -> {
            dialogListener.applyFunction(
                    dialogItems.get(position).getImageResource(),
                    dialogItems.get(position).getFunctionName()
            );
            getDialog().dismiss();
        });
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            dialogListener = (DialogListener) context;
        } catch (Exception e) {
            throw new ClassCastException(context.toString() + " must implement DialogListener");
        }
    }

    public interface DialogListener {
        void applyFunction(int imageSource, String functionName);
    }
}