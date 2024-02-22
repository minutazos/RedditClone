package com.epitech.redditech.Models.Image;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class ImageResponse {

    @SerializedName("id")
    private String mId;
    @SerializedName("resolutions")
    private List<SourceResponse> mResolutions;
    @SerializedName("source")
    private SourceResponse mSourceResponse;

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public List<SourceResponse> getResolutions() {
        return mResolutions;
    }

    public void setResolutions(List<SourceResponse> resolutions) {
        mResolutions = resolutions;
    }

    public SourceResponse getSource() {
        return mSourceResponse;
    }

    public void setSource(SourceResponse sourceResponse) {
        mSourceResponse = sourceResponse;
    }
}
