package com.jhonisaac.daggerretrofitwheatherapp;

import android.app.Application;

import di.component.ApplicationContextComponent;
import di.component.DaggerApplicationContextComponent;
import di.component.RetrofitSubComponent;
import di.component.SharedPreferencesSubComponent;
import di.module.ApplicationContextModule;
import di.module.RetrofitModule;
import di.module.SharedPreferencesModule;

public class BaseApplication extends Application {

    private SharedPreferencesSubComponent sharedPreferencesSubComponent;

    private ApplicationContextComponent applicationContextComponent;

    private RetrofitSubComponent retrofitSubComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        setUpGraph();

    }

    private void setUpGraph() {
        applicationContextComponent = DaggerApplicationContextComponent.builder()
                .applicationContextModule(new ApplicationContextModule(this))
                .build();
    }

    private void clearApplicationContext() {
        applicationContextComponent = null;
    }

    public SharedPreferencesSubComponent plusSharedPreferencesSubComponent (){
        if (sharedPreferencesSubComponent == null) {
            sharedPreferencesSubComponent = retrofitSubComponent
                    .plusSharedPreferencesSubComponent(new SharedPreferencesModule());
        }

        return sharedPreferencesSubComponent;
    }

    private void clearSharedPreferencesSubComponent() {
        sharedPreferencesSubComponent = null;
    }

    public RetrofitSubComponent plusRetrofitComponent() {
        if (retrofitSubComponent == null) {
            retrofitSubComponent = applicationContextComponent
                    .plusRetrofitSubComponent(new RetrofitModule());
        }
        return retrofitSubComponent;
    }

    private void clearRetrofitSubComponent() {
        retrofitSubComponent = null;
    }

    public ApplicationContextComponent getApplicationContextComponent () {
        return applicationContextComponent;
    }




}
