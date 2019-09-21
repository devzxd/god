package com.fqyb.god.util;

import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

@Slf4j
public class AipResponeseUtil {

    public static void check(JSONObject rstAip){
        try{
            int code = rstAip.getInt("error_code");

            switch (code){
                case 1: log.error("服务器内部错误"); break;
                case 2: log.error("服务暂不可用"); break;
                case 3: log.error("调用的API不存在，请检查请求URL后重新尝试"); break;
                case 4: log.error("集群超限额，请再次请求， 如果持续出现此类错误 "); break;
                case 6: log.error("无权限访问该用户数据，创建应用时未勾选相关接口"); break;
                case 13: log.error("获取token失败"); break;
                case 14: log.error("IAM 鉴权失败"); break;
                case 15: log.error("应用不存在或者创建失败");break;
                case 17: log.error("每天请求量超限额");break;
                case 18: log.error("QPS超限额");break;
                case 19: log.error("请求总量超限额");break;
                case 100: log.error("无效的access_token参数，请检查后重新尝试");
                case 110: log.error("access_token无效");
                case 111: log.error("access token过期");
                case 282000:log.error("服务器内部错误");
            }
        }catch (Exception e){
        }


    }
}
