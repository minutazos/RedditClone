package com.epitech.redditech.Models.Subreddit;

import java.util.List;

import com.epitech.redditech.Models.Image.ImageResponse;
import com.google.gson.annotations.SerializedName;


public class SubredditDataResponse {

    @SerializedName("accept_followers")
    private Boolean mAcceptFollowers;
    @SerializedName("accounts_active")
    private Object mAccountsActive;
    @SerializedName("community_icon")
    private String mCommunityIcon;
    @SerializedName("community_reviewed")
    private Boolean mCommunityReviewed;
    @SerializedName("created")
    private Double mCreated;
    @SerializedName("created_utc")
    private Double mCreatedUtc;
    @SerializedName("description")
    private String mDescription;
    @SerializedName("display_name")
    private String mDisplayName;
    @SerializedName("display_name_prefixed")
    private String mDisplayNamePrefixed;
    @SerializedName("header_img")
    private ImageResponse mHeaderImg;
    @SerializedName("header_title")
    private String mHeaderTitle;
    @SerializedName("icon_img")
    private String mIconImg;
    @SerializedName("icon_size")
    private List<Long> mIconSize;
    @SerializedName("id")
    private String mId;
    @SerializedName("lang")
    private String mLang;
    @SerializedName("mobile_banner_image")
    private String mMobileBannerImage;
    @SerializedName("name")
    private String mName;
    @SerializedName("over18")
    private Boolean mOver18;
    @SerializedName("public_description")
    private String mPublicDescription;
    @SerializedName("restrict_commenting")
    private Boolean mRestrictCommenting;
    @SerializedName("restrict_posting")
    private Boolean mRestrictPosting;
    @SerializedName("subreddit_type")
    private String mSubredditType;
    @SerializedName("subscribers")
    private Long mSubscribers;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user_has_favorited")
    private Boolean mUserHasFavorited;
    @SerializedName("user_is_banned")
    private Boolean mUserIsBanned;
    @SerializedName("user_is_contributor")
    private Boolean mUserIsContributor;
    @SerializedName("user_is_moderator")
    private Boolean mUserIsModerator;
    @SerializedName("user_is_muted")
    private Boolean mUserIsMuted;
    @SerializedName("user_is_subscriber")
    private Boolean mUserIsSubscriber;

    public Boolean getAcceptFollowers() {
        return mAcceptFollowers;
    }

    public void setAcceptFollowers(Boolean acceptFollowers) {
        mAcceptFollowers = acceptFollowers;
    }

    public Object getAccountsActive() {
        return mAccountsActive;
    }

    public void setAccountsActive(Object accountsActive) {
        mAccountsActive = accountsActive;
    }

    public String getCommunityIcon() {
        return mCommunityIcon;
    }

    public void setCommunityIcon(String communityIcon) {
        mCommunityIcon = communityIcon;
    }

    public Boolean getCommunityReviewed() {
        return mCommunityReviewed;
    }

    public void setCommunityReviewed(Boolean communityReviewed) {
        mCommunityReviewed = communityReviewed;
    }

    public Double getCreated() {
        return mCreated;
    }

    public void setCreated(Double created) {
        mCreated = created;
    }

    public Double getCreatedUtc() {
        return mCreatedUtc;
    }

    public void setCreatedUtc(Double createdUtc) {
        mCreatedUtc = createdUtc;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public String getDisplayName() {
        return mDisplayName;
    }

    public void setDisplayName(String displayName) {
        mDisplayName = displayName;
    }

    public String getDisplayNamePrefixed() {
        return mDisplayNamePrefixed;
    }

    public void setDisplayNamePrefixed(String displayNamePrefixed) {
        mDisplayNamePrefixed = displayNamePrefixed;
    }

    public ImageResponse getHeaderImg() {
        return mHeaderImg;
    }

    public void setHeaderImg(ImageResponse headerImg) {
        mHeaderImg = headerImg;
    }

    public String getHeaderTitle() {
        return mHeaderTitle;
    }

    public void setHeaderTitle(String headerTitle) {
        mHeaderTitle = headerTitle;
    }

    public String getIconImg() {
        return mIconImg;
    }

    public void setIconImg(String iconImg) {
        mIconImg = iconImg;
    }

    public List<Long> getIconSize() {
        return mIconSize;
    }

    public void setIconSize(List<Long> iconSize) {
        mIconSize = iconSize;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public String getLang() {
        return mLang;
    }

    public void setLang(String lang) {
        mLang = lang;
    }

    public String getMobileBannerImage() {
        return mMobileBannerImage;
    }

    public void setMobileBannerImage(String mobileBannerImage) {
        mMobileBannerImage = mobileBannerImage;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getOver18() {
        return mOver18;
    }

    public void setOver18(Boolean over18) {
        mOver18 = over18;
    }

    public String getPublicDescription() {
        return mPublicDescription;
    }

    public void setPublicDescription(String publicDescription) {
        mPublicDescription = publicDescription;
    }

    public Boolean getRestrictCommenting() {
        return mRestrictCommenting;
    }

    public void setRestrictCommenting(Boolean restrictCommenting) {
        mRestrictCommenting = restrictCommenting;
    }

    public Boolean getRestrictPosting() {
        return mRestrictPosting;
    }

    public void setRestrictPosting(Boolean restrictPosting) {
        mRestrictPosting = restrictPosting;
    }

    public String getSubredditType() {
        return mSubredditType;
    }

    public void setSubredditType(String subredditType) {
        mSubredditType = subredditType;
    }

    public Long getSubscribers() {
        return mSubscribers;
    }

    public void setSubscribers(Long subscribers) {
        mSubscribers = subscribers;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public Boolean getUserHasFavorited() {
        return mUserHasFavorited;
    }

    public void setUserHasFavorited(Boolean userHasFavorited) {
        mUserHasFavorited = userHasFavorited;
    }

    public Boolean getUserIsBanned() {
        return mUserIsBanned;
    }

    public void setUserIsBanned(Boolean userIsBanned) {
        mUserIsBanned = userIsBanned;
    }

    public Boolean getUserIsContributor() {
        return mUserIsContributor;
    }

    public void setUserIsContributor(Boolean userIsContributor) {
        mUserIsContributor = userIsContributor;
    }

    public Boolean getUserIsModerator() {
        return mUserIsModerator;
    }

    public void setUserIsModerator(Boolean userIsModerator) {
        mUserIsModerator = userIsModerator;
    }

    public Boolean getUserIsMuted() {
        return mUserIsMuted;
    }

    public void setUserIsMuted(Boolean userIsMuted) {
        mUserIsMuted = userIsMuted;
    }

    public Boolean getUserIsSubscriber() {
        return mUserIsSubscriber;
    }

    public void setUserIsSubscriber(Boolean userIsSubscriber) {
        mUserIsSubscriber = userIsSubscriber;
    }
}
