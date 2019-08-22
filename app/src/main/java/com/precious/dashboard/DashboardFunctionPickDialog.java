package com.precious.dashboard;

import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
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

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.fragment_functions_list, null);

        builder.setView(view)
                .setTitle("Choose Function");


        return builder.create();
    }


}
