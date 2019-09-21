package com.fqyb.god.controller;

import com.fqyb.god.common.TypeEnum;
import com.fqyb.god.config.ServiceFactory;
import com.fqyb.god.pojo.ApiRequest;
import com.fqyb.god.service.DreamHandler;
import com.fqyb.god.util.AipResponeseUtil;
import com.fqyb.god.util.AipUtil;
import com.fqyb.god.util.ImgUtil;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.util.HashMap;

/**
 * @author: zhaoxudong
 * @date: 2019-09-19 19:28
 * @description:
 */
@Slf4j
@Controller
@RequestMapping
public class UIController {


    @GetMapping("/takePhoto")
    private String takePhoto() {
        return "takePhoto";
    }

    @ResponseBody
    @PostMapping("/getPhoto")
    private String getPhoto(@RequestBody ApiRequest apiRequest) throws Exception {
        HashMap<String, String> options = new HashMap<>();
        //解析base64
        byte[] bytes = new BASE64Decoder().decodeBuffer(ImgUtil.replacePre(apiRequest.getBase64()));
        //通过API获取图片解析结果
        JSONObject rst;
        try {
            rst = AipUtil.getClient().gesture(bytes, options);
            AipResponeseUtil.check(rst);
            int result_num = rst.getInt("result_num");
            if (result_num > 0) {
                JSONArray result = rst.getJSONArray("result");
                System.out.println(result);
                for (int i = 0; i < result.length(); i++) {
                    JSONObject jsonRst = result.getJSONObject(i);
                    String classname = jsonRst.get("classname").toString();
                    System.out.println(classname);
                    if (!(classname.equalsIgnoreCase("Face") || classname.equalsIgnoreCase("Insult"))) {
                        DreamHandler dreamHandler = ServiceFactory.getDreamHandler(TypeEnum.getType(apiRequest.getTypeEnum()));
                        dreamHandler.handler(classname);
                        return classname;
                    }
                }
            }
        } catch (Exception e) {
            log.error("详细信息查看控制台{}", e);
        }
        return null;
    }


}
