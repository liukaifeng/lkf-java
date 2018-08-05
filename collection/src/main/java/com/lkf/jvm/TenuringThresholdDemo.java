package com.lkf.jvm;

/**
 * 动态对象年龄判定
 */
public class TenuringThresholdDemo {
    private static final int _1MB = 1024 * 1024;

    /**
     * VM 参 数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:MaxTenuringThreshold=15 -XX:+PrintTenuringDistribution -XX:+UseSerialGC
     */
    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[_1MB / 4];
        allocation2 = new byte[_1MB / 4];
        //allocation1+allocation2大于Survivo空间的一半
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];

    }

    public static void main(String[] args) {
        testTenuringThreshold();
    }
}
