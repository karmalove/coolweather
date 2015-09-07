package com.kevin.able.coolweather.util;

/**
 * Created by Kevin on 2015/9/6.
 */
public interface HttpCallbackListener {
    void onFinish(String response);
    void onError(Exception e);
}
