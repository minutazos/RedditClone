package com.epitech.redditech.Views.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.epitech.redditech.Controllers.Network.INetworkClient;
import com.epitech.redditech.Controllers.Network.NetworkClientInstance;
import com.epitech.redditech.Controllers.User.UserController;
import com.epitech.redditech.Controllers.User.IUserController;
import com.epitech.redditech.R;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserActivity extends AppCompatActivity implements IUserView {

    private static final String TAG = UserActivity.class.getName();
    IUserController controller = new UserController(this);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user);
        controller.getName();
        controller.getProfileImg();
        controller.getFollowersEnabled();
        controller.getChatRequest();
        controller.getCountryCode();
        controller.getEmailNewFollower();
        controller.getUnsubscribeEmail();
    }

    @SuppressLint("SetTextI18n")
    public void setText(String name) {
        TextView result = findViewById(R.id.user);
        result.setText(name);
    }

    @Override
    public void setProfileImg(String url) {
        Picasso.with(this).
                load(url).
                into((ImageView) findViewById(R.id.iconImg));
    }

    @Override
    public void setFollowersEnabled(Boolean enabled) {
        Switch enable = (Switch) findViewById(R.id.FollowersEnabled);
        enable.setChecked(enabled);
    }

    @Override
    public void setCountryCode(String country) {
    }

    @Override
    public void setChatRequest(Boolean chat_request) {
        Switch chat = (Switch) findViewById(R.id.ChatRequest);
        chat.setChecked(chat_request);
    }

    @Override
    public void setEmailNewFollower(Boolean email_new_follower) {
        Switch email = (Switch) findViewById(R.id.EmailNewFollower);
        email.setChecked(email_new_follower);
    }

    @Override
    public void setUnsubscribeEmail(Boolean unsubscribe_email) {
        Switch unsubsribe = (Switch) findViewById(R.id.UnsubscribeEmail);
        unsubsribe.setChecked(unsubscribe_email);
    }
}