package com.example.administrator.baselib.mvp;

import android.content.Context;

import com.example.administrator.baselib.base.MvpPresenterImpl;
import com.example.administrator.baselib.client.ApiException;
import com.example.administrator.baselib.client.BaseApiService;
import com.example.administrator.baselib.client.BaseObserver;
import com.example.administrator.baselib.client.ErrorTransformer;
import com.example.administrator.baselib.client.ResultInfo;
import com.example.administrator.baselib.client.RetrofitClient;
import com.example.administrator.baselib.retrofit.DiscountBean;
import com.example.administrator.baselib.util.LogUtils;
import com.example.administrator.baselib.util.ToastUtils;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
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
        final BaseApiService apiService = RetrofitClient.getInstance(context).create(BaseApiService.class);
        apiService.userLogin("150940409", "123456")
                .subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .doOnNext(new Consumer<ResultInfo<String>>() {
//
//                    @Override
//                    public void accept(ResultInfo<String> s) throws Exception {
//                        LogUtils.e("登录结果：" + s);
//                        if (s.getCode() == 200) {
//                            ToastUtils.showShort("登录成功");
//                        } else {
//                            LogUtils.d("请求失败，退出下面操作");
//                            return;
//                        }
//                    }
//                })
                .observeOn(Schedulers.io())
                .flatMap(new Function<ResultInfo<String>, Observable<ResultInfo<DiscountBean>>>() {

                    @Override
                    public Observable<ResultInfo<DiscountBean>> apply(ResultInfo<String> stringResultInfo) throws Exception {
                        if (stringResultInfo.getCode()==200){
                            LogUtils.d("可以发送请求");
                            return apiService.userLogins(10, 1);

                        }else {
                            LogUtils.d("请求失败");
                            return null;
                        }
                    }

                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<ResultInfo<DiscountBean>>() {
                    @Override
                    public void accept(ResultInfo<DiscountBean> discountBean) throws Exception {
                        LogUtils.d(discountBean.toString());
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        ToastUtils.showShort(throwable.getMessage());
                    }
                });

//        apiService.userLogins(10, 1)
//                .compose(new ErrorTransformer())
//                .subscribeOn(Schedulers.io())
//                .flatMap(new Function<DiscountBean, Observable<String>>() {
//
//                    @Override
//                    public Observable apply(DiscountBean discountBean) throws Exception {
//                        return apiService.userLogin("15094040903", "123456");
//                    }
//                }).subscribeOn(Schedulers.io())
//                .compose(new ErrorTransformer())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(new BaseObserver<String>(context) {
//                    @Override
//                    public void onError(ApiException.ResultCode e) {
//                        ToastUtils.showShort(e.getMessage());
//                    }
//
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(String s) {
//                        ToastUtils.showShort(s);
//                        ToastUtils.showShort("获取登录信息成功");
//
//                    }
//
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });
//                .map(new Function<DiscountBean, DiscountBean.TreasuresBean>() {
//
//                    @Override
//                    public DiscountBean.TreasuresBean apply(DiscountBean discountBean) throws Exception {
//                        return discountBean.getTreasures().get(0);
//                    }
//                })
//                .subscribe(new Consumer<DiscountBean.TreasuresBean>() {
//
//                    @Override
//                    public void accept(DiscountBean.TreasuresBean treasuresBean) throws Exception {
//                        ToastUtils.showShort(treasuresBean.getPName());
//                    }
//                }, new Consumer<Throwable>() {
//                    @Override
//                    public void accept(Throwable throwable) throws Exception {
//
//                    }
//                });
//                .subscribe(new BaseObserver<DiscountBean>(context) {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//                        addComposite(d);
//                    }
//
//                    @Override
//                    public void onNext(DiscountBean discountBean) {
//                        Toast.makeText(context, discountBean.toString(), Toast.LENGTH_SHORT).show();
//                    }
//
//
//                    @Override
//                    public void onComplete() {
//                        mView.hideLoading();
//                    }
//
//
//                    @Override
//                    public void onError(ApiException.ResultCode e) {
//                        Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT).show();
//                    }
//
//
//                });
    }
}
