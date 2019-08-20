package com.precious.dashboard.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.precious.dashboard.db.entity.Dashboard;

@Dao
public interface DashboardDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(Dashboard dashboard);

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void update(Dashboard dashboard);

    @Delete
    void delete(Dashboard dashboard);

    @Query("SELECT * FROM dashboard WHERE user_id = :userId")
    LiveData<Dashboard> getDashboard(int userId);

}
