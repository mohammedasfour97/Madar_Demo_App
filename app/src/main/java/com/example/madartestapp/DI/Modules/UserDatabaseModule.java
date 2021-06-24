package com.example.madartestapp.DI.Modules;

import android.content.Context;

import com.example.madartestapp.RoomDB.UserDatabase;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class UserDatabaseModule {

    private Context context;

    public UserDatabaseModule(Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public synchronized UserDatabase getInstance() {

        return Room.databaseBuilder(context,
                    UserDatabase.class, "user_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }

    }