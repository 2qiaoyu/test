package com.joham.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @Documented 标记生成javadoc
 * <p>
 * 　　@Inherited 标记继承关系
 * <p>
 * 　　@Retention 注解的生存期
 * <p>
 * 　　@Target 标注的目标
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String name();

    int age();
}
