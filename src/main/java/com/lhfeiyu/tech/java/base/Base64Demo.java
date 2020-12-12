package com.lhfeiyu.tech.java.base;

import org.apache.ibatis.javassist.bytecode.ByteArray;

import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.text.MessageFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.Formatter;
import java.util.Locale;

/**
 * @author airson
 */
public class Base64Demo {

    public static void main(String[] args) {
        formatString();
        //nullCheck();
    }

    public static void formatString() {
        int n = 0x0f03<<16;
        byte[] b = new byte[4];
        b[3] = (byte) (n & 0xff);
        b[2] = (byte) (n >> 8 & 0xff);
        b[1] = (byte) (n >> 16 & 0xff);
        b[0] = (byte) (n >> 24 & 0xff);

        String str = Base64.getEncoder().encodeToString(b);
        System.out.println(str);

        String msg = "5LiN6L+H56m/6LaK"; // 不过穿越
        try {
            str = new String(Base64.getDecoder().decode(msg),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        System.out.println(str);

        String sbstr = "01234567890123456789";
        System.out.println(sbstr.substring(0,18));


    }

}
