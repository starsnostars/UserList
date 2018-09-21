package com.example.afanasyev.userlist;

import android.app.Activity;
import android.app.Application;
import android.databinding.DataBindingUtil;

import javax.inject.Inject;

import DI.AppComponent;
import DI.DaggerAppComponent;
import dagger.android.AndroidInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.HasActivityInjector;
import utils.AppBindingComponent;

public class App extends Application implements HasActivityInjector {
    @Inject
    DispatchingAndroidInjector<Activity> injector;

    @Override
    public void onCreate() {
        super.onCreate();
        DaggerAppComponent.builder().app(this).build().inject(this);
        DataBindingUtil.setDefaultComponent(new AppBindingComponent());
    }

    @Override
    public AndroidInjector<Activity> activityInjector() {
        return this.injector;
    }
}
