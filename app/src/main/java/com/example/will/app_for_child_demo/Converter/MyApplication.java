package com.example.will.app_for_child_demo.Converter;

import android.app.Application;
import android.content.Context;

public class MyApplication extends Application {

    private static Application sApplication;

    public static Application getApplication() {
        return sApplication;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        sApplication = this;
    }
}