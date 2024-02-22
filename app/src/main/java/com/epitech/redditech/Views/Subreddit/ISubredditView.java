package com.epitech.redditech.Views.Subreddit;

import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindResponse;

import java.util.HashMap;
import java.util.List;

public interface ISubredditView {
    void setArticles(List<KindResponse<ArticleDataResponse>> articles, String after, String typeArticles);
    void setIconMap(HashMap<String, String> map);
}
