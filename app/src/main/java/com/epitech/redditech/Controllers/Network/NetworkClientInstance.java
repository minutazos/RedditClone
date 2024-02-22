package com.epitech.redditech.Controllers.Network;

import com.epitech.redditech.Controllers.Network.Interceptors.TokenAuthenticator;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkClientInstance {

    private static final String BASE_URL = "https://oauth.reddit.com/";
    public static final String CLIENT_ID = "fUZ6HfiDAfwHbSPqj_j_cA";
    public static final String STATE = "RANDOM_STRING";
    public static final String REDIRECT_URI =
            "epitech://redditech/oauth2redirect";
    private static Retrofit retrofit;
    private static OkHttpClient client;
    public static INetworkClient iNetworkClient = null;


    public static void createNetworkClient(String token) {
        client = createClient(token);
        retrofit = new retrofit2.Retrofit.Builder()
                .client(client)
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        iNetworkClient = retrofit.create(INetworkClient.class);
    }

    public static INetworkClient getNetworkInstance() {
        if (retrofit == null || iNetworkClient == null) {
            client = createClient("");
            retrofit = new retrofit2.Retrofit.Builder()
                    .client(client)
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
            iNetworkClient = retrofit.create(INetworkClient.class);
        }
        return (iNetworkClient);
    }

    private static OkHttpClient createClient(String token) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.writeTimeout(30, TimeUnit.SECONDS);
        builder.authenticator(new TokenAuthenticator());
        builder.addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Authorization", "Bearer " + token)
                    .build();
            return (chain.proceed(newRequest));
        });
        return (builder.build());
    }

}
