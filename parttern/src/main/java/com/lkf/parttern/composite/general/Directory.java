package com.lkf.parttern.composite.general;

import java.util.ArrayList;

/**
 * 目录对象
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class Directory {
    private String name;
    private ArrayList includedFiles = new ArrayList();

    public Directory(String name) {
        this.name = name;
    }

    public void add(Object obj) {
        includedFiles.add(obj);
    }

    public void list() {
        System.out.println(CompositeGeneralDemo.compositeBuilder + name);
        CompositeGeneralDemo.compositeBuilder.append("   ");
        for (Object obj : includedFiles) {
            String name = obj.getClass().getSimpleName();
            if (name.equals("Directory")) {
                ((Directory)obj).list();
            } else {
                ((File)obj).list();
            }
        }
        CompositeGeneralDemo.compositeBuilder.setLength(CompositeGeneralDemo.compositeBuilder.length() - 3);
    }
}
