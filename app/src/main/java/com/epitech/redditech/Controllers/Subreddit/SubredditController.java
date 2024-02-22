package com.epitech.redditech.Controllers.Subreddit;

import android.annotation.SuppressLint;
import android.view.MenuItem;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.epitech.redditech.Controllers.IArticleViewerController;
import com.epitech.redditech.Controllers.Network.INetworkClient;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindListResponse;
import com.epitech.redditech.Models.Generic.KindResponse;
import com.epitech.redditech.Models.Subreddit.SubredditDataResponse;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Subreddit.ISubredditView;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SubredditController implements ISubredditController, IArticleViewerController {
    private static final String TAG = SubredditController.class.getName();

    public ISubredditView subredditView;
    private final INetworkClient client = NetworkClientInstance.getNetworkInstance();
    private String after;
    private MutableLiveData<HashMap<String, String>> _iconLiveMap;

    public SubredditController(ISubredditView subredditView) {
        this.subredditView = subredditView;
        this.after = "";
        this._iconLiveMap = new MutableLiveData<>();
        getSubredditIcons();
    }


    public void setNewAfter(String after) {
        this.after = after;
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

    public void getSubredditIcons() {
        Call<KindListResponse<SubredditDataResponse>> call = client.getSubscribedSubreddits();
        call.enqueue(new Callback<KindListResponse<SubredditDataResponse>>() {
            @Override
            public void onResponse(Call<KindListResponse<SubredditDataResponse>> call, Response<KindListResponse<SubredditDataResponse>> response) {
                HashMap<String, String> iconMap = new HashMap<>();
                for (KindResponse<SubredditDataResponse> subreddit : response.body().getData().getChildren())
                    iconMap.put(subreddit.getData().getName(), subreddit.getData().getIconImg());
                _iconLiveMap.setValue(iconMap);
                subredditView.setIconMap(iconMap);
            }

            @Override
            public void onFailure(Call<KindListResponse<SubredditDataResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public LiveData<HashMap<String, String>> getIconMutableLiveMap() {
        if (this._iconLiveMap == null) {
            this._iconLiveMap = new MutableLiveData<>();
            getSubredditIcons();
        }
        return (this._iconLiveMap);
    }

    @Override
    public void getNewArticles() {
        Call<KindListResponse<ArticleDataResponse>> call = client.getNewArticlesFromSubscribed(this.after);
        call.enqueue(new Callback<KindListResponse<ArticleDataResponse>>() {
            @Override
            public void onResponse(Call<KindListResponse<ArticleDataResponse>> call, Response<KindListResponse<ArticleDataResponse>> response) {
                assert response.body() != null;
                subredditView.setArticles(response.body().getData().getChildren(), response.body().getData().getAfter(), "new");
            }

            @Override
            public void onFailure(Call<KindListResponse<ArticleDataResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getBestArticles() {
        Call<KindListResponse<ArticleDataResponse>> call = client.getBestArticlesFromSubscribed(this.after);
        call.enqueue(new Callback<KindListResponse<ArticleDataResponse>>() {
            @Override
            public void onResponse(Call<KindListResponse<ArticleDataResponse>> call, Response<KindListResponse<ArticleDataResponse>> response) {
                assert response.body() != null;
                subredditView.setArticles(response.body().getData().getChildren(), response.body().getData().getAfter(), "best");
            }

            @Override
            public void onFailure(Call<KindListResponse<ArticleDataResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getHotArticles() {
        Call<KindListResponse<ArticleDataResponse>> call = client.getHotArticlesFromSubscribed(this.after);
        call.enqueue(new Callback<KindListResponse<ArticleDataResponse>>() {
            @Override
            public void onResponse(Call<KindListResponse<ArticleDataResponse>> call, Response<KindListResponse<ArticleDataResponse>> response) {
                assert response.body() != null;
                subredditView.setArticles(response.body().getData().getChildren(), response.body().getData().getAfter(), "hot");
            }

            @Override
            public void onFailure(Call<KindListResponse<ArticleDataResponse>> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onNavigationItemSelected(@NonNull @NotNull MenuItem item) {
        int itemId = item.getItemId();

        if (itemId == R.id.bestMenu) {
            getBestArticles();
            return true;
        } else if (itemId == R.id.newMenu) {
            getNewArticles();
            return true;
        } else if (itemId == R.id.hotMenu) {
            getHotArticles();
            return true;
        }
        return false;
    }
}
