package com.precious.dashboard.db;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.precious.dashboard.R;
import com.precious.dashboard.db.dao.DashboardDAO;
import com.precious.dashboard.db.dao.DashboardFunctionDAO;
import com.precious.dashboard.db.dao.UserDAO;
import com.precious.dashboard.db.entity.Dashboard;
import com.precious.dashboard.db.entity.DashboardFunction;
import com.precious.dashboard.db.entity.User;


@Database(
        entities = {
                User.class,
                Dashboard.class,
                DashboardFunction.class
        }, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {

    private static final String APP_DB_NAME = "app_database";

    private static AppDatabase instance;

    public abstract UserDAO userDAO();
    public abstract DashboardDAO dashboardDAO();
    public abstract DashboardFunctionDAO dashboardFunctionDAO();

    public static synchronized AppDatabase getInstance(Context context) {
        if (instance == null) {
            //Create or open a new SQLite database, and return it as
            //a Room Database instance.
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    AppDatabase.class, APP_DB_NAME)
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }

    //Singleton instance
    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private UserDAO userDAO;
        private DashboardDAO dashboardDAO;
        private DashboardFunctionDAO dashboardFunctionDAO;

        private PopulateDbAsyncTask(AppDatabase db){
            userDAO = db.userDAO();
            dashboardDAO = db.dashboardDAO();
            dashboardFunctionDAO = db.dashboardFunctionDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            //app have to be reinstalled, if you add a new dummy

            userDAO.insert(new User(666999, "test"));

            dashboardFunctionDAO.insert(new DashboardFunction("Kalender", R.drawable.ic_outline_calender));
            dashboardFunctionDAO.insert(new DashboardFunction("Zeiterfassung", R.drawable.ic_outline_timer));
            dashboardFunctionDAO.insert(new DashboardFunction("Nachrichten", R.drawable.ic_outline_message));
            dashboardFunctionDAO.insert(new DashboardFunction("Shop", R.drawable.ic_outline_shopping_cart));
            dashboardFunctionDAO.insert(new DashboardFunction("Intranet", R.drawable.ic_outline_launch));
            dashboardFunctionDAO.insert(new DashboardFunction("Webmail", R.drawable.ic_outline_launch));
            dashboardFunctionDAO.insert(new DashboardFunction("ERP", R.drawable.ic_outline_launch));
            dashboardFunctionDAO.insert(new DashboardFunction("Stellenangebote", R.drawable.ic_outline_stelle_wechseln));
            dashboardFunctionDAO.insert(new DashboardFunction("Feedback", R.drawable.ic_outline_feedback));
            dashboardFunctionDAO.insert(new DashboardFunction("Profil", R.drawable.ic_outline_person));
            dashboardFunctionDAO.insert(new DashboardFunction("default", R.drawable.ic_outline_add_circle));

            dashboardDAO.insert(new Dashboard(666999, 6,"default","default","default","default","default","default","default","default"));



            return null;
        }
    }
}
