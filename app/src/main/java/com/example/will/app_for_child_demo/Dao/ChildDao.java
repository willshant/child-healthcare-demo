package com.example.will.app_for_child_demo.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.will.app_for_child_demo.Entity.Child;

import java.util.List;

@Dao
public interface ChildDao {

    // LiveData is a data holder class that can be observed within a given lifecycle.
    // Always holds/caches latest version of data. Notifies its active observers when the
    // data has changed. Since we are getting all the contents of the database,
    // we are notified whenever any of the database contents have changed.

    // ORDER BY firstName ASC
    @Query("SELECT * from child_table")
    LiveData<List<Child>> getAllChild();

//    @Query("SELECT * from  where id = id")
//    Child getChildById(int id);

    @Insert
    void insert(Child child);

    @Update
    int update(Child child);

    @Delete
    void delete(Child child);



}
