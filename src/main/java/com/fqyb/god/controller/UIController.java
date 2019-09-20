package com.fqyb.god.controller;

import com.fasterxml.jackson.databind.*;
import com.fqyb.god.pojo.ApiCallback;
import com.fqyb.god.util.AipUtil;
import com.fqyb.god.util.ImgUtil;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;


import java.io.IOException;
import java.util.HashMap;
import java.util.List;

/**
 * @author: zhaoxudong
 * @date: 2019-09-19 19:28
 * @description:
 */
@Controller
@RequestMapping
public class UIController {

    @GetMapping("/takePhoto")
    private String takePhoto(){
        return "takePhoto";
    }
    @ResponseBody
    @PostMapping("/getPhoto")
    private String getPhoto(@RequestBody HashMap<String,Object> map) throws IOException{
        HashMap<String, String> options = new HashMap<>();
        //解析base64
        byte[] bytes = new BASE64Decoder().decodeBuffer(ImgUtil.replacePre(map.get("base64").toString()));
        //通过API获取图片解析结果
        JSONObject rst = AipUtil.getClient().gesture(bytes, options);

        int result_num = rst.getInt("result_num");

        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

        if (result_num >0) {
            JSONArray result = rst.getJSONArray("result");
            for (int i= 0;i<result.length();i++){
                JSONObject jsonRst = result.getJSONObject(i);
                System.out.println(jsonRst);
                if (!jsonRst.get("classname").equals("Face")){
                    return jsonRst.toString();
                }

            }

        }

        return null;
    }
}
