package com.lkf.jdk8;

public class AppleColorPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        // 选出绿色的苹果
        return "green".equalsIgnoreCase(apple.getColor());
    }
}
