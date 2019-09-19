package com.fqyb.god.controller;

import com.fqyb.god.util.AipUtil;
import com.fqyb.god.util.ImgUtil;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;
import sun.misc.BASE64Decoder;

import java.io.IOException;
import java.util.HashMap;

/**
 * @author: zhaoxudong
 * @date: 2019-09-19 19:28
 * @description:
 */
@RestController
@RequestMapping
public class Test {
    @PostMapping("/")
    private String test(@RequestBody HashMap<String,Object> map) throws IOException {
        HashMap<String, String> options = new HashMap<String, String>();
        byte[] bytes = new BASE64Decoder().decodeBuffer(ImgUtil.replacePre(map.get("base64").toString()));
        return AipUtil.getClient().gesture(bytes,options).toString();
    }
}
