package com.epitech.redditech.Views.Home;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;

import com.epitech.redditech.Controllers.Home.HomeController;
import com.epitech.redditech.Controllers.Home.IHomeController;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Subreddit.SubredditFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

import org.jetbrains.annotations.NotNull;


public class HomeActivity extends AppCompatActivity implements IHomeView {

    private static final String TAG = HomeActivity.class.getName();
    IHomeController controller;
    BottomNavigationView bottomNavigationView;

    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        this.bottomNavigationView = findViewById(R.id.bottomNavigationView);
        this.controller = new HomeController(this, getSupportFragmentManager());
        bottomNavigationView.setOnItemSelectedListener(controller);
        bottomNavigationView.setSelectedItemId(R.id.home);
    }
}