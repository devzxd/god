package com.fqyb.god.service;

import com.fqyb.god.common.TypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * @author：zhaoyi
 * @createTime: 2019/9/21,3:52 下午
 */
@Component
@Slf4j
public class VideoHandler implements DreamHandler  {
    public void dealHandSign(String handSign) throws Exception {
        final Robot rb = new Robot();
        int num = 1;
        //快进
        if ("Five".equalsIgnoreCase(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("快进5秒");
                rb.keyPress(KeyEvent.VK_RIGHT);
                rb.keyRelease(KeyEvent.VK_RIGHT);
            }
        //快退
        } else if ("One".equalsIgnoreCase(handSign)) {
            for (int i = 0; i < num; i++) {
                Thread.sleep(2000);
                System.out.println("快退5秒");
                rb.keyPress(KeyEvent.VK_LEFT);
                rb.keyRelease(KeyEvent.VK_LEFT);
            }

        } else if ("lock".equals(handSign)) {
            rb.keyPress(KeyEvent.VK_CONTROL);
            rb.keyPress(KeyEvent.VK_Q);
            rb.keyRelease(KeyEvent.VK_Q);
            rb.keyRelease(KeyEvent.VK_CONTROL);
        //音量放大
        } else if ("Thumb_up".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("soundUp");
                rb.keyPress(KeyEvent.VK_UP);
                rb.keyRelease(KeyEvent.VK_UP);
            }
        //音量降低
        } else if ("Thumb_down".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("soundDown");
                rb.keyPress(KeyEvent.VK_DOWN);
                rb.keyRelease(KeyEvent.VK_DOWN);
            }
        //播放/暂停
        } else if ("Palm_up".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("run/stop");
                rb.keyPress(KeyEvent.VK_SPACE);
                rb.keyRelease(KeyEvent.VK_SPACE);
            }
        }
        //上一集
        else if ("Prayer".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("上一集");
                rb.keyPress(KeyEvent.VK_PAGE_UP);
                rb.keyRelease(KeyEvent.VK_PAGE_UP);
            }
        }
        //下一集
        else if ("OK".equals(handSign)) {
            for (int i = 0; i < num; i++) {
                System.out.println("下一集");
                rb.keyPress(KeyEvent.VK_PAGE_DOWN);
                rb.keyRelease(KeyEvent.VK_PAGE_DOWN);
            }
        }


    }

    @Override
    public TypeEnum getHandlerType() {
        return TypeEnum.VIDEO;
    }

    @Override
    public void handler(String classname) {
        try{
            dealHandSign(classname);
        }catch (Exception e){
            log.error("操作video异常{}",e);
        }
    }
}
