package com.epitech.redditech.Models.Generic;

import com.google.gson.annotations.SerializedName;

public class KindListResponse<T> {
    @SerializedName("data")
    private ListResponse<T> mContent;
    @SerializedName("kind")
    private String mKind;

    public ListResponse<T> getData() {
        return mContent;
    }

    public void setData(ListResponse<T> listContent) {
        mContent = listContent;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }
}
