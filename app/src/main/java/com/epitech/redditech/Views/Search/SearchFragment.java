package com.epitech.redditech.Views.Search;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.ImageButton;

import com.epitech.redditech.Controllers.IArticleViewerController;
import com.epitech.redditech.Controllers.Search.ISearchController;
import com.epitech.redditech.Controllers.Search.SearchController;
import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindResponse;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Helpers.EndlessRecyclerViewScrollListener;
import com.epitech.redditech.Views.Subreddit.ArticlesAdapter;

import java.util.HashMap;
import java.util.List;


public class SearchFragment extends Fragment implements ISearchView, ArticlesAdapter.ItemClickListener {

    private static final String TAG = SearchFragment.class.getName();
    ISearchController controller = new SearchController(this);
    private ViewGroup container;
    private EditText searchQuery;
    private ImageButton searchButton;
    private RecyclerView rView;
    private HashMap<String, String> iconMap = new HashMap<>();
    private EndlessRecyclerViewScrollListener scollListener;
    private String query;
    private ArticlesAdapter adapter;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.container = container;
        View view = inflater.inflate(R.layout.fragment_search, container, false);
        this.searchQuery = view.findViewById(R.id.searchSubredditQuery);
        this.searchButton = view.findViewById(R.id.searchButton);
        this.searchButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!searchQuery.getText().toString().isEmpty()) {
                    query = searchQuery.getText().toString();
                    controller.getArticles(query);
                    InputMethodManager inputManager = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    inputManager.hideSoftInputFromWindow(getActivity().getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
                }
            }
        });
        return view;
    }

    @Override
    public void setIconMap(HashMap<String, String> map) {
        this.iconMap = map;
    }

    @Override
    public void setArticles(List<KindResponse<ArticleDataResponse>> articles, String after) {
        RecyclerView rvItems = getView().findViewById(R.id.fragment_subreddit_search);
        this.rView = rvItems;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this.container.getContext());
        controller.setNewAfter(after);
        rvItems.setLayoutManager(layoutManager);
        this.scollListener = new EndlessRecyclerViewScrollListener(layoutManager) {
            @Override
            public void onLoadMore(int page, int totalItemsCount, RecyclerView view) {
                controller.getArticles(query);
            }
        };
        adapter = new ArticlesAdapter(this.container.getContext(), articles, (IArticleViewerController) controller, this.iconMap);
        adapter.setClickListener(this);
        rvItems.setAdapter(adapter);
        rvItems.addOnScrollListener(scollListener);
    }

    @Override
    public void onItemClick(View view, int position) {
    }
}