package com.precious.dashboard;

import android.app.Application;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.precious.dashboard.db.entity.Dashboard;
import com.precious.dashboard.db.repository.DashboardRepository;

import java.util.List;

public class DashboardViewModel extends AndroidViewModel {

    private DashboardRepository repository;
    private LiveData<List<String>> allFunctions;
    private List<ImageButton> imageButtons;

    public DashboardViewModel(@NonNull Application application) {
        super(application);

        repository = new DashboardRepository(application);
        allFunctions = repository.getAllDashboardFunctions();

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



    public LiveData<List<String>> getAllFunctions(){
        return allFunctions;
    }

    public void setButtons(List<ImageButton> imageButtons){
        this.imageButtons = imageButtons;
    }

    public List<ImageButton> getImageButtons() {
        return imageButtons;
    }


}
