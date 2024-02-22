package com.epitech.redditech.Views.Subreddit;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.epitech.redditech.Controllers.IArticleViewerController;
import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindResponse;
import com.epitech.redditech.Controllers.Subreddit.ISubredditController;
import com.epitech.redditech.Controllers.Subreddit.SubredditController;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Helpers.EndlessRecyclerViewScrollListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.HashMap;
import java.util.List;

public class SubredditFragment extends Fragment implements ISubredditView, ArticlesAdapter.ItemClickListener {

    private static final String TAG = SubredditFragment.class.getName();
    ISubredditController controller = new SubredditController(this);
    private EndlessRecyclerViewScrollListener scrollListener;
    private ArticlesAdapter adapter;
    private HashMap<String, String> iconMap = new HashMap<>();
    private ViewGroup container;
    private RecyclerView rView;
    private BottomNavigationView topNavigationView;
    private String typeArticles;

    public SubredditFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        controller.getNewArticles();
        this.container = container;
        View view = inflater.inflate(R.layout.activity_subreddit, container, false);
        this.topNavigationView = view.findViewById(R.id.subredditTopNavigation);
        topNavigationView.setOnItemSelectedListener(this.controller);
        return (view);
    }

    @Override
    public void onItemClick(View view, int position) {
    }

    @Override
    public void setIconMap(HashMap<String, String> map) {
        this.iconMap = map;
    }

    @Override
    public void setArticles(List<KindResponse<ArticleDataResponse>> articles, String after, String typeArticles) {
        controller.getSubredditIcons();
        RecyclerView rvItems = getView().findViewById(R.id.fragment_article);
        this.typeArticles = typeArticles;
        this.rView = rvItems;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.container.getContext());
        rvItems.setLayoutManager(layoutManager);
        controller.setNewAfter(after);
        scrollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                if (typeArticles.equals("new"))
                    controller.getNewArticles();
                else if (typeArticles.equals("best"))
                    controller.getBestArticles();
                else
                    controller.getHotArticles();
            }
        };
        adapter = new ArticlesAdapter(this.container.getContext(), articles, (IArticleViewerController) controller, this.iconMap);
        adapter.setClickListener(this);
        rvItems.setAdapter(adapter);
        rvItems.addOnScrollListener(scrollListener);
    }
}