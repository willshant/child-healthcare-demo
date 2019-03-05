package com.example.will.app_for_child_demo.Repository;


import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.will.app_for_child_demo.Dao.ChildDao;
import com.example.will.app_for_child_demo.Dao.HomeVisitDao;
import com.example.will.app_for_child_demo.Database.MyRoomDB;
import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.Entity.HomeVisit;

import java.util.List;

public class HomeVisitRepository {

    private HomeVisitDao mHomeVisitDao;


    public HomeVisitRepository(Application application) {
        MyRoomDB db = MyRoomDB.getDatabase(application);
        mHomeVisitDao = db.homeVisitDao();
    }

    public HomeVisit getVisitByChild (int cid) {
        return mHomeVisitDao.getVisitByChild(cid);
    }

    public void insert (HomeVisit hv) {
        new insertAsyncTask(mHomeVisitDao).execute(hv);
    }

    public void update (HomeVisit hv) {
        new updateAsyncTask(mHomeVisitDao).execute(hv);
    }

    public void delete (HomeVisit hv) {
        new deleteAsyncTask(mHomeVisitDao).execute(hv);
    }

    private static class insertAsyncTask extends AsyncTask<HomeVisit, Void, Void> {

        private HomeVisitDao mAsyncTaskDao;

        insertAsyncTask(HomeVisitDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final HomeVisit... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }

    private static class updateAsyncTask extends AsyncTask<HomeVisit, Void, Void> {

        private HomeVisitDao mAsyncTaskDao;

        updateAsyncTask(HomeVisitDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final HomeVisit... params) {
            mAsyncTaskDao.update(params[0]);
            return null;
        }
    }

    private static class deleteAsyncTask extends AsyncTask<HomeVisit, Void, Void> {

        private HomeVisitDao mAsyncTaskDao;

        deleteAsyncTask(HomeVisitDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final HomeVisit... params) {
            mAsyncTaskDao.delete(params[0]);
            return null;
        }
    }
}