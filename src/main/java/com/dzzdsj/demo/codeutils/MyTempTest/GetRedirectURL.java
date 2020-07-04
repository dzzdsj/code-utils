package com.dzzdsj.demo.codeutils.MyTempTest;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
/**
 * 获取重定向的地址上的参数
 *
 */
public class GetRedirectURL {

    /**
     * 获取重定向地址
     *
     * @param path
     * @return
     * @throws Exception
     */
    private static String getRedirectUrl(String path) throws Exception {
        HttpURLConnection conn = (HttpURLConnection) new URL(path)
                .openConnection();
        conn.setInstanceFollowRedirects(false);
        conn.setConnectTimeout(5000);
        return conn.getHeaderField("Location");
    }


    /**
     * url参数放进map
     * @param redictURL
     * @return
     */
    private static Map<String, String> getParamMap(String redictURL) {
        //截取参数字符串
        String paramStr = redictURL.substring(redictURL.indexOf("?") + 1);
        System.out.println(paramStr);
        String[] strArr = paramStr.split("&");
        //参数map
        Map<String, String> paramMap = new HashMap<>();
        String key;
        String value;
        for (String s : strArr) {
            key = s.substring(0, s.indexOf("="));
            value = s.substring(s.indexOf("=") + 1);
            paramMap.put(key, value);
        }
        return paramMap;
    }


    /**
     * 获取重定向的地址上的参数
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
        String url = "https://syuias.fuzhou.gov.cn/auth/authorize?clientId=202003190008&redirectUri=http%3A%2F%2Fwww.baidu.com&responseType=code&scope=userInfo&sign=C5A9FFEFC5BCAD791DFE3CB10565465B&personToken=b70cf3ad732ec3d913bf9f895d6a3e7890f8aa07715ca18b9303ba9bce03d3c25c448940d5a1fdbfd47810af366e5503d00c4b41a4a831d362b6e9af09d87ebdffd39fdc08fbae2c9f3ff89b2a1da8b48014455e44f5d048ec9454e069822d158a2c6e70fbf5d09a976b92783de3b0192c786d31eb9caebf860f9f18dddd004c";
        //回调地址
        String redictURL = getRedirectUrl(url);
        System.out.println(redictURL);
        //获取参数
        Map<String, String> paramMap = getParamMap(redictURL);
        System.out.println(paramMap);
        String code = paramMap.get("code");
        System.out.println("code=" + code);
    }
}
