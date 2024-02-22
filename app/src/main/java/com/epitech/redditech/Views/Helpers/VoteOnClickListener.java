package com.epitech.redditech.Views.Helpers;

import android.annotation.SuppressLint;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.epitech.redditech.Controllers.IArticleViewerController;
import com.epitech.redditech.R;

public class VoteOnClickListener implements View.OnClickListener {
    String articleId;
    IArticleViewerController controller;
    Long voteNums;
    TextView votes;
    boolean voted;

    public VoteOnClickListener(String id, IArticleViewerController controller, Long voteNums, TextView votes) {
        this.votes = votes;
        this.voteNums = voteNums;
        this.articleId = id;
        this.controller = controller;
    }

    @SuppressLint({"SetTextI18n", "NonConstantResourceId"})
    @Override
    public void onClick(View view) {
        Long finalVote = voteNums;
        view.setBackgroundColor(0xFFFF4500);

        if (view.getId() == R.id.upVote) {
            if (!voted) {
                voted = true;
                finalVote++;
                votes.setText(finalVote.toString());
                controller.upVote(articleId);
            } else {
                voted = false;
                view.setBackgroundColor(0xFF000000);
                votes.setText(finalVote.toString());
                controller.unVote(articleId);
            }
        } else if (view.getId() == R.id.downVote) {
            if (!voted) {
                voted = true;
                finalVote--;
                votes.setText(finalVote.toString());
                controller.downVote(articleId);
            } else {
                voted = false;
                votes.setText(finalVote.toString());
                controller.unVote(articleId);
                view.setBackgroundColor(0xFF000000);
            }
        }
    }
}
