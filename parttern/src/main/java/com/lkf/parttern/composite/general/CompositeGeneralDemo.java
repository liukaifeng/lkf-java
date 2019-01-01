package com.lkf.parttern.composite.general;

/**
 * 普通实现方式
 *
 * @author kaifeng
 * @date 2018/12/23
 */
public class CompositeGeneralDemo {
    public static StringBuilder compositeBuilder = new StringBuilder();

    public static void main(String[] args) {
        Directory d1 = new Directory("一级目录（01）");
        Directory d2 = new Directory("二级目录（02）");
        Directory d3 = new Directory("三级目录（03）");

        File track1 = new File("File_01_01");
        File track2 = new File("File_01_02");
        File track3 = new File("File_02_01");
        File track4 = new File("File_02_02");
        File track5 = new File("File_03_01");

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
