package com.epitech.redditech.Views.Subreddit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.epitech.redditech.Controllers.IArticleViewerController;
import com.epitech.redditech.Controllers.Subreddit.ISubredditController;
import com.epitech.redditech.Models.Article.ArticleDataResponse;
import com.epitech.redditech.Models.Generic.KindResponse;
import com.epitech.redditech.R;
import com.epitech.redditech.Views.Helpers.VoteOnClickListener;
import com.squareup.picasso.Picasso;
import com.squareup.picasso.Target;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.List;

public class ArticlesAdapter extends RecyclerView.Adapter<ArticlesAdapter.ViewHolder> {

    private List<KindResponse<ArticleDataResponse>> mData;
    private LayoutInflater mInflater;
    private ItemClickListener mClickListener;
    private Context context;
    private IArticleViewerController controller;
    private final HashMap<String, String> iconMap = new HashMap<>();

    public ArticlesAdapter(Context context, List<KindResponse<ArticleDataResponse>> data, IArticleViewerController controller, HashMap<String, String> iconMap) {
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        this.controller = controller;
        this.mData = data;
    }
    
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NotNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.fragment_article, parent, false);
        return new ViewHolder(view);
    }

    // binds the data to the TextView in each row
    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NotNull ViewHolder holder, int position) {
        ArticleDataResponse article = mData.get(position).getData();
        if (iconMap.get(article.getSubreddit()) != null) {
            Picasso.with(this.context)
                    .load(Uri.parse(iconMap.get(article.getSubreddit())))
                    .into((ImageView) holder.subredditIcon);
        } else
            holder.subredditIconText.setText("r/" + article.getSubreddit());
        if (!article.getUrl().equals("https://www.reddit.com" + article.getPermalink()))
            Picasso.with(this.context)
                .load(Uri.parse(article.getUrl()))
                .error(R.drawable.error_loading)
                .placeholder(R.drawable.ic_baseline_cached_24)
                .fit()
                .centerCrop()
                .into(holder.media);
        holder.subreddit.setText("r/" + article.getSubreddit());
        if (article.getTitle() != null && !article.getTitle().equals(""))
            holder.title.setText(article.getTitle());
        holder.author.setText("u/" + article.getAuthor());
        if (article.getSelftext() != null && !article.getSelftext().equals(""))
            holder.body.setText(article.getSelftext());
        else
            holder.body.setHeight(0);
        holder.votes.setText(article.getUps().toString());
        holder.comments.setText(article.getNumComments().toString());
        holder.upVoteButton.setOnClickListener(new VoteOnClickListener(article.getId(), controller, article.getUps(), holder.votes));
        holder.downVoteButton.setOnClickListener(new VoteOnClickListener(article.getId(), controller, article.getUps(), holder.votes));
    }

    public void updateIconMap(HashMap<String, String> iconMap) {
        this.iconMap.clear();
        this.iconMap.putAll(iconMap);
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return mData != null ? mData.size() : 0;
    }


    // stores and recycles views as they are scrolled off screen
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView subreddit;
        TextView title;
        TextView body;
        TextView author;
        TextView votes;
        TextView comments;
        TextView subredditIconText;
        ImageView subredditIcon;
        ImageView media;
        ImageButton upVoteButton;
        ImageButton downVoteButton;
        ImageButton commentButton;

        ViewHolder(View itemView) {
            super(itemView);
            subreddit = itemView.findViewById(R.id.subredditHeader);
            title = itemView.findViewById(R.id.articleTitle);
            body = itemView.findViewById(R.id.bodyText);
            author = itemView.findViewById(R.id.author);
            votes = itemView.findViewById(R.id.votes);
            comments = itemView.findViewById(R.id.comments);
            subredditIconText = itemView.findViewById(R.id.iconImgText);
            subredditIcon = itemView.findViewById(R.id.iconImg);
            media = itemView.findViewById(R.id.mediaPreview);
            upVoteButton = itemView.findViewById(R.id.upVote);
            downVoteButton = itemView.findViewById(R.id.downVote);
            commentButton = itemView.findViewById(R.id.commentButton);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if (mClickListener != null) mClickListener.onItemClick(view, getAdapterPosition());
        }
    }

    public KindResponse<ArticleDataResponse> getItem(int id) {
        return mData.get(id);
    }

    public void setClickListener(ItemClickListener itemClickListener) {
        this.mClickListener = itemClickListener;
    }

    public interface ItemClickListener {
        void onItemClick(View view, int position);
    }
}
