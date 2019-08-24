package com.precious.dashboard.db.entity;

import androidx.annotation.InspectableProperty;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

@Entity(tableName = "user")
public class User {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private int username;

    @ColumnInfo(name = "password")
    private String userPassword;

    @ForeignKey(entity = Dashboard.class, parentColumns = "dashboard_id", childColumns = "dashboard_id")
    @ColumnInfo(name = "dashboard_id")
    private int dashboardId;

    public User(){
    }

    public User(int username, String password){
        this.username = username;
        this.userPassword = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUsername() {
        return username;
    }

    public void setUsername(int username) {
        this.username = username;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public int getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(int dashboardId) {
        this.dashboardId = dashboardId;
    }
}
