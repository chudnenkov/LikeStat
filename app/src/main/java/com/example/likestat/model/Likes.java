package com.example.likestat.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Likes {

    @SerializedName("data")
    @Expose
    private List<Like> likes;

    public List<Like> getLikes() {
        return likes;
    }

    public void setLikes(List<Like> likes) {
        this.likes = likes;
    }

    public static class Like {

        @SerializedName("nickname")
        @Expose
        private String nickname;

        @SerializedName("avatar_image")
        @Expose
        private Image avatarImage;

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Image getAvatarImage() {
            return avatarImage;
        }

        public void setAvatarImagel(Image avatarImage) {
            this.avatarImage = avatarImage;
        }
    }

    public static class Image{
        @SerializedName("url_medium_origin")
        @Expose
        private String urlSmall;

        public String getUrlSmall() {
            return urlSmall;
        }

        public void setUrlSmall(String urlSmall) {
            this.urlSmall = urlSmall;
        }
    }

}
