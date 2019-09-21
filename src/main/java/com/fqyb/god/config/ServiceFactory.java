package com.fqyb.god.config;

import com.fqyb.god.common.TypeEnum;
import com.fqyb.god.service.DreamHandler;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;


@Component
public class ServiceFactory implements ApplicationContextAware {


    private static Map<TypeEnum, DreamHandler> factory;


    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        factory = new HashMap<>(16);
        Map<String, DreamHandler> beanNamesForType = applicationContext.getBeansOfType(DreamHandler.class);

        beanNamesForType.forEach((k,v)->{
            factory.put(v.getHandlerType(),v);
        });


    }

    public static DreamHandler getDreamHandler(TypeEnum typeEnum){
        DreamHandler dreamHandler = factory.get(typeEnum);
        if (dreamHandler == null){
            return null;
        }
        return dreamHandler;
    }
}