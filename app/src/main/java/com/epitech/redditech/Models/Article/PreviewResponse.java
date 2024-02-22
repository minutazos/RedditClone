package com.epitech.redditech.Models.Article;

import java.util.List;

import com.epitech.redditech.Models.Image.ImageResponse;
import com.google.gson.annotations.SerializedName;

public class PreviewResponse {

    @SerializedName("enabled")
    private Boolean mEnabled;
    @SerializedName("images")
    private List<ImageResponse> mImageResponses;

    public Boolean getEnabled() {
        return mEnabled;
    }

    public void setEnabled(Boolean enabled) {
        mEnabled = enabled;
    }

    public List<ImageResponse> getImages() {
        return mImageResponses;
    }

    public void setImages(List<ImageResponse> imageResponses) {
        mImageResponses = imageResponses;
    }

}
