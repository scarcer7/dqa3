package com.razor.dqa.validator.fields;

import java.lang.reflect.Field;

import javax.validation.constraints.NotNull;

import com.razor.dqa.model.AssessTarget;
import com.razor.dqa.validator.DqaResult;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class NotNullValidator implements FieldValidator {

    @Override
    public DqaResult validate(Field field, AssessTarget target, DqaResult result) throws IllegalArgumentException, IllegalAccessException {
        
        Object value = field.get(target);
        if (value == null) {
            log.warn("@NotNull校验失败：(" + value + ") [" + field.getName() + "] of " + target);
            result.getCompleteness().getElementCompleteness().fail(target.getClass().getSimpleName() + "." + field.getName(), value);
        } else {
            result.getCompleteness().getElementCompleteness().pass();
        }

        return result;
    }

    @Override
    public boolean shouldApply(Field field) {
        return field.isAnnotationPresent(NotNull.class);
    }

}
