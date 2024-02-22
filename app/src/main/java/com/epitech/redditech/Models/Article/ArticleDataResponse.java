package com.epitech.redditech.Models.Article;

import java.util.List;

import com.epitech.redditech.Models.Image.ImageResponse;
import com.google.gson.annotations.SerializedName;

public class ArticleDataResponse {
    @SerializedName("allow_live_comments")
    private Boolean mAllowLiveComments;
    @SerializedName("archived")
    private Boolean mArchived;
    @SerializedName("author")
    private String mAuthor;
    @SerializedName("author_fullname")
    private String mAuthorFullname;
    @SerializedName("category")
    private String mCategory;
    @SerializedName("created")
    private Double mCreated;
    @SerializedName("created_utc")
    private Double mCreatedUtc;
    @SerializedName("discussion_type")
    private Object mDiscussionType;
    @SerializedName("distinguished")
    private Object mDistinguished;
    @SerializedName("domain")
    private String mDomain;
    @SerializedName("downs")
    private Long mDowns;
    @SerializedName("hidden")
    private Boolean mHidden;
    @SerializedName("hide_score")
    private Boolean mHideScore;
    @SerializedName("id")
    private String mId;
    @SerializedName("is_self")
    private Boolean mIsSelf;
    @SerializedName("is_video")
    private Boolean mIsVideo;
    @SerializedName("likes")
    private Long mLikes;
    @SerializedName("locked")
    private Boolean mLocked;
    @SerializedName("media")
    private ImageResponse mMedia;
    @SerializedName("media_only")
    private Boolean mMediaOnly;
    @SerializedName("name")
    private String mName;
    @SerializedName("no_follow")
    private Boolean mNoFollow;
    @SerializedName("num_comments")
    private Long mNumComments;
    @SerializedName("over_18")
    private Boolean mOver18;
    @SerializedName("permalink")
    private String mPermalink;
    @SerializedName("pinned")
    private Boolean mPinned;
    @SerializedName("post_hint")
    private String mPostHint;
    @SerializedName("preview")
    private PreviewResponse mPreviewResponse;
    @SerializedName("saved")
    private Boolean mSaved;
    @SerializedName("score")
    private Long mScore;
    @SerializedName("selftext")
    private String mSelftext;
    @SerializedName("send_replies")
    private Boolean mSendReplies;
    @SerializedName("stickied")
    private Boolean mStickied;
    @SerializedName("subreddit")
    private String mSubreddit;
    @SerializedName("subreddit_id")
    private String mSubredditId;
    @SerializedName("subreddit_type")
    private String mSubredditType;
    @SerializedName("suggested_sort")
    private String mSuggestedSort;
    @SerializedName("title")
    private String mTitle;
    @SerializedName("ups")
    private Long mUps;
    @SerializedName("upvote_ratio")
    private Double mUpvoteRatio;
    @SerializedName("url")
    private String mUrl;
    @SerializedName("user_reports")
    private List<Object> mUserReports;
    @SerializedName("view_count")
    private Object mViewCount;
    @SerializedName("visited")
    private Boolean mVisited;


    public Boolean getAllowLiveComments() {
        return mAllowLiveComments;
    }

    public void setAllowLiveComments(Boolean allowLiveComments) {
        mAllowLiveComments = allowLiveComments;
    }

    public Boolean getArchived() {
        return mArchived;
    }

    public void setArchived(Boolean archived) {
        mArchived = archived;
    }

    public String getAuthor() {
        return mAuthor;
    }

    public void setAuthor(String author) {
        mAuthor = author;
    }

    public String getAuthorFullname() {
        return mAuthorFullname;
    }

    public void setAuthorFullname(String authorFullname) {
        mAuthorFullname = authorFullname;
    }

    public Object getCategory() {
        return mCategory;
    }

