package com.example.madartestapp;

import com.example.madartestapp.Modules.AppModule;
import com.example.madartestapp.Modules.UserDatabaseModule;
import com.example.madartestapp.RoomDB.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, UserDatabaseModule.class})
public interface UserComponent {

    void inject(UserRepository userRepository);
    void inject(UserViewModel userViewModel);
}
