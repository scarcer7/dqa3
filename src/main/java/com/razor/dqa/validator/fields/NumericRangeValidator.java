package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import java.math.BigDecimal;

import javax.validation.constraints.Size;

import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NumericRangeValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        
        Size size = field.getAnnotation(Size.class);
        
        field.setAccessible(true);
        Object value = field.get(target);
        if (value != null) {
            double v = 0.0d;
            if (value instanceof Integer) {
                v = ((Integer) value).doubleValue();
            } else if (value instanceof BigDecimal) {
                v = ((BigDecimal) value).doubleValue();
            }
            if (v <= size.max() && v >= size.min()) {
                result.getAccuracy().getFormatCompliance().pass();
            } else {
                log.warn("@Size校验失败：(" + value + ", " + size.min() + "," + size.max()+") [" + field.getName() + "] of " + target);
                result.getAccuracy().getFormatCompliance().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
            }
        }

        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(Size.class);
    }

}
