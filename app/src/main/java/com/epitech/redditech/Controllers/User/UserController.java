package com.epitech.redditech.Controllers.User;

import com.epitech.redditech.Controllers.Network.INetworkClient;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.Models.User.PrefsResponses;
import com.epitech.redditech.Models.User.UserResponse;
import com.epitech.redditech.Views.User.IUserView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserController implements IUserController {
    private static final String TAG = UserController.class.getName();

    public IUserView userView;
    private final INetworkClient client = NetworkClientInstance.getNetworkInstance();

    public UserController(IUserView userView) { this.userView = userView; }
    public void getName() {
        Call<UserResponse> call = client.getUserInfo();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                userView.setText(response.body().getUserName());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getProfileImg() {
        Call<UserResponse> call = client.getUserInfo();
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                assert response.body() != null;
                userView.setProfileImg(response.body().getIconImg());
            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getFollowersEnabled() {
        Call<PrefsResponses> call = client.getUserPrefs();
        call.enqueue(new Callback<PrefsResponses>() {
            @Override
            public void onResponse(Call<PrefsResponses> call, Response<PrefsResponses> response) {
                userView.setFollowersEnabled(response.body().getFollowers());
            }

            @Override
            public void onFailure(Call<PrefsResponses> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getCountryCode() {
        Call<PrefsResponses> call = client.getUserPrefs();
        call.enqueue(new Callback<PrefsResponses>() {
            @Override
            public void onResponse(Call<PrefsResponses> call, Response<PrefsResponses> response) {
                userView.setCountryCode(response.body().getCountry());
            }

            @Override
            public void onFailure(Call<PrefsResponses> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getChatRequest() {
        Call<PrefsResponses> call = client.getUserPrefs();
        call.enqueue(new Callback<PrefsResponses>() {
            @Override
            public void onResponse(Call<PrefsResponses> call, Response<PrefsResponses> response) {
                userView.setChatRequest(response.body().getChatRequest());
            }

            @Override
            public void onFailure(Call<PrefsResponses> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getEmailNewFollower() {
        Call<PrefsResponses> call = client.getUserPrefs();
        call.enqueue(new Callback<PrefsResponses>() {
            @Override
            public void onResponse(Call<PrefsResponses> call, Response<PrefsResponses> response) {
                userView.setEmailNewFollower(response.body().getEmailNewFollower());
            }

            @Override
            public void onFailure(Call<PrefsResponses> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    @Override
    public void getUnsubscribeEmail() {
        Call<PrefsResponses> call = client.getUserPrefs();
        call.enqueue(new Callback<PrefsResponses>() {
            @Override
            public void onResponse(Call<PrefsResponses> call, Response<PrefsResponses> response) {
                userView.setUnsubscribeEmail(response.body().getUnsubsribeEmails());
            }

            @Override
            public void onFailure(Call<PrefsResponses> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
