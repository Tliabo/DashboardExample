package com.precious.dashboard.db.entity;

import android.widget.ImageButton;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static androidx.room.ForeignKey.CASCADE;

@Entity(tableName = "dashboard")
public class Dashboard {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "dashboard_id")
    private int dashboardId;

    @ForeignKey(entity = User.class, parentColumns = "user_Id", childColumns = "user_id", onDelete = CASCADE)
    @ColumnInfo(name = "user_id")
    private int userId;

    //There can be max. 8 functions
    @ColumnInfo(name = "amount_functions")
    private int functionsAmount;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position1")
    private String position1;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position2")
    private String position2;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position3")
    private String position3;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position4")
    private String position4;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position5")
    private String position5;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position6")
    private String position6;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position7")
    private String position7;

    @ForeignKey(entity = DashboardFunction.class, parentColumns = "function_name", childColumns = "position8")
    private String position8;

    public Dashboard(){

    }

    @Ignore
    public Dashboard(int userId, int functionsAmount,
                     String position1,
                     String position2,
                     String position3,
                     String position4,
                     String position5,
                     String position6,
                     String position7,
                     String position8) {
        this.userId = userId;
        this.functionsAmount = functionsAmount;

        this.position1 = position1;
        this.position2 = position2;
        this.position3 = position3;
        this.position4 = position4;
        this.position5 = position5;
        this.position6 = position6;
        this.position7 = position7;
        this.position8 = position8;
    }

    public void setDashboardId(int dashboardId) {
        this.dashboardId = dashboardId;
    }

    public int getDashboardId() {
        return dashboardId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getFunctionsAmount() {
        return functionsAmount;
    }

    public void setFunctionsAmount(int functionsAmount) {
        this.functionsAmount = functionsAmount;
    }

    public String getPosition1() {
        return position1;
    }

    public void setPosition1(String position1) {
        this.position1 = position1;
    }

    public String getPosition2() {
        return position2;
    }

    public void setPosition2(String position2) {
        this.position2 = position2;
    }

    public String getPosition3() {
        return position3;
    }

    public void setPosition3(String position3) {
        this.position3 = position3;
    }

    public String getPosition4() {
        return position4;
    }

    public void setPosition4(String position4) {
        this.position4 = position4;
    }

    public String getPosition5() {
        return position5;
    }

    public void setPosition5(String position5) {
        this.position5 = position5;
    }

    public String getPosition6() {
        return position6;
    }

    public void setPosition6(String position6) {
        this.position6 = position6;
    }

    public String getPosition7() {
        return position7;
    }

    public void setPosition7(String position7) {
        this.position7 = position7;
    }

    public String getPosition8() {
        return position8;
    }

    public void setPosition8(String position8) {
        this.position8 = position8;
    }


}
