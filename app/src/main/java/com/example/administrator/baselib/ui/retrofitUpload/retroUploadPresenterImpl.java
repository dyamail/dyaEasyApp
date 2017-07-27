package com.example.administrator.baselib.ui.retrofitUpload;

import com.example.administrator.baselib.App;
import com.example.administrator.baselib.base.MvpPresenterImpl;
import com.example.administrator.baselib.client.ApiException;
import com.example.administrator.baselib.client.BaseApiService;
import com.example.administrator.baselib.client.BaseObserver;
import com.example.administrator.baselib.client.ErrorTransformer;
import com.example.administrator.baselib.retrofit.ServieceFactory;
import com.example.administrator.baselib.util.ToastUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/26  14:24
 */
public class retroUploadPresenterImpl extends MvpPresenterImpl<retroUploadView> implements retroUploadPresenter {
    @Override
    public void retroUploadImage(String filepath, MultipartBody.Part body) {
        BaseApiService apiService = ServieceFactory.getInstance().createService(BaseApiService.class);
        apiService.uploads(filepath, body)
                .subscribeOn(Schedulers.io())
                .compose(new ErrorTransformer())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new BaseObserver(App.getAppContext()) {
                    @Override
                    public void onError(ApiException.ResultCode e) {
                        ToastUtils.showShort(e.getMessage());
                    }

                    @Override
                    public void onSubscribe(Disposable d) {
                        addComposite(d);
                    }

                    @Override
                    public void onNext(Object o) {
                        ToastUtils.showShort(o.toString());
                    }

                    @Override
                    public void onComplete() {

                    }
                });

    }
}
