package com.example.administrator.baselib.base;

public interface MvpPresenter<V extends MvpView> {
    void attachView(V view);
    void detachView();
}
