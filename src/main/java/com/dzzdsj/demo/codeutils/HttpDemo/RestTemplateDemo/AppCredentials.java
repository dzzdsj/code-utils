package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo;


import com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.util.security.crypto.CryptoUtils;
import org.apache.commons.lang3.StringUtils;

import java.util.*;

/**
 * @author: mawenliang
 * @Date: 2018/9/25 19:59
 * @Description:
 */
public class AppCredentials {

    public static Map<String, String> generateAppCredentials(Map<String, String> params, String appId, String appSecret, String signType, String url) {
        Map<String, String> headers = new HashMap<String, String>();
        Map<String, String> copyParams = new HashMap<String, String>();
        if (null != params && !params.isEmpty()) {
            copyParams.putAll(params);
        }
        String timestamp = String.valueOf(System.currentTimeMillis());
        copyParams.put("appId", appId);
        copyParams.put("appSecret", appSecret);
        copyParams.put("signType", signType);
        copyParams.put("timestamp", timestamp);
        copyParams.put("reqUri", url);

        StringBuilder content = new StringBuilder();
        List<String> keys = new ArrayList<>(copyParams.keySet());
        Collections.sort(keys);
        int index = 0;
        for (String key : keys) {
            String value = copyParams.get(key);
            //参数不为空且长度不超过1000的按照key=value用&拼接
            if (StringUtils.isNoneBlank(key, value) && value.length() <= CoreConstants.PARAM_MAX_LENGTH) {
                content.append((index == 0 ? "" : "&")).append(key).append("=").append(value);
                index++;
            }

        }
        // 生成签名
        String sign = "";
        switch (signType) {
            case CryptoConstants.DIGEST_ALGORITHM_MD5:
                sign = CryptoUtils.digestWithMD5(content.toString(), "utf-8");
                break;
            case CryptoConstants.DIGEST_ALGORITHM_SHA256:
                sign = CryptoUtils.digestWithSHA256(content.toString(), "utf-8");
                break;
            case CryptoConstants.DIGEST_ALGORITHM_SM3:
                sign = CryptoUtils.digestWithSM3(content.toString());
                break;
            default:
                break;
        }

        // 构造headers
        headers.put(HttpConstants.HEADER_APP_ID, appId);
        headers.put(HttpConstants.HEADER_APP_SIGN, sign);
        headers.put(HttpConstants.HEADER_APP_TIMESTAMP, timestamp);
        headers.put(HttpConstants.HEADER_SIGN_TYPE, signType);
//        if(headers!=null){
//            for(String s:headers.keySet()){
//                System.out.println(s+":"+headers.get(s));
//            }
//        }
        return headers;
    }
}
