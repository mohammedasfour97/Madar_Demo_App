package com.example.madartestapp.RoomDB;

import com.example.madartestapp.User;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface UserDao {

    @Query("SELECT * FROM user_table")
    LiveData<List<User>> getAllUsers();

    @Insert
    void insert(User user);
}
