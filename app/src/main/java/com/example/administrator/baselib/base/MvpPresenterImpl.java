package com.example.administrator.baselib.base;

import java.lang.ref.SoftReference;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public class MvpPresenterImpl<V extends MvpView> implements MvpPresenter<V> {

    protected V mView;

    protected CompositeDisposable mCompositeSubscription = new CompositeDisposable();

    @Override
    public void attachView(V view) {
        this.mView = view;
    }

    public void addComposite(Disposable disposable) {
        if (mCompositeSubscription == null) {
            mCompositeSubscription = new CompositeDisposable();
        }
        mCompositeSubscription.add(disposable);
    }

    @Override
    public void detachView() {
        if (mCompositeSubscription != null) {
            mCompositeSubscription.clear();
        }
        mView = null;
    }

}
