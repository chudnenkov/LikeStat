package com.example.likestat.presenter;

import android.util.Log;

import com.example.likestat.LikeStatApplication;
import com.example.likestat.model.BookmarksCount;
import com.example.likestat.model.Likes;
import com.example.likestat.model.ViewsCount;
import com.example.likestat.view.MainView;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public class MainPresenterImpl implements MainPresenter {
    private final static String TAG = "MainPresenterImpl.class";
    private MainView mainView;
    private CompositeDisposable mCompositeDisposable = new CompositeDisposable();
    private Likes likes, commentators, mentions, reposters;
    private int bookmarksCnt, viewsCount;

    public MainPresenterImpl(MainView mainView){
        this.mainView = mainView;
    }

    @Override
    public void getLikes(int id) {
        mCompositeDisposable.add(LikeStatApplication.getApi().getLikes(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<Likes>() {
                            @Override
                            public void onNext(Likes likes) {
                                if (likes != null) {
                                    MainPresenterImpl.this.likes = likes;
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError");
                            }

                            @Override
                            public void onComplete() {
                                mainView.showLikers(likes);
                            }
                        }
                ));
    }

    @Override
    public void getCommentators(int id) {
        mCompositeDisposable.add(LikeStatApplication.getApi().getCommentators(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<Likes>() {
                            @Override
                            public void onNext(Likes commentators) {
                                if (commentators != null) {
                                    MainPresenterImpl.this.commentators = commentators;
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError");
                            }

                            @Override
                            public void onComplete() {
                                mainView.showCommentators(commentators);
                            }
                        }
                ));
    }

    @Override
    public void getMentions(int id) {
        mCompositeDisposable.add(LikeStatApplication.getApi().getMentions(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<Likes>() {
                            @Override
                            public void onNext(Likes mentions) {
                                if (mentions != null) {
                                    MainPresenterImpl.this.mentions = mentions;
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError");
                            }

                            @Override
                            public void onComplete() {
                                mainView.showMentions(mentions);
                            }
                        }
                ));
    }

    @Override
    public void getReposters(int id) {
        mCompositeDisposable.add(LikeStatApplication.getApi().getReposters(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<Likes>() {
                            @Override
                            public void onNext(Likes reposters) {
                                if (reposters != null) {
                                    MainPresenterImpl.this.reposters = reposters;
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError");
                            }

                            @Override
                            public void onComplete() {
                                mainView.showReposters(reposters);
                            }
                        }
                ));
    }

    @Override
    public void getBookmarksCount(int id) {
        mCompositeDisposable.add(LikeStatApplication.getApi().getBookmarksCount(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<BookmarksCount>() {
                            @Override
                            public void onNext(BookmarksCount bookmarks) {
                                if (bookmarks != null) {
                                    bookmarksCnt = bookmarks.getBookmarksCount();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError");
                            }

                            @Override
                            public void onComplete() {
                             mainView.showBookmarksCount(bookmarksCnt);
                            }
                        }
                ));
    }

    @Override
    public void getViewsCount(int id) {
        mCompositeDisposable.add(LikeStatApplication.getApi().getViewsCount(String.valueOf(id))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(
                        new DisposableObserver<ViewsCount>() {
                            @Override
                            public void onNext(ViewsCount viewsCount) {
                                if (viewsCount != null) {
                                    MainPresenterImpl.this.viewsCount = viewsCount.getViewsCount();
                                }
                            }

                            @Override
                            public void onError(Throwable e) {
                                Log.e(TAG, "onError");
                            }

                            @Override
                            public void onComplete() {
                                mainView.showViewsCount(viewsCount);
                            }
                        }
                ));
    }

    @Override
    public void onDestroy() {
        mCompositeDisposable.dispose();
    }
}
