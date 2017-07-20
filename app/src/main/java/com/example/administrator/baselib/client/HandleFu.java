package com.example.administrator.baselib.client;

import io.reactivex.functions.Function;

public class HandleFu<T> implements Function<ResultInfo<T>, T> {

    @Override
    public T apply(ResultInfo<T> resultInfo) throws Exception {
        if (!resultInfo.isOk())
            throw new ServerError(resultInfo.getCode(), "" + resultInfo.getMsg() != null ? resultInfo.getMsg() : "");
        return resultInfo.getData();
    }
}