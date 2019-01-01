package com.lkf.parttern.composite.cmp;

/**
 * 文件对象实现类
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class CmpFile implements AbstractFile {

    private String name;

    public CmpFile(String name) {
        this.name = name;
    }

    @Override
    public void list() {
        System.out.println(CompositeDemo.compositeBuilder + name);
    }
}
