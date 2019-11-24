package com.lkf.keyword;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private static final long serialVersionUID = 1L;
    protected int maxElements;

    public LRUCache(int maxSize) {
        super(maxSize, 0.75F, true);
        this.maxElements = maxSize;
    }
    /**
     * 判断节点数是否超出限制
     * @param eldest 头节点
     * @return 超限返回 true，否则返回 false
     */
    protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return this.size() > this.maxElements;
    }

    public V save(K key, V val) {
        return put(key, val);
    }

    public V getOne(K key) {
        return get(key);
    }

    public boolean exists(K key) {
        return containsKey(key);
    }

    public static void main(String[] args) {
        LRUCache<Integer, Integer> cache = new LRUCache<>(3);

        for (int i = 0; i < 5; i++) {
            cache.save(i, i * i);
        }

        System.out.println("插入5个键值对后，缓存内容：");
        System.out.println(cache + "\n");

        System.out.println("访问键值为2的节点后，缓存内容：");
        cache.getOne(7);
        System.out.println(cache + "\n");

        System.out.println("插入键值为8的键值对后，缓存内容：");
        cache.save(8, 8);
        System.out.println(cache);
    }
}
