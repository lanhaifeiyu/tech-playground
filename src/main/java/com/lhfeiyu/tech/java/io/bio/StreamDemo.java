package com.lhfeiyu.tech.java.io.bio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Date;

/**
 *
 */
public class StreamDemo {

    private static Logger logger = LoggerFactory.getLogger(StreamDemo.class);

    public static void main(String[] args) throws IOException {
        test();
    }

    public static void test() throws IOException {
        File file1 = new File("D:\\work\\airson\\tech\\stable_keep_files\\stream1.txt");
        File file2 = new File("D:\\work\\airson\\tech\\stable_keep_files\\stream2.txt");
        if (!file1.exists()) {
            file1.createNewFile();
        }

        if (file2.exists()) {
            file2.delete();
        }
        file2.createNewFile();


        FileInputStream fis = new FileInputStream(file1);
        BufferedInputStream bis = new BufferedInputStream(fis);
        DataInputStream dis = new DataInputStream(bis);

        FileOutputStream fis2 = new FileOutputStream(file2);
        BufferedOutputStream bis2 = new BufferedOutputStream(fis2);
        DataOutputStream dis2 = new DataOutputStream(bis2);

        byte[] data = new byte[512];
        int len;
        long d1 = new Date().getTime();
        while ((len = bis.read(data)) > 0) {
            //logger.debug("len:{}", len);
            bis2.write(data, 0, len);
        }
        long d2 = new Date().getTime();
        logger.debug("ts:{}", (d2 - d1));


        dis.close();
        dis2.close();


    }

}
