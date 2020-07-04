package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.util.security.crypto;


import com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.util.security.crypto.sm.sm3.SM3Digest;
import com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.util.security.crypto.sm.sm4.SM4Coder;
import org.apache.commons.codec.binary.Base64;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.util.encoders.Hex;


import java.io.UnsupportedEncodingException;

/**
 * @author MaJingcao
 * @date 2017/12/27
 * Copyright by syswin
 */

public class CryptoUtils {


    public static final String CHARSET = "UTF-8";

    public static String encryptWithSM4(String data, String key,
                                        boolean isUrlSafe) {
        try {
            SM4Coder sm4 = new SM4Coder();
            sm4.setSecretKey(key);
            byte[] encrypt = sm4.encryptData_ECB(data).getBytes("UTF-8");
            if (isUrlSafe) {
                return Base64.encodeBase64URLSafeString(encrypt);
            }
            return Base64.encodeBase64String(encrypt);
        } catch (Exception e) {

            System.out.println("encrypt执行失败： " + e.getMessage() + e);
        }
        return null;
    }

    public static String decryptWithSM4(String encryptData, String key) {
        try {
            SM4Coder sm4 = new SM4Coder();
            sm4.setSecretKey(key);
            byte[] encodeBase64 = Base64.decodeBase64(encryptData
                    .getBytes("UTF-8"));
            return sm4.decryptData_ECB(new String(encodeBase64, "UTF-8"));
        } catch (Exception e) {

            System.out.println("decrypt执行失败： " + e.getMessage() + e);
        }
        return null;
    }

    public static String digestWithSM3(String data) {
        try {
            SM3Digest digest = new SM3Digest();
            byte[] dbyte = data.getBytes("UTF-8");
            digest.update(dbyte, 0, dbyte.length);
            byte[] sign = new byte[32];
            digest.doFinal(sign, 0);
            return new String(Hex.encode(sign), "UTF-8");
        } catch (Exception e) {
            System.out.println("decrypt执行失败： " + e.getMessage() + e);
        }
        return null;
    }

    public static String digestWithMD5(String data, String charSet) {
        try {
            return DigestUtils.md5Hex(data.getBytes(charSet)).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            return DigestUtils.md5Hex(data).toUpperCase();
        }
    }

    public static String digestWithSHA256(String data, String charSet) {
        try {
            return DigestUtils.sha256Hex(data.getBytes(charSet)).toUpperCase();
        } catch (UnsupportedEncodingException e) {
            return DigestUtils.sha256Hex(data).toUpperCase();
        }
    }

}