package com.kevin.able.coolweather.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Kevin on 2015/9/6.
 */
public class HttpUtil {
    public static void sendHttpRequest(final String address,final HttpCallbackListener listener){
        //开启网络线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                HttpURLConnection connection = null;
                try {
                    URL url = new URL(address);
                    connection = (HttpURLConnection)url.openConnection();
                    connection.setRequestMethod("GET");
                    connection.setConnectTimeout(8000);
                    connection.setReadTimeout(8000);
                    InputStream in = connection.getInputStream();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(in));
                    StringBuilder response = new StringBuilder();
                    String line;
                    while ((line=bufferedReader.readLine())!=null){
                        response.append(line);
                    }
                    if (listener!=null){
                        //回调onFinish方法
                        listener.onFinish(response.toString());
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                    if (listener!=null){
                        //回调onError方法
                        listener.onError(e);
                    }
                }finally {
                    if (connection!=null){
                        connection.disconnect();
                    }
                }
            }
        }).start();

    }
}
