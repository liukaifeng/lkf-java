package com.lkf.parttern.composite.cmp;

import java.util.ArrayList;

/**
 * 目录对象实现类
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class CmpDirectory implements AbstractFile {
    private String name;
    private ArrayList includedFiles = new ArrayList();

    public CmpDirectory(String name) {
        this.name = name;
    }

    public void add(Object obj) {
        includedFiles.add(obj);
    }

    @Override
    public void list() {
        System.out.println(CompositeDemo.compositeBuilder + name);
        CompositeDemo.compositeBuilder.append("   ");
        for (Object includedFile : includedFiles) {
            AbstractFile obj = (AbstractFile) includedFile;
            obj.list();
        }
        CompositeDemo.compositeBuilder.setLength(CompositeDemo.compositeBuilder.length() - 3);
    }
}
