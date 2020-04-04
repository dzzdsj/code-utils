package com.dzzdsj.demo.codeutils.FastJsonDemo.MenuTree;

import lombok.Data;

import java.util.List;

/**
 * 菜单树<-->叶子节点转换
 */
@Data
public class Menu {
    private int id;
    private int parentId;
    private String url;
    private String title;
    private String icon;
    private List<Menu> child;

    public Menu(int id, int parentId, String url, String title, String icon) {
        this.id = id;
        this.parentId = parentId;
        this.url = url;
        this.title = title;
        this.icon = icon;
    }
}
