package com.dzzdsj.demo.codeutils.FastJsonDemo.MenuTree;

import java.util.ArrayList;
import java.util.List;

public class MenuTreeDemo {
    public static void main(String[] args) {
        //初始化所有节点
        List<Menu> leefList = initMenuTree();
        //1.获取所有根节点
        List<Menu> rootList = getRootList(leefList);
        //2.递归->为所有根节点找到他对应的子节点
        rootList.forEach(out -> {
            List<Menu> childList = getChild(out.getId(), leefList);
            out.setChild(childList);
        });
        System.out.println(rootList);
    }

    private static List<Menu> getRootList(List<Menu> menuList) {
        List<Menu> rootList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getParentId() == 0) {
                rootList.add(menu);
            }
        }
        return rootList;
    }

    /**
     * 在所有叶子节点中获取当前id的子节点
     *
     * @param id
     * @param menuList
     * @return
     */
    private static List<Menu> getChild(int id, List<Menu> menuList) {
        List<Menu> childList = new ArrayList<>();
        for (Menu menu : menuList) {
            if (menu.getParentId() == id) {
                childList.add(menu);
            }
        }
        return childList;
    }

    /**
     * 初始化所有节点
     *
     * @return
     */
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
