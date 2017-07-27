package com.example.administrator.baselib.ui.retrofitUpload;

import com.example.administrator.baselib.base.MvpPresenter;
import com.example.administrator.baselib.base.MvpView;

import okhttp3.MultipartBody;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/26  14:20
 */
public interface retroUploadPresenter extends MvpPresenter<retroUploadView> {
    void retroUploadImage(String filepath, MultipartBody.Part body);
}
