package com.example.likestat.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.likestat.R;
import com.example.likestat.adapter.LikeAdapter;
import com.example.likestat.model.Likes;
import com.example.likestat.presenter.MainPresenter;
import com.example.likestat.presenter.MainPresenterImpl;

public class MainActivity extends AppCompatActivity implements MainView {

    private MainPresenter mainPresenter;
    private RecyclerView LikesRecyclerView, commentatorsRecyclerView, mentionsRecyclerView, repostersRecyclerView;
    private TextView viewsTextView, likesTextView, commentatorsTextView, mentionsTextView, repostersTextView, bookmarksTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        viewsTextView = findViewById(R.id.views);

        LikesRecyclerView = findViewById(R.id.likesRecyclerView);
        likesTextView = findViewById(R.id.likes);

        commentatorsRecyclerView = findViewById(R.id.commentatorsRecyclerView);
        commentatorsTextView = findViewById(R.id.commentators);

        mentionsRecyclerView  = findViewById(R.id.mentionsRecyclerView);
        mentionsTextView = findViewById(R.id.mentions);

        repostersRecyclerView  = findViewById(R.id.repostersRecyclerView);
        repostersTextView = findViewById(R.id.reposters);

        bookmarksTextView = findViewById(R.id.bookmarks);

        mainPresenter = new MainPresenterImpl(this);
        mainPresenter.getViewsCount(2720);
        mainPresenter.getLikes(2720);
        mainPresenter.getCommentators(2720);
        mainPresenter.getMentions(2720);
        mainPresenter.getReposters(2720);
        mainPresenter.getBookmarksCount(2720);
    }

    @Override
    public void showViewsCount(int cnt) {
        viewsTextView.setText(String.valueOf(cnt));
    }

    @Override
    public void showLikers(Likes likes) {
        LikeAdapter likeAdapter = new LikeAdapter(likes);
        LikesRecyclerView.setAdapter(likeAdapter);
        likesTextView.setText(String.valueOf(likes.getLikes().size()));
    }

    @Override
    public void showCommentators(Likes likes) {
        LikeAdapter commentatorsAdapter = new LikeAdapter(likes);
        commentatorsRecyclerView.setAdapter(commentatorsAdapter);
        commentatorsTextView.setText(String.valueOf(likes.getLikes().size()));
    }

    @Override
    public void showMentions(Likes likes) {
        LikeAdapter mentionsAdapter =   new LikeAdapter(likes);
        mentionsRecyclerView.setAdapter(mentionsAdapter);
        mentionsTextView.setText(String.valueOf(likes.getLikes().size()));
    }

    @Override
    public void showReposters(Likes likes) {
        LikeAdapter repostersAdapter =   new LikeAdapter(likes);
        repostersRecyclerView.setAdapter(repostersAdapter);
        repostersTextView.setText(String.valueOf(likes.getLikes().size()));
    }

    @Override
    public void showBookmarksCount(int cnt) {
        bookmarksTextView.setText(String.valueOf(cnt));
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        mainPresenter.onDestroy();
    }
}
