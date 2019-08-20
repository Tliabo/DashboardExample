package com.precious.dashboard.db.entity;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "functions")
public class DashboardFunction {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dashboard_id")
    private int dashboardId;

    @ColumnInfo(name = "function_name")
    private String functionName;

    @ColumnInfo(name = "function_icon")
    private int functionIcon;

    public DashboardFunction(String functionName, int functionIcon) {
        this.functionName = functionName;
        this.functionIcon = functionIcon;
    }

    public int getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(int dashboardId) {
        this.dashboardId = dashboardId;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public int getFunctionIcon() {
        return functionIcon;
    }

    public void setFunctionIcon(int functionIcon) {
        this.functionIcon = functionIcon;
    }
}
