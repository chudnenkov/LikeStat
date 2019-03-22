package com.example.likestat.presenter;

public interface MainPresenter {
    void onDestroy();
    void getLikes(int id);
    void getCommentators(int id);
    void getMentions(int id);
    void getReposters(int id);
    void getBookmarksCount(int id);
    void getViewsCount(int id);
}
