package com.precious.dashboard;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.Toast;

import com.precious.dashboard.db.entity.Dashboard;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private static final int CHANGE_DASHBOARD_FUNCTION_REQUEST = 1;
    private static final String CHANGE_DASHBOARD_FUNCTION_DIALOG = "change_dashboard";

    private int username;
    private int functionAmount;

    private DashboardViewModel dashboardViewModel;

    private List<ImageButton> imageButtons = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        DashboardFunctionAdapter adapter = new DashboardFunctionAdapter();

        dashboardViewModel = ViewModelProviders.of(this).get(DashboardViewModel.class);
        dashboardViewModel.getDashboard(username).observe(this, new Observer<Dashboard>() {
            @Override
            public void onChanged(List<Dashboard> dashboards) {
                adapter.setDashboardFunctions(dashboards);
            }
        });

    }

    public void chooseFunction(){
        DashboardFunctionPickDialog dialog = new DashboardFunctionPickDialog();
        dialog.show(getSupportFragmentManager(), CHANGE_DASHBOARD_FUNCTION_DIALOG);
    }

    void initImageButtons(){
        ImageButton imageButton1 = findViewById(R.id.imageButton1);
        ImageButton imageButton2 = findViewById(R.id.imageButton2);
        ImageButton imageButton3 = findViewById(R.id.imageButton3);
        ImageButton imageButton4 = findViewById(R.id.imageButton4);
        ImageButton imageButton5 = findViewById(R.id.imageButton5);
        ImageButton imageButton6 = findViewById(R.id.imageButton6);
        ImageButton imageButton7 = findViewById(R.id.imageButton7);
        ImageButton imageButton8 = findViewById(R.id.imageButton8);

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

            Dashboard dashboard = new Dashboard(userId, )

            productViewModel.insert(product);

            Toast.makeText(this, "Function saved", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Function not saved", Toast.LENGTH_SHORT).show();
        }
    }


    public void onClick(ImageButton button){
        Intent intent;

        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();

        // Handle navigation view item clicks here.
        switch (button.getContentDescription()) {
            case R.id.nav_erp:
                intent = new Intent(DashboardActivity.this, ERPActivity.class);
                startActivity(intent);

                break;
            case R.id.nav_webmail:
                intent = new Intent(DashboardActivity.this, WebmailActivity.class);
                startActivity(intent);

                break;
            case R.id.nav_dashboard:
                ft.replace(
                        R.id.fragment_container, new DashboardFragment()
                ).commit();
                break;
            case R.id.nav_timetracking:
                intent = new Intent(DashboardActivity.this, TimeTrackingActivity.class);
//                intent.putExtra("userId", userId);
                startActivity(intent);

                break;
            case R.id.nav_message:
                intent = new Intent(DashboardActivity.this, MessageActivity.class);
                startActivity(intent);

                break;
            case R.id.nav_shop:
                intent = new Intent(DashboardActivity.this, ShopActivity.class);
                startActivity(intent);

                break;
            case R.id.nav_settings:

                break;
            case R.id.nav_feedback:
                intent = new Intent(DashboardActivity.this, FeedbackActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_calender:
                intent = new Intent(DashboardActivity.this, CalenderActivity.class);
                startActivity(intent);
                break;
            case R.id.nav_logout:
                Toast toast = Toast.makeText(this, "Logout", Toast.LENGTH_SHORT);
                toast.show();
                break;
        }
    }

}
