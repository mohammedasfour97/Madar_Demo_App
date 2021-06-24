package com.example.madartestapp.UI;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.navigation.NavController;

import android.os.Bundle;

import com.example.madartestapp.R;
import com.example.madartestapp.databinding.ActivityMainBindingImpl;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DataBindingUtil.setContentView(this , R.layout.activity_main);

    }
}