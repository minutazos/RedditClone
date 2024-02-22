package com.epitech.redditech.Controllers.Network.Interceptors;

import android.content.Context;
import android.content.SharedPreferences;

import androidx.annotation.NonNull;

import com.epitech.redditech.App;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.Models.Token.RefreshTokenResponse;
import com.epitech.redditech.R;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.io.IOException;

import okhttp3.Authenticator;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;

public class TokenAuthenticator implements Authenticator {

    @Nullable
    @Override
    public Request authenticate(@Nullable Route route, @NotNull Response response) throws IOException {
        String accessToken = getAccessToken();
        if (!isRequestWithAccessToken(response) || accessToken == null)
            return (null);
        synchronized (this) {
            final String newAccessToken = getAccessToken();
            if (!accessToken.equals(newAccessToken)) {
                return (newRequestWithAccessToken(response.request(), newAccessToken));
            }

            final String updatedAccessToken = updateAccessToken();
            return (newRequestWithAccessToken(response.request(), updatedAccessToken));
        }
    }

    private String updateAccessToken() throws IOException {
        String accessToken = getAccessToken();
        Context context = App.getContext();
        retrofit2.Response<RefreshTokenResponse> retResponse = NetworkClientInstance.getNetworkInstance().refreshToken(
                "refresh_token",
                accessToken
        ).execute();
        if (retResponse != null) {
            accessToken = retResponse.body().getAccessToken();
            Long expiresIn = retResponse.body().getExpiresIn();
            SharedPreferences.Editor prefs = context.getSharedPreferences(
                    context.getResources().getString(R.string.auth), Context.MODE_PRIVATE).edit();
            prefs.putString(context.getResources().getString(R.string.access_token), accessToken);
            prefs.putLong(context.getResources().getString(R.string.expires), expiresIn);
            prefs.apply();
            return (accessToken);
        }
        return accessToken;
    }

    private String getAccessToken() {
        Context context = App.getContext();
        SharedPreferences prefs = context.getSharedPreferences(
                context.getResources().getString(R.string.auth), Context.MODE_PRIVATE);
        return (prefs.getString(context.getResources().getString(R.string.refresh_token), null));
    }
    @NonNull
    private Request newRequestWithAccessToken(@NonNull Request request, @NonNull String accessToken) {
        return request.newBuilder()
                .header("Authorization", "Bearer " + accessToken)
                .build();
    }

    private boolean isRequestWithAccessToken(@NonNull Response response) {
        String header = response.request().header("Authorization");
        return header != null && header.startsWith("Bearer");
    }
}
