package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;
import java.util.Set;

import com.google.common.collect.Sets;
import com.razor.dqa.annotation.InInt;
import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class InIntValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        
        InInt inInt = field.getAnnotation(InInt.class);
        Set<Integer> values = Sets.newHashSet();
        for (int i : inInt.value()) {
            values.add(i);
        }
        
        field.setAccessible(true);
        Object value = field.get(target);
        if (value != null) {
            if (values.contains((Integer) value)) {
                result.getAccuracy().getFormatCompliance().pass();
            } else {
                log.warn("@InInt校验失败：(" + value + ", " + values + ") [" + field.getName() + "] of " + target);
                result.getAccuracy().getFormatCompliance().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
            }
        }
        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(InInt.class);
    }

}
