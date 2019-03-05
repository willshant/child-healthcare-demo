package com.example.will.app_for_child_demo.Entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.ForeignKey;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;

@Entity(tableName = "home_visit_table")
public class HomeVisit implements Serializable {

    @PrimaryKey(autoGenerate = true)
    private int id;

//    @ForeignKey(Child)
    private int childId;

    @NonNull
    private Date dateVisit;

    @NonNull
    private boolean finished = false;

    private Date dateCheck;

    private Date dateDewarm;

    public HomeVisit(int childId, @NonNull Date dateVisit, @NonNull boolean finished, Date dateCheck, Date dateDewarm) {
        this.childId = childId;
        this.dateVisit = dateVisit;
        this.finished = finished;
        this.dateCheck = dateCheck;
        this.dateDewarm = dateDewarm;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getChildId() {
        return childId;
    }

    public void setChildId(int childId) {
        this.childId = childId;
    }

    @NonNull
    public Date getDateVisit() {
        return dateVisit;
    }

    public void setDateVisit(@NonNull Date dateVisit) {
        this.dateVisit = dateVisit;
    }

    @NonNull
    public boolean isFinished() {
        return finished;
    }

    public void setFinished(@NonNull boolean finished) {
        this.finished = finished;
    }

    public Date getDateCheck() {
        return dateCheck;
    }

    public void setDateCheck(Date dateCheck) {
        this.dateCheck = dateCheck;
    }

    public Date getDateDewarm() {
        return dateDewarm;
    }

    public void setDateDewarm(Date dateDewarm) {
        this.dateDewarm = dateDewarm;
    }
}