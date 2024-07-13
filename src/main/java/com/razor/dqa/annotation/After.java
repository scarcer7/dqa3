package com.razor.dqa.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface After {

    /**
     * 比较目标字段
     * @return
     */
    String fieldName();

    /**
     * 比较对象是否为参考表。
     * @return {@code true}，如果是参考表（即另一张表）；否则，{@code false}
     */
    boolean isRef() default false;

}
