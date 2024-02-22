package com.epitech.redditech.Controllers.Home;

import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;

import com.epitech.redditech.Controllers.Network.INetworkClient;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Home.IHomeView;
import com.epitech.redditech.Views.Search.SearchFragment;
import com.epitech.redditech.Views.Subreddit.SubredditFragment;
import com.epitech.redditech.Views.User.UserFragment;

import org.jetbrains.annotations.NotNull;

public class HomeController implements IHomeController {
    private static final String TAG = HomeController.class.getName();

    public IHomeView homeView;
    private final INetworkClient client = NetworkClientInstance.getNetworkInstance();

    FragmentManager fgManager;
    SubredditFragment subredditFragment = new SubredditFragment();
    SearchFragment searchFragment = new SearchFragment();
    UserFragment userFragment = new UserFragment();

    public HomeController(IHomeView homeView, FragmentManager fgManager) {
        this.homeView = homeView;
        this.fgManager = fgManager;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.search) {
            fgManager.beginTransaction().replace(R.id.flFragment, searchFragment).commit();
            return true;
        } else if (itemId == R.id.account) {
            fgManager.beginTransaction().replace(R.id.flFragment, userFragment).commit();
            return true;
        } else if (itemId == R.id.home) {
            fgManager.beginTransaction().replace(R.id.flFragment, subredditFragment).commit();
            return true;
        }

        return false;
    }
}
