package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;

public interface DreamHandler{
    TypeEnum getHandlerType();
    void handler(String classname);
}
