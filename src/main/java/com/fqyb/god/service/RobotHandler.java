package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;

@Component
@Slf4j
public class RobotHandler implements DreamHandler {

    @Autowired
    SimpMessagingTemplate template;


    @Override
    public TypeEnum getHandlerType() {
        return TypeEnum.ROBOT;
    }

    @Override
    public void handler(String classname) {
        if ("Prayer".equalsIgnoreCase(classname)) {
            final Robot rb;
            try {
                rb = new Robot();
                rb.keyPress(KeyEvent.VK_WINDOWS);
                rb.keyPress(KeyEvent.VK_D);
                rb.waitForIdle();
                rb.keyRelease(KeyEvent.VK_D);
                rb.keyRelease(KeyEvent.VK_WINDOWS);
            } catch (AWTException e) {
                e.printStackTrace();
            }
            return;
        }

        template.convertAndSend("/topic/god/robot", classname);

    }
}
