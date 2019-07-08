package cn.edu.njnu.util;

import sun.misc.BASE64Encoder;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;

public class DownloadUtil {

    public static String getName(String agent, String filename) throws UnsupportedEncodingException {
        if (agent.contains("MSIE")) {
            //IE浏览器
            filename = URLEncoder.encode(filename, "utf-8");
            filename = filename.replace("+", " ");
        } else if (agent.toLowerCase().contains("firefox")) {
            //火狐浏览器
            BASE64Encoder base64Encoder = new BASE64Encoder();
            filename = "=?utf-8?B?" + base64Encoder.encode(filename.getBytes(StandardCharsets.UTF_8)) + "?=";
        } else {
            filename = URLEncoder.encode(filename, "utf-8");
        }
        return filename;
    }

}
