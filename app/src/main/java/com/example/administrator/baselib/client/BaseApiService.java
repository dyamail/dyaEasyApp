package com.example.administrator.baselib.client;

import com.example.administrator.baselib.retrofit.DiscountBean;


import io.reactivex.Observable;
import retrofit2.http.POST;
import retrofit2.http.Query;


public interface BaseApiService<T> {

    public static final String Base_URL = "http://192.168.0.242:8080/jjs-mobile/";

    public static final String CONNECTION_URI = " http://192.168.0.242:8080/jjs-mobile/";

    @POST("login.do")
    Observable<DiscountBean> userLogin(@Query("phone") String phone, @Query("password") String password);

    @POST("showHotProducts.do")
    Observable<ResultInfo> userLogins();


}
