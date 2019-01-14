package com.lkf.annotation;

import java.lang.annotation.*;

/**
 * 自定义注解，用于方法描述
 *
 * @author kaifeng
 * @date 2019/1/13
 */
@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Comment {
    String author() default "lkf";

    String description();
}

