package com.epitech.redditech.Controllers.Login;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.util.Log;

import com.epitech.redditech.App;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.Controllers.Network.INetworkClient;
import com.epitech.redditech.Models.Token.AccessTokenResponse;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Login.ILoginView;

import org.jetbrains.annotations.NotNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginController implements ILoginController {
    private static final String AUTH_URL =
            "https://www.reddit.com/api/v1/authorize.compact?client_id=%s" +
                    "&response_type=code&state=%s&redirect_uri=%s&" +
                    "duration=permanent&scope=identity read mysubreddits vote";

    private static final String ACCESS_TOKEN_URL =
            "https://www.reddit.com/";
    private static final String TAG = LoginController.class.getName();

    public ILoginView loginView;

    public LoginController(ILoginView loginView) {
        this.loginView = loginView;
    }

    public Intent openRedditLogin() {
        String url = String.format(AUTH_URL, NetworkClientInstance.CLIENT_ID, NetworkClientInstance.STATE, NetworkClientInstance.REDIRECT_URI);
        return (new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
    }

    public void onLogin(String code) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ACCESS_TOKEN_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        INetworkClient netClient = retrofit.create(INetworkClient.class);
        Call<AccessTokenResponse> accessTokenCall = netClient.getAccessToken(
                "authorization_code",
                code,
                NetworkClientInstance.REDIRECT_URI
        );
        accessTokenCall.enqueue(new Callback<AccessTokenResponse>() {
            @Override
            public void onResponse(@NotNull Call<AccessTokenResponse> call, @NotNull Response<AccessTokenResponse> response) {
                assert response.body() != null;
                Long expiresIn = response.body().getExpiresIn();
                Long expiresTime = System.currentTimeMillis() + (expiresIn * 1000);
                saveTokens(response.body().getAccessToken(), response.body().getRefreshToken(), expiresTime);
                NetworkClientInstance.createNetworkClient(response.body().getAccessToken());
                loginView.onLoginSuccess();
            }

            @Override
            public void onFailure(Call<AccessTokenResponse> call, Throwable t) {
                t.printStackTrace();
                loginView.onLoginFailure(t.getMessage());
            }
        });
    }

    public void saveTokens(String accessToken, String refreshToken, Long expiresTime) {
        Context context = App.getContext();
        SharedPreferences.Editor sharedPref =
                context.getSharedPreferences(context.getResources().getString(R.string.auth), Context.MODE_PRIVATE).edit();
        sharedPref.putString(context.getResources().getString(R.string.access_token), accessToken);
        sharedPref.putString(context.getResources().getString(R.string.refresh_token), refreshToken);
        sharedPref.putLong(context.getResources().getString(R.string.expires), expiresTime);
        sharedPref.apply();
    }

    public void onDestroy() {
        loginView = null;
    }

}
