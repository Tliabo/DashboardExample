package com.precious.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import com.precious.dashboard.db.entity.Dashboard;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DashboardFunctionPickDialog.DialogListener, View.OnClickListener{

    private static final int CHANGE_DASHBOARD_FUNCTION_REQUEST = 1;
    private static final String CHANGE_DASHBOARD_FUNCTION_DIALOG = "change_dashboard";

    private int username = 666999;

    private DashboardViewModel dashboardViewModel;

    private List<ImageButton> imageButtons = new ArrayList<>();
    private ImageButton imageButton1;
    private ImageButton imageButton2;
    private ImageButton imageButton3;
    private ImageButton imageButton4;
    private ImageButton imageButton5;
    private ImageButton imageButton6;
    private ImageButton imageButton7;
    private ImageButton imageButton8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        DashboardFunctionAdapter adapter = new DashboardFunctionAdapter();

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
//        dashboardViewModel.getDashboard(username);

        initButtons();

    }

    private void initButtons() {
        imageButton1 = findViewById(R.id.imageButton1);
        imageButton2 = findViewById(R.id.imageButton2);
        imageButton3 = findViewById(R.id.imageButton3);
        imageButton4 = findViewById(R.id.imageButton4);
        imageButton5 = findViewById(R.id.imageButton5);
        imageButton6 = findViewById(R.id.imageButton6);
        imageButton7 = findViewById(R.id.imageButton7);
        imageButton8 = findViewById(R.id.imageButton8);

        imageButton1.setOnClickListener(this);
        imageButton2.setOnClickListener(this);
        imageButton3.setOnClickListener(this);
        imageButton4.setOnClickListener(this);
        imageButton5.setOnClickListener(this);
        imageButton6.setOnClickListener(this);
        imageButton7.setOnClickListener(this);
        imageButton8.setOnClickListener(this);

        addImageButtonsToList();
    }

    public void chooseFunction(){
        DashboardFunctionPickDialog dialog = new DashboardFunctionPickDialog();
        dialog.show(getSupportFragmentManager(), CHANGE_DASHBOARD_FUNCTION_DIALOG);
    }

    void addImageButtonsToList(){

        imageButtons.add(imageButton1);
        imageButtons.add(imageButton2);
        imageButtons.add(imageButton3);
        imageButtons.add(imageButton4);
        imageButtons.add(imageButton5);
        imageButtons.add(imageButton6);
        imageButtons.add(imageButton7);
        imageButtons.add(imageButton8);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CHANGE_DASHBOARD_FUNCTION_REQUEST && resultCode == RESULT_OK) {

            String position1 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS1);
            String position2 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS2);
            String position3 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS3);
            String position4 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS4);
            String position5 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS5);
            String position6 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS6);
            String position7 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS7);
            String position8 = data.getStringExtra(DashboardFunctionPickDialog.EXTRA_POS8);

            Dashboard dashboard = new Dashboard(username,8, position1, position2, position3, position4, position5, position6, position7, position8);

            dashboardViewModel.update(dashboard);

            Toast.makeText(this, "Function saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Function not saved", Toast.LENGTH_SHORT).show();
        }
    }



    @Override
    public void onClick(View v) {
        Intent intent;
        Toast toast;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        switch (v.getContentDescription().toString()) {
            case "Kalender":
//                toast = Toast.makeText(this, "Kalender", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "Stellenangebote":
//                toast = Toast.makeText(this, "Stellenangebote", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "Information":
//                toast = Toast.makeText(this, "Information", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "Shop":
//                toast = Toast.makeText(this, "Shop", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "TimeTracking":
//                toast = Toast.makeText(this, "TimeTracking", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "ERP":
//                toast = Toast.makeText(this, "ERP", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "Mail":
//                toast = Toast.makeText(this, "Mail", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "Feedback":
//                toast = Toast.makeText(this, "Feedback", Toast.LENGTH_SHORT);
//                toast.show();
                break;
            case "default":
//                toast = Toast.makeText(this, "default", Toast.LENGTH_SHORT);
//                toast.show();
                chooseFunction();
                break;
        }
    }

    @Override
    public void applyFunction(int imageSource, String functionName) {

    }
}
