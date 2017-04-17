package com.example.asus.jsoupdemo;

import android.util.Log;

/**
 * @ClassName: LogUtils.
 * @Desription: 日志打印输出工具类
 * @author: Dreamcoding
 * @date: 2017/3/12 0012 21:01.
 */

public class LogUtils {
    public static final String LOG_TAG = "-----";
    public static boolean DEBUG = true;

    public static final void d(String log) {
        if (DEBUG)
            Log.d(LOG_TAG, log);
    }

    public static final void d(String tag,String log) {
        if (DEBUG)
            Log.d(tag, log);
    }

    public static final void e(String log) {
        if (DEBUG)
            Log.e(LOG_TAG, log);
    }

    public static final void e(String tag,String log) {
        if (DEBUG)
            Log.e(tag,  log);
    }

    public static final void i(String log) {
        if (DEBUG)
            Log.i(LOG_TAG, log);
    }

    public static final void i(String tag, String log) {
        if (DEBUG)
            Log.i(tag, log);
    }

    public static final void v(String log) {
        if (DEBUG)
            Log.v(LOG_TAG, log);
    }

    public static final void v(String tag,String log) {
        if (DEBUG)
            Log.v(tag, log);
    }

    public static final void w(String log) {
        if (DEBUG)
            Log.w(LOG_TAG, log);
    }

    public static final void w(String tag,String log) {
        if (DEBUG)
            Log.w(tag, log);
    }
}
