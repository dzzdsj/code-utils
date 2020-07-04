package com.dzzdsj.demo.codeutils.HttpDemo.RestTemplateDemo.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * @author zhangjian
 * @date 2017年8月18日 下午3:36:58
 * @Description: TODO
 */
public class CollectionUtils {
    /**
     * @param array
     * @return List<T>
     * @author zhangjian
     * @date 2017年8月28日 下午1:46:10
     * @Description: 将数组转换成list集合
     */
    public static <T> List<T> ArrayToList(T[] array) {
        ArrayList<T> arrayList = new ArrayList<>();
        if (array == null) {
            return arrayList;
        }
        for (T string : array) {
            if (!string.equals("")) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    /**
     * @param StringList
     * @return List<String>
     * @author zhangjian
     * @date 2017年8月28日 下午1:46:22
     * @Description: 将拼接的string字符串转换成list集合
     */
    public static List<String> stringArrayToStringList(String StringList, String separator) {
        if (StringUtils.isBlank(StringList)) {
            return null;
        }
        String[] split = StringList.split(separator);
        ArrayList<String> arrayList = new ArrayList<>();
        if (split == null) {
            return arrayList;
        }
        for (String string : split) {
            if (!string.equals("")) {
                arrayList.add(string);
            }
        }
        return arrayList;
    }

    /**
     * @param StringList
     * @return List<String>
     * @author zhangjian
     * @date 2017年8月28日 下午1:46:22
     * @Description: 将list集合编程元素拼接形式
     */
    public static String StringListTostringArray(List<String> list, String separator) {
        StringBuffer stringBuffer = new StringBuffer();
        for (String string : list) {
            if (StringUtils.isNotBlank(string)) {
                stringBuffer.append(string).append(separator);
            }

        }
        return stringBuffer.toString();
    }

    /**
     * @param list
     * @return List<T>
     * @author zhangjian
     * @date 2017年8月28日 下午1:52:22
     * @Description: 集合去重
     */
    public static <T> List<T> uniq(List<T> list) {
        HashSet<T> hashSet = new HashSet<>();
        for (T t : hashSet) {
            hashSet.add(t);
        }
        ArrayList<T> arrayList = new ArrayList<>();
        for (T t : arrayList) {
            arrayList.add(t);
        }
        return arrayList;

    }

}
