package com.example.likestat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BookmarksCount {

    @SerializedName("bookmarks_count")
    @Expose
    private int bookmarksCount;

    public int getBookmarksCount() {
        return bookmarksCount;
    }

    public void setBookmarksCount(int bookmarksCount) {
        this.bookmarksCount = bookmarksCount;
    }

}
