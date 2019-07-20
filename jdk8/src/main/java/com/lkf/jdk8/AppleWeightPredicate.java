package com.lkf.jdk8;

public class AppleWeightPredicate implements ApplePredicate{
    @Override
    public boolean test(Apple apple) {
        // 选出重量大于1的苹果
        return 1 < apple.getWeight();
    }
}
