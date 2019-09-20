package com.fqyb.god.controller;


import com.fqyb.god.service.PPTService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author：zhaoyi
 * @createTime: 2019/9/20,4:04 下午
 */
@RestController
public class PPTController {
    @Autowired
    PPTService pptService = new PPTService();

    @RequestMapping(value = "/dealHandSign", method = RequestMethod.GET)
    public String dealHandNum(String handSign) throws Exception {

        pptService.dealHandSign(handSign);


        return "123";

    }

}
