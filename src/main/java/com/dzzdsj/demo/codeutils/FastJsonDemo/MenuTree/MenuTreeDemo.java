package com.dzzdsj.demo.codeutils.FastJsonDemo.MenuTree;

import com.alibaba.fastjson.JSON;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeDemo {
    public static void main(String[] args) {
        List<Menu> menuList = initMenuTree();//初始化所有叶子节点
        String menuListStr = JSON.toJSONString(menuList);
        System.out.println("menuListStr:"+menuListStr);
        List<Menu> rootList = getRootList(menuList);//1.获取所有根节点
        System.out.println("rootList:"+rootList);
        for (Menu menu:rootList){
            List<Menu> childList = new ArrayList<>();
            childList.addAll(getChild(menu.getId(),menuList));
        }
    }

    private static List<Menu> getRootList(List<Menu> menuList) {
        List<Menu> rootList = new ArrayList<>();
        for (Menu menu: menuList) {
            if(menu.getParentId()==0){
                rootList.add(menu);
            }
        }
        return rootList;
    }

    private static List<Menu> getChild(int id, List<Menu> menuList){
        List<Menu> childList = new ArrayList<>();
        for(Menu menu: menuList){
            if(menu.getParentId()==id){
                childList.add(menu);
            }
        }
        return childList;
    }

    private static List<Menu> initMenuTree() {
        List<Menu> menuList = new ArrayList<>();
        Menu menu1 = new Menu(1, 0, "aa", "bb", "cc");
        Menu menu2 = new Menu(2, 0, "aa", "bb", "cc");
        Menu menu3 = new Menu(3, 1, "aa", "bb", "cc");
        Menu menu4 = new Menu(4, 1, "aa", "bb", "cc");
        Menu menu5 = new Menu(5, 2, "aa", "bb", "cc");
        Menu menu6 = new Menu(6, 2, "aa", "bb", "cc");
        Menu menu7 = new Menu(7, 3, "aa", "bb", "cc");
        Menu menu8 = new Menu(8, 5, "aa", "bb", "cc");
        Menu menu9 = new Menu(9, 7, "aa", "bb", "cc");
        menuList.add(menu1);
        menuList.add(menu2);
        menuList.add(menu3);
        menuList.add(menu4);
        menuList.add(menu5);
        menuList.add(menu6);
        menuList.add(menu7);
        menuList.add(menu8);
        menuList.add(menu9);
        return menuList;
    }
}
