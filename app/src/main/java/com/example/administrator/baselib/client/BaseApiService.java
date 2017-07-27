package com.example.administrator.baselib.client;

import com.example.administrator.baselib.retrofit.DisAll;
import com.example.administrator.baselib.retrofit.DiscountBean;
import com.example.administrator.baselib.retrofit.Response;


import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.Query;
import retrofit2.http.Url;


public interface BaseApiService<T> {

    public static final String Base_URL = "http://192.168.0.242:8080/jjs-mobile/";

    public static final String CONNECTION_URI = " http://192.168.0.242:8080/jjs-mobile/";

    @POST("login.do")
    Observable<ResultInfo<String>> userLogin(@Query("phone") String phone, @Query("password") String password);

    @POST("showHotProducts.do")
    Observable<ResultInfo<DiscountBean>> userLogins(@Query("pageRow") int pageRow, @Query("nowPage") int nowPage);

    @Multipart
    @POST()
    Observable<ResponseBody> uploads(
            @Url String url,
            @Part() MultipartBody.Part file);
}
