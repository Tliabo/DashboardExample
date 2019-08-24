package com.precious.dashboard;

import android.app.Application;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.precious.dashboard.db.entity.Dashboard;
import com.precious.dashboard.db.entity.DashboardFunction;
import com.precious.dashboard.db.repository.DashboardRepository;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {

    private DashboardRepository repository;
    private LiveData<List<Dashboard>> allDashboards;
    private LiveData<List<DashboardFunction>> allFunctions;
    private List<ImageButton> imageButtons;

    public DashboardViewModel(@NonNull Application application) {
        super(application);

        repository = new DashboardRepository(application);
        allFunctions = repository.getAllDashboardFunctions();
        allDashboards = repository.getAllDashboards();

    }

    public void insert(Dashboard dashboard){
        repository.insert(dashboard);
    }

    public void update(Dashboard dashboard){
        repository.update(dashboard);
    }

    public void delete(Dashboard dashboard){
        repository.delete(dashboard);
    }

    public LiveData<List<DashboardFunction>> getAllFunctions(){
        return allFunctions;
    }

    public void setButtons(List<ImageButton> imageButtons){
        this.imageButtons = imageButtons;
    }

    public List<ImageButton> getImageButtons() {
        return imageButtons;
    }

    public LiveData<List<Dashboard>> getAllDashboards(){
        return allDashboards;
    }

    private void addNewFunctionButton(String functionName, int imageSource){


    }


}
