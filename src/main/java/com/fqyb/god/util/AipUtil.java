package com.fqyb.god.util;

import com.baidu.aip.bodyanalysis.AipBodyAnalysis;


/**
 * @author: zhaoxudong
 * @date: 2019-09-19 19:30
 * @description:
 */
public class AipUtil {
    private static final String APP_ID = "17273387";
    private static final String API_KEY = "2S11uyDitFmU3PM5pGgMZ9hV";
    private static final String SECRET_KEY = "Bt3mg4gttfFdCTOGMjNL40nhZoBXQy45";
    private static AipBodyAnalysis client = null;

    public static AipBodyAnalysis getClient() {
        // 初始化一个AipBodyAnalysis
        if (client == null) {
            client = new AipBodyAnalysis(APP_ID, API_KEY, SECRET_KEY);
            // 可选：设置网络连接参数
            client.setConnectionTimeoutInMillis(2000);
            client.setSocketTimeoutInMillis(60000);
        }
        return client;

//        // 可选：设置代理服务器地址, http和socket二选一，或者均不设置
//        client.setHttpProxy("proxy_host", proxy_port);  // 设置http代理
//        client.setSocketProxy("proxy_host", proxy_port);  // 设置socket代理
    }

}
