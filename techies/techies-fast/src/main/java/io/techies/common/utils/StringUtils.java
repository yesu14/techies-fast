package io.techies.common.utils;

import java.util.UUID;

public class StringUtils {
    public static String getUUID(){
        String uuid = UUID.randomUUID().toString();
        //去掉“-”符号
        return uuid.replaceAll("-", "");
    }
}
