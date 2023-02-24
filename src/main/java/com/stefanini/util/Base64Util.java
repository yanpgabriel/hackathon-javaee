package com.stefanini.util;

import java.util.Base64;

public class Base64Util {
    public static String encode(String string){
        return Base64.getEncoder().encodeToString(string.getBytes());
    }

    public static String decode(String string){
        return new String(Base64.getDecoder().decode(string));
    }
}
