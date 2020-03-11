package com.orange.mvp_demo.app;

import android.app.Application;

import com.yechaoa.yutils.ActivityUtil;
import com.yechaoa.yutils.LogUtil;
import com.yechaoa.yutils.YUtils;

/**
 * Time: 2020/3/11 9:05
 * <p>
 * Author: 橘子丶
 */
public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
//初始化
        YUtils.initialize(this);
        //设置打印开关
        LogUtil.setIsLog(true);
        //注册Activity生命周期
        registerActivityLifecycleCallbacks(ActivityUtil.getActivityLifecycleCallbacks());
    }
}
