package com.dzzdsj.demo.codeutils.JavaSE.DateFormat;

import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateFormatUtil {
    /**
     * Date转字符串
     */
    public static String dateToStr(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(date);
        return dateStr;
    }

    /**
     * Date转时间戳
     */
    public static long dateToTimestamp(Date date) {
        return date.getTime();
    }

    /**
     * 时间戳转字符串
     */  //1584265362653, 13位long
    public static String timestampToStr(long timestamp) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String dateStr = sdf.format(timestamp);
        return dateStr;
    }

    /**
     * 字符串转Date
     */
    public static Date strToDate(String str) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        ParsePosition parsePosition = new ParsePosition(0);
        return sdf.parse(str, parsePosition);
    }

    /**
     * 获取年份
     */
    public static int getYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 获取月份
     */
    public static int getMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        return calendar.get(Calendar.MONTH) + 1;
    }

    /**
     * 获取日期这个月的第几天
     */
    public static int getDayOfMonth(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //从0开始计数
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 获取日期这个年的第几天
     */
    public static int getDayOfYear(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //从0开始计数
        return calendar.get(Calendar.DAY_OF_YEAR);
    }

    /**
     * 获取日期这个年的第几天
     */
    public static int getDayOfWeek(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        //从0开始计数
        return calendar.get(Calendar.DAY_OF_WEEK) - 1;//0-6,星期天是0
    }
}
