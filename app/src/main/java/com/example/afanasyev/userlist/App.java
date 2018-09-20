package com.example.afanasyev.userlist;

import android.app.Application;
import android.databinding.DataBindingUtil;

import utils.AppBindingComponent;

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DataBindingUtil.setDefaultComponent(new AppBindingComponent());
    }
}
