package com.sayboard.utils;

/**
 * @outhor moke
 * @date 2019-11-19
 */
public class WebUtil {
    private WebUtil(){

    }
    public static boolean isNull(String name){
        return name == null || "".equals(name);
    }
}
