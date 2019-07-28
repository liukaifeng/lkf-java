package com.lkf.jdk8.optional;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        Optional<Integer> canBeEmpty1 = Optional.of(5);
        canBeEmpty1.isPresent();                    // returns true
        canBeEmpty1.get();                          // returns 5

        Optional<Integer> canBeEmpty2 = Optional.empty();
        canBeEmpty2.isPresent();                    // returns false
    }
}
