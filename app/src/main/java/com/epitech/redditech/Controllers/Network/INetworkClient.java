package com.epitech.redditech.Controllers.Network;

import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindListResponse;
import com.epitech.redditech.Models.Generic.KindResponse;
import com.epitech.redditech.Models.Subreddit.SubredditDataResponse;
import com.epitech.redditech.Models.Token.AccessTokenResponse;
import com.epitech.redditech.Models.Token.RefreshTokenResponse;
import com.epitech.redditech.Models.User.UserResponse;
import com.epitech.redditech.Models.User.PrefsResponses;

import org.json.JSONObject;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.PATCH;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

public interface INetworkClient {

    @Headers({
            "Authorization: Basic ZlVaNkhmaURBZndIYlNQcWpfal9jQTo=",
            "User-Agent: Redditech"
    })
    @POST("api/v1/access_token")
    @FormUrlEncoded
    Call<AccessTokenResponse> getAccessToken(
            @Field("grant_type") String grantType,
            @Field("code") String code,
            @Field("redirect_uri") String redirectUri
    );

    @Headers({
            "Authorization: Basic ZlVaNkhmaURBZndIYlNQcWpfal9jQTo=",
            "User-Agent: Redditech"
    })
    @POST("api/v1/access_token")
    @FormUrlEncoded
    Call<RefreshTokenResponse> refreshToken(
        @Field("grant_type") String grantType,
        @Field("refresh_token") String refreshToken
    );

    @GET("api/v1/me/prefs")
    Call<PrefsResponses> getUserPrefs();

    @PATCH("api/v1/me/prefs")
    Call<ResponseBody> setUserPrefs(@Body PrefsResponses JSONObject);

    @GET("api/v1/me")
    Call<UserResponse> getUserInfo();

    @GET
    Call<ResponseBody> getImg(@Url String url);

    @GET("r/{subreddit}/new")
    Call<KindListResponse<ArticleDataResponse>> getSubredditArticles(@Path("subreddit") String subreddit, @Query("after") String after);

    @GET("subreddits/mine/subscriber")
    Call<KindListResponse<SubredditDataResponse>> getSubscribedSubreddits();

    @GET("r/{subreddit}/about")
    Call<KindResponse<SubredditDataResponse>> getSubredditData(@Path("subreddit") String subreddit);

    @GET("best")
    Call<KindListResponse<ArticleDataResponse>> getBestArticlesFromSubscribed(@Query("after") String after);

    @GET("new")
    Call<KindListResponse<ArticleDataResponse>> getNewArticlesFromSubscribed(@Query("after") String after);

    @GET("hot")
    Call<KindListResponse<ArticleDataResponse>> getHotArticlesFromSubscribed(@Query("after") String after);

    @GET("random")
    Call<List<KindListResponse<ArticleDataResponse>>> getRandomArticlesFromSubscribed();

    @GET("search")
    Call<KindListResponse<ArticleDataResponse>> getSearch(@Query("q") String query, @Query("after") String after);

    @POST("api/vote")
    @FormUrlEncoded
    Call<ResponseBody> vote(@Field("id") String id,
                            @Field("dir") int dir,
                            @Field("rank") int rank);
}
