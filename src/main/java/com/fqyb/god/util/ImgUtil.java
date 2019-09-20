package com.fqyb.god.util;

import org.springframework.util.StringUtils;

import java.text.MessageFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author: zhaoxudong
 * @date: 2019-09-19 20:46
 * @description:
 */
public class ImgUtil {
    /**
     * 去掉base64图片前缀
     *
     * @param imgString
     * @return
     */
    public static  String replacePre(String imgString) {
        //允许的图片格式（可配置）
        String imgType = "jpg,png,jpeg,webp";
        if (!StringUtils.isEmpty(imgType)) {
            String[] imgTypes = imgType.split(",");
            Pattern pattern;
            Matcher matcher;
            String regex;
            for (String v : imgTypes) {
                regex = MessageFormat.format("data:image/{0};base64,", v);
                pattern = Pattern.compile(regex, Pattern.CASE_INSENSITIVE);
                matcher = pattern.matcher(imgString);
                if (matcher.lookingAt()) {
                    return matcher.replaceFirst("");
                }
            }
        }
        return imgString;
    }
}
