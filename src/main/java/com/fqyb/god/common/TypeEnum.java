package com.fqyb.god.common;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public enum TypeEnum {
    PPT,
    MAP,
    ROBOT;



    public static TypeEnum getType(String type){

        if(type.equalsIgnoreCase(PPT.name())){
          return PPT;
        }
        if(type.equalsIgnoreCase(MAP.name())){
            return MAP;
        }
        if(type.equalsIgnoreCase(ROBOT.name())){
            return ROBOT;
        }
        log.error("没有匹配到类型");
        return null;

    }
}
