package com.lkf.rwlock;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 *
 *
 * @author kaifeng
 * @date 2018/12/9
 */
public class ReadWriteLockCache {
    private static Map<String, Object> cacheMap = new HashMap<String, Object>();
    private static ReentrantReadWriteLock rwl = new ReentrantReadWriteLock();
    private static Lock readLock = rwl.readLock();
    private static Lock writeLock = rwl.writeLock();

    /**
     * 根据指定key获取值
     *
     * @param key 指定key
     */
    public static Object get(String key) {
        readLock.lock();
        try {
            return cacheMap.get(key);
        } finally {
            readLock.unlock();
        }
    }

    /**
     * 更新指定key对应的值，并返回旧值
     */
    public static Object put(String key, Object value) {
        writeLock.lock();
        try {
            return cacheMap.put(key, value);
        } finally {
            writeLock.unlock();
        }
    }

    /**
     * 清空所有缓存内容
     */
    public static void clear() {
        writeLock.lock();
        try {
            cacheMap.clear();
        } finally {
            writeLock.unlock();
        }
    }
}