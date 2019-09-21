package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

@Component
@Slf4j
public class MapHandler implements DreamHandler {
    @Override
    public TypeEnum getHandlerType() {
        return TypeEnum.MAP;
    }



    public void dealHandSign(String handSign) throws Exception {
        final Robot rb = new Robot();
        int num = 1;

        rb.mousePress(InputEvent.BUTTON2_DOWN_MASK);
        rb.mouseRelease(InputEvent.BUTTON2_DOWN_MASK);

        if ("Thumb_up".equalsIgnoreCase(handSign) || "One".equalsIgnoreCase(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("up");
                rb.keyPress(KeyEvent.VK_UP);
                rb.keyRelease(KeyEvent.VK_UP);
            }

        } else if ("Thumb_down".equalsIgnoreCase(handSign) || "w".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("down");
                rb.keyPress(KeyEvent.VK_DOWN);
                rb.keyRelease(KeyEvent.VK_DOWN);
            }


        } else if ("Prayer".equalsIgnoreCase(handSign)) {
            rb.keyPress(KeyEvent.VK_WINDOWS);
            rb.keyPress(KeyEvent.VK_D);
            rb.waitForIdle();
            rb.keyRelease(KeyEvent.VK_D);
            rb.keyRelease(KeyEvent.VK_WINDOWS);

        } else if ("Two".equals(handSign) ) {
            for (int i = 0; i < num; i++) {
//                Thread.sleep(20);
                System.out.println("turnleft");
                rb.keyPress(KeyEvent.VK_LEFT);
                rb.delay(100);//停顿100ms
                rb.keyRelease(KeyEvent.VK_LEFT);
            }

            //往右
        } else if ("Three".equals(handSign) || "Ok".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("turnright");
                rb.keyPress(KeyEvent.VK_RIGHT);
                rb.delay(100);//停顿100ms
                rb.keyRelease(KeyEvent.VK_RIGHT);
            }

            //放大/缩小
        } else if ("Eight".equals(handSign) ) {
            for (int i = 0; i < num; i++) {
                rb.mouseWheel(-20);
            }
        } else if ("Seven".equals(handSign) || "Heart_single".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                rb.mouseWheel(50);
            }
        }else if ("Five".equals(handSign) ) {
            for (int i = 0; i < num; i++) {
                rb.mouseWheel(-60);
            }
        }

    }


    @Override
    public void handler(String classname) {
        try{
            dealHandSign(classname);
        }catch (Exception e){
            log.error("操作map异常{}",e);
        }
    }
}
