package com.example.will.app_for_child_demo.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.will.app_for_child_demo.Entity.Child;

import java.util.List;

@Dao
public interface ChildDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.
    @Query("SELECT * from child_table") // ORDER BY firstName ASC
    LiveData<List<Child>> getAllChild();

    @Insert
    void insert(Child child);

}
