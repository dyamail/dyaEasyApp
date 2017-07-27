package com.example.administrator.baselib;

import android.app.Application;
import android.content.Context;

import com.example.administrator.baselib.util.Utils;

/**
 * Description:
 * Company    :
 * Author     : dyamail
 * Date       : 2017/7/20  15:10
 */
public class App extends Application {
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext=getApplicationContext();
        Utils.init(this);
    }
    public static Context getAppContext(){
        return sContext;
    }
}
