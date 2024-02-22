package com.epitech.redditech.Controllers;

public interface IArticleViewerController {
    void upVote(String id);
    void downVote(String id);
    void unVote(String id);
}
