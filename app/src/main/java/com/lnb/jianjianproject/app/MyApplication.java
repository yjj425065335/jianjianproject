package com.lnb.jianjianproject.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by Administrator on 17/6/19.
 */

public class MyApplication extends Application {
    private static MyApplication app;
    private static Context context;

    public static MyApplication getInstance() {
        return app;
    }
    public static Context getContext() {
        return context;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        context = getApplicationContext();
    }
}
