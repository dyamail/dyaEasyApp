package com.example.administrator.baselib.mvp;

import android.content.Context;
import android.widget.Toast;

import com.example.administrator.baselib.base.MvpPresenterImpl;
import com.example.administrator.baselib.client.BaseApiService;
import com.example.administrator.baselib.client.BaseObserver;
import com.example.administrator.baselib.client.ApiException;
import com.example.administrator.baselib.client.ErrorTransformer;
import com.example.administrator.baselib.client.RetrofitClient;
import com.example.administrator.baselib.retrofit.DiscountBean;

import java.util.List;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/14  15:38
 */
public class MainPresenterImpl extends MvpPresenterImpl<MainView> implements MainPresenter {


    @Override
    public void userLogin(final Context context, String phone, String pass) {
        BaseApiService apiService = RetrofitClient.getInstance(context).create(BaseApiService.class);
        apiService.userLogins()
                .compose(new ErrorTransformer())
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())

//                .map(new Function<List<DiscountBean>, DiscountBean>() {
//
//                    @Override
//                    public DiscountBean apply(List<DiscountBean> discountBeen) throws Exception {
//                        return discountBeen.get(0);
//                    }
//                }).subscribe(new Consumer<DiscountBean>() {
//
//            @Override
//            public void accept(DiscountBean discountBean) throws Exception {
//                Toast.makeText(context, discountBean.toString(), Toast.LENGTH_SHORT).show();
//            }
//        });
                .subscribe(new BaseObserver<List<DiscountBean>>(context) {
                    @Override
                    public void onSubscribe(Disposable d) {
                        addComposite(d);
                    }

                    @Override
                    public void onNext(List<DiscountBean> discountBean) {
                        Toast.makeText(context, discountBean.toString(), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onComplete() {
                        mView.hideLoading();
                    }


                    @Override
                    public void onError(ApiException.ResultCode e) {
                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                });
    }
}
