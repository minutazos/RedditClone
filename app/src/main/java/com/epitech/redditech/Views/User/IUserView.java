package com.epitech.redditech.Views.User;

import android.widget.Switch;

public interface IUserView {
    void setText(String name);
    void setProfileImg(String url);
    void setFollowersEnabled(Boolean enabled);
    void setCountryCode(String country);
    void setChatRequest(Boolean chat_request);
    void setEmailNewFollower(Boolean email_new_follower);
    void setUnsubscribeEmail(Boolean unsubscribe_email);
}