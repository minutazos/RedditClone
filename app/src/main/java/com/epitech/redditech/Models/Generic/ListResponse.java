package com.epitech.redditech.Models.Generic;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ListResponse<T> {
    public enum KINDS {
        COMMENT,
        ACCOUNT,
        POST,
        MESSAGE,
        SUBREDDIT,
        AWARD
    };

    @SerializedName("after")
    private String mAfter;
    @SerializedName("dist")
    private Long mDist;
    @SerializedName("geo_filter")
    private Object mGeoFilter;
    @SerializedName("before")
    private Object mBefore;
    @SerializedName("modhash")
    private Object mModhash;
    @SerializedName("children")
    private List<KindResponse<T>> mChildren;


    public String getAfter() {
        return mAfter;
    }

    public void setAfter(String after) {
        mAfter = after;
    }

    public Long getDist() {
        return mDist;
    }

    public void setDist(Long mDist) {
        this.mDist = mDist;
    }

    public Object getGeoFilter() {
        return mGeoFilter;
    }

    public void setGeoFilter(Object mGeoFilter) {
        this.mGeoFilter = mGeoFilter;
    }

    public Object getBefore() {
        return mBefore;
    }

    public void setBefore(Object mBefore) {
        this.mBefore = mBefore;
    }

    public Object getModhash() {
        return mModhash;
    }

    public void setModhash(Object mModhash) {
        this.mModhash = mModhash;
    }

    public List<KindResponse<T>> getChildren() {
        return mChildren;
    }

    public void setChildren(List<KindResponse<T>> children) {
        this.mChildren = children;
    }
}
