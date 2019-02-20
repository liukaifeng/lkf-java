package com.lkf.concurrent;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.Phaser;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/1/27
 */
public class PhaserTest {
    public static void main(String[] args) throws IOException {
//        int parties = 3;
//        int phases = 4;
//
//        final Phaser phaser = new Phaser(parties) {
//            @Override
//            protected boolean onAdvance(int phase, int registeredParties) {
//                System.out.println("====== Phase : " + phase + " ======");
//                return registeredParties == 0;
//            }
//        };
//
//        for (int i = 0; i < parties; i++) {
//            int threadId = i;
//            Thread thread = new Thread(() -> {
//                for (int phase = 0; phase < phases; phase++) {
//                    System.out.println(String.format("Thread %s, phase %s", threadId, phase));
//                    phaser.arriveAndAwaitAdvance();
//                }
//            });
//            thread.start();
//        }
        String s1 = "Hello World";
        String s2 = new String(s1.getBytes("GB2312"), StandardCharsets.ISO_8859_1);

    }

    public static boolean testAllUpperCase(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (!Character.isUpperCase(c)) {
                return false;
            }
        }
        return true;
    }
}
