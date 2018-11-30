package com.wsk.common.utils;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

/**
 * @author WuShukai
 * @version V1.0
 * @description
 * @date 2018/11/30  16:05
 */
public class HttpUtil {
    public static void get(String url) {
        try {
            Document document = Jsoup.connect(url).get();
            System.out.println(document.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String urlToStringPost(String url) throws IOException {
        Document document;
        Connection connection = Jsoup.connect(url).ignoreContentType(true).timeout(5000);
        document = connection.post();
        return document.getElementsByTag("body").first().text();
    }

    public static void main(String[] args) throws InterruptedException, IOException {
        int a = 0;
        while (true) {
            System.out.println(a);
            urlToStringPost("http://localhost:8762/hi?name=wsk");
//            Thread.sleep(1000);
            if (a++ >= 100000) {
                break;
            }
        }
    }
}
