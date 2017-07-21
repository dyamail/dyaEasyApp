package com.example.administrator.baselib.retrofit;

import com.google.gson.JsonParseException;
import com.jakewharton.retrofit2.adapter.rxjava2.HttpException;

import org.json.JSONException;
import org.reactivestreams.Subscriber;

import java.text.ParseException;

import io.reactivex.Observer;

public abstract class AbsAPICallback<T> implements Observer<T> {

    //对应HTTP的状态码
    private static final int UNAUTHORIZED = 401;
    private static final int FORBIDDEN = 403;
    private static final int NOT_FOUND = 404;
    private static final int REQUEST_TIMEOUT = 408;
    private static final int INTERNAL_SERVER_ERROR = 500;
    private static final int BAD_GATEWAY = 502;
    private static final int SERVICE_UNAVAILABLE = 503;
    private static final int GATEWAY_TIMEOUT = 504;
    //出错提示
    private final String networkMsg="网络错误";
    private final String parseMsg="解析错误";
    private final String unknownMsg="不知道错误";




    @Override
    public void onError(Throwable e) {
        Throwable throwable = e;
        //获取最根源的异常
        while(throwable.getCause() != null){
            e = throwable;
            throwable = throwable.getCause();
        }

        ApiException ex;
        if (e instanceof HttpException){             //HTTP错误
            HttpException httpException = (HttpException) e;
            ex = new ApiException(e, httpException.code());
            switch(httpException.code()){
                case UNAUTHORIZED:
//                case FORBIDDEN:
//                    onPermissionError(ex);          //权限错误，需要实现
//                    break;
                case NOT_FOUND:
                case REQUEST_TIMEOUT:
                case GATEWAY_TIMEOUT:
                case INTERNAL_SERVER_ERROR:
                case BAD_GATEWAY:
                case SERVICE_UNAVAILABLE:
                default:
                    ex.setDisplayMessage(networkMsg);  //均视为网络错误
                    onError(ex);
                    break;
            }
        } else if (e instanceof ResultException){    //服务器返回的错误
            ResultException resultException = (ResultException) e;
           if (resultException.getErrCode()==300){
               ex = new ApiException(resultException, resultException.getErrCode());
               ex.setDisplayMessage("服务器错误了");
               onError(ex);
           }


//            onResultError(ex);
        } else if (e instanceof JsonParseException
                || e instanceof JSONException
                || e instanceof ParseException){
            ex = new ApiException(e, ApiException.PARSE_ERROR);
            ex.setDisplayMessage(parseMsg);            //均视为解析错误
            onError(ex);
        } else {
            ex = new ApiException(e, ApiException.UNKNOWN);
            ex.setDisplayMessage(unknownMsg);          //未知错误
            onError(ex);
        }
    }


    /**
     * 错误回调
     */
    protected abstract void onError(ApiException ex);

    /**
     * 权限错误，需要实现重新登录操作
     */
//    protected abstract void onPermissionError(ApiException ex);

    /**
     * 服务器返回的错误
     */
//    protected abstract void onResultError(ApiException ex);



}