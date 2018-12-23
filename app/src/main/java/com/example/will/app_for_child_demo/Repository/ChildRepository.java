package com.example.will.app_for_child_demo.Repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import com.example.will.app_for_child_demo.Dao.ChildDao;
import com.example.will.app_for_child_demo.Database.MyRoomDB;
import com.example.will.app_for_child_demo.Entity.Child;

import java.util.List;

public class ChildRepository {

    private ChildDao mChildDao;
    private LiveData<List<Child>> mAllChild;

    public ChildRepository(Application application) {
        MyRoomDB db = MyRoomDB.getDatabase(application);
        mChildDao = db.childDao();
        mAllChild = mChildDao.getAllChild();
    }

    public LiveData<List<Child>> getAllChild() {
        return mAllChild;
    }


    public void insert (Child child) {
        new insertAsyncTask(mChildDao).execute(child);
    }

    private static class insertAsyncTask extends AsyncTask<Child, Void, Void> {

        private ChildDao mAsyncTaskDao;

        insertAsyncTask(ChildDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final Child... params) {
            mAsyncTaskDao.insert(params[0]);
            return null;
        }
    }
}