package com.lkf.parttern.composite.cmp;
/**
 * 组合模式客户端调用
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class CompositeDemo {
    public static StringBuilder compositeBuilder = new StringBuilder();

    public static void main(String[] args) {
        CmpDirectory d1 = new CmpDirectory("一级目录（01）");
        CmpDirectory d2 = new CmpDirectory("二级目录（02）");
        CmpDirectory d3 = new CmpDirectory("三级目录（03）");

        CmpFile track1 = new CmpFile("File_01_01");
        CmpFile track2 = new CmpFile("File_01_02");
        CmpFile track3 = new CmpFile("File_02_01");
        CmpFile track4 = new CmpFile("File_02_02");
        CmpFile track5 = new CmpFile("File_03_01");

        d1.add(track1);
        d1.add(d2);
        d1.add(track2);

        d2.add(track3);
        d2.add(track4);
        d2.add(d3);

        d3.add(track5);

        d1.list();
    }
}


