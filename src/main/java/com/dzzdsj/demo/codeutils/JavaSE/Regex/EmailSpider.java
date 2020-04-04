package com.dzzdsj.demo.codeutils.JavaSE.Regex;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailSpider {
    public static void main(String[] args) {
        try {
            BufferedReader br = new BufferedReader(new FileReader("D:\\git\\myGit\\demo\\code-utils\\src\\main\\java\\com\\dzzdsj\\demo\\codeutils\\JavaSE\\Regex\\emailhtml.html"));
            String line = "";
            while ((line = br.readLine()) != null){
                parse(line);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void parse(String line) {
//        Pattern p = Pattern.compile("[\\w[.-]]+@[\\w[.-]]+\\.[\\w]+");
        /**汉字在正则表示为[\u4e00-\u9fa5]*/
        Pattern p = Pattern.compile("[A-Za-z0-9\\u4e00-\\u9fa5]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");
//        Pattern p = Pattern.compile("[a-zA-Z0-9_-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+");//不包含汉字
        Matcher m = p.matcher(line);
        while (m.find()){
            System.out.println(m.group());
        }
    }
}
