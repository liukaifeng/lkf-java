package com.lkf.parttern.composite.general;

/**
 * 文件对象
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class File {
    private String name;

    public File(String name) {
        this.name = name;
    }

    public void list() {
        System.out.println(CompositeGeneralDemo.compositeBuilder + name);
    }
}
