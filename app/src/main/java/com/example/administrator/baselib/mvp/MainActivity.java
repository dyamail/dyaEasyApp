package com.example.administrator.baselib.mvp;

import android.app.ProgressDialog;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.administrator.baselib.R;
import com.example.administrator.baselib.base.MvpActivity;
import com.example.administrator.baselib.retrofit.DiscountBean;
import com.gyf.barlibrary.ImmersionBar;
import com.vlonjatg.progressactivity.ProgressLinearLayout;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends MvpActivity<MainPresenterImpl> implements MainView {

    @Bind(R.id.et_login_account)
    EditText etLoginAccount;
    @Bind(R.id.et_login_pwd)
    EditText etLoginPwd;
    @Bind(R.id.btn_login_login)
    Button btnLoginLogin;
    @Bind(R.id.progress_bar_loading)
    ProgressLinearLayout progressBarLoading;
    @Bind(R.id.toolbar_me)
    Toolbar toolbar;

    private ProgressDialog pd;


    @Override
    protected void beforeInit() {
        ImmersionBar.with(this).titleBar(toolbar).init();
    }


    @Override
    protected MainPresenterImpl createPresenter() {
        return new MainPresenterImpl();
    }

    @Override
    protected int getLayoutRes() {
        return R.layout.activity_main;
    }


    @Override
    public void showLoading() {

        progressBarLoading.showLoading();
    }

    @Override
    public void hideLoading() {
        progressBarLoading.showEmpty(R.mipmap.ic_launcher, "暂时没有数据", "去死吧");
    }

    @Override
    public void loadAdData(DiscountBean newsBean) {

    }


    @Override
    public void finishRefresh() {


    }

    @OnClick(R.id.btn_login_login)
    public void onViewClicked() {
        mPresenter.userLogin(this, "", "");
    }


}
