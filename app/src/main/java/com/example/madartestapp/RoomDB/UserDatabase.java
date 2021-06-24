package com.example.madartestapp.RoomDB;

import com.example.madartestapp.RoomDB.UserDao;
import com.example.madartestapp.User;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {User.class}, version = 1)
public abstract class UserDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
