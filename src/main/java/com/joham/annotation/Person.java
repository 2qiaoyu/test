package com.joham.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * Created by joham on 2015/8/7.
 *  @Documented 标记生成javadoc

　　@Inherited 标记继承关系

　　@Retention 注解的生存期

　　@Target 标注的目标
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface Person {
    String name();
    int age();
}
