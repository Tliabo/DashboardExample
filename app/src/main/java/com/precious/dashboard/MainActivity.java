package com.precious.dashboard;

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
import com.precious.dashboard.db.entity.DashboardFunction;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements DashboardFunctionPickDialog.DialogListener, View.OnClickListener, View.OnLongClickListener {

    private static final int CHANGE_DASHBOARD_FUNCTION_REQUEST = 1;
    private static final String CHANGE_DASHBOARD_FUNCTION_DIALOG = "change_dashboard";

    private int buttonToChange;

    private DashboardViewModel dashboardViewModel;

    private Dashboard myDashboard;

    private int username = 666999;

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

        dashboardViewModel =
                ViewModelProviders.of(this).get(DashboardViewModel.class);

        dashboardViewModel.getAllDashboards().observe(
                this, dashboards -> {
                    for (Dashboard pDashboard : dashboards) {
                        if (pDashboard.getUserId() == username) {
                            myDashboard = pDashboard;
                            initButtons();
                            break;
                        }
                    }
                }
        );
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

        imageButton1.setContentDescription(myDashboard.getPosition1());
        imageButton2.setContentDescription(myDashboard.getPosition2());
        imageButton3.setContentDescription(myDashboard.getPosition3());
        imageButton4.setContentDescription(myDashboard.getPosition4());
        imageButton5.setContentDescription(myDashboard.getPosition5());
        imageButton6.setContentDescription(myDashboard.getPosition6());
        imageButton7.setContentDescription(myDashboard.getPosition7());
        imageButton8.setContentDescription(myDashboard.getPosition8());

        addImageButtonsToList();

        for (ImageButton imageButton : imageButtons) {
            imageButton.setOnClickListener(this);
            imageButton.setOnLongClickListener(this);
            setImageSource(imageButton);
        }

    }

    private void setImageSource(ImageButton imageButton) {
        dashboardViewModel.getAllFunctions().observe(this, dashboardFunctions -> {
            for (DashboardFunction function : dashboardFunctions) {
                if (function.getFunctionName().equals(imageButton.getContentDescription())) {
                    imageButton.setImageResource(function.getFunctionIcon());
                }
            }
        });
    }

    public void chooseFunction() {
        DashboardFunctionPickDialog dialog = new DashboardFunctionPickDialog();
        dialog.show(getSupportFragmentManager(), CHANGE_DASHBOARD_FUNCTION_DIALOG);
    }

    void addImageButtonsToList() {

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
                buttonToChange = v.getId();
                chooseFunction();
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {

        buttonToChange = v.getId();
        chooseFunction();

        return false;
    }

    @Override
    public void applyFunction(int imageSource, String functionName) {

        if (imageSource >= 0 && functionName != null) {
            for (int i = 0; i < imageButtons.size(); i++) {
                if (imageButtons.get(i).getId() == buttonToChange) {

                    imageButtons.get(i).setImageResource(imageSource);
                    imageButtons.get(i).setContentDescription(functionName);

                    String positionBuilder = ("position" + (i + 1));

                    updateDashboardPosition(positionBuilder, functionName);

                    dashboardViewModel.update(myDashboard);
                }
            }
        }
    }

    private void updateDashboardPosition(String positionBuilder, String functionName) {

        switch (positionBuilder) {
            case "position1":
                myDashboard.setPosition1(functionName);
                break;
            case "position2":
                myDashboard.setPosition2(functionName);
                break;
            case "position3":
                myDashboard.setPosition3(functionName);
                break;
            case "position4":
                myDashboard.setPosition4(functionName);
                break;
            case "position5":
                myDashboard.setPosition5(functionName);
                break;
            case "position6":
                myDashboard.setPosition6(functionName);
                break;
            case "position7":
                myDashboard.setPosition7(functionName);
                break;
            case "position8":
                myDashboard.setPosition8(functionName);
                break;
        }
    }
}
