package com.example.madartestapp.DI;

import com.example.madartestapp.DI.Modules.AppModule;
import com.example.madartestapp.DI.Modules.UserDatabaseModule;
import com.example.madartestapp.Repessitories.UserRepository;
import com.example.madartestapp.ViewModels.UserViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {AppModule.class, UserDatabaseModule.class})
public interface UserComponent {

    void inject(UserRepository userRepository);
    void inject(UserViewModel userViewModel);
}
