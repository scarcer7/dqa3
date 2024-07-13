package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import com.razor.dqa.annotation.NumericCompareWith;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

/**
 * 对两个字段进行数值比较
 */
@Slf4j
public class NumericCompareWithValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result)
            throws IllegalArgumentException, IllegalAccessException {
        
        NumericCompareWith annotation = field.getAnnotation(NumericCompareWith.class);
        double compareValue = getCompareTarget(field, target);
        field.setAccessible(true);
        double value = toDouble(field.get(target));
        if (annotation.comparison().pass(value, compareValue)) {
            result.getNormativity().getBusinessRule().pass();
        } else {
            log.warn("@NumericCompareWith校验失败：(" + value + ") [" + field.getName() + "] of " + target);
            result.getNormativity().getBusinessRule().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
        }

        return result;
    }

    private double getCompareTarget(Field field, AssessTarget target) {
        NumericCompareWith annotation = field.getAnnotation(NumericCompareWith.class);
        field.setAccessible(true);
        try {
            Field field1 = target.getClass().getDeclaredField(annotation.fieldName());
            field1.setAccessible(true);
            Object value1 = field1.get(target);
            // 如果不需要四则运算
            if (!annotation.isOperation()) return toDouble(value1);
            // 如果需要四则运算
            Field field2 = target.getClass().getDeclaredField(annotation.secondFieldName());
            field2.setAccessible(true);
            Object value2 = field2.get(target);
            return annotation.operator().op(toDouble(value1), toDouble(value2));

        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }

    }

    private double toDouble(Object o) {
        if (o instanceof Integer) return ((Integer) o).doubleValue();
        return Double.valueOf(String.valueOf(o)).doubleValue();
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(NumericCompareWith.class);
    }

}
