package com.epitech.redditech.Controllers.Search;

import com.epitech.redditech.Controllers.IArticleViewerController;
import com.epitech.redditech.Controllers.Network.INetworkClient;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindListResponse;
import com.epitech.redditech.Views.Search.ISearchView;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchController implements ISearchController, IArticleViewerController {

    public ISearchView searchView;
    private String after;
    private final INetworkClient client = NetworkClientInstance.getNetworkInstance();

    public SearchController(ISearchView searchView) {
        this.after = "";
        this.searchView = searchView;
    }

    public void setNewAfter(String after){
        this.after = after;
    }

    public void getSubredditIcons() {
        HashMap<String, String> iconMap = new HashMap<>();
        searchView.setIconMap(iconMap);
    }

    @Override
    public void getArticles(String query) {
        Call<KindListResponse<ArticleDataResponse>> call = client.getSearch(query, this.after);
        call.enqueue(new Callback<KindListResponse<ArticleDataResponse>>() {
            @Override
            public void onResponse(Call<KindListResponse<ArticleDataResponse>> call, Response<KindListResponse<ArticleDataResponse>> response) {
                searchView.setArticles(response.body().getData().getChildren(), response.body().getData().getAfter());
            }

            @Override
            public void onFailure(Call<KindListResponse<ArticleDataResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void upVote(String id) {
        Call<ResponseBody> call = client.vote("t3_" + id, 1, 2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void downVote(String id) {
        Call<ResponseBody> call = client.vote("t3_" + id, -1, 2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void unVote(String id) {
        Call<ResponseBody> call = client.vote("t3_" + id, 0, 2);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
