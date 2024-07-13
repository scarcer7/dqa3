package com.razor.dqa.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;

import com.razor.dqa.annotation.type.Comparison;
import com.razor.dqa.annotation.type.NumericType;
import com.razor.dqa.annotation.type.Operator;

/**
 * 数字类型比较。
 * <p>
 * 可以指定当前字段与另一个字段{@link #fieldName()}进行比较。
 * 也可以指定与另外两个字段（{@link #fieldName()}以及{@link #secondFieldName()}）的运算结果进行比较。
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NumericCompareWith {

    /**
     * 
     * @return 比较对象字段
     */
    String fieldName();

    /**
     * 
     * @return 比较类型
     */
    Comparison comparison();

    /**
     * 
     * @return 是否复杂运算
     */
    boolean isOperation() default false;

    /**
     * 
     * @return 第二个字段，默认为空。当 {@link #isOperation()} 为 {@code true} 时必填。
     */
    String secondFieldName() default StringUtils.EMPTY;

    /**
     * 
     * @return 两个字段之间的运算符，默认为 {@link Operator#UNKNOWN}。当{@link #isOperation()} 为{@code true} 时，必须指定。
     */
    Operator operator() default Operator.UNKNOWN;

    /**
     * 
     * @return 数字类型。默认为{@link NumericType#INT}
     */
    NumericType numericType() default NumericType.INT;
}
