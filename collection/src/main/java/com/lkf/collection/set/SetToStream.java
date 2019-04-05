package com.lkf.collection.set;

import java.util.HashSet;
import java.util.Set;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/4/5
 */
public class SetToStream {
    public static void main(String[] args) {
        Set<String> vowelsSet = new HashSet<>();
        vowelsSet.add("h");
        vowelsSet.add("e");
        vowelsSet.add("l");
        vowelsSet.add("l");
        vowelsSet.add("o");

        //转换 set 为 stream 并进行遍历输出
        vowelsSet.stream().forEach(System.out::println);
    }
}
