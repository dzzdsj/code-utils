package com.dzzdsj.demo.codeutils.Utils;

public class FormatValidUtil {
//    public static final String PHONE = "PHONE";
//    public static final String PASSWORD = "PASSWORD";
    public enum FormatEnum{PHONE,PASSWORD,IDCARD,USERNAME};
//    public static boolean validFormat(String validStr, String type){
//        switch (type){
//            case PHONE:
//                String phoneREG = "[1]\\d{10}";
//                return validStr.matches(phoneREG);
//            case PASSWORD:
//                return checkPassword(validStr);
//            default:
//                return false;
//        }
//    }

    public static boolean validFormat(String validStr, FormatEnum type){
        switch (type){
            case PHONE:
                String phoneREG = "[1]\\d{10}";
                return validStr.matches(phoneREG);
            case PASSWORD:
                return checkPassword(validStr);
            default:
                return false;
        }
    }

    /**
     *长度10到30位之间
     *至少包含大写字母、小写字母、数字、特殊字符中任意三个
     */
    public static boolean checkPassword(String password){
        int f1 = 0;
        int f2 = 0;
        int f3 = 0;
        int f4 = 0;
        int length = password.length();
        if(length<10 || length>30){
            return false;
        }

        for(int i=0;i<length;i++){
            char a = password.charAt(i);

            if(a>='a'&&a<='z'){
                f1=1;
                continue;
            }
            if(a>='A'&&a<='Z'){
                f2=1;
                continue;
            }
            //数字0-9
            if(a>=48&&a<=57){
                f3=1;
                continue;
            }
            if(f1==1&&f2==1&&f3==1){
                break;
            }
            //特殊字符
            f4=1;
        }
        if((f1+f2+f3+f4)>=3){
            return true;
        }else {
            return false;
        }
    }

}
