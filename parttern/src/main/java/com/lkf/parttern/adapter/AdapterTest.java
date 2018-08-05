package com.lkf.parttern.adapter;

public class AdapterTest {
    public static void main(String[] args) {
//        Target adapter = new Adapter();
        Target adapter = new AdapterWarpper(new Adaptee());
        adapter.sampleOperation1();
        adapter.sampleOperation2();
    }
}
