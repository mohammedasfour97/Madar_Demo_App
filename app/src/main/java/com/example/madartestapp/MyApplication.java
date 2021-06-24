package com.example.madartestapp;

import android.app.Application;

import com.example.madartestapp.DI.DaggerUserComponent;
import com.example.madartestapp.DI.Modules.AppModule;
import com.example.madartestapp.DI.UserComponent;
import com.example.madartestapp.DI.Modules.UserDatabaseModule;

public class MyApplication extends Application {

    private UserComponent userComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        userComponent = DaggerUserComponent.builder()
                .appModule(new AppModule(this))
                .userDatabaseModule(new UserDatabaseModule(this))
                .build();
    }

    public UserComponent getUserComponent() {
        return userComponent;
    }
}
