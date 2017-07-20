package com.example.administrator.baselib.base;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.v4.widget.SwipeRefreshLayout;

import com.example.administrator.baselib.R;
import com.gyf.barlibrary.ImmersionBar;

import butterknife.Bind;
import butterknife.ButterKnife;

public abstract class MvpActivity<P extends MvpPresenter> extends SuperActivity implements MvpView {

    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutRes());
        ButterKnife.bind(this);
        beforeInit();
        mPresenter = createPresenter();
        mPresenter.attachView(this);
        ImmersionBar.with(this).init();
    }

    protected abstract void beforeInit();


    @Override
    protected void onDestroy() {
        mPresenter.detachView();
        super.onDestroy();
        ImmersionBar.with(this).destroy();
    }

    protected abstract P createPresenter();

    @LayoutRes
    protected abstract int getLayoutRes();
}
