package com.epitech.redditech.Controllers.Subreddit;

import androidx.lifecycle.LiveData;

import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

import java.util.HashMap;

public interface ISubredditController extends NavigationBarView.OnItemSelectedListener{
    void getNewArticles();
    void getBestArticles();
    void getHotArticles();
    void setNewAfter(String after);
    void getSubredditIcons();
    LiveData<HashMap<String, String>> getIconMutableLiveMap();
}