    public void setCategory(String category) {
        mCategory = category;
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

    public Object getDiscussionType() {
        return mDiscussionType;
    }

    public void setDiscussionType(Object discussionType) {
        mDiscussionType = discussionType;
    }

    public Object getDistinguished() {
        return mDistinguished;
    }

    public void setDistinguished(Object distinguished) {
        mDistinguished = distinguished;
    }

    public String getDomain() {
        return mDomain;
    }

    public void setDomain(String domain) {
        mDomain = domain;
    }

    public Long getDowns() {
        return mDowns;
    }

    public void setDowns(Long downs) {
        mDowns = downs;
    }

    public Boolean getHidden() {
        return mHidden;
    }

    public void setHidden(Boolean hidden) {
        mHidden = hidden;
    }

    public Boolean getHideScore() {
        return mHideScore;
    }

    public void setHideScore(Boolean hideScore) {
        mHideScore = hideScore;
    }

    public String getId() {
        return mId;
    }

    public void setId(String id) {
        mId = id;
    }

    public Boolean getIsSelf() {
        return mIsSelf;
    }

    public void setIsSelf(Boolean isSelf) {
        mIsSelf = isSelf;
    }

    public Boolean getIsVideo() {
        return mIsVideo;
    }

    public void setIsVideo(Boolean isVideo) {
        mIsVideo = isVideo;
    }

    public Object getLikes() {
        return mLikes;
    }

    public void setLikes(Long likes) {
        mLikes = likes;
    }

    public Boolean getLocked() {
        return mLocked;
    }

    public void setLocked(Boolean locked) {
        mLocked = locked;
    }

    public ImageResponse getMedia() {
        return mMedia;
    }

    public void setMedia(ImageResponse media) {
        mMedia = media;
    }

    public Boolean getMediaOnly() {
        return mMediaOnly;
    }

    public void setMediaOnly(Boolean mediaOnly) {
        mMediaOnly = mediaOnly;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public Boolean getNoFollow() {
        return mNoFollow;
    }

    public void setNoFollow(Boolean noFollow) {
        mNoFollow = noFollow;
    }

    public Long getNumComments() {
        return mNumComments;
    }

    public void setNumComments(Long numComments) {
        mNumComments = numComments;
    }

    public Boolean getOver18() {
        return mOver18;
    }

    public void setOver18(Boolean over18) {
        mOver18 = over18;
    }

    public String getPermalink() {
        return mPermalink;
    }

    public void setPermalink(String permalink) {
        mPermalink = permalink;
    }

    public Boolean getPinned() {
        return mPinned;
    }

    public void setPinned(Boolean pinned) {
        mPinned = pinned;
    }

    public String getPostHint() {
        return mPostHint;
    }

    public void setPostHint(String postHint) {
        mPostHint = postHint;
    }

    public PreviewResponse getPreview() {
        return mPreviewResponse;
    }

    public void setPreview(PreviewResponse previewResponse) {
        mPreviewResponse = previewResponse;
    }

    public Boolean getSaved() {
        return mSaved;
    }

    public void setSaved(Boolean saved) {
        mSaved = saved;
    }

    public Long getScore() {
        return mScore;
    }

    public void setScore(Long score) {
        mScore = score;
    }

    public String getSelftext() {
        return mSelftext;
    }

    public void setSelftext(String selftext) {
        mSelftext = selftext;
    }

    public Boolean getSendReplies() {
        return mSendReplies;
    }

    public void setSendReplies(Boolean sendReplies) {
        mSendReplies = sendReplies;
    }

    public Boolean getStickied() {
        return mStickied;
    }

    public void setStickied(Boolean stickied) {
        mStickied = stickied;
    }

    public String getSubreddit() {
        return mSubreddit;
    }

    public void setSubreddit(String subreddit) {
        mSubreddit = subreddit;
    }

    public String getSubredditId() {
        return mSubredditId;
    }

    public void setSubredditId(String subredditId) {
        mSubredditId = subredditId;
    }

    public String getSubredditType() {
        return mSubredditType;
    }

    public void setSubredditType(String subredditType) {
        mSubredditType = subredditType;
    }

    public String getSuggestedSort() {
        return mSuggestedSort;
    }

    public void setSuggestedSort(String suggestedSort) {
        mSuggestedSort = suggestedSort;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Long getUps() {
        return mUps;
    }

    public void setUps(Long ups) {
        mUps = ups;
    }

    public Double getUpvoteRatio() {
        return mUpvoteRatio;
    }

    public void setUpvoteRatio(Double upvoteRatio) {
        mUpvoteRatio = upvoteRatio;
    }

    public String getUrl() {
        return mUrl;
    }

    public void setUrl(String url) {
        mUrl = url;
    }

    public List<Object> getUserReports() {
        return mUserReports;
    }

    public void setUserReports(List<Object> userReports) {
        mUserReports = userReports;
    }

    public Object getViewCount() {
        return mViewCount;
    }

    public void setViewCount(Object viewCount) {
        mViewCount = viewCount;
    }

    public Boolean getVisited() {
        return mVisited;
    }

    public void setVisited(Boolean visited) {
        mVisited = visited;
    }
}
