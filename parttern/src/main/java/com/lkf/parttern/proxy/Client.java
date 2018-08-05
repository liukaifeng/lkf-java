package com.lkf.parttern.proxy;

public class Client {
    public static void main(String[] args) {
        Proxy proxy = new Proxy(new RealSubject());
        proxy.request("今天晚饭吃什么");
    }
}
