package com.precious.dashboard.db.repository;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.precious.dashboard.db.AppDatabase;
import com.precious.dashboard.db.dao.DashboardDAO;
import com.precious.dashboard.db.dao.DashboardFunctionDAO;
import com.precious.dashboard.db.dao.UserDAO;
import com.precious.dashboard.db.entity.Dashboard;
import com.precious.dashboard.db.entity.DashboardFunction;
import com.precious.dashboard.db.entity.User;

import java.util.List;

public class DashboardRepository {
    private DashboardDAO dashboardDAO;
    private DashboardFunctionDAO dashboardFunctionDAO;
    private UserDAO userDAO;

    private LiveData<Dashboard> dashboard;
    private LiveData<List<DashboardFunction>> allDashboardFunctions;

    private AppDatabase database;

    public DashboardRepository(Application application){
        database = AppDatabase.getInstance(application);

        dashboardFunctionDAO = database.dashboardFunctionDAO();
        dashboardDAO = database.dashboardDAO();
        userDAO = database.userDAO();

        allDashboardFunctions = dashboardFunctionDAO.getAllFunctions();

    }

    public void insert(Dashboard dashboard){
        new InsertDashboardAsyncTask(dashboardDAO).execute(dashboard);
    }

    public void update(Dashboard dashboard){
        new UpdateDashboardAsyncTask(dashboardDAO).execute(dashboard);
    }

    public void delete(Dashboard dashboard){
        new DeleteDashboardAsyncTask(dashboardDAO).execute(dashboard);
    }

    public LiveData<Dashboard> getDashboard(int username) {
        dashboard = dashboardDAO.getDashboard(userDAO.getUser(username).getValue().getUsername());
        return dashboard;
    }

    public LiveData<List<DashboardFunction>> getAllDashboardFunctions(){
        return  allDashboardFunctions;
    }

    private static class InsertDashboardAsyncTask extends AsyncTask<Dashboard, Void, Void> {

        private DashboardDAO dashboardDAO;

        private InsertDashboardAsyncTask(DashboardDAO dashboardDAO){
            this.dashboardDAO = dashboardDAO;
        }

        @Override
        protected Void doInBackground(Dashboard... dashboards) {
            dashboardDAO.insert(dashboards[0]);
            return null;
        }
    }

    private static class UpdateDashboardAsyncTask extends AsyncTask<Dashboard, Void, Void> {

        private DashboardDAO dashboardDAO;

        private UpdateDashboardAsyncTask(DashboardDAO dashboardDAO){
            this.dashboardDAO = dashboardDAO;
        }

        @Override
        protected Void doInBackground(Dashboard... dashboards) {
            dashboardDAO.update(dashboards[0]);
            return null;
        }
    }

    private static class DeleteDashboardAsyncTask extends AsyncTask<Dashboard, Void, Void> {

        private DashboardDAO dashboardDAO;

        private DeleteDashboardAsyncTask(DashboardDAO dashboardDAO){
            this.dashboardDAO = dashboardDAO;
        }

        @Override
        protected Void doInBackground(Dashboard... dashboards) {
            dashboardDAO.delete(dashboards[0]);
            return null;
        }
    }
}
