package com.example.looperdemo;

import android.app.Application;
import android.content.Context;

/**
 * 通过appliction得到全局context,需要manifest中注册
 */
public class MyApplication extends Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }
}
