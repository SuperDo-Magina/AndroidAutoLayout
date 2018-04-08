package com.superdo.magina.androidautolayout;

import android.app.Application;

import com.superdo.magina.autolayout.AutoLayout;

/**
 * <pre>
 *
 *      author LYB
 *      time   18/4/8 上午8:53
 *      des
 *
 * </pre>
 */

public class App extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        AutoLayout.init(this, 1080, 1920);
    }
}
