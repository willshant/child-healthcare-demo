package com.example.will.app_for_child_demo.ViewModel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;

import com.example.will.app_for_child_demo.Entity.Child;
import com.example.will.app_for_child_demo.Repository.ChildRepository;

import java.util.List;

public class ChildViewModel extends AndroidViewModel {

    private ChildRepository mRepository;

    private LiveData<List<Child>> mAllChild;

    public ChildViewModel (Application application) {
        super(application);
        mRepository = new ChildRepository(application);
        mAllChild = mRepository.getAllChild();

    }

    public LiveData<List<Child>> getAllChild() {
        return mAllChild;
    }

    public void insert(Child child) {
        mRepository.insert(child);
    }

    public void update(Child child) {
        mRepository.update(child);
    }
}