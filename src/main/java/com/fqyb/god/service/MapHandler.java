package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class MapHandler implements DreamHandler {
    @Override
    public TypeEnum getHandlerType() {
        return TypeEnum.MAP;
    }

    @Override
    public void handler(String classname) {

    }
}
