package com.epitech.redditech.Models.Generic;

import com.google.gson.annotations.SerializedName;

public class KindResponse<T> {
    @SerializedName("data")
    private T mContent;
    @SerializedName("kind")
    private String mKind;

    public T getData() {
        return mContent;
    }

    public void setData(T listContent) {
        mContent = listContent;
    }

    public String getKind() {
        return mKind;
    }

    public void setKind(String kind) {
        mKind = kind;
    }
}
