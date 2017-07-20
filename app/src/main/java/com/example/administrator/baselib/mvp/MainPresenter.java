package com.example.administrator.baselib.mvp;

import android.content.Context;
import android.graphics.Bitmap;

import com.example.administrator.baselib.base.MvpPresenter;


public interface MainPresenter extends MvpPresenter<MainView> {
    void userLogin(Context context, String phone, String pass);
}
