package com.example.administrator.baselib.client;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

//处理错误的变换
public class ErrorTransformer<T> implements ObservableTransformer {
    @Override
    public ObservableSource apply(Observable upstream) {
        //onErrorResumeNext当发生错误的时候，由另外一个Observable来代替当前的Observable并继续发射数据
        return (Observable<T>) upstream.map(new HandleFu<T>()).onErrorResumeNext(new HttpResponseFunc<T>());

    }
}