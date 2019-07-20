package com.lkf.jdk8.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * java.util.function.Consumer<T>定义了一个叫accept的抽象方法，它接受一个泛型T的对象，并没有返回（void）
 */
public class ConsumerDemo {
    public static void main(String[] args) {
        //遍历对象集合，并打印每一个元素
        forEach(Arrays.asList(2, 4, 9), System.out::println);
    }

    /**
     * 根据 consumer 遍历对象
     */
    public static <T> void forEach(List<T> list, Consumer<T> consumer) {
        for (T t : list) {
            consumer.accept(t);
        }
    }
}
