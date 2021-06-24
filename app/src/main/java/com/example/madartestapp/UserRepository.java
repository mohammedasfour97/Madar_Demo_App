package com.example.madartestapp;

import android.app.Application;
import android.os.AsyncTask;

import com.example.madartestapp.RoomDB.UserDao;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

public class UserRepository {
    private UserDao user_dao;


    @Inject
    UserDatabase userDatabase;

    public UserRepository(Application application) {

        ((MyApplication)application).getUserComponent().inject(this);

        user_dao = userDatabase.userDao();
    }

    public LiveData<List<User>> getAllUsers() {

        return  user_dao.getAllUsers();
    }

    public void insertUser(User user){

        new InsertUserAsyncTask(user_dao).execute(user);
    }


    private static class InsertUserAsyncTask extends AsyncTask<User, Void, Void> {

        private UserDao userDao;

        public InsertUserAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected Void doInBackground(User... users) {
            userDao.insert(users[0]);
            return null;
        }
    }

   /* private static class GetAllUsersAsyncTask extends AsyncTask<String , Void, List<User>> {

        private UserDao userDao;

        public GetAllUsersAsyncTask(UserDao userDao) {
            this.userDao = userDao;
        }

        @Override
        protected List<User> doInBackground(String... args) {
            return userDao.getAllUsers();
        }
    }

    */
}
