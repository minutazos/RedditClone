package com.epitech.redditech.Views.User;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.epitech.redditech.Controllers.User.IUserController;
import com.epitech.redditech.Controllers.User.UserController;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.User.IUserView;
import com.epitech.redditech.Views.User.UserActivity;
import com.squareup.picasso.Picasso;

public class UserFragment extends Fragment implements IUserView {

    private static final String TAG = UserFragment.class.getName();
    IUserController controller = new UserController(this);

    public UserFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_user, container, false);
        controller.getName();
        controller.getProfileImg();
        controller.getFollowersEnabled();
        controller.getChatRequest();
        controller.getCountryCode();
        controller.getEmailNewFollower();
        controller.getUnsubscribeEmail();
        return (view);
    }

    @SuppressLint("SetTextI18n")
    public void setText(String name) {
        TextView result = getView().findViewById(R.id.user);
        result.setText(name);
    }

    @Override
    public void setProfileImg(String url) {
        /*Picasso.with(this).
                load(url).
                into((ImageView) getView().findViewById(R.id.iconImg));*/
    }

    @Override
    public void setFollowersEnabled(Boolean enabled) {
        Switch enable = (Switch) getView().findViewById(R.id.FollowersEnabled);
        enable.setChecked(enabled);
    }

    @Override
    public void setCountryCode(String country) {
    }

    @Override
    public void setChatRequest(Boolean chat_request) {
        Switch chat = (Switch) getView().findViewById(R.id.ChatRequest);
        chat.setChecked(chat_request);
    }

    @Override
    public void setEmailNewFollower(Boolean email_new_follower) {
        Switch email = (Switch) getView().findViewById(R.id.EmailNewFollower);
        email.setChecked(email_new_follower);
    }

    @Override
    public void setUnsubscribeEmail(Boolean unsubscribe_email) {
        Switch unsubsribe = (Switch) getView().findViewById(R.id.UnsubscribeEmail);
        unsubsribe.setChecked(unsubscribe_email);
    }
}