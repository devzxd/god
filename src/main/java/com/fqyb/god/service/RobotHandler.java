package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class RobotHandler implements DreamHandler{

    @Autowired
    SimpMessagingTemplate template;


    @Override
    public TypeEnum getHandlerType() {
        return TypeEnum.ROBOT;
    }

    @Override
    public void handler(String classname) {
        template.convertAndSend("/topic/god/robot", classname);
    }
}
