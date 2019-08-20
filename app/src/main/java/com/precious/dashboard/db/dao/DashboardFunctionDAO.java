package com.precious.dashboard.db.dao;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.precious.dashboard.db.entity.DashboardFunction;

import java.util.List;

@Dao
public interface DashboardFunctionDAO {

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    void insert(DashboardFunction function);

    @Update (onConflict = OnConflictStrategy.REPLACE)
    void update(DashboardFunction function);

    @Delete
    void delete(DashboardFunction function);

    @Query("SELECT function_name FROM functions")
    LiveData<List<String>> getAllFunctionNames();

    @Query("SELECT * FROM functions")
    LiveData<List<DashboardFunction>> getAllFunctions();

}
