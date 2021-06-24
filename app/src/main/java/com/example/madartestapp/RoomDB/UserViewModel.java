package com.example.madartestapp.RoomDB;

import android.app.Application;

import com.example.madartestapp.User;
import com.example.madartestapp.UserRepository;

import java.util.List;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserViewModel extends AndroidViewModel {

    private UserRepository userRepository;

    public UserViewModel(Application application) {
        super(application);
        userRepository = new UserRepository(application);
    }

    public LiveData<List<User>> get_all_users(){

        return userRepository.getAllUsers();
    }

    public void insertUser(User user){

        userRepository.insertUser(user);
    }
}
