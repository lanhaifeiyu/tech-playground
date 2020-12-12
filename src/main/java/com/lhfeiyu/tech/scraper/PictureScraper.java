package com.lhfeiyu.tech.scraper;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class PictureScraper {

    private static Logger logger = LoggerFactory.getLogger(PictureScraper.class);

    public static void main(String[] args) throws InterruptedException {
        String host = "https://cdn.puroller99.com";
        //String cmd = "wget -P /Users/airsonyu/ztmp/pic/ https://cdn.puroller99.com/c0487/2/1.jpg";

        /*parsePicture(host, "c0112", 31);
        parsePicture(host, "c0192", 66);

        parsePicture(host, "c0223", 57);
        parsePicture(host, "c0257", 80);
        parsePicture(host, "c0284", 182);
        parsePicture(host, "c0293", 76);

        parsePicture(host, "c0308", 84);
        parsePicture(host, "c0360", 76);

        parsePicture(host, "c0448", 31);
        parsePicture(host, "c0466", 74);
        parsePicture(host, "c0487", 70);
        parsePicture(host, "c0493", 36);

        parsePicture(host, "c0509", 68);
        parsePicture(host, "c0517", 64);
        parsePicture(host, "c0535", 51);
        parsePicture(host, "c0536", 66);
        parsePicture(host, "c0537", 54);
        parsePicture(host, "c0538", 22);
        parsePicture(host, "c0541", 60);
        parsePicture(host, "c0547", 135);
        parsePicture(host, "c0550", 51);
        parsePicture(host, "c0552", 51);
        parsePicture(host, "c0554", 54);
        parsePicture(host, "c0557", 31);
        parsePicture(host, "c0558", 45);
        parsePicture(host, "c0559", 49);
        parsePicture(host, "c0560", 30);
        parsePicture(host, "c0566", 47);*/

        changeNameForOrder();
    }

    /**
     * 修正排序，方便查看
     * 1.jpg -> 01.jpg
     * 9.jpg -> 09.jpg
     */
    public static void changeNameForOrder() {
        // /Users/airsonyu/ztmp/pic/c0112/1/1/jpg
        String base = "/Users/airsonyu/ztmp/pic/";
        File baseFolder = new File(base);
        File[] books = baseFolder.listFiles();
        for (File book : books) {
            if (book.getName().startsWith(".")) {
                continue;
            }
            logger.debug("change name book:{}", book.getName());
            File[] pages = book.listFiles();
            for (File page : pages) { // alias: chapter
                if (page.getName().startsWith(".")) {
                    continue;
                }
                logger.debug("change name page:{}", page.getName());
                File[] pics = page.listFiles();
                for (File pic : pics) {
                    if (pic.getName().startsWith(".")) {
                        continue;
                    }
                    String[] item = pic.getName().split("\\.");
                    int index = Integer.parseInt(item[0]);
                    String suffix = item[1];
                    if (index <= 9) {
                        String indexStr = "0" + index;
                        String newFile = page + "/" + indexStr + "." + suffix; // page 已经是全路径
                        logger.info("change name:{}", newFile);
                        pic.renameTo(new File(newFile));
                    }
                }
            }
        }

    }

    public static void parsePicture(String host, String book, int max_page) throws InterruptedException {
        //String cmd = "wget -P /Users/airsonyu/ztmp/pic/ https://cdn.puroller99.com/c0487/2/1.jpg";
        int max_index = 80; // 最后一张图会自动结束
        for (int page = 1; page <= max_page; page++) {
            for (int index = 1; index <= max_index; index++) {
                String save_folder = "/Users/airsonyu/ztmp/pic/" + book + "/" + page + "/";
                File file = new File(save_folder);
                if (!file.exists()) {
                    file.mkdirs();
                }
                String cmd_base = "wget -P " + save_folder;
                String cmd = cmd_base + " " + host + "/" + book + "/" + page + "/" + index + ".jpg";

                boolean success = runCmd(cmd); // 失败时就表明已经到了最后一张图片
                if (!success) {
                    logger.info("index end:{},page:{}", index, page);
                    break;
                }
            }
        }
    }

    public static boolean runCmd(String cmd) throws InterruptedException {
        Thread.sleep(50);
        logger.debug("runCmd:{}", cmd);
        Runtime runtime = Runtime.getRuntime();
        try {
            Process pro = runtime.exec(cmd);
            int status = pro.waitFor();
            if (status != 0) {
                logger.debug("Failed to call shell's command:{}", cmd);
                return false;
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return true;
    }

}
