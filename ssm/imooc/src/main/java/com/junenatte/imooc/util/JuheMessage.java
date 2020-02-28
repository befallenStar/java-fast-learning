package com.junenatte.imooc.util;

import com.alibaba.fastjson.JSONObject;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

//import net.sf.json.JSONObject;

/**
 * @author www.juhe.com
 */
public class JuheMessage {
    public static final String DEF_CHATSET = "UTF-8";
    public static final int DEF_CONN_TIMEOUT = 30000;
    public static final int DEF_READ_TIMEOUT = 30000;
    public static String userAgent = "Mozilla/5.0 (Windows NT 6.1) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/29.0.1547.66 Safari/537.36";

    public static String mobileQuery(String phone, String code) {
        String result = null;
        //请求接口地址
        String url = "http://v.juhe.cn/sms/send";
        //请求参数
        Map<String, String> params = new HashMap<>();
        //接受短信的用户手机号码
        params.put("mobile", phone);
        //您申请的短信模板ID，根据实际情况修改
        params.put("tpl_id", "49816");
        //您设置的模板变量，根据实际情况修改
        params.put("tpl_value", "#code#=" + code);
        //应用APPKEY(应用详细页查询)
        params.put("key", "");
        try {
            result = net(url, params, "GET");
            JSONObject object = JSONObject.parseObject(result);
            if (object.getInteger("error_code") == 0) {
                result = (String) object.get("result");
            } else {
                result = object.get("error_code") + ":" + object.get("reason");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return result;
    }

    public static void main(String[] args) {

    }

    /**
     * @param strUrl 请求地址
     * @param params 请求参数
     * @param method 请求方法
     * @return 网络请求字符串
     */
    public static String net(String strUrl, Map<String, String> params, String method) throws Exception {
        HttpURLConnection conn = null;
        BufferedReader reader = null;
        String rs = null;
        try {
            StringBuilder sb = new StringBuilder();
            String GET = "GET";
            String POST = "POST";
            if (method == null || GET.equals(method)) {
                strUrl = strUrl + "?" + urlencode(params);
            }
            URL url = new URL(strUrl);
            conn = (HttpURLConnection) url.openConnection();
            if (method == null || GET.equals(method)) {
                conn.setRequestMethod(GET);
            } else {
                conn.setRequestMethod(POST);
                conn.setDoOutput(true);
            }
            conn.setRequestProperty("User-agent", userAgent);
            conn.setUseCaches(false);
            conn.setConnectTimeout(DEF_CONN_TIMEOUT);
            conn.setReadTimeout(DEF_READ_TIMEOUT);
            conn.setInstanceFollowRedirects(false);
            conn.connect();
            if (params != null && POST.equals(method)) {
                try {
                    DataOutputStream out = new DataOutputStream(conn.getOutputStream());
                    out.writeBytes(urlencode(params));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
            InputStream is = conn.getInputStream();
            reader = new BufferedReader(new InputStreamReader(is, DEF_CHATSET));
            String strRead;
            while ((strRead = reader.readLine()) != null) {
                sb.append(strRead);
            }
            rs = sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                reader.close();
            }
            if (conn != null) {
                conn.disconnect();
            }
        }
        return rs;
    }

    /**
     * 将map型转为请求参数型
     *
     * @param data 请求参数
     * @return url
     */
    public static String urlencode(Map<String, String> data) {
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<String, String> i : data.entrySet()) {
            try {
                sb.append(i.getKey()).append("=").append(URLEncoder.encode(i.getValue() + "", "UTF-8")).append("&");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
}
