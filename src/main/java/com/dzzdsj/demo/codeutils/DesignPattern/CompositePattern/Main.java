package com.dzzdsj.demo.codeutils.DesignPattern.CompositePattern;

/**
 * Composite 组合模式:使得容器和内容具有一致性，创造出递归结构   文件夹目录树/菜单树
 */
public class Main {
    public static void main(String[] args) {
        Directory rootdir = new Directory("root");
        Directory bindir = new Directory("bin");
        Directory usrdir = new Directory("usr");
        Directory tmpdir = new Directory("tmp");
        rootdir.add(bindir);
        rootdir.add(usrdir);
        rootdir.add(tmpdir);
        bindir.add(new File("vi", 100));
        bindir.add(new File("xx", 100));
        rootdir.printList();
    }
}
