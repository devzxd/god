package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author：zhaoyi
 * @createTime: 2019/9/20,4:08 下午
 */
@Slf4j
@Component
public class PPTHandler implements DreamHandler {
    public void dealHandSign(String handSign) throws Exception {
        final Robot rb = new Robot();
        if ("Thumb_up".equalsIgnoreCase(handSign) || "One".equalsIgnoreCase(handSign)) {
            System.out.println("up");
            rb.keyPress(KeyEvent.VK_UP);
            rb.keyRelease(KeyEvent.VK_UP);
        } else if ("five".equalsIgnoreCase(handSign)) {
            System.out.println("down");
            rb.keyPress(KeyEvent.VK_DOWN);
            rb.keyRelease(KeyEvent.VK_DOWN);
        }
//        else if ("Fist".equalsIgnoreCase(handSign)) {
//            rb.keyPress(KeyEvent.VK_WINDOWS);
//            rb.keyPress(KeyEvent.VK_D);
//            rb.waitForIdle();
//            rb.keyRelease(KeyEvent.VK_D);
//            rb.keyRelease(KeyEvent.VK_WINDOWS);
//
//        }

    }

    @Override
    public TypeEnum getHandlerType() {
        return TypeEnum.PPT;
    }

    @Override
    public void handler(String classname) {
        try {
            dealHandSign(classname);
        } catch (Exception e) {
            log.error("操作ppt异常{}", e);
        }
    }
}
