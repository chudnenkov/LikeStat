package com.example.likestat.view;

import com.example.likestat.model.Likes;

public interface MainView {

    void showViewsCount(int cnt);
    void showLikers(Likes likes);
    void showCommentators(Likes likes);
    void showMentions(Likes likes);
    void showReposters(Likes likes);
    void showBookmarksCount(int cnt);
}
