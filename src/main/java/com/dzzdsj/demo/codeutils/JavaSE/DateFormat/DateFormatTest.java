package com.dzzdsj.demo.codeutils.JavaSE.DateFormat;

import java.util.Calendar;
import java.util.Date;

public class DateFormatTest {
    public static void main(String[] args) {
        /**获取当前系统时间的三种方式*/
        long currentTimeMillis = System.currentTimeMillis();//1584265362653, 13位long
        Calendar calendar = Calendar.getInstance();
        Date date = new Date();
        System.out.println(currentTimeMillis);
        System.out.println(calendar);
        System.out.println(date);

        System.out.println(DateFormatUtil.dateToStr(date));
        System.out.println(DateFormatUtil.dateToTimestamp(date));
        System.out.println(DateFormatUtil.timestampToStr(currentTimeMillis));

        String str = "2020-03-15 17:42:42";
        System.out.println(str);
        System.out.println(DateFormatUtil.strToDate(str));

        System.out.println(DateFormatUtil.getYear(date));
        System.out.println(DateFormatUtil.getMonth(date));
        System.out.println(DateFormatUtil.getDayOfMonth(date));
        System.out.println(DateFormatUtil.getDayOfYear(date));
        System.out.println(DateFormatUtil.getDayOfWeek(date));
    }
}
