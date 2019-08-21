package com.precious.dashboard;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageButton;

import com.precious.dashboard.db.entity.DashboardFunction;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;

    private static final String DASHBOARD_BEGIN_DIALOG_TAG = "dashboard_dialog_tag";
    private static final String DASHBOARD_END_DIALOG_TAG = "dashboard_end_dialog_tag";

    private DashboardViewModel dashboardViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();

        chooseFunction();
    }

    public void chooseFunction(){
        DashboardFunctionPickDialog dialog = DashboardFunctionPickDialog.newInstance(this);
        dialog.setCancelable(true);
        dialog.show(getSupportFragmentManager(), DASHBOARD_BEGIN_DIALOG_TAG);
    }

    public void initData() {
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);

        final DashboardFunctionAdapter adapter = new DashboardFunctionAdapter();
        recyclerView.setAdapter(adapter);

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        dashboardViewModel.getAllFunctions().observe(this, adapter::setDashboardFunctions);
    }
}
