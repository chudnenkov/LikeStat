package com.example.likestat.api;


import com.example.likestat.model.BookmarksCount;
import com.example.likestat.model.Likes;
import com.example.likestat.model.ViewsCount;

import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @POST("users/posts/likers/all?")
    Observable<Likes> getLikes(@Query("id") String id);

    @POST("users/posts/commentators/all?")
    Observable<Likes> getCommentators(@Query("id") String id);

    @POST("users/posts/mentions/all?")
    Observable<Likes> getMentions(@Query("id") String id);

    @POST("users/posts/reposters/all?")
    Observable<Likes> getReposters(@Query("id") String id);

    @POST("users/posts/get?")
    Observable<BookmarksCount> getBookmarksCount(@Query("id") String id);

    @POST("users/posts/get?")
    Observable<ViewsCount> getViewsCount(@Query("id") String id);
}
