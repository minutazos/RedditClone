package com.epitech.redditech.Models.User;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PrefsResponses {

    @SerializedName("enable_followers")
    private Boolean followers;

    @SerializedName("country_code")
    private String country;

    @SerializedName("email_chat_request")
    private Boolean chat_request;

    @SerializedName("email_user_new_follower")
    private Boolean email_new_follower;

    @SerializedName("email_unsubscribe_all")
    private  Boolean unsubsribe_emails;

    public Boolean getFollowers() { return followers; }
    public void setFollowers(Boolean followers) { this.followers = followers; }

    public String getCountry() { return country; }
    public void setCountry(String country) { this.country = country; }

    public Boolean getChatRequest() { return chat_request; }
    public void setChatRequest(Boolean chat_request) { this.chat_request = chat_request; }

    public Boolean getEmailNewFollower() { return email_new_follower; }
    public void setEmailNewFollower(Boolean email_new_follower) { this.email_new_follower = email_new_follower; }

    public Boolean getUnsubsribeEmails() { return unsubsribe_emails; }
    public void setUnsubsribeEmails(Boolean unsubsribe_emails) { this.unsubsribe_emails = unsubsribe_emails; }
}