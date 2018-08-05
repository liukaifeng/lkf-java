package com.lkf.jvm;

import java.lang.ref.PhantomReference;
import java.lang.ref.ReferenceQueue;

public class PhantomReferenceDemo {
    public static void main(String[] args) {
        ReferenceQueue<String> queue = new ReferenceQueue<String>();
        PhantomReference<String> pr = new PhantomReference<String>("Hello World", queue);
        System.out.println(pr.get());
    }
}
