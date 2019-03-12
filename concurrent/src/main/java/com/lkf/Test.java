package com.lkf;

import java.util.HashMap;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

import static sun.management.snmp.jvminstr.JvmThreadInstanceEntryImpl.ThreadStateMap.Byte0.newThread;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/1/12
 */
public class Test {


    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        System.out.println("getAndIncrement:" + atomicInteger.getAndIncrement());
        System.out.println("get:" + atomicInteger.get());
    }
}
