package com.lkf.annotation;

import sun.management.MethodInfo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * to do desc
 *
 * @author kaifeng
 * @date 2019/1/13
 */
public class AnnotationDemo {
    public static void main(String[] args) {
        try {
            for (Method method : AnnotationDemo.class
                    .getClassLoader()
                    .loadClass(("com.lkf.annotation.AnnotationService"))
                    .getMethods()) {
                if (method
                        .isAnnotationPresent(com.lkf.annotation.Comment.class)) {
                    try {
                        for (Annotation anno : method.getDeclaredAnnotations()) {
                            System.out.println("Annotation in Method '"
                                    + method + "' : " + anno);
                        }
                        Comment comment = method
                                .getAnnotation(Comment.class);
                        System.out.println("author:" + comment.author());
                        System.out.println("description:" + comment.description());

                    } catch (Throwable ex) {
                        ex.printStackTrace();
                    }
                }
            }
        } catch (SecurityException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
