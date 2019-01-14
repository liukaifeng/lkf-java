package com.lkf.annotation;

/**
 * 服务示例
 *
 * @author kaifeng
 * @date 2019/1/13
 */
public class AnnotationService {
    @Comment(author = "lkf", description = "我是方法methodA")
    public String methodA() {
        return "我是方法methodA";
    }
}
