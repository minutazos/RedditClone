package com.epitech.redditech.Views.Search;

import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindResponse;

import java.util.HashMap;
import java.util.List;

public interface ISearchView {
    void setArticles(List<KindResponse<ArticleDataResponse>> articles, String after);
    void setIconMap(HashMap<String, String> map);
}
