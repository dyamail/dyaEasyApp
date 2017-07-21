package com.example.administrator.baselib.retrofit;

import android.util.Log;

import com.example.administrator.baselib.client.BaseApiService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;


/**
 * Created by Administrator on 2016/11/18.
 */

public class ServieceFactory {

    private final Gson mGsonDateFormat;


    public ServieceFactory(){
        mGsonDateFormat = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
    }


    private static class SingletonHolder{
        private static final ServieceFactory INSTANCE = new ServieceFactory();
    }


    public static ServieceFactory getInstance(){
        return SingletonHolder.INSTANCE;
    }


    public <S> S createService(Class<S> serviceClass){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseApiService.Base_URL)
                .client(getOkHttpClient())
                .addConverterFactory(ResponseConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        return retrofit.create(serviceClass);

    }

    HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
        @Override
        public void log(String message) {
            //打印retrofit日志
            Log.i("RetrofitLog","retrofitBack ======================= "+message);
        }
    });


    private static final long DEFAULT_TIMEOUT = 10;
    private OkHttpClient getOkHttpClient(){
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        //定制OkHttp
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        builder.writeTimeout(DEFAULT_TIMEOUT,TimeUnit.SECONDS);
        builder.addInterceptor(loggingInterceptor);
        //设置缓存
//        File httpCacheDirectory = new File(SDCardUtils.getRootDirectoryPath(),"HuaMy/NetCache");
//        builder.cache(new Cache(httpCacheDirectory,10*1024*1024));
        return builder.build();
    }

}
