package com.lkf;

import java.util.HashMap;
import java.util.UUID;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.newThread;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/1/12
 */
public class Test {
    public static void main(String[] args) throws InterruptedException {
        final HashMap<String, String> map = new HashMap<String, String>(2);
        Thread t = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                new Thread(() -> map.put(UUID.randomUUID().toString(), ""), "child_thread_" + i).start();
            }
        }, "parent_thread");
        t.start();
        t.join();
    }
}
