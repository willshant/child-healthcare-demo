package com.example.will.app_for_child_demo.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.Entity.HomeVisit;

import java.util.List;

@Dao
public interface HomeVisitDao {

    @Query("SELECT * from home_visit_table where childId = :cid") // with max date & time
    HomeVisit getVisitByChild(int cid);

    @Insert
    void insert(HomeVisit hv);

    @Update
    void update(HomeVisit hv);

    @Delete
    void delete(HomeVisit hv);

}

