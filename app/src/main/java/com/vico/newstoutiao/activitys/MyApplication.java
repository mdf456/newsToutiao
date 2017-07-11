package com.vico.newstoutiao.activitys;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by ${Vico} on 2017/7/11.
 */

public class MyApplication extends Application {
    private static  RequestQueue requestQueue ;

    public static RequestQueue getRequestQueue() {
        return requestQueue;
    }

    @Override
    public void onCreate() {
        super.onCreate();
         requestQueue = Volley.newRequestQueue(getApplicationContext());
    }
}
