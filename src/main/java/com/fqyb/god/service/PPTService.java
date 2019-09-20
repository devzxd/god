package com.fqyb.god.service;

import org.springframework.stereotype.Service;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

/**
 * @author：zhaoyi
 * @createTime: 2019/9/20,4:08 下午
 */
@Service
public class PPTService {
    public void dealHandSign(String handSign) throws Exception {
        final Robot rb = new Robot();
        int num = 1;
        if ("1".equals(handSign) || "s".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("up");
                rb.keyPress(KeyEvent.VK_UP);
                rb.keyRelease(KeyEvent.VK_UP);
            }

        } else if ("2".equals(handSign) || "w".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("down");
                rb.keyPress(KeyEvent.VK_DOWN);
                rb.keyRelease(KeyEvent.VK_DOWN);
            }

        } else if ("lock".equals(handSign)) {
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_Q);
            rb.keyRelease(KeyEvent.VK_Q);
            rb.keyRelease(KeyEvent.VK_CONTROL);

        } else if ("3".equals(handSign) || "d".equals(handSign)) {
            for (int i = 0; i < num; i++) {
//                Thread.sleep(20);
                System.out.println("turnleft");
                rb.keyPress(KeyEvent.VK_LEFT);
                rb.delay(100);//停顿100ms
                rb.keyRelease(KeyEvent.VK_LEFT);
            }

        } else if ("4".equals(handSign) || "a".equals(handSign)) {
            for (int i = 0; i < num; i++) {
//                Thread.sleep(20);
                System.out.println("turnright");
                rb.keyPress(KeyEvent.VK_RIGHT);
                rb.delay(100);//停顿100ms
                rb.keyRelease(KeyEvent.VK_RIGHT);
            }

        } else if ("11".equals(handSign) || "rollup".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                rb.mouseWheel(50);
            }
        } else if ("12".equals(handSign) || "rolldown".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                rb.mouseWheel(-50);
            }
        }


    }
}
