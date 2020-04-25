package com.dzzdsj.demo.codeutils.Utils;

public class FormatValidDemo {
    public static void main(String[] args) {
        String phone = "123456789012";
        boolean flag = FormatValidUtil.validFormat(phone, FormatValidUtil.FormatEnum.PHONE);
        System.out.println(flag);
    }
}
